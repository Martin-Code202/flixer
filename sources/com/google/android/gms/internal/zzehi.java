package com.google.android.gms.internal;

import java.util.Arrays;
/* access modifiers changed from: package-private */
public final class zzehi {
    final int tag;
    final byte[] zzjaw;

    zzehi(int i, byte[] bArr) {
        this.tag = i;
        this.zzjaw = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzehi)) {
            return false;
        }
        zzehi zzehi = (zzehi) obj;
        return this.tag == zzehi.tag && Arrays.equals(this.zzjaw, zzehi.zzjaw);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzjaw);
    }
}
