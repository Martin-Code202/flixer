package com.google.android.gms.common.internal;

import android.util.Log;
public abstract class zzi<TListener> {
    private TListener mListener;
    private /* synthetic */ zzd zzftk;
    private boolean zzftl = false;

    public zzi(zzd zzd, TListener tlistener) {
        this.zzftk = zzd;
        this.mListener = tlistener;
    }

    public final void removeListener() {
        synchronized (this) {
            this.mListener = null;
        }
    }

    public final void unregister() {
        removeListener();
        synchronized (this.zzftk.zzfsy) {
            this.zzftk.zzfsy.remove(this);
        }
    }

    public final void zzajp() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.mListener;
            if (this.zzftl) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (tlistener != null) {
            try {
                zzs(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzftl = true;
        }
        unregister();
    }

    /* access modifiers changed from: protected */
    public abstract void zzs(TListener tlistener);
}
