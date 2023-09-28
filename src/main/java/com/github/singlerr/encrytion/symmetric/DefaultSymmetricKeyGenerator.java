package com.github.singlerr.encrytion.symmetric;

import java.security.SecureRandom;

public final class DefaultSymmetricKeyGenerator implements SymmetricKeyGenerator {

    @Override
    public byte[] generate() {
        byte[] key = new byte[2048];
        new SecureRandom().nextBytes(key);

        return key;
    }
}
