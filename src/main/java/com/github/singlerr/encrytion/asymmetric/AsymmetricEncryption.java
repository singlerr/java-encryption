package com.github.singlerr.encrytion.asymmetric;

import com.github.singlerr.encrytion.CryptoService;

public interface AsymmetricEncryption {

    void factory(AsymmetricEncryptorFactory factory);

    void keyStorage(AsymmetricKeyStorage keyStorage);

    CryptoService build();
}
