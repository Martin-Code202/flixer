package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
/* access modifiers changed from: package-private */
public abstract class zzbcx<R extends Result> extends zzm<R, zzbcz> {
    public zzbcx(GoogleApiClient googleApiClient) {
        super(zzbcr.API, googleApiClient);
    }
}
