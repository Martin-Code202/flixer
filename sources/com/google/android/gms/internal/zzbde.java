package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzak;
public final class zzbde {
    private final String mTag;
    private final int zzdqq;
    private final String zzfvk;
    private final zzak zzfwi;

    private zzbde(String str, String str2) {
        this.zzfvk = str2;
        this.mTag = str;
        this.zzfwi = new zzak(str);
        this.zzdqq = getLogLevel();
    }

    public zzbde(String str, String... strArr) {
        this(str, zzb(strArr));
    }

    private final String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.zzfvk.concat(str);
    }

    private final int getLogLevel() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private final boolean zzad(int i) {
        return this.zzdqq <= i;
    }

    private static String zzb(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(' ');
        return sb.toString();
    }

    public final void zzb(String str, Object... objArr) {
        if (zzad(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }
}
