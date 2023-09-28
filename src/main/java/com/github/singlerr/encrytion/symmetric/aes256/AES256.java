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
package com.github.singlerr.encrytion.symmetric.aes256;

import com.github.singlerr.encrytion.CryptoService;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryption;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptorFactory;
import com.github.singlerr.encrytion.symmetric.SymmetricKeyStorage;

public final class AES256 implements SymmetricEncryption {

    private SymmetricEncryptorFactory factory;

    private SymmetricKeyStorage keyStorage;

    @Override
    public void factory(SymmetricEncryptorFactory factory) {
        this.factory = factory;
    }

    @Override
    public void keyStorage(SymmetricKeyStorage keyStorage) {
        this.keyStorage = keyStorage;
    }

    @Override
    public CryptoService build() {
        return new AES256CryptoService(factory, keyStorage);
    }
}
