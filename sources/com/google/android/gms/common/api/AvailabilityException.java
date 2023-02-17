package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.zzbp;
import java.util.ArrayList;
public class AvailabilityException extends Exception {
    private final ArrayMap<zzh<?>, ConnectionResult> zzfgi;

    public AvailabilityException(ArrayMap<zzh<?>, ConnectionResult> arrayMap) {
        this.zzfgi = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        zzh<? extends Api.ApiOptions> zzafk = googleApi.zzafk();
        zzbp.zzb(this.zzfgi.get(zzafk) != null, "The given API was not part of the availability request.");
        return this.zzfgi.get(zzafk);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        boolean z = true;
        ArrayList arrayList = new ArrayList();
        for (zzh<?> zzh : this.zzfgi.keySet()) {
            ConnectionResult connectionResult = this.zzfgi.get(zzh);
            if (connectionResult.isSuccess()) {
                z = false;
            }
            String zzafv = zzh.zzafv();
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(zzafv).length() + 2).append(zzafv).append(": ").append(valueOf).toString());
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }

    public final ArrayMap<zzh<?>, ConnectionResult> zzafh() {
        return this.zzfgi;
    }
}
