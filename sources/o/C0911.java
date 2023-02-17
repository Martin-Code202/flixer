package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.BaseNflxHandler;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import java.util.Map;
import o.C1328Ba;
/* access modifiers changed from: package-private */
/* renamed from: o.ᖬ  reason: contains not printable characters */
public class C0911 extends BaseNflxHandler {
    public C0911(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        C1283.m16846("NflxHandler", "handlePlayAction starts...");
        String r2 = C1328Ba.m3977((String) this.f1041.get("targetid"));
        C1328Ba.C0070 r3 = m489();
        if (r3 == null) {
            C1283.m16850("NflxHandler", "handlePlayAction fails, no video info found!");
            return NflxHandler.Response.NOT_HANDLING;
        } else if (r3.m4000()) {
            C1283.m16846("NflxHandler", "handlePlayAction ends, handling with delay.");
            return NflxHandler.Response.HANDLING_WITH_DELAY;
        } else {
            C1283.m16846("NflxHandler", "handlePlayAction, handling.");
            VideoType r4 = r3.m3999();
            if (r4 == VideoType.MOVIE || r4 == VideoType.SHOW) {
                m15710(r3.m3998(), r4, r2, C1328Ba.m3990(this.f1041));
                return NflxHandler.Response.HANDLING_WITH_DELAY;
            } else if (r4 != VideoType.EPISODE) {
                return NflxHandler.Response.NOT_HANDLING;
            } else {
                String r5 = C1328Ba.m3981(this.f1041);
                if (C1349Bv.m4113(r5)) {
                    C1283.m16846("NflxHandler", "no episode id");
                    return NflxHandler.Response.NOT_HANDLING;
                }
                m15710(r5, VideoType.EPISODE, r2, C1328Ba.m3990(this.f1041));
                return NflxHandler.Response.HANDLING_WITH_DELAY;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᖬ$ˊ  reason: contains not printable characters */
    public class C0912 extends AbstractC2061pj {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ String f14796;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f14798;

        /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;)V */
        C0912(String str, String str2) {
            this.f14796 = str2;
            this.f14798 = str;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            if (status.mo298()) {
                C0911.this.m15711(pPVar, this.f14796, C1328Ba.m3992(this.f14798));
            }
            C1328Ba.m3984(C0911.this.f1040);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            if (status.mo298()) {
                C0911.this.m15711(pIVar, this.f14796, C1328Ba.m3992(this.f14798));
            }
            C1328Ba.m3984(C0911.this.f1040);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            if (status.mo298()) {
                C0911.this.m15711(pRVar, this.f14796, C1328Ba.m3992(this.f14798));
            }
            C1328Ba.m3984(C0911.this.f1040);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15710(String str, VideoType videoType, String str2, String str3) {
        if (VideoType.MOVIE.equals(videoType)) {
            this.f1040.getServiceManager().m9764().mo9513(str, (String) null, new C0912(str3, str2));
        } else if (VideoType.EPISODE.equals(videoType)) {
            this.f1040.getServiceManager().m9764().mo9484(str, null, new C0912(str3, str2));
        } else if (VideoType.SHOW.equals(videoType)) {
            this.f1040.getServiceManager().m9764().mo9503(str, (String) null, new C0912(str3, str2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15711(pT pTVar, String str, oX oXVar) {
        if (C1349Bv.m4113(str)) {
            C1283.m16854("NflxHandler", "Starting local playback");
            PlaybackLauncher.m1617(this.f1040, pTVar.getPlayable(), pTVar.getType(), oXVar);
            return;
        }
        oG r4 = this.f1040.getServiceManager().m9811();
        if (r4 == null) {
            C1283.m16854("NflxHandler", "MDX is null, go local playback");
        } else {
            C1283.m16854("NflxHandler", "MDX exist, check if target is available");
            if (r4.mo6177(str)) {
                m487();
                PlaybackLauncher.m1608(this.f1040, pTVar.getPlayable(), pTVar.getType(), oXVar, -1);
                return;
            }
            C1283.m16854("NflxHandler", "MDX does not know target dial UUID, go local playback");
        }
        PlaybackLauncher.m1617(this.f1040, pTVar.getPlayable(), pTVar.getType(), oXVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ˋ */
    public NflxHandler.Response mo485(String str, String str2, String str3) {
        if (str != null) {
            m15710(str, VideoType.MOVIE, str2, str3);
            return NflxHandler.Response.HANDLING_WITH_DELAY;
        }
        C1283.m16850("NflxHandler", "Video ID not found, return to LOLOMO");
        m487();
        return NflxHandler.Response.HANDLING;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ॱ */
    public NflxHandler.Response mo488(String str, String str2, String str3) {
        m15710(str, VideoType.EPISODE, str2, str3);
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }
}
