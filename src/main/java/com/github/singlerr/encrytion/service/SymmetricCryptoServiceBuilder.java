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

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.symmetric.*;

public class SymmetricCryptoServiceBuilder extends CryptoServiceBuilder {

    private SymmetricKeyGenerator keyGenerator;

    private final SymmetricEncryption encryption;

    public SymmetricCryptoServiceBuilder(SymmetricEncryption encryptionType) {
        this.keyGenerator = new DefaultSymmetricKeyGenerator();
        this.encryption = encryptionType;
    }

    public SymmetricCryptoServiceBuilder encryptorFactory(SymmetricEncryptorFactory factory) {
        this.encryption.factory(factory);
        return this;
    }

    public SymmetricCryptoServiceBuilder keyGenerator(SymmetricKeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
        return this;
    }

    @Override
    public CryptoService build() {

        this.encryption.keyStorage(new SymmetricKeyStorage(keyGenerator.generate()));

        return this.encryption.build();
    }
}
