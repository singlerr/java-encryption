package com.github.singlerr.encrytion.asymmetric.rsa;

import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptor;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptorFactory;

public final class RSAEncryptorFactory implements AsymmetricEncryptorFactory {
    @Override
    public AsymmetricEncryptor create() {
        return new RSAEncryptor();
    }
}
