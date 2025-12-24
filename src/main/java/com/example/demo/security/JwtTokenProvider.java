@Component
public class JwtTokenProvider {

    private final String secret = "secret";

    public String generateToken(Authentication auth, Long id, String role) {
        return id + ":" + role;
    }

    public String getUsernameFromToken(String token) {
        return token.split(":")[0];
    }
}
