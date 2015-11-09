package com.web.util;

import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-13-20:23
 * @since v1.0
 */
@Component("ConverseUtil")
public class ConverseUtil {
    public int converseInt(Integer i){
        return i == null ? 0 : i.intValue();
    }
    public int converseInt(String s){
        return Integer.valueOf(s).intValue();
    }
    public long converseLong(Long l){
        return l == null ? 0L : l.longValue();
    }
    public long converseLong(String s){
        return Long.valueOf(s).longValue();
    }
    public double converseDouble(Double d){
        return d == null ? 0d : d.doubleValue();
    }
    public double converseDouble(String s){
        return Double.valueOf(s).doubleValue();
    }
    public float converseFloat(Float f){
        return f == null ? 0f : f.floatValue();
    }
    public float converseFloat(String s){
        return Float.valueOf(s).floatValue();
    }
    public short converseShort(Short s){
        return s == null ? 0 : s.shortValue();
    }
    public short converseShort(String s){
        return Short.valueOf(s).shortValue();
    }
    public byte converseByte(Byte b){
        return b == null ? 0 : b.byteValue();
    }
    public byte converseByte(String s){
        return Byte.valueOf(s).byteValue();
    }
    public boolean converseBoolean(Boolean b){
        return b == null ? false : b.booleanValue();
    }
    public boolean converseBoolean(String s){
        return Boolean.valueOf(s).booleanValue();
    }
}
