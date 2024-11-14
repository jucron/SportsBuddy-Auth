package renault.repositories;

import lombok.extern.slf4j.Slf4j;
import renault.model.Credential;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CredentialsRepository {

    private final List<Credential> mockCredentialsRepository;

    public CredentialsRepository() {
        this.mockCredentialsRepository = new ArrayList<>();
    }

    public Optional<Credential> findByUsername(String username) {
        log.info("CredentialsRepository findByUsername with username: {}", username);
        return mockCredentialsRepository.stream()
                .filter(credential -> credential.getUsername().equals(username))
                .findFirst();
    }

    public void save(Credential credential) {
        mockCredentialsRepository.add(new Credential(credential.getUsername(), credential.getPassword()));
    }
}
