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
public interface oU {
    void onAccountDataFetched(AccountData accountData, Status status);

    void onAdvisoriesFetched(List<Advisory> list, Status status);

    void onAutoLoginTokenCreated(String str, Status status);

    void onAvailableAvatarsListFetched(List<AvatarInfo> list, Status status);

    void onBBVideosFetched(List<AbstractC2077pz> list, Status status);

    void onBigRowVideofetched(List<AbstractC2070ps> list, Status status);

    void onBigRowYellowSquareValueFetched(boolean z, Status status);

    void onCWVideosFetched(List<AbstractC2074pw> list, Status status);

    void onEpisodeDetailsFetched(pI pIVar, Status status);

    void onEpisodesFetched(List<pI> list, Status status);

    void onFalkorVideoFetched(CH ch, Status status);

    void onFlatGenreVideosFetched(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, List<pJ> list, Status status);

    void onGenreListsFetched(List<GenreList> list, Status status);

    void onGenreLoLoMoPrefetched(LoLoMoSummary loLoMoSummary, Status status);

    void onGenresFetched(List<pW> list, Status status);

    void onKidsCharacterDetailsFetched(pL pLVar, Boolean bool, Status status);

    void onLoLoMoPrefetched(LoLoMoSummary loLoMoSummary, Status status);

    void onLoLoMoSummaryFetched(pA pAVar, Status status);

    void onLoMosFetched(List<pC> list, Status status);

    void onLoginComplete(Status status);

    void onLogoutComplete(Status status);

    void onMovieDetailsFetched(pP pPVar, Status status);

    void onNotificationsListFetched(AbstractC2082qc qcVar, Status status);

    void onOnRampEligibilityAction(OnRampEligibility onRampEligibility, Status status);

    void onPostPlayImpressionLogged(boolean z, Status status);

    void onPostPlayVideosFetched(pO pOVar, Status status);

    void onPrePlayImpressionLogged(boolean z, Status status);

    void onPreplayVideoFetched(PrePlayExperiences prePlayExperiences, Status status);

    void onPreviewsFetched(List<pD> list, Status status);

    void onProfileListUpdateStatus(Status status);

    void onQueueAdd(Status status);

    void onQueueRemove(Status status);

    void onResourceCached(String str, String str2, long j, long j2, Status status);

    void onResourceFetched(String str, String str2, Status status);

    void onScenePositionFetched(int i, Status status);

    void onSearchResultsFetched(AbstractC2080qa qaVar, Status status);

    void onSeasonsFetched(List<pS> list, Status status);

    void onShortFormVideosFetched(List<Object> list, Status status);

    void onShowDetailsAndSeasonsFetched(pR pRVar, List<pS> list, Status status);

    void onShowDetailsFetched(pR pRVar, Status status);

    void onSimsFetched(List<CH> list, Status status);

    void onSurveyFetched(CL cl, Status status);

    void onTallPanelVideosFetched(List<pK> list, Status status);

    void onTrailersFetched(TrailersFeedItemSummary trailersFeedItemSummary, List<pH> list, Status status);

    void onUpdatePlanCompleted(Status status);

    void onVerified(boolean z, Status status);

    void onVideoHide(Status status);

    void onVideoRatingSet(pE pEVar, Status status);

    void onVideoSummaryFetched(Video.Summary summary, Status status);

    void onVideosFetched(List<pJ> list, Status status);

    void onWatchHistoryVideosFetched(List<CH> list, Status status);
}
