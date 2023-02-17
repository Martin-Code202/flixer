package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.stats.zza;
public final class zzcfb implements ServiceConnection, zzf, zzg {
    final /* synthetic */ zzceo zziwe;
    private volatile boolean zziwl;
    private volatile zzcbv zziwm;

    protected zzcfb(zzceo zzceo) {
        this.zziwe = zzceo;
    }

    static /* synthetic */ boolean zza(zzcfb zzcfb, boolean z) {
        zzcfb.zziwl = false;
        return false;
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        zzbp.zzfy("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                zzcbo zzcbo = (zzcbo) this.zziwm.zzajk();
                this.zziwm = null;
                this.zziwe.zzaul().zzg(new zzcfe(this, zzcbo));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zziwm = null;
                this.zziwl = false;
            }
        }
        return;
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbp.zzfy("MeasurementServiceConnection.onConnectionFailed");
        zzcbw zzayx = this.zziwe.zzikh.zzayx();
        if (zzayx != null) {
            zzayx.zzayg().zzj("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zziwl = false;
            this.zziwm = null;
        }
        this.zziwe.zzaul().zzg(new zzcfg(this));
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        zzbp.zzfy("MeasurementServiceConnection.onConnectionSuspended");
        this.zziwe.zzaum().zzayj().log("Service connection suspended");
        this.zziwe.zzaul().zzg(new zzcff(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzcbo zzcbo;
        zzbp.zzfy("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zziwl = false;
                this.zziwe.zzaum().zzaye().log("Service connected with null binder");
                return;
            }
            zzcbo zzcbo2 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder == null) {
                        zzcbo = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        zzcbo = queryLocalInterface instanceof zzcbo ? (zzcbo) queryLocalInterface : new zzcbq(iBinder);
                    }
                    zzcbo2 = zzcbo;
                    this.zziwe.zzaum().zzayk().log("Bound to IMeasurementService interface");
                } else {
                    this.zziwe.zzaum().zzaye().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zziwe.zzaum().zzaye().log("Service connect failed to get IMeasurementService");
            }
            if (zzcbo2 == null) {
                this.zziwl = false;
                try {
                    zza.zzakz();
                    this.zziwe.getContext().unbindService(this.zziwe.zzivx);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zziwe.zzaul().zzg(new zzcfc(this, zzcbo2));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbp.zzfy("MeasurementServiceConnection.onServiceDisconnected");
        this.zziwe.zzaum().zzayj().log("Service disconnected");
        this.zziwe.zzaul().zzg(new zzcfd(this, componentName));
    }

    public final void zzazt() {
        this.zziwe.zzuj();
        Context context = this.zziwe.getContext();
        synchronized (this) {
            if (this.zziwl) {
                this.zziwe.zzaum().zzayk().log("Connection attempt already in progress");
            } else if (this.zziwm != null) {
                this.zziwe.zzaum().zzayk().log("Already awaiting connection attempt");
            } else {
                this.zziwm = new zzcbv(context, Looper.getMainLooper(), this, this);
                this.zziwe.zzaum().zzayk().log("Connecting to remote service");
                this.zziwl = true;
                this.zziwm.zzajg();
            }
        }
    }

    public final void zzk(Intent intent) {
        this.zziwe.zzuj();
        Context context = this.zziwe.getContext();
        zza zzakz = zza.zzakz();
        synchronized (this) {
            if (this.zziwl) {
                this.zziwe.zzaum().zzayk().log("Connection attempt already in progress");
                return;
            }
            this.zziwl = true;
            zzakz.zza(context, intent, this.zziwe.zzivx, 129);
        }
    }
}
