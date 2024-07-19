package com.camel.camel_tcp;

import java.io.FileInputStream;
import java.security.*;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class EncryptionExample {

    public static void main(String[] args) throws Exception {
        
        // Load Bouncy Castle provider
        Security.addProvider(new BouncyCastleProvider());

        // Load keystore and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("mykeystore.jks"), "keystore_password".toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("mytruststore.jks"), "truststore_password".toCharArray());

        // Retrieve private and public keys from keystore
        PrivateKey privateKey = (PrivateKey) keyStore.getKey("mykey", "key_password".toCharArray());
        PublicKey publicKey = trustStore.getCertificate("mykey").getPublicKey();

        // Encrypt data using public key
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = cipher.doFinal("Hello, world!".getBytes());

        // Decrypt data using private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        String decryptedString = new String(decryptedData);

        System.out.println("Original string: Hello, world!");
        System.out.println("Encrypted data: " + new String(encryptedData));
        System.out.println("Decrypted string: " + decryptedString);
    }
}