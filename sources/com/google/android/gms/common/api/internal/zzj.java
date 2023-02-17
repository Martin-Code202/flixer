package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;
public final class zzj {
    private final ArrayMap<zzh<?>, ConnectionResult> zzfgi = new ArrayMap<>();
    private final TaskCompletionSource<Void> zzfio = new TaskCompletionSource<>();
    private int zzfip;
    private boolean zzfiq = false;

    public zzj(Iterable<? extends GoogleApi<?>> iterable) {
        Iterator<? extends GoogleApi<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.zzfgi.put(((GoogleApi) it.next()).zzafk(), null);
        }
        this.zzfip = this.zzfgi.keySet().size();
    }

    public final Task<Void> getTask() {
        return this.zzfio.getTask();
    }

    public final void zza(zzh<?> zzh, ConnectionResult connectionResult) {
        this.zzfgi.put(zzh, connectionResult);
        this.zzfip--;
        if (!connectionResult.isSuccess()) {
            this.zzfiq = true;
        }
        if (this.zzfip != 0) {
            return;
        }
        if (this.zzfiq) {
            this.zzfio.setException(new AvailabilityException(this.zzfgi));
            return;
        }
        this.zzfio.setResult(null);
    }

    public final Set<zzh<?>> zzafx() {
        return this.zzfgi.keySet();
    }

    public final void zzafy() {
        this.zzfio.setResult(null);
    }
}
