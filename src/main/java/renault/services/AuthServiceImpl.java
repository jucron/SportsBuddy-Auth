package renault.services;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import renault.model.Credential;
import renault.protobuf.java.AuthServiceGrpc;
import renault.protobuf.java.AuthServiceProto;
import renault.repositories.CredentialsRepository;
import renault.repositories.RepositoryLocator;

@Slf4j
public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {

    private final CredentialsRepository credentialsRepository = RepositoryLocator.getCredentialsRepository();

    @Override
    public void register(AuthServiceProto.RegisterRequest request, StreamObserver<AuthServiceProto.RegisterResponse> responseObserver) {
        boolean isOk;
        //check if username already exists
        boolean isUsernamePresent = credentialsRepository.findByUsername(request.getCredential().getUsername()).isPresent();
        if (isUsernamePresent) {
            log.info("INFO<AuthService>: username {{}} already in DB, refusing registration.", request.getCredential().getUsername());
            isOk = false;
        } else {
            log.info("INFO<AuthService>: username {{}} not in DB, registering.", request.getCredential().getUsername());
            //if username not taken, make registry in repository
            Credential credential = new Credential(request.getCredential().getUsername(), request.getCredential().getPassword());
            credentialsRepository.save(credential);
            isOk = true;
        }
        // Build the response
        AuthServiceProto.RegisterResponse response = AuthServiceProto.RegisterResponse.newBuilder()
                .setIsOk(isOk)
                .build();
        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }



    @Override
    public void authenticate(AuthServiceProto.AuthenticateRequest request, StreamObserver<AuthServiceProto.AuthenticateResponse> responseObserver) {
        super.authenticate(request, responseObserver);
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

//    @Override
//    public void validateToken(AuthServiceProto request, StreamObserver<AuthServiceProto.TokenResponse> responseObserver) {
//        System.out.println("validateToken API triggered");
//        // Simulate the authentication logic
//        String token = request.getToken();
//
//        // Build the response
//        AuthServiceProto.TokenResponse response = AuthServiceProto.TokenResponse.newBuilder()
//                .setIsValid(TokenService.validateToken(token))
//                .build();
//
//        // Send the response to the client
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//    public void register(AuthServiceProto.Re credential) {
//

//}

