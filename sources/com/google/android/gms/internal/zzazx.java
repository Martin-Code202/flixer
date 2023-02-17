package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import java.util.Locale;
public final class zzazx {
    private static boolean zzfce = false;
    private String mTag;
    private final boolean zzfcf;
    private boolean zzfcg;
    private boolean zzfch;
    private String zzfci;

    public zzazx(String str) {
        this(str, false);
    }

    private zzazx(String str, boolean z) {
        zzbp.zzh(str, "The log tag cannot be null or empty.");
        this.mTag = str;
        this.zzfcf = str.length() <= 23;
        this.zzfcg = false;
        this.zzfch = false;
    }

    private final boolean zzaeq() {
        if (!this.zzfcg) {
            return this.zzfcf && Log.isLoggable(this.mTag, 3);
        }
        return true;
    }

    private String zzg(String str, Object... objArr) {
        String format = objArr.length == 0 ? str : String.format(Locale.ROOT, str, objArr);
        if (TextUtils.isEmpty(this.zzfci)) {
            return format;
        }
        String valueOf = String.valueOf(this.zzfci);
        String valueOf2 = String.valueOf(format);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final void zza(Throwable th, String str, Object... objArr) {
        Log.e(this.mTag, zzg(str, objArr), th);
    }

    public final void zzb(String str, Object... objArr) {
        if (zzaeq()) {
            Log.d(this.mTag, zzg(str, objArr));
        }
    }

    public final void zzb(Throwable th, String str, Object... objArr) {
        if (zzaeq()) {
            Log.d(this.mTag, zzg(str, objArr), th);
        }
    }

    public final void zzc(String str, Object... objArr) {
        Log.e(this.mTag, zzg(str, objArr));
    }

    public final void zze(String str, Object... objArr) {
        Log.i(this.mTag, zzg(str, objArr));
    }

    public final void zzf(String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr));
    }

    public final void zzfl(String str) {
        this.zzfci = TextUtils.isEmpty(str) ? null : String.format("[%s] ", str);
    }
}
