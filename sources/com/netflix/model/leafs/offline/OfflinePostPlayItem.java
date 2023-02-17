package com.netflix.model.leafs.offline;

import com.netflix.model.leafs.PostPlayItem;
import o.pF;
class OfflinePostPlayItem extends PostPlayItem {
    OfflinePostPlayItem(pF pFVar, String str) {
        setVideoId(Integer.valueOf(Integer.parseInt(pFVar.getPlayableId())));
        getActions().add(new OfflinePostPlayAction(pFVar));
        setType(PostPlayItem.POST_PLAY_ITEM_EPISODE);
        setAncestorTitle(pFVar.getParentTitle());
        setTitle(pFVar.getPlayableTitle());
        setDisplayArtAsset(new OfflinePostPlayAsset(str));
    }
}
