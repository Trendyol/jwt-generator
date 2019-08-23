public class Main {
    public static void main(String[] args) {
        String jwt = JWTGenerator.getJWT("testSecrettestSecrettestSecrettestSecrettestSecret", "testUserName@testEmail.com", "12345678", "testUserName@testEmail.com");
        System.out.println(jwt);
    }
}
