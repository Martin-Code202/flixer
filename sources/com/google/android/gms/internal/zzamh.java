package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.HashMap;
public final class zzamh extends zzh<zzamh> {
    public String mCategory;
    public String zzdmr;
    public String zzdnl;
    public long zzdnm;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzdnl);
        hashMap.put("timeInMillis", Long.valueOf(this.zzdnm));
        hashMap.put("category", this.mCategory);
        hashMap.put(SignupConstants.Field.LABEL, this.zzdmr);
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzamh zzamh) {
        zzamh zzamh2 = zzamh;
        if (!TextUtils.isEmpty(this.zzdnl)) {
            zzamh2.zzdnl = this.zzdnl;
        }
        if (this.zzdnm != 0) {
            zzamh2.zzdnm = this.zzdnm;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzamh2.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzdmr)) {
            zzamh2.zzdmr = this.zzdmr;
        }
    }
}
