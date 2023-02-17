package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.HashMap;
public final class zzamc extends zzh<zzamc> {
    private String mCategory;
    private String zzdmq;
    private String zzdmr;
    private long zzdms;

    public final String getAction() {
        return this.zzdmq;
    }

    public final String getCategory() {
        return this.mCategory;
    }

    public final String getLabel() {
        return this.zzdmr;
    }

    public final long getValue() {
        return this.zzdms;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.mCategory);
        hashMap.put("action", this.zzdmq);
        hashMap.put(SignupConstants.Field.LABEL, this.zzdmr);
        hashMap.put("value", Long.valueOf(this.zzdms));
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzamc zzamc) {
        zzamc zzamc2 = zzamc;
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzamc2.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzdmq)) {
            zzamc2.zzdmq = this.zzdmq;
        }
        if (!TextUtils.isEmpty(this.zzdmr)) {
            zzamc2.zzdmr = this.zzdmr;
        }
        if (this.zzdms != 0) {
            zzamc2.zzdms = this.zzdms;
        }
    }
}
