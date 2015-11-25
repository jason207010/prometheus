package com.web.util.digest;

import java.nio.charset.StandardCharsets;

/**
 * @author Jayson <br/>2015-10-27 16:05
 */
public class CRC32 {
    public static String CRC32Hex(String src){
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(src.getBytes(StandardCharsets.UTF_8));
        String string = Long.toHexString(crc32.getValue());
        return string;
    }
    public static long crc32(String src){
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(src.getBytes(StandardCharsets.UTF_8));
        return crc32.getValue();
    }
}
