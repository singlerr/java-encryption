package com.github.singlerr.encrytion.asymmetric;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public interface AsymmetricKeyGenerator {

    KeyPair generate() throws NoSuchAlgorithmException;

}
