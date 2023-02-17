package com.netflix.mediaclient.ui.player;

import o.C0889;
import o.C2268wj;
import o.wK;
import o.wN;
public class PostPlayFactory {

    public enum PostPlayType {
        EpisodesForTablet,
        EpisodesForPhone,
        EpisodesForMDX,
        RecommendationForTablet,
        RecommendationForPhone,
        SignupForTablet,
        SignupForPhone
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static PostPlay m2595(IPlayerFragment iPlayerFragment) {
        if (iPlayerFragment.mo2255()) {
            return new C2268wj(iPlayerFragment);
        }
        if (C0889.m15606()) {
            return new wN(iPlayerFragment);
        }
        return new wK(iPlayerFragment);
    }
}
