package com.netflix.mediaclient.service.webclient.model.leafs;

import o.AbstractC2087qh;
public class TrackableObject implements AbstractC2087qh {
    private final int listPos;
    private final String reqId;
    private final int trackId;

    public TrackableObject(String str, int i, int i2) {
        this.reqId = str;
        this.trackId = i;
        this.listPos = i2;
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        return this.trackId;
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        return this.listPos;
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        return this.reqId;
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        return 0;
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        return null;
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return false;
    }
}
