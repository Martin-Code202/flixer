package com.netflix.model.leafs;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.netflix.model.leafs.blades.PrePlayItem;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import o.AbstractC0847;
import o.AbstractC0852;
import o.C1281;
import o.C1283;
public class PrePlayExperiences extends AbstractC0847 implements AbstractC0852 {
    private static final String TAG = "PrePlayExperiences";
    private static final Type preplayItemType = new TypeToken<List<PrePlayItem>>() { // from class: com.netflix.model.leafs.PrePlayExperiences.1
    }.getType();
    private boolean mAutoplay;
    private List<PrePlayItem> mItems;
    private String mPromotedVideoId;
    private String mType;
    private String mUiLabel;

    public String getPromotedVideoId() {
        return this.mPromotedVideoId;
    }

    public String getType() {
        return this.mType;
    }

    public boolean isAutoplay() {
        return this.mAutoplay;
    }

    public List<PrePlayItem> getExperiences() {
        return this.mItems;
    }

    public String getUiLabel() {
        return this.mUiLabel;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        if (jsonElement != null && jsonElement.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                if (entry.getKey().equals("experience") && value != null && value.isJsonObject()) {
                    for (Map.Entry<String, JsonElement> entry2 : value.getAsJsonObject().entrySet()) {
                        JsonElement value2 = entry2.getValue();
                        String key = entry2.getKey();
                        char c = 65535;
                        switch (key.hashCode()) {
                            case -457016128:
                                if (key.equals("uiLabel")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 3575610:
                                if (key.equals("type")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 100526016:
                                if (key.equals("items")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1439562083:
                                if (key.equals("autoplay")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1741756850:
                                if (key.equals("promotedVideoId")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                this.mPromotedVideoId = value2.getAsString();
                                break;
                            case 1:
                                this.mType = value2.getAsString();
                                break;
                            case 2:
                                this.mAutoplay = value2.getAsBoolean();
                                break;
                            case 3:
                                this.mItems = (List) ((Gson) C1281.m16832(Gson.class)).fromJson(value2.getAsJsonArray(), preplayItemType);
                                break;
                            case 4:
                                this.mUiLabel = value2.getAsString();
                                break;
                            default:
                                C1283.m16854(TAG, "skipping entry" + entry2.getKey());
                                break;
                        }
                    }
                }
            }
        }
    }
}
