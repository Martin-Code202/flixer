package com.netflix.model.leafs.offline;

import com.netflix.model.leafs.PostPlayAsset;
class OfflinePostPlayAsset extends PostPlayAsset {
    OfflinePostPlayAsset(String str) {
        super(PostPlayAsset.Type.DISPLAY_ART);
        setUrl(str);
    }
}
