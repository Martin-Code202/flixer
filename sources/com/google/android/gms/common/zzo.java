package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzv;
import com.google.android.gms.internal.zzbed;
import java.util.concurrent.atomic.AtomicBoolean;
public class zzo {
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11400000;
    private static boolean zzffv = false;
    private static boolean zzffw = false;
    private static boolean zzffx = false;
    private static boolean zzffy = false;
    static final AtomicBoolean zzffz = new AtomicBoolean();
    private static final AtomicBoolean zzfga = new AtomicBoolean();

    zzo() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zze.zzaex().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzfga.get()) {
            int zzcg = zzbe.zzcg(context);
            if (zzcg == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (zzcg != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException(new StringBuilder(String.valueOf("com.google.android.gms.version").length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(zzcg).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
        boolean z = !zzi.zzcj(context) && !zzi.zzcl(context);
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzp.zzbz(context);
            if (z) {
                zzg zza = zzp.zza(packageInfo, zzj.zzffr);
                if (zza == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                } else if (zzp.zza(packageInfo2, zza) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (zzp.zza(packageInfo2, zzj.zzffr) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (packageInfo2.versionCode / 1000 < GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000) {
                Log.w("GooglePlayServicesUtil", new StringBuilder(77).append("Google Play services out of date.  Requires ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(packageInfo2.versionCode).toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzv.zzb(context, i, str);
    }

    @Deprecated
    public static void zzbj(Context context) {
        int isGooglePlayServicesAvailable = zze.zzaex().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            zze.zzaex();
            Intent zza = zze.zza(context, isGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", new StringBuilder(57).append("GooglePlayServices not available due to error ").append(isGooglePlayServicesAvailable).toString());
            if (zza == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
        }
    }

    @Deprecated
    public static void zzbv(Context context) {
        if (!zzffz.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    @Deprecated
    public static int zzbw(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean zzby(Context context) {
        if (!zzffy) {
            try {
                PackageInfo packageInfo = zzbed.zzcr(context).getPackageInfo("com.google.android.gms", 64);
                if (packageInfo != null) {
                    zzp.zzbz(context);
                    if (zzp.zza(packageInfo, zzj.zzffr[1]) != null) {
                        zzffx = true;
                    }
                }
                zzffx = false;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } finally {
                zzffy = true;
            }
        }
        return zzffx || !"user".equals(Build.TYPE);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzx(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return zzv.zzf(context, i);
    }

    @TargetApi(21)
    static boolean zzx(Context context, String str) {
        Bundle applicationRestrictions;
        boolean equals = str.equals("com.google.android.gms");
        if (zzp.zzalk()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (!applicationInfo.enabled) {
                return false;
            }
            return !(zzp.zzalh() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile")));
        } catch (PackageManager.NameNotFoundException unused2) {
            return false;
        }
    }
}
