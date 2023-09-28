package com.github.singlerr.encrytion.symmetric.aes256;

import com.github.singlerr.encrytion.symmetric.SymmetricEncryptor;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptorFactory;
import com.github.singlerr.encrytion.symmetric.SymmetricKeyStorage;

public final class AES256EncryptorFactory implements SymmetricEncryptorFactory {
    @Override
    public SymmetricEncryptor create(SymmetricKeyStorage keyStorage) {
        return new AES256Encryptor();
    }
}
