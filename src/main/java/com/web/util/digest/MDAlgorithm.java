package com.web.util.digest;

/**
 * @author Jayson <br/>2015-10-28 14:27
 */
public enum MDAlgorithm {
    MD2("MD2"),
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA384("SHA-384"),
    SHA512("SHA-512")
    ;
    private String algorithm;

    MDAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
