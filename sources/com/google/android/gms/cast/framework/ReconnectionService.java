package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzavl;
import com.google.android.gms.internal.zzazx;
public class ReconnectionService extends Service {
    private static final zzazx zzejc = new zzazx("ReconnectionService");
    private zzr zzepq;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.zzepq.onBind(intent);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onBind", zzr.class.getSimpleName());
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        this.zzepq = zzavl.zza(this, sharedInstance.getSessionManager().zzabu(), sharedInstance.zzabt().zzabu());
        try {
            this.zzepq.onCreate();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onCreate", zzr.class.getSimpleName());
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.zzepq.onDestroy();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onDestroy", zzr.class.getSimpleName());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return this.zzepq.onStartCommand(intent, i, i2);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onStartCommand", zzr.class.getSimpleName());
            return 1;
        }
    }
}
