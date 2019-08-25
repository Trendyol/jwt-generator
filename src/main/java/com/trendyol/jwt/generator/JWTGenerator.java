package com.trendyol.jwt.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * JWTGenerator can be used to generate JWTs.
 */
public class JWTGenerator {
    private JWTGenerator() {

    }

    /**
     * Generates a JWT based on secret, header and body.
     *
     * @param secret The secret for the JWT.
     * @param header the fields to be added to the header section of the JWT. If there is no header fields to be
     *               specified,
     *               this field can be null.
     * @param body   Body field of the JWT using Map with (String, Object) pairs.
     * @return Generated JWT.
     */
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

    /**
     * Generates a JWT based on secret, header and body.
     * The generated JWT's body contains all the fields of the body.
     *
     * @param secret The secret for the JWT.
     * @param header the fields to be added to the header section of the JWT. If there is no header fields to be
     *               specified,
     *               this field can be null.
     * @param body   Body field of the JWT using an object.
     * @return Generated JWT.
     */
    public static String getJWT(String secret, Map<String, Object> header, Object body) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> bodyMap = objectMapper.convertValue(body, HashMap.class);

        return getJWT(secret, header, bodyMap);
    }
}
