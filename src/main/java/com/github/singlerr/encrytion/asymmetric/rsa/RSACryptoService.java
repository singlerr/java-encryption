package com.github.singlerr.encrytion.asymmetric.rsa;

import com.github.singlerr.encrytion.asymmetric.AsymmetricCryptoService;
import com.github.singlerr.encrytion.asymmetric.AsymmetricEncryptorFactory;
import com.github.singlerr.encrytion.asymmetric.AsymmetricKeyStorage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public final class RSACryptoService extends AsymmetricCryptoService {

    public RSACryptoService(AsymmetricEncryptorFactory factory, AsymmetricKeyStorage keyStorage) {
        super(factory, keyStorage);
    }

    @Override
    public byte[] decrypt(byte[] source) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return encryptor.decrypt(keyStorage.getPrivateKey().array(), source);
    }

    //TODO: use readOnlyBuffer
    @Override
    public byte[] encrypt(byte[] source) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException,InvalidKeySpecException {
        return encryptor.encrypt(keyStorage.getPublicKey().array(), source);
    }
}
