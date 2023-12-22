package com.github.cao.awa.kalmia.network.encode.kalmiagram.crypto;

public abstract class TransportLayerCrypto {
    public abstract byte[] encode(byte[] plains) throws Exception;

    public abstract byte[] decode(byte[] ciphertext) throws Exception;
}
