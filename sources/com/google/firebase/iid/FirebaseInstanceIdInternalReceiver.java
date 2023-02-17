package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.zzp;
public final class FirebaseInstanceIdInternalReceiver extends WakefulBroadcastReceiver {
    private static boolean zzhqx = false;
    private static zzh zzmln;
    private static zzh zzmlo;

    static synchronized zzh zzag(Context context, String str) {
        synchronized (FirebaseInstanceIdInternalReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (zzmlo == null) {
                    zzmlo = new zzh(context, str);
                }
                return zzmlo;
            }
            if (zzmln == null) {
                zzmln = new zzh(context, str);
            }
            return zzmln;
        }
    }

    static boolean zzel(Context context) {
        return zzp.isAtLeastO() && context.getApplicationInfo().targetSdkVersion > 25;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (!(parcelableExtra instanceof Intent)) {
                Log.e("FirebaseInstanceId", "Missing or invalid wrapped intent");
                return;
            }
            Intent intent2 = (Intent) parcelableExtra;
            if (zzel(context)) {
                zzag(context, intent.getAction()).zza(intent2, goAsync());
            } else {
                zzq.zzbys().zza(context, intent.getAction(), intent2);
            }
        }
    }
}
