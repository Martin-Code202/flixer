package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.io.File;
import java.util.List;
import java.util.Map;
/* renamed from: o.ov  reason: case insensitive filesystem */
public final class C2046ov implements oF {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final oK f9367;

    public C2046ov(oK oKVar) {
        this.f9367 = oKVar;
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public void mo9487(AbstractC0487 r4, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8517(r4, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchTask:: service is not available");
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public boolean mo9467(int i, String str, oU oUVar) {
        if (this.f9367.mo9519()) {
            int r5 = this.f9367.mo9518(oUVar);
            C1283.m16851("ServiceManagerBrowse", "prefetchLolomo requestId= %s", Integer.valueOf(r5));
            this.f9367.mo9517().mo8509(i, str, this.f9367.mo9515(), r5);
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "prefetchLolomo:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9500(String str, int i, int i2, int i3, int i4, boolean z, int i5, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8488(str, i, i2, i3, i4, z, i5, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "prefetchGenreLoLoMo:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public synchronized boolean mo9491(String str, int i, int i2, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8499(str, i, i2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchLoMos:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public synchronized boolean mo9472(pC pCVar, int i, int i2, boolean z, boolean z2, boolean z3, oU oUVar) {
        if (pCVar != null) {
            if (!C1349Bv.m4113(pCVar.getId())) {
                if (this.f9367.mo9519()) {
                    this.f9367.mo9517().mo8483(pCVar, i, i2, z, z2, z3, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
                    return true;
                }
                C1283.m16865("ServiceManagerBrowse", "fetchVideos:: service is not available");
                return false;
            }
        }
        StringBuilder sb = new StringBuilder("SPY-10830 LoLoMo refresh crash");
        if (pCVar == null) {
            sb.append(", lomo == null");
        } else {
            sb.append(", lomo.id == ").append(pCVar.getId()).append(", lomo.title = ").append(pCVar.getTitle()).append(", lomo.class = ").append(pCVar.getClass());
        }
        C1276.m16820().mo5725(sb.toString());
        return false;
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public synchronized boolean mo9494(pC pCVar, int i, int i2, boolean z, oU oUVar) {
        if (C1349Bv.m4113(pCVar.getId())) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8493(pCVar, i, i2, z, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchGenreVideos:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public synchronized boolean mo9510(String str, CmpTaskMode cmpTaskMode, VideoType videoType, int i, int i2, oU oUVar) {
        if (!C1340Bm.m4052(str)) {
            if (oUVar != null) {
                oUVar.onEpisodesFetched(null, new NetflixStatus(StatusCode.INVALID_ARGUMENTS));
            }
            return false;
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8489(str, cmpTaskMode, videoType, i, i2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchEpisodes:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public synchronized boolean mo9511(String str, CmpTaskMode cmpTaskMode, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            int r5 = this.f9367.mo9518(oUVar);
            C1283.m16851("ServiceManagerBrowse", "fetchSeasons requestId=%s id=%s", Integer.valueOf(r5), str);
            this.f9367.mo9517().mo8511(str, cmpTaskMode, this.f9367.mo9515(), r5);
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchSeasons:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public synchronized boolean mo9489(int i, int i2, String str, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8466(i, i2, str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchCWVideos:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9497(int i, int i2, String str, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8496(i, i2, str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchShortFormVideos:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9477(int i, int i2, String str, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8507(i, i2, str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchPreviews:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public boolean mo9499(int i, oU oUVar) {
        if (this.f9367.mo9519()) {
            int r5 = this.f9367.mo9518(oUVar);
            C1283.m16851("ServiceManagerBrowse", "fetchWatchHistory requestId=%d fromVideo=%d", Integer.valueOf(r5), Integer.valueOf(i));
            this.f9367.mo9517().mo8465(i, this.f9367.mo9515(), r5);
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchWatchHistory:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public boolean mo9490(VideoType videoType, String str, boolean z, oU oUVar) {
        if (this.f9367.mo9519()) {
            int r6 = this.f9367.mo9518(oUVar);
            C1283.m16851("ServiceManagerBrowse", "hideWatchHistory requestId=%d", Integer.valueOf(r6));
            this.f9367.mo9517().mo8475(videoType, str, z, this.f9367.mo9515(), r6);
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "hideWatchHistory:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9502(String str, VideoType videoType, PlayLocationType playLocationType, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8481(str, videoType, playLocationType, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchPostPlayVideos:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public boolean mo9512(String str, VideoType videoType, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8480(str, videoType, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchPostPlayVideos:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9482(String str, VideoType videoType, String str2, String str3, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8502(str, videoType, str2, str3, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "logPostPlayImpression:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public boolean mo9470(String str, String str2, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8482(str, str2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "logPostPlayImpression:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9478(int i, int i2, pC pCVar, boolean z, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8508(i, i2, pCVar, z, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchIQVideos:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9505(String str, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8477(str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchLoLoMoSummary:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public boolean mo9471(String str, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8510(str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchVideoSummary:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public boolean mo9514(String str, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8486(str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchFalkorVideo:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public synchronized boolean mo9513(String str, String str2, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8504(str, str2, this.f9367.mo9515(), this.f9367.mo9516(oUVar, str));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchMovieDetails:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public boolean mo9486(List<? extends AbstractC2072pu> list, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8515(list, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "prefetchFromLolomoList:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public synchronized boolean mo9492(String str, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8468(str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchKidsCharacterDetails:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9479(VideoType videoType, String str, String str2, oU oUVar) {
        if (C1349Bv.m4113(str) || C1349Bv.m4113(str2)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8467(videoType, str, str2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchScenePosition:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public void mo9473(String str, ExpiringContentAdvisory.ContentAction contentAction) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8503(str, contentAction);
        } else {
            C1283.m16865("ServiceManagerBrowse", "updateExpiredContentAdvisoryStatus:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public void mo9474(String str, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8498(str, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchAdvisories:: service is not available");
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9484(String str, String str2, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8472(str, str2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchEpisodeDetails:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9503(String str, String str2, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8491(str, str2, this.f9367.mo9515(), this.f9367.mo9516(oUVar, str));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchShowDetails:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9504(String str, String str2, boolean z, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8514(str, str2, z, this.f9367.mo9515(), this.f9367.mo9516(oUVar, str));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "fetchShowDetailsAndSeasons:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public synchronized boolean mo9493(oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8506(this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchGenreLists:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized boolean mo9501(String str, CmpTaskMode cmpTaskMode, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8500(str, cmpTaskMode, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchFilteredGenreLists:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9480(String str, int i, int i2, oU oUVar) {
        if (!this.f9367.mo9519()) {
            C1283.m16865("ServiceManagerBrowse", "fetchGenres:: service is not available");
            return false;
        } else if (C1349Bv.m4113(str)) {
            return false;
        } else {
            this.f9367.mo9517().mo8469(str, i, i2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9481(String str, CmpTaskMode cmpTaskMode, boolean z, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8479(str, cmpTaskMode, z, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "searchNetflix:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public synchronized boolean mo9509(String str, CmpTaskMode cmpTaskMode, int i, int i2, boolean z, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8478(str, cmpTaskMode, this.f9367.mo9515(), this.f9367.mo9518(oUVar), i, i2, z);
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "searchNetflix:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public synchronized boolean mo9485(String str, oU oUVar, int i, int i2) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8487(str, this.f9367.mo9515(), this.f9367.mo9518(oUVar), i, i2);
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "searchNetflix:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public synchronized boolean mo9468(String str, VideoType videoType, int i, int i2, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8501(str, videoType, i, i2, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "setVideoThumbRating:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public boolean mo9469(String str, VideoType videoType, int i, String str2, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8490(str, videoType, i, str2, this.f9367.mo9515(), this.f9367.mo9516(oUVar, str));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "addToQueue:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public boolean mo9483(String str, VideoType videoType, String str2, oU oUVar) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8513(str, videoType, str2, this.f9367.mo9515(), this.f9367.mo9516(oUVar, str));
            return true;
        } else {
            C1283.m16865("ServiceManagerBrowse", "removeFromQueue:: service is not available");
            return false;
        }
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public boolean mo9476() {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8484();
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "flushCaches:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public void mo9465(File file) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8476(file);
        } else {
            C1283.m16865("ServiceManagerBrowse", "dumpCacheToDisk:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public void mo9466(pJ pJVar, BillboardInteractionType billboardInteractionType, Map<String, String> map) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8516(pJVar, billboardInteractionType, map);
        } else {
            C1283.m16865("ServiceManagerBrowse", "logBillboardActivity:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public boolean mo9498(int i, int i2, oU oUVar) {
        if (this.f9367.mo9519()) {
            int r5 = this.f9367.mo9518(oUVar);
            C1283.m16851("ServiceManagerBrowse", "fetchNotificationsList requestId=%s", Integer.valueOf(r5));
            this.f9367.mo9517().mo8474(i, i2, this.f9367.mo9515(), r5);
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchNotificationsList:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public boolean mo9508(int i, int i2, boolean z, oU oUVar) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8497(i, i2, z, this.f9367.mo9515(), this.f9367.mo9518(oUVar));
            return true;
        }
        C1283.m16865("ServiceManagerBrowse", "fetchNotificationsList:: service is not available");
        return false;
    }

    @Override // o.oF
    /* renamed from: ˋ */
    public void mo9475(boolean z) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8495(z, false, false, (C1999nc) null);
        } else {
            C1283.m16865("ServiceManagerBrowse", "refreshIrisNotifications:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public void mo9507(IrisNotificationSummary irisNotificationSummary) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8485(irisNotificationSummary);
        } else {
            C1283.m16865("ServiceManagerBrowse", "markNotificationAsRead:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public void mo9496(List<IrisNotificationSummary> list) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8492(list);
        } else {
            C1283.m16865("ServiceManagerBrowse", "markNotificationsAsRead:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ˏ */
    public synchronized void mo9495(String str, VideoType videoType) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Parameter cannot be null");
        } else if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8512(str, videoType);
        } else {
            C1283.m16865("ServiceManagerBrowse", "purgeCachedEpisodes:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ˎ */
    public void mo9488(boolean z) {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8494(z, null);
            C1276.m16820().mo5728("browse.cw.refresh");
            return;
        }
        C1283.m16865("ServiceManagerBrowse", "refreshCw:: service is not available");
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public void mo9464() {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8473();
        } else {
            C1283.m16865("ServiceManagerBrowse", "refreshWatchHistory:: service is not available");
        }
    }

    @Override // o.oF
    /* renamed from: ॱ */
    public void mo9506() {
        if (this.f9367.mo9519()) {
            this.f9367.mo9517().mo8464();
        } else {
            C1283.m16865("ServiceManagerBrowse", "clearSearchResults:: service is not available");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC0929<?> m9711() {
        if (this.f9367.mo9519()) {
            return this.f9367.mo9517().mo8505();
        }
        C1283.m16865("ServiceManagerBrowse", "getModelProxy:: service is not available");
        return null;
    }

    @Override // o.oF
    /* renamed from: ˊ */
    public pC mo9463(String str) {
        if (this.f9367.mo9519()) {
            C0876 r2 = (C0876) m9711();
            if (r2 != null) {
                return r2.m15581(str);
            }
            return null;
        }
        C1283.m16865("ServiceManagerBrowse", "getModelProxy:: service is not available");
        return null;
    }
}
