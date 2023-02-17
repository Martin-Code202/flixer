package o;

import android.content.Intent;
import android.os.Bundle;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class qU {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Set<VideoType> f9554 = new HashSet(Arrays.asList(VideoType.MOVIE, VideoType.SHOW, VideoType.CHARACTERS));

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9975(NetflixActivity netflixActivity, pJ pJVar, oX oXVar, String str, Bundle bundle) {
        m9965(netflixActivity, pJVar.getType(), pJVar.getId(), pJVar.getTitle(), oXVar, null, null, str, bundle, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9974(NetflixActivity netflixActivity, pJ pJVar, oX oXVar, String str) {
        if (!m9971(pJVar.getType())) {
            return;
        }
        if (!pJVar.isOriginal() || !pJVar.isPreRelease()) {
            m9965(netflixActivity, pJVar.getType(), pJVar.getId(), pJVar.getTitle(), oXVar, null, null, str, null, 0);
        } else {
            m9978(netflixActivity, pJVar.getType(), pJVar.getId(), pJVar.getTitle(), oXVar, null, null, str, null, 0);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9966(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar, String str3) {
        m9965(netflixActivity, videoType, str, str2, oXVar, null, null, str3, null, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9973(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar) {
        if (m9971(videoType)) {
            m9983(netflixActivity, videoType, str, str2, oXVar, null, null, null, 0, m9972(videoType));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Class<?> m9972(VideoType videoType) {
        return VideoType.MOVIE.equals(videoType) ? ActivityC2234vd.class : ActivityC2231va.class;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Class<?> m9977(NetflixActivity netflixActivity, VideoType videoType) {
        if ((netflixActivity instanceof ActivityC2234vd) || (netflixActivity instanceof ActivityC2231va)) {
            return m9972(videoType);
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9969(NetflixActivity netflixActivity, pJ pJVar, String str, String str2, oX oXVar, String str3) {
        if (!m9971(pJVar.getType())) {
            return;
        }
        if (!pJVar.isOriginal() || !pJVar.isPreRelease()) {
            m9965(netflixActivity, pJVar.getType(), str, str2, oXVar, null, null, str3, null, 0);
        } else {
            m9978(netflixActivity, pJVar.getType(), str, str2, oXVar, null, null, str3, null, 0);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9979(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar, String str3, Bundle bundle) {
        m9965(netflixActivity, videoType, str, str2, oXVar, null, null, str3, bundle, 0);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9981(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3, String str4) {
        if (m9971(videoType)) {
            m9965(netflixActivity, videoType, str, str2, oXVar, action, str3, str4, null, 0);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9970(NetflixActivity netflixActivity, pJ pJVar, oX oXVar, DetailsActivity.Action action, String str, String str2) {
        if (!m9971(pJVar.getType())) {
            return;
        }
        if (!pJVar.isOriginal() || !pJVar.isPreRelease()) {
            m9965(netflixActivity, pJVar.getType(), pJVar.getId(), pJVar.getTitle(), oXVar, action, str, str2, null, 0);
        } else {
            m9978(netflixActivity, pJVar.getType(), pJVar.getId(), pJVar.getTitle(), oXVar, action, str, str2, null, 0);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m9965(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3, String str4, Bundle bundle, int i) {
        BrowseExperience r10 = BrowseExperience.m1775();
        Class r11 = m9977(netflixActivity, videoType);
        if (r11 == null) {
            r11 = m9982(videoType);
        }
        if (r11 == null) {
            m9967(netflixActivity, r10, str, null, videoType, oXVar, str4);
        } else {
            m9983(netflixActivity, videoType, str, str2, oXVar, action, str3, bundle, i, r11);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m9983(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3, Bundle bundle, int i, Class<?> cls) {
        Intent r8 = m9976(netflixActivity, cls, videoType, str, str2, oXVar, action, str3);
        if (bundle != null) {
            r8.putExtras(bundle);
        }
        if (i > 0) {
            r8.addFlags(i);
        }
        netflixActivity.startActivity(r8);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m9978(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3, String str4, Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("extra_is_movie", videoType == VideoType.MOVIE);
        m9983(netflixActivity, videoType, str, str2, oXVar, action, str3, bundle, i, ActivityC2129rr.m10468());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m9971(VideoType videoType) {
        if (videoType != null) {
            return true;
        }
        C1276.m16820().mo5727("SPY-8330: Start intent must provide extra value: extra_video_type");
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001b: APUT  (r1v1 java.lang.Object[]), (3 ??[int, float, short, byte, char]), (r2v3 java.lang.Integer) */
    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m9967(NetflixActivity netflixActivity, BrowseExperience browseExperience, String str, String str2, VideoType videoType, oX oXVar, String str3) {
        Integer num;
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = videoType;
        if (oXVar == null) {
            num = null;
        } else {
            num = Integer.valueOf(oXVar.getTrackId());
        }
        objArr[3] = num;
        objArr[4] = str3;
        objArr[5] = browseExperience;
        String format = String.format("DetailsActivityLauncher - Don't know how to handle parent ID: %s, ep ID: %s, type: %s, trackId: %s, source: %s, experience: %s", objArr);
        C1283.m16865("DetailsActivityLauncher", format);
        if (netflixActivity.getServiceManager().m9825() != null) {
            netflixActivity.getServiceManager().m9825().mo1515().mo5714(format);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Intent m9976(NetflixActivity netflixActivity, Class<?> cls, VideoType videoType, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3) {
        Intent intent = new Intent(netflixActivity, cls);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_ID, str);
        intent.putExtra("extra_video_title", str2);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        intent.putExtra(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
        intent.putExtra("extra_model_view_id", netflixActivity.getUiScreen().ordinal());
        if (action != null) {
            intent.putExtra("extra_action", action);
        }
        if (str3 != null) {
            intent.putExtra("extra_action_token", str3);
        }
        if (cls.getName().contains("etails") && netflixActivity.getClass().getName().contains("etails")) {
            intent.putExtra("extra_same_activity_type", true);
        }
        return intent;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Intent m9980(NetflixActivity netflixActivity, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3) {
        Intent intent = null;
        Class<? extends DetailsActivity> r8 = m9982(VideoType.SHOW);
        if (r8 == null) {
            m9967(netflixActivity, BrowseExperience.m1775(), str, str2, VideoType.SHOW, oXVar, "getEpisodeDetailsIntent");
        } else {
            intent = new Intent(netflixActivity, r8).putExtra(NetflixActivity.EXTRA_VIDEO_ID, str).putExtra("extra_episode_id", str2).putExtra(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
            if (action != null) {
                intent.putExtra("extra_action", action);
            }
            intent.putExtra("extra_model_view_id", netflixActivity.getUiScreen().ordinal());
            if (str3 != null) {
                intent.putExtra("extra_action_token", str3);
            }
            intent.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, VideoType.SHOW.getValue());
        }
        return intent;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9968(NetflixActivity netflixActivity, String str, String str2, oX oXVar, DetailsActivity.Action action, String str3) {
        Intent r2 = m9980(netflixActivity, str, str2, oXVar, action, str3);
        if (r2 == null) {
            C1283.m16865("DetailsActivityLauncher", "Can't start activity - intent is null");
        } else {
            netflixActivity.startActivity(r2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Class<? extends DetailsActivity> m9982(VideoType videoType) {
        boolean equals = VideoType.MOVIE.equals(videoType);
        if (!f9554.contains(videoType)) {
            return null;
        }
        if (videoType == VideoType.CHARACTERS) {
            return ActivityC2174te.m11118();
        }
        return equals ? ActivityC2121rj.m10436() : ActivityC2132ru.m10478();
    }
}
