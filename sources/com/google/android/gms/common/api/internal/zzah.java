package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
public final class zzah {
    private final Map<zzs<?>, Boolean> zzfkz = Collections.synchronizedMap(new WeakHashMap());
    private final Map<TaskCompletionSource<?>, Boolean> zzfla = Collections.synchronizedMap(new WeakHashMap());

    private final void zza(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.zzfkz) {
            hashMap = new HashMap(this.zzfkz);
        }
        synchronized (this.zzfla) {
            hashMap2 = new HashMap(this.zzfla);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((zzs) entry.getKey()).zzu(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzs<? extends Result> zzs, boolean z) {
        this.zzfkz.put(zzs, Boolean.valueOf(z));
        zzs.zza(new zzai(this, zzs));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzags() {
        return !this.zzfkz.isEmpty() || !this.zzfla.isEmpty();
    }

    public final void zzagt() {
        zza(false, zzbp.zzfnj);
    }

    public final void zzagu() {
        zza(true, zzdj.zzfpp);
    }
}
