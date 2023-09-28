package com.github.singlerr.encrytion.service;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryption;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyGenerator;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyStorage;

public class AsymmetricCryptoServiceBuilder extends CryptoServiceBuilder {

    private AsymmetricKeyGenerator keyGenerator;

    private final AsymmetricEncryption encryption;

    public AsymmetricCryptoServiceBuilder(AsymmetricEncryption encryptionType) {
        this.encryption = encryptionType;
    }

    public AsymmetricCryptoServiceBuilder encryptorFactory(AsymmetricEncryptorFactory factory) {
        this.encryption.factory(factory);
        return this;
    }

    public AsymmetricCryptoServiceBuilder keyGenerator(AsymmetricKeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
        return this;
    }

    @Override
    public CryptoService build() throws Exception {

        this.encryption.keyStorage(new AsymmetricKeyStorage(keyGenerator.generate()));

        return this.encryption.build();
    }
}
