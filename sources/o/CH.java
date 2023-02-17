package o;

import com.netflix.falkor.BranchMap;
import com.netflix.mediaclient.servicemgr.interface_.IconFontGlyph;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.branches.FalkorRoarData;
import com.netflix.model.branches.SummarizedList;
import com.netflix.model.branches.UnsummarizedList;
import com.netflix.model.leafs.Episode;
import com.netflix.model.leafs.PostPlayExperience;
import com.netflix.model.leafs.PostPlayImpression;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.TrackableListSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import com.netflix.model.leafs.originals.BigRowSummary;
import com.netflix.model.leafs.originals.BillboardSummary;
import com.netflix.model.leafs.originals.TallPanelAsset;
import com.netflix.model.leafs.originals.interactive.InteractiveFeatures;
import com.netflix.model.leafs.originals.interactive.MotionBoxart;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class CH extends AbstractC1381Cx implements AbstractC2077pz, AbstractC2074pw, pK, pE, pP, pM, pN, pO, AbstractC2084qe, AbstractC2070ps {
    private static final long EPISODE_NODE_REFRESH_AGE = TimeUnit.HOURS.toMillis(6);
    private static final String TAG = "FalkorVideo";
    private static final long VOLATILE_NODE_REFRESH_AGE = TimeUnit.MINUTES.toMillis(60);
    private Video.Advisories advisories;
    private Video.TrickPlayBaseBigUrl baseBigUrl;
    private Video.TrickPlayBaseUrl baseUrl;
    private BigRowSummary bigRowSummary;
    private BillboardSummary billboardSummary;
    protected Video.Bookmark bookmark;
    private Video.CwCleanBoxart cleanBoxshot;
    private Video.Detail detail;
    private BranchMap<C1049> episodes;
    private Video.HasWatched hasWatched;
    private Video.HeroImages heroImages;
    private Video.HorizontalDisplayArt horizontalDisplayArtUrl;
    private Video.HorizontalDisplaySmallArt horizontalDisplaySmallArtUrl;
    private Video.InQueue inQueue;
    private Video.InterestingMomentsUrl interestingMomentsUrl;
    private Video.OfflineAvailable offlineAvailable;
    private BranchMap<C1049> performerStills;
    private BranchMap<C1049> performers;
    private C1049 postPlayExperience;
    private PostPlayImpression postPlayImpression;
    private PrePlayExperiences prePlayExperiences;
    private Video.RatingInfo rating;
    private UnsummarizedList<FalkorRoarData> roarData;
    private BranchMap<CA> scenes;
    private Video.SearchTitle searchTitle;
    private SummarizedList<C1049, TrackableListSummary> seasons;
    private SummarizedList<C1049, TrackableListSummary> sims;
    private Video.StoryImgDisplayArt storyImgDisplayArtUrl;
    private Video.Summary summary;
    private Video.SupplementalVideos supplementalVideos;
    private Video.TallPanelArt tallPanelArt;
    private TallPanelAsset tallPanelAsset;
    private SummarizedList<C1049, TrackableListSummary> trailers;
    private Video.TvCardArt tvCardArtUrl;
    private Video.VerticalStoryArt vertStoryArtUrl;
    private Video.Evidence videoEvidence;
    private C1049 watchNext;

    public CH(AbstractC0929<? extends AbstractC0730> r1) {
        super(r1);
    }

    public Video.Summary getSummary() {
        return this.summary;
    }

    /* access modifiers changed from: protected */
    public Video.Detail getDetail() {
        return this.detail;
    }

    public TallPanelAsset getTallPanelAsset() {
        return this.tallPanelAsset;
    }

    public String getTallPanelUrl() {
        if (this.tallPanelArt != null) {
            return this.tallPanelArt.getUrl();
        }
        return null;
    }

    public String getTallPanelArtImageTypeIdentifier() {
        if (this.tallPanelArt != null) {
            return this.tallPanelArt.getImageTypeIdentifier();
        }
        return null;
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2070337635:
                if (str.equals("legacySummary")) {
                    c = 4;
                    break;
                }
                break;
            case -1857640538:
                if (str.equals("summary")) {
                    c = 2;
                    break;
                }
                break;
            case -1794539439:
                if (str.equals("tvCardArt")) {
                    c = 19;
                    break;
                }
                break;
            case -1722431145:
                if (str.equals("tallPanel")) {
                    c = 3;
                    break;
                }
                break;
            case -1408222849:
                if (str.equals("vertStoryArt")) {
                    c = 15;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 5;
                    break;
                }
                break;
            case -1331680159:
                if (str.equals("cleanBoxart")) {
                    c = 0;
                    break;
                }
                break;
            case -1218016046:
                if (str.equals("horzDispArt")) {
                    c = 16;
                    break;
                }
                break;
            case -1136616012:
                if (str.equals("hasWatched")) {
                    c = 7;
                    break;
                }
                break;
            case -971889268:
                if (str.equals("tallPanelArt")) {
                    c = 20;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c = 6;
                    break;
                }
                break;
            case -908068505:
                if (str.equals("scenes")) {
                    c = 30;
                    break;
                }
                break;
            case -648601833:
                if (str.equals("advisories")) {
                    c = 1;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 28;
                    break;
                }
                break;
            case -619243478:
                if (str.equals("heroImgs")) {
                    c = '\r';
                    break;
                }
                break;
            case -586870806:
                if (str.equals("castStills")) {
                    c = '!';
                    break;
                }
                break;
            case -569992200:
                if (str.equals("roarData")) {
                    c = '\"';
                    break;
                }
                break;
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 11;
                    break;
                }
                break;
            case -319313801:
                if (str.equals("prePlay")) {
                    c = 24;
                    break;
                }
                break;
            case -280837022:
                if (str.equals("watchNext")) {
                    c = 25;
                    break;
                }
                break;
            case -165471106:
                if (str.equals("postPlayExperience")) {
                    c = 31;
                    break;
                }
                break;
            case 3046207:
                if (str.equals("cast")) {
                    c = ' ';
                    break;
                }
                break;
            case 40719645:
                if (str.equals("postPlayImpression")) {
                    c = 21;
                    break;
                }
                break;
            case 136285222:
                if (str.equals("offlineAvailable")) {
                    c = '\n';
                    break;
                }
                break;
            case 382967383:
                if (str.equals("evidence")) {
                    c = '\f';
                    break;
                }
                break;
            case 461144535:
                if (str.equals("trickplayBaseUrl")) {
                    c = 22;
                    break;
                }
                break;
            case 479193064:
                if (str.equals("similars")) {
                    c = 26;
                    break;
                }
                break;
            case 936901554:
                if (str.equals("defaultTrailer")) {
                    c = 14;
                    break;
                }
                break;
            case 1251913459:
                if (str.equals("storyImgDispArt")) {
                    c = 18;
                    break;
                }
                break;
            case 1276055968:
                if (str.equals("trailers")) {
                    c = 27;
                    break;
                }
                break;
            case 1882756813:
                if (str.equals("horzDispSmallArt")) {
                    c = 17;
                    break;
                }
                break;
            case 1926204140:
                if (str.equals("inQueue")) {
                    c = '\b';
                    break;
                }
                break;
            case 1958422540:
                if (str.equals("intrUrl")) {
                    c = 23;
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 29;
                    break;
                }
                break;
            case 2005378358:
                if (str.equals("bookmark")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.cleanBoxshot;
            case 1:
                return this.advisories;
            case 2:
                return this.summary;
            case 3:
                return this.tallPanelAsset;
            case 4:
                return this.summary;
            case 5:
                return getDetail();
            case 6:
                return this.rating;
            case 7:
                return this.hasWatched;
            case '\b':
                return this.inQueue;
            case '\t':
                return this.bookmark;
            case '\n':
                return this.offlineAvailable;
            case 11:
                return this.searchTitle;
            case '\f':
                return this.videoEvidence;
            case '\r':
                return this.heroImages;
            case 14:
                return this.supplementalVideos;
            case 15:
                return this.vertStoryArtUrl;
            case 16:
                return this.horizontalDisplayArtUrl;
            case 17:
                return this.horizontalDisplaySmallArtUrl;
            case 18:
                return this.storyImgDisplayArtUrl;
            case 19:
                return this.tvCardArtUrl;
            case 20:
                return this.tallPanelArt;
            case 21:
                return this.postPlayImpression;
            case 22:
                return this.baseUrl;
            case 23:
                return this.interestingMomentsUrl;
            case 24:
                return this.prePlayExperiences;
            case 25:
                return this.watchNext;
            case 26:
                return this.sims;
            case 27:
                return this.trailers;
            case 28:
                return this.episodes;
            case 29:
                return this.seasons;
            case 30:
                return this.scenes;
            case 31:
                return this.postPlayExperience;
            case ' ':
                return this.performers;
            case '!':
                return this.performerStills;
            case '\"':
                return this.roarData;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2070337635:
                if (str.equals("legacySummary")) {
                    c = 4;
                    break;
                }
                break;
            case -1857640538:
                if (str.equals("summary")) {
                    c = 2;
                    break;
                }
                break;
            case -1794539439:
                if (str.equals("tvCardArt")) {
                    c = 19;
                    break;
                }
                break;
            case -1722431145:
                if (str.equals("tallPanel")) {
                    c = 3;
                    break;
                }
                break;
            case -1408222849:
                if (str.equals("vertStoryArt")) {
                    c = 15;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 5;
                    break;
                }
                break;
            case -1331680159:
                if (str.equals("cleanBoxart")) {
                    c = 0;
                    break;
                }
                break;
            case -1218016046:
                if (str.equals("horzDispArt")) {
                    c = 16;
                    break;
                }
                break;
            case -1136616012:
                if (str.equals("hasWatched")) {
                    c = 7;
                    break;
                }
                break;
            case -971889268:
                if (str.equals("tallPanelArt")) {
                    c = 20;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c = 6;
                    break;
                }
                break;
            case -908068505:
                if (str.equals("scenes")) {
                    c = 29;
                    break;
                }
                break;
            case -648601833:
                if (str.equals("advisories")) {
                    c = 1;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 24;
                    break;
                }
                break;
            case -619243478:
                if (str.equals("heroImgs")) {
                    c = '\r';
                    break;
                }
                break;
            case -586870806:
                if (str.equals("castStills")) {
                    c = 27;
                    break;
                }
                break;
            case -569992200:
                if (str.equals("roarData")) {
                    c = '#';
                    break;
                }
                break;
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 11;
                    break;
                }
                break;
            case -319313801:
                if (str.equals("prePlay")) {
                    c = '!';
                    break;
                }
                break;
            case -280837022:
                if (str.equals("watchNext")) {
                    c = '\"';
                    break;
                }
                break;
            case -165471106:
                if (str.equals("postPlayExperience")) {
                    c = 25;
                    break;
                }
                break;
            case 3046207:
                if (str.equals("cast")) {
                    c = 26;
                    break;
                }
                break;
            case 40719645:
                if (str.equals("postPlayImpression")) {
                    c = 21;
                    break;
                }
                break;
            case 136285222:
                if (str.equals("offlineAvailable")) {
                    c = '\n';
                    break;
                }
                break;
            case 382967383:
                if (str.equals("evidence")) {
                    c = '\f';
                    break;
                }
                break;
            case 461144535:
                if (str.equals("trickplayBaseUrl")) {
                    c = 30;
                    break;
                }
                break;
            case 479193064:
                if (str.equals("similars")) {
                    c = 22;
                    break;
                }
                break;
            case 936901554:
                if (str.equals("defaultTrailer")) {
                    c = 14;
                    break;
                }
                break;
            case 1251913459:
                if (str.equals("storyImgDispArt")) {
                    c = 18;
                    break;
                }
                break;
            case 1276055968:
                if (str.equals("trailers")) {
                    c = 23;
                    break;
                }
                break;
            case 1882756813:
                if (str.equals("horzDispSmallArt")) {
                    c = 17;
                    break;
                }
                break;
            case 1926204140:
                if (str.equals("inQueue")) {
                    c = '\b';
                    break;
                }
                break;
            case 1958422540:
                if (str.equals("intrUrl")) {
                    c = ' ';
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 28;
                    break;
                }
                break;
            case 2005378358:
                if (str.equals("bookmark")) {
                    c = '\t';
                    break;
                }
                break;
            case 2099100391:
                if (str.equals("trickplayBaseBigUrl")) {
                    c = 31;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Video.CwCleanBoxart cwCleanBoxart = new Video.CwCleanBoxart();
                this.cleanBoxshot = cwCleanBoxart;
                return cwCleanBoxart;
            case 1:
                Video.Advisories advisories2 = new Video.Advisories();
                this.advisories = advisories2;
                return advisories2;
            case 2:
                Video.Summary summary2 = new Video.Summary();
                this.summary = summary2;
                return summary2;
            case 3:
                TallPanelAsset tallPanelAsset2 = new TallPanelAsset();
                this.tallPanelAsset = tallPanelAsset2;
                return tallPanelAsset2;
            case 4:
                Video.Summary summary3 = new Video.Summary();
                this.summary = summary3;
                return summary3;
            case 5:
                Video.Detail detail2 = new Video.Detail();
                this.detail = detail2;
                return detail2;
            case 6:
                Video.RatingInfo ratingInfo = new Video.RatingInfo();
                this.rating = ratingInfo;
                return ratingInfo;
            case 7:
                Video.HasWatched hasWatched2 = new Video.HasWatched();
                this.hasWatched = hasWatched2;
                return hasWatched2;
            case '\b':
                Video.InQueue inQueue2 = new Video.InQueue();
                this.inQueue = inQueue2;
                return inQueue2;
            case '\t':
                Video.Bookmark bookmark2 = new Video.Bookmark();
                this.bookmark = bookmark2;
                return bookmark2;
            case '\n':
                Video.OfflineAvailable offlineAvailable2 = new Video.OfflineAvailable();
                this.offlineAvailable = offlineAvailable2;
                return offlineAvailable2;
            case 11:
                Video.SearchTitle searchTitle2 = new Video.SearchTitle();
                this.searchTitle = searchTitle2;
                return searchTitle2;
            case '\f':
                Video.Evidence evidence = new Video.Evidence();
                this.videoEvidence = evidence;
                return evidence;
            case '\r':
                Video.HeroImages heroImages2 = new Video.HeroImages();
                this.heroImages = heroImages2;
                return heroImages2;
            case 14:
                Video.SupplementalVideos supplementalVideos2 = new Video.SupplementalVideos();
                this.supplementalVideos = supplementalVideos2;
                return supplementalVideos2;
            case 15:
                Video.VerticalStoryArt verticalStoryArt = new Video.VerticalStoryArt();
                this.vertStoryArtUrl = verticalStoryArt;
                return verticalStoryArt;
            case 16:
                Video.HorizontalDisplayArt horizontalDisplayArt = new Video.HorizontalDisplayArt();
                this.horizontalDisplayArtUrl = horizontalDisplayArt;
                return horizontalDisplayArt;
            case 17:
                Video.HorizontalDisplaySmallArt horizontalDisplaySmallArt = new Video.HorizontalDisplaySmallArt();
                this.horizontalDisplaySmallArtUrl = horizontalDisplaySmallArt;
                return horizontalDisplaySmallArt;
            case 18:
                Video.StoryImgDisplayArt storyImgDisplayArt = new Video.StoryImgDisplayArt();
                this.storyImgDisplayArtUrl = storyImgDisplayArt;
                return storyImgDisplayArt;
            case 19:
                Video.TvCardArt tvCardArt = new Video.TvCardArt();
                this.tvCardArtUrl = tvCardArt;
                return tvCardArt;
            case 20:
                Video.TallPanelArt tallPanelArt2 = new Video.TallPanelArt();
                this.tallPanelArt = tallPanelArt2;
                return tallPanelArt2;
            case 21:
                PostPlayImpression postPlayImpression2 = new PostPlayImpression();
                this.postPlayImpression = postPlayImpression2;
                return postPlayImpression2;
            case 22:
                SummarizedList<C1049, TrackableListSummary> summarizedList = new SummarizedList<>(CO.f4967, CO.f4970);
                this.sims = summarizedList;
                return summarizedList;
            case 23:
                SummarizedList<C1049, TrackableListSummary> summarizedList2 = new SummarizedList<>(CO.f4967, CO.f4970);
                this.trailers = summarizedList2;
                return summarizedList2;
            case 24:
                BranchMap<C1049> branchMap = new BranchMap<>(CO.f4967);
                this.episodes = branchMap;
                return branchMap;
            case 25:
                C1049 r0 = new C1049();
                this.postPlayExperience = r0;
                return r0;
            case 26:
                BranchMap<C1049> branchMap2 = new BranchMap<>(CO.f4967);
                this.performers = branchMap2;
                return branchMap2;
            case 27:
                BranchMap<C1049> branchMap3 = new BranchMap<>(CO.f4967);
                this.performerStills = branchMap3;
                return branchMap3;
            case 28:
                SummarizedList<C1049, TrackableListSummary> summarizedList3 = new SummarizedList<>(CO.f4967, CO.f4970);
                this.seasons = summarizedList3;
                return summarizedList3;
            case 29:
                BranchMap<CA> branchMap4 = new BranchMap<>(CO.m4226(this.proxy));
                this.scenes = branchMap4;
                return branchMap4;
            case 30:
                Video.TrickPlayBaseUrl trickPlayBaseUrl = new Video.TrickPlayBaseUrl();
                this.baseUrl = trickPlayBaseUrl;
                return trickPlayBaseUrl;
            case 31:
                Video.TrickPlayBaseBigUrl trickPlayBaseBigUrl = new Video.TrickPlayBaseBigUrl();
                this.baseBigUrl = trickPlayBaseBigUrl;
                return trickPlayBaseBigUrl;
            case ' ':
                Video.InterestingMomentsUrl interestingMomentsUrl2 = new Video.InterestingMomentsUrl();
                this.interestingMomentsUrl = interestingMomentsUrl2;
                return interestingMomentsUrl2;
            case '!':
                PrePlayExperiences prePlayExperiences2 = new PrePlayExperiences();
                this.prePlayExperiences = prePlayExperiences2;
                return prePlayExperiences2;
            case '\"':
                C1049 r02 = new C1049();
                this.watchNext = r02;
                return r02;
            case '#':
                UnsummarizedList<FalkorRoarData> unsummarizedList = new UnsummarizedList<>(CO.m4231());
                this.roarData = unsummarizedList;
                return unsummarizedList;
            default:
                return null;
        }
    }

    public Set<String> getKeys() {
        HashSet hashSet = new HashSet();
        if (this.cleanBoxshot != null) {
            hashSet.add("cleanBoxart");
        }
        if (this.advisories != null) {
            hashSet.add("advisories");
        }
        if (this.summary != null) {
            hashSet.add("summary");
        }
        if (this.summary != null) {
            hashSet.add("legacySummary");
        }
        if (this.tallPanelAsset != null) {
            hashSet.add("tallPanel");
        }
        if (this.roarData != null) {
            hashSet.add("roarData");
        }
        if (getDetail() != null) {
            hashSet.add("detail");
        }
        if (this.rating != null) {
            hashSet.add("rating");
        }
        if (this.inQueue != null) {
            hashSet.add("inQueue");
        }
        if (this.hasWatched != null) {
            hashSet.add("hasWatched");
        }
        if (this.bookmark != null) {
            hashSet.add("bookmark");
        }
        if (this.offlineAvailable != null) {
            hashSet.add("offlineAvailable");
        }
        if (this.searchTitle != null) {
            hashSet.add("searchTitle");
        }
        if (this.videoEvidence != null) {
            hashSet.add("evidence");
        }
        if (this.heroImages != null) {
            hashSet.add("heroImgs");
        }
        if (this.supplementalVideos != null) {
            hashSet.add("defaultTrailer");
        }
        if (this.vertStoryArtUrl != null) {
            hashSet.add("vertStoryArt");
        }
        if (this.horizontalDisplayArtUrl != null) {
            hashSet.add("horzDispArt");
        }
        if (this.horizontalDisplaySmallArtUrl != null) {
            hashSet.add("horzDispSmallArt");
        }
        if (this.storyImgDisplayArtUrl != null) {
            hashSet.add("storyImgDispArt");
        }
        if (this.tvCardArtUrl != null) {
            hashSet.add("tvCardArt");
        }
        if (this.tallPanelArt != null) {
            hashSet.add("tallPanelArt");
        }
        if (this.postPlayImpression != null) {
            hashSet.add("postPlayImpression");
        }
        if (this.sims != null) {
            hashSet.add("similars");
        }
        if (this.episodes != null) {
            hashSet.add("episodes");
        }
        if (this.postPlayExperience != null) {
            hashSet.add("postPlayExperience");
        }
        if (this.performers != null) {
            hashSet.add("cast");
        }
        if (this.performerStills != null) {
            hashSet.add("castStills");
        }
        if (this.seasons != null) {
            hashSet.add("seasons");
        }
        if (this.scenes != null) {
            hashSet.add("scenes");
        }
        if (this.baseUrl != null) {
            hashSet.add("trickplayBaseUrl");
        }
        if (this.baseBigUrl != null) {
            hashSet.add("trickplayBaseBigUrl");
        }
        if (this.interestingMomentsUrl != null) {
            hashSet.add("intrUrl");
        }
        if (this.prePlayExperiences != null) {
            hashSet.add("prePlay");
        }
        if (this.watchNext != null) {
            hashSet.add("watchNext");
        }
        return hashSet;
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2070337635:
                if (str.equals("legacySummary")) {
                    c = 4;
                    break;
                }
                break;
            case -1857640538:
                if (str.equals("summary")) {
                    c = 2;
                    break;
                }
                break;
            case -1794539439:
                if (str.equals("tvCardArt")) {
                    c = 21;
                    break;
                }
                break;
            case -1722431145:
                if (str.equals("tallPanel")) {
                    c = 3;
                    break;
                }
                break;
            case -1408222849:
                if (str.equals("vertStoryArt")) {
                    c = 17;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 5;
                    break;
                }
                break;
            case -1331680159:
                if (str.equals("cleanBoxart")) {
                    c = 0;
                    break;
                }
                break;
            case -1218016046:
                if (str.equals("horzDispArt")) {
                    c = 18;
                    break;
                }
                break;
            case -1136616012:
                if (str.equals("hasWatched")) {
                    c = 7;
                    break;
                }
                break;
            case -1113967769:
                if (str.equals("billboardSummary")) {
                    c = 15;
                    break;
                }
                break;
            case -971889268:
                if (str.equals("tallPanelArt")) {
                    c = 22;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c = 6;
                    break;
                }
                break;
            case -908068505:
                if (str.equals("scenes")) {
                    c = 26;
                    break;
                }
                break;
            case -648601833:
                if (str.equals("advisories")) {
                    c = 1;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 24;
                    break;
                }
                break;
            case -619243478:
                if (str.equals("heroImgs")) {
                    c = '\r';
                    break;
                }
                break;
            case -586870806:
                if (str.equals("castStills")) {
                    c = 29;
                    break;
                }
                break;
            case -569992200:
                if (str.equals("roarData")) {
                    c = '\"';
                    break;
                }
                break;
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 11;
                    break;
                }
                break;
            case -319313801:
                if (str.equals("prePlay")) {
                    c = '!';
                    break;
                }
                break;
            case -280837022:
                if (str.equals("watchNext")) {
                    c = '#';
                    break;
                }
                break;
            case -165471106:
                if (str.equals("postPlayExperience")) {
                    c = 27;
                    break;
                }
                break;
            case 3046207:
                if (str.equals("cast")) {
                    c = 28;
                    break;
                }
                break;
            case 136285222:
                if (str.equals("offlineAvailable")) {
                    c = '\n';
                    break;
                }
                break;
            case 382967383:
                if (str.equals("evidence")) {
                    c = '\f';
                    break;
                }
                break;
            case 461144535:
                if (str.equals("trickplayBaseUrl")) {
                    c = 30;
                    break;
                }
                break;
            case 479193064:
                if (str.equals("similars")) {
                    c = 23;
                    break;
                }
                break;
            case 627488140:
                if (str.equals("bigRowSummary")) {
                    c = 16;
                    break;
                }
                break;
            case 936901554:
                if (str.equals("defaultTrailer")) {
                    c = 14;
                    break;
                }
                break;
            case 1251913459:
                if (str.equals("storyImgDispArt")) {
                    c = 20;
                    break;
                }
                break;
            case 1882756813:
                if (str.equals("horzDispSmallArt")) {
                    c = 19;
                    break;
                }
                break;
            case 1926204140:
                if (str.equals("inQueue")) {
                    c = '\b';
                    break;
                }
                break;
            case 1958422540:
                if (str.equals("intrUrl")) {
                    c = ' ';
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 25;
                    break;
                }
                break;
            case 2005378358:
                if (str.equals("bookmark")) {
                    c = '\t';
                    break;
                }
                break;
            case 2099100391:
                if (str.equals("trickplayBaseBigUrl")) {
                    c = 31;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.cleanBoxshot = (Video.CwCleanBoxart) obj;
                return;
            case 1:
                this.advisories = (Video.Advisories) obj;
                return;
            case 2:
                this.summary = (Video.Summary) obj;
                return;
            case 3:
                this.tallPanelAsset = (TallPanelAsset) obj;
                return;
            case 4:
                this.summary = (Video.Summary) obj;
                return;
            case 5:
                this.detail = (Video.Detail) obj;
                return;
            case 6:
                this.rating = (Video.RatingInfo) obj;
                return;
            case 7:
                this.hasWatched = (Video.HasWatched) obj;
                return;
            case '\b':
                this.inQueue = (Video.InQueue) obj;
                return;
            case '\t':
                this.bookmark = (Video.Bookmark) obj;
                return;
            case '\n':
                this.offlineAvailable = (Video.OfflineAvailable) obj;
                return;
            case 11:
                this.searchTitle = (Video.SearchTitle) obj;
                return;
            case '\f':
                this.videoEvidence = (Video.Evidence) obj;
                return;
            case '\r':
                this.heroImages = (Video.HeroImages) obj;
                return;
            case 14:
                this.supplementalVideos = (Video.SupplementalVideos) obj;
                return;
            case 15:
                this.billboardSummary = (BillboardSummary) obj;
                return;
            case 16:
                this.bigRowSummary = (BigRowSummary) obj;
                return;
            case 17:
                this.vertStoryArtUrl = (Video.VerticalStoryArt) obj;
                return;
            case 18:
                this.horizontalDisplayArtUrl = (Video.HorizontalDisplayArt) obj;
                return;
            case 19:
                this.horizontalDisplaySmallArtUrl = (Video.HorizontalDisplaySmallArt) obj;
                return;
            case 20:
                this.storyImgDisplayArtUrl = (Video.StoryImgDisplayArt) obj;
                return;
            case 21:
                this.tvCardArtUrl = (Video.TvCardArt) obj;
                return;
            case 22:
                this.tallPanelArt = (Video.TallPanelArt) obj;
                return;
            case 23:
                this.sims = (SummarizedList) obj;
                return;
            case 24:
                this.episodes = (BranchMap) obj;
                return;
            case 25:
                this.seasons = (SummarizedList) obj;
                return;
            case 26:
                this.scenes = (BranchMap) obj;
                return;
            case 27:
                this.postPlayExperience = (C1049) obj;
                return;
            case 28:
                this.performers = new BranchMap<>(CO.f4967);
            case 29:
                this.performerStills = new BranchMap<>(CO.f4967);
                break;
            case 30:
                break;
            case 31:
                this.baseBigUrl = (Video.TrickPlayBaseBigUrl) obj;
                return;
            case ' ':
                this.interestingMomentsUrl = (Video.InterestingMomentsUrl) obj;
                return;
            case '!':
                this.prePlayExperiences = (PrePlayExperiences) obj;
                return;
            case '\"':
                this.roarData = (UnsummarizedList) obj;
                return;
            case '#':
                if (!(obj instanceof C1128)) {
                    this.watchNext = (C1049) obj;
                    return;
                }
                return;
            default:
                return;
        }
        this.baseUrl = (Video.TrickPlayBaseUrl) obj;
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    @Override // o.pT
    public boolean shouldRefreshVolatileData() {
        long currentTimeMillis = System.currentTimeMillis() - VOLATILE_NODE_REFRESH_AGE;
        boolean z = this.bookmark != null && this.bookmark.needsRefresh(currentTimeMillis);
        boolean z2 = this.inQueue != null && this.inQueue.needsRefresh(currentTimeMillis);
        boolean z3 = this.rating != null && this.rating.needsRefresh(currentTimeMillis);
        C1283.m16863(TAG, "shouldRefreshVolatileData bookmark=%b, queue=%b, rating=%b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        boolean z4 = z || z2 || z3;
        if (z4 || this.episodes == null) {
            return z4;
        }
        Object obj = this.episodes.get("current");
        if (this.seasons == null || (obj instanceof C0993) || (this.seasons.get("current") instanceof C0993)) {
            return true;
        }
        if (!(obj instanceof C1049)) {
            return z4;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - EPISODE_NODE_REFRESH_AGE;
        boolean needsRefresh = ((C1049) obj).needsRefresh(currentTimeMillis2);
        boolean z5 = this.seasons.m3069() != null && this.seasons.m3069().needsRefresh(currentTimeMillis2);
        C1283.m16863(TAG, "shouldRefreshVolatileData currentEpisode=%b, seasonCount=%b", Boolean.valueOf(needsRefresh), Boolean.valueOf(z5));
        return needsRefresh || z5;
    }

    public String toString() {
        return "FalkorVideo [getId()=" + getId() + ", getTitle()=" + getTitle() + ", getType()=" + getType() + "]";
    }

    @Override // o.AbstractC2072pu
    public String getId() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.getId();
    }

    @Override // o.AbstractC2072pu
    public String getTitle() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.getTitle();
    }

    @Override // o.pJ
    public String getBoxshotUrl() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.getBoxshotUrl();
    }

    @Override // o.AbstractC2075px
    public String getCleanBoxshotUrl() {
        return this.cleanBoxshot == null ? getBoxshotUrl() : this.cleanBoxshot.getCleanBoxshotUrl();
    }

    @Override // o.pJ
    public String getBoxartId() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.getBoxartId();
    }

    @Override // o.AbstractC2072pu
    public VideoType getType() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.getType();
    }

    /* access modifiers changed from: protected */
    public boolean isEpisode() {
        return (this.detail == null ? null : Boolean.valueOf(this.detail.isEpisode)).booleanValue();
    }

    @Override // o.pJ
    public VideoType getErrorType() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.getErrorType();
    }

    @Override // o.pT
    public String getTvCardUrl() {
        Video.Detail detail2 = getDetail();
        if (detail2 != null && C1349Bv.m4107(detail2.tvCardUrl)) {
            return detail2.tvCardUrl;
        }
        if (this.tvCardArtUrl == null) {
            return null;
        }
        return this.tvCardArtUrl.getUrl();
    }

    @Override // o.AbstractC2073pv
    public String getHorzDispUrl() {
        if (this.horizontalDisplayArtUrl != null) {
            return this.horizontalDisplayArtUrl.getUrl();
        }
        if (this.searchTitle != null) {
            return this.searchTitle.horzDispUrl;
        }
        if (this.detail != null) {
            return this.detail.horzDispUrl;
        }
        return null;
    }

    @Override // o.AbstractC2073pv
    public String getHorzDispSmallUrl() {
        if (this.horizontalDisplaySmallArtUrl == null) {
            return null;
        }
        return this.horizontalDisplaySmallArtUrl.getUrl();
    }

    @Override // o.AbstractC2074pw
    public String getInterestingUrl() {
        if (this.interestingMomentsUrl != null && this.interestingMomentsUrl.getUrl() != null) {
            return this.interestingMomentsUrl.getUrl();
        }
        Video.Detail detail2 = getDetail();
        if (detail2 != null) {
            return detail2.getInterestingUrl();
        }
        return null;
    }

    @Override // o.pI
    public String getInterestingSmallUrl() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail != null) {
            return currentEpisodeDetail.getInterestingSmallUrl();
        }
        return null;
    }

    @Override // o.AbstractC2074pw
    public String createModifiedStillUrl() {
        return BE.m3843(this, false);
    }

    @Override // o.AbstractC2074pw
    public String createModifiedSmallStillUrl() {
        return BE.m3840(this);
    }

    public String createModifiedBigStillUrl() {
        return BE.m3843(this, true);
    }

    @Override // o.AbstractC2074pw
    public String getTrickplayImgBaseUrl() {
        if (this.baseUrl != null && this.baseUrl.getUrl() != null) {
            return this.baseUrl.getUrl();
        }
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.baseUrl;
    }

    @Override // o.AbstractC2074pw
    public String getTrickplayBigImgBaseUrl() {
        if (this.baseBigUrl != null && this.baseBigUrl.getUrl() != null) {
            return this.baseBigUrl.getUrl();
        }
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.baseUrlBig;
    }

    @Override // o.pF
    public String getPlayableId() {
        return VideoType.MOVIE.equals(getType()) ? getId() : getCurrentEpisodeId();
    }

    @Override // o.pF
    public String getPlayableTitle() {
        return VideoType.MOVIE.equals(getType()) ? getTitle() : getCurrentEpisodeTitle();
    }

    @Override // o.pF
    public boolean isPlayableEpisode() {
        return getCurrentEpisodeDetail() != null;
    }

    @Override // o.pF
    public long getPlayableBookmarkUpdateTime() {
        return getBookmarkLastUpdateTime();
    }

    private long getBookmarkLastUpdateTime() {
        Video.Bookmark bookmark2;
        long j = -1;
        if (this.bookmark != null) {
            j = this.bookmark.getLastModified();
        }
        if (getCurrentEpisode() == null || getCurrentEpisodeDetail() == null || (bookmark2 = (Video.Bookmark) getCurrentEpisode().get("bookmark")) == null) {
            return j;
        }
        return bookmark2.getLastModified();
    }

    @Override // o.pF
    public int getPlayableBookmarkPosition() {
        return C1352By.m4135(getBookmarkPosition(), getEndtime(), getRuntime());
    }

    private int getBookmarkPosition() {
        Video.Bookmark bookmark2;
        int i = -1;
        if (this.bookmark != null) {
            i = this.bookmark.getBookmarkPosition();
        }
        if (getCurrentEpisodeDetail() == null || (bookmark2 = (Video.Bookmark) getCurrentEpisode().get("bookmark")) == null) {
            return i;
        }
        return bookmark2.getBookmarkPosition();
    }

    public Video.Bookmark getBookmark() {
        return this.bookmark;
    }

    @Override // o.pT
    public String getDefaultTrailer() {
        if (this.supplementalVideos == null) {
            return null;
        }
        return this.supplementalVideos.defaultTrailer;
    }

    @Override // o.pF
    public String getParentTitle() {
        if (VideoType.MOVIE.equals(getType())) {
            return null;
        }
        return getTitle();
    }

    @Override // o.pF
    public String getTopLevelId() {
        return getId();
    }

    @Override // o.pF
    public int getRuntime() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return 0;
        }
        return detail2.runtime;
    }

    @Override // o.pF
    public int getEndtime() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return 0;
        }
        return detail2.endtime;
    }

    @Override // o.pF
    public int getLogicalStart() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return 0;
        }
        return detail2.logicalStart;
    }

    @Override // o.pF
    public int getEpisodeNumber() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return -1;
        }
        return currentEpisodeDetail.getEpisodeNumber();
    }

    @Override // o.pF, o.pS
    public int getSeasonNumber() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return -1;
        }
        return currentEpisodeDetail.getSeasonNumber();
    }

    @Override // o.pF
    public boolean isAutoPlayEnabled() {
        if (VideoType.MOVIE.equals(getType())) {
            Video.Detail detail2 = getDetail();
            if (detail2 == null) {
                return false;
            }
            return detail2.isAutoPlayEnabled;
        }
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return false;
        }
        return currentEpisodeDetail.isAutoPlayEnabled();
    }

    @Override // o.pF
    public int getAutoPlayMaxCount() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return -1;
        }
        return detail2.autoPlayMaxCount;
    }

    @Override // o.pF
    public boolean isNextPlayableEpisode() {
        Episode.Detail currentEpisodeDetail;
        if (!VideoType.SHOW.equals(getType()) || (currentEpisodeDetail = getCurrentEpisodeDetail()) == null) {
            return false;
        }
        return currentEpisodeDetail.isNextPlayableEpisode();
    }

    @Override // o.pF
    public boolean isPinProtected() {
        if (VideoType.MOVIE.equals(getType())) {
            Video.Detail detail2 = getDetail();
            if (detail2 == null) {
                return false;
            }
            return detail2.isPinProtected;
        }
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return false;
        }
        return currentEpisodeDetail.isPinProtected();
    }

    @Override // o.pF
    public boolean isPreviewProtected() {
        if (VideoType.MOVIE.equals(getType())) {
            Video.Detail detail2 = getDetail();
            return detail2 != null && detail2.isPreviewProtected;
        }
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        return currentEpisodeDetail != null && currentEpisodeDetail.isPreviewProtected();
    }

    @Override // o.pF
    public boolean isAgeProtected() {
        Video.Detail detail2 = getDetail();
        return detail2 != null && detail2.isAgeProtected;
    }

    private Episode.Detail getCurrentEpisodeDetail() {
        C1383Cz currentEpisode = getCurrentEpisode();
        if (currentEpisode == null) {
            return null;
        }
        return (Episode.Detail) currentEpisode.get("detail");
    }

    private C1383Cz getCurrentEpisode() {
        Object obj;
        if (this.episodes == null || (obj = this.episodes.get("current")) == null || (obj instanceof C0993)) {
            return null;
        }
        return (C1383Cz) ((C1049) obj).m16078(getModelProxy());
    }

    @Override // o.pT
    public int getYear() {
        Video.Detail detail2 = getDetail();
        int i = detail2 == null ? 0 : detail2.year;
        if (i > 0) {
            return i;
        }
        if (this.searchTitle == null) {
            return 0;
        }
        return this.searchTitle.releaseYear;
    }

    @Override // o.pT
    public String getStoryUrl() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.storyImgUrl;
    }

    @Override // o.pT
    public String getSynopsis() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.synopsis;
    }

    @Override // o.pT
    public String getCertification() {
        Video.Detail detail2 = getDetail();
        String str = detail2 == null ? null : detail2.certification;
        if (!C1349Bv.m4113(str)) {
            return str;
        }
        if (this.searchTitle == null) {
            return null;
        }
        return this.searchTitle.certification;
    }

    @Override // o.pT
    public int getMaturityLevel() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return -1;
        }
        return detail2.maturityLevel;
    }

    @Override // o.pF
    public long getExpirationTime() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return -1;
        }
        return detail2.expirationTime;
    }

    @Override // o.pF
    public List<Advisory> getAdvisories() {
        return this.advisories == null ? new ArrayList(0) : this.advisories.getAdvisoryList();
    }

    @Override // o.pT
    public String getSupplementalMessage() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.supplementalMessage;
    }

    @Override // o.pJ
    public boolean isOriginal() {
        Video.Detail detail2 = getDetail();
        if (detail2 != null) {
            return detail2.isOriginal;
        }
        if (this.searchTitle != null) {
            return this.searchTitle.isOriginal;
        }
        return false;
    }

    @Override // o.pF
    public boolean isNSRE() {
        Video.Detail detail2 = getDetail();
        return detail2 != null && detail2.isNSRE;
    }

    @Override // o.pF
    public boolean isEpisodeNumberHidden() {
        Video.Detail detail2 = getDetail();
        return detail2 != null && detail2.episodeNumberHidden;
    }

    @Override // o.pF
    public boolean isAvailableOffline() {
        if (this.offlineAvailable != null) {
            return this.offlineAvailable.isAvailableOffline();
        }
        return false;
    }

    @Override // o.pT
    public boolean hasWatched() {
        return this.hasWatched != null && this.hasWatched.hasWatched;
    }

    @Override // o.pJ
    public boolean isPreRelease() {
        Video.Detail detail2 = getDetail();
        if (detail2 != null) {
            return detail2.isPreRelease;
        }
        if (this.searchTitle != null) {
            return this.searchTitle.isPreRelease;
        }
        return false;
    }

    public MotionBoxart getMotionBoxart() {
        if (this.summary != null) {
            return this.summary.getMotionBoxart();
        }
        return null;
    }

    public InteractiveFeatures getInteractiveFeatures() {
        if (this.detail != null) {
            return this.detail.interactiveFeatures;
        }
        return null;
    }

    @Override // o.pT
    public boolean hasTrailers() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return false;
        }
        return detail2.hasTrailers;
    }

    @Override // o.pF
    public boolean isSupplementalVideo() {
        Video.Detail detail2 = getDetail();
        return detail2 != null && detail2.isSupplementalVideo;
    }

    @Override // o.pF
    public boolean supportsPrePlay() {
        Video.Detail detail2 = VideoType.MOVIE == getType() ? getDetail() : getCurrentEpisodeDetail();
        return detail2 != null && detail2.supportsPrePlay;
    }

    @Override // o.pT
    public String getQuality() {
        if (this.detail == null) {
            return null;
        }
        return this.detail.quality;
    }

    @Override // o.pT
    public String getActors() {
        if (this.detail == null) {
            return null;
        }
        return this.detail.actors;
    }

    @Override // o.pP, o.pR
    public Set<String> getCharacterRoles() {
        if (this.detail == null) {
            return null;
        }
        return this.detail.characterRoles;
    }

    @Override // o.pT
    public String getGenres() {
        if (this.detail == null) {
            return null;
        }
        return this.detail.genres;
    }

    public void setUserThumbRating(int i) {
        this.rating.userThumbRating = i;
    }

    @Override // o.pE
    public int getUserThumbRating() {
        if (this.rating == null) {
            return 0;
        }
        return this.rating.userThumbRating;
    }

    @Override // o.pB
    public int getMatchPercentage() {
        Video.RatingInfo ratingInfo = this.rating;
        if (ratingInfo == null) {
            return -1;
        }
        return ratingInfo.matchPercentage;
    }

    @Override // o.pB
    public boolean isNewForPvr() {
        Video.RatingInfo ratingInfo = this.rating;
        if (ratingInfo == null) {
            return false;
        }
        return ratingInfo.isNewForPvr;
    }

    @Override // o.pT
    public boolean isInQueue() {
        if (this.inQueue == null) {
            return false;
        }
        return this.inQueue.inQueue;
    }

    @Override // o.pT
    public String getHighResolutionPortraitBoxArtUrl() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.mdxVertUrl;
    }

    @Override // o.pT
    public String getHighResolutionLandscapeBoxArtUrl() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.hiResHorzUrl;
    }

    @Override // o.AbstractC2073pv
    public String getStoryDispUrl() {
        if (this.storyImgDisplayArtUrl == null) {
            return null;
        }
        return this.storyImgDisplayArtUrl.getUrl();
    }

    public String getVerticalStoryArtUrl() {
        return this.vertStoryArtUrl.url;
    }

    @Override // o.pT
    public String getBifUrl() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.bifUrl;
    }

    @Override // o.pT
    public String getCatalogIdUrl() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.restUrl;
    }

    @Override // o.AbstractC2076py
    public boolean isVideoHd() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return false;
        }
        return detail2.isHdAvailable;
    }

    @Override // o.AbstractC2076py
    public boolean isVideoUhd() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return false;
        }
        return detail2.isUhdAvailable;
    }

    @Override // o.AbstractC2076py
    public boolean isVideo5dot1() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return false;
        }
        return detail2.is5dot1Available;
    }

    @Override // o.AbstractC2076py
    public boolean isVideoHdr10() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return false;
        }
        return detail2.isHdr10Avaiable;
    }

    @Override // o.AbstractC2076py
    public boolean isVideoDolbyVision() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return false;
        }
        return detail2.isDolbyVisionAvailable;
    }

    @Override // o.pT
    public pF getPlayable() {
        return this;
    }

    @Override // o.pP
    public String getDirectors() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.directors;
    }

    @Override // o.pP
    public int getNumDirectors() {
        return C1349Bv.m4114(getDirectors());
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<I extends o.ᓼ>, java.util.List<o.pJ> */
    @Override // o.pQ
    public List<pJ> getSimilars() {
        return (List<I>) getModelProxy().mo15259(C0506.m14509(getType() == VideoType.MOVIE, getId()));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<I extends o.ᓼ>, java.util.List<o.pJ> */
    @Override // o.pU
    public List<pJ> getTrailers() {
        return (List<I>) getModelProxy().mo15259(C0506.m14503(getType() == VideoType.MOVIE, getId()));
    }

    @Override // o.pQ
    public int getSimilarsTrackId() {
        TrackableListSummary similarsSummary = getSimilarsSummary();
        if (similarsSummary == null) {
            return 0;
        }
        return similarsSummary.getTrackId();
    }

    @Override // o.pU
    public int getTrailersTrackId() {
        TrackableListSummary trailersSummary = getTrailersSummary();
        if (trailersSummary == null) {
            return 0;
        }
        return trailersSummary.getTrackId();
    }

    @Override // o.pQ
    public String getSimilarsRequestId() {
        TrackableListSummary similarsSummary = getSimilarsSummary();
        if (similarsSummary == null) {
            return null;
        }
        return similarsSummary.getRequestId();
    }

    @Override // o.pU
    public String getTrailersRequestId() {
        TrackableListSummary trailersSummary = getTrailersSummary();
        if (trailersSummary == null) {
            return null;
        }
        return trailersSummary.getRequestId();
    }

    private TrackableListSummary getSimilarsSummary() {
        if (this.sims == null) {
            return null;
        }
        return (TrackableListSummary) this.sims.get("summary");
    }

    private TrackableListSummary getTrailersSummary() {
        if (this.trailers == null) {
            return null;
        }
        return (TrackableListSummary) this.trailers.get("summary");
    }

    @Override // o.pQ
    public int getSimilarsListPos() {
        return 0;
    }

    @Override // o.pU
    public int getTrailersListPos() {
        return 0;
    }

    @Override // o.pR
    public String getNumSeasonsLabel() {
        Video.Detail detail2 = getDetail();
        return (detail2 == null || detail2.seasonNumLabel == null) ? "" : detail2.seasonNumLabel;
    }

    @Override // o.pR
    public String getCreators() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.directors;
    }

    @Override // o.pR
    public int getNumCreators() {
        return C1349Bv.m4114(getCreators());
    }

    @Override // o.pS
    public int getNumOfEpisodes() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return -1;
        }
        return detail2.episodeCount;
    }

    @Override // o.pR
    public int getCurrentEpisodeNumber() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return -1;
        }
        return currentEpisodeDetail.getEpisodeNumber();
    }

    @Override // o.pR
    public String getCurrentEpisodeId() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return null;
        }
        return currentEpisodeDetail.getId();
    }

    @Override // o.AbstractC2074pw, o.pR
    public String getCurrentEpisodeTitle() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return null;
        }
        return currentEpisodeDetail.getTitle();
    }

    public String getCurrentEpisodeStoryImgUrl() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return null;
        }
        return currentEpisodeDetail.getSoryImgUrl();
    }

    @Override // o.pR
    public String getCurrentEpisodeHorzDispUrl() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return null;
        }
        return currentEpisodeDetail.getHorzDispUrl();
    }

    @Override // o.pR
    public String getCurrentEpisodeSynopsis() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return null;
        }
        return currentEpisodeDetail.getSynopsis();
    }

    @Override // o.pR
    public String getCurrentEpisodeBadge() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return null;
        }
        return currentEpisodeDetail.getNewBadge();
    }

    @Override // o.pR
    public int getCurrentSeasonNumber() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        if (currentEpisodeDetail == null) {
            return -1;
        }
        return currentEpisodeDetail.getSeasonNumber();
    }

    @Override // o.pR
    public CB getCurrentSeasonDetail() {
        if (getType() != VideoType.SHOW) {
            return null;
        }
        Object r5 = getModelProxy().mo15251(C0859.m15528("shows", getId(), "seasons", "current", "detail"));
        if (r5 instanceof CB) {
            return (CB) r5;
        }
        return null;
    }

    public String getEvidenceText() {
        if (this.videoEvidence == null) {
            return null;
        }
        return this.videoEvidence.getText();
    }

    public IconFontGlyph getEvidenceGlyph() {
        if (this.videoEvidence == null) {
            return null;
        }
        return this.videoEvidence.getIconFontGlyph();
    }

    public String getNarrative() {
        Video.Detail detail2 = getDetail();
        if (detail2 != null) {
            return detail2.synopsisNarrative;
        }
        return null;
    }

    @Override // o.pN
    public String getNewBadge() {
        Video.Detail detail2 = getDetail();
        if (detail2 != null) {
            return detail2.newBadge;
        }
        return null;
    }

    @Override // o.pR
    public int getSeasonCount() {
        TrackableListSummary r3;
        if (getType() != VideoType.SHOW || this.seasons == null || (r3 = this.seasons.m3069()) == null) {
            return 0;
        }
        return r3.getLength();
    }

    @Override // o.pM
    public List<String> getHeroImages() {
        if (this.heroImages == null) {
            return null;
        }
        return this.heroImages.heroImgs;
    }

    @Override // o.pT
    public String getTitleImgUrl() {
        if (this.detail != null) {
            return this.detail.titleUrl;
        }
        return null;
    }

    @Override // o.pT
    public String getTitleCroppedImgUrl() {
        if (this.detail == null) {
            return null;
        }
        return this.detail.titleCroppedUrl;
    }

    @Override // o.pO
    public List<pN> getPostPlayVideos() {
        if (isPostPlayInvalid("videos")) {
            return null;
        }
        return this.proxy.mo15259(C0859.m15528(getType().getValue(), getId(), "postPlayExperience", C0859.m15519(2), "videoRef", "summary"));
    }

    @Override // o.pO
    public PostPlayExperience getPostPlayExperienceData() {
        if (this.postPlayExperience == null || getId() == null) {
            return null;
        }
        List r4 = this.proxy.mo15259(C0859.m15528("postPlayExperiences", getId(), "experienceData"));
        if (r4.size() != 0) {
            return (PostPlayExperience) r4.get(0);
        }
        return null;
    }

    public List<Object> getPostPlayContexts() {
        if (isPostPlayInvalid("contexts")) {
            return null;
        }
        return this.proxy.mo15259(C0859.m15528(getType().getValue(), getId(), "postPlayExperience", C0859.m15519(2), "postplayContext"));
    }

    private boolean isPostPlayInvalid(String str) {
        if (getId() == null) {
            logInvalidPostPlayMethod(str, "video ID");
            return true;
        } else if (getType() != null) {
            return false;
        } else {
            logInvalidPostPlayMethod(str, "video type");
            return true;
        }
    }

    private void logInvalidPostPlayMethod(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SPY-7478 - Can't get post play ").append(str).append(" because ").append(str2).append(" is null - ").append("getType=").append(getType()).append(",getId=").append(getId()).append(",getCurrentEpisodeId=").append(getCurrentEpisodeId());
        String sb2 = sb.toString();
        C1283.m16865(TAG, sb2);
        C1276.m16820().mo5725(sb2);
    }

    @Override // o.pF
    public boolean isAvailableToStream() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return true;
        }
        return detail2.isAvailableToStream;
    }

    @Override // o.pT
    public String getCopyright() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.copyright;
    }

    @Override // o.AbstractC2077pz
    public BillboardSummary getBillboardSummary() {
        return this.billboardSummary;
    }

    @Override // o.pF
    public boolean isAdvisoryDisabled() {
        return false;
    }

    @Override // o.pF
    public String getSeasonAbbrSeqLabel() {
        Episode.Detail currentEpisodeDetail = getCurrentEpisodeDetail();
        return (currentEpisodeDetail == null || currentEpisodeDetail.abbrSeqLabel == null) ? "" : currentEpisodeDetail.abbrSeqLabel;
    }

    @Override // o.pF
    public CreditMarks getCreditMarks() {
        Video.Detail detail2 = getDetail();
        if (detail2 == null) {
            return null;
        }
        return detail2.creditMarks;
    }

    public PrePlayExperiences getPreplayExperiences() {
        return this.prePlayExperiences;
    }

    public CH getWatchNextVideo() {
        if (this.watchNext == null) {
            return null;
        }
        return (CH) this.watchNext.m16078(getModelProxy());
    }

    @Override // o.AbstractC2070ps
    public BigRowSummary getBigRowSummary() {
        return this.bigRowSummary;
    }
}
