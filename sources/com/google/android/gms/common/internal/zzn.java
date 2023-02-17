package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
public final class zzn extends zze {
    private /* synthetic */ zzd zzftk;
    private IBinder zzfto;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzn(zzd zzd, int i, IBinder iBinder, Bundle bundle) {
        super(zzd, i, bundle);
        this.zzftk = zzd;
        this.zzfto = iBinder;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    public final boolean zzajo() {
        try {
            String interfaceDescriptor = this.zzfto.getInterfaceDescriptor();
            if (!this.zzftk.zzhd().equals(interfaceDescriptor)) {
                String zzhd = this.zzftk.zzhd();
                Log.e("GmsClient", new StringBuilder(String.valueOf(interfaceDescriptor).length() + String.valueOf(zzhd).length() + 34).append("service descriptor mismatch: ").append(zzhd).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            }
            IInterface zzd = this.zzftk.zzd(this.zzfto);
            if (zzd == null) {
                return false;
            }
            if (!(this.zzftk.zza(2, 4, (int) zzd)) && !(this.zzftk.zza(3, 4, (int) zzd))) {
                return false;
            }
            this.zzftk.zzftf = null;
            Bundle zzaeh = this.zzftk.zzaeh();
            if (this.zzftk.zzftb == null) {
                return true;
            }
            this.zzftk.zzftb.onConnected(zzaeh);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    public final void zzj(ConnectionResult connectionResult) {
        if (this.zzftk.zzftc != null) {
            this.zzftk.zzftc.onConnectionFailed(connectionResult);
        }
        this.zzftk.onConnectionFailed(connectionResult);
    }
}
