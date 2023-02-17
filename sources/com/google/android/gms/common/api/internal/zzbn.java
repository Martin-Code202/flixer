package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* access modifiers changed from: package-private */
public final class zzbn extends Handler {
    private /* synthetic */ zzbl zzfnh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbn(zzbl zzbl, Looper looper) {
        super(looper);
        this.zzfnh = zzbl;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((zzbm) message.obj).zzc(this.zzfnh);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GACStateManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return;
        }
    }
}
