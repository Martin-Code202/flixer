package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardOriginalsLogo extends AbstractBillboardAsset {
    public BillboardOriginalsLogo(JsonElement jsonElement) {
        super(jsonElement);
    }

    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "OriginalsLogo";
    }
}
