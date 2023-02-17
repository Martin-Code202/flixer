package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbp;
import java.util.UUID;
public final class zzaot {
    private final String mName;
    private final long zzdtt;
    private /* synthetic */ zzaor zzdtu;

    private zzaot(zzaor zzaor, String str, long j) {
        this.zzdtu = zzaor;
        zzbp.zzgg(str);
        zzbp.zzbh(j > 0);
        this.mName = str;
        this.zzdtt = j;
    }

    private final void zzzh() {
        long currentTimeMillis = this.zzdtu.zzvx().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzdtu.zzdtp.edit();
        edit.remove(zzzl());
        edit.remove(zzzm());
        edit.putLong(zzzk(), currentTimeMillis);
        edit.commit();
    }

    private final long zzzj() {
        return this.zzdtu.zzdtp.getLong(zzzk(), 0);
    }

    private final String zzzk() {
        return String.valueOf(this.mName).concat(":start");
    }

    private final String zzzl() {
        return String.valueOf(this.mName).concat(":count");
    }

    private final String zzzm() {
        return String.valueOf(this.mName).concat(":value");
    }

    public final void zzdy(String str) {
        if (zzzj() == 0) {
            zzzh();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.zzdtu.zzdtp.getLong(zzzl(), 0);
            if (j <= 0) {
                SharedPreferences.Editor edit = this.zzdtu.zzdtp.edit();
                edit.putString(zzzm(), str);
                edit.putLong(zzzl(), 1);
                edit.apply();
                return;
            }
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (1 + j);
            SharedPreferences.Editor edit2 = this.zzdtu.zzdtp.edit();
            if (z) {
                edit2.putString(zzzm(), str);
            }
            edit2.putLong(zzzl(), 1 + j);
            edit2.apply();
        }
    }

    public final Pair<String, Long> zzzi() {
        long zzzj = zzzj();
        long abs = zzzj == 0 ? 0 : Math.abs(zzzj - this.zzdtu.zzvx().currentTimeMillis());
        if (abs < this.zzdtt) {
            return null;
        }
        if (abs > (this.zzdtt << 1)) {
            zzzh();
            return null;
        }
        String string = this.zzdtu.zzdtp.getString(zzzm(), null);
        long j = this.zzdtu.zzdtp.getLong(zzzl(), 0);
        zzzh();
        if (string == null || j <= 0) {
            return null;
        }
        return new Pair<>(string, Long.valueOf(j));
    }
}
