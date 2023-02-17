package com.netflix.mediaclient.servicemgr;

import java.util.Random;
import o.AbstractC1615ci;
import o.AbstractC2041oq;
import o.AbstractC2049oy;
import o.AbstractC2063pl;
import o.C1359Ce;
import o.M;
import o.P;
import o.oQ;
public interface IClientLogging {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final long f2458 = new Random().nextLong();

    public enum CompletionReason {
        success,
        canceled,
        failed
    }

    public enum ModalView {
        appLoading,
        nmLanding,
        signupNative,
        signupPrompt,
        registration,
        emailConfirmation,
        login,
        privacyPolicy,
        offerDetails,
        payment,
        badPayment,
        legalTerms,
        orderConfirmation,
        profilesGate,
        jfkGate,
        homeScreen,
        bob,
        movieDetails,
        browseTitles,
        originalDetails,
        audioSubtitlesSelector,
        characterDetails,
        seasonsSelector,
        episodesSelector,
        search,
        searchResults,
        preQuery,
        prePlayback,
        playback,
        playbackControls,
        trickplay,
        postPlay,
        customerService,
        logout,
        errorDialog,
        upgradeStreamsPitch,
        upgradeStreamsPrompt,
        upgradeStreamsError,
        maxStreamsReached,
        mdxPlayback,
        openSourceLicenses,
        settings,
        profileDetails,
        titleResults,
        peopleResults,
        suggestionResults,
        peopleTitleResults,
        suggestionTitleResults,
        socialNotifications,
        externalLink,
        contactUs,
        menuPanel,
        notification,
        survey,
        optInDialog,
        eogPrompt,
        eogPlanSelector,
        ageVerificationDialog,
        ikoMode,
        ikoMoment,
        ikoNotification,
        memento,
        rdp,
        onramp,
        umsAlert,
        myListGallery,
        skipCreditsButton,
        skipPrePlayRecapButton,
        watchHistory,
        comingSoon,
        notificationLanding,
        offlineShows,
        addCachedVideoButton,
        removeCachedVideoButton,
        viewCachedVideosButton,
        cachedVideos,
        cachedEpisodes,
        pauseDownloadButton,
        resumeDownloadButton,
        retryDownloadButton,
        downloadProgress,
        videoNotAvailableToCacheWarning,
        videoNotEligibleToCacheWarning,
        noConnectivityWarning,
        myDownloads,
        planUpgradeGate,
        planUpgradeGateDownload,
        planUpgradeConfirmationPrompt,
        planUpgradeConfirmationPromptDownload,
        upgradingPlan,
        upgradingPlanDownload,
        subtitlesSelector,
        trickplayScrubberThumb,
        castDeviceSelector,
        audioSelector,
        myProfile,
        homeTab,
        searchTab,
        trailersTab,
        downloadsTab,
        moreTab,
        testPlaybackActivity
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    P mo1503();

    /* renamed from: ˊ  reason: contains not printable characters */
    AbstractC2041oq mo1504();

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean m1505(NetflixDataRequest netflixDataRequest);

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    M mo1506();

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo1507(C1359Ce ce);

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    long mo1508();

    /* renamed from: ˎ  reason: contains not printable characters */
    AbstractC2063pl mo1509();

    /* renamed from: ˎˏ  reason: contains not printable characters */
    void mo1510();

    /* renamed from: ˏˎ  reason: contains not printable characters */
    AdvertiserIdLogging mo1511();

    /* renamed from: ˏˏ  reason: contains not printable characters */
    oQ mo1512();

    /* renamed from: ˑ  reason: contains not printable characters */
    void mo1513();

    /* renamed from: ͺॱ  reason: contains not printable characters */
    void mo1514();

    /* renamed from: ॱ  reason: contains not printable characters */
    AbstractC2049oy mo1515();

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo1516(boolean z, Object obj);

    /* renamed from: ॱʻ  reason: contains not printable characters */
    String mo1517();

    /* renamed from: ॱʼ  reason: contains not printable characters */
    AbstractC1615ci mo1518();

    /* renamed from: ॱʽ  reason: contains not printable characters */
    String mo1519();

    /* renamed from: ॱͺ  reason: contains not printable characters */
    String mo1520();
}
