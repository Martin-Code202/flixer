package com.netflix.model.leafs.originals;
public class BigRowSummary extends BillboardSummary {
    public BillboardVideo getVideo() {
        if (getVideoAssets() != null) {
            return getVideoAssets().horizontalBackground();
        }
        return null;
    }
}
