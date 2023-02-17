package o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: o.э  reason: contains not printable characters */
public final class C0506 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0859 f13635 = C0859.m15528("episodes", "current", C0859.m15523("detail", "bookmark", "offlineAvailable"));

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0859 f13636 = f13635;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0859 f13637 = C0859.m15528(C0859.m15523("detail", "bookmark", "offlineAvailable"));

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0859 f13638 = C0859.m15528(C0859.m15523("detail", "offlineAvailable"));

    /* renamed from: ॱ  reason: contains not printable characters */
    static final List<C0859> f13639 = C0859.m15523("summary", "detail", "bookmark", "offlineAvailable");

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final C0859 f13640 = C0859.m15528("tallPanelArt");

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m14498(List<C0859> list, String str, String str2, int i, int i2, boolean z) {
        C0859 r3;
        if (!C1349Bv.m4113(str)) {
            r3 = C0859.m15528("lists", str, C0859.m15532(i, i2));
        } else if (C1349Bv.m4113(str2)) {
            r3 = C0859.m15528("lolomo", "continueWatching", C0859.m15532(i, i2));
        } else {
            r3 = C0859.m15528("lolomos", str2, "continueWatching", C0859.m15532(i, i2));
        }
        list.add(m14508(z).m15540(r3));
        list.add(f13635.m15540(r3));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m14511(List<C0859> list, String str, String str2, int i, int i2, boolean z) {
        C0859 r3;
        if (!C1349Bv.m4113(str2)) {
            r3 = C0859.m15528("lists", str2, C0859.m15532(i, i2));
        } else if (C1349Bv.m4113(str)) {
            r3 = C0859.m15528("lolomo", "shortForm", C0859.m15532(i, i2));
        } else {
            r3 = C0859.m15528("lolomos", str, "shortForm", C0859.m15532(i, i2));
        }
        list.add(m14497(z).m15540(r3));
        list.add(f13637.m15540(r3));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m14501(List<C0859> list, String str, String str2, int i, int i2, boolean z) {
        C0859 r4;
        if (!C1349Bv.m4113(str2)) {
            C0859.m15528("lists", str2, C0859.m15532(i, i2));
            r4 = C0859.m15528("lists", str2, "thirtySecondPreviewData", C0859.m15532(i, i2), "previewSummary");
        } else if (!C1349Bv.m4113(str)) {
            C0859.m15528("lolomos", str, "thirtySecondPreview", C0859.m15532(i, i2));
            r4 = C0859.m15528("lolomos", str, "thirtySecondPreview", "thirtySecondPreviewData", C0859.m15532(i, i2), "previewSummary");
        } else {
            C0859.m15528("lolomo", "thirtySecondPreview", C0859.m15532(i, i2));
            r4 = C0859.m15528("lolomo", "thirtySecondPreview", "thirtySecondPreviewData", C0859.m15532(i, i2), "previewSummary");
        }
        list.add(r4);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14516(List<C0859> list, String str, String str2, int i, int i2) {
        C0859 r5;
        boolean r3 = C1349Bv.m4113(str2);
        if (!C1349Bv.m4113(str2)) {
            r5 = C0859.m15528("lists", str, C0859.m15532(i, i2));
        } else if (r3) {
            r5 = C0859.m15528("lolomo", "netflixOriginals", C0859.m15532(i, i2));
        } else {
            r5 = C0859.m15528("lolomos", str2, "netflixOriginals", C0859.m15532(i, i2));
        }
        list.add(r5);
        list.add(f13640.m15540(r5));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0859 m14508(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("summary");
        }
        arrayList.addAll(C0859.m15523("detail", "rating", "inQueue", "bookmark", "offlineAvailable", "cleanBoxart"));
        return C0859.m15528(arrayList);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0859 m14497(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("summary");
        }
        arrayList.addAll(C0859.m15523("detail", "bookmark", "offlineAvailable"));
        return C0859.m15528(arrayList);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0859 m14502(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("summary");
        }
        arrayList.addAll(C0859.m15523("detail", "rating", "inQueue", "bookmark", "offlineAvailable"));
        return C0859.m15528(arrayList);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m14505(List<C0859> list, String str, String str2, int i, int i2, boolean z) {
        C0859 r2 = m14507("billboard", str, str2);
        list.add(r2.m15535(m14496(C0859.m15532(i, i2), m14502(z))));
        list.add(r2.m15535(m14496(C0859.m15532(i, i2), f13636)));
        list.add(r2.m15535(m14495(C0859.m15532(i, i2))));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0859 m14495(Map<?, ?> map) {
        return C0859.m15528("billboardData", map, "billboardSummary");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0859 m14496(Map<?, ?> map, C0859 r4) {
        return C0859.m15528("videoEvidence", map).m15535(r4);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static C0859 m14507(String str, String str2, String str3) {
        if (!C1349Bv.m4113(str2)) {
            return C0859.m15528("lists", str2);
        }
        return C1349Bv.m4113(str3) ? C0859.m15528("lolomo", str) : C0859.m15528("lolomos", str3, str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14517(List<C0859> list, String str, String str2, int i, int i2, boolean z) {
        C0859 r4;
        C0859 r3;
        if (str2 != null && str2.length() > 0) {
            r3 = C0859.m15528("lists", str2, "videoEvidence", C0859.m15532(i, i2));
            r4 = C0859.m15528("lists", str2, "bigRowData", C0859.m15532(i, i2), "bigRowSummary");
        } else if (str == null || str.length() <= 0) {
            r3 = C0859.m15528("lolomo", "bigRow", "videoEvidence", C0859.m15532(i, i2));
            r4 = C0859.m15528("lolomo", "bigRow", "bigRowData", C0859.m15532(i, i2), "bigRowSummary");
        } else {
            r3 = C0859.m15528("lolomos", str, "bigRow", "videoEvidence", C0859.m15532(i, i2));
            r4 = C0859.m15528("lolomos", str, "bigRow", "bigRowData", C0859.m15532(i, i2), "bigRowSummary");
        }
        list.add(m14502(z).m15540(r3));
        list.add(r4);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0859 m14509(boolean z, String str) {
        Object[] objArr = new Object[5];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = str;
        objArr[2] = "similars";
        objArr[3] = C0859.m15519(11);
        objArr[4] = "summary";
        return C0859.m15528(objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0859 m14503(boolean z, String str) {
        Object[] objArr = new Object[5];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = str;
        objArr[2] = "trailers";
        objArr[3] = C0859.m15519(24);
        objArr[4] = C0859.m15523("summary", "trickplayBaseUrl", "intrUrl", "detail");
        return C0859.m15528(objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0859 m14514(boolean z, String str) {
        Object[] objArr = new Object[4];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = str;
        objArr[2] = "trailers";
        objArr[3] = "summary";
        return C0859.m15528(objArr);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0859 m14494(String str, String str2, String str3) {
        return C0859.m15528(str, str2, "scenes", str3, "summary");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0859 m14506(String str) {
        return C0859.m15528("characters", str, "gallery", C0859.m15519(100), "summary");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14518(List<C0859> list, List<String> list2, boolean z) {
        list.add(C0859.m15528("movies", list2, C0859.m15523("summary", "detail", "rating", "inQueue", "bookmark", "offlineAvailable", "evidence", "defaultTrailer")));
        list.add(m14504(true, list2));
        list.add(m14515(true, list2));
        if (z) {
            list.add(m14500(true, list2));
            list.add(m14510(true, list2));
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0859 m14504(boolean z, List<String> list) {
        Object[] objArr = new Object[5];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = list;
        objArr[2] = "similars";
        objArr[3] = C0859.m15519(11);
        objArr[4] = "summary";
        return C0859.m15528(objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0859 m14500(boolean z, List<String> list) {
        Object[] objArr = new Object[5];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = list;
        objArr[2] = "trailers";
        objArr[3] = C0859.m15519(24);
        objArr[4] = C0859.m15523("summary", "trickplayBaseUrl", "intrUrl", "detail");
        return C0859.m15528(objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0859 m14515(boolean z, List<String> list) {
        Object[] objArr = new Object[4];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = list;
        objArr[2] = "similars";
        objArr[3] = "summary";
        return C0859.m15528(objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v0 java.lang.String) */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0859 m14510(boolean z, List<String> list) {
        Object[] objArr = new Object[4];
        objArr[0] = z ? "movies" : "shows";
        objArr[1] = list;
        objArr[2] = "trailers";
        objArr[3] = "summary";
        return C0859.m15528(objArr);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0859 m14513(List<String> list) {
        return C0859.m15528("shows", list, "seasons", "all", "detail");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m14512(List<C0859> list, String str, boolean z) {
        if (z) {
            list.add(C0859.m15528("movies", str, C0859.m15523("inQueue", "rating", "bookmark")));
            return;
        }
        list.add(C0859.m15528("shows", str, C0859.m15523("detail", "inQueue", "rating")));
        list.add(C0859.m15528("shows", str, "seasons", "summary"));
        list.add(C0859.m15528("shows", str, "seasons", "all", "detail"));
        list.add(C0859.m15528("shows", str, "episodes", "current", C0859.m15523("detail", "bookmark")));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m14499(List<C0859> list, List<String> list2, String str, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.addAll(Arrays.asList("summary", "detail", "rating", "inQueue", "hasWatched", "defaultTrailer"));
        list.add(C0859.m15528("shows", list2, arrayList));
        list.add(C0859.m15528("shows", list2, "episodes", "current", C0859.m15523("detail", "bookmark", "offlineAvailable")));
        if (C1349Bv.m4107(str)) {
            list.add(C0859.m15528("episodes", str, C0859.m15523("detail", "bookmark", "offlineAvailable")));
            list.add(C0859.m15528("episodes", str, "watchNext", C0859.m15523("detail", "bookmark", "offlineAvailable")));
        }
        list.add(m14504(false, list2));
        list.add(m14515(false, list2));
        if (z3) {
            list.add(m14500(false, list2));
            list.add(m14510(false, list2));
        }
        if (z) {
            list.add(C0859.m15528("shows", list2, "seasons", "summary"));
            list.add(m14513(list2));
        }
        if (z2) {
            list.add(C0859.m15528("shows", list2, "seasons", "current", "episodes", C0859.m15532(0, 39), f13639));
        }
    }
}
