package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
public final class zzarl extends zzaa<zzarm> {
    public zzarl(Context context, Looper looper, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 74, zzq, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
        return queryLocalInterface instanceof zzarm ? (zzarm) queryLocalInterface : new zzarn(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.auth.api.accountactivationstate.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
    }
}
