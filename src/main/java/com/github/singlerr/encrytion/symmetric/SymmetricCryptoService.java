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
package com.github.singlerr.encrytion.symmetric;

import com.github.singlerr.encrytion.CryptoService;

public abstract class SymmetricCryptoService implements CryptoService {

    protected final SymmetricEncryptorFactory encryptorFactory;

    protected final SymmetricEncryptor encryptor;

    protected final SymmetricKeyStorage keyStorage;

    protected SymmetricCryptoService(SymmetricEncryptorFactory factory, SymmetricKeyStorage storage) {
        this.encryptorFactory = factory;
        this.keyStorage = storage;
        this.encryptor = factory.create(storage);
    }
}
