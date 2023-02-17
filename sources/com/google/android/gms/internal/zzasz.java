package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
public final class zzasz extends zzaa<zzatc> {
    private final Bundle zzdzw;

    public zzasz(Context context, Looper looper, zzq zzq, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzq, connectionCallbacks, onConnectionFailedListener);
        if (zzf == null) {
            this.zzdzw = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public final boolean zzaac() {
        zzq zzake = zzake();
        return !TextUtils.isEmpty(zzake.getAccountName()) && !zzake.zzc(zzd.API).isEmpty();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof zzatc ? (zzatc) queryLocalInterface : new zzatd(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.auth.service.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final Bundle zzzu() {
        return this.zzdzw;
    }
}
