package o;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.model.leafs.Episode;
import com.netflix.model.leafs.PostPlayItem;
/* renamed from: o.si  reason: case insensitive filesystem */
public final class C2149si {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C2149si f10161 = new C2149si();

    private C2149si() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m10732(Context context, C1383Cz cz) {
        Object obj;
        Episode.Detail detail;
        Episode.Detail detail2;
        Episode.Detail detail3;
        C1457Fr.m5025(context, "context");
        m10733(context);
        C0403 r0 = C0403.m14185(context, R.string.label_watch_history_season_episode);
        if (cz == null || (detail3 = cz.f5242) == null || (obj = detail3.abbrSeqLabel) == null) {
            obj = (cz == null || (detail2 = cz.f5242) == null) ? null : Integer.valueOf(detail2.getSeasonNumber());
        }
        String r02 = r0.m14186("season", obj).m14186(PostPlayItem.POST_PLAY_ITEM_EPISODE, (cz == null || (detail = cz.f5242) == null) ? null : Integer.valueOf(detail.getEpisodeNumber())).m14186("title", cz != null ? cz.getTitle() : null).m14188();
        C1457Fr.m5016((Object) r02, "ICUMessageFormat.getForm…                .format()");
        return r02;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m10733(Context context) {
        ABTestConfig.Cell r2;
        if (context == null || (r2 = C1272.m16797(C0654.class, context)) == null) {
            return "";
        }
        switch (C2156so.f10240[r2.ordinal()]) {
            case 1:
            case 2:
                String string = context.getResources().getString(R.string.label_watch_history_screen_cell_2);
                C1457Fr.m5016((Object) string, "context.resources.getStr…ch_history_screen_cell_2)");
                return string;
            case 3:
                String string2 = context.getResources().getString(R.string.label_watch_history_screen_cell_3);
                C1457Fr.m5016((Object) string2, "context.resources.getStr…ch_history_screen_cell_3)");
                return string2;
            case 4:
                String string3 = context.getResources().getString(R.string.label_watch_history_screen_cell_4);
                C1457Fr.m5016((Object) string3, "context.resources.getStr…ch_history_screen_cell_4)");
                return string3;
            default:
                return "";
        }
    }
}
