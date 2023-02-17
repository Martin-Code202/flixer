package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Set;
public abstract class zzaa<T extends IInterface> extends zzd<T> implements Api.zze, zzae {
    private final Account zzduy;
    private final Set<Scope> zzecl;
    private final zzq zzfki;

    protected zzaa(Context context, Looper looper, int i, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzaf.zzce(context), GoogleApiAvailability.getInstance(), i, zzq, (GoogleApiClient.ConnectionCallbacks) zzbp.zzu(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzbp.zzu(onConnectionFailedListener));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzaa(Context context, Looper looper, zzaf zzaf, GoogleApiAvailability googleApiAvailability, int i, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzaf, googleApiAvailability, i, connectionCallbacks == null ? null : new zzab(connectionCallbacks), onConnectionFailedListener == null ? null : new zzac(onConnectionFailedListener), zzq.zzajw());
        this.zzfki = zzq;
        this.zzduy = zzq.getAccount();
        Set<Scope> zzajt = zzq.zzajt();
        Set<Scope> zzb = zzb(zzajt);
        for (Scope scope : zzb) {
            if (!zzajt.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.zzecl = zzb;
    }

    @Override // com.google.android.gms.common.internal.zzd
    public final Account getAccount() {
        return this.zzduy;
    }

    @Override // com.google.android.gms.common.internal.zzd
    public zzc[] zzaji() {
        return new zzc[0];
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final Set<Scope> zzajm() {
        return this.zzecl;
    }

    /* access modifiers changed from: protected */
    public final zzq zzake() {
        return this.zzfki;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzb(Set<Scope> set) {
        return set;
    }
}
