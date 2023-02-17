package com.netflix.mediaclient.ui.common;

import android.content.Intent;
import android.util.Pair;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import o.ActivityC2153sl;
import o.ActivityC2280wv;
import o.C0505;
import o.C1278;
import o.C1283;
import o.C1305Ag;
import o.C1349Bv;
import o.C2059ph;
import o.oG;
import o.oX;
import o.pF;
import o.uT;
public final class PlaybackLauncher {

    public enum PlayLaunchedBy {
        HomeScreen,
        DetailsScreen,
        PlayerScreen,
        LaunchActivity,
        Unknown
    }

    public enum PlaybackTarget {
        local,
        remote,
        remoteButNotAvailable,
        localButDisabled
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m1617(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar) {
        m1609(netflixActivity, pFVar, videoType, oXVar, -1, false, false, false, 0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m1609(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i, boolean z, boolean z2, boolean z3, int i2) {
        C1283.m16854("nf_play", "Playable to playback: " + pFVar);
        if (pFVar.isPlayableEpisode()) {
            videoType = VideoType.EPISODE;
        }
        m1612(netflixActivity, pFVar.getPlayableId(), videoType, oXVar, i, z, z2, z3, false, i2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m1610(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        C1283.m16854("nf_play", "Playable to playback: " + pFVar);
        if (pFVar.isPlayableEpisode()) {
            videoType = VideoType.EPISODE;
        }
        m1612(netflixActivity, pFVar.getPlayableId(), videoType, oXVar, i, z, z2, z3, z4, 0);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m1612(NetflixActivity netflixActivity, String str, VideoType videoType, oX oXVar, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        Intent intent = new Intent(netflixActivity, ActivityC2280wv.class);
        intent.addFlags(131072);
        intent.addFlags(268435456);
        intent.putExtra("SeamlessMode", z);
        intent.putExtra("advisory_disabled", z2);
        intent.putExtra("is_pin_verified", z3);
        intent.putExtra("extra_skip_preplay", z4);
        intent.putExtra("play_launched_by", m1606(netflixActivity).ordinal());
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_ID, str);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        intent.putExtra("extra_bookmark_seconds_from_start_param", i);
        intent.putExtra(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
        intent.putExtra("EXTRA_AUTO_PLAY_COUNT", i2);
        netflixActivity.startActivity(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static PlayLaunchedBy m1606(NetflixActivity netflixActivity) {
        if (netflixActivity instanceof DetailsActivity) {
            return PlayLaunchedBy.DetailsScreen;
        }
        if (netflixActivity instanceof ActivityC2153sl) {
            if (netflixActivity.getFragmentHelper().mo10700()) {
                return PlayLaunchedBy.DetailsScreen;
            }
            return PlayLaunchedBy.HomeScreen;
        } else if (netflixActivity instanceof ActivityC2280wv) {
            return PlayLaunchedBy.PlayerScreen;
        } else {
            if (netflixActivity instanceof LaunchActivity) {
                return PlayLaunchedBy.LaunchActivity;
            }
            return PlayLaunchedBy.Unknown;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static PlaybackTarget m1603(C2059ph phVar) {
        if (phVar == null || !phVar.mo9519() || phVar.m9811() == null) {
            C1283.m16850("nf_play", "MDX or service manager are null! That should NOT happen. Default to local.");
            if (phVar == null || phVar.m9827() == null) {
                C1283.m16865("nf_play", "Service manager not available or ready! Guess that local playback is enabled! We should never end here!");
                return PlaybackTarget.local;
            } else if (phVar.m9827().mo16520().mo14182()) {
                C1283.m16865("nf_play", "MDX manager null, but configuration exist and local playback is enabled, go local.");
                return PlaybackTarget.local;
            } else {
                C1283.m16865("nf_play", "MDX manager null, but configuration exist and local playback is disabled, display an error.");
                return PlaybackTarget.localButDisabled;
            }
        } else {
            boolean r2 = phVar.m9827().mo16520().mo14182();
            oG r3 = phVar.m9811();
            m1618(r3);
            String r4 = r3.mo6171();
            if (C1349Bv.m4113(r4)) {
                if (r2) {
                    C1283.m16854("nf_play", "Local target, play on device");
                    return PlaybackTarget.local;
                }
                C1283.m16854("nf_play", "Local target, but local playback disabled. Try to find at least one remote target");
                Pair<String, String>[] r5 = phVar.m9811().mo6163();
                if (r5 == null || r5.length < 1) {
                    C1283.m16854("nf_play", "Local target, local playback disabled and no remote targets. Display an error.");
                    return PlaybackTarget.localButDisabled;
                }
                phVar.m9811().mo6180((String) r5[0].first);
                return PlaybackTarget.remote;
            } else if (m1614(r3, r4)) {
                return PlaybackTarget.remote;
            } else {
                if (r2) {
                    C1283.m16854("nf_play", "Remote target not available and local playback enabled, play on device");
                    return PlaybackTarget.local;
                }
                C1283.m16854("nf_play", "Remote target not available and local playback disabled, report an error!");
                return PlaybackTarget.remoteButNotAvailable;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m1618(oG oGVar) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m1614(oG oGVar, String str) {
        if (!oGVar.r_()) {
            C1283.m16865("nf_play", "MDX service is NOT ready");
            return false;
        }
        Pair<String, String>[] r2 = oGVar.mo6163();
        if (r2 == null || r2.length < 1) {
            C1283.m16865("nf_play", "No MDX remote targets found");
            return false;
        }
        for (Pair<String, String> pair : r2) {
            if (str.equals(pair.first)) {
                C1283.m16854("nf_play", "Target found");
                return true;
            }
        }
        C1283.m16865("nf_play", "Target NOT found!");
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m1607(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar) {
        m1605(netflixActivity, pFVar, videoType, oXVar, -1);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m1613(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i) {
        m1611(netflixActivity, pFVar, videoType, oXVar, true, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m1605(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i) {
        switch (m1603(netflixActivity.getServiceManager())) {
            case local:
                m1611(netflixActivity, pFVar, videoType, oXVar, false, i);
                return;
            case remote:
                m1611(netflixActivity, pFVar, videoType, oXVar, true, i);
                return;
            case localButDisabled:
                m1615(netflixActivity, R.string.local_playback_disabled);
                return;
            case remoteButNotAvailable:
                m1615(netflixActivity, R.string.local_playback_disabled_and_remote_taget_not_available);
                return;
            default:
                return;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m1608(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i) {
        m1611(netflixActivity, pFVar, videoType, oXVar, true, i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m1604(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i) {
        m1611(netflixActivity, pFVar, videoType, oXVar, false, i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m1616(NetflixActivity netflixActivity, String str, boolean z, VideoType videoType, oX oXVar, boolean z2, int i) {
        if (z2) {
            C1283.m16854("nf_play", "Starting MDX remote playback");
            if (!uT.m11653(netflixActivity, str, videoType, z, oXVar, i, false)) {
                C1283.m16865("nf_play", "SPY-5248 -  request is not sent to target, no need to change miniplayer state");
            }
        } else if (netflixActivity.getServiceManager().m9827() == null || netflixActivity.getServiceManager().m9827().mo16520() == null || !netflixActivity.getServiceManager().m9827().mo16520().mo14182()) {
            C1283.m16865("nf_play", "Local playback is disabled, we can not start playback!");
            m1615(netflixActivity, R.string.local_playback_disabled);
        } else {
            C1283.m16854("nf_play", "Start local playback");
            m1612(netflixActivity, str, videoType, oXVar, i, false, false, true, false, 0);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m1615(NetflixActivity netflixActivity, int i) {
        netflixActivity.displayDialog(C0505.m14491(netflixActivity, null, new C1278("", netflixActivity.getString(i), null, null)));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m1611(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, boolean z, int i) {
        if (pFVar.isPlayableEpisode()) {
            videoType = VideoType.EPISODE;
        }
        String playableId = (videoType == VideoType.EPISODE || videoType == VideoType.MOVIE) ? pFVar.getPlayableId() : pFVar.getTopLevelId();
        C1283.m16851("nf_play", "nf_pin verifyPinAndPlay - %s ageProtected: %b, pinProtected:%b, previewProtected: %b", pFVar.getPlayableId(), Boolean.valueOf(pFVar.isAgeProtected()), Boolean.valueOf(pFVar.isPinProtected()), Boolean.valueOf(pFVar.isPreviewProtected()));
        C1305Ag.m3609(netflixActivity, pFVar.isAgeProtected(), new PlayVerifierVault(PlayVerifierVault.RequestedBy.PLAY_LAUNCHER.m2951(), playableId, pFVar.isPreviewProtected(), pFVar.isPinProtected(), videoType, z, oXVar, i));
    }
}
