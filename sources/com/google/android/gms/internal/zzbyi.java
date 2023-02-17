package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
public class zzbyi extends zzaa<zzbzk> {
    private final String zzhyz;
    protected final zzcae<zzbzk> zzhza = new zzbyj(this);

    public zzbyi(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, zzq zzq) {
        super(context, looper, 23, zzq, connectionCallbacks, onConnectionFailedListener);
        this.zzhyz = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzbzk ? (zzbzk) queryLocalInterface : new zzbzl(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final Bundle zzzu() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzhyz);
        return bundle;
    }
}
