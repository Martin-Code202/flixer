package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
/* access modifiers changed from: package-private */
public final class zzh extends Handler {
    private /* synthetic */ zzd zzftk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzh(zzd zzd, Looper looper) {
        super(looper);
        this.zzftk = zzd;
    }

    private static void zza(Message message) {
        ((zzi) message.obj).unregister();
    }

    private static boolean zzb(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzftk.zzfth.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.zzftk.isConnecting()) {
            zza(message);
        } else if (message.what == 4) {
            this.zzftk.zzftf = new ConnectionResult(message.arg2);
            if (!(this.zzftk.zzajn()) || (this.zzftk.zzftg)) {
                ConnectionResult connectionResult = this.zzftk.zzftf != null ? this.zzftk.zzftf : new ConnectionResult(8);
                this.zzftk.zzfsw.zzf(connectionResult);
                this.zzftk.onConnectionFailed(connectionResult);
                return;
            }
            this.zzftk.zza(3, (int) null);
        } else if (message.what == 5) {
            ConnectionResult connectionResult2 = this.zzftk.zzftf != null ? this.zzftk.zzftf : new ConnectionResult(8);
            this.zzftk.zzfsw.zzf(connectionResult2);
            this.zzftk.onConnectionFailed(connectionResult2);
        } else if (message.what == 3) {
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
            this.zzftk.zzfsw.zzf(connectionResult3);
            this.zzftk.onConnectionFailed(connectionResult3);
        } else if (message.what == 6) {
            this.zzftk.zza(5, (int) null);
            if (this.zzftk.zzftb != null) {
                this.zzftk.zzftb.onConnectionSuspended(message.arg2);
            }
            this.zzftk.onConnectionSuspended(message.arg2);
            boolean unused = this.zzftk.zza(5, 1, (int) null);
        } else if (message.what == 2 && !this.zzftk.isConnected()) {
            zza(message);
        } else if (zzb(message)) {
            ((zzi) message.obj).zzajp();
        } else {
            Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        }
    }
}
