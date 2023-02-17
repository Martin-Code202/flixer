package o;

import android.content.Context;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmVideoDetailsRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* renamed from: o.qr  reason: case insensitive filesystem */
public class C2098qr implements pT, RealmModel, RealmVideoDetailsRealmProxyInterface {
    private String actors;
    private String bifUrl;
    private String boxartImageId;
    private String boxshotUrl;
    private String catalogIdUrl;
    private String cert;
    private String copyright;
    private String defaultTrailer;
    private int errorType;
    private String genres;
    private String hResLandBoxArtUrl;
    private String hResPortBoxArtUrl;
    private boolean hasTrailers;
    private boolean hasWatched;
    private String horzDispSmallUrl;
    private String horzDispUrl;
    private String id;
    private boolean isInQueue;
    private boolean isOriginal;
    private boolean isPreRelease;
    private boolean isVideo5dot1;
    private boolean isVideoDolbyVision;
    private boolean isVideoHd;
    private boolean isVideoHdr10;
    private boolean isVideoUhd;
    private int maturityLevel;
    private String nextEpisodeId;
    private C2092qm playable;
    private String profileId;
    private String quality;
    private RealmList<RealmSeason> seasonLabels;
    private int seasonNumber;
    private String storyDispUrl;
    private String storyUrl;
    private String supplMessage;
    private String synopsis;
    private String title;
    private String titleCroppedImgUrl;
    private String titleImgUrl;
    private String tvCardUrl;
    private int videoType;
    private int year;

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$actors() {
        return this.actors;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$bifUrl() {
        return this.bifUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$boxartImageId() {
        return this.boxartImageId;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$boxshotUrl() {
        return this.boxshotUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$catalogIdUrl() {
        return this.catalogIdUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$cert() {
        return this.cert;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$copyright() {
        return this.copyright;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$defaultTrailer() {
        return this.defaultTrailer;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$errorType() {
        return this.errorType;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$genres() {
        return this.genres;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$hResLandBoxArtUrl() {
        return this.hResLandBoxArtUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$hResPortBoxArtUrl() {
        return this.hResPortBoxArtUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$hasTrailers() {
        return this.hasTrailers;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$hasWatched() {
        return this.hasWatched;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$horzDispSmallUrl() {
        return this.horzDispSmallUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$horzDispUrl() {
        return this.horzDispUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$id() {
        return this.id;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isInQueue() {
        return this.isInQueue;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isOriginal() {
        return this.isOriginal;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isPreRelease() {
        return this.isPreRelease;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideo5dot1() {
        return this.isVideo5dot1;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoDolbyVision() {
        return this.isVideoDolbyVision;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoHd() {
        return this.isVideoHd;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoHdr10() {
        return this.isVideoHdr10;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public boolean realmGet$isVideoUhd() {
        return this.isVideoUhd;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$maturityLevel() {
        return this.maturityLevel;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$nextEpisodeId() {
        return this.nextEpisodeId;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public C2092qm realmGet$playable() {
        return this.playable;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$profileId() {
        return this.profileId;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$quality() {
        return this.quality;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public RealmList realmGet$seasonLabels() {
        return this.seasonLabels;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$seasonNumber() {
        return this.seasonNumber;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$storyDispUrl() {
        return this.storyDispUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$storyUrl() {
        return this.storyUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$supplMessage() {
        return this.supplMessage;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$synopsis() {
        return this.synopsis;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$title() {
        return this.title;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$titleCroppedImgUrl() {
        return this.titleCroppedImgUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$titleImgUrl() {
        return this.titleImgUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public String realmGet$tvCardUrl() {
        return this.tvCardUrl;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$videoType() {
        return this.videoType;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public int realmGet$year() {
        return this.year;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$actors(String str) {
        this.actors = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$bifUrl(String str) {
        this.bifUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$boxartImageId(String str) {
        this.boxartImageId = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$boxshotUrl(String str) {
        this.boxshotUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$catalogIdUrl(String str) {
        this.catalogIdUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$cert(String str) {
        this.cert = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$copyright(String str) {
        this.copyright = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$defaultTrailer(String str) {
        this.defaultTrailer = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$errorType(int i) {
        this.errorType = i;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$genres(String str) {
        this.genres = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hResLandBoxArtUrl(String str) {
        this.hResLandBoxArtUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hResPortBoxArtUrl(String str) {
        this.hResPortBoxArtUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hasTrailers(boolean z) {
        this.hasTrailers = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$hasWatched(boolean z) {
        this.hasWatched = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$horzDispSmallUrl(String str) {
        this.horzDispSmallUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$horzDispUrl(String str) {
        this.horzDispUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isInQueue(boolean z) {
        this.isInQueue = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isOriginal(boolean z) {
        this.isOriginal = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isPreRelease(boolean z) {
        this.isPreRelease = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideo5dot1(boolean z) {
        this.isVideo5dot1 = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoDolbyVision(boolean z) {
        this.isVideoDolbyVision = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoHd(boolean z) {
        this.isVideoHd = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoHdr10(boolean z) {
        this.isVideoHdr10 = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$isVideoUhd(boolean z) {
        this.isVideoUhd = z;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$maturityLevel(int i) {
        this.maturityLevel = i;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$nextEpisodeId(String str) {
        this.nextEpisodeId = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$playable(C2092qm qmVar) {
        this.playable = qmVar;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$profileId(String str) {
        this.profileId = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$quality(String str) {
        this.quality = str;
    }

    public void realmSet$seasonLabels(RealmList realmList) {
        this.seasonLabels = realmList;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$seasonNumber(int i) {
        this.seasonNumber = i;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$storyDispUrl(String str) {
        this.storyDispUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$storyUrl(String str) {
        this.storyUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$supplMessage(String str) {
        this.supplMessage = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$synopsis(String str) {
        this.synopsis = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$title(String str) {
        this.title = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$titleCroppedImgUrl(String str) {
        this.titleCroppedImgUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$titleImgUrl(String str) {
        this.titleImgUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$tvCardUrl(String str) {
        this.tvCardUrl = str;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$videoType(int i) {
        this.videoType = i;
    }

    @Override // io.realm.RealmVideoDetailsRealmProxyInterface
    public void realmSet$year(int i) {
        this.year = i;
    }

    public C2098qr() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public void fillForRealm(pT pTVar) {
        realmSet$year(pTVar.getYear());
        realmSet$maturityLevel(pTVar.getMaturityLevel());
        realmSet$synopsis(pTVar.getSynopsis());
        realmSet$quality(pTVar.getQuality());
        realmSet$actors(pTVar.getActors());
        realmSet$genres(pTVar.getGenres());
        realmSet$cert(pTVar.getCertification());
        realmSet$supplMessage(pTVar.getSupplementalMessage());
        realmSet$defaultTrailer(pTVar.getDefaultTrailer());
        realmSet$copyright(pTVar.getCopyright());
        realmSet$hResPortBoxArtUrl(pTVar.getHighResolutionPortraitBoxArtUrl());
        realmSet$hResLandBoxArtUrl(pTVar.getHighResolutionLandscapeBoxArtUrl());
        realmSet$boxshotUrl(pTVar.getBoxshotUrl());
        realmSet$boxartImageId(pTVar.getBoxartId());
        if (pTVar instanceof pI) {
            realmSet$horzDispUrl(((pI) pTVar).getInterestingUrl());
            realmSet$nextEpisodeId(((pI) pTVar).mo4562());
        } else {
            realmSet$horzDispUrl(pTVar.getHorzDispUrl());
        }
        realmSet$horzDispSmallUrl(pTVar.getHorzDispSmallUrl());
        realmSet$storyDispUrl(pTVar.getStoryDispUrl());
        realmSet$tvCardUrl(pTVar.getTvCardUrl());
        realmSet$storyUrl(pTVar.getStoryUrl());
        realmSet$bifUrl(pTVar.getBifUrl());
        realmSet$catalogIdUrl(pTVar.getCatalogIdUrl());
        realmSet$titleImgUrl(pTVar.getTitleImgUrl());
        realmSet$titleCroppedImgUrl(pTVar.getTitleCroppedImgUrl());
        realmSet$title(pTVar.getTitle());
        realmSet$isOriginal(pTVar.isOriginal());
        realmSet$isPreRelease(pTVar.isPreRelease());
        realmSet$hasWatched(pTVar.hasWatched());
        realmSet$hasTrailers(pTVar.hasTrailers());
        realmSet$isInQueue(pTVar.isInQueue());
        realmSet$isVideoHd(pTVar.isVideoHd());
        realmSet$isVideoUhd(pTVar.isVideoUhd());
        realmSet$isVideo5dot1(pTVar.isVideo5dot1());
        realmSet$isVideoHdr10(pTVar.isVideoHdr10());
        realmSet$isVideoDolbyVision(pTVar.isVideoDolbyVision());
        if (pTVar.getErrorType() != null) {
            realmSet$errorType(pTVar.getErrorType().getKey());
        }
        realmSet$seasonNumber(pTVar.getPlayable().getSeasonNumber());
        realmSet$videoType(pTVar.getType().getKey());
    }

    public static void insertInRealm(Realm realm, AbstractC0933 r2, pT pTVar, String str) {
        insertInRealm(realm, r2, pTVar, null, str);
    }

    public static void insertInRealm(Realm realm, final AbstractC0933 r3, final pT pTVar, final List<pS> list, final String str) {
        if (C2093qn.m10092(realm, C2098qr.class, pTVar.getId())) {
            C2093qn.m10091(realm, new Realm.Transaction() { // from class: o.qr.5
                @Override // io.realm.Realm.Transaction
                public void execute(Realm realm2) {
                    C2098qr qrVar = (C2098qr) realm2.createObject(C2098qr.class, pTVar.getId());
                    qrVar.fillForRealm(pTVar);
                    qrVar.realmSet$profileId(str);
                    if (list != null) {
                        for (pS pSVar : list) {
                            if (qrVar.realmGet$seasonLabels() == null) {
                                qrVar.realmSet$seasonLabels(new RealmList());
                            }
                            RealmSeason realmSeason = new RealmSeason();
                            realmSeason.setNumber(pSVar.getSeasonNumber());
                            realmSeason.setTitle(pSVar.getTitle());
                            qrVar.realmGet$seasonLabels().add(realmSeason);
                        }
                    }
                    C2092qm qmVar = (C2092qm) realm2.where(C2092qm.class).equalTo("playableId", pTVar.getPlayable().getPlayableId()).findFirst();
                    if (qmVar == null) {
                        qmVar = (C2092qm) realm2.copyToRealm(new C2092qm(pTVar.getPlayable()));
                    }
                    qrVar.setPlayable(qmVar);
                    C2053pb.m9720((Context) C1281.m16832(Context.class), r3, qrVar.getHorzDispUrl(), qrVar.getId());
                    realm2.where(RealmIncompleteVideoDetails.class).equalTo("playableId", pTVar.getId()).findAll().deleteAllFromRealm();
                }
            });
        } else {
            C2093qn.m10091(realm, new Realm.Transaction() { // from class: o.qr.4
                @Override // io.realm.Realm.Transaction
                public void execute(Realm realm2) {
                    realm2.where(RealmIncompleteVideoDetails.class).equalTo("playableId", pTVar.getId()).findAll().deleteAllFromRealm();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPlayable(C2092qm qmVar) {
        realmSet$playable(qmVar);
    }

    public void setPlayableAndVideoType(C2092qm qmVar, VideoType videoType2, String str) {
        setPlayable(qmVar);
        realmSet$videoType(videoType2.getKey());
        realmSet$title(str);
    }

    public String getProfileId() {
        return realmGet$profileId();
    }

    public String getSeasonTitle(int i) {
        Iterator it = realmGet$seasonLabels().iterator();
        while (it.hasNext()) {
            RealmSeason realmSeason = (RealmSeason) it.next();
            if (realmSeason.getNumber() == i) {
                return realmSeason.getTitle();
            }
        }
        return null;
    }

    @Override // o.pT
    public int getYear() {
        return realmGet$year();
    }

    @Override // o.pT
    public String getSynopsis() {
        return realmGet$synopsis();
    }

    @Override // o.pT
    public String getQuality() {
        return realmGet$quality();
    }

    @Override // o.pT
    public String getActors() {
        return realmGet$actors();
    }

    @Override // o.pT
    public String getGenres() {
        return realmGet$genres();
    }

    @Override // o.pT
    public String getCertification() {
        return realmGet$cert();
    }

    @Override // o.pT
    public int getMaturityLevel() {
        return realmGet$maturityLevel();
    }

    @Override // o.pT
    public String getSupplementalMessage() {
        return realmGet$supplMessage();
    }

    @Override // o.pT, o.pJ
    public boolean isOriginal() {
        return realmGet$isOriginal();
    }

    @Override // o.pJ
    public boolean isPreRelease() {
        return realmGet$isPreRelease();
    }

    @Override // o.pT
    public boolean isNSRE() {
        return realmGet$playable().isNSRE();
    }

    @Override // o.pT
    public boolean isEpisodeNumberHidden() {
        return realmGet$playable().isEpisodeNumberHidden();
    }

    @Override // o.pT
    public boolean hasWatched() {
        return realmGet$hasWatched();
    }

    @Override // o.pT
    public boolean hasTrailers() {
        return realmGet$hasTrailers();
    }

    @Override // o.pT
    public String getDefaultTrailer() {
        return realmGet$defaultTrailer();
    }

    @Override // o.pT
    public String getCopyright() {
        return realmGet$copyright();
    }

    @Override // o.pT
    public boolean isInQueue() {
        return realmGet$isInQueue();
    }

    @Override // o.pT
    public String getHighResolutionPortraitBoxArtUrl() {
        return realmGet$hResPortBoxArtUrl();
    }

    @Override // o.pT
    public String getHighResolutionLandscapeBoxArtUrl() {
        return realmGet$hResLandBoxArtUrl();
    }

    @Override // o.pJ
    public String getBoxshotUrl() {
        return realmGet$boxshotUrl();
    }

    @Override // o.pJ
    public String getBoxartId() {
        return realmGet$boxartImageId();
    }

    @Override // o.AbstractC2073pv
    public String getHorzDispUrl() {
        return realmGet$horzDispUrl();
    }

    public String getRealmHorzDispUrl(Context context) {
        String r2 = C2053pb.m9721(context, getId());
        return new File(r2).exists() ? "file://" + r2 : realmGet$horzDispUrl();
    }

    @Override // o.AbstractC2073pv
    public String getHorzDispSmallUrl() {
        return realmGet$horzDispSmallUrl();
    }

    @Override // o.pJ
    public VideoType getErrorType() {
        return VideoType.values()[realmGet$errorType()];
    }

    @Override // o.AbstractC2073pv
    public String getStoryDispUrl() {
        return realmGet$storyDispUrl();
    }

    @Override // o.pT
    public String getTvCardUrl() {
        return realmGet$tvCardUrl();
    }

    @Override // o.pT
    public String getStoryUrl() {
        return realmGet$storyUrl();
    }

    @Override // o.pT
    public String getBifUrl() {
        return realmGet$bifUrl();
    }

    @Override // o.pT
    public String getCatalogIdUrl() {
        return realmGet$catalogIdUrl();
    }

    @Override // o.pT
    public pF getPlayable() {
        return realmGet$playable();
    }

    @Override // o.pT
    public String getTitleImgUrl() {
        return realmGet$titleImgUrl();
    }

    @Override // o.pT
    public String getTitleCroppedImgUrl() {
        return realmGet$titleCroppedImgUrl();
    }

    public String getNextEpisodeId() {
        return realmGet$nextEpisodeId();
    }

    @Override // o.pT
    public boolean isAvailableToStream() {
        return realmGet$playable().isAvailableToStream();
    }

    @Override // o.AbstractC2072pu
    public String getId() {
        return realmGet$id();
    }

    @Override // o.AbstractC2072pu
    public String getTitle() {
        return realmGet$title();
    }

    @Override // o.AbstractC2072pu
    public VideoType getType() {
        return VideoType.create(realmGet$videoType());
    }

    @Override // o.AbstractC2076py
    public boolean isVideoHd() {
        return realmGet$isVideoHd();
    }

    @Override // o.AbstractC2076py
    public boolean isVideoUhd() {
        return realmGet$isVideoUhd();
    }

    @Override // o.AbstractC2076py
    public boolean isVideo5dot1() {
        return realmGet$isVideo5dot1();
    }

    @Override // o.AbstractC2076py
    public boolean isVideoHdr10() {
        return realmGet$isVideoHdr10();
    }

    @Override // o.AbstractC2076py
    public boolean isVideoDolbyVision() {
        return realmGet$isVideoDolbyVision();
    }

    public String toString() {
        return "RealmVideoDetails{id='" + realmGet$id() + "', year=" + realmGet$year() + ", maturityLevel=" + realmGet$maturityLevel() + ", synopsis='" + realmGet$synopsis() + "', quality='" + realmGet$quality() + "', actors='" + realmGet$actors() + "', genres='" + realmGet$genres() + "', cert='" + realmGet$cert() + "', supplMessage='" + realmGet$supplMessage() + "', defaultTrailer='" + realmGet$defaultTrailer() + "', copyright='" + realmGet$copyright() + "', hResPortBoxArtUrl='" + realmGet$hResPortBoxArtUrl() + "', hResLandBoxArtUrl='" + realmGet$hResLandBoxArtUrl() + "', boxshotUrl='" + realmGet$boxshotUrl() + "', boxartImageId='" + realmGet$boxartImageId() + "', horzDispUrl='" + realmGet$horzDispUrl() + "', horzDispSmallUrl='" + realmGet$horzDispSmallUrl() + "', storyDispUrl='" + realmGet$storyDispUrl() + "', tvCardUrl='" + realmGet$tvCardUrl() + "', storyUrl='" + realmGet$storyUrl() + "', bifUrl='" + realmGet$bifUrl() + "', catalogIdUrl='" + realmGet$catalogIdUrl() + "', titleImgUrl='" + realmGet$titleImgUrl() + "', titleCroppedImgUrl='" + realmGet$titleCroppedImgUrl() + "', title='" + realmGet$title() + "', isOriginal=" + realmGet$isOriginal() + ", isPreRelease=" + realmGet$isPreRelease() + ", hasWatched=" + realmGet$hasWatched() + ", hasTrailers=" + realmGet$hasTrailers() + ", isInQueue=" + realmGet$isInQueue() + ", isVideoHd=" + realmGet$isVideoHd() + ", isVideoUhd=" + realmGet$isVideoUhd() + ", isVideo5dot1=" + realmGet$isVideo5dot1() + ", isVideoHdr10=" + realmGet$isVideoHdr10() + ", isVideoDolbyVision=" + realmGet$isVideoDolbyVision() + ", playable=" + realmGet$playable() + ", errorType=" + realmGet$errorType() + ", videoType=" + realmGet$videoType() + '}';
    }

    @Override // o.pB
    public int getUserThumbRating() {
        throw new UnsupportedOperationException("not supported in offline realm");
    }

    @Override // o.pB
    public int getMatchPercentage() {
        throw new UnsupportedOperationException("not supported in offline realm");
    }

    @Override // o.pB
    public boolean isNewForPvr() {
        throw new UnsupportedOperationException("not supported in offline realm");
    }

    @Override // o.pT
    public boolean shouldRefreshVolatileData() {
        return false;
    }
}
