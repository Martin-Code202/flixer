package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzad implements Handler.Callback {
    private final Handler mHandler;
    private final Object mLock = new Object();
    private final zzae zzful;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzfum = new ArrayList<>();
    private ArrayList<GoogleApiClient.ConnectionCallbacks> zzfun = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzfuo = new ArrayList<>();
    private volatile boolean zzfup = false;
    private final AtomicInteger zzfuq = new AtomicInteger(0);
    private boolean zzfur = false;

    public zzad(Looper looper, zzae zzae) {
        this.zzful = zzae;
        this.mHandler = new Handler(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.mLock) {
                if (this.zzfup && this.zzful.isConnected() && this.zzfum.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzful.zzaeh());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        return false;
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzbp.zzu(connectionCallbacks);
        synchronized (this.mLock) {
            if (this.zzfum.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.zzfum.add(connectionCallbacks);
            }
        }
        if (this.zzful.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbp.zzu(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (this.zzfuo.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.zzfuo.add(onConnectionFailedListener);
            }
        }
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbp.zzu(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (!this.zzfuo.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public final void zzakf() {
        this.zzfup = false;
        this.zzfuq.incrementAndGet();
    }

    public final void zzakg() {
        this.zzfup = true;
    }

    public final void zzce(int i) {
        zzbp.zza(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            this.zzfur = true;
            ArrayList arrayList = new ArrayList(this.zzfum);
            int i2 = this.zzfuq.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.zzfup || this.zzfuq.get() != i2) {
                    break;
                } else if (this.zzfum.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzfun.clear();
            this.zzfur = false;
        }
    }

    public final void zzk(Bundle bundle) {
        zzbp.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.mLock) {
            zzbp.zzbg(!this.zzfur);
            this.mHandler.removeMessages(1);
            this.zzfur = true;
            zzbp.zzbg(this.zzfun.size() == 0);
            ArrayList arrayList = new ArrayList(this.zzfum);
            int i = this.zzfuq.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.zzfup || !this.zzful.isConnected() || this.zzfuq.get() != i) {
                    break;
                } else if (!this.zzfun.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzfun.clear();
            this.zzfur = false;
        }
    }

    public final void zzk(ConnectionResult connectionResult) {
        zzbp.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            ArrayList arrayList = new ArrayList(this.zzfuo);
            int i = this.zzfuq.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                if (this.zzfup && this.zzfuq.get() == i) {
                    if (this.zzfuo.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
