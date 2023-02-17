package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
public final class TrackEncryptionBox {
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final int initializationVectorSize;
    public final boolean isEncrypted;
    public final String schemeType;

    public TrackEncryptionBox(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        Assertions.checkArgument((i == 0) ^ (bArr2 == null));
        this.isEncrypted = z;
        this.schemeType = str;
        this.initializationVectorSize = i;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i2, i3);
    }

    private static int schemeToCryptoMode(String str) {
        if (str == null) {
            return 1;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c = 2;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c = 3;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c = 0;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                Log.w("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                return 1;
        }
    }
}
