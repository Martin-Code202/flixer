package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
public class BillboardDateBadge extends AbstractBillboardAsset {
    @Override // com.netflix.model.leafs.originals.AbstractBillboardAsset
    public String getTag() {
        return "DateBadge";
    }

    public BillboardDateBadge(JsonElement jsonElement) {
        super(jsonElement);
    }
}
