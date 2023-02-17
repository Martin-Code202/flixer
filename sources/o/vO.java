package o;

import android.content.Context;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import java.util.List;
public class vO {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m12022(C2059ph phVar, String str) {
        pV r2 = m12017(phVar, str);
        return r2 != null && r2.mo6881() == DownloadState.Complete;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static pV m12017(C2059ph phVar, String str) {
        if (phVar != null) {
            return phVar.m9766(str);
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static oX m12020(pV pVVar) {
        if (pVVar == null || pVVar.mo6907() != qN.f9513.getTrackId()) {
            return qN.f9515;
        }
        return qN.f9513;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m12027(pV pVVar) {
        return pVVar.mo6881() == DownloadState.Complete && pVVar.mo6912().m1586();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m12016(pV pVVar) {
        return pVVar.mo6881() == DownloadState.Complete && !pVVar.mo6912().m1586();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m12014(final NetflixActivity netflixActivity) {
        if (netflixActivity != null && netflixActivity.getServiceManager() != null) {
            netflixActivity.getServiceManager().m9764().mo9493(new oP("offlineUiHelper") { // from class: o.vO.5
                @Override // o.oP, o.oU
                public void onGenreListsFetched(List<GenreList> list, Status status) {
                    super.onGenreListsFetched(list, status);
                    if (status.mo301()) {
                        C1283.m16865("offlineUiHelper", "Invalid status code for genres fetch");
                    } else if (list != null && list.size() > 1) {
                        for (GenreList genreList : list) {
                            if (genreList != null && "1647397".compareToIgnoreCase(genreList.getId()) == 0) {
                                ActivityC2153sl.m10769(netflixActivity, genreList);
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m12025(Context context, String str, VideoType videoType, oX oXVar) {
        if (context != null) {
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(context, NetflixActivity.class);
            if (netflixActivity == null) {
                C1283.m16862("offlineUiHelper", "netflixActivity is null");
                return;
            }
            C2059ph serviceManager = netflixActivity.getServiceManager();
            if (serviceManager == null) {
                C1283.m16862("offlineUiHelper", "serviceManager is null");
                return;
            }
            AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(netflixActivity);
            if (offlineAgentOrNull == null) {
                C1283.m16862("offlineUiHelper", "offlineAgentInterface is null");
                return;
            }
            C2098qr r5 = C2093qn.m10096(str);
            if (r5 == null) {
                C1283.m16862("offlineUiHelper", "videoDetails is null");
                return;
            }
            pF playable = r5.getPlayable();
            if (playable == null) {
                C1283.m16862("offlineUiHelper", "playable is null");
            } else if (videoType == null) {
                C1283.m16862("offlineUiHelper", "type is null");
            } else {
                pV r7 = m12029(offlineAgentOrNull).mo11976(str);
                if (r7 == null) {
                    C1283.m16862("offlineUiHelper", "offlinePlayableViewData is null");
                } else if (r7.mo6881() != DownloadState.Complete) {
                    C1283.m16862("offlineUiHelper", "download is not complete yet");
                } else {
                    int playableBookmarkPosition = playable.getPlayableBookmarkPosition();
                    C2052pa r10 = m12023(serviceManager, serviceManager.m9835(), str);
                    if (r10 != null) {
                        playableBookmarkPosition = r10.mBookmarkInSecond;
                    }
                    PlaybackLauncher.m1605(netflixActivity, r5.getPlayable(), r5.getType(), oXVar, C1352By.m4135(playableBookmarkPosition, playable.getEndtime(), playable.getRuntime()));
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m12026(Context context, boolean z) {
        C1339Bl.m4048(context, "prefs_offline_snackbar_user_swiped", z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m12018(Context context) {
        return C1339Bl.m4051(context, "prefs_offline_snackbar_user_swiped", false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m12024(Context context) {
        int r5 = m12028(context) + 1;
        C1283.m16863("offlineUiHelper", "incrementSnackBarDownloadCompleteCount count=%d", Integer.valueOf(r5));
        C1339Bl.m4042(context, "prefs_offline_snackbar_dl_complete_count", r5);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m12021(Context context) {
        C1283.m16862("offlineUiHelper", "resetSnackBarDownloadCompleteCount count=0");
        C1339Bl.m4042(context, "prefs_offline_snackbar_dl_complete_count", 0);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m12028(Context context) {
        return C1339Bl.m4037(context, "prefs_offline_snackbar_dl_complete_count", 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m12019(pV pVVar) {
        return pVVar.mo6885().mo296() || (pVVar.mo6881() == DownloadState.Stopped && pVVar.mo6911().m1581());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C2052pa m12023(C2059ph phVar, String str, String str2) {
        BookmarkStore r1;
        if (phVar == null || (r1 = phVar.m9831()) == null) {
            return null;
        }
        return r1.getBookmark(str, str2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m12015(C2059ph phVar, String str, C2052pa paVar) {
        BookmarkStore r0;
        if (phVar != null && (r0 = phVar.m9831()) != null) {
            r0.setBookmark(str, paVar);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static vM m12029(AbstractC1853hl hlVar) {
        return NetflixApplication.getInstance().m251().m12032();
    }
}
