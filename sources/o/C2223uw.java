package o;

import android.content.Context;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.PostPlayItem;
import com.netflix.model.leafs.originals.BillboardCTA;
/* renamed from: o.uw  reason: case insensitive filesystem */
public final class C2223uw {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m11782(C2059ph phVar, pJ pJVar, BillboardCTA billboardCTA, oU oUVar) {
        if (!C1349Bv.m4113(billboardCTA.getName()) && !C1349Bv.m4113(billboardCTA.getVideoId())) {
            String lowerCase = billboardCTA.getName().toLowerCase();
            if (lowerCase.contains("trailer") || lowerCase.contains("recap")) {
                phVar.m9764().mo9513(billboardCTA.getVideoId(), (String) null, oUVar);
            } else if (lowerCase.contains("season")) {
                if (lowerCase.contains("continue")) {
                    phVar.m9764().mo9503(pJVar.getId(), (String) null, oUVar);
                } else {
                    phVar.m9764().mo9510(billboardCTA.getVideoId(), CmpTaskMode.FROM_CACHE_OR_NETWORK, VideoType.SEASON, 0, 1, oUVar);
                }
            } else if (lowerCase.contains(PostPlayItem.POST_PLAY_ITEM_EPISODE) || lowerCase.contains("show")) {
                phVar.m9764().mo9484(billboardCTA.getVideoId(), null, oUVar);
            } else if (pJVar.getType() == VideoType.MOVIE) {
                phVar.m9764().mo9513(billboardCTA.getVideoId(), (String) null, oUVar);
            } else {
                phVar.m9764().mo9503(billboardCTA.getVideoId(), (String) null, oUVar);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m11781(Context context, String str, String str2) {
        if (str == null) {
            str = "play";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2121234393:
                if (str.equals("playEpisode")) {
                    c = 1;
                    break;
                }
                break;
            case -1644011681:
                if (str.equals("playTrailer")) {
                    c = 4;
                    break;
                }
                break;
            case -1642704999:
                if (str.equals("rewatchShow")) {
                    c = 2;
                    break;
                }
                break;
            case -1119721862:
                if (str.equals("continueWatching")) {
                    c = 3;
                    break;
                }
                break;
            case 3443508:
                if (str.equals("play")) {
                    c = 7;
                    break;
                }
                break;
            case 109400031:
                if (str.equals("share")) {
                    c = 6;
                    break;
                }
                break;
            case 450861206:
                if (str.equals("listEpisodes")) {
                    c = 5;
                    break;
                }
                break;
            case 1568910135:
                if (str.equals("playSeason")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return context.getResources().getString(R.string.billboard_cta_season_n, str2);
            case 1:
                return context.getResources().getString(R.string.billboard_cta_episode_n);
            case 2:
                return context.getResources().getString(R.string.billboard_cta_rewatch_show);
            case 3:
                return context.getResources().getString(R.string.billboard_cta_continue_watching);
            case 4:
                return context.getResources().getString(R.string.billboard_cta_trailer);
            case 5:
                return context.getResources().getString(R.string.billboard_cta_list_episodes);
            case 6:
                return context.getResources().getString(R.string.share_button_name);
            case 7:
            default:
                return context.getResources().getString(R.string.billboard_cta_play);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m11783(String str) {
        return str != null && str.toLowerCase().contains("continue");
    }
}
