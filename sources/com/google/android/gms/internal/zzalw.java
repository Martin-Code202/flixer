package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.HashMap;
public final class zzalw extends zzh<zzalw> {
    private String mName;
    private String zzbqr;
    private String zzbsw;
    private String zzdmd;
    private String zzdme;
    private String zzdmf;
    private String zzdmg;
    private String zzdmh;
    private String zzdmi;
    private String zzdmj;

    public final String getContent() {
        return this.zzbqr;
    }

    public final String getId() {
        return this.zzbsw;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getSource() {
        return this.zzdmd;
    }

    public final void setName(String str) {
        this.mName = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put(NetflixActivity.EXTRA_SOURCE, this.zzdmd);
        hashMap.put("medium", this.zzdme);
        hashMap.put("keyword", this.zzdmf);
        hashMap.put("content", this.zzbqr);
        hashMap.put("id", this.zzbsw);
        hashMap.put("adNetworkId", this.zzdmg);
        hashMap.put("gclid", this.zzdmh);
        hashMap.put("dclid", this.zzdmi);
        hashMap.put("aclid", this.zzdmj);
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzalw zzalw) {
        zzalw zzalw2 = zzalw;
        if (!TextUtils.isEmpty(this.mName)) {
            zzalw2.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.zzdmd)) {
            zzalw2.zzdmd = this.zzdmd;
        }
        if (!TextUtils.isEmpty(this.zzdme)) {
            zzalw2.zzdme = this.zzdme;
        }
        if (!TextUtils.isEmpty(this.zzdmf)) {
            zzalw2.zzdmf = this.zzdmf;
        }
        if (!TextUtils.isEmpty(this.zzbqr)) {
            zzalw2.zzbqr = this.zzbqr;
        }
        if (!TextUtils.isEmpty(this.zzbsw)) {
            zzalw2.zzbsw = this.zzbsw;
        }
        if (!TextUtils.isEmpty(this.zzdmg)) {
            zzalw2.zzdmg = this.zzdmg;
        }
        if (!TextUtils.isEmpty(this.zzdmh)) {
            zzalw2.zzdmh = this.zzdmh;
        }
        if (!TextUtils.isEmpty(this.zzdmi)) {
            zzalw2.zzdmi = this.zzdmi;
        }
        if (!TextUtils.isEmpty(this.zzdmj)) {
            zzalw2.zzdmj = this.zzdmj;
        }
    }

    public final void zzcy(String str) {
        this.zzdmd = str;
    }

    public final void zzcz(String str) {
        this.zzdme = str;
    }

    public final void zzda(String str) {
        this.zzdmf = str;
    }

    public final void zzdb(String str) {
        this.zzbqr = str;
    }

    public final void zzdc(String str) {
        this.zzbsw = str;
    }

    public final void zzdd(String str) {
        this.zzdmg = str;
    }

    public final void zzde(String str) {
        this.zzdmh = str;
    }

    public final void zzdf(String str) {
        this.zzdmi = str;
    }

    public final void zzdg(String str) {
        this.zzdmj = str;
    }

    public final String zzuq() {
        return this.zzdme;
    }

    public final String zzur() {
        return this.zzdmf;
    }

    public final String zzus() {
        return this.zzdmg;
    }

    public final String zzut() {
        return this.zzdmh;
    }

    public final String zzuu() {
        return this.zzdmi;
    }

    public final String zzuv() {
        return this.zzdmj;
    }
}
