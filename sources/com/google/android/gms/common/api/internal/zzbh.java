package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.zzy;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
/* access modifiers changed from: package-private */
public final class zzbh implements ResultCallback<Status> {
    private /* synthetic */ GoogleApiClient zzemr;
    private /* synthetic */ zzbd zzfmu;
    private /* synthetic */ zzda zzfmw;
    private /* synthetic */ boolean zzfmx;

    zzbh(zzbd zzbd, zzda zzda, boolean z, GoogleApiClient googleApiClient) {
        this.zzfmu = zzbd;
        this.zzfmw = zzda;
        this.zzfmx = z;
        this.zzemr = googleApiClient;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        Status status2 = status;
        zzy.zzbl(this.zzfmu.mContext).zzaau();
        if (status2.isSuccess() && this.zzfmu.isConnected()) {
            this.zzfmu.reconnect();
        }
        this.zzfmw.setResult(status2);
        if (this.zzfmx) {
            this.zzemr.disconnect();
        }
    }
}
