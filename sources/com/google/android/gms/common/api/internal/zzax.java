package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
final class zzax extends zzbb {
    private /* synthetic */ zzar zzflw;
    private final ArrayList<Api.zze> zzfmc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzax(zzar zzar, ArrayList<Api.zze> arrayList) {
        super(zzar, null);
        this.zzflw = zzar;
        this.zzfmc = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zzbb
    public final void zzagz() {
        this.zzflw.zzflg.zzfjt.zzfmn = this.zzflw.zzahf();
        ArrayList<Api.zze> arrayList = this.zzfmc;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.zze zze = arrayList.get(i);
            i++;
            zze.zza(this.zzflw.zzfls, this.zzflw.zzflg.zzfjt.zzfmn);
        }
    }
}
