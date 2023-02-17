package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaze;
import java.io.IOException;
/* access modifiers changed from: package-private */
public final class zzak extends RemoteMediaClient.zzb {
    private /* synthetic */ RemoteMediaClient zzeud;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzak(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient) {
        super(remoteMediaClient, googleApiClient);
        this.zzeud = remoteMediaClient;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.zzb
    public final void zzb(zzaze zzaze) {
        synchronized (this.zzeud.mLock) {
            try {
                this.zzeud.zzemk.zza(this.zzenr);
            } catch (IOException unused) {
                setResult((zzak) ((RemoteMediaClient.MediaChannelResult) zzb(new Status(2100))));
            }
        }
        return;
    }
}
