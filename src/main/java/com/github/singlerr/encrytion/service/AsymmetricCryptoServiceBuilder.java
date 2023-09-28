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
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryption;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyGenerator;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyStorage;

public class AsymmetricCryptoServiceBuilder extends CryptoServiceBuilder {

    private AsymmetricKeyGenerator keyGenerator;

    private final AsymmetricEncryption encryption;

    public AsymmetricCryptoServiceBuilder(AsymmetricEncryption encryptionType) {
        this.encryption = encryptionType;
    }

    public AsymmetricCryptoServiceBuilder encryptorFactory(AsymmetricEncryptorFactory factory) {
        this.encryption.factory(factory);
        return this;
    }

    public AsymmetricCryptoServiceBuilder keyGenerator(AsymmetricKeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
        return this;
    }

    @Override
    public CryptoService build() throws Exception {

        this.encryption.keyStorage(new AsymmetricKeyStorage(keyGenerator.generate()));

        return this.encryption.build();
    }
}
