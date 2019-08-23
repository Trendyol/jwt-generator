import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JWTGenerator {
    public static String getJWT(String secret, String subject, String userId, String userEmail) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        String jwt = Jwts.builder()
                .setSubject(subject)
                .claim("userId", userId)
                .claim("email", userEmail)
                .signWith(key)
                .compact();

        return jwt;
    }
}
