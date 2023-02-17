package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.netflix.mediaclient.android.activity.NetflixActivity;
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        String str = null;
        String stringExtra2 = intent.getStringExtra(NetflixActivity.EXTRA_FROM);
        if ("google.com/iid".equals(stringExtra2) || "gcm.googleapis.com/refresh".equals(stringExtra2)) {
            str = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            str = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
        }
        int i = -1;
        if (str != null) {
            if (FirebaseInstanceIdInternalReceiver.zzel(context)) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                FirebaseInstanceIdInternalReceiver.zzag(context, str).zza(intent, goAsync());
                i = -1;
            } else {
                i = zzq.zzbys().zza(context, str, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(i);
        }
    }
}
