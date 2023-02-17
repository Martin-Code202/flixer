package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;
public abstract class PendingResult<R extends Result> {

    public interface zza {
        void zzq(Status status);
    }

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit);

    public void zza(zza zza2) {
        throw new UnsupportedOperationException();
    }

    public Integer zzafs() {
        throw new UnsupportedOperationException();
    }
}
