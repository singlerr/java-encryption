package com.github.singlerr.encrytion.service;

import com.github.singlerr.encrytion.CryptoService;

public abstract class CryptoServiceBuilder {
    public abstract CryptoService build() throws Exception;
}
