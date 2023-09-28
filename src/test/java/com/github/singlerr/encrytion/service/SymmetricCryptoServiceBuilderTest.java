/**
Copyright 2023 singlerr

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/
package com.github.singlerr.encrytion.service;

import static org.junit.jupiter.api.Assertions.*;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.symmetric.aes256.AES256;
import com.github.singlerr.encrytion.symmetric.aes256.AES256EncryptorFactory;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SymmetricCryptoServiceBuilderTest {

    @Test
    void build()
            throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException,
                    NoSuchAlgorithmException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        CryptoService service = new SymmetricCryptoServiceBuilder(new AES256())
                .encryptorFactory(new AES256EncryptorFactory())
                .build();

        byte[] data = "test".getBytes(StandardCharsets.UTF_8);
        byte[] encrypted = service.encrypt(data);
        Assertions.assertArrayEquals(data, service.decrypt(encrypted));
    }
}
