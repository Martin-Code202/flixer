package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Iterator;
import java.util.Map;
final class zzau extends zzbb {
    final /* synthetic */ zzar zzflw;
    private final Map<Api.zze, zzat> zzfly;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzau(zzar zzar, Map<Api.zze, zzat> map) {
        super(zzar, null);
        this.zzflw = zzar;
        this.zzfly = map;
    }

    @Override // com.google.android.gms.common.api.internal.zzbb
    public final void zzagz() {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        Iterator<Api.zze> it = this.zzfly.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Api.zze next = it.next();
            if (next.zzaff()) {
                z2 = true;
                if (!(this.zzfly.get(next).zzfjr)) {
                    z = true;
                    break;
                }
            } else {
                z3 = false;
            }
        }
        int isGooglePlayServicesAvailable = z2 ? this.zzflw.zzfkn.isGooglePlayServicesAvailable(this.zzflw.mContext) : 0;
        if (isGooglePlayServicesAvailable == 0 || (!z && !z3)) {
            if (this.zzflw.zzflq) {
                this.zzflw.zzflo.connect();
            }
            for (Api.zze zze : this.zzfly.keySet()) {
                zzat zzat = this.zzfly.get(zze);
                if (!zze.zzaff() || isGooglePlayServicesAvailable == 0) {
                    zze.zza(zzat);
                } else {
                    this.zzflw.zzflg.zza(new zzaw(this, this.zzflw, zzat));
                }
            }
            return;
        }
        this.zzflw.zzflg.zza(new zzav(this, this.zzflw, new ConnectionResult(isGooglePlayServicesAvailable, null)));
    }
}
