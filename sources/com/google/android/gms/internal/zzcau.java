package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* access modifiers changed from: package-private */
public final class zzcau extends zzcdu {
    zzcau(zzccw zzccw) {
        super(zzccw);
    }

    private final Boolean zza(double d, zzcga zzcga) {
        try {
            return zza(new BigDecimal(d), zzcga, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(long j, zzcga zzcga) {
        try {
            return zza(new BigDecimal(j), zzcga, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(zzcfy zzcfy, zzcgh zzcgh, long j) {
        Boolean bool;
        if (zzcfy.zzixq != null) {
            Boolean zza = zza(j, zzcfy.zzixq);
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        zzcfz[] zzcfzArr = zzcfy.zzixo;
        for (zzcfz zzcfz : zzcfzArr) {
            if (TextUtils.isEmpty(zzcfz.zzixv)) {
                zzaum().zzayg().zzj("null or empty param name in filter. event", zzauh().zzjc(zzcgh.name));
                return null;
            }
            hashSet.add(zzcfz.zzixv);
        }
        ArrayMap arrayMap = new ArrayMap();
        zzcgi[] zzcgiArr = zzcgh.zziyw;
        for (zzcgi zzcgi : zzcgiArr) {
            if (hashSet.contains(zzcgi.name)) {
                if (zzcgi.zziza != null) {
                    arrayMap.put(zzcgi.name, zzcgi.zziza);
                } else if (zzcgi.zzixb != null) {
                    arrayMap.put(zzcgi.name, zzcgi.zzixb);
                } else if (zzcgi.zzfwn != null) {
                    arrayMap.put(zzcgi.name, zzcgi.zzfwn);
                } else {
                    zzaum().zzayg().zze("Unknown value for param. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(zzcgi.name));
                    return null;
                }
            }
        }
        zzcfz[] zzcfzArr2 = zzcfy.zzixo;
        for (zzcfz zzcfz2 : zzcfzArr2) {
            boolean equals = Boolean.TRUE.equals(zzcfz2.zzixu);
            String str = zzcfz2.zzixv;
            if (TextUtils.isEmpty(str)) {
                zzaum().zzayg().zzj("Event has empty param name. event", zzauh().zzjc(zzcgh.name));
                return null;
            }
            Object obj = arrayMap.get(str);
            if (obj instanceof Long) {
                if (zzcfz2.zzixt == null) {
                    zzaum().zzayg().zze("No number filter for long param. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(str));
                    return null;
                }
                Boolean zza2 = zza(((Long) obj).longValue(), zzcfz2.zzixt);
                if (zza2 == null) {
                    return null;
                }
                if ((!zza2.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (zzcfz2.zzixt == null) {
                    zzaum().zzayg().zze("No number filter for double param. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(str));
                    return null;
                }
                Boolean zza3 = zza(((Double) obj).doubleValue(), zzcfz2.zzixt);
                if (zza3 == null) {
                    return null;
                }
                if ((!zza3.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (zzcfz2.zzixs != null) {
                    bool = zza((String) obj, zzcfz2.zzixs);
                } else if (zzcfz2.zzixt == null) {
                    zzaum().zzayg().zze("No filter for String param. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(str));
                    return null;
                } else if (zzcfw.zzkf((String) obj)) {
                    bool = zza((String) obj, zzcfz2.zzixt);
                } else {
                    zzaum().zzayg().zze("Invalid param value for number filter. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(str));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if ((!bool.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj == null) {
                zzaum().zzayk().zze("Missing param for filter. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(str));
                return false;
            } else {
                zzaum().zzayg().zze("Unknown param type. event, param", zzauh().zzjc(zzcgh.name), zzauh().zzjd(str));
                return null;
            }
        }
        return true;
    }

    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzaum().zzayg().zzj("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(String str, zzcga zzcga) {
        if (!zzcfw.zzkf(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzcga, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzcgc zzcgc) {
        List<String> list;
        zzbp.zzu(zzcgc);
        if (str == null || zzcgc.zziye == null || zzcgc.zziye.intValue() == 0) {
            return null;
        }
        if (zzcgc.zziye.intValue() == 6) {
            if (zzcgc.zziyh == null || zzcgc.zziyh.length == 0) {
                return null;
            }
        } else if (zzcgc.zziyf == null) {
            return null;
        }
        int intValue = zzcgc.zziye.intValue();
        boolean z = zzcgc.zziyg != null && zzcgc.zziyg.booleanValue();
        String upperCase = (z || intValue == 1 || intValue == 6) ? zzcgc.zziyf : zzcgc.zziyf.toUpperCase(Locale.ENGLISH);
        if (zzcgc.zziyh == null) {
            list = null;
        } else {
            String[] strArr = zzcgc.zziyh;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                ArrayList arrayList = new ArrayList();
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    arrayList.add(strArr[i].toUpperCase(Locale.ENGLISH));
                }
                list = arrayList;
            }
        }
        String str2 = null;
        if (intValue == 1) {
            str2 = upperCase;
        }
        return zza(str, intValue, z, upperCase, list, str2);
    }

    private static Boolean zza(BigDecimal bigDecimal, zzcga zzcga, double d) {
        zzbp.zzu(zzcga);
        if (zzcga.zzixw == null || zzcga.zzixw.intValue() == 0) {
            return null;
        }
        if (zzcga.zzixw.intValue() == 4) {
            if (zzcga.zzixz == null || zzcga.zziya == null) {
                return null;
            }
        } else if (zzcga.zzixy == null) {
            return null;
        }
        int intValue = zzcga.zzixw.intValue();
        BigDecimal bigDecimal2 = null;
        BigDecimal bigDecimal3 = null;
        BigDecimal bigDecimal4 = null;
        if (zzcga.zzixw.intValue() == 4) {
            if (!zzcfw.zzkf(zzcga.zzixz) || !zzcfw.zzkf(zzcga.zziya)) {
                return null;
            }
            try {
                bigDecimal3 = new BigDecimal(zzcga.zzixz);
                bigDecimal4 = new BigDecimal(zzcga.zziya);
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (!zzcfw.zzkf(zzcga.zzixy)) {
            return null;
        } else {
            try {
                bigDecimal2 = new BigDecimal(zzcga.zzixy);
            } catch (NumberFormatException unused2) {
                return null;
            }
        }
        if (intValue == 4) {
            if (bigDecimal3 == null) {
                return null;
            }
        } else if (bigDecimal2 == null) {
            return null;
        }
        switch (intValue) {
            case 1:
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            case 2:
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            case 3:
                if (d != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            case 4:
                return Boolean.valueOf((bigDecimal.compareTo(bigDecimal3) == -1 || bigDecimal.compareTo(bigDecimal4) == 1) ? false : true);
            default:
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcgg[] zza(String str, zzcgh[] zzcghArr, zzcgm[] zzcgmArr) {
        zzcgb next;
        Boolean bool;
        zzcbg zzcbg;
        zzbp.zzgg(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map<Integer, zzcgl> zziz = zzaug().zziz(str);
        if (zziz != null) {
            for (Integer num : zziz.keySet()) {
                int intValue = num.intValue();
                zzcgl zzcgl = zziz.get(Integer.valueOf(intValue));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < (zzcgl.zzjaf.length << 6); i++) {
                    if (zzcfw.zza(zzcgl.zzjaf, i)) {
                        zzaum().zzayk().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzcfw.zza(zzcgl.zzjag, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzcgg zzcgg = new zzcgg();
                arrayMap.put(Integer.valueOf(intValue), zzcgg);
                zzcgg.zziyu = false;
                zzcgg.zziyt = zzcgl;
                zzcgg.zziys = new zzcgl();
                zzcgg.zziys.zzjag = zzcfw.zza(bitSet);
                zzcgg.zziys.zzjaf = zzcfw.zza(bitSet2);
            }
        }
        if (zzcghArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzcghArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                zzcgh zzcgh = zzcghArr[i2];
                zzcbg zzaf = zzaug().zzaf(str, zzcgh.name);
                if (zzaf == null) {
                    zzaum().zzayg().zze("Event aggregate wasn't created during raw event logging. appId, event", zzcbw.zzjf(str), zzauh().zzjc(zzcgh.name));
                    zzcbg = new zzcbg(str, zzcgh.name, 1, 1, zzcgh.zziyx.longValue());
                } else {
                    zzcbg = zzaf.zzaxz();
                }
                zzaug().zza(zzcbg);
                long j = zzcbg.zzink;
                Map<Integer, List<zzcfy>> map = (Map) arrayMap4.get(zzcgh.name);
                if (map == null) {
                    map = zzaug().zzak(str, zzcgh.name);
                    if (map == null) {
                        map = new ArrayMap<>();
                    }
                    arrayMap4.put(zzcgh.name, map);
                }
                for (Integer num2 : map.keySet()) {
                    int intValue2 = num2.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue2))) {
                        zzaum().zzayk().zzj("Skipping failed audience ID", Integer.valueOf(intValue2));
                    } else {
                        zzcgg zzcgg2 = (zzcgg) arrayMap.get(Integer.valueOf(intValue2));
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(intValue2));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(intValue2));
                        if (zzcgg2 == null) {
                            zzcgg zzcgg3 = new zzcgg();
                            arrayMap.put(Integer.valueOf(intValue2), zzcgg3);
                            zzcgg3.zziyu = true;
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue2), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue2), bitSet4);
                        }
                        for (zzcfy zzcfy : map.get(Integer.valueOf(intValue2))) {
                            if (zzaum().zzad(2)) {
                                zzaum().zzayk().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), zzcfy.zzixm, zzauh().zzjc(zzcfy.zzixn));
                                zzaum().zzayk().zzj("Filter definition", zzauh().zza(zzcfy));
                            }
                            if (zzcfy.zzixm == null || zzcfy.zzixm.intValue() > 256) {
                                zzaum().zzayg().zze("Invalid event filter ID. appId, id", zzcbw.zzjf(str), String.valueOf(zzcfy.zzixm));
                            } else if (bitSet3.get(zzcfy.zzixm.intValue())) {
                                zzaum().zzayk().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), zzcfy.zzixm);
                            } else {
                                Boolean zza = zza(zzcfy, zzcgh, j);
                                zzaum().zzayk().zzj("Event filter result", zza == null ? "null" : zza);
                                if (zza == null) {
                                    hashSet.add(Integer.valueOf(intValue2));
                                } else {
                                    bitSet4.set(zzcfy.zzixm.intValue());
                                    if (zza.booleanValue()) {
                                        bitSet3.set(zzcfy.zzixm.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (zzcgmArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            int length2 = zzcgmArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                zzcgm zzcgm = zzcgmArr[i3];
                Map<Integer, List<zzcgb>> map2 = (Map) arrayMap5.get(zzcgm.name);
                if (map2 == null) {
                    map2 = zzaug().zzal(str, zzcgm.name);
                    if (map2 == null) {
                        map2 = new ArrayMap<>();
                    }
                    arrayMap5.put(zzcgm.name, map2);
                }
                for (Integer num3 : map2.keySet()) {
                    int intValue3 = num3.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        zzaum().zzayk().zzj("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        zzcgg zzcgg4 = (zzcgg) arrayMap.get(Integer.valueOf(intValue3));
                        BitSet bitSet5 = (BitSet) arrayMap2.get(Integer.valueOf(intValue3));
                        BitSet bitSet6 = (BitSet) arrayMap3.get(Integer.valueOf(intValue3));
                        if (zzcgg4 == null) {
                            zzcgg zzcgg5 = new zzcgg();
                            arrayMap.put(Integer.valueOf(intValue3), zzcgg5);
                            zzcgg5.zziyu = true;
                            bitSet5 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue3), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue3), bitSet6);
                        }
                        Iterator<zzcgb> it = map2.get(Integer.valueOf(intValue3)).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            next = it.next();
                            if (zzaum().zzad(2)) {
                                zzaum().zzayk().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue3), next.zzixm, zzauh().zzje(next.zziyc));
                                zzaum().zzayk().zzj("Filter definition", zzauh().zza(next));
                            }
                            if (next.zzixm == null || next.zzixm.intValue() > 256) {
                                break;
                            } else if (bitSet5.get(next.zzixm.intValue())) {
                                zzaum().zzayk().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), next.zzixm);
                            } else {
                                zzcfz zzcfz = next.zziyd;
                                if (zzcfz == null) {
                                    zzaum().zzayg().zzj("Missing property filter. property", zzauh().zzje(zzcgm.name));
                                    bool = null;
                                } else {
                                    boolean equals = Boolean.TRUE.equals(zzcfz.zzixu);
                                    if (zzcgm.zziza != null) {
                                        if (zzcfz.zzixt == null) {
                                            zzaum().zzayg().zzj("No number filter for long property. property", zzauh().zzje(zzcgm.name));
                                            bool = null;
                                        } else {
                                            bool = zza(zza(zzcgm.zziza.longValue(), zzcfz.zzixt), equals);
                                        }
                                    } else if (zzcgm.zzixb != null) {
                                        if (zzcfz.zzixt == null) {
                                            zzaum().zzayg().zzj("No number filter for double property. property", zzauh().zzje(zzcgm.name));
                                            bool = null;
                                        } else {
                                            bool = zza(zza(zzcgm.zzixb.doubleValue(), zzcfz.zzixt), equals);
                                        }
                                    } else if (zzcgm.zzfwn == null) {
                                        zzaum().zzayg().zzj("User property has no value, property", zzauh().zzje(zzcgm.name));
                                        bool = null;
                                    } else if (zzcfz.zzixs == null) {
                                        if (zzcfz.zzixt == null) {
                                            zzaum().zzayg().zzj("No string or number filter defined. property", zzauh().zzje(zzcgm.name));
                                        } else if (zzcfw.zzkf(zzcgm.zzfwn)) {
                                            bool = zza(zza(zzcgm.zzfwn, zzcfz.zzixt), equals);
                                        } else {
                                            zzaum().zzayg().zze("Invalid user property value for Numeric number filter. property, value", zzauh().zzje(zzcgm.name), zzcgm.zzfwn);
                                        }
                                        bool = null;
                                    } else {
                                        bool = zza(zza(zzcgm.zzfwn, zzcfz.zzixs), equals);
                                    }
                                }
                                zzaum().zzayk().zzj("Property filter result", bool == null ? "null" : bool);
                                if (bool == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet6.set(next.zzixm.intValue());
                                    if (bool.booleanValue()) {
                                        bitSet5.set(next.zzixm.intValue());
                                    }
                                }
                            }
                        }
                        zzaum().zzayg().zze("Invalid property filter ID. appId, id", zzcbw.zzjf(str), String.valueOf(next.zzixm));
                        hashSet.add(Integer.valueOf(intValue3));
                    }
                }
            }
        }
        zzcgg[] zzcggArr = new zzcgg[arrayMap2.size()];
        int i4 = 0;
        for (Integer num4 : arrayMap2.keySet()) {
            int intValue4 = num4.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue4))) {
                zzcgg zzcgg6 = (zzcgg) arrayMap.get(Integer.valueOf(intValue4));
                if (zzcgg6 == null) {
                    zzcgg6 = new zzcgg();
                }
                i4++;
                zzcggArr[i4] = zzcgg6;
                zzcgg6.zzixi = Integer.valueOf(intValue4);
                zzcgg6.zziys = new zzcgl();
                zzcgg6.zziys.zzjag = zzcfw.zza((BitSet) arrayMap2.get(Integer.valueOf(intValue4)));
                zzcgg6.zziys.zzjaf = zzcfw.zza((BitSet) arrayMap3.get(Integer.valueOf(intValue4)));
                zzcay zzaug = zzaug();
                zzcgl zzcgl2 = zzcgg6.zziys;
                zzaug.zzwk();
                zzaug.zzuj();
                zzbp.zzgg(str);
                zzbp.zzu(zzcgl2);
                try {
                    byte[] bArr = new byte[zzcgl2.zzhi()];
                    zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
                    zzcgl2.zza(zzi);
                    zzi.zzccm();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(intValue4));
                    contentValues.put("current_results", bArr);
                    try {
                        if (zzaug.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zzaug.zzaum().zzaye().zzj("Failed to insert filter results (got -1). appId", zzcbw.zzjf(str));
                        }
                    } catch (SQLiteException e) {
                        zzaug.zzaum().zzaye().zze("Error storing filter results. appId", zzcbw.zzjf(str), e);
                    }
                } catch (IOException e2) {
                    zzaug.zzaum().zzaye().zze("Configuration loss. Failed to serialize filter results. appId", zzcbw.zzjf(str), e2);
                }
            }
        }
        return (zzcgg[]) Arrays.copyOf(zzcggArr, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
    }
}
