package o;

import android.util.SparseIntArray;
import java.math.BigInteger;
/* renamed from: o.Au  reason: case insensitive filesystem */
public class C1319Au {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static final SparseIntArray f4536 = new SparseIntArray();

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static final char[] f4537 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_', '-', '.', '*', '(', ')', ',', '@', '\'', '$', ':', ';', '!'};

    static {
        m3785();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static void m3785() {
        for (int i = 0; i < f4537.length; i++) {
            f4536.put(f4537[i], Integer.valueOf(i).intValue());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m3783(char c) {
        Integer valueOf = Integer.valueOf(f4536.get(c));
        if (valueOf != null) {
            return valueOf.intValue();
        }
        throw new NumberFormatException("Value out of range " + c);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3786(String str, int i) {
        return m3784(str, i).toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static BigInteger m3784(String str, int i) {
        BigInteger bigInteger = new BigInteger("" + i);
        BigInteger bigInteger2 = new BigInteger("0");
        int i2 = 0;
        String sb = new StringBuilder(str).reverse().toString();
        for (int i3 = 0; i3 < sb.length(); i3++) {
            i2++;
            bigInteger2 = bigInteger2.add(bigInteger.pow(i2).multiply(new BigInteger("" + m3783(sb.charAt(i3)))));
        }
        return bigInteger2;
    }
}
