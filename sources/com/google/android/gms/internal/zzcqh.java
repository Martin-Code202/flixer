package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzw;
public final class zzcqh {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzjnz = "*gcore*:";
    private final Context mContext;
    private final String zzfxy;
    private final String zzfya;
    private final PowerManager.WakeLock zzjoa;
    private WorkSource zzjob;
    private final int zzjoc;
    private final String zzjod;
    private boolean zzjoe;
    private int zzjof;
    private int zzjog;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzcqh(Context context, int i, String str) {
        this(context, 1, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcqh(Context context, int i, String str, String str2, String str3) {
        this(context, 1, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcqh(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzjoe = true;
        zzbp.zzh(str, "Wake lock name can NOT be empty");
        this.zzjoc = i;
        this.zzjod = null;
        this.zzfya = null;
        this.mContext = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(zzjnz);
            String valueOf2 = String.valueOf(str);
            this.zzfxy = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.zzfxy = str;
        }
        this.zzjoa = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzw.zzco(this.mContext)) {
            this.zzjob = zzw.zzac(context, zzs.zzgm(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.zzjob;
            if (workSource != null && zzw.zzco(this.mContext)) {
                if (this.zzjob != null) {
                    this.zzjob.add(workSource);
                } else {
                    this.zzjob = workSource;
                }
                try {
                    this.zzjoa.setWorkSource(this.zzjob);
                } catch (IllegalArgumentException e) {
                    Log.wtf(TAG, e.toString());
                }
            }
        }
    }

    private final String zzg(String str, boolean z) {
        if (!this.zzjoe) {
            return this.zzjod;
        }
        if (z) {
            return null;
        }
        return this.zzjod;
    }

    private final boolean zzlb(String str) {
        if (TextUtils.isEmpty(null)) {
            return false;
        }
        String str2 = null;
        return !str2.equals(this.zzjod);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r11 == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r15.zzjog == 0) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acquire(long r16) {
        /*
            r15 = this;
            r10 = r15
            r0 = 0
            boolean r11 = r15.zzlb(r0)
            r0 = 0
            java.lang.String r12 = r10.zzg(r0, r11)
            r13 = r10
            monitor-enter(r13)
            int r0 = r10.zzjof     // Catch:{ all -> 0x005e }
            if (r0 > 0) goto L_0x0015
            int r0 = r10.zzjog     // Catch:{ all -> 0x005e }
            if (r0 <= 0) goto L_0x0023
        L_0x0015:
            android.os.PowerManager$WakeLock r0 = r10.zzjoa     // Catch:{ all -> 0x005e }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x0023
            r0 = 0
            r10.zzjof = r0     // Catch:{ all -> 0x005e }
            r0 = 0
            r10.zzjog = r0     // Catch:{ all -> 0x005e }
        L_0x0023:
            boolean r0 = r10.zzjoe     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0031
            int r0 = r10.zzjof     // Catch:{ all -> 0x005e }
            int r1 = r0 + 1
            r10.zzjof = r1     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0039
            if (r11 != 0) goto L_0x0039
        L_0x0031:
            boolean r0 = r10.zzjoe     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x005c
            int r0 = r10.zzjog     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x005c
        L_0x0039:
            com.google.android.gms.common.stats.zze.zzalc()     // Catch:{ all -> 0x005e }
            android.content.Context r0 = r10.mContext     // Catch:{ all -> 0x005e }
            android.os.PowerManager$WakeLock r1 = r10.zzjoa     // Catch:{ all -> 0x005e }
            java.lang.String r1 = com.google.android.gms.common.stats.zzc.zza(r1, r12)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r10.zzfxy     // Catch:{ all -> 0x005e }
            r4 = r12
            int r6 = r10.zzjoc     // Catch:{ all -> 0x005e }
            android.os.WorkSource r2 = r10.zzjob     // Catch:{ all -> 0x005e }
            java.util.List r7 = com.google.android.gms.common.util.zzw.zzb(r2)     // Catch:{ all -> 0x005e }
            r2 = 7
            r5 = 0
            r8 = 1000(0x3e8, double:4.94E-321)
            com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005e }
            int r0 = r10.zzjog     // Catch:{ all -> 0x005e }
            int r0 = r0 + 1
            r10.zzjog = r0     // Catch:{ all -> 0x005e }
        L_0x005c:
            monitor-exit(r13)
            goto L_0x0061
        L_0x005e:
            r14 = move-exception
            monitor-exit(r13)
            throw r14
        L_0x0061:
            android.os.PowerManager$WakeLock r0 = r15.zzjoa
            r1 = 1000(0x3e8, double:4.94E-321)
            r0.acquire(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcqh.acquire(long):void");
    }

    public final boolean isHeld() {
        return this.zzjoa.isHeld();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r13.zzjog == 1) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r9 == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
            r13 = this;
            r8 = r13
            r0 = 0
            boolean r9 = r13.zzlb(r0)
            r0 = 0
            java.lang.String r10 = r8.zzg(r0, r9)
            r11 = r8
            monitor-enter(r11)
            boolean r0 = r8.zzjoe     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x001b
            int r0 = r8.zzjof     // Catch:{ all -> 0x0048 }
            int r0 = r0 + -1
            r8.zzjof = r0     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0024
            if (r9 != 0) goto L_0x0024
        L_0x001b:
            boolean r0 = r8.zzjoe     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0046
            int r0 = r8.zzjog     // Catch:{ all -> 0x0048 }
            r1 = 1
            if (r0 != r1) goto L_0x0046
        L_0x0024:
            com.google.android.gms.common.stats.zze.zzalc()     // Catch:{ all -> 0x0048 }
            android.content.Context r0 = r8.mContext     // Catch:{ all -> 0x0048 }
            android.os.PowerManager$WakeLock r1 = r8.zzjoa     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = com.google.android.gms.common.stats.zzc.zza(r1, r10)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = r8.zzfxy     // Catch:{ all -> 0x0048 }
            r4 = r10
            int r6 = r8.zzjoc     // Catch:{ all -> 0x0048 }
            android.os.WorkSource r2 = r8.zzjob     // Catch:{ all -> 0x0048 }
            java.util.List r7 = com.google.android.gms.common.util.zzw.zzb(r2)     // Catch:{ all -> 0x0048 }
            r2 = 8
            r5 = 0
            com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0048 }
            int r0 = r8.zzjog     // Catch:{ all -> 0x0048 }
            int r0 = r0 + -1
            r8.zzjog = r0     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r11)
            goto L_0x004b
        L_0x0048:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L_0x004b:
            android.os.PowerManager$WakeLock r0 = r13.zzjoa
            r0.release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcqh.release():void");
    }

    public final void setReferenceCounted(boolean z) {
        this.zzjoa.setReferenceCounted(false);
        this.zzjoe = false;
    }
}
