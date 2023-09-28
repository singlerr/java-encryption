package com.github.singlerr.encrytion.asymmetric;

import java.nio.ByteBuffer;
import java.security.KeyPair;

/***
 * Immutable key storage
 * @author singlerr
 */
public class AsymmetricKeyStorage {

    private final ByteBuffer privateKey;

    private final ByteBuffer publicKey;

    public AsymmetricKeyStorage(byte[] privateKey, byte[] publicKey) {
        this.privateKey = ByteBuffer.wrap(privateKey);
        this.publicKey = ByteBuffer.wrap(privateKey);
    }

    public AsymmetricKeyStorage(KeyPair keyPair) {
        this(keyPair.getPrivate().getEncoded(), keyPair.getPublic().getEncoded());
    }


    public ByteBuffer getPrivateKey() {
        return privateKey.duplicate();
    }

    public ByteBuffer getPublicKey() {
        return publicKey.duplicate();
    }
}
