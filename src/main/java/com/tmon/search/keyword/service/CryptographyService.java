package com.tmon.search.keyword.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptographyService {
    public String disestPasswordWithSeed(String password, String passwordSeed) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digestedBytes = messageDigest.digest((passwordSeed + password).getBytes());
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < digestedBytes.length; i++) {
            String hex = Integer.toHexString(0xff & digestedBytes[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
