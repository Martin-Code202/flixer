package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzbp;
public final class zzcck {
    private final String zzbfe;
    private long zzdms;
    private boolean zziri;
    private /* synthetic */ zzcch zzirj;
    private final long zzirk;

    public zzcck(zzcch zzcch, String str, long j) {
        this.zzirj = zzcch;
        zzbp.zzgg(str);
        this.zzbfe = str;
        this.zzirk = j;
    }

    public final long get() {
        if (!this.zziri) {
            this.zziri = true;
            this.zzdms = this.zzirj.zzdtp.getLong(this.zzbfe, this.zzirk);
        }
        return this.zzdms;
    }

    public final void set(long j) {
        SharedPreferences.Editor edit = this.zzirj.zzdtp.edit();
        edit.putLong(this.zzbfe, j);
        edit.apply();
        this.zzdms = j;
    }
}
