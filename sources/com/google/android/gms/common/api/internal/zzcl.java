package com.google.android.gms.common.api.internal;
public final class zzcl<L> {
    private final L mListener;
    private final String zzfow;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return false;
        }
        zzcl zzcl = (zzcl) obj;
        return this.mListener == zzcl.mListener && this.zzfow.equals(zzcl.zzfow);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.mListener) * 31) + this.zzfow.hashCode();
    }
}
