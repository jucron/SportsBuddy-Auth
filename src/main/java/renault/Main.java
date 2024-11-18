package renault;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import renault.properties.PropertiesLocator;
import renault.properties.ServerProperties;
import renault.properties.TokenProperties;
import renault.services.AuthServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting Server");

        //Initial configs
        Properties properties = new Properties();
        loadTokenProperties(properties);
        loadServerProperties(properties);


        // Create a gRPC server
        ServerProperties serverProperties = PropertiesLocator.getServerProperties();
        Server server = ServerBuilder.forPort(serverProperties.getPort())
                .addService(new AuthServiceImpl()) // Register the service implementation
                .build();

        System.out.printf("Server started on port %s",serverProperties.getPort());

        // Start the server
        server.start();

        // Wait for the server to shut down
        server.awaitTermination();
    }

    private static void loadServerProperties(Properties properties) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/dev.properties")) {
            // Load the properties file
            properties.load(fis);

            // Access properties
            String port = properties.getProperty("server.port");

            ServerProperties serverProperties = PropertiesLocator.getServerProperties();
            serverProperties.setPort(Integer.parseInt(port));

            log.info("INFO <Main>: Server properties loaded correctly");

        } catch (IOException e) {
            log.error("ERROR <Main>: Could not load Server properties");
            log.error(e.toString());
        }
    }

    private static void loadTokenProperties(Properties properties) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/dev.properties")) {
            // Load the properties file
            properties.load(fis);

            // Access properties
            String secret = properties.getProperty("token.secret");
            String expiration = properties.getProperty("token.expiration");

            TokenProperties tokenProperties = PropertiesLocator.getTokenProperties();
            tokenProperties.setSECRET_KEY(secret);
            tokenProperties.setTokenExpirationTime(Integer.parseInt(expiration));

            log.info("INFO <Main>: Token properties loaded correctly");

        } catch (IOException e) {
            log.error("ERROR <Main>: Could not load token properties");
            log.error(e.toString());
        }

    }
}