package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import java.util.Iterator;
public final class zzcbf {
    final String mAppId;
    final String mName;
    private String mOrigin;
    final long zzfdb;
    final long zzini;
    final zzcbh zzinj;

    zzcbf(zzccw zzccw, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbp.zzgg(str2);
        zzbp.zzgg(str3);
        this.mAppId = str2;
        this.mName = str3;
        this.mOrigin = TextUtils.isEmpty(str) ? null : str;
        this.zzfdb = j;
        this.zzini = j2;
        if (this.zzini != 0 && this.zzini > this.zzfdb) {
            zzccw.zzaum().zzayg().zzj("Event created with reverse previous/current timestamps. appId", zzcbw.zzjf(str2));
        }
        this.zzinj = zza(zzccw, bundle);
    }

    private zzcbf(zzccw zzccw, String str, String str2, String str3, long j, long j2, zzcbh zzcbh) {
        zzbp.zzgg(str2);
        zzbp.zzgg(str3);
        zzbp.zzu(zzcbh);
        this.mAppId = str2;
        this.mName = str3;
        this.mOrigin = TextUtils.isEmpty(str) ? null : str;
        this.zzfdb = j;
        this.zzini = j2;
        if (this.zzini != 0 && this.zzini > this.zzfdb) {
            zzccw.zzaum().zzayg().zzj("Event created with reverse previous/current timestamps. appId", zzcbw.zzjf(str2));
        }
        this.zzinj = zzcbh;
    }

    private static zzcbh zza(zzccw zzccw, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new zzcbh(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator<String> it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next == null) {
                zzccw.zzaum().zzaye().log("Param name can't be null");
                it.remove();
            } else {
                Object zzk = zzccw.zzaui().zzk(next, bundle2.get(next));
                if (zzk == null) {
                    zzccw.zzaum().zzayg().zzj("Param value can't be null", zzccw.zzauh().zzjd(next));
                    it.remove();
                } else {
                    zzccw.zzaui().zza(bundle2, next, zzk);
                }
            }
        }
        return new zzcbh(bundle2);
    }

    public final String toString() {
        String str = this.mAppId;
        String str2 = this.mName;
        String valueOf = String.valueOf(this.zzinj);
        return new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(str).length() + 33 + String.valueOf(str2).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(valueOf).append("}").toString();
    }

    /* access modifiers changed from: package-private */
    public final zzcbf zza(zzccw zzccw, long j) {
        return new zzcbf(zzccw, this.mOrigin, this.mAppId, this.mName, this.zzfdb, j, this.zzinj);
    }
}
