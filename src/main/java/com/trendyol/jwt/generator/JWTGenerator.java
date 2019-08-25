package com.trendyol.jwt.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JWTGenerator {
    private JWTGenerator() {

    }

    public static String getJWT(String secret, Map<String, Object> header, Map<String, Object> body) {
        byte[] bytes = secret.getBytes();
        byte[] decoded = Base64.getDecoder().decode(bytes);
        Key key = Keys.hmacShaKeyFor(decoded);

        return Jwts.builder()
                .setHeaderParams(header)
                .setHeaderParam("typ", "JWT")
                .addClaims(body)
                .signWith(key)
                .compact();
    }

    public static String getJWT(String secret, Map<String, Object> header, Object body) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> bodyMap = objectMapper.convertValue(body, HashMap.class);

        return getJWT(secret, header, bodyMap);
    }
}
