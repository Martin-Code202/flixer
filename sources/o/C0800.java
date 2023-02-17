package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.model.leafs.Video;
import java.util.List;
/* renamed from: o.ᒱ  reason: contains not printable characters */
public class C0800 implements AbstractC0695 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f14495;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14496;

    public C0800(int i, String str) {
        this.f14496 = i;
        this.f14495 = str;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return list.size() > 1;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        String str2 = list.get(1);
        String str3 = null;
        if (list.size() > 3) {
            str3 = list.get(3);
        }
        m15298(str2, str3, netflixActivity, str);
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private NflxHandler.Response m15298(final String str, final String str2, final NetflixActivity netflixActivity, final String str3) {
        netflixActivity.getServiceManager().m9764().mo9471(str, new AbstractC2061pj() { // from class: o.ᒱ.3
            @Override // o.AbstractC2061pj, o.oU
            public void onVideoSummaryFetched(Video.Summary summary, Status status) {
                if (!status.mo298() || summary == null) {
                    C1276.m16820().mo5731(new Throwable("SPY-7518 - got error trying to fetch video summary for: " + str));
                    C1328Ba.m3984(netflixActivity);
                    return;
                }
                C0800.this.m15300(netflixActivity, summary.getType(), str, str2, str3);
            }
        });
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᒱ$iF */
    public class iF extends AbstractC2061pj {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ String f14508;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f14509;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ VideoType f14511;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ NetflixActivity f14512;

        /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;)V */
        iF(String str, NetflixActivity netflixActivity, VideoType videoType, String str2) {
            this.f14512 = netflixActivity;
            this.f14511 = videoType;
            this.f14508 = str2;
            this.f14509 = str;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            if (status.mo298()) {
                C0800.this.m15301(this.f14512, this.f14511, pPVar.getPlayable(), this.f14508, C1328Ba.m3992(this.f14509));
            }
            C1328Ba.m3984(this.f14512);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            if (status.mo298()) {
                C0800.this.m15301(this.f14512, this.f14511, pIVar.getPlayable(), this.f14508, C1328Ba.m3992(this.f14509));
            }
            C1328Ba.m3984(this.f14512);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            if (status.mo298()) {
                C0800.this.m15301(this.f14512, this.f14511, pRVar.getPlayable(), this.f14508, C1328Ba.m3992(this.f14509));
            }
            C1328Ba.m3984(this.f14512);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15300(NetflixActivity netflixActivity, VideoType videoType, String str, String str2, String str3) {
        if (VideoType.MOVIE.equals(videoType)) {
            netflixActivity.getServiceManager().m9764().mo9513(str, this.f14495, new iF(str3, netflixActivity, videoType, str2));
        } else if (VideoType.EPISODE.equals(videoType)) {
            netflixActivity.getServiceManager().m9764().mo9484(str, this.f14495, new iF(str3, netflixActivity, videoType, str2));
        } else if (VideoType.SHOW.equals(videoType)) {
            netflixActivity.getServiceManager().m9764().mo9503(str, (String) null, new iF(str3, netflixActivity, videoType, str2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15301(final NetflixActivity netflixActivity, final VideoType videoType, final pF pFVar, final String str, final oX oXVar) {
        if (C1349Bv.m4107(this.f14495)) {
            netflixActivity.getServiceManager().m9764().mo9479(videoType, pFVar.getPlayableId(), this.f14495, new AbstractC2061pj() { // from class: o.ᒱ.2
                @Override // o.AbstractC2061pj, o.oU
                public void onScenePositionFetched(int i, Status status) {
                    if (status.mo298()) {
                    }
                    C0800.this.m15299(netflixActivity, pFVar, videoType, str, oXVar);
                }
            });
        } else {
            m15299(netflixActivity, pFVar, videoType, str, oXVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15299(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, String str, oX oXVar) {
        if (C1349Bv.m4113(str)) {
            C1283.m16854("NetflixComWatchHandler", "Starting local playback");
            PlaybackLauncher.m1604(netflixActivity, pFVar, videoType, oXVar, this.f14496);
            return;
        }
        oG r2 = netflixActivity.getServiceManager().m9811();
        if (r2 == null) {
            C1283.m16854("NetflixComWatchHandler", "MDX is null, go local playback");
        } else {
            C1283.m16854("NetflixComWatchHandler", "MDX exist, check if target is available");
            if (r2.mo6177(str)) {
                C0808.m15373(netflixActivity);
                PlaybackLauncher.m1608(netflixActivity, pFVar, videoType, oXVar, this.f14496);
                return;
            }
            C1283.m16854("NetflixComWatchHandler", "MDX does not know target dial UUID, go local playback");
        }
        PlaybackLauncher.m1604(netflixActivity, pFVar, videoType, oXVar, this.f14496);
    }
}
