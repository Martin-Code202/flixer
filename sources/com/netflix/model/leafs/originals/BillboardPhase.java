package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.originals.AutoValue_BillboardPhase;
import java.util.List;
public abstract class BillboardPhase {
    @SerializedName("actions")
    public abstract List<BillboardCTA> actions();

    @SerializedName("supplementalMessage")
    public abstract String supplementalMessage();

    public static TypeAdapter<BillboardPhase> typeAdapter(Gson gson) {
        return new AutoValue_BillboardPhase.GsonTypeAdapter(gson);
    }
}
