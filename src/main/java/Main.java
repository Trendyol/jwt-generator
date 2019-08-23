import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class Main {
    public static void main(String[] args) {
        String secret = "testSecrettestSecrettestSecrettestSecrettestSecret";
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        String jwt = Jwts.builder()
                .setSubject("testUserName@testEmail.com")
                .claim("userId", "12345678")
                .claim("email", "testUserName@testEmail.com")
                .signWith(key)
                .compact();

        System.out.println(jwt);
    }
}
