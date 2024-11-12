package renault.services;

import io.grpc.stub.StreamObserver;
import renault.proto.AuthServiceGrpc;
import renault.proto.AuthServiceProto;

public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {
    @Override
    public void validateToken(AuthServiceProto.TokenRequest request, StreamObserver<AuthServiceProto.TokenResponse> responseObserver) {
        System.out.println("validateToken API triggered");
        // Simulate the authentication logic
        String token = request.getToken();

        // Build the response
        AuthServiceProto.TokenResponse response = AuthServiceProto.TokenResponse.newBuilder()
                .setIsValid(TokenService.validateToken(token))
                .build();

        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
