package com.github.singlerr.encrytion.symmetric;

import java.nio.ByteBuffer;

/***
 * Immutable key storage
 * @author singlerr
 */
public class SymmetricKeyStorage {

    private final ByteBuffer key;

    public SymmetricKeyStorage(byte[] key) {
        this.key = ByteBuffer.wrap(key).asReadOnlyBuffer();
    }

    public ByteBuffer getKey() {
        return key.duplicate().asReadOnlyBuffer();
    }
}
