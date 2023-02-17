package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* access modifiers changed from: package-private */
public final class zzbi extends Handler {
    private /* synthetic */ zzbd zzfmu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzbd zzbd, Looper looper) {
        super(looper);
        this.zzfmu = zzbd;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.zzfmu.zzahh();
                return;
            case 2:
                this.zzfmu.resume();
                return;
            default:
                Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return;
        }
    }
}
