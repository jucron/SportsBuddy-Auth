package renault.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;
import renault.properties.TokenProperties;
import renault.model.Credential;

@Slf4j
@RequiredArgsConstructor
public class JwtService {

    /** JSON Web Token:
     JWT contains Claims and are transferred between two parties
     Claims in JWT are encoded as JSON object that is digitally signed using a Json Web Signature
     JWT consists in 3 parts: Header, Payload and Signature
     > Header: Type of token and algorithm (ex sh-256 etc.)
     > Payload: Contain the Claims - statements about an Entity (typically the User and other Data)
     > types of Claims:
     +registered - predefined, recommended but not mandatory
     = provide a set of useful, repeatable claims
     = ex: ISS (issuer), subject, expiration time, etc.
     +public - defined within the IA and JWT registry or Public by nature
     +private - custom Claims created to share private information between parties
     > Signature - Two goals:
     = verify the Sender of the JWToken
     = ensure that the message wasn't changed along the way
     */

    /** Secret-Key:
     Encrypt data from: https://generate-random.org/encryption-key-generator
     */

    private final TokenProperties tokenProperties = new TokenProperties();
    public static Set<String> blackListTokens = new HashSet<>();

    public String extractUsername(String jwtToken) {
        //Subject of this Claim should be the username
        return extractClaim(jwtToken, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        //Generic method in order to be easy to extract any type of Claim
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken (Map<String, Object> extraClaims, Credential credential) {
        return Jwts.builder()
                .claims(extraClaims)
                .issuer(tokenProperties.getIssuer())
                .subject(credential.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + tokenProperties.getTokenExpirationTime()))
//                .signWith(getSignInKey(),SignatureAlgorithm.ES256)
                .signWith(getSignInKey())
                .compact();
    }
    public String generateToken (Credential credential) {
        return generateToken(new HashMap<>(),credential);
    }

    public boolean isTokenValid(String token) {
        //Checks if the token belongs to any user, have been issued by this server, is not expired and is not part of the BlackList
        if (extractUsername(token) != null) {
            if (extractIssuer(token).equals(tokenProperties.getIssuer())) {
                if (!isTokenExpired(token)) {
                    return !this.isTokenInBlackList(token);
                }
            }
        }
        return false;
    }

    public void addTokenToBlackList(String token) {
        getBlackListTokens().add(token);
        log.info("INFO <JwtServiceImpl>: new token added to blacklist, with now size of {}", getBlackListTokens().size());
    }

    private boolean isTokenInBlackList(String token) {
        return getBlackListTokens().contains(token);
    }

    private Set<String> getBlackListTokens() {
        if (blackListTokens == null) {
            blackListTokens = new HashSet<>();
        }
        return blackListTokens;
    }

    private boolean isTokenExpired(String token) {
        //Checks if Token issue date is before today
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenOnRenewalRange(String token) {
        //checks if expirationDate have less half of the expiration time to expire
        Date expirationDate = extractExpiration(token);
        Date currentDate = new Date();
        long timeDifference = expirationDate.getTime() - currentDate.getTime();
        long halfExpirationTime = tokenProperties.getTokenExpirationTime() / 2;
        return timeDifference <= halfExpirationTime;
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    private String extractIssuer(String token) {
        return extractClaim(token,Claims::getIssuer);
    }

    private Claims extractAllClaims(String jwtToken) {
        //Will interpret jwtToken and extract payload containing all Claims
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(tokenProperties.getSECRET_KEY());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
