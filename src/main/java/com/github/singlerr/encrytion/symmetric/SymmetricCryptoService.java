package com.github.singlerr.encrytion.symmetric;

import com.github.singlerr.encrytion.CryptoService;

public abstract class SymmetricCryptoService implements CryptoService {

    protected final SymmetricEncryptorFactory encryptorFactory;

    protected final SymmetricEncryptor encryptor;

    protected final SymmetricKeyStorage keyStorage;

    protected SymmetricCryptoService(SymmetricEncryptorFactory factory, SymmetricKeyStorage storage) {
        this.encryptorFactory = factory;
        this.keyStorage = storage;
        this.encryptor = factory.create(storage);
    }

}
