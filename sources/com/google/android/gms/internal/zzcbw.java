package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
public final class zzcbw extends zzcdu {
    private final String zzfvj = zzcax.zzavm();
    private final long zzilf = zzcax.zzauw();
    private final char zzipq;
    private final zzcby zzipr;
    private final zzcby zzips;
    private final zzcby zzipt;
    private final zzcby zzipu;
    private final zzcby zzipv;
    private final zzcby zzipw;
    private final zzcby zzipx;
    private final zzcby zzipy;
    private final zzcby zzipz;

    zzcbw(zzccw zzccw) {
        super(zzccw);
        if (zzauo().zzxu()) {
            zzcax.zzawl();
            this.zzipq = 'C';
        } else {
            zzcax.zzawl();
            this.zzipq = 'c';
        }
        this.zzipr = new zzcby(this, 6, false, false);
        this.zzips = new zzcby(this, 6, true, false);
        this.zzipt = new zzcby(this, 6, false, true);
        this.zzipu = new zzcby(this, 5, false, false);
        this.zzipv = new zzcby(this, 5, true, false);
        this.zzipw = new zzcby(this, 5, false, true);
        this.zzipx = new zzcby(this, 4, false, false);
        this.zzipy = new zzcby(this, 3, false, false);
        this.zzipz = new zzcby(this, 2, false, false);
    }

    private static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zzc = zzc(z, obj);
        String zzc2 = zzc(z, obj2);
        String zzc3 = zzc(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzc)) {
            sb.append(str2);
            sb.append(zzc);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc2)) {
            sb.append(str2);
            sb.append(zzc2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc3)) {
            sb.append(str2);
            sb.append(zzc3);
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010b, code lost:
        r5.append(": ");
        r5.append(r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzc(boolean r14, java.lang.Object r15) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbw.zzc(boolean, java.lang.Object):java.lang.String");
    }

    protected static Object zzjf(String str) {
        if (str == null) {
            return null;
        }
        return new zzcbz(str);
    }

    private static String zzjg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzad(i)) {
            zzk(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            int i2 = i;
            zzbp.zzu(str);
            zzccr zzayy = this.zzikh.zzayy();
            if (zzayy == null) {
                zzk(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzayy.isInitialized()) {
                zzk(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= 9) {
                    i2 = 8;
                }
                char charAt = "01VDIWEA?".charAt(i2);
                char c = this.zzipq;
                long j = this.zzilf;
                String zza = zza(true, str, obj, obj2, obj3);
                String sb = new StringBuilder(String.valueOf(zza).length() + String.valueOf("2").length() + 23).append("2").append(charAt).append(c).append(j).append(":").append(zza).toString();
                if (sb.length() > 1024) {
                    sb = str.substring(0, 1024);
                }
                zzayy.zzg(new zzcbx(this, sb));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzad(int i) {
        return Log.isLoggable(this.zzfvj, i);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatv() {
        super.zzatv();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatw() {
        super.zzatw();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatx() {
        super.zzatx();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcan zzaty() {
        return super.zzaty();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcau zzatz() {
        return super.zzatz();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcdw zzaua() {
        return super.zzaua();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbr zzaub() {
        return super.zzaub();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbe zzauc() {
        return super.zzauc();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzceo zzaud() {
        return super.zzaud();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcek zzaue() {
        return super.zzaue();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbs zzauf() {
        return super.zzauf();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcay zzaug() {
        return super.zzaug();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbu zzauh() {
        return super.zzauh();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfw zzaui() {
        return super.zzaui();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccq zzauj() {
        return super.zzauj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfl zzauk() {
        return super.zzauk();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccr zzaul() {
        return super.zzaul();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbw zzaum() {
        return super.zzaum();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcch zzaun() {
        return super.zzaun();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcax zzauo() {
        return super.zzauo();
    }

    public final zzcby zzaye() {
        return this.zzipr;
    }

    public final zzcby zzayf() {
        return this.zzips;
    }

    public final zzcby zzayg() {
        return this.zzipu;
    }

    public final zzcby zzayh() {
        return this.zzipw;
    }

    public final zzcby zzayi() {
        return this.zzipx;
    }

    public final zzcby zzayj() {
        return this.zzipy;
    }

    public final zzcby zzayk() {
        return this.zzipz;
    }

    public final String zzayl() {
        Pair<String, Long> zzzi = zzaun().zziqn.zzzi();
        if (zzzi == null || zzzi == zzcch.zziqm) {
            return null;
        }
        String valueOf = String.valueOf(zzzi.second);
        String str = (String) zzzi.first;
        return new StringBuilder(String.valueOf(str).length() + String.valueOf(valueOf).length() + 1).append(valueOf).append(":").append(str).toString();
    }

    /* access modifiers changed from: protected */
    public final void zzk(int i, String str) {
        Log.println(i, this.zzfvj, str);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
