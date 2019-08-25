package com.trendyol.jwt.example;

import com.trendyol.jwt.generator.JWTGenerator;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class GenerateJWTExampleUsingMap {
    static final Logger logger = Logger.getLogger(GenerateJWTExampleUsingMap.class);

    public static void main(String[] args) {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");

        Map<String, Object> body = new HashMap<>();
        body.put("name","John Doe");
        body.put("email", "johndoe@examplemail.com");
        body.put("age", 42);

        String jwt = JWTGenerator.getJWT("525m3A6LOmrkgvHF6qxFOxJESI4lfZQsQrbu4YXUAF5", null, body);
        logger.debug(jwt);
    }
}
