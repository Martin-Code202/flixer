package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.OnRampEligibility;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import java.util.List;
public class oP implements oU {

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final String f9234;

    public oP(String str) {
        this.f9234 = str;
    }

    @Override // o.oU
    public void onLoLoMoPrefetched(LoLoMoSummary loLoMoSummary, Status status) {
    }

    @Override // o.oU
    public void onGenreLoLoMoPrefetched(LoLoMoSummary loLoMoSummary, Status status) {
    }

    @Override // o.oU
    public void onLoMosFetched(List<pC> list, Status status) {
    }

    @Override // o.oU
    public void onVideosFetched(List<pJ> list, Status status) {
    }

    @Override // o.oU
    public void onFlatGenreVideosFetched(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, List<pJ> list, Status status) {
    }

    @Override // o.oU
    public void onCWVideosFetched(List<AbstractC2074pw> list, Status status) {
    }

    @Override // o.oU
    public void onShortFormVideosFetched(List<Object> list, Status status) {
    }

    @Override // o.oU
    public void onPreviewsFetched(List<pD> list, Status status) {
    }

    @Override // o.oU
    public void onBBVideosFetched(List<AbstractC2077pz> list, Status status) {
    }

    @Override // o.oU
    public void onTallPanelVideosFetched(List<pK> list, Status status) {
    }

    @Override // o.oU
    public void onWatchHistoryVideosFetched(List<CH> list, Status status) {
    }

    @Override // o.oU
    public void onPostPlayVideosFetched(pO pOVar, Status status) {
    }

    @Override // o.oU
    public void onPostPlayImpressionLogged(boolean z, Status status) {
    }

    @Override // o.oU
    public void onPreplayVideoFetched(PrePlayExperiences prePlayExperiences, Status status) {
    }

    @Override // o.oU
    public void onPrePlayImpressionLogged(boolean z, Status status) {
    }

    @Override // o.oU
    public void onVideoSummaryFetched(Video.Summary summary, Status status) {
    }

    @Override // o.oU
    public void onFalkorVideoFetched(CH ch, Status status) {
    }

    @Override // o.oU
    public void onMovieDetailsFetched(pP pPVar, Status status) {
    }

    @Override // o.oU
    public void onKidsCharacterDetailsFetched(pL pLVar, Boolean bool, Status status) {
    }

    @Override // o.oU
    public void onEpisodeDetailsFetched(pI pIVar, Status status) {
    }

    @Override // o.oU
    public void onLoLoMoSummaryFetched(pA pAVar, Status status) {
    }

    @Override // o.oU
    public void onResourceFetched(String str, String str2, Status status) {
    }

    @Override // o.oU
    public void onResourceCached(String str, String str2, long j, long j2, Status status) {
    }

    @Override // o.oU
    public void onEpisodesFetched(List<pI> list, Status status) {
    }

    @Override // o.oU
    public void onSeasonsFetched(List<pS> list, Status status) {
    }

    @Override // o.oU
    public void onShowDetailsFetched(pR pRVar, Status status) {
    }

    @Override // o.oU
    public void onShowDetailsAndSeasonsFetched(pR pRVar, List<pS> list, Status status) {
    }

    @Override // o.oU
    public void onGenreListsFetched(List<GenreList> list, Status status) {
    }

    @Override // o.oU
    public void onGenresFetched(List<pW> list, Status status) {
    }

    @Override // o.oU
    public void onVideoRatingSet(pE pEVar, Status status) {
    }

    @Override // o.oU
    public void onQueueAdd(Status status) {
    }

    @Override // o.oU
    public void onQueueRemove(Status status) {
    }

    @Override // o.oU
    public void onVerified(boolean z, Status status) {
    }

    @Override // o.oU
    public void onLoginComplete(Status status) {
    }

    @Override // o.oU
    public void onLogoutComplete(Status status) {
    }

    @Override // o.oU
    public void onSearchResultsFetched(AbstractC2080qa qaVar, Status status) {
    }

    @Override // o.oU
    public void onVideoHide(Status status) {
    }

    @Override // o.oU
    public void onAvailableAvatarsListFetched(List<AvatarInfo> list, Status status) {
    }

    @Override // o.oU
    public void onNotificationsListFetched(AbstractC2082qc qcVar, Status status) {
    }

    @Override // o.oU
    public void onProfileListUpdateStatus(Status status) {
    }

    @Override // o.oU
    public void onAutoLoginTokenCreated(String str, Status status) {
    }

    @Override // o.oU
    public void onSurveyFetched(CL cl, Status status) {
    }

    @Override // o.oU
    public void onUpdatePlanCompleted(Status status) {
    }

    @Override // o.oU
    public void onAdvisoriesFetched(List<Advisory> list, Status status) {
    }

    @Override // o.oU
    public void onOnRampEligibilityAction(OnRampEligibility onRampEligibility, Status status) {
    }

    @Override // o.oU
    public void onScenePositionFetched(int i, Status status) {
    }

    @Override // o.oU
    public void onBigRowVideofetched(List<AbstractC2070ps> list, Status status) {
    }

    @Override // o.oU
    public void onBigRowYellowSquareValueFetched(boolean z, Status status) {
    }

    @Override // o.oU
    public void onTrailersFetched(TrailersFeedItemSummary trailersFeedItemSummary, List<pH> list, Status status) {
    }

    @Override // o.oU
    public void onAccountDataFetched(AccountData accountData, Status status) {
    }

    @Override // o.oU
    public void onSimsFetched(List<CH> list, Status status) {
    }
}
