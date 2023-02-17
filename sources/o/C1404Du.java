package o;

import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* renamed from: o.Du  reason: case insensitive filesystem */
public class C1404Du {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Charset f5465 = Charset.forName("UTF-8");

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C1401Dr m4748(MslContext mslContext, Collection<?> collection) {
        AbstractC1400Dq r3 = mslContext.mo3174();
        C1401Dr r4 = r3.m4730();
        for (Object obj : collection) {
            if ((obj instanceof byte[]) || (obj instanceof Boolean) || (obj instanceof C1401Dr) || (obj instanceof C1405Dv) || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Map) || (obj instanceof Collection) || (obj instanceof Object[]) || (obj instanceof Enum) || obj == null) {
                r4.mo4734(-1, obj);
            } else if (obj instanceof AbstractC1399Dp) {
                r4.mo4734(-1, r3.mo3176(((AbstractC1399Dp) obj).mo3114(r3, r3.mo3177((Set<C1407Dx>) null))));
            } else {
                throw new MslEncoderException("Class " + obj.getClass().getName() + " is not MSL encoding-compatible.");
            }
        }
        return r4;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4746(C1405Dv dv, C1405Dv dv2) {
        if (dv == dv2) {
            return true;
        }
        if (dv == null || dv2 == null) {
            return false;
        }
        Set<String> r2 = dv.m4758();
        Set<String> r3 = dv2.m4758();
        if (r2 != r3 && (r2 == null || r3 == null || r2.size() != r3.size() || !r2.equals(r3))) {
            return false;
        }
        for (String str : r2) {
            Object r6 = dv.m4751(str);
            Object r7 = dv2.m4751(str);
            if (r6 != r7) {
                if (r6 == null || r7 == null) {
                    return false;
                }
                if ((r6 instanceof byte[]) || (r7 instanceof byte[])) {
                    if (!Arrays.equals(dv.mo4761(str), dv2.mo4761(str))) {
                        return false;
                    }
                } else if (!(r6 instanceof C1405Dv) || !(r7 instanceof C1405Dv)) {
                    if (!(r6 instanceof C1401Dr) || !(r7 instanceof C1401Dr)) {
                        if (!(r6.getClass() == r7.getClass() && r6.equals(r7))) {
                            return false;
                        }
                    } else if (!m4745((C1401Dr) r6, (C1401Dr) r7)) {
                        return false;
                    }
                } else if (!m4746((C1405Dv) r6, (C1405Dv) r7)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m4747(C1405Dv dv) {
        int i;
        if (dv == null) {
            return -1;
        }
        int i2 = 0;
        for (String str : dv.m4758()) {
            byte[] r6 = dv.mo4762(str, (byte[]) null);
            if (r6 != null) {
                i = Arrays.hashCode(r6);
            } else {
                Object r7 = dv.m4751(str);
                if (r7 instanceof C1405Dv) {
                    i = m4747((C1405Dv) r7);
                } else if (r7 instanceof C1401Dr) {
                    i = m4749((C1401Dr) r7);
                } else if (r7 != null) {
                    i = r7.hashCode();
                } else {
                    i = 1;
                }
            }
            i2 ^= str.hashCode() + i;
        }
        return i2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4745(C1401Dr dr, C1401Dr dr2) {
        if (dr == dr2) {
            return true;
        }
        if (dr == null || dr2 == null || dr.m4732() != dr2.m4732()) {
            return false;
        }
        for (int i = 0; i < dr.m4732(); i++) {
            Object r3 = dr.m4733(i);
            Object r4 = dr2.m4733(i);
            if (r3 != r4) {
                if (r3 == null || r4 == null) {
                    return false;
                }
                if ((r3 instanceof byte[]) || (r4 instanceof byte[])) {
                    if (!Arrays.equals(dr.mo4731(i), dr2.mo4731(i))) {
                        return false;
                    }
                } else if (!(r3 instanceof C1405Dv) || !(r4 instanceof C1405Dv)) {
                    if (!(r3 instanceof C1401Dr) || !(r4 instanceof C1401Dr)) {
                        if (!(r3.getClass() == r4.getClass() && r3.equals(r4))) {
                            return false;
                        }
                    } else if (!m4745((C1401Dr) r3, (C1401Dr) r4)) {
                        return false;
                    }
                } else if (!m4746((C1405Dv) r3, (C1405Dv) r4)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m4749(C1401Dr dr) {
        if (dr == null) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < dr.m4732(); i2++) {
            byte[] r4 = dr.mo4738(i2, null);
            if (r4 != null) {
                i = (i * 37) + Arrays.hashCode(r4);
            } else {
                Object r5 = dr.m4733(i2);
                if (r5 instanceof C1405Dv) {
                    i = (i * 37) + m4747((C1405Dv) r5);
                } else if (r5 instanceof C1401Dr) {
                    i = (i * 37) + m4749((C1401Dr) r5);
                } else if (r5 != null) {
                    i = (i * 37) + r5.hashCode();
                } else {
                    i = (i * 37) + 1;
                }
            }
        }
        return i;
    }
}
