package renault.services;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import renault.model.Credential;
import renault.protobuf.java.AuthServiceGrpc;
import renault.protobuf.java.AuthServiceProto;
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
            String encodedPassword = PasswordUtils.hashPassword(request.getCredential().getPassword());
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
                token = this.jwtService.generateToken(credential);
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
        super.introspect(request, responseObserver);
    }

    @Override
    public void expire(AuthServiceProto.ExpireRequest request, StreamObserver<AuthServiceProto.ExpireResponse> responseObserver) {
        super.expire(request, responseObserver);
    }
}

