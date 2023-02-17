package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
final class zze implements Runnable {
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ zzd zzmkz;

    zze(zzd zzd, Intent intent) {
        this.zzmkz = zzd;
        this.val$intent = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String action = this.val$intent.getAction();
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.").toString());
        this.zzmkz.finish();
    }
}
