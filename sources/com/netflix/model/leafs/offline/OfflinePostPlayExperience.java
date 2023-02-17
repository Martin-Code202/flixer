package com.netflix.model.leafs.offline;

import com.netflix.model.leafs.PostPlayExperience;
import o.pF;
public class OfflinePostPlayExperience extends PostPlayExperience {
    private static final int OFFLINE_POST_PLAY_AUTOPLAY_SECONDS = 10;
    private static final String OFFLINE_POST_PLAY_TYPE = "nextEpisode";

    public OfflinePostPlayExperience(pF pFVar, String str, boolean z) {
        setType(OFFLINE_POST_PLAY_TYPE);
        setAutoplay(z);
        setAutoplaySeconds(10);
        setSeamlessCountdownSeconds(10);
        setItemsInitialIndex(0);
        getItems().add(new OfflinePostPlayItem(pFVar, str));
    }
}
