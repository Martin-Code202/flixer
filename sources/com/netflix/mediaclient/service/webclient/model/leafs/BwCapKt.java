package com.netflix.mediaclient.service.webclient.model.leafs;

import com.netflix.mediaclient.service.player.StreamProfileType;
import o.C1457Fr;
public final class BwCapKt {
    public static final BwCap getBwCapForProfile(StreamProfileType streamProfileType, StreamProfileData streamProfileData) {
        C1457Fr.m5025(streamProfileType, "profileType");
        C1457Fr.m5025(streamProfileData, "profileData");
        switch (streamProfileType) {
            case AL0:
                return streamProfileData.getAl0CellularCap();
            case AL1:
                return streamProfileData.getAl1CellularCap();
            case CE3:
                return streamProfileData.getCe3CellularCap();
            default:
                return streamProfileData.getCe3CellularCap();
        }
    }
}
