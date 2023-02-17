package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbp;
public final class zzccl {
    private final long zzdtt;
    private /* synthetic */ zzcch zzirj;
    private String zzirl;
    private final String zzirm;
    private final String zzirn;

    private zzccl(zzcch zzcch, String str, long j) {
        this.zzirj = zzcch;
        zzbp.zzgg(str);
        zzbp.zzbh(j > 0);
        this.zzirl = String.valueOf(str).concat(":start");
        this.zzirm = String.valueOf(str).concat(":count");
        this.zzirn = String.valueOf(str).concat(":value");
        this.zzdtt = j;
    }

    private final void zzzh() {
        this.zzirj.zzuj();
        long currentTimeMillis = this.zzirj.zzvx().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzirj.zzdtp.edit();
        edit.remove(this.zzirm);
        edit.remove(this.zzirn);
        edit.putLong(this.zzirl, currentTimeMillis);
        edit.apply();
    }

    private final long zzzj() {
        return this.zzirj.zzaym().getLong(this.zzirl, 0);
    }

    public final void zzf(String str, long j) {
        this.zzirj.zzuj();
        if (zzzj() == 0) {
            zzzh();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzirj.zzdtp.getLong(this.zzirm, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zzirj.zzdtp.edit();
            edit.putString(this.zzirn, str);
            edit.putLong(this.zzirm, 1);
            edit.apply();
            return;
        }
        boolean z = (this.zzirj.zzaui().zzazz().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (1 + j2);
        SharedPreferences.Editor edit2 = this.zzirj.zzdtp.edit();
        if (z) {
            edit2.putString(this.zzirn, str);
        }
        edit2.putLong(this.zzirm, 1 + j2);
        edit2.apply();
    }

    public final Pair<String, Long> zzzi() {
        long j;
        this.zzirj.zzuj();
        this.zzirj.zzuj();
        long zzzj = zzzj();
        if (zzzj == 0) {
            zzzh();
            j = 0;
        } else {
            j = Math.abs(zzzj - this.zzirj.zzvx().currentTimeMillis());
        }
        if (j < this.zzdtt) {
            return null;
        }
        if (j > (this.zzdtt << 1)) {
            zzzh();
            return null;
        }
        String string = this.zzirj.zzaym().getString(this.zzirn, null);
        long j2 = this.zzirj.zzaym().getLong(this.zzirm, 0);
        zzzh();
        return (string == null || j2 <= 0) ? zzcch.zziqm : new Pair<>(string, Long.valueOf(j2));
    }
}
