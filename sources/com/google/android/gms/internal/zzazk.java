package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
final class zzazk implements Runnable {
    private /* synthetic */ String zzeib;
    private /* synthetic */ zzaze zzfbq;
    private /* synthetic */ String zzfbu;

    zzazk(zzazg zzazg, zzaze zzaze, String str, String str2) {
        this.zzfbq = zzaze;
        this.zzeib = str;
        this.zzfbu = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cast.MessageReceivedCallback messageReceivedCallback;
        synchronized (this.zzfbq.zzfau) {
            messageReceivedCallback = (Cast.MessageReceivedCallback) this.zzfbq.zzfau.get(this.zzeib);
        }
        if (messageReceivedCallback != null) {
            messageReceivedCallback.onMessageReceived(this.zzfbq.zzepc, this.zzeib, this.zzfbu);
        } else {
            zzaze.zzejm.zzb("Discarded message for unknown namespace '%s'", this.zzeib);
        }
    }
}
