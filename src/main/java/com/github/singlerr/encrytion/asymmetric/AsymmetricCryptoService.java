package com.github.singlerr.encrytion.asymmetric;

import com.github.singlerr.encrytion.CryptoService;

public abstract class AsymmetricCryptoService implements CryptoService {

    protected final AsymmetricEncryptorFactory encryptorFactory;

    protected final AsymmetricEncryptor encryptor;

    protected final AsymmetricKeyStorage keyStorage;

    protected AsymmetricCryptoService(AsymmetricEncryptorFactory factory, AsymmetricKeyStorage storage) {
        this.encryptorFactory = factory;
        this.keyStorage = storage;
        this.encryptor = factory.create();
    }
}
