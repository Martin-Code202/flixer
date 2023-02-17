package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzaoi {
    private final Map<String, String> zzbql;
    private final List<zzanp> zzdsv;
    private final long zzdsw;
    private final long zzdsx;
    private final int zzdsy;
    private final boolean zzdsz;
    private final String zzdta;

    public zzaoi(zzamr zzamr, Map<String, String> map, long j, boolean z) {
        this(zzamr, map, j, z, 0, 0, null);
    }

    public zzaoi(zzamr zzamr, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzamr, map, j, z, j2, i, null);
    }

    public zzaoi(zzamr zzamr, Map<String, String> map, long j, boolean z, long j2, int i, List<zzanp> list) {
        String zza;
        String zza2;
        zzbp.zzu(zzamr);
        zzbp.zzu(map);
        this.zzdsx = j;
        this.zzdsz = z;
        this.zzdsw = j2;
        this.zzdsy = i;
        this.zzdsv = list != null ? list : Collections.emptyList();
        this.zzdta = zzr(list);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (zzj(entry.getKey()) && (zza2 = zza(zzamr, entry.getKey())) != null) {
                hashMap.put(zza2, zzb(zzamr, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!zzj(entry2.getKey()) && (zza = zza(zzamr, entry2.getKey())) != null) {
                hashMap.put(zza, zzb(zzamr, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.zzdta)) {
            zzapd.zzb(hashMap, "_v", this.zzdta);
            if (this.zzdta.equals("ma4.0.0") || this.zzdta.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzbql = Collections.unmodifiableMap(hashMap);
    }

    private static String zza(zzamr zzamr, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        String substring = obj2.startsWith("&") ? obj2.substring(1) : obj2;
        int length = substring.length();
        if (length > 256) {
            substring = substring.substring(0, 256);
            zzamr.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), substring);
        }
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        return substring;
    }

    private static String zzb(zzamr zzamr, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zzamr.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    private static boolean zzj(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private final String zzl(String str, String str2) {
        zzbp.zzgg(str);
        zzbp.zzb(!str.startsWith("&"), "Short param name required");
        String str3 = this.zzbql.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String zzr(List<zzanp> list) {
        String str = null;
        if (list != null) {
            Iterator<zzanp> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zzanp next = it.next();
                if ("appendVersion".equals(next.getId())) {
                    str = next.getValue();
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzdsx);
        if (this.zzdsw != 0) {
            stringBuffer.append(", dbId=").append(this.zzdsw);
        }
        if (this.zzdsy != 0) {
            stringBuffer.append(", appUID=").append(this.zzdsy);
        }
        ArrayList arrayList = new ArrayList(this.zzbql.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(this.zzbql.get(str));
        }
        return stringBuffer.toString();
    }

    public final Map<String, String> zziy() {
        return this.zzbql;
    }

    public final int zzyl() {
        return this.zzdsy;
    }

    public final long zzym() {
        return this.zzdsw;
    }

    public final long zzyn() {
        return this.zzdsx;
    }

    public final List<zzanp> zzyo() {
        return this.zzdsv;
    }

    public final boolean zzyp() {
        return this.zzdsz;
    }

    public final long zzyq() {
        return zzapd.zzea(zzl("_s", "0"));
    }

    public final String zzyr() {
        return zzl("_m", "");
    }
}
