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
package com.github.singlerr.encrytion.asymmetric.rsa;

import com.github.singlerr.encrytion.asymmetric.AsymmetricCryptoService;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyStorage;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class RSACryptoService extends AsymmetricCryptoService {

    public RSACryptoService(AsymmetricEncryptorFactory factory, AsymmetricKeyStorage keyStorage) {
        super(factory, keyStorage);
    }

    @Override
    public byte[] decrypt(byte[] source)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
                    IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return encryptor.decrypt(keyStorage.getPrivateKey(), source);
    }

    // TODO: use readOnlyBuffer
    @Override
    public byte[] encrypt(byte[] source)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
                    IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return encryptor.encrypt(keyStorage.getPublicKey(), source);
    }
}
