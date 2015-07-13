package com.web.util;

import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-13-20:23
 * @since v1.0
 */
@Component("ConverseUtil")
public class ConverseUtil {
    public int converse(Integer i){
        return i == null ? 0 : i.intValue();
    }
    public long converse(Long l){
        return l == null ? 0L : l.longValue();
    }
    public double converse(Double d){
        return d == null ? 0d : d.doubleValue();
    }
    public float converse(Float f){
        return f == null ? 0f : f.floatValue();
    }
    public short converse(Short s){
        return s == null ? 0 : s.shortValue();
    }
    public byte converse(Byte b){
        return b == null ? 0 : b.byteValue();
    }
    public boolean converse(Boolean b){
        return b == null ? false : b.booleanValue();
    }
}
