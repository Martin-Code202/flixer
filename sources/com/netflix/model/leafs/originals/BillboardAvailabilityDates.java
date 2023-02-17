package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.originals.AutoValue_BillboardAvailabilityDates;
public abstract class BillboardAvailabilityDates {
    @SerializedName("start")
    public abstract Long start();

    public static TypeAdapter<BillboardAvailabilityDates> typeAdapter(Gson gson) {
        return new AutoValue_BillboardAvailabilityDates.GsonTypeAdapter(gson);
    }
}
