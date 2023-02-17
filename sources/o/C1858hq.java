package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.List;
import o.AbstractC1863hu;
import o.C2058pg;
import org.json.JSONObject;
/* renamed from: o.hq  reason: case insensitive filesystem */
public final class C1858hq extends AbstractC2068pq implements AbstractC1849hh {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Cif f7410 = new Cif(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1863hu f7411;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1863hu.AbstractC0118 f7412;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f7413;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final BroadcastReceiver f7414 = new C0117(this);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1853hl f7415;

    public C1858hq(AbstractC1853hl hlVar, AbstractC1863hu huVar) {
        C1457Fr.m5025(hlVar, "offlineAgent");
        C1457Fr.m5025(huVar, "offlineFalkor");
        this.f7415 = hlVar;
        this.f7411 = huVar;
        if (C0880.m15595() && mo7054()) {
            m7313();
        }
        this.f7412 = new C1859iF(this);
    }

    /* renamed from: o.hq$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m7324(String str) {
        this.f7413 = str;
    }

    /* renamed from: o.hq$ˊ  reason: contains not printable characters */
    public static final class C0117 extends BroadcastReceiver {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C1858hq f7418;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0117(C1858hq hqVar) {
            this.f7418 = hqVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1457Fr.m5025(context, "context");
            if (intent != null && this.f7418.mo7054()) {
                String action = intent.getAction();
                C2058pg.If r4 = C2058pg.m9731(intent);
                if (C1457Fr.m5018(r4.f9384, IPlayer.PlaybackType.OfflinePlayback)) {
                    C1283.m16854("SmartDownloadController", "PlayStopReceiver received an OfflinePlayback for videoId " + r4.f9385);
                    if (C1457Fr.m5018((Object) "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START", (Object) action)) {
                        this.f7418.m7324(r4.f9385);
                    } else if (C1457Fr.m5018((Object) "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP", (Object) action)) {
                        this.f7418.m7324((String) null);
                        C1858hq hqVar = this.f7418;
                        C1457Fr.m5016((Object) r4, "playerIntent");
                        hqVar.m7311(r4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m7311(C2058pg.If r5) {
        C2094qo qoVar = C2094qo.f9607;
        String str = r5.f9385;
        C1457Fr.m5016((Object) str, "playerIntent.mVideoId");
        C2098qr r3 = qoVar.m10098(str);
        if (r3 != null && C1457Fr.m5018(r3.getType(), VideoType.EPISODE)) {
            C1283.m16854("SmartDownloadController", "PlayStopReceiver received an OfflinePlayback episode");
            int i = r5.f9386;
            pF playable = r3.getPlayable();
            C1457Fr.m5016((Object) playable, "showData.playable");
            if (i >= playable.getEndtime()) {
                C1283.m16854("SmartDownloadController", "PlayStopReceiver received an OfflinePlayback episode that was finished, storing in Realm and start SD");
                C1276.m16820().mo5728("SmartDownloadController.playStartStopReceiver storing WatchedEpisode id: " + r5.f9385);
                C2094qo qoVar2 = C2094qo.f9607;
                pF playable2 = r3.getPlayable();
                C1457Fr.m5016((Object) playable2, "showData.playable");
                qoVar2.m10101(playable2);
                m7310();
            }
        }
    }

    @Override // o.AbstractC1854hm
    public boolean aa_() {
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7316() {
        C1348Bu.m4094();
        C1283.m16854("SmartDownloadController", "onUserAccountInActive received");
        m7309();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7322() {
        C1348Bu.m4094();
        C1283.m16854("SmartDownloadController", "onUserAccountActive received");
        if (C0880.m15595() && mo7054()) {
            C1283.m16854("SmartDownloadController", "onUserAccountActive received, registerPlayStopReceiver");
            m7313();
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final void m7313() {
        C1283.m16854("SmartDownloadController", "registerPlayStopReceiver");
        AG.m3331(AbstractApplicationC1258.m16692(), this.f7414, null, "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START", "com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private final void m7309() {
        C1283.m16854("SmartDownloadController", "unregisterPlayStopReceiver");
        AG.m3336(AbstractApplicationC1258.m16692(), this.f7414);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7323() {
        C1283.m16854("SmartDownloadController", "handleConnectivityChange");
        if (C0880.m15595()) {
            m7310();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private final void m7310() {
        if (C1889iq.m7739(this.f7415, AbstractApplicationC1258.m16692())) {
            for (T t : C2094qo.f9607.m10099()) {
                C1283.m16854("SmartDownloadController", "startSmartDownloadIfConnectivity is going to fetch show id " + t.getShowId());
                this.f7411.mo7341(t.getShowId(), VideoType.SHOW, 0, 1000, this.f7412);
            }
            return;
        }
        if (!C2094qo.f9607.m10099().isEmpty()) {
            this.f7415.mo7122();
        }
    }

    /* renamed from: o.hq$iF  reason: case insensitive filesystem */
    static final class C1859iF implements AbstractC1863hu.AbstractC0118 {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C1858hq f7417;

        C1859iF(C1858hq hqVar) {
            this.f7417 = hqVar;
        }

        @Override // o.AbstractC1863hu.AbstractC0118
        /* renamed from: ˊ  reason: contains not printable characters */
        public final void mo7325(List<pI> list, Status status) {
            if (status != null && status.mo301()) {
                C1283.m16850("SmartDownloadController", "Error status for onEpisodesFetched was " + status);
            } else if (list == null || list.isEmpty()) {
                C1276.m16820().mo5725("SmartDownloadController onSeasonsFetched seasons was null or empty");
            } else {
                C1283.m16854("SmartDownloadController", "onEpisodesFetched received " + list.size() + " episodes");
                C1858hq hqVar = this.f7417;
                pI pIVar = list.get(0);
                C1457Fr.m5016((Object) pIVar, "episodeList[0]");
                hqVar.m7318(pIVar);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m7318(pI pIVar) {
        C1457Fr.m5025(pIVar, "episodeDetails");
        if (pIVar instanceof C1383Cz) {
            C2094qo qoVar = C2094qo.f9607;
            String r1 = ((C1383Cz) pIVar).mo4565();
            C1457Fr.m5016((Object) r1, "episodeDetails.showId");
            List<C2100qt> r3 = qoVar.m10107(r1);
            if (r3.isEmpty()) {
                C1283.m16854("SmartDownloadController", "Empty watchedEpisodes for showId " + ((C1383Cz) pIVar).mo4565() + ", deleting the RealmWatchedShow to not request empty shows");
                C2094qo qoVar2 = C2094qo.f9607;
                String r12 = ((C1383Cz) pIVar).mo4565();
                C1457Fr.m5016((Object) r12, "episodeDetails.showId");
                qoVar2.m10102(r12);
                return;
            }
            this.f7415.mo7124(this);
            String r0 = ((C1383Cz) pIVar).mo4565();
            C1457Fr.m5016((Object) r0, "episodeDetails.showId");
            String r4 = m7317(r0, r3);
            AbstractC0929<? extends AbstractC0730> modelProxy = ((C1383Cz) pIVar).getModelProxy();
            for (C2100qt qtVar : r3) {
                if (qtVar.getEpisodeSmartDownloadedId() == null) {
                    C1457Fr.m5016((Object) modelProxy, "modelProxy");
                    C1383Cz r02 = m7315(modelProxy, r4);
                    String r8 = r02 != null ? r02.mo4562() : null;
                    C1276.m16820().mo5728("SmartDownloadController.downloadNextEpisodesForShow is going to enqueue episodeId " + r8);
                    C1283.m16854("SmartDownloadController", "is going to enqueue episodeId " + r8);
                    if (r8 != null) {
                        m7321(qtVar, r8);
                        r4 = r8;
                    } else {
                        C2094qo qoVar3 = C2094qo.f9607;
                        String r13 = ((C1383Cz) pIVar).mo4565();
                        C1457Fr.m5016((Object) r13, "episodeDetails.showId");
                        qoVar3.m10102(r13);
                        C1276.m16820().mo5728("SmartDownloadController.downloadNextEpisodesForShow nextEpisodeId was null after " + r4);
                        C1283.m16854("SmartDownloadController", "nextEpisodeId was null so exiting the loop");
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String m7317(String str, List<? extends C2100qt> list) {
        C1457Fr.m5025(str, "showId");
        C1457Fr.m5025(list, "watchedEpisodes");
        List<C2098qr> r2 = C2094qo.f9607.m10100(str);
        if (r2.isEmpty()) {
            String episodeId = ((C2100qt) EI.m4840((List<? extends Object>) list)).getEpisodeId();
            C1457Fr.m5016((Object) episodeId, "watchedEpisodes.last().episodeId");
            return episodeId;
        }
        C2100qt qtVar = (C2100qt) EI.m4840((List<? extends Object>) list);
        pF playable = ((C2098qr) EI.m4840((List<? extends Object>) r2)).getPlayable();
        int seasonNumber = qtVar.getSeasonNumber();
        C1457Fr.m5016((Object) playable, "lastDownloadedEpisode");
        if (seasonNumber < playable.getSeasonNumber() || qtVar.getEpisodeNumber() < playable.getEpisodeNumber()) {
            String playableId = playable.getPlayableId();
            C1457Fr.m5016((Object) playableId, "lastDownloadedEpisode.playableId");
            return playableId;
        }
        String episodeId2 = qtVar.getEpisodeId();
        C1457Fr.m5016((Object) episodeId2, "lastWatchedEpisode.episodeId");
        return episodeId2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m7321(C2100qt qtVar, String str) {
        C1457Fr.m5025(qtVar, "watchedEpisode");
        C1457Fr.m5025(str, "nextEpisodeId");
        C2094qo.f9607.m10103(qtVar, str);
        this.f7415.mo7141(str, VideoType.EPISODE, qN.f9513);
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2185(String str, Status status) {
        super.mo2185(str, status);
        C1283.m16854("SmartDownloadController", "onCreateRequestResponse received for playableId " + str + ", statusCode is " + (status != null ? status.mo302() : null));
        if (str != null && status != null && C1457Fr.m5018(status.mo302(), StatusCode.DL_NOT_ENOUGH_FREE_SPACE)) {
            C1283.m16854("SmartDownloadController", "onCreateRequestResponse received DL_NOT_ENOUGH_FREE_SPACE");
            C2100qt r3 = C2094qo.f9607.m10104(str);
            String episodeSmartDownloadedId = r3 != null ? r3.getEpisodeSmartDownloadedId() : null;
            if (r3 != null && episodeSmartDownloadedId != null) {
                C1276.m16820().mo5728("SmartDownloadController.onCreateRequestResponse received DL_NOT_ENOUGH_FREE_SPACE, will delete " + r3.getEpisodeId() + " and try again " + episodeSmartDownloadedId);
                C1283.m16854("SmartDownloadController", "onCreateRequestResponse received DL_NOT_ENOUGH_FREE_SPACE, will delete " + r3.getEpisodeId() + " and try again " + episodeSmartDownloadedId);
                String episodeId = r3.getEpisodeId();
                C1457Fr.m5016((Object) episodeId, "watchedEpisode.episodeId");
                if (m7320(episodeId)) {
                    this.f7415.mo7121(episodeSmartDownloadedId, VideoType.EPISODE, qN.f9513);
                }
            }
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2174(pV pVVar) {
        super.mo2174(pVVar);
        C1283.m16854("SmartDownloadController", "onDownloadCompleted received for offlinePlayableViewData playableId " + (pVVar != null ? pVVar.mo6915() : null));
        if (pVVar != null) {
            C2094qo qoVar = C2094qo.f9607;
            String r1 = pVVar.mo6915();
            C1457Fr.m5016((Object) r1, "offlinePlayableViewData.playableId");
            C2100qt r3 = qoVar.m10104(r1);
            if (r3 != null) {
                C1276.m16820().mo5728("SmartDownloadController.onDownloadCompleted received for " + pVVar.mo6915() + ". Will delete " + r3.getEpisodeId());
                C1283.m16854("SmartDownloadController", "onDownloadCompleted received, will delete watched episode " + r3.getEpisodeId());
                String episodeId = r3.getEpisodeId();
                C1457Fr.m5016((Object) episodeId, "watchedEpisode.episodeId");
                m7320(episodeId);
                C2094qo.f9607.m10105(r3);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m7320(String str) {
        C1457Fr.m5025(str, "playableId");
        if (C2094qo.f9607.m10098(str) == null) {
            return false;
        }
        if (C1457Fr.m5018((Object) str, (Object) this.f7413)) {
            C1276.m16820().mo5727("SPY-13954 SmartDownloadController deleteOfflinePlayable: the playableId " + str + " was used by the Player. Not deleting.");
            return false;
        }
        this.f7415.mo7140(str);
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final C1383Cz m7315(AbstractC0929<? extends AbstractC0730> r5, String str) {
        C1457Fr.m5025(r5, "modelProxy");
        C1457Fr.m5025(str, "episodeId");
        return (C1383Cz) r5.mo15251(C0859.m15528("episodes", str, C0859.m15523("detail")));
    }

    @Override // o.AbstractC1849hh
    /* renamed from: ˎ */
    public void mo7055(boolean z) {
        synchronized (this) {
            boolean r6 = mo7054();
            C1283.m16851("SmartDownloadController", "setSmartDownloadsEnabled oldValue=%b newValue=%b", Boolean.valueOf(r6), Boolean.valueOf(z));
            if (r6 != z) {
                C1339Bl.m4048(AbstractApplicationC1258.m16692(), "smart_downloads_preference", z);
            }
            if (z) {
                m7313();
                this.f7415.mo7124(this);
            } else {
                m7309();
                this.f7415.mo7135(this);
            }
            m7319(z);
            EA ea = EA.f5503;
        }
    }

    @Override // o.AbstractC1849hh
    /* renamed from: ˋ */
    public boolean mo7054() {
        boolean r6;
        synchronized (this) {
            r6 = C1339Bl.m4051(AbstractApplicationC1258.m16692(), "smart_downloads_preference", C0880.m15594());
        }
        return r6;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.hq$If */
    public static final class If implements AbstractC0574 {

        /* renamed from: ˏ  reason: contains not printable characters */
        public static final If f7416 = new If();

        If() {
        }

        @Override // o.AbstractC0503
        public final JSONObject toJSONObject() {
            return new JSONObject();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m7319(boolean z) {
        C1300Ac.m3531(new C1080(AppView.androidSmartDownloadSetting, If.f7416), new C1070(z), false);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m7314() {
        C2094qo.f9607.m10108();
    }
}
