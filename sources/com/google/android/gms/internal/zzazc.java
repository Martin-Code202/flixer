package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
public final class zzazc extends zzaa<zzazu> {
    public zzazc(Context context, Looper looper, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 161, zzq, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastService");
        return queryLocalInterface instanceof zzazu ? (zzazu) queryLocalInterface : new zzazv(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.cast.internal.ICastService";
    }
}
