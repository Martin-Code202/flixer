package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
/* access modifiers changed from: package-private */
public final class zzah extends zzaf implements Handler.Callback {
    private final Context mApplicationContext;
    private final Handler mHandler;
    private final HashMap<zzag, zzai> zzfux = new HashMap<>();
    private final zza zzfuy;
    private final long zzfuz;
    private final long zzfva;

    zzah(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzfuy = zza.zzakz();
        this.zzfuz = 5000;
        this.zzfva = 300000;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.zzfux) {
                    zzag zzag = (zzag) message.obj;
                    zzai zzai = this.zzfux.get(zzag);
                    if (zzai != null && zzai.zzakj()) {
                        if (zzai.isBound()) {
                            zzai.zzgd("GmsClientSupervisor");
                        }
                        this.zzfux.remove(zzag);
                    }
                }
                return true;
            case 1:
                synchronized (this.zzfux) {
                    zzag zzag2 = (zzag) message.obj;
                    zzai zzai2 = this.zzfux.get(zzag2);
                    if (zzai2 != null && zzai2.getState() == 3) {
                        String valueOf = String.valueOf(zzag2);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName componentName = zzai2.getComponentName();
                        if (componentName == null) {
                            componentName = zzag2.getComponentName();
                        }
                        if (componentName == null) {
                            componentName = new ComponentName(zzag2.getPackage(), "unknown");
                        }
                        zzai2.onServiceDisconnected(componentName);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zza(zzag zzag, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzbp.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzfux) {
            zzai zzai = this.zzfux.get(zzag);
            if (zzai != null) {
                this.mHandler.removeMessages(0, zzag);
                if (!zzai.zza(serviceConnection)) {
                    zzai.zza(serviceConnection, str);
                    switch (zzai.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzai.getComponentName(), zzai.getBinder());
                            break;
                        case 2:
                            zzai.zzgc(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(zzag);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                }
            } else {
                zzai = new zzai(this, zzag);
                zzai.zza(serviceConnection, str);
                zzai.zzgc(str);
                this.zzfux.put(zzag, zzai);
            }
            isBound = zzai.isBound();
        }
        return isBound;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzaf
    public final void zzb(zzag zzag, ServiceConnection serviceConnection, String str) {
        zzbp.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzfux) {
            zzai zzai = this.zzfux.get(zzag);
            if (zzai == null) {
                String valueOf = String.valueOf(zzag);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (!zzai.zza(serviceConnection)) {
                String valueOf2 = String.valueOf(zzag);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf2).toString());
            } else {
                zzai.zzb(serviceConnection, str);
                if (zzai.zzakj()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzag), this.zzfuz);
                }
            }
        }
    }
}
