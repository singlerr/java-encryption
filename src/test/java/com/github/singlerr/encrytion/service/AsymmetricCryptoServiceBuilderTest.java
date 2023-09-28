package com.github.singlerr.encrytion.service;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.asymmetric.rsa.RSA;
import com.github.singlerr.encrytion.asymmetric.rsa.RSAEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.rsa.RSAKeyGenerator;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class AsymmetricCryptoServiceBuilderTest {

    @Test
    void build() throws Exception {
        CryptoService service = new AsymmetricCryptoServiceBuilder(new RSA())
                .keyGenerator(new RSAKeyGenerator())
                .encryptorFactory(new RSAEncryptorFactory())
                .build();
    }
}