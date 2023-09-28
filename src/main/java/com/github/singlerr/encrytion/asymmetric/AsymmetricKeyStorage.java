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
package com.github.singlerr.encrytion.asymmetric;

import java.security.KeyPair;
import java.util.Arrays;

/***
 * Immutable key storage
 * @author singlerr
 */
public class AsymmetricKeyStorage {

    private final byte[] privateKey;

    private final byte[] publicKey;

    public AsymmetricKeyStorage(byte[] privateKey, byte[] publicKey) {
        this.privateKey = Arrays.copyOf(privateKey, privateKey.length);
        this.publicKey = Arrays.copyOf(publicKey, publicKey.length);
    }

    public AsymmetricKeyStorage(KeyPair keyPair) {
        this(keyPair.getPrivate().getEncoded(), keyPair.getPublic().getEncoded());
    }

    public byte[] getPrivateKey() {
        return Arrays.copyOf(privateKey, privateKey.length);
    }

    public byte[] getPublicKey() {
        return Arrays.copyOf(publicKey, publicKey.length);
    }
}
