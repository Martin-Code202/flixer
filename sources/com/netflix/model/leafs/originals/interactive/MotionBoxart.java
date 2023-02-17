package com.netflix.model.leafs.originals.interactive;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.originals.interactive.AutoValue_MotionBoxart;
public abstract class MotionBoxart {
    @SerializedName("overlayUrl")
    public abstract String overlayUrl();

    @SerializedName("url")
    public abstract String url();

    public static TypeAdapter<MotionBoxart> typeAdapter(Gson gson) {
        return new AutoValue_MotionBoxart.GsonTypeAdapter(gson);
    }
}
