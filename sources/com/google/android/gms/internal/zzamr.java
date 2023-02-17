package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
public class zzamr {
    private final zzamu zzdoc;

    protected zzamr(zzamu zzamu) {
        zzbp.zzu(zzamu);
        this.zzdoc = zzamu;
    }

    private final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaon zzaon = null;
        if (this.zzdoc != null) {
            zzaon = this.zzdoc.zzwm();
        }
        if (zzaon != null) {
            String str2 = zzaod.zzdra.get();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, zzaon.zzc(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                zzaon.zzb(i, str, obj, obj2, obj3);
                return;
            }
            return;
        }
        String str3 = zzaod.zzdra.get();
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, zzc(str, obj, obj2, obj3));
        }
    }

    protected static String zzc(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zzi = zzi(obj);
        String zzi2 = zzi(obj2);
        String zzi3 = zzi(obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzi)) {
            sb.append(str2);
            sb.append(zzi);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzi2)) {
            sb.append(str2);
            sb.append(zzi2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzi3)) {
            sb.append(str2);
            sb.append(zzi3);
        }
        return sb.toString();
    }

    private static String zzi(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    public static boolean zzqu() {
        return Log.isLoggable(zzaod.zzdra.get(), 2);
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.zzdoc.getContext();
    }

    public final void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    public final void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    public final void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    public final void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    public final void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    public final void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    public final void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    public final void zzdm(String str) {
        zza(2, str, null, null, null);
    }

    public final void zzdn(String str) {
        zza(3, str, null, null, null);
    }

    public final void zzdo(String str) {
        zza(4, str, null, null, null);
    }

    public final void zzdp(String str) {
        zza(5, str, null, null, null);
    }

    public final void zzdq(String str) {
        zza(6, str, null, null, null);
    }

    public final void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    public final zzamu zzvw() {
        return this.zzdoc;
    }

    /* access modifiers changed from: protected */
    public final zzd zzvx() {
        return this.zzdoc.zzvx();
    }

    /* access modifiers changed from: protected */
    public final zzaon zzvy() {
        return this.zzdoc.zzvy();
    }

    /* access modifiers changed from: protected */
    public final zzanv zzvz() {
        return this.zzdoc.zzvz();
    }

    /* access modifiers changed from: protected */
    public final zzj zzwa() {
        return this.zzdoc.zzwa();
    }

    /* access modifiers changed from: protected */
    public final zzamj zzwc() {
        return this.zzdoc.zzwc();
    }

    /* access modifiers changed from: protected */
    public final zzaoa zzwd() {
        return this.zzdoc.zzwd();
    }

    /* access modifiers changed from: protected */
    public final zzape zzwe() {
        return this.zzdoc.zzwe();
    }

    /* access modifiers changed from: protected */
    public final zzaor zzwf() {
        return this.zzdoc.zzwf();
    }

    /* access modifiers changed from: protected */
    public final zzanm zzwg() {
        return this.zzdoc.zzwq();
    }
}
