package com.example.nonauthsecapp.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtils {
    public static String hash(String password, String salt) {
//        https://www.baeldung.com/sha-256-hashing-java
        return DigestUtils.sha256Hex(password + salt);
    }

    public static String hashPass(String pass) {
        return DigestUtils.sha256Hex(pass);
    }
}
