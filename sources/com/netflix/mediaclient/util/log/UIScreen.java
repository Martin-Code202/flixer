package com.netflix.mediaclient.util.log;

import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.servicemgr.IClientLogging;
public enum UIScreen {
    transientUI(null, null),
    homeScreen(AppView.browseTitles, IClientLogging.ModalView.homeScreen),
    login(AppView.login, IClientLogging.ModalView.login),
    logout(AppView.logout, IClientLogging.ModalView.logout),
    appLoading(AppView.appLoading, IClientLogging.ModalView.appLoading),
    playbackControls(AppView.playbackControls, IClientLogging.ModalView.playbackControls),
    search(AppView.search, IClientLogging.ModalView.search),
    profilesGate(AppView.profilesGate, IClientLogging.ModalView.profilesGate),
    survey(AppView.survey, IClientLogging.ModalView.survey),
    playback(AppView.playback, IClientLogging.ModalView.playback),
    profileDetails(AppView.editProfile, IClientLogging.ModalView.profileDetails),
    watchHistory(AppView.viewingActivity, IClientLogging.ModalView.watchHistory),
    movieDetails(AppView.movieDetails, IClientLogging.ModalView.movieDetails),
    nmLanding(AppView.nmLanding, IClientLogging.ModalView.nmLanding),
    settings(AppView.settings, IClientLogging.ModalView.settings),
    onramp(AppView.onramp, IClientLogging.ModalView.onramp),
    characterDetails(AppView.characterDetails, IClientLogging.ModalView.characterDetails),
    contactUs(AppView.contactUs, IClientLogging.ModalView.contactUs),
    customerService(AppView.customerService, IClientLogging.ModalView.customerService),
    eogPrompt(AppView.eogPrompt, IClientLogging.ModalView.eogPrompt),
    externalLink(AppView.externalLink, IClientLogging.ModalView.externalLink),
    myListGallery(AppView.myListGallery, IClientLogging.ModalView.myListGallery),
    openSourceLicenses(AppView.openSourceLicenses, IClientLogging.ModalView.openSourceLicenses),
    searchResults(AppView.searchResults, IClientLogging.ModalView.searchResults),
    myProfile(AppView.profileTabActivity, IClientLogging.ModalView.myProfile),
    signupPrompt(AppView.signupPrompt, IClientLogging.ModalView.signupPrompt),
    socialNotifications(AppView.socialNotifications, IClientLogging.ModalView.socialNotifications),
    offlineShows(AppView.cachedVideos, IClientLogging.ModalView.offlineShows),
    notificationLanding(AppView.notificationLanding, IClientLogging.ModalView.notificationLanding),
    preQuery(AppView.preQuery, IClientLogging.ModalView.preQuery),
    suggestionTitleResults(AppView.suggestionTitleResults, IClientLogging.ModalView.suggestionTitleResults),
    optInDialog(AppView.optInDialog, IClientLogging.ModalView.optInDialog),
    trailersFeed(AppView.previews, IClientLogging.ModalView.trailersTab),
    previews(AppView.previews, IClientLogging.ModalView.browseTitles),
    browseTitles(AppView.browseTitlesGallery, IClientLogging.ModalView.browseTitles),
    testPlayback(AppView.testPlaybackActivity, IClientLogging.ModalView.testPlaybackActivity);
    

    /* renamed from: ˏˎ  reason: contains not printable characters */
    public final AppView f4083;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public final IClientLogging.ModalView f4084;

    private UIScreen(AppView appView, IClientLogging.ModalView modalView) {
        this.f4083 = appView;
        this.f4084 = modalView;
    }
}
