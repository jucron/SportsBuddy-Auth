package renault.properties;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
public class TokenProperties {

    private String SECRET_KEY;
    private int tokenExpirationTime;

}
