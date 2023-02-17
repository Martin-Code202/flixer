package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* renamed from: o.ﻌ  reason: contains not printable characters */
public class C1204 implements AbstractC1203 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f15581 = System.nanoTime();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1203 f15582;

    public C1204(AbstractC1203 r3) {
        this.f15582 = r3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16481(String str) {
        TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.f15581, TimeUnit.NANOSECONDS);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Status m16480(Status status) {
        return status;
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7402(LoLoMoSummary loLoMoSummary, Status status) {
        m16481("onLoLoMoPrefetched");
        this.f15582.mo7402(loLoMoSummary, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8528(LoLoMoSummary loLoMoSummary, Status status) {
        m16481("onGenreLoLoMoPrefetched");
        this.f15582.mo8528(loLoMoSummary, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7393(List<pC> list, Status status) {
        m16481("onLoMosFetched");
        this.f15582.mo7393(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo7395(List<AbstractC2074pw> list, Status status) {
        m16481("onCWVideosFetched");
        this.f15582.mo7395(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8539(List<Object> list, Status status) {
        m16481("onShortFormVideosFetched");
        this.f15582.mo8539(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8530(List<pD> list, Status status) {
        m16481("onPreviewsFetched");
        this.f15582.mo8530(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˋ */
    public void mo7396(List<AbstractC2077pz> list, Status status) {
        m16481("onBBVideosFetched");
        this.f15582.mo7396(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ʼ */
    public void mo7394(List<pK> list, Status status) {
        m16481("onTallPanelVideosFetched");
        this.f15582.mo7394(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ʽ */
    public void mo8519(List<CH> list, Status status) {
        m16481("onWatchHistoryVideosFetched");
        this.f15582.mo8519(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo6199(pO pOVar, Status status) {
        m16481("onPostPlayVideosFetched");
        this.f15582.mo6199(pOVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8529(PrePlayExperiences prePlayExperiences, Status status) {
        m16481("onPrePlayVideosFetched");
        this.f15582.mo8529(prePlayExperiences, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8521(boolean z, Status status) {
        m16481("onPostPlayImpressionLogged");
        this.f15582.mo8521(z, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8533(boolean z, Status status) {
        m16481("onPrePlayImpressionLogged");
        this.f15582.mo8533(z, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱॱ */
    public void mo7398(List<pJ> list, Status status) {
        m16481("onVideosFetched");
        this.f15582.mo7398(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8538(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, List<pJ> list, Status status) {
        m16481("onFlatGenreVideosFetched");
        this.f15582.mo8538(flatGenreListOfVideosSummary, list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ᐝ */
    public void mo7347(List<pI> list, Status status) {
        m16481("onEpisodesFetched");
        this.f15582.mo7347(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ʻ */
    public void mo8518(List<pS> list, Status status) {
        m16481("onSeasonsFetched");
        this.f15582.mo8518(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8531(pA pAVar, Status status) {
        m16481("onLoLoMoSummaryFetched");
        this.f15582.mo8531(pAVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo8525(Video.Summary summary, Status status) {
        m16481("onVideoSummaryFetched");
        this.f15582.mo8525(summary, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8177(CH ch, Status status) {
        m16481("onFalkorVideoFetched");
        this.f15582.mo8177(ch, status);
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo6200(pP pPVar, Status status) {
        m16481("onMovieDetailsFetched");
        this.f15582.mo6200(pPVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8536(int i, Status status) {
        m16481("onScenePositionFetched");
        this.f15582.mo8536(i, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8532(pL pLVar, Boolean bool, Status status) {
        m16481("onKidsCharacterDetailsFetched");
        this.f15582.mo8532(pLVar, bool, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo6203(pI pIVar, Status status) {
        m16481("onEpisodeDetailsFetched");
        this.f15582.mo6203(pIVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8175(pR pRVar, Status status) {
        m16481("onShowDetailsFetched");
        this.f15582.mo8175(pRVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7346(pR pRVar, List<pS> list, Status status) {
        m16481("onShowDetailsAndSeasonsFetched");
        this.f15582.mo7346(pRVar, list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏॱ */
    public void mo8534(List<GenreList> list, Status status) {
        m16481("onGenreListsFetched");
        this.f15582.mo8534(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ͺ */
    public void mo8535(List<pW> list, Status status) {
        m16481("onGenresFetched");
        this.f15582.mo8535(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8540(pE pEVar, Status status) {
        m16481("onVideoRatingSet");
        this.f15582.mo8540(pEVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8537(Status status) {
        m16481("onQueueAdd");
        this.f15582.mo8537(m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo8524(Status status) {
        m16481("onQueueRemove");
        this.f15582.mo8524(m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8527(Status status) {
        m16481("onVideoHide");
        this.f15582.mo8527(m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo8526(AbstractC2080qa qaVar, Status status) {
        m16481("onSearchResultsFetched");
        this.f15582.mo8526(qaVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8174(AbstractC2082qc qcVar, Status status) {
        m16481("onIrisNotificationsListFetched");
        this.f15582.mo8174(qcVar, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8173(Status status) {
        m16481("onIrisNotificationsMarkedAsRead");
        this.f15582.mo8173(m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊॱ */
    public void mo8522(List<Advisory> list, Status status) {
        m16481("onAdvisoriesFetched");
        this.f15582.mo8522(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7348(Map<String, Boolean> map, Status status) {
        m16481("onOfflineGeoPlayabilityReceived");
        this.f15582.mo7348(map, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˋॱ */
    public void mo7397(List<AbstractC2070ps> list, Status status) {
        m16481("onBigRowVideofetched");
        this.f15582.mo7397(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˋ */
    public void mo8523(boolean z, Status status) {
        m16481("onBigRowVideofetched");
        this.f15582.mo8523(z, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱˊ */
    public void mo8541(List<CH> list, Status status) {
        m16481("onSimsFetched");
        this.f15582.mo8541(list, m16480(status));
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8520(TrailersFeedItemSummary trailersFeedItemSummary, List<pH> list, Status status) {
        m16481("onTrailersFetched");
        this.f15582.mo8520(trailersFeedItemSummary, list, m16480(status));
    }
}
