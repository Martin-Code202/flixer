package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
final class zzal implements ResultCallback<Status> {
    private final long zzenp;
    private /* synthetic */ RemoteMediaClient.zza zzeuf;

    zzal(RemoteMediaClient.zza zza, long j) {
        this.zzeuf = zza;
        this.zzenp = j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        Status status2 = status;
        if (!status2.isSuccess()) {
            RemoteMediaClient.this.zzemk.zzc(this.zzenp, status2.getStatusCode());
        }
    }
}
