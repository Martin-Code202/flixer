package com.google.android.gms.internal;

import java.io.IOException;
public abstract class zzehg {
    protected volatile int zzngp = -1;

    public static final <T extends zzehg> T zza(T t, byte[] bArr) {
        return (T) zza(t, bArr, 0, bArr.length);
    }

    private static <T extends zzehg> T zza(T t, byte[] bArr, int i, int i2) {
        try {
            zzegx zzh = zzegx.zzh(bArr, 0, i2);
            t.zza(zzh);
            zzh.zzgm(0);
            return t;
        } catch (zzehf e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzehh.zzd(this);
    }

    public abstract zzehg zza(zzegx zzegx);

    public void zza(zzegy zzegy) {
    }

    /* renamed from: zzcei */
    public zzehg clone() {
        return (zzehg) super.clone();
    }

    public final int zzceo() {
        if (this.zzngp < 0) {
            zzhi();
        }
        return this.zzngp;
    }

    public final int zzhi() {
        int zzn = zzn();
        this.zzngp = zzn;
        return zzn;
    }

    /* access modifiers changed from: protected */
    public int zzn() {
        return 0;
    }
}
