package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.internal.zzbye;
import com.google.android.gms.internal.zzbzu;
public class ActivityRecognition {
    public static final Api<Object> API = new Api<>("ActivityRecognition.API", zzdwp, zzdwo);
    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi = new zzbye();
    private static final Api.zzf<zzbzu> zzdwo = new Api.zzf<>();
    private static final Api.zza<zzbzu, Object> zzdwp = new zza();

    public static abstract class zza<R extends Result> extends zzm<R, zzbzu> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.API, googleApiClient);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.location.ActivityRecognition$zza<R extends com.google.android.gms.common.api.Result> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
        public final /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((zza<R>) ((Result) obj));
        }
    }
}
