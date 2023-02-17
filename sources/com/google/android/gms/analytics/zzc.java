package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
final class zzc implements Runnable {
    private /* synthetic */ BroadcastReceiver.PendingResult zzdjq;

    zzc(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.zzdjq = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzdjq != null) {
            this.zzdjq.finish();
        }
    }
}
