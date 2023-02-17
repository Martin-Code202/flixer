package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
/* access modifiers changed from: package-private */
public final class zzl<TResult> {
    private final Object mLock = new Object();
    private Queue<zzk<TResult>> zzkgf;
    private boolean zzkgg;

    zzl() {
    }

    public final void zza(zzk<TResult> zzk) {
        synchronized (this.mLock) {
            if (this.zzkgf == null) {
                this.zzkgf = new ArrayDeque();
            }
            this.zzkgf.add(zzk);
        }
    }

    public final void zzb(Task<TResult> task) {
        zzk<TResult> poll;
        synchronized (this.mLock) {
            if (this.zzkgf != null && !this.zzkgg) {
                this.zzkgg = true;
            } else {
                return;
            }
        }
        while (true) {
            synchronized (this.mLock) {
                poll = this.zzkgf.poll();
                if (poll == null) {
                    this.zzkgg = false;
                    return;
                }
            }
            poll.onComplete(task);
        }
    }
}
