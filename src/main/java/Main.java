import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class Main {
    public static void main(String[] args) {
        String jwt = JWTGenerater.getJWT("testSecrettestSecrettestSecrettestSecrettestSecret", "testUserName@testEmail.com", "12345678", "testUserName@testEmail.com");
        System.out.println(jwt);
    }
}
