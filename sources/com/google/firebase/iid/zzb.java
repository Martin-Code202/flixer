package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public abstract class zzb extends Service {
    private final Object mLock = new Object();
    final ExecutorService zzirz = Executors.newSingleThreadExecutor();
    private Binder zzmkr;
    private int zzmks;
    private int zzmkt = 0;

    /* access modifiers changed from: private */
    public final void zzm(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.mLock) {
            this.zzmkt--;
            if (this.zzmkt == 0) {
                stopSelfResult(this.zzmks);
            }
        }
    }

    public abstract void handleIntent(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzmkr == null) {
            this.zzmkr = new zzf(this);
        }
        return this.zzmkr;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.mLock) {
            this.zzmks = i2;
            this.zzmkt++;
        }
        Intent zzn = zzn(intent);
        if (zzn == null) {
            zzm(intent);
            return 2;
        } else if (zzo(zzn)) {
            zzm(intent);
            return 2;
        } else {
            this.zzirz.execute(new zzc(this, zzn, intent));
            return 3;
        }
    }

    public Intent zzn(Intent intent) {
        return intent;
    }

    public boolean zzo(Intent intent) {
        return false;
    }
}
