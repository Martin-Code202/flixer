package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
public final class zzl implements ServiceConnection {
    private /* synthetic */ zzd zzftk;
    private final int zzftn;

    public zzl(zzd zzd, int i) {
        this.zzftk = zzd;
        this.zzftn = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzax zzax;
        if (iBinder == null) {
            this.zzftk.zzcd(16);
            return;
        }
        synchronized (this.zzftk.zzfsu) {
            zzd zzd = this.zzftk;
            if (iBinder == null) {
                zzax = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                zzax = (queryLocalInterface == null || !(queryLocalInterface instanceof zzax)) ? new zzay(iBinder) : (zzax) queryLocalInterface;
            }
            zzd.zzfsv = zzax;
        }
        this.zzftk.zza(0, (Bundle) null, this.zzftn);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzftk.zzfsu) {
            this.zzftk.zzfsv = null;
        }
        this.zzftk.mHandler.sendMessage(this.zzftk.mHandler.obtainMessage(6, this.zzftn, 1));
    }
}
