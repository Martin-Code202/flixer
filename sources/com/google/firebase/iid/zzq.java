package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;
public final class zzq {
    private static zzq zzmma;
    private final SimpleArrayMap<String, String> zzmmb = new SimpleArrayMap<>();
    private Boolean zzmmc = null;
    final Queue<Intent> zzmmd = new LinkedList();
    private Queue<Intent> zzmme = new LinkedList();

    private zzq() {
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return zza(context, 0, "com.google.firebase.INSTANCE_ID_EVENT", intent, 134217728);
    }

    private static PendingIntent zza(Context context, int i, String str, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, i2);
    }

    public static PendingIntent zzb(Context context, int i, Intent intent, int i2) {
        return zza(context, i, "com.google.firebase.MESSAGING_EVENT", intent, 1073741824);
    }

    public static synchronized zzq zzbys() {
        zzq zzq;
        synchronized (zzq.class) {
            if (zzmma == null) {
                zzmma = new zzq();
            }
            zzq = zzmma;
        }
        return zzq;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ed A[Catch:{ SecurityException -> 0x012c, IllegalStateException -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0106 A[Catch:{ SecurityException -> 0x012c, IllegalStateException -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010f A[Catch:{ SecurityException -> 0x012c, IllegalStateException -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0120 A[Catch:{ SecurityException -> 0x012c, IllegalStateException -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzf(android.content.Context r16, android.content.Intent r17) {
        /*
        // Method dump skipped, instructions count: 353
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzq.zzf(android.content.Context, android.content.Intent):int");
    }

    public final int zza(Context context, String str, Intent intent) {
        char c = 65535;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    c = 0;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.zzmmd.offer(intent);
                break;
            case 1:
                this.zzmme.offer(intent);
                break;
            default:
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Unknown service action: ".concat(valueOf) : new String("Unknown service action: "));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return zzf(context, intent2);
    }

    public final Intent zzbyt() {
        return this.zzmme.poll();
    }

    public final void zze(Context context, Intent intent) {
        zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }
}
