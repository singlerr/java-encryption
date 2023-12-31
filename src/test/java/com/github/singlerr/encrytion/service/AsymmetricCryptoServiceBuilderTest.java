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
import com.github.singlerr.encrytion.asymmetric.rsa.RSA;
import com.github.singlerr.encrytion.asymmetric.rsa.RSAEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.rsa.RSAKeyGenerator;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AsymmetricCryptoServiceBuilderTest {

    @Test
    void build() throws Exception {
        CryptoService service = new AsymmetricCryptoServiceBuilder(new RSA())
                .keyGenerator(new RSAKeyGenerator())
                .encryptorFactory(new RSAEncryptorFactory())
                .build();

        byte[] data = "test".getBytes(StandardCharsets.UTF_8);
        byte[] encrypted = service.encrypt(data);

        Assertions.assertArrayEquals(data, service.decrypt(encrypted));
    }
}
