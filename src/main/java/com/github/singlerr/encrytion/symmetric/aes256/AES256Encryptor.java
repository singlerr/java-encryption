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

import com.github.singlerr.encrytion.KeyAlgorithm;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptor;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AES256Encryptor implements SymmetricEncryptor {

    @Override
    public byte[] encrypt(byte[] key, byte[] data)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
                    InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(KeyAlgorithm.AES_256.getAlgorithm());

        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(key, 0, 16));
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        return cipher.doFinal(data);
    }

    @Override
    public byte[] decrypt(byte[] key, byte[] data)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
                    InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(KeyAlgorithm.AES_256.getAlgorithm());
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(key, 0, 16));
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        return cipher.doFinal(data);
    }
}
