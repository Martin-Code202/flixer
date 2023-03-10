package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.zzccn;
import com.google.android.gms.internal.zzccp;
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzccp {
    private zzccn zzikr;

    @Override // com.google.android.gms.internal.zzccp
    public final void doStartService(Context context, Intent intent) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zzikr == null) {
            this.zzikr = new zzccn(this);
        }
        this.zzikr.onReceive(context, intent);
    }
}
