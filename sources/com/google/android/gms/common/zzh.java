package com.google.android.gms.common;

import java.util.Arrays;
/* access modifiers changed from: package-private */
public final class zzh extends zzg {
    private final byte[] zzffo;

    zzh(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zzffo = bArr;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzg
    public final byte[] getBytes() {
        return this.zzffo;
    }
}
