package com.netflix.mediaclient.ui.search;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab8274;
import o.AD;
import o.C1283;
import o.pJ;
public class SearchUtils {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final SparseArray<SparseIntArray> f3927 = new SparseArray<>(2);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static SearchExperience f3928;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final SparseArray<SparseIntArray> f3929 = new SparseArray<>(2);

    public enum SearchExperience {
        PHONE,
        TABLET
    }

    public enum SuggestionType {
        SEARCH_HISTORY,
        BROWSE_HISTORY
    }

    static {
        m2920(SearchExperience.TABLET);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m2920(SearchExperience searchExperience) {
        if (searchExperience != f3928) {
            f3928 = searchExperience;
            m2908();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static SearchExperience m2916() {
        return f3928;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m2911() {
        switch (f3928) {
            case TABLET:
                return R.layout.search_results_frag_tablet;
            default:
                return R.layout.search_results_frag_phone;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m2926() {
        switch (f3928) {
            case TABLET:
                return R.layout.search_result_view_related_tablet;
            default:
                return R.layout.search_result_view_related;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static double m2918() {
        switch (f3928) {
            case TABLET:
                return 0.5625d;
            default:
                return 1.4299999475479126d;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m2923() {
        switch (f3928) {
            case TABLET:
                return false;
            default:
                return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m2919(Context context) {
        if (context == null) {
            C1283.m16865("SearchUtils", "getNumVideoGridCols, Context is null");
            return 2;
        }
        int r2 = AD.m3284(context);
        return f3929.get(r2).get(AD.m3290(context));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m2912(Context context) {
        if (context == null) {
            C1283.m16865("SearchUtils", "getNumRelatedGridCols, Context is null");
            return 2;
        }
        int r2 = AD.m3284(context);
        return f3927.get(r2).get(AD.m3290(context));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private static void m2908() {
        switch (f3928) {
            case TABLET:
                m2928();
                m2924();
                return;
            default:
                m2925();
                m2917();
                return;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m2915(Context context) {
        int i;
        int r3 = m2919(context);
        if (r3 <= 0 || (i = 21 % r3) == 0) {
            return 21;
        }
        return 21 - i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m2927(Context context) {
        if (context == null) {
            C1283.m16865("SearchUtils", "getMaxResultsRelated, Context is null");
            return 1;
        }
        int r2 = AD.m3284(context);
        int r3 = AD.m3290(context);
        if (r2 != 1) {
            return 40;
        }
        if (r3 == 3 || r3 == 4) {
            return 3;
        }
        return 40;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m2921(Context context) {
        return m2915(context);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static void m2917() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray.put(1, 2);
        sparseIntArray2.put(1, 1);
        sparseIntArray.put(2, 3);
        sparseIntArray2.put(2, 1);
        sparseIntArray.put(3, 4);
        sparseIntArray2.put(3, 1);
        sparseIntArray.put(4, 4);
        sparseIntArray2.put(4, 1);
        f3929.put(1, sparseIntArray);
        f3927.put(1, sparseIntArray2);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private static void m2925() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray.put(1, 3);
        sparseIntArray2.put(1, 1);
        sparseIntArray.put(2, 4);
        sparseIntArray2.put(2, 1);
        sparseIntArray.put(3, 5);
        sparseIntArray2.put(3, 1);
        sparseIntArray.put(4, 6);
        sparseIntArray2.put(4, 1);
        f3929.put(2, sparseIntArray);
        f3927.put(2, sparseIntArray2);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static void m2924() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray.put(1, 3);
        sparseIntArray2.put(1, 3);
        sparseIntArray.put(2, 2);
        sparseIntArray2.put(2, 3);
        sparseIntArray.put(3, 2);
        sparseIntArray2.put(3, 3);
        sparseIntArray.put(4, 3);
        sparseIntArray2.put(4, 3);
        f3929.put(1, sparseIntArray);
        f3927.put(1, sparseIntArray2);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static void m2928() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray.put(1, 2);
        sparseIntArray2.put(1, 1);
        sparseIntArray.put(2, 3);
        sparseIntArray2.put(2, 1);
        sparseIntArray.put(3, 3);
        sparseIntArray2.put(3, 1);
        sparseIntArray.put(4, 3);
        sparseIntArray2.put(4, 1);
        f3929.put(2, sparseIntArray);
        f3927.put(2, sparseIntArray2);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m2930() {
        switch (f3928) {
            case TABLET:
                return false;
            default:
                return true;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m2929() {
        switch (f3928) {
            case TABLET:
                return false;
            default:
                return true;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m2910() {
        switch (f3928) {
            case TABLET:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m2909() {
        switch (f3928) {
            case PHONE:
                return true;
            default:
                return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m2913(String str) {
        return str.replaceAll("\\s+", " ");
    }

    public enum SaveType {
        VIDEO_MOVIE("movies", 0),
        VIDEO_SHOW("shows", 1),
        VIDEO_SEASON("seasons", 2),
        VIDEO_EPISODE("episodes", 3),
        VIDEO_CHARACTERS("characters", 4),
        SEARCH_PERSON("person", 5),
        SEARCH_RELATED_TO("related_to", 6),
        PRE_QUERY_ENTITY("prequery", 8),
        UNKNOWN("", 9);
        

        /* renamed from: ʼ  reason: contains not printable characters */
        private final String f3941;

        /* renamed from: ͺ  reason: contains not printable characters */
        private final int f3942;

        private SaveType(String str, int i) {
            this.f3941 = str;
            this.f3942 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static SaveType m2931(String str) {
            SaveType[] values = values();
            for (SaveType saveType : values) {
                if (saveType.f3941.equalsIgnoreCase(str)) {
                    return saveType;
                }
            }
            return UNKNOWN;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m2932() {
            return this.f3941;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m2922(pJ pJVar, SuggestionType suggestionType, NetflixActivity netflixActivity) {
        if (pJVar != null && netflixActivity != null) {
            if ((Config_Ab8274.m507(netflixActivity) && suggestionType == SuggestionType.BROWSE_HISTORY) || (Config_Ab8274.m508(netflixActivity) && suggestionType == SuggestionType.SEARCH_HISTORY)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("suggest_text_1", pJVar.getTitle());
                contentValues.put("falkorId", pJVar.getId());
                contentValues.put("saveType", pJVar.getType().getValue());
                contentValues.put("entityType", "video");
                contentValues.put("suggestionType", suggestionType.name());
                contentValues.put("profileId", netflixActivity.getServiceManager().m9835());
                netflixActivity.getContentResolver().insert(Uri.parse("content://com.netflix.mediaclient.ui.search.NetflixSearchSuggestionsContentProvider/insert"), contentValues);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m2914(String str, String str2, String str3, String str4, SaveType saveType, SuggestionType suggestionType, NetflixActivity netflixActivity) {
        if (netflixActivity != null && saveType != SaveType.UNKNOWN && Config_Ab8274.m507(netflixActivity)) {
            if (suggestionType == SuggestionType.BROWSE_HISTORY || suggestionType == SuggestionType.SEARCH_HISTORY) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("suggest_text_1", str4);
                contentValues.put("entityId", str);
                contentValues.put("falkorId", str2);
                contentValues.put("saveType", saveType.name());
                contentValues.put("entityType", str3);
                contentValues.put("suggestionType", suggestionType.name());
                contentValues.put("profileId", netflixActivity.getServiceManager().m9835());
                netflixActivity.getContentResolver().insert(Uri.parse("content://com.netflix.mediaclient.ui.search.NetflixSearchSuggestionsContentProvider/insert"), contentValues);
            }
        }
    }
}
