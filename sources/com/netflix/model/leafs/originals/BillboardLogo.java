package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardLogo extends AbstractBillboardAsset {
    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "Logo";
    }

    public BillboardLogo(JsonElement jsonElement) {
        super(jsonElement);
    }
}
