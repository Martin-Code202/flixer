package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbp;
public final class zzccn {
    private final zzccp zzirp;

    public zzccn(zzccp zzccp) {
        zzbp.zzu(zzccp);
        this.zzirp = zzccp;
    }

    public static boolean zzj(Context context, boolean z) {
        zzbp.zzu(context);
        return zzcfw.zza(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
    }

    public final void onReceive(Context context, Intent intent) {
        zzccw zzdn = zzccw.zzdn(context);
        zzcbw zzaum = zzdn.zzaum();
        if (intent == null) {
            zzaum.zzayg().log("Receiver called with null intent");
            return;
        }
        zzcax.zzawl();
        String action = intent.getAction();
        zzaum.zzayk().zzj("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzcfh.zzk(context, false);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            this.zzirp.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzaum.zzayk().log("Install referrer extras are null");
                return;
            }
            zzaum.zzayi().zzj("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            Bundle zzp = zzdn.zzaui().zzp(Uri.parse(stringExtra));
            if (zzp == null) {
                zzaum.zzayk().log("No campaign defined in install referrer broadcast");
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
            if (longExtra == 0) {
                zzaum.zzayg().log("Install referrer is missing timestamp");
            }
            zzdn.zzaul().zzg(new zzcco(this, zzdn, longExtra, zzp, context, zzaum));
        }
    }
}
