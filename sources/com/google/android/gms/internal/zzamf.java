package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
public final class zzamf extends zzh<zzamf> {
    private String zzaph;
    private int zzdnd;
    private int zzdne;
    private String zzdnf;
    private String zzdng;
    private boolean zzdnh;
    private boolean zzdni;

    public zzamf() {
        this(false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzamf(boolean r7) {
        /*
            r6 = this;
            java.util.UUID r4 = java.util.UUID.randomUUID()
            long r0 = r4.getLeastSignificantBits()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r2
            int r0 = (int) r0
            r5 = r0
            if (r0 == 0) goto L_0x0012
            r0 = r5
            goto L_0x002a
        L_0x0012:
            long r0 = r4.getMostSignificantBits()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r2
            int r0 = (int) r0
            r5 = r0
            if (r0 == 0) goto L_0x0020
            r0 = r5
            goto L_0x002a
        L_0x0020:
            java.lang.String r0 = "GAv4"
            java.lang.String r1 = "UUID.randomUUID() returned 0."
            android.util.Log.e(r0, r1)
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x002a:
            r1 = 0
            r6.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamf.<init>(boolean):void");
    }

    private zzamf(boolean z, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.zzdnd = i;
        this.zzdni = false;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.zzaph);
        hashMap.put("interstitial", Boolean.valueOf(this.zzdnh));
        hashMap.put("automatic", Boolean.valueOf(this.zzdni));
        hashMap.put("screenId", Integer.valueOf(this.zzdnd));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzdne));
        hashMap.put("referrerScreenName", this.zzdnf);
        hashMap.put("referrerUri", this.zzdng);
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzamf zzamf) {
        zzamf zzamf2 = zzamf;
        if (!TextUtils.isEmpty(this.zzaph)) {
            zzamf2.zzaph = this.zzaph;
        }
        if (this.zzdnd != 0) {
            zzamf2.zzdnd = this.zzdnd;
        }
        if (this.zzdne != 0) {
            zzamf2.zzdne = this.zzdne;
        }
        if (!TextUtils.isEmpty(this.zzdnf)) {
            zzamf2.zzdnf = this.zzdnf;
        }
        if (!TextUtils.isEmpty(this.zzdng)) {
            String str = this.zzdng;
            if (TextUtils.isEmpty(str)) {
                zzamf2.zzdng = null;
            } else {
                zzamf2.zzdng = str;
            }
        }
        if (this.zzdnh) {
            zzamf2.zzdnh = this.zzdnh;
        }
        if (this.zzdni) {
            zzamf2.zzdni = this.zzdni;
        }
    }

    public final String zzvk() {
        return this.zzaph;
    }

    public final int zzvl() {
        return this.zzdnd;
    }

    public final String zzvm() {
        return this.zzdng;
    }
}
