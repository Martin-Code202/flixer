package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaze;
import com.google.android.gms.internal.zzbaa;
import java.io.IOException;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public final class zzae extends RemoteMediaClient.zzb {
    private /* synthetic */ JSONObject zzemx;
    private /* synthetic */ RemoteMediaClient zzeud;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(RemoteMediaClient remoteMediaClient, GoogleApiClient googleApiClient, JSONObject jSONObject) {
        super(remoteMediaClient, googleApiClient);
        this.zzeud = remoteMediaClient;
        this.zzemx = jSONObject;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.zzb
    public final void zzb(zzaze zzaze) {
        synchronized (this.zzeud.mLock) {
            try {
                this.zzeud.zzemk.zza(this.zzenr, this.zzemx);
            } catch (zzbaa | IOException unused) {
                setResult((zzae) ((RemoteMediaClient.MediaChannelResult) zzb(new Status(2100))));
            }
        }
        return;
    }
}
