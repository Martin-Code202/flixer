package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.zza;
import java.util.HashSet;
import java.util.Set;
/* access modifiers changed from: package-private */
public final class zzai implements ServiceConnection {
    private int mState = 2;
    private IBinder zzftp;
    private ComponentName zzfuv;
    private final Set<ServiceConnection> zzfvb = new HashSet();
    private boolean zzfvc;
    private final zzag zzfvd;
    private /* synthetic */ zzah zzfve;

    public zzai(zzah zzah, zzag zzag) {
        this.zzfve = zzah;
        this.zzfvd = zzag;
    }

    public final IBinder getBinder() {
        return this.zzftp;
    }

    public final ComponentName getComponentName() {
        return this.zzfuv;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzfvc;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzfve.zzfux) {
            this.zzfve.mHandler.removeMessages(1, this.zzfvd);
            this.zzftp = iBinder;
            this.zzfuv = componentName;
            for (ServiceConnection serviceConnection : this.zzfvb) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzfve.zzfux) {
            this.zzfve.mHandler.removeMessages(1, this.zzfvd);
            this.zzftp = null;
            this.zzfuv = componentName;
            for (ServiceConnection serviceConnection : this.zzfvb) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        zza unused = this.zzfve.zzfuy;
        Context unused2 = this.zzfve.mApplicationContext;
        this.zzfvd.zzaki();
        this.zzfvb.add(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzfvb.contains(serviceConnection);
    }

    public final boolean zzakj() {
        return this.zzfvb.isEmpty();
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        zza unused = this.zzfve.zzfuy;
        Context unused2 = this.zzfve.mApplicationContext;
        this.zzfvb.remove(serviceConnection);
    }

    public final void zzgc(String str) {
        this.mState = 3;
        this.zzfvc = this.zzfve.zzfuy.zza(this.zzfve.mApplicationContext, str, this.zzfvd.zzaki(), this, this.zzfvd.zzakh());
        if (this.zzfvc) {
            this.zzfve.mHandler.sendMessageDelayed(this.zzfve.mHandler.obtainMessage(1, this.zzfvd), this.zzfve.zzfva);
            return;
        }
        this.mState = 2;
        try {
            zza unused = this.zzfve.zzfuy;
            this.zzfve.mApplicationContext.unbindService(this);
        } catch (IllegalArgumentException unused2) {
        }
    }

    public final void zzgd(String str) {
        this.zzfve.mHandler.removeMessages(1, this.zzfvd);
        zza unused = this.zzfve.zzfuy;
        this.zzfve.mApplicationContext.unbindService(this);
        this.zzfvc = false;
        this.mState = 2;
    }
}
