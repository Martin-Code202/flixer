package o;
/* renamed from: o.ذ  reason: contains not printable characters */
public class C0580 {
    /* renamed from: ˏ  reason: contains not printable characters */
    static long[] m14701(int i, int i2) {
        long[] jArr = new long[4];
        jArr[0] = ((((long) i) & 4294967295L) << 32) | (((long) i2) & 4294967295L);
        for (int i3 = 1; i3 < 4; i3++) {
            jArr[i3] = m14699(jArr[i3 - 1], i3);
        }
        return jArr;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long m14699(long j, int i) {
        return m14702(j, 1812433253, 30, i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static long m14702(long j, long j2, int i, int i2) {
        return (((j >> i) ^ j) * j2) + ((long) i2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static void m14700(long[] jArr, long[] jArr2, int i) {
        long j = ((jArr[i % 4] * 2147483085) + jArr2[(i + 2) % 4]) % 2147483647L;
        jArr2[(i + 3) % 4] = ((jArr[(i + 3) % 4] * 2147483085) + jArr2[(i + 2) % 4]) / 2147483647L;
        jArr[(i + 3) % 4] = j;
    }
}
