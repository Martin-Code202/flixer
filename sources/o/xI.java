package o;

import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.l10n.BidiMarker;
public final class xI {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final xI f12010 = new xI();

    private xI() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m12777(pF pFVar) {
        String str;
        if (pFVar == null) {
            return "";
        }
        String r5 = BX.m3956(pFVar.getParentTitle(), BidiMarker.FORCED_RTL);
        String r6 = BX.m3956(pFVar.getPlayableTitle(), BidiMarker.FORCED_RTL);
        if (pFVar.isPlayableEpisode()) {
            NetflixApplication instance = NetflixApplication.getInstance();
            C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
            str = instance.getResources().getString(R.string.title_episode_string_player, pFVar.getSeasonAbbrSeqLabel(), Integer.valueOf(pFVar.getEpisodeNumber()), r6);
            C1457Fr.m5016((Object) str, "NetflixApplication.getIn…pisodeNumber, childTitle)");
            if (pFVar.isNSRE() || pFVar.isEpisodeNumberHidden()) {
                NetflixApplication instance2 = NetflixApplication.getInstance();
                C1457Fr.m5016((Object) instance2, "NetflixApplication.getInstance()");
                str = instance2.getResources().getString(R.string.title_episode_string_basic, r5, r6);
                C1457Fr.m5016((Object) str, "NetflixApplication.getIn… parentTitle, childTitle)");
            }
        } else {
            NetflixApplication instance3 = NetflixApplication.getInstance();
            C1457Fr.m5016((Object) instance3, "NetflixApplication.getInstance()");
            str = instance3.getResources().getString(R.string.title_movie_string, r6);
            C1457Fr.m5016((Object) str, "NetflixApplication.getIn…movie_string, childTitle)");
        }
        return C1349Bv.m4102(str).toString();
    }
}
