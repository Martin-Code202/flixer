package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.internal.zzbp;
final class zzck extends Handler {
    private /* synthetic */ zzcj zzfov;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzbp.zzbh(message.what == 1);
        this.zzfov.zzb((zzcm) message.obj);
    }
}
