package com.web.util.digest;

import java.security.NoSuchAlgorithmException;

/**
 * @author Jayson <br/>2015-10-28 14:26
 */
public class MessageDigest {
    public static byte[] encode(byte[] data , MDAlgorithm algorithm){
        java.security.MessageDigest md = null;
        try {
            md = java.security.MessageDigest.getInstance(algorithm.getAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md.digest(data);
    }
}
