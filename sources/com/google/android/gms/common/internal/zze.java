package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
abstract class zze extends zzi<Boolean> {
    private int statusCode;
    private Bundle zzftj;
    private /* synthetic */ zzd zzftk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zze(zzd zzd, int i, Bundle bundle) {
        super(zzd, true);
        this.zzftk = zzd;
        this.statusCode = i;
        this.zzftj = bundle;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzajo();

    /* access modifiers changed from: protected */
    public abstract void zzj(ConnectionResult connectionResult);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public final /* synthetic */ void zzs(Boolean bool) {
        if (bool == null) {
            this.zzftk.zza(1, (int) null);
            return;
        }
        switch (this.statusCode) {
            case 0:
                if (!zzajo()) {
                    this.zzftk.zza(1, (int) null);
                    zzj(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                this.zzftk.zza(1, (int) null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.zzftk.zza(1, (int) null);
                PendingIntent pendingIntent = null;
                if (this.zzftj != null) {
                    pendingIntent = (PendingIntent) this.zzftj.getParcelable("pendingIntent");
                }
                zzj(new ConnectionResult(this.statusCode, pendingIntent));
                return;
        }
    }
}
