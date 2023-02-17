package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* access modifiers changed from: package-private */
public final class zzd {
    final Intent intent;
    private final BroadcastReceiver.PendingResult zzmkw;
    private boolean zzmkx = false;
    private final ScheduledFuture<?> zzmky;

    zzd(Intent intent2, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.intent = intent2;
        this.zzmkw = pendingResult;
        this.zzmky = scheduledExecutorService.schedule(new zze(this, intent2), 9500, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void finish() {
        if (!this.zzmkx) {
            this.zzmkw.finish();
            this.zzmky.cancel(false);
            this.zzmkx = true;
        }
    }
}
