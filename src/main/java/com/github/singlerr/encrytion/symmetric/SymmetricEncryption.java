package com.github.singlerr.encrytion.symmetric;

import com.github.singlerr.encrytion.CryptoService;

public interface SymmetricEncryption {

    void factory(SymmetricEncryptorFactory factory);

    void keyStorage(SymmetricKeyStorage keyStorage);

    CryptoService build();
}
