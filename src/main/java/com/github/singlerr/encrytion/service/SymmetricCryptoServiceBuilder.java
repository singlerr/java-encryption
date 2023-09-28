package com.github.singlerr.encrytion.service;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.symmetric.*;

public class SymmetricCryptoServiceBuilder extends CryptoServiceBuilder {

    private SymmetricKeyGenerator keyGenerator;

    private final SymmetricEncryption encryption;

    public SymmetricCryptoServiceBuilder(SymmetricEncryption encryptionType) {
        this.keyGenerator = new DefaultSymmetricKeyGenerator();
        this.encryption = encryptionType;
    }

    public SymmetricCryptoServiceBuilder encryptorFactory(SymmetricEncryptorFactory factory) {
        this.encryption.factory(factory);
        return this;
    }

    public SymmetricCryptoServiceBuilder keyGenerator(SymmetricKeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
        return this;
    }

    @Override
    public CryptoService build() {

        this.encryption.keyStorage(new SymmetricKeyStorage(keyGenerator.generate()));

        return this.encryption.build();
    }
}
