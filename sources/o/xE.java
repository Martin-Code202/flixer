package o;

import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
public final class xE {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0260 f11958 = new C0260(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PublishSubject<If> f11959;

    public xE() {
        PublishSubject<If> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create()");
        this.f11959 = create;
    }

    /* renamed from: o.xE$ˋ  reason: contains not printable characters */
    public static final class C0260 {
        private C0260() {
        }

        public /* synthetic */ C0260(C1456Fq fq) {
            this();
        }
    }

    public static final class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Status f11960;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f11961;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final pT f11962;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final oX f11963;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final IPlayer.PlaybackType f11964;

        public If(pT pTVar, Status status, IPlayer.PlaybackType playbackType, oX oXVar, int i) {
            C1457Fr.m5025(status, "status");
            C1457Fr.m5025(playbackType, "playbackType");
            C1457Fr.m5025(oXVar, "playContext");
            this.f11962 = pTVar;
            this.f11960 = status;
            this.f11964 = playbackType;
            this.f11963 = oXVar;
            this.f11961 = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ If(pT pTVar, Status status, IPlayer.PlaybackType playbackType, oX oXVar, int i, int i2, C1456Fq fq) {
            this((i2 & 1) != 0 ? null : pTVar, status, (i2 & 4) != 0 ? IPlayer.PlaybackType.StreamingPlayback : playbackType, (i2 & 8) != 0 ? new oB("PlayerRepository") : oXVar, (i2 & 16) != 0 ? -1 : i);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final pT m12751() {
            return this.f11962;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final Status m12750() {
            return this.f11960;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final IPlayer.PlaybackType m12749() {
            return this.f11964;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final oX m12748() {
            return this.f11963;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final int m12752() {
            return this.f11961;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Observable<If> m12747(C2059ph phVar, String str, VideoType videoType, oX oXVar, int i) {
        C1457Fr.m5025(phVar, "serviceManager");
        C1457Fr.m5025(str, "videoId");
        C1457Fr.m5025(videoType, "videoType");
        C1457Fr.m5025(oXVar, "playContext");
        if (vO.m12022(phVar, str)) {
            m12743(str, oXVar, i);
        } else {
            m12744(phVar, str, videoType, oXVar, i);
        }
        return this.f11959;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Observable<If> m12746() {
        return this.f11959;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m12744(C2059ph phVar, String str, VideoType videoType, oX oXVar, int i) {
        switch (xB.f11954[videoType.ordinal()]) {
            case 1:
                phVar.m9764().mo9513(str, (String) null, new C2286iF(this, oXVar, i));
                return;
            case 2:
                phVar.m9764().mo9503(str, (String) null, new C2286iF(this, oXVar, i));
                return;
            case 3:
                phVar.m9764().mo9484(str, null, new C2286iF(this, oXVar, i));
                return;
            default:
                PublishSubject<If> publishSubject = this.f11959;
                NetflixImmutableStatus netflixImmutableStatus = AbstractC0367.f13241;
                C1457Fr.m5016((Object) netflixImmutableStatus, "CommonStatus.INTERNAL_ERROR");
                publishSubject.onNext(new If(null, netflixImmutableStatus, null, null, 0, 29, null));
                return;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m12743(String str, oX oXVar, int i) {
        C2098qr r9 = C2093qn.m10096(str);
        PublishSubject<If> publishSubject = this.f11959;
        C2098qr qrVar = r9;
        NetflixImmutableStatus netflixImmutableStatus = r9 != null ? AbstractC0367.f13235 : AbstractC0367.f13246;
        C1457Fr.m5016((Object) netflixImmutableStatus, "if (videoDetails != null…NT_ERR_REALM_DETAILS_NULL");
        publishSubject.onNext(new If(qrVar, netflixImmutableStatus, IPlayer.PlaybackType.OfflinePlayback, oXVar, 0, 16, null));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m12742(pT pTVar, Status status, oX oXVar, int i) {
        this.f11959.onNext(new If(pTVar, status, null, oXVar, i, 4, null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.xE$iF  reason: case insensitive filesystem */
    public final class C2286iF extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final oX f11965;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f11966;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ xE f11967;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2286iF(xE xEVar, oX oXVar, int i) {
            super("PlayerRepository");
            C1457Fr.m5025(oXVar, "playContext");
            this.f11967 = xEVar;
            this.f11965 = oXVar;
            this.f11966 = i;
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            C1457Fr.m5025(status, "status");
            super.onMovieDetailsFetched(pPVar, status);
            this.f11967.m12742(pPVar, status, this.f11965, this.f11966);
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            C1457Fr.m5025(status, "status");
            super.onShowDetailsFetched(pRVar, status);
            this.f11967.m12742(pRVar, status, this.f11965, this.f11966);
        }

        @Override // o.oP, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            C1457Fr.m5025(status, "res");
            super.onEpisodeDetailsFetched(pIVar, status);
            this.f11967.m12742(pIVar, status, this.f11965, this.f11966);
        }
    }
}
