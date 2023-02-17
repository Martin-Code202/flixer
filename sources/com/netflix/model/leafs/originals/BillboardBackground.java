package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardBackground extends AbstractBillboardAsset {
    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "Background";
    }

    public BillboardBackground(JsonElement jsonElement) {
        super(jsonElement);
    }
}
