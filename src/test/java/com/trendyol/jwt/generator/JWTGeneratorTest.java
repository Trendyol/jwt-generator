package com.trendyol.jwt.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

class JWTGeneratorTest {

    User user;
    String secret;
    Map<String, Object> header;

    private static Key getKeyForSecret(String secret) {
        byte[] bytes = secret.getBytes();
        byte[] decoded = Base64.getDecoder().decode(bytes);
        return Keys.hmacShaKeyFor(decoded);
    }

    @BeforeEach
    void setUp() {
        user = new User("John Doe", "johndoe@examplemail.com", 35);
        secret = "525m3A6LOmrkgvHF6qxFOxJESI4lfZQsQrbu4YXUAF5";
        header = new HashMap<>();
        header.put("typ", "JWT");
    }

    @Test
    void testGetJWTUsingMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> body = objectMapper.convertValue(user, HashMap.class);

        String jwtString = JWTGenerator.getJWT(secret, header, body);

        testGetJWT(jwtString);
    }

    @Test
    void testGetJWTUsingObject() {
        String jwtString = JWTGenerator.getJWT(secret, header, user);

        testGetJWT(jwtString);
    }

    private void testGetJWT(String jwtString) {
        Key key = getKeyForSecret(secret);

        JwtParser jwtParser = Jwts.parser().setSigningKey(key);
        Jwt<Header, Claims> jwt = jwtParser.parse(jwtString);

        Header header = jwt.getHeader();
        Assertions.assertEquals("HS256", header.get("alg"));
        Assertions.assertEquals("JWT", header.getType());

        Claims claims = jwt.getBody();
        Assertions.assertEquals(user.getName(), claims.get("name", String.class));
        Assertions.assertEquals(user.getEmail(), claims.get("email", String.class));
        Assertions.assertEquals(user.getAge(), claims.get("age", Integer.class));
    }

    private class User {
        private String name;
        private String email;
        private int age;

        public User(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}