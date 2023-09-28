package com.github.singlerr.encrytion.symmetric.aes256;

import com.github.singlerr.encrytion.KeyAlgorithm;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class AES256Encryptor implements SymmetricEncryptor {

    @Override
    public byte[] encrypt(byte[] key, byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(KeyAlgorithm.AES_256.getAlgorithm());

        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(key, 0, 16));
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        return cipher.doFinal(data);
    }

    @Override
    public byte[] decrypt(byte[] key, byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(KeyAlgorithm.AES_256.getAlgorithm());
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(key, 0, 16));
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        return cipher.doFinal(data);
    }
}
