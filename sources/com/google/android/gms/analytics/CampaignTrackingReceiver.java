package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzamu;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzaon;
import com.google.android.gms.internal.zzapd;
public class CampaignTrackingReceiver extends BroadcastReceiver {
    private static Boolean zzdjp;

    public static boolean zzbe(Context context) {
        zzbp.zzu(context);
        if (zzdjp != null) {
            return zzdjp.booleanValue();
        }
        boolean zza = zzapd.zza(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        zzdjp = Boolean.valueOf(zza);
        return zza;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        zzamu zzbg = zzamu.zzbg(context);
        zzaon zzvy = zzbg.zzvy();
        if (intent == null) {
            zzvy.zzdp("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zzvy.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zzvy.zzdp("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        zzt(context, stringExtra);
        int zzxw = zzanv.zzxw();
        if (stringExtra.length() <= zzxw) {
            str = stringExtra;
        } else {
            zzvy.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzxw));
            str = stringExtra.substring(0, zzxw);
        }
        zzbg.zzwc().zza(str, (Runnable) new zzc(this, goAsync()));
    }

    /* access modifiers changed from: protected */
    public void zzt(Context context, String str) {
    }
}
