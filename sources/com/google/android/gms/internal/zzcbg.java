package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
/* access modifiers changed from: package-private */
public final class zzcbg {
    final String mAppId;
    final String mName;
    final long zzink;
    final long zzinl;
    final long zzinm;

    zzcbg(String str, String str2, long j, long j2, long j3) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzbp.zzbh(j >= 0);
        zzbp.zzbh(j2 >= 0);
        this.mAppId = str;
        this.mName = str2;
        this.zzink = j;
        this.zzinl = j2;
        this.zzinm = j3;
    }

    /* access modifiers changed from: package-private */
    public final zzcbg zzaxz() {
        return new zzcbg(this.mAppId, this.mName, this.zzink + 1, this.zzinl + 1, this.zzinm);
    }

    /* access modifiers changed from: package-private */
    public final zzcbg zzbb(long j) {
        return new zzcbg(this.mAppId, this.mName, this.zzink, this.zzinl, j);
    }
}
