package com.project.TaskListsAPI.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    public static String hash(String value)
    {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
        messageDigest.update(value.getBytes());
        return new String(messageDigest.digest());

    }
}
