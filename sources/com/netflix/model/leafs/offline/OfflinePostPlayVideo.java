package com.netflix.model.leafs.offline;

import o.CH;
import o.pF;
public class OfflinePostPlayVideo extends CH {
    private final pF mPlayable;

    public OfflinePostPlayVideo(pF pFVar) {
        super(null);
        this.mPlayable = pFVar;
    }

    @Override // o.CH, o.pT
    public pF getPlayable() {
        return this.mPlayable;
    }
}
