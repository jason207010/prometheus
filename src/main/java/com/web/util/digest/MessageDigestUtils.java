package com.web.util.digest;

import org.apache.commons.codec.binary.Hex;

/**
 * @author Jayson <br/>2015-10-28 14:25
 */
public class MessageDigestUtils {
    public static byte[] md2(byte[] data){
        return MessageDigest.encode(data, MDAlgorithm.MD2);
    }

    public static String md2Hex(byte[] data){
        return Hex.encodeHexString(md2(data));
    }

    public static byte[] md5(byte[] data){
        return MessageDigest.encode(data, MDAlgorithm.MD5);
    }

    public static String md5Hex(byte[] data){
        return Hex.encodeHexString(md5(data));
    }

    public static byte[] sha1(byte[] data){
        return MessageDigest.encode(data, MDAlgorithm.SHA1);
    }

    public static String sha1Hex(byte[] data){
        return Hex.encodeHexString(sha1(data));
    }

    public static byte[] sha256(byte[] data){
        return MessageDigest.encode(data, MDAlgorithm.SHA256);
    }

    public static String sha256Hex(byte[] data){
        return Hex.encodeHexString(sha256(data));
    }
    
    public static byte[] sha384(byte[] data){
        return MessageDigest.encode(data, MDAlgorithm.SHA384);
    }

    public static String sha384Hex(byte[] data){
        return Hex.encodeHexString(sha384(data));
    }

    public static byte[] sha512(byte[] data){
        return MessageDigest.encode(data , MDAlgorithm.SHA512);
    }

    public static String sha512Hex(byte[] data){
        return Hex.encodeHexString(sha512(data));
    }
}
