package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardBackgroundPortrait extends AbstractBillboardAsset {
    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "Background";
    }

    public BillboardBackgroundPortrait(JsonElement jsonElement) {
        super(jsonElement);
    }
}
