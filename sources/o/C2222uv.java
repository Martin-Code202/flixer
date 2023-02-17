package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.model.leafs.ListOfGenreSummary;
import java.util.HashMap;
/* renamed from: o.uv  reason: case insensitive filesystem */
public final class C2222uv extends C1277 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final ListOfGenreSummary f11039 = new ListOfGenreSummary();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static ListOfGenreSummary f11040;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C2222uv f11041;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static ListOfGenreSummary f11042;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final HashMap<String, GenreList> f11043 = new HashMap<>(4);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final C0237 f11044 = new C0237();

    static {
        C2222uv uvVar = new C2222uv();
        f11041 = uvVar;
        f11040 = new ListOfGenreSummary("", uvVar.m11776(), GenreList.GenreType.LOLOMO);
        f11042 = new ListOfGenreSummary("", uvVar.m11778(), GenreList.GenreType.LOLOMO);
        C1281 r6 = C1281.f15992;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE");
        LocalBroadcastManager.getInstance((Context) C1281.m16832(Context.class)).registerReceiver(f11044, intentFilter);
    }

    private C2222uv() {
        super("AroGalleriesConstants");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String m11776() {
        return BrowseExperience.m1780() ? "2496491" : "83";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final String m11778() {
        return BrowseExperience.m1780() ? "2495600" : "34399";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final ListOfGenreSummary m11774() {
        return f11039;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final ListOfGenreSummary m11780() {
        return f11040;
    }

    /* renamed from: o.uv$ˋ  reason: contains not printable characters */
    public static final class C0237 extends BroadcastReceiver {
        C0237() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -618428631:
                        if (!action.equals("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE")) {
                            return;
                        }
                        break;
                    case 39639845:
                        if (!action.equals("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE")) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                C2222uv uvVar = C2222uv.f11041;
                C2222uv uvVar2 = C2222uv.f11041;
                C2222uv.f11043.clear();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m11777(Context context) {
        String str;
        C1457Fr.m5025(context, "context");
        String string = context.getString(R.string.lolomo_genre_name_all_genres);
        f11040 = new ListOfGenreSummary(string, m11776(), GenreList.GenreType.LOLOMO);
        f11042 = new ListOfGenreSummary(string, m11778(), GenreList.GenreType.LOLOMO);
        if (!f11043.isEmpty()) {
            f11043.clear();
        }
        f11043.put("lolomo", new ListOfGenreSummary(context.getString(R.string.lolomo_filter_name_all), "lolomo", GenreList.GenreType.LOLOMO));
        if (C0727.m15066()) {
            str = context.getString(R.string.lolomo_filter_name_tv_shows);
        } else {
            str = context.getString(R.string.lolomo_filter_name_series);
        }
        f11043.put(m11776(), new ListOfGenreSummary(str, m11776(), GenreList.GenreType.LOLOMO));
        f11043.put(m11778(), new ListOfGenreSummary(context.getString(R.string.lolomo_filter_name_movies), m11778(), GenreList.GenreType.LOLOMO));
        f11043.put("839338", new ListOfGenreSummary(context.getString(R.string.lolomo_filter_name_nflx_originals), "839338", GenreList.GenreType.LOLOMO));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final GenreList m11779(String str) {
        C1457Fr.m5025(str, "genreId");
        GenreList genreList = f11043.get(str);
        if (genreList != null) {
            return genreList;
        }
        C1276.m16820().mo5728("GenreList should not be null for " + str + ", keys: " + f11043.keySet());
        return f11039;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final ListOfGenreSummary m11775(String str) {
        C1457Fr.m5025(str, "genreId");
        return C1457Fr.m5018(str, m11776()) ? f11040 : f11042;
    }
}
