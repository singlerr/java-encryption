package com.github.singlerr.encrytion.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DefaultAsymmetricKeyGenerator implements AsymmetricKeyGenerator {

    private final String algo;

    public DefaultAsymmetricKeyGenerator(String algo) {
        this.algo = algo;
    }

    @Override
    public KeyPair generate() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algo);
        keyPairGenerator.initialize(2048, secureRandom);

        return keyPairGenerator.genKeyPair();
    }
}
