package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
public class CMac {
    private byte[] L;
    private byte[] Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public CMac(BlockCipher blockCipher, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (i > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        } else if (blockCipher.getBlockSize() == 8 || blockCipher.getBlockSize() == 16) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.macSize = i / 8;
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.ZEROES = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
        } else {
            throw new IllegalArgumentException("Block size must be either 64 or 128 bits");
        }
    }

    private byte[] doubleLu(byte[] bArr) {
        int i = (bArr[0] & 255) >> 7;
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length - 1; i2++) {
            bArr2[i2] = (byte) ((bArr[i2] << 1) + ((bArr[i2 + 1] & 255) >> 7));
        }
        bArr2[bArr.length - 1] = (byte) (bArr[bArr.length - 1] << 1);
        if (i == 1) {
            int length = bArr.length - 1;
            bArr2[length] = (byte) (bArr2[length] ^ (bArr.length == 16 ? (byte) -121 : 27));
        }
        return bArr2;
    }

    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        for (int i2 = 0; i2 < this.mac.length; i2++) {
            byte[] bArr3 = this.buf;
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr2[i2]);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        System.arraycopy(this.mac, 0, bArr, i, this.macSize);
        reset();
        return this.macSize;
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(true, cipherParameters);
        this.L = new byte[this.ZEROES.length];
        this.cipher.processBlock(this.ZEROES, 0, this.L, 0);
        this.Lu = doubleLu(this.L);
        this.Lu2 = doubleLu(this.Lu);
        this.cipher.init(true, cipherParameters);
    }

    public void reset() {
        for (int i = 0; i < this.buf.length; i++) {
            this.buf[i] = 0;
        }
        this.bufOff = 0;
        this.cipher.reset();
    }

    public void update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.cipher.getBlockSize();
        int i3 = blockSize - this.bufOff;
        if (i2 > i3) {
            System.arraycopy(bArr, i, this.buf, this.bufOff, i3);
            this.cipher.processBlock(this.buf, 0, this.mac, 0);
            this.bufOff = 0;
            i2 -= i3;
            i += i3;
            while (i2 > blockSize) {
                this.cipher.processBlock(bArr, i, this.mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
        this.bufOff += i2;
    }
}
