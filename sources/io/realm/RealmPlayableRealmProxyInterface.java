package io.realm;
public interface RealmPlayableRealmProxyInterface {
    String realmGet$advisoriesString();

    int realmGet$bookmark();

    int realmGet$duration();

    int realmGet$endtime();

    int realmGet$episodeNumber();

    boolean realmGet$episodeNumberHidden();

    long realmGet$expTime();

    boolean realmGet$isAdvisoryDisabled();

    boolean realmGet$isAgeProtected();

    boolean realmGet$isAutoPlay();

    boolean realmGet$isAvailableToStream();

    boolean realmGet$isEpisode();

    boolean realmGet$isNSRE();

    boolean realmGet$isNextPlayableEpisode();

    boolean realmGet$isPinProtected();

    boolean realmGet$isPreviewProtected();

    boolean realmGet$isSupplementalVideo();

    int realmGet$logicalStart();

    int realmGet$maxAutoplay();

    String realmGet$parentId();

    String realmGet$parentTitle();

    String realmGet$playableId();

    String realmGet$seasonLabel();

    int realmGet$seasonNumber();

    boolean realmGet$supportsPrePlay();

    String realmGet$title();

    long realmGet$watchedTime();

    void realmSet$advisoriesString(String str);

    void realmSet$bookmark(int i);

    void realmSet$duration(int i);

    void realmSet$endtime(int i);

    void realmSet$episodeNumber(int i);

    void realmSet$episodeNumberHidden(boolean z);

    void realmSet$expTime(long j);

    void realmSet$isAdvisoryDisabled(boolean z);

    void realmSet$isAgeProtected(boolean z);

    void realmSet$isAutoPlay(boolean z);

    void realmSet$isAvailableToStream(boolean z);

    void realmSet$isEpisode(boolean z);

    void realmSet$isNSRE(boolean z);

    void realmSet$isNextPlayableEpisode(boolean z);

    void realmSet$isPinProtected(boolean z);

    void realmSet$isPreviewProtected(boolean z);

    void realmSet$isSupplementalVideo(boolean z);

    void realmSet$logicalStart(int i);

    void realmSet$maxAutoplay(int i);

    void realmSet$parentId(String str);

    void realmSet$parentTitle(String str);

    void realmSet$seasonLabel(String str);

    void realmSet$seasonNumber(int i);

    void realmSet$supportsPrePlay(boolean z);

    void realmSet$title(String str);

    void realmSet$watchedTime(long j);
}
