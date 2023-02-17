package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzbp;
import java.util.HashMap;
public final class zzame extends zzh<zzame> {
    private String zzdmv;
    private String zzdmw;
    private String zzdmx;
    private String zzdmy;
    private boolean zzdmz;
    private String zzdna;
    private boolean zzdnb;
    private double zzdnc;

    public final String getUserId() {
        return this.zzdmx;
    }

    public final void setClientId(String str) {
        this.zzdmw = str;
    }

    public final void setUserId(String str) {
        this.zzdmx = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.zzdmv);
        hashMap.put("clientId", this.zzdmw);
        hashMap.put("userId", this.zzdmx);
        hashMap.put("androidAdId", this.zzdmy);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzdmz));
        hashMap.put("sessionControl", this.zzdna);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzdnb));
        hashMap.put("sampleRate", Double.valueOf(this.zzdnc));
        return zzh(hashMap);
    }

    public final void zzah(boolean z) {
        this.zzdmz = z;
    }

    public final void zzai(boolean z) {
        this.zzdnb = true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzame zzame) {
        zzame zzame2 = zzame;
        if (!TextUtils.isEmpty(this.zzdmv)) {
            zzame2.zzdmv = this.zzdmv;
        }
        if (!TextUtils.isEmpty(this.zzdmw)) {
            zzame2.zzdmw = this.zzdmw;
        }
        if (!TextUtils.isEmpty(this.zzdmx)) {
            zzame2.zzdmx = this.zzdmx;
        }
        if (!TextUtils.isEmpty(this.zzdmy)) {
            zzame2.zzdmy = this.zzdmy;
        }
        if (this.zzdmz) {
            zzame2.zzdmz = true;
        }
        if (!TextUtils.isEmpty(this.zzdna)) {
            zzame2.zzdna = this.zzdna;
        }
        if (this.zzdnb) {
            zzame2.zzdnb = this.zzdnb;
        }
        if (this.zzdnc != 0.0d) {
            double d = this.zzdnc;
            zzbp.zzb(d >= 0.0d && d <= 100.0d, "Sample rate must be between 0% and 100%");
            zzame2.zzdnc = d;
        }
    }

    public final void zzdh(String str) {
        this.zzdmv = str;
    }

    public final void zzdi(String str) {
        this.zzdmy = str;
    }

    public final String zzvd() {
        return this.zzdmv;
    }

    public final String zzve() {
        return this.zzdmw;
    }

    public final String zzvf() {
        return this.zzdmy;
    }

    public final boolean zzvg() {
        return this.zzdmz;
    }

    public final String zzvh() {
        return this.zzdna;
    }

    public final boolean zzvi() {
        return this.zzdnb;
    }

    public final double zzvj() {
        return this.zzdnc;
    }
}
