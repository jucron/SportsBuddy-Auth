package renault;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import renault.services.AuthServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting Server");
        // Create a gRPC server
        Server server = ServerBuilder.forPort(9090)
                .addService(new AuthServiceImpl()) // Register the service implementation
                .build();

        System.out.println("Server started on port 9090");

        // Start the server
        server.start();

        // Wait for the server to shut down
        server.awaitTermination();
    }
}