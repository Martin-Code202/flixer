package o;
/* renamed from: o.ڊ  reason: contains not printable characters */
public class C0600 {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m14733(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
