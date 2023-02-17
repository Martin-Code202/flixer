package o;

import java.util.Collection;
import java.util.Iterator;
public class Gl extends Gj {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static final boolean m5070(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* bridge */ /* synthetic */ String m5065(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return Ge.m5064(str, c, c2, z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String m5064(String str, char c, char c2, boolean z) {
        C1457Fr.m5025(str, "$receiver");
        if (z) {
            return FU.m4997(Ge.m5083(str, new char[]{c}, z, 0, 4, null), String.valueOf(c2), null, null, 0, null, null, 62, null);
        }
        String replace = str.replace(c, c2);
        C1457Fr.m5016((Object) replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
        return replace;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ String m5068(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return Ge.m5062(str, str2, str3, z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String m5062(String str, String str2, String str3, boolean z) {
        C1457Fr.m5025(str, "$receiver");
        C1457Fr.m5025(str2, "oldValue");
        C1457Fr.m5025(str3, "newValue");
        return FU.m4997(Ge.m5104(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ boolean m5067(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Ge.m5069(str, str2, z);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final boolean m5069(String str, String str2, boolean z) {
        C1457Fr.m5025(str, "$receiver");
        C1457Fr.m5025(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return Ge.m5066(str, 0, str2, 0, str2.length(), z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final boolean m5063(CharSequence charSequence) {
        boolean z;
        C1457Fr.m5025(charSequence, "$receiver");
        if (charSequence.length() != 0) {
            FE r1 = Ge.m5102(charSequence);
            if (!(r1 instanceof Collection) || !((Collection) r1).isEmpty()) {
                Iterator it = r1.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!Gc.m4992(charSequence.charAt(((EU) it).mo4855()))) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final boolean m5066(String str, int i, String str2, int i2, int i3, boolean z) {
        C1457Fr.m5025(str, "$receiver");
        C1457Fr.m5025(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
