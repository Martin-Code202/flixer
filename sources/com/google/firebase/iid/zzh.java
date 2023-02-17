package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
public final class zzh implements ServiceConnection {
    private final Context zzahy;
    private final Intent zzmld;
    private final ScheduledExecutorService zzmle;
    private final Queue<zzd> zzmlf;
    private zzf zzmlg;
    private boolean zzmlh;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzmlf = new LinkedList();
        this.zzmlh = false;
        this.zzahy = context.getApplicationContext();
        this.zzmld = new Intent(str).setPackage(this.zzahy.getPackageName());
        this.zzmle = scheduledExecutorService;
    }

    private final synchronized void zzbyj() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.zzmlf.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            if (this.zzmlg == null || !this.zzmlg.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", new StringBuilder(39).append("binder is dead. start connection? ").append(!this.zzmlh).toString());
                }
                if (!this.zzmlh) {
                    this.zzmlh = true;
                    try {
                        if (!zza.zzakz().zza(this.zzahy, this.zzmld, this, 65)) {
                            Log.e("EnhancedIntentService", "binding to the service failed");
                            while (!this.zzmlf.isEmpty()) {
                                this.zzmlf.poll().finish();
                            }
                        } else {
                            return;
                        }
                    } catch (SecurityException e) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e);
                    }
                }
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
            }
            this.zzmlg.zza(this.zzmlf.poll());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.zzmlh = false;
            this.zzmlg = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf).toString());
            }
            zzbyj();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf).toString());
        }
        zzbyj();
    }

    public final synchronized void zza(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.zzmlf.add(new zzd(intent, pendingResult, this.zzmle));
        zzbyj();
    }
}
