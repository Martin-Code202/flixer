package org.bouncycastle.crypto;
public interface BlockCipher {
    int getBlockSize();

    void init(boolean z, CipherParameters cipherParameters);

    int processBlock(byte[] bArr, int i, byte[] bArr2, int i2);

    void reset();
}
