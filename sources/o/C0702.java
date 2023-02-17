package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.Video;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.โ  reason: contains not printable characters */
public class C0702 implements AbstractC0695 {
    C0702() {
    }

    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return true;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        C1283.m16846("NetflixComDownloadHandler", "Starting download activity");
        String str2 = list.get(1);
        if (C1349Bv.m4113(str2)) {
            return NflxHandler.Response.NOT_HANDLING;
        }
        m15015(str2, netflixActivity, str);
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15015(final String str, final NetflixActivity netflixActivity, final String str2) {
        if (netflixActivity.getServiceManager().m9764() != null) {
            netflixActivity.getServiceManager().m9764().mo9471(str, new AbstractC2061pj() { // from class: o.โ.1
                @Override // o.AbstractC2061pj, o.oU
                public void onVideoSummaryFetched(Video.Summary summary, Status status) {
                    if (!status.mo298() || summary == null) {
                        C1276.m16820().mo5731(new Throwable("NetflixComDownloadHandler - got error trying to fetch video summary for: " + str));
                        C1328Ba.m3984(netflixActivity);
                        return;
                    }
                    C0702.this.m15016(netflixActivity, summary.getType(), str, str2);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.โ$ˋ  reason: contains not printable characters */
    public class C0703 extends AbstractC2061pj {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ NetflixActivity f14221;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f14223;

        /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;)V */
        C0703(String str, NetflixActivity netflixActivity) {
            this.f14221 = netflixActivity;
            this.f14223 = str;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            if (status.mo298()) {
                C0702.this.m15014(this.f14221, pPVar, C1328Ba.m3992(this.f14223));
            }
            C1328Ba.m3984(this.f14221);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            if (status.mo298()) {
                C0702.this.m15014(this.f14221, pIVar, C1328Ba.m3992(this.f14223));
            }
            C1328Ba.m3984(this.f14221);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15016(NetflixActivity netflixActivity, VideoType videoType, String str, String str2) {
        if (netflixActivity.getServiceManager().m9764() != null) {
            if (VideoType.MOVIE.equals(videoType)) {
                netflixActivity.getServiceManager().m9764().mo9513(str, (String) null, new C0703(str2, netflixActivity));
            } else if (VideoType.EPISODE.equals(videoType)) {
                netflixActivity.getServiceManager().m9764().mo9484(str, null, new C0703(str2, netflixActivity));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15014(NetflixActivity netflixActivity, pT pTVar, oX oXVar) {
        if (netflixActivity.getServiceManager().m9832() != null) {
            C0808.m15368(netflixActivity, pTVar.getPlayable(), pTVar.getType(), oXVar);
        }
    }
}
