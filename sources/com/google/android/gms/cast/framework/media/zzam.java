package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbac;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public final class zzam implements zzbac {
    private /* synthetic */ RemoteMediaClient zzeuh;
    private /* synthetic */ RemoteMediaClient.zzb zzeui;

    zzam(RemoteMediaClient.zzb zzb, RemoteMediaClient remoteMediaClient) {
        this.zzeui = zzb;
        this.zzeuh = remoteMediaClient;
    }

    @Override // com.google.android.gms.internal.zzbac
    public final void zza(long j, int i, Object obj) {
        JSONObject jSONObject = null;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        }
        this.zzeui.setResult((RemoteMediaClient.zzb) new RemoteMediaClient.zzc(new Status(i), jSONObject));
    }

    @Override // com.google.android.gms.internal.zzbac
    public final void zzx(long j) {
        this.zzeui.setResult((RemoteMediaClient.zzb) ((RemoteMediaClient.MediaChannelResult) this.zzeui.zzb(new Status(2103))));
    }
}
