package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;
public final class zzag {
    private final String zzdmq;
    private final String zzfuu;
    private final ComponentName zzfuv = null;
    private final int zzfuw;

    public zzag(String str, String str2, int i) {
        this.zzdmq = zzbp.zzgg(str);
        this.zzfuu = zzbp.zzgg(str2);
        this.zzfuw = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzag = (zzag) obj;
        return zzbf.equal(this.zzdmq, zzag.zzdmq) && zzbf.equal(this.zzfuu, zzag.zzfuu) && zzbf.equal(this.zzfuv, zzag.zzfuv) && this.zzfuw == zzag.zzfuw;
    }

    public final ComponentName getComponentName() {
        return this.zzfuv;
    }

    public final String getPackage() {
        return this.zzfuu;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdmq, this.zzfuu, this.zzfuv, Integer.valueOf(this.zzfuw)});
    }

    public final String toString() {
        return this.zzdmq == null ? this.zzfuv.flattenToString() : this.zzdmq;
    }

    public final int zzakh() {
        return this.zzfuw;
    }

    public final Intent zzaki() {
        return this.zzdmq != null ? new Intent(this.zzdmq).setPackage(this.zzfuu) : new Intent().setComponent(this.zzfuv);
    }
}
