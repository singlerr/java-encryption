package com.github.singlerr.encrytion.asymmetric.rsa;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryption;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyStorage;

public final class RSA implements AsymmetricEncryption {

    private AsymmetricEncryptorFactory factory;

    private AsymmetricKeyStorage keyStorage;

    @Override
    public void factory(AsymmetricEncryptorFactory factory) {
        this.factory = factory;
    }

    @Override
    public void keyStorage(AsymmetricKeyStorage keyStorage) {
        this.keyStorage = keyStorage;
    }

    @Override
    public CryptoService build() {
        return new RSACryptoService(factory, keyStorage);
    }
}
