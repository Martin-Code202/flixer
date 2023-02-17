package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
public class ParametersWithIV implements CipherParameters {
    private byte[] iv;
    private CipherParameters parameters;

    public byte[] getIV() {
        return this.iv;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
