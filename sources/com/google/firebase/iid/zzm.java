package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* access modifiers changed from: package-private */
public final class zzm extends Handler {
    private /* synthetic */ zzl zzmlx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzm(zzl zzl, Looper looper) {
        super(looper);
        this.zzmlx = zzl;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzmlx.zzc(message);
    }
}
