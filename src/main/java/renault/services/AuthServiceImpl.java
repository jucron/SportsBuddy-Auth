package renault.services;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import renault.model.Credential;
import renault.protobuf.AuthServiceGrpc;
import renault.protobuf.AuthServiceProto;
import renault.repositories.CredentialsRepository;
import renault.repositories.RepositoryLocator;
import renault.utils.PasswordUtils;

import java.util.Optional;

@Slf4j
public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {

    private final CredentialsRepository credentialsRepository = RepositoryLocator.getCredentialsRepository();
    private final JwtService jwtService = new JwtService();

    @Override
    public void register(AuthServiceProto.RegisterRequest request, StreamObserver<AuthServiceProto.RegisterResponse> responseObserver) {
        boolean isOk;
        String status;
        //check if username already exists
        boolean isUsernamePresent = credentialsRepository.findByUsername(request.getCredential().getUsername()).isPresent();
        if (isUsernamePresent) {
            log.info("INFO<AuthService>: username {{}} already in DB, refusing registration.", request.getCredential().getUsername());
            isOk = false;
            status = "Username already taken";
        } else {
            log.info("INFO<AuthService>: username {{}} not in DB, registering.", request.getCredential().getUsername());
            //if username not taken, make registry in repository
            String username = request.getCredential().getUsername();
            String pass = request.getCredential().getPassword();
            String encodedPassword = PasswordUtils.hashPassword(pass);
            Credential credential = new Credential()
                    .withUsername(username)
                    .withPassword(encodedPassword);
            credentialsRepository.save(credential);
            isOk = true;
            status = "Registration successful";
        }
        // Build the response
        AuthServiceProto.RegisterResponse response = AuthServiceProto.RegisterResponse.newBuilder()
                .setStatus(status)
                .setIsOk(isOk)
                .build();
        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void authenticate(AuthServiceProto.AuthenticateRequest request, StreamObserver<AuthServiceProto.AuthenticateResponse> responseObserver) {
        String status;
        String token;
        //fetch Account
        Optional<Credential> credentialOptional = credentialsRepository.findByUsername(request.getCredential().getUsername());
        if (credentialOptional.isPresent()) {
            Credential credential = credentialOptional.get();
            //proceed authentication
            if (PasswordUtils.verifyPassword(request.getCredential().getPassword(), credential.getPassword())) {
                status = "Auth successful";
                String newToken = this.jwtService.generateToken(credential);
                log.info("INFO<AuthService>: new token generated for user {{}}, token is: \n{}", request.getCredential().getUsername(),newToken);
                token = newToken;
            } else {
                status = "Wrong password";
                token = "N/A";
            }

        } else {
            status = "Username not found";
            token = "N/A";
        }

        // Build the response
        AuthServiceProto.AuthenticateResponse response = AuthServiceProto.AuthenticateResponse.newBuilder()
                .setStatus(status)
                .setToken(token)
                .build();
        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void introspect(AuthServiceProto.IntrospectRequest request, StreamObserver<AuthServiceProto.IntrospectResponse> responseObserver) {
        String status;
        String token;

        Optional<Credential> credentialOptional = credentialsRepository.findByUsername(jwtService.extractUsername(request.getToken()));
        if (credentialOptional.isPresent()) {
            if (jwtService.isTokenValid(request.getToken())) {
                status = "Token is valid";
                token = request.getToken();
                if (jwtService.isTokenOnRenewalRange(request.getToken())) {
                    status = "Token is renewed";
                    token = jwtService.generateToken(credentialOptional.get());
                }
            } else {
                status = "Token is not valid";
                token = "";
            }
        } else {
            status = "Token with unknown Username";
            token = "";
        }

        // Build the response
        AuthServiceProto.IntrospectResponse response = AuthServiceProto.IntrospectResponse.newBuilder()
                .setStatus(status)
                .setToken(token)
                .build();
        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void expire(AuthServiceProto.ExpireRequest request, StreamObserver<AuthServiceProto.ExpireResponse> responseObserver) {
        String status;
        boolean isOk;

        if (jwtService.isTokenValid(request.getToken())) {
            jwtService.addTokenToBlackList(request.getToken());
            status = "Token added to blacklist";
            isOk = true;
        } else {
            status = "Token is not valid";
            isOk = false;
        }
        // Build the response
        AuthServiceProto.ExpireResponse response = AuthServiceProto.ExpireResponse.newBuilder()
                .setStatus(status)
                .setIsOk(isOk)
                .build();
        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

