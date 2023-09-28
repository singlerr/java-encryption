package com.github.singlerr.encrytion;

public enum KeyAlgorithm {

    AES_256("AES/CBC/PKCS5Padding");

    private final String algorithm;

    KeyAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
