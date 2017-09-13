/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
 
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Kyota Watanabe
 */
public class Hash {
    public static final int strechCount = 10000;
    public static final int keyLength = 256;
    public static final String cryptoAlgorithm = "PBKDF2WithHmacSHA256";
    
    
    public static byte[] hash256(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        messageDigest.update(str.getBytes());
        return messageDigest.digest();
    }
    
    public static String encrypt(String plain, String salt) {
        SecretKeyFactory skf;
        try {
            skf = SecretKeyFactory.getInstance(cryptoAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
        char[] buff = plain.toCharArray();
        byte[] saltBuff = hash256(salt);
        PBEKeySpec keySpec = new PBEKeySpec(buff, saltBuff, strechCount, keyLength);
        
        SecretKey secretKey;
        try {
            secretKey = skf.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        
        byte[] encoded = secretKey.getEncoded();

        StringBuilder sb = new StringBuilder(64);
        for (byte b : encoded) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
