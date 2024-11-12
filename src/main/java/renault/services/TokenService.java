package renault.services;

import io.grpc.ManagedChannelBuilder;

import java.util.Objects;

public class TokenService {
    public static boolean validateToken(String token) {
        // Simulate the token validation logic
        System.out.println("TokenService triggered with token: "+token);

        return Objects.equals(token, "123");
    }
}
