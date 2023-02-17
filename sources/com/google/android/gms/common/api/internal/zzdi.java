package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
/* access modifiers changed from: package-private */
public final class zzdi extends Handler {
    private /* synthetic */ zzdg zzfpo;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                PendingResult<?> pendingResult = (PendingResult) message.obj;
                synchronized (this.zzfpo.zzfje) {
                    if (pendingResult == null) {
                        this.zzfpo.zzfph.zzd(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zzcu) {
                        this.zzfpo.zzfph.zzd(((zzcu) pendingResult).getStatus());
                    } else {
                        this.zzfpo.zzfph.zza(pendingResult);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what).toString());
                return;
        }
    }
}
