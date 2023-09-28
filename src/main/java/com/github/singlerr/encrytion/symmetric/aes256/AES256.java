package com.github.singlerr.encrytion.symmetric.aes256;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryption;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptorFactory;
import com.github.singlerr.encrytion.symmetric.SymmetricKeyStorage;

public final class AES256 implements SymmetricEncryption {

    private SymmetricEncryptorFactory factory;

    private SymmetricKeyStorage keyStorage;

    @Override
    public void factory(SymmetricEncryptorFactory factory) {
        this.factory = factory;
    }

    @Override
    public void keyStorage(SymmetricKeyStorage keyStorage) {
        this.keyStorage = keyStorage;
    }

    @Override
    public CryptoService build() {
        return new AES256CryptoService(factory, keyStorage);
    }
}
