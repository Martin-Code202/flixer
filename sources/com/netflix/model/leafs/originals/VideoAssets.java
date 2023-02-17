package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.originals.AutoValue_VideoAssets;
public abstract class VideoAssets {
    @SerializedName("horizontalBackground")
    public abstract BillboardVideo horizontalBackground();

    public static TypeAdapter<VideoAssets> typeAdapter(Gson gson) {
        return new AutoValue_VideoAssets.GsonTypeAdapter(gson);
    }
}
