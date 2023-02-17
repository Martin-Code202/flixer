package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzbp;
public final class zzccj {
    private final String zzbfe;
    private boolean zzfgp;
    private final boolean zzirh = true;
    private boolean zziri;
    private /* synthetic */ zzcch zzirj;

    public zzccj(zzcch zzcch, String str, boolean z) {
        this.zzirj = zzcch;
        zzbp.zzgg(str);
        this.zzbfe = str;
    }

    public final boolean get() {
        if (!this.zziri) {
            this.zziri = true;
            this.zzfgp = this.zzirj.zzdtp.getBoolean(this.zzbfe, this.zzirh);
        }
        return this.zzfgp;
    }

    public final void set(boolean z) {
        SharedPreferences.Editor edit = this.zzirj.zzdtp.edit();
        edit.putBoolean(this.zzbfe, z);
        edit.apply();
        this.zzfgp = z;
    }
}
