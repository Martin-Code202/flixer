package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
public interface zzbk {
    void begin();

    void connect();

    boolean disconnect();

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);

    void zza(ConnectionResult connectionResult, Api<?> api, boolean z);

    <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t);

    <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t);
}
