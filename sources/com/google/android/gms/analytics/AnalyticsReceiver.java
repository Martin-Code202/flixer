package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.zzaou;
public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzaou zzdjl;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zzdjl == null) {
            this.zzdjl = new zzaou();
        }
        zzaou.onReceive(context, intent);
    }
}
