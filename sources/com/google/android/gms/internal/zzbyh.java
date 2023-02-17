package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
/* access modifiers changed from: package-private */
public abstract class zzbyh extends ActivityRecognition.zza<Status> {
    public zzbyh(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.zzs
    public final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
