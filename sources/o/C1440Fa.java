package o;

import kotlin.TypeCastException;
/* renamed from: o.Fa  reason: case insensitive filesystem */
public final class C1440Fa {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C1444Fe f5669;

    static {
        C1444Fe fe;
        int r3 = m4998();
        if (r3 >= 65544) {
            try {
                Object newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                if (newInstance == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                fe = (C1444Fe) newInstance;
                f5669 = fe;
            } catch (ClassNotFoundException e) {
                Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                if (newInstance2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                fe = (C1444Fe) newInstance2;
            } catch (ClassNotFoundException e2) {
            }
        }
        if (r3 >= 65543) {
            try {
                Object newInstance3 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                if (newInstance3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                fe = (C1444Fe) newInstance3;
                f5669 = fe;
            } catch (ClassNotFoundException e3) {
                Object newInstance4 = Class.forName("o.Fb").newInstance();
                if (newInstance4 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                fe = (C1444Fe) newInstance4;
            } catch (ClassNotFoundException e4) {
            }
        }
        fe = new C1444Fe();
        f5669 = fe;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int m4998() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int r8 = Ge.m5090((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (r8 < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException e) {
                return 65542;
            }
        } else {
            int r9 = Ge.m5090((CharSequence) property, '.', r8 + 1, false, 4, (Object) null);
            if (r9 < 0) {
                r9 = property.length();
            }
            if (property == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = property.substring(0, r8);
            C1457Fr.m5016((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i = r8 + 1;
            if (property == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring2 = property.substring(i, r9);
            C1457Fr.m5016((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException e2) {
                return 65542;
            }
        }
    }
}
