package o;

import java.util.Collections;
import java.util.List;
public class kC {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<C1950ku> m8185(List<C1950ku> list, long j, long j2) {
        int i;
        if (j == -9223372036854775807L && j2 == -9223372036854775807L) {
            return list;
        }
        long j3 = j == -9223372036854775807L ? 0 : j;
        long j4 = (j2 == -9223372036854775807L || j2 > 2147483647L) ? Long.MAX_VALUE : j3 + j2;
        int r7 = m8187(list, j3, -1);
        if (j2 == 0) {
            i = r7;
        } else {
            i = m8187(list, j4, r7);
        }
        if (r7 >= 0 && i >= 0) {
            return list.subList(r7, i + 1);
        }
        C1283.m16844("nf_cache", "unable to find chunk for startPtsUs = %s", Long.valueOf(j3));
        return Collections.emptyList();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static List<C1950ku> m8188(List<C1950ku> list, long j, long j2) {
        if (j == -1 && j2 == -1) {
            return list;
        }
        long j3 = j == -1 ? 0 : j;
        long j4 = j2 == -9223372036854775807L ? Long.MAX_VALUE : j2;
        int r5 = m8186(list, j3, -1);
        int r6 = m8186(list, j4, r5);
        if (r5 < 0 || r6 < 0) {
            C1283.m16844("nf_cache", "unable to find chunk for startByte = %s", Long.valueOf(j3));
            return Collections.emptyList();
        }
        if (list.get(r5).m8443() > j3) {
            C1283.m16848("nf_cache", "incomplete chunk -- chunk=[%s, %s] , cached=[%s,%s]", Long.valueOf(list.get(r5).m8443()), Long.valueOf(list.get(r5).m8444()), Long.valueOf(j3), Long.valueOf(j4));
            r5++;
        }
        if (list.get(r6).m8444() > j4) {
            C1283.m16848("nf_cache", "incomplete chunk -- chunk=[%s, %s] , cached=[%s,%s]", Long.valueOf(list.get(r6).m8443()), Long.valueOf(list.get(r6).m8444()), Long.valueOf(j3), Long.valueOf(j4));
            r6--;
        }
        if (r5 < list.size() && r5 <= r6 && r6 >= 0) {
            return list.subList(r5, r6 + 1);
        }
        C1283.m16848("nf_cache", "incomplete chunk -- empty list", Long.valueOf(j3));
        return Collections.emptyList();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m8187(List<C1950ku> list, long j, int i) {
        int i2 = i < 0 ? 0 : i;
        int size = list.size() - 1;
        if (j > list.get(size).m8445()) {
            return size;
        }
        if (j < list.get(i2).m8445()) {
            return i2;
        }
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            C1950ku kuVar = list.get(i3);
            if (kuVar.m8441() > j) {
                size = i3 - 1;
            } else if (kuVar.m8445() >= j) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int m8186(List<C1950ku> list, long j, int i) {
        int i2 = i < 0 ? 0 : i;
        int size = list.size() - 1;
        if (j > list.get(size).m8444()) {
            return size;
        }
        if (j < list.get(i2).m8443()) {
            return i2;
        }
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            C1950ku kuVar = list.get(i3);
            if (kuVar.m8443() > j) {
                size = i3 - 1;
            } else if (kuVar.m8444() >= j) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }
}
