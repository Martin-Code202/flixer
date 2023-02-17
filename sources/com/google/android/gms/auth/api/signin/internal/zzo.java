package com.google.android.gms.auth.api.signin.internal;
public final class zzo {
    private static int zzecz = 31;
    private int zzeda = 1;

    public final int zzaao() {
        return this.zzeda;
    }

    public final zzo zzaq(boolean z) {
        this.zzeda = (zzecz * this.zzeda) + (z ? 1 : 0);
        return this;
    }

    public final zzo zzo(Object obj) {
        this.zzeda = (zzecz * this.zzeda) + (obj == null ? 0 : obj.hashCode());
        return this;
    }
}
