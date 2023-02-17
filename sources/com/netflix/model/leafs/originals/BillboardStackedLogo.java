package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardStackedLogo extends AbstractBillboardAsset {
    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "StackedLogo";
    }

    public BillboardStackedLogo(JsonElement jsonElement) {
        super(jsonElement);
    }
}
