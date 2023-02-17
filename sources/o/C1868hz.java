package o;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* renamed from: o.hz  reason: case insensitive filesystem */
public class C1868hz {

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String f7476;

    /* renamed from: ˋ  reason: contains not printable characters */
    public final long f7477;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int f7478;

    public C1868hz(String str, int i, long j) {
        this.f7476 = str;
        this.f7478 = i;
        this.f7477 = j;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m7373(List<C1868hz> list) {
        Collections.sort(list, new Comparator<C1868hz>() { // from class: o.hz.4
            /* renamed from: ॱ  reason: contains not printable characters */
            public int compare(C1868hz hzVar, C1868hz hzVar2) {
                return hzVar.f7478 - hzVar2.f7478;
            }
        });
    }
}
