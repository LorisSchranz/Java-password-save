// Doesn't work yet

/*
package ch.bbw.lskf.PasswordManager.Controllers;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

*/
/*The Controller of the application*//*

class PasswordController {

//TODO: Hash Function, Save Function, Load Function,

    //Private Key
    static String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
            "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALM7/9udLrFXIdm4\n" +
            "cXcdwTNVlFUgOTtp8mdd3tXZy7gOe3VU9iVgYQJNmw/0+3NogLloTmWVY/G0lXG7\n" +
            "NtOsrqkf/KQsmZNL7b9qFOZMtgXjJz6jsFVpfft+1FNhQdmf7XgjzGHKg82uLps5\n" +
            "MZ94k7xv5jEzbve24vWGUsN0ETmpAgMBAAECgYBJqSDv6ttjusGIrwrCv5HFPSin\n" +
            "C4U568LZxHRuQwI8dIc8o1w95Cw6PBa8KhylQ4+To1CE4y6eCW9ZvG099TwaSJhr\n" +
            "DB7y3r/UVsf5AWL316Ex/wG9AvqyvKG/xcqx3dqPzvHP2vfq1sA6/1VEkD1eSAdb\n" +
            "f0WNEBbETjNdN8x82QJBAO6i1uZs3m6k5XuO3OZQFmpA9gR+V6kZmhb57056lvYk\n" +
            "cylHqFjFGpXzHS2Hc/9xjSEDtsYXqQouQ9pysmzQJ9sCQQDARqmqEbkC5chmNDjf\n" +
            "ZLnl48cqbEFEJjQOOBDHRLnUAEh3fXSHGDxf2YoGkVNSVf/ipf6mlmV9R2eyTbfr\n" +
            "io3LAkEAzdbka2opC2NtFwEKBhe63fgevY2Fa7VLttnr09Pmd3bFZywKSFfsML+9\n" +
            "wVH/eq2lwH6Fn6U1CDUUDk+1HCsI1QJBAJbJE5cGzQNjtjPIcm1mbY7GgVNYkBpk\n" +
            "p2AbQbUzxVNnYW0rmm2zaO12CRM7do9UWBajPL/ho/eKPt0Kq9hw0N8CQEz2wDTs\n" +
            "qcP256yQfkKLR/6vzcFUqQLmW3pgV8NUOs+DfcD/2uMUI3Mxr9oWnEuVb8hMHqy5\n" +
            "Dr1SFcZ8lavkP8M=\n" +
            "-----END PRIVATE KEY-----";

    //Public Key
    static String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzO//bnS6xVyHZuHF3HcEzVZRV\n" +
            "IDk7afJnXd7V2cu4Dnt1VPYlYGECTZsP9PtzaIC5aE5llWPxtJVxuzbTrK6pH/yk\n" +
            "LJmTS+2/ahTmTLYF4yc+o7BVaX37ftRTYUHZn+14I8xhyoPNri6bOTGfeJO8b+Yx\n" +
            "M273tuL1hlLDdBE5qQIDAQAB\n" +
            "-----END PUBLIC KEY-----";


    //ToDo: Replace with Save in DB/Load encrypted texts from DB function
    String encryptedText = encrypt("Password", publicKey);

    private static String encrypt(String text, String publicKey) {
        try {
            RSAPublicKey publicKey1 = getPublicKeyFromString(publicKey);

            return encrypt(text, publicKey1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static RSAPublicKey getPublicKeyFromString(String key) throws IOException, GeneralSecurityException {
        String publicKeyPEM = key;

        // Remove the first and last lines
        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----n", "");
        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");

        // Base64 decode data
        byte[] encoded = Base64.decodeBase64(publicKeyPEM);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(encoded));
        return pubKey;
    }

    public static RSAPrivateKey getPrivateKeyFromString(String key) throws IOException, GeneralSecurityException {
        String privateKeyPEM = key;

        // Remove the first and last lines
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----n", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");

        // Base64 decode data
        byte[] encoded = Base64.decodeBase64(privateKeyPEM);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
        return privKey;
    }

    public static String decrypt(String text, String privateKey) {

        try {
            RSAPrivateKey privateKey1 = getPrivateKeyFromString(privateKey);
            String signKey = RSAHelper.sign(RSAHelper.getPrivateKeyFromString(privateKey), text);

            if (RSAHelper.verify(RSAHelper.getPublicKeyFromString(publicKey), text, signKey)) {
                return RSAHelper.decrypt(text, privateKey1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return null;
    }
}
//Don't work because no file reader
////Function to write the data encrypted in DB
//public static String writeInDB(Password password){
//    //only encrypt if not empty
//    if(password != null || password != ''){
//        encrypt(password, publicKey);
//    }
//
//}
////Function to read data out of DB and decrypt it
//public static readFromDB(String encryptedText){
//    //getting a list from the passwords
//    for(passwords : passwordList){
//        decrypt(this.password, publicKey)
//    }
//}


*/
