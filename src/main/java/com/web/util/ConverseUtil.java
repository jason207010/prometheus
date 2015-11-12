package com.web.util;

/**
 * @author jayson   2015-07-13-20:23
 * @since v1.0
 */
public final class ConverseUtil {
    public static int converseInt(Integer i){
        return i == null ? 0 : i.intValue();
    }
    public static int converseInt(String s){
        return Integer.valueOf(s).intValue();
    }
    public static long converseLong(Long l){
        return l == null ? 0L : l.longValue();
    }
    public static long converseLong(String s){
        return Long.valueOf(s).longValue();
    }
    public static double converseDouble(Double d){
        return d == null ? 0d : d.doubleValue();
    }
    public static double converseDouble(String s){
        return Double.valueOf(s).doubleValue();
    }
    public static float converseFloat(Float f){
        return f == null ? 0f : f.floatValue();
    }
    public static float converseFloat(String s){
        return Float.valueOf(s).floatValue();
    }
    public static short converseShort(Short s){
        return s == null ? 0 : s.shortValue();
    }
    public static short converseShort(String s){
        return Short.valueOf(s).shortValue();
    }
    public static byte converseByte(Byte b){
        return b == null ? 0 : b.byteValue();
    }
    public static byte converseByte(String s){
        return Byte.valueOf(s).byteValue();
    }
    public static boolean converseBoolean(Boolean b){
        return b == null ? false : b.booleanValue();
    }
    public static boolean converseBoolean(String s){
        return Boolean.valueOf(s).booleanValue();
    }
}
