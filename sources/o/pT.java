package o;
public interface pT extends pJ, pB, AbstractC2076py, AbstractC2073pv {
    String getActors();

    String getBifUrl();

    String getCatalogIdUrl();

    String getCertification();

    String getCopyright();

    String getDefaultTrailer();

    String getGenres();

    String getHighResolutionLandscapeBoxArtUrl();

    String getHighResolutionPortraitBoxArtUrl();

    int getMaturityLevel();

    pF getPlayable();

    String getQuality();

    String getStoryUrl();

    String getSupplementalMessage();

    String getSynopsis();

    String getTitleCroppedImgUrl();

    String getTitleImgUrl();

    String getTvCardUrl();

    int getYear();

    boolean hasTrailers();

    boolean hasWatched();

    boolean isAvailableToStream();

    boolean isEpisodeNumberHidden();

    boolean isInQueue();

    boolean isNSRE();

    @Override // o.pJ
    boolean isOriginal();

    boolean shouldRefreshVolatileData();
}
