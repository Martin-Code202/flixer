package com.netflix.model.leafs.blades;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.blades.AutoValue_PrePlayItem;
import java.util.List;
public abstract class PrePlayItem {
    @SerializedName("actions")
    public abstract List<PreplayItemAction> actions();

    @SerializedName("impressionData")
    public abstract String impressionData();

    @SerializedName("supplementalMessage")
    public abstract String supplementalMessage();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("type")
    public abstract String type();

    public static TypeAdapter<PrePlayItem> typeAdapter(Gson gson) {
        return new AutoValue_PrePlayItem.GsonTypeAdapter(gson);
    }
}
