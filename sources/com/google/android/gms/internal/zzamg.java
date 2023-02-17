package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
public final class zzamg extends zzh<zzamg> {
    public String zzdmq;
    public String zzdnj;
    public String zzdnk;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.zzdnj);
        hashMap.put("action", this.zzdmq);
        hashMap.put("target", this.zzdnk);
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzamg zzamg) {
        zzamg zzamg2 = zzamg;
        if (!TextUtils.isEmpty(this.zzdnj)) {
            zzamg2.zzdnj = this.zzdnj;
        }
        if (!TextUtils.isEmpty(this.zzdmq)) {
            zzamg2.zzdmq = this.zzdmq;
        }
        if (!TextUtils.isEmpty(this.zzdnk)) {
            zzamg2.zzdnk = this.zzdnk;
        }
    }
}
