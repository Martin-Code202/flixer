package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
public final class zzasp extends zzaa<zzasu> {
    private final Auth.AuthCredentialsOptions zzebk;

    public zzasp(Context context, Looper looper, zzq zzq, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzq, connectionCallbacks, onConnectionFailedListener);
        this.zzebk = authCredentialsOptions;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof zzasu ? (zzasu) queryLocalInterface : new zzasv(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final Bundle zzzu() {
        return this.zzebk == null ? new Bundle() : this.zzebk.zzzu();
    }
}
