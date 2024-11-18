package renault.properties;

import io.grpc.Server;

public class PropertiesLocator {
    private static TokenProperties tokenProperties;
    private static ServerProperties serverProperties;

    public static TokenProperties getTokenProperties() {
        if (tokenProperties == null) {
            tokenProperties = new TokenProperties();
        }
        return tokenProperties;
    }

    public static ServerProperties getServerProperties() {
        if (serverProperties == null) {
            serverProperties = new ServerProperties();
        }
        return serverProperties;
    }

}
