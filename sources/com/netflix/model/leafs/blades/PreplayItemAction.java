package com.netflix.model.leafs.blades;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.blades.AutoValue_PreplayItemAction;
public abstract class PreplayItemAction {
    @SerializedName("bookmarkPosition")
    public abstract int bookmarkPosition();

    @SerializedName("doNotIncrementInterrupter")
    public abstract boolean doNotIncrementInterrupter();

    @SerializedName("ignoreBookmark")
    public abstract boolean ignoreBookmark();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("trackId")
    public abstract int trackId();

    @SerializedName("type")
    public abstract String type();

    @SerializedName("videoId")
    public abstract String videoId();

    public static TypeAdapter<PreplayItemAction> typeAdapter(Gson gson) {
        return new AutoValue_PreplayItemAction.GsonTypeAdapter(gson);
    }
}
