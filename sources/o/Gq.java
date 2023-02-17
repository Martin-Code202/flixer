package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4;
import kotlin.text.StringsKt__StringsKt$splitToSequence$1;
import kotlin.text.StringsKt__StringsKt$splitToSequence$2;
public class Gq extends Gl {
    /* renamed from: ॱ */
    public static final FE m5102(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "$receiver");
        return new FE(0, charSequence.length() - 1);
    }

    /* renamed from: ˏ */
    public static final int m5095(CharSequence charSequence) {
        C1457Fr.m5025(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    /* renamed from: ˊ */
    public static final String m5079(CharSequence charSequence, FE fe) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(fe, "range");
        return charSequence.subSequence(fe.m4979().intValue(), fe.m4977().intValue() + 1).toString();
    }

    /* renamed from: ˏ */
    public static final boolean m5098(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        int i4 = i3 - 1;
        if (0 > i4) {
            return true;
        }
        for (int i5 = 0; Gc.m5060(charSequence.charAt(i + i5), charSequence2.charAt(i2 + i5), z); i5++) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˋ */
    public static final Pair<Integer, Character> m5088(CharSequence charSequence, char[] cArr, int i, boolean z, boolean z2) {
        int i2;
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            FE fe = !z2 ? new FE(FF.m4987(i, 0), Ge.m5095(charSequence)) : FF.m4990(FF.m4988(i, Ge.m5095(charSequence)), 0);
            int r3 = fe.m4983();
            int r4 = fe.m4981();
            int r5 = fe.m4984();
            if (r5 > 0) {
                if (r3 > r4) {
                    return null;
                }
            } else if (r3 < r4) {
                return null;
            }
            while (true) {
                char charAt = charSequence.charAt(r3);
                int i3 = 0;
                int length = cArr.length;
                while (true) {
                    if (i3 >= length) {
                        i2 = -1;
                        break;
                    } else if (Gc.m5060(cArr[i3], charAt, z)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    return C1438Ey.m4973(Integer.valueOf(r3), Character.valueOf(cArr[i2]));
                }
                if (r3 == r4) {
                    return null;
                }
                r3 += r5;
            }
        } else {
            char r2 = ED.m4794(cArr);
            int indexOf = !z2 ? ((String) charSequence).indexOf(r2, i) : ((String) charSequence).lastIndexOf(r2, i);
            if (indexOf < 0) {
                return null;
            }
            return C1438Ey.m4973(Integer.valueOf(indexOf), Character.valueOf(r2));
        }
    }

    /* renamed from: ˋ */
    public static final int m5086(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Integer r0;
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(cArr, "chars");
        Pair<Integer, Character> r02 = m5088(charSequence, cArr, i, z, false);
        if (r02 == null || (r0 = r02.m3221()) == null) {
            return -1;
        }
        return r0.intValue();
    }

    /* renamed from: ˊ */
    static /* synthetic */ int m5077(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return m5084(charSequence, charSequence2, i, i2, z, z2);
    }

    /* renamed from: ˋ */
    private static final int m5084(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        FE fe;
        if (!z2) {
            fe = new FE(FF.m4987(i, 0), FF.m4988(i2, charSequence.length()));
        } else {
            fe = FF.m4990(FF.m4988(i, Ge.m5095(charSequence)), FF.m4987(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int r7 = fe.m4983();
            int r8 = fe.m4981();
            int r9 = fe.m4984();
            if (r9 > 0) {
                if (r7 > r8) {
                    return -1;
                }
            } else if (r7 < r8) {
                return -1;
            }
            while (!Ge.m5098(charSequence2, 0, charSequence, r7, charSequence2.length(), z)) {
                if (r7 == r8) {
                    return -1;
                }
                r7 += r9;
            }
            return r7;
        }
        int r72 = fe.m4983();
        int r82 = fe.m4981();
        int r92 = fe.m4984();
        if (r92 > 0) {
            if (r72 > r82) {
                return -1;
            }
        } else if (r72 < r82) {
            return -1;
        }
        while (!Ge.m5066((String) charSequence2, 0, (String) charSequence, r72, charSequence2.length(), z)) {
            if (r72 == r82) {
                return -1;
            }
            r72 += r92;
        }
        return r72;
    }

    /* renamed from: ˊ */
    public static final Pair<Integer, String> m5080(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        T t;
        T t2;
        if (z || collection.size() != 1) {
            FE fe = !z2 ? new FE(FF.m4987(i, 0), charSequence.length()) : FF.m4990(FF.m4988(i, Ge.m5095(charSequence)), 0);
            if (charSequence instanceof String) {
                int r7 = fe.m4983();
                int r8 = fe.m4981();
                int r9 = fe.m4984();
                if (r9 > 0) {
                    if (r7 > r8) {
                        return null;
                    }
                } else if (r7 < r8) {
                    return null;
                }
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next = it.next();
                        T t3 = next;
                        if (Ge.m5066(t3, 0, (String) charSequence, r7, t3.length(), z)) {
                            t2 = next;
                            break;
                        }
                    }
                    T t4 = t2;
                    if (t4 != null) {
                        return C1438Ey.m4973(Integer.valueOf(r7), t4);
                    }
                    if (r7 == r8) {
                        return null;
                    }
                    r7 += r9;
                }
            } else {
                int r72 = fe.m4983();
                int r82 = fe.m4981();
                int r92 = fe.m4984();
                if (r92 > 0) {
                    if (r72 > r82) {
                        return null;
                    }
                } else if (r72 < r82) {
                    return null;
                }
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t = null;
                            break;
                        }
                        T next2 = it2.next();
                        T t5 = next2;
                        if (Ge.m5098(t5, 0, charSequence, r72, t5.length(), z)) {
                            t = next2;
                            break;
                        }
                    }
                    T t6 = t;
                    if (t6 != null) {
                        return C1438Ey.m4973(Integer.valueOf(r72), t6);
                    }
                    if (r72 == r82) {
                        return null;
                    }
                    r72 += r92;
                }
            }
        } else {
            String str = (String) EI.m4820(collection);
            int r73 = !z2 ? Ge.m5085(charSequence, str, i, false, 4, (Object) null) : Ge.m5100(charSequence, str, i, false, 4, (Object) null);
            if (r73 < 0) {
                return null;
            }
            return C1438Ey.m4973(Integer.valueOf(r73), str);
        }
    }

    /* renamed from: ˎ */
    public static /* bridge */ /* synthetic */ int m5090(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Ge.m5089(charSequence, c, i, z);
    }

    /* renamed from: ˎ */
    public static final int m5089(CharSequence charSequence, char c, int i, boolean z) {
        C1457Fr.m5025(charSequence, "$receiver");
        if (z || !(charSequence instanceof String)) {
            return Ge.m5086(charSequence, new char[]{c}, i, z);
        }
        return ((String) charSequence).indexOf(c, i);
    }

    /* renamed from: ˋ */
    public static /* synthetic */ int m5085(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Ge.m5078(charSequence, str, i, z);
    }

    /* renamed from: ˊ */
    public static final int m5078(CharSequence charSequence, String str, int i, boolean z) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(str, "string");
        if (z || !(charSequence instanceof String)) {
            return m5077(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    /* renamed from: ॱ */
    public static /* synthetic */ int m5100(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Ge.m5095(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Ge.m5099(charSequence, str, i, z);
    }

    /* renamed from: ॱ */
    public static final int m5099(CharSequence charSequence, String str, int i, boolean z) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(str, "string");
        if (z || !(charSequence instanceof String)) {
            return m5084(charSequence, (CharSequence) str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    /* renamed from: ॱ */
    public static /* synthetic */ boolean m5105(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Ge.m5094(charSequence, charSequence2, z);
    }

    /* renamed from: ˎ */
    public static final boolean m5094(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(charSequence2, "other");
        return charSequence2 instanceof String ? Ge.m5085(charSequence, (String) charSequence2, 0, z, 2, null) >= 0 : m5077(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    /* renamed from: ˎ */
    static /* synthetic */ FW m5091(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m5082(charSequence, cArr, i, z, i2);
    }

    /* renamed from: ˊ */
    private static final FW<FE> m5082(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new Gf(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    /* renamed from: ˎ */
    static /* synthetic */ FW m5092(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m5097(charSequence, strArr, i, z, i2);
    }

    /* renamed from: ˏ */
    private static final FW<FE> m5097(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new Gf(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(ED.m4792((Object[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    /* renamed from: ॱ */
    public static /* synthetic */ FW m5104(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return Ge.m5093(charSequence, strArr, z, i);
    }

    /* renamed from: ˎ */
    public static final FW<String> m5093(CharSequence charSequence, String[] strArr, boolean z, int i) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(strArr, "delimiters");
        return FU.m4996(m5092(charSequence, strArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    /* renamed from: ˋ */
    public static /* synthetic */ List m5087(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return Ge.m5101(charSequence, strArr, z, i);
    }

    /* renamed from: ॱ */
    public static final List<String> m5101(CharSequence charSequence, String[] strArr, boolean z, int i) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(strArr, "delimiters");
        Iterable<FE> r7 = FU.m4994(m5092(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(EI.m4812(r7, 10));
        for (FE fe : r7) {
            arrayList.add(Ge.m5079(charSequence, fe));
        }
        return arrayList;
    }

    /* renamed from: ˊ */
    public static /* synthetic */ FW m5083(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return Ge.m5103(charSequence, cArr, z, i);
    }

    /* renamed from: ॱ */
    public static final FW<String> m5103(CharSequence charSequence, char[] cArr, boolean z, int i) {
        C1457Fr.m5025(charSequence, "$receiver");
        C1457Fr.m5025(cArr, "delimiters");
        return FU.m4996(m5091(charSequence, cArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }
}
