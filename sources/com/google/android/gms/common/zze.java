package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzbed;
public class zze {
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zze zzffj = new zze();

    zze() {
    }

    public static Intent zza(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !zzi.zzcj(context)) ? zzaj.zzu("com.google.android.gms", zzw(context, str)) : zzaj.zzakk();
            case 3:
                return zzaj.zzge("com.google.android.gms");
            default:
                return null;
        }
    }

    public static zze zzaex() {
        return zzffj;
    }

    public static void zzbv(Context context) {
        zzo.zzbv(context);
    }

    public static boolean zze(Context context, int i) {
        return zzo.zze(context, i);
    }

    private static String zzw(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(zzbed.zzcr(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, null);
    }

    public String getErrorString(int i) {
        return zzo.getErrorString(i);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = zzo.isGooglePlayServicesAvailable(context);
        if (zzo.zze(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int i) {
        return zzo.isUserRecoverableError(i);
    }

    public final PendingIntent zza(Context context, int i, int i2, String str) {
        Intent zza = zza(context, i, str);
        if (zza == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, zza, 268435456);
    }

    @Deprecated
    public final Intent zzbn(int i) {
        return zza(null, i, null);
    }
}
