package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzbp;
public final class zzccm {
    private String mValue;
    private final String zzbfe;
    private boolean zziri;
    private /* synthetic */ zzcch zzirj;
    private final String zziro = null;

    public zzccm(zzcch zzcch, String str, String str2) {
        this.zzirj = zzcch;
        zzbp.zzgg(str);
        this.zzbfe = str;
    }

    public final String zzays() {
        if (!this.zziri) {
            this.zziri = true;
            this.mValue = this.zzirj.zzdtp.getString(this.zzbfe, null);
        }
        return this.mValue;
    }

    public final void zzjl(String str) {
        if (!zzcfw.zzas(str, this.mValue)) {
            SharedPreferences.Editor edit = this.zzirj.zzdtp.edit();
            edit.putString(this.zzbfe, str);
            edit.apply();
            this.mValue = str;
        }
    }
}
