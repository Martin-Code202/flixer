package com.google.android.gms.cast.framework.media;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzavl;
import com.google.android.gms.internal.zzazx;
public class MediaNotificationService extends Service {
    private static final zzazx zzejc = new zzazx("MediaNotificationService");
    private zzd zzesk;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.zzesk.onBind(intent);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onBind", zzd.class.getSimpleName());
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        this.zzesk = zzavl.zza(this, CastContext.getSharedInstance(this).zzabu(), zzn.zzw(null), CastContext.getSharedInstance(this).getCastOptions().getCastMediaOptions());
        try {
            this.zzesk.onCreate();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onCreate", zzd.class.getSimpleName());
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.zzesk.onDestroy();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onDestroy", zzd.class.getSimpleName());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return this.zzesk.onStartCommand(intent, i, i2);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "onStartCommand", zzd.class.getSimpleName());
            return 1;
        }
    }
}
