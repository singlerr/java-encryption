package com.github.singlerr.encrytion.symmetric.aes256;

import com.github.singlerr.encrytion.symmetric.SymmetricCryptoService;
import com.github.singlerr.encrytion.symmetric.SymmetricEncryptorFactory;
import com.github.singlerr.encrytion.symmetric.SymmetricKeyStorage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public final class AES256CryptoService extends SymmetricCryptoService {
    public AES256CryptoService(SymmetricEncryptorFactory factory, SymmetricKeyStorage storage) {
        super(factory, storage);
    }

    @Override
    public byte[] decrypt(byte[] source) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return encryptor.decrypt(keyStorage.getKey().array(), source);
    }

    @Override
    public byte[] encrypt(byte[] source) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return encryptor.encrypt(keyStorage.getKey().array(), source);
    }
}
