package com.github.singlerr.encrytion.symmetric;

public interface SymmetricEncryptorFactory {

    SymmetricEncryptor create(SymmetricKeyStorage keyStorage);

}
