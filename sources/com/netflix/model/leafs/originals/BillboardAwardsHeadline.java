package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardAwardsHeadline extends AbstractBillboardAsset {
    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "AwardsHeadline";
    }

    public BillboardAwardsHeadline(JsonElement jsonElement) {
        super(jsonElement);
    }
}
