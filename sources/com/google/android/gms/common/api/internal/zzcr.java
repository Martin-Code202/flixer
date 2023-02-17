package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;
public abstract class zzcr<A extends Api.zzb, L> {
    private final zzcj<L> zzfpb;

    public final void zzaim() {
        this.zzfpb.clear();
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(A a, TaskCompletionSource<Void> taskCompletionSource);
}
