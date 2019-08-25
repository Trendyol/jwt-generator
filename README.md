# JWT-Generator

## Description
This repository contains a JWT generator using [JJWT](https://github.com/jwtk/jjwt).

## Usage
In order to use the generator, a secret and a body must be provided, several fields for header can be also be provided.

In order to provide fields for header, you must create a Map<String, Object> that contains the fields you want. If there is no fields you want to add to header section of the JWT, you can assign null to the header.

In order to provide a body, you can either provide an ```Object``` that contains fields which you want in the body, or you can create a ```Map<String, Object>```.

Once you get a secret, header and a body, you can call:
```java
String jwt = JWTGenerator.getJWT(secret, header, body);
```
By doing this, you should have obtained JWT successfully.

## Examples
In order to see example codes, go to [```src/main/java/com/trendyol/jwt/example```](src/main/java/com/trendyol/jwt/example) directory.
