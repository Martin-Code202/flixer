package o;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import io.realm.RealmModel;
import io.realm.RealmPlayableRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.util.List;
/* renamed from: o.qm  reason: case insensitive filesystem */
public class C2092qm implements pF, RealmModel, RealmPlayableRealmProxyInterface {
    private String advisoriesString;
    protected int bookmark;
    private int duration;
    private int endtime;
    private int episodeNumber;
    private boolean episodeNumberHidden;
    private long expTime;
    private boolean isAdvisoryDisabled;
    private boolean isAgeProtected;
    private boolean isAutoPlay;
    private boolean isAvailableToStream;
    private boolean isEpisode;
    private boolean isNSRE;
    private boolean isNextPlayableEpisode;
    private boolean isPinProtected;
    private boolean isPreviewProtected;
    private boolean isSupplementalVideo;
    private int logicalStart;
    private int maxAutoplay;
    private String parentId;
    private String parentTitle;
    private String playableId;
    private String seasonLabel;
    private int seasonNumber;
    private boolean supportsPrePlay;
    private String title;
    private long watchedTime;

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$advisoriesString() {
        return this.advisoriesString;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$bookmark() {
        return this.bookmark;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$duration() {
        return this.duration;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$endtime() {
        return this.endtime;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$episodeNumber() {
        return this.episodeNumber;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$episodeNumberHidden() {
        return this.episodeNumberHidden;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public long realmGet$expTime() {
        return this.expTime;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAdvisoryDisabled() {
        return this.isAdvisoryDisabled;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAgeProtected() {
        return this.isAgeProtected;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAutoPlay() {
        return this.isAutoPlay;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isAvailableToStream() {
        return this.isAvailableToStream;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isEpisode() {
        return this.isEpisode;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isNSRE() {
        return this.isNSRE;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isNextPlayableEpisode() {
        return this.isNextPlayableEpisode;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isPinProtected() {
        return this.isPinProtected;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isPreviewProtected() {
        return this.isPreviewProtected;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$isSupplementalVideo() {
        return this.isSupplementalVideo;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$logicalStart() {
        return this.logicalStart;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$maxAutoplay() {
        return this.maxAutoplay;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$parentId() {
        return this.parentId;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$parentTitle() {
        return this.parentTitle;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$playableId() {
        return this.playableId;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$seasonLabel() {
        return this.seasonLabel;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public int realmGet$seasonNumber() {
        return this.seasonNumber;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public boolean realmGet$supportsPrePlay() {
        return this.supportsPrePlay;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public String realmGet$title() {
        return this.title;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public long realmGet$watchedTime() {
        return this.watchedTime;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$advisoriesString(String str) {
        this.advisoriesString = str;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$bookmark(int i) {
        this.bookmark = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$duration(int i) {
        this.duration = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$endtime(int i) {
        this.endtime = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$episodeNumber(int i) {
        this.episodeNumber = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$episodeNumberHidden(boolean z) {
        this.episodeNumberHidden = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$expTime(long j) {
        this.expTime = j;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAdvisoryDisabled(boolean z) {
        this.isAdvisoryDisabled = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAgeProtected(boolean z) {
        this.isAgeProtected = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAutoPlay(boolean z) {
        this.isAutoPlay = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isAvailableToStream(boolean z) {
        this.isAvailableToStream = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isEpisode(boolean z) {
        this.isEpisode = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isNSRE(boolean z) {
        this.isNSRE = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isNextPlayableEpisode(boolean z) {
        this.isNextPlayableEpisode = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isPinProtected(boolean z) {
        this.isPinProtected = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isPreviewProtected(boolean z) {
        this.isPreviewProtected = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$isSupplementalVideo(boolean z) {
        this.isSupplementalVideo = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$logicalStart(int i) {
        this.logicalStart = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$maxAutoplay(int i) {
        this.maxAutoplay = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$parentId(String str) {
        this.parentId = str;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$parentTitle(String str) {
        this.parentTitle = str;
    }

    public void realmSet$playableId(String str) {
        this.playableId = str;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$seasonLabel(String str) {
        this.seasonLabel = str;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$seasonNumber(int i) {
        this.seasonNumber = i;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$supportsPrePlay(boolean z) {
        this.supportsPrePlay = z;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$title(String str) {
        this.title = str;
    }

    @Override // io.realm.RealmPlayableRealmProxyInterface
    public void realmSet$watchedTime(long j) {
        this.watchedTime = j;
    }

    public C2092qm() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public C2092qm(pF pFVar) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$playableId(pFVar.getPlayableId());
        realmSet$parentId(pFVar.getTopLevelId());
        realmSet$isNSRE(pFVar.isNSRE());
        realmSet$isEpisode(pFVar.isPlayableEpisode());
        realmSet$title(pFVar.getPlayableTitle());
        realmSet$parentTitle(pFVar.getParentTitle());
        realmSet$watchedTime(pFVar.getPlayableBookmarkUpdateTime());
        realmSet$bookmark(pFVar.getPlayableBookmarkPosition());
        realmSet$seasonNumber(pFVar.getSeasonNumber());
        realmSet$episodeNumber(pFVar.getEpisodeNumber());
        realmSet$duration(pFVar.getRuntime());
        realmSet$endtime(pFVar.getEndtime());
        realmSet$logicalStart(pFVar.getLogicalStart());
        realmSet$isAutoPlay(pFVar.isAutoPlayEnabled());
        realmSet$isNextPlayableEpisode(pFVar.isNextPlayableEpisode());
        realmSet$isAgeProtected(pFVar.isAgeProtected());
        realmSet$isPinProtected(pFVar.isPinProtected());
        realmSet$isPreviewProtected(pFVar.isPreviewProtected());
        realmSet$expTime(pFVar.getExpirationTime());
        realmSet$isAdvisoryDisabled(pFVar.isAdvisoryDisabled());
        realmSet$seasonLabel(pFVar.getSeasonAbbrSeqLabel());
        realmSet$maxAutoplay(pFVar.getAutoPlayMaxCount());
        realmSet$isAvailableToStream(pFVar.isAvailableToStream());
        realmSet$isSupplementalVideo(pFVar.isSupplementalVideo());
        if (pFVar.getAdvisories() != null) {
            realmSet$advisoriesString(new Gson().toJson(pFVar.getAdvisories()));
        }
        realmSet$supportsPrePlay(pFVar.supportsPrePlay());
        realmSet$episodeNumberHidden(pFVar.isEpisodeNumberHidden());
    }

    @Override // o.pF
    public boolean isAvailableOffline() {
        return true;
    }

    @Override // o.pF
    public String getPlayableId() {
        return realmGet$playableId();
    }

    @Override // o.pF
    public String getPlayableTitle() {
        return realmGet$title();
    }

    @Override // o.pF
    public boolean isPlayableEpisode() {
        return realmGet$isEpisode();
    }

    @Override // o.pF
    public long getPlayableBookmarkUpdateTime() {
        return realmGet$watchedTime();
    }

    @Override // o.pF
    public int getPlayableBookmarkPosition() {
        return realmGet$bookmark();
    }

    @Override // o.pF
    public String getParentTitle() {
        return realmGet$parentTitle();
    }

    @Override // o.pF
    public String getTopLevelId() {
        return realmGet$parentId();
    }

    @Override // o.pF
    public int getRuntime() {
        return realmGet$duration();
    }

    @Override // o.pF
    public int getEndtime() {
        return realmGet$endtime();
    }

    @Override // o.pF
    public int getLogicalStart() {
        return realmGet$logicalStart();
    }

    @Override // o.pF
    public int getEpisodeNumber() {
        return realmGet$episodeNumber();
    }

    @Override // o.pF, o.pS
    public int getSeasonNumber() {
        return realmGet$seasonNumber();
    }

    @Override // o.pF
    public boolean isAutoPlayEnabled() {
        return realmGet$isAutoPlay();
    }

    @Override // o.pF
    public int getAutoPlayMaxCount() {
        return realmGet$maxAutoplay();
    }

    @Override // o.pF
    public boolean isNextPlayableEpisode() {
        return realmGet$isNextPlayableEpisode();
    }

    @Override // o.pF
    public boolean isAgeProtected() {
        return realmGet$isAgeProtected();
    }

    @Override // o.pF
    public boolean isPinProtected() {
        return realmGet$isPinProtected();
    }

    @Override // o.pF
    public boolean isPreviewProtected() {
        return realmGet$isPreviewProtected();
    }

    @Override // o.pF
    public long getExpirationTime() {
        return realmGet$expTime();
    }

    @Override // o.pF
    public List<Advisory> getAdvisories() {
        if (C1349Bv.m4113(realmGet$advisoriesString())) {
            return null;
        }
        return Advisory.asList(new JsonParser().parse(realmGet$advisoriesString()).getAsJsonArray());
    }

    @Override // o.pF
    public boolean isAdvisoryDisabled() {
        return realmGet$isAdvisoryDisabled();
    }

    @Override // o.pF
    public String getSeasonAbbrSeqLabel() {
        return realmGet$seasonLabel();
    }

    @Override // o.pF
    public boolean isAvailableToStream() {
        return realmGet$isAvailableToStream();
    }

    @Override // o.pF
    public boolean isNSRE() {
        return realmGet$isNSRE();
    }

    @Override // o.pF
    public boolean isEpisodeNumberHidden() {
        return realmGet$episodeNumberHidden();
    }

    @Override // o.pF
    public boolean isSupplementalVideo() {
        return realmGet$isSupplementalVideo();
    }

    @Override // o.pF
    public boolean supportsPrePlay() {
        return realmGet$supportsPrePlay();
    }

    @Override // o.pF
    public CreditMarks getCreditMarks() {
        return null;
    }

    public String toString() {
        return "RealmPlayable{playableId='" + realmGet$playableId() + "', parentId='" + realmGet$parentId() + "', title='" + realmGet$title() + "', seasonLabel='" + realmGet$seasonLabel() + "', parentTitle='" + realmGet$parentTitle() + "', isEpisode=" + realmGet$isEpisode() + ", isNSRE=" + realmGet$isNSRE() + ", isAutoPlay=" + realmGet$isAutoPlay() + ", isNextPlayableEpisode=" + realmGet$isNextPlayableEpisode() + ", isAgeProtected=" + realmGet$isAgeProtected() + ", isPinProtected=" + realmGet$isPinProtected() + ", isPreviewProtected=" + realmGet$isPreviewProtected() + ", isAdvisoryDisabled=" + realmGet$isAdvisoryDisabled() + ", isAvailableToStream=" + realmGet$isAvailableToStream() + ", duration=" + realmGet$duration() + ", seasonNumber=" + realmGet$seasonNumber() + ", episodeNumber=" + realmGet$episodeNumber() + ", logicalStart=" + realmGet$logicalStart() + ", endtime=" + realmGet$endtime() + ", maxAutoplay=" + realmGet$maxAutoplay() + ", expTime=" + realmGet$expTime() + ", advisories=" + realmGet$advisoriesString() + ", watchedTime=" + realmGet$watchedTime() + ", bookmark=" + realmGet$bookmark() + ", supportsPrePlay=" + realmGet$supportsPrePlay() + ", episodeNumberHidden=" + realmGet$episodeNumberHidden() + '}';
    }
}
