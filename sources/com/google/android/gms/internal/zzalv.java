package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.util.HashMap;
public final class zzalv extends zzh<zzalv> {
    private String mAppId;
    private String zzdma;
    private String zzdmb;
    private String zzdmc;

    public final String getAppId() {
        return this.mAppId;
    }

    public final void setAppId(String str) {
        this.mAppId = str;
    }

    public final void setAppInstallerId(String str) {
        this.zzdmc = str;
    }

    public final void setAppName(String str) {
        this.zzdma = str;
    }

    public final void setAppVersion(String str) {
        this.zzdmb = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(LoggingRequest.APP_NAME, this.zzdma);
        hashMap.put("appVersion", this.zzdmb);
        hashMap.put("appId", this.mAppId);
        hashMap.put("appInstallerId", this.zzdmc);
        return zzh(hashMap);
    }

    /* renamed from: zza */
    public final void zzb(zzalv zzalv) {
        if (!TextUtils.isEmpty(this.zzdma)) {
            zzalv.zzdma = this.zzdma;
        }
        if (!TextUtils.isEmpty(this.zzdmb)) {
            zzalv.zzdmb = this.zzdmb;
        }
        if (!TextUtils.isEmpty(this.mAppId)) {
            zzalv.mAppId = this.mAppId;
        }
        if (!TextUtils.isEmpty(this.zzdmc)) {
            zzalv.zzdmc = this.zzdmc;
        }
    }

    public final String zzun() {
        return this.zzdma;
    }

    public final String zzuo() {
        return this.zzdmb;
    }

    public final String zzup() {
        return this.zzdmc;
    }
}
