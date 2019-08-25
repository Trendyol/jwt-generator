package com.trendyol.jwt.example;

import com.trendyol.jwt.generator.JWTGenerator;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class GenerateJWTExampleUsingObject {
    static final Logger logger = Logger.getLogger(GenerateJWTExampleUsingObject.class);

    public static void main(String[] args) {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");

        User userForBody = new User("John Doe", "johndoe@examplemail.com", 42);

        String jwt = JWTGenerator.getJWT("525m3A6LOmrkgvHF6qxFOxJESI4lfZQsQrbu4YXUAF5", header, userForBody);
        logger.debug(jwt);
    }
}

class User {
    private String name;
    private String email;
    private int age;

    User(String name, String email, int age) {
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
