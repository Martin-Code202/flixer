package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import java.util.HashMap;
public final class zzamd extends zzh<zzamd> {
    public String zzdmt;
    public boolean zzdmu;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.zzdmt);
        hashMap.put(DeepErrorElement.FATAL, Boolean.valueOf(this.zzdmu));
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzamd zzamd) {
        zzamd zzamd2 = zzamd;
        if (!TextUtils.isEmpty(this.zzdmt)) {
            zzamd2.zzdmt = this.zzdmt;
        }
        if (this.zzdmu) {
            zzamd2.zzdmu = this.zzdmu;
        }
    }
}
