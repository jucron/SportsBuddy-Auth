package renault.repositories;

public class RepositoryLocator {
    private static CredentialsRepository credentialsRepository;

    public static CredentialsRepository getCredentialsRepository() {
        if (credentialsRepository == null) {
            credentialsRepository = new CredentialsRepository();
        }
        return credentialsRepository;
    }
}
