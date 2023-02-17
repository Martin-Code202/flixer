package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.netflix.mediaclient.android.activity.NetflixActivity;
final class zzd {
    private static void zzb(Context context, String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra(NetflixActivity.EXTRA_FROM);
        String str2 = (stringExtra3 == null || !stringExtra3.startsWith("/topics/")) ? null : stringExtra3;
        if (str2 != null) {
            bundle.putString("_nt", str2);
        }
        try {
            bundle.putInt("_nmt", Integer.valueOf(intent.getStringExtra("google.c.a.ts")).intValue());
        } catch (NumberFormatException e) {
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.valueOf(intent.getStringExtra("google.c.a.udt")).intValue());
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            Log.d("FirebaseMessaging", new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(str).length() + 22).append("Sending event=").append(str).append(" params=").append(valueOf).toString());
        }
        AppMeasurement zzcs = zzcs(context);
        if (zzcs != null) {
            zzcs.logEventInternal("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    private static AppMeasurement zzcs(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public static void zzg(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("google.c.a.abt");
        if (stringExtra != null) {
            zzc.zza(context, "fcm", Base64.decode(stringExtra, 0), new zzb(), 1);
        }
        zzb(context, "_nr", intent);
    }

    public static void zzh(Context context, Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                AppMeasurement zzcs = zzcs(context);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (zzcs != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    zzcs.setUserPropertyInternal("fcm", "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(NetflixActivity.EXTRA_SOURCE, "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    zzcs.logEventInternal("fcm", "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        zzb(context, "_no", intent);
    }

    public static void zzi(Context context, Intent intent) {
        zzb(context, "_nd", intent);
    }

    public static void zzj(Context context, Intent intent) {
        zzb(context, "_nf", intent);
    }
}
