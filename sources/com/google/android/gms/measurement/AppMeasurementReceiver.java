package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.zzccn;
import com.google.android.gms.internal.zzccp;
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzccp {
    private zzccn zzikr;

    @Override // com.google.android.gms.internal.zzccp
    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zzikr == null) {
            this.zzikr = new zzccn(this);
        }
        this.zzikr.onReceive(context, intent);
    }
}
