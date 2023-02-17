package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
public final class zzama extends zzh<zzama> {
    public int zzcet;
    public int zzceu;
    private String zzdmm;
    public int zzdmn;
    public int zzdmo;
    public int zzdmp;

    public final String getLanguage() {
        return this.zzdmm;
    }

    public final void setLanguage(String str) {
        this.zzdmm = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.zzdmm);
        hashMap.put("screenColors", Integer.valueOf(this.zzdmn));
        hashMap.put("screenWidth", Integer.valueOf(this.zzcet));
        hashMap.put("screenHeight", Integer.valueOf(this.zzceu));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzdmo));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzdmp));
        return zzh(hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzh] */
    @Override // com.google.android.gms.analytics.zzh
    public final /* synthetic */ void zzb(zzama zzama) {
        zzama zzama2 = zzama;
        if (this.zzdmn != 0) {
            zzama2.zzdmn = this.zzdmn;
        }
        if (this.zzcet != 0) {
            zzama2.zzcet = this.zzcet;
        }
        if (this.zzceu != 0) {
            zzama2.zzceu = this.zzceu;
        }
        if (this.zzdmo != 0) {
            zzama2.zzdmo = this.zzdmo;
        }
        if (this.zzdmp != 0) {
            zzama2.zzdmp = this.zzdmp;
        }
        if (!TextUtils.isEmpty(this.zzdmm)) {
            zzama2.zzdmm = this.zzdmm;
        }
    }
}
