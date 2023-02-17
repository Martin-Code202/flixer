package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import java.util.Map;
public class zzaon extends zzams {
    private static zzaon zzdth;

    public zzaon(zzamu zzamu) {
        super(zzamu);
    }

    private static String zzk(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? String.valueOf(obj) : obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) obj).longValue()) < 100) {
            return String.valueOf(obj);
        }
        String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
        String valueOf = String.valueOf(Math.abs(((Long) obj).longValue()));
        return str + Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
    }

    public static zzaon zzyt() {
        return zzdth;
    }

    public final void zza(zzaoi zzaoi, String str) {
        String zzaoi2 = zzaoi != null ? zzaoi.toString() : "no hit data";
        String valueOf = String.valueOf(str);
        zzd(valueOf.length() != 0 ? "Discarding hit. ".concat(valueOf) : new String("Discarding hit. "), zzaoi2);
    }

    public final synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzbp.zzu(str);
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        char c = zzvz().zzxu() ? 'C' : 'c';
        char charAt = "01VDIWEA?".charAt(i);
        String str2 = zzamt.VERSION;
        String zzc = zzc(str, zzk(obj), zzk(obj2), zzk(obj3));
        String sb = new StringBuilder(String.valueOf(zzc).length() + String.valueOf("3").length() + 3 + String.valueOf(str2).length()).append("3").append(charAt).append(c).append(str2).append(":").append(zzc).toString();
        if (sb.length() > 1024) {
            sb = sb.substring(0, 1024);
        }
        zzaor zzwo = zzvw().zzwo();
        if (zzwo != null) {
            zzwo.zzzg().zzdy(sb);
        }
    }

    public final void zze(Map<String, String> map, String str) {
        String str2;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        String valueOf = String.valueOf(str);
        zzd(valueOf.length() != 0 ? "Discarding hit. ".concat(valueOf) : new String("Discarding hit. "), str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        synchronized (zzaon.class) {
            zzdth = this;
        }
    }
}
