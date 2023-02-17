package com.netflix.model.leafs.offline;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.PostPlayAction;
import o.pF;
import o.pN;
public class OfflinePostPlayAction extends PostPlayAction {
    private final OfflinePostPlayVideo offlinePostPlayVideo;

    OfflinePostPlayAction(pF pFVar) {
        setType(PostPlayAction.CallToActionType.play);
        setVideoType(VideoType.EPISODE);
        setVideoId(Integer.parseInt(pFVar.getPlayableId()));
        setSeasonSequenceAbbr(pFVar.getSeasonAbbrSeqLabel());
        setEpisode(pFVar.getEpisodeNumber());
        this.offlinePostPlayVideo = new OfflinePostPlayVideo(pFVar);
    }

    @Override // com.netflix.model.leafs.PostPlayAction
    public pN getPlayBackVideo() {
        return this.offlinePostPlayVideo;
    }
}
