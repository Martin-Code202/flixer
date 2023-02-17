package com.google.android.gms.common;

import java.lang.ref.WeakReference;
abstract class zzi extends zzg {
    private static final WeakReference<byte[]> zzffq = new WeakReference<>(null);
    private WeakReference<byte[]> zzffp = zzffq;

    zzi(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzg
    public final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzffp.get();
            if (bArr == null) {
                bArr = zzafb();
                this.zzffp = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzafb();
}
