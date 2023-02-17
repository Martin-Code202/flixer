package com.netflix.mediaclient.servicemgr;
public enum UiLocation {
    HOME_LOLOMO("browseHome"),
    GENRE_LOLOMO("browseGenre"),
    MDP("mdp"),
    MDP_SIMILARS("mdpSimilars"),
    SDP("sdp"),
    SDP_SIMILARS("sdpSimilars"),
    SEARCH("search"),
    PEOPLE("people"),
    BROWSE("Browse"),
    UNKNOWN("");
    

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f2745;

    private UiLocation(String str) {
        this.f2745 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1563() {
        return this.f2745;
    }
}
