package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
/* access modifiers changed from: package-private */
public final class zzan implements RemoteMediaClient.MediaChannelResult {
    private /* synthetic */ Status zzeil;

    zzan(RemoteMediaClient.zzb zzb, Status status) {
        this.zzeil = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzeil;
    }
}
