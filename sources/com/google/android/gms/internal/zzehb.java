package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeha;
import java.io.IOException;
public final class zzehb<M extends zzeha<M>, T> {
    public final int tag;
    private int type;
    protected final Class<T> zzmju;
    protected final boolean zzngh;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzehb)) {
            return false;
        }
        zzehb zzehb = (zzehb) obj;
        return this.type == zzehb.type && this.zzmju == zzehb.zzmju && this.tag == zzehb.tag && this.zzngh == zzehb.zzngh;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzmju.hashCode()) * 31) + this.tag) * 31) + (this.zzngh ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, zzegy zzegy) {
        try {
            zzegy.zzhf(this.tag);
            switch (this.type) {
                case 10:
                    ((zzehg) obj).zza(zzegy);
                    zzegy.zzu(this.tag >>> 3, 4);
                    return;
                case 11:
                    zzegy.zzb((zzehg) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzbw(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzegy.zzgs(i) << 1) + ((zzehg) obj).zzhi();
            case 11:
                return zzegy.zzb(i, (zzehg) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}
