package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzehf;
import com.google.android.gms.internal.zzeie;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public final class zzc {
    private static Bundle zza(zzeie zzeie) {
        return zzay(zzeie.zznkh, zzeie.zznki);
    }

    private static Object zza(zzeie zzeie, String str, zzb zzb) {
        Object obj = null;
        try {
            Class<?> cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle zza = zza(zzeie);
            obj = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            cls.getField("mOrigin").set(obj, str);
            cls.getField("mCreationTimestamp").set(obj, Long.valueOf(zzeie.zznkj));
            cls.getField("mName").set(obj, zzeie.zznkh);
            cls.getField("mValue").set(obj, zzeie.zznki);
            cls.getField("mTriggerEventName").set(obj, TextUtils.isEmpty(zzeie.zznkk) ? null : zzeie.zznkk);
            cls.getField("mTimedOutEventName").set(obj, !TextUtils.isEmpty(zzeie.zznkp) ? zzeie.zznkp : zzb.zzbnt());
            cls.getField("mTimedOutEventParams").set(obj, zza);
            cls.getField("mTriggerTimeout").set(obj, Long.valueOf(zzeie.zznkl));
            cls.getField("mTriggeredEventName").set(obj, !TextUtils.isEmpty(zzeie.zznkn) ? zzeie.zznkn : zzb.zzbns());
            cls.getField("mTriggeredEventParams").set(obj, zza);
            cls.getField("mTimeToLive").set(obj, Long.valueOf(zzeie.zzgcb));
            cls.getField("mExpiredEventName").set(obj, !TextUtils.isEmpty(zzeie.zznkq) ? zzeie.zznkq : zzb.zzbnu());
            cls.getField("mExpiredEventParams").set(obj, zza);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
        }
        return obj;
    }

    private static String zza(zzeie zzeie, zzb zzb) {
        return (zzeie == null || TextUtils.isEmpty(zzeie.zznko)) ? zzb.zzbnv() : zzeie.zznko;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.Object> zza(com.google.android.gms.measurement.AppMeasurement r7, java.lang.String r8) {
        /*
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r0 = com.google.android.gms.measurement.AppMeasurement.class
            java.lang.String r1 = "getConditionalUserProperties"
            r2 = 2
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 0
            r2[r4] = r3     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 1
            r2[r4] = r3     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            java.lang.reflect.Method r6 = r0.getDeclaredMethod(r1, r2)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            r0 = 1
            r6.setAccessible(r0)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            r1 = 0
            r0[r1] = r8     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            java.lang.String r1 = ""
            r2 = 1
            r0[r2] = r1     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            java.lang.Object r0 = r6.invoke(r7, r0)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0031 }
            r5 = r0
            goto L_0x0039
        L_0x0031:
            r6 = move-exception
            java.lang.String r0 = "FirebaseAbtUtil"
            java.lang.String r1 = "Could not complete the operation due to an internal error."
            android.util.Log.e(r0, r1, r6)
        L_0x0039:
            java.lang.String r0 = "FirebaseAbtUtil"
            r1 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = "FirebaseAbtUtil"
            int r6 = r5.size()
            java.lang.String r1 = java.lang.String.valueOf(r8)
            int r1 = r1.length()
            int r2 = r1 + 55
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            java.lang.String r2 = "Number of currently set _Es for origin: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " is "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0072:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.zza(com.google.android.gms.measurement.AppMeasurement, java.lang.String):java.util.List");
    }

    private static void zza(Context context, String str, String str2, String str3, String str4) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String valueOf = String.valueOf(str);
            Log.v("FirebaseAbtUtil", valueOf.length() != 0 ? "_CE(experimentId) called by ".concat(valueOf) : new String("_CE(experimentId) called by "));
        }
        if (zzeh(context)) {
            AppMeasurement zzcs = zzcs(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", String.class, String.class, Bundle.class);
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str3).length() + String.valueOf(str2).length() + 17).append("Clearing _E: [").append(str2).append(", ").append(str3).append("]").toString());
                }
                declaredMethod.invoke(zzcs, str2, str4, zzay(str2, str3));
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0239, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x023a, code lost:
        android.util.Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0241, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0239 A[ExcHandler: ClassNotFoundException | IllegalAccessException | NoSuchFieldException (r8v0 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:51:0x0235] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(android.content.Context r22, java.lang.String r23, byte[] r24, com.google.firebase.messaging.zzb r25, int r26) {
        /*
        // Method dump skipped, instructions count: 578
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.zza(android.content.Context, java.lang.String, byte[], com.google.firebase.messaging.zzb, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x02a2, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x02a3, code lost:
        android.util.Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x02aa, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x02a2 A[ExcHandler: ClassNotFoundException | IllegalAccessException | NoSuchFieldException (r4v0 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:18:0x0111] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.measurement.AppMeasurement r20, android.content.Context r21, java.lang.String r22, com.google.android.gms.internal.zzeie r23, com.google.firebase.messaging.zzb r24, int r25) {
        /*
        // Method dump skipped, instructions count: 683
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.zza(com.google.android.gms.measurement.AppMeasurement, android.content.Context, java.lang.String, com.google.android.gms.internal.zzeie, com.google.firebase.messaging.zzb, int):void");
    }

    private static zzeie zzak(byte[] bArr) {
        try {
            return zzeie.zzaz(bArr);
        } catch (zzehf unused) {
            return null;
        }
    }

    private static String zzar(Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    private static String zzas(Object obj) {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }

    private static Bundle zzay(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    private static int zzb(AppMeasurement appMeasurement, String str) {
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", String.class);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appMeasurement, str)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        }
    }

    private static AppMeasurement zzcs(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    private static boolean zzeh(Context context) {
        if (zzcs(context) != null) {
            try {
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                return true;
            } catch (ClassNotFoundException unused) {
                if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
                    return false;
                }
                Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
                return false;
            }
        } else if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
            return false;
        } else {
            Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            return false;
        }
    }
}
