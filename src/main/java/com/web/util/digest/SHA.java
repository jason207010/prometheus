package com.web.util.digest;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Jayson <br/>2015-10-23 16:42
 */
public class SHA {
    public static String sha1Hex(String src){
        return DigestUtils.sha1Hex(src);
    }

    public static String sha256Hex(String src){
        return DigestUtils.sha256Hex(src);
    }

    public static String sha384Hex(String src){
        return DigestUtils.sha384Hex(src);
    }

    public static String sha512Hex(String src){
        return DigestUtils.sha512Hex(src);
    }
}
