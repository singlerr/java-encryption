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

import com.github.singlerr.encrytion.symmetric.SymmetricCryptoService;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptorFactory;
import com.github.singlerr.encrytion.symmetric.SymmetricKeyStorage;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class AES256CryptoService extends SymmetricCryptoService {
    public AES256CryptoService(SymmetricEncryptorFactory factory, SymmetricKeyStorage storage) {
        super(factory, storage);
    }

    @Override
    public byte[] decrypt(byte[] source)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
                    IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return encryptor.decrypt(keyStorage.getKey(), source);
    }

    @Override
    public byte[] encrypt(byte[] source)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
                    IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return encryptor.encrypt(keyStorage.getKey(), source);
    }
}
