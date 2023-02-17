package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.netflix.model.leafs.originals.Tone;
import java.util.Map;
import o.AK;
import o.AbstractC0852;
public class PostPlayAsset implements AbstractC0852 {
    private static final String TAG = "PostPlayAsset";
    private String assetType;
    private int height;
    private boolean isBadged;
    private String tone;
    private Type type;
    private String url;
    private int width;

    public enum Type {
        BACKGROUND,
        LOGO,
        DISPLAY_ART
    }

    public PostPlayAsset(Type type2) {
        this(type2, null);
    }

    public PostPlayAsset(Type type2, JsonElement jsonElement) {
        this.width = 0;
        this.height = 0;
        this.isBadged = false;
        this.type = type2;
        if (jsonElement != null) {
            populate(jsonElement);
        }
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            if (!(value instanceof JsonNull)) {
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1221029593:
                        if (key.equals("height")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -722613525:
                        if (key.equals("isBadged")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 116079:
                        if (key.equals("url")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3565938:
                        if (key.equals("tone")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 113126854:
                        if (key.equals("width")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1315305034:
                        if (key.equals("assetType")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.url = value.getAsString();
                        continue;
                    case 1:
                        this.assetType = value.getAsString();
                        continue;
                    case 2:
                        this.width = value.getAsInt();
                        continue;
                    case 3:
                        this.height = value.getAsInt();
                        continue;
                    case 4:
                        this.isBadged = value.getAsBoolean();
                        continue;
                    case 5:
                        this.tone = Tone.DARK.equals(AK.m3375(value)) ? Tone.DARK : Tone.LIGHT;
                        continue;
                }
            }
        }
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type2) {
        this.type = type2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getAssetType() {
        return this.assetType;
    }

    public void setAssetType(String str) {
        this.assetType = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isBadged() {
        return this.isBadged;
    }

    public void setBadged(boolean z) {
        this.isBadged = z;
    }

    public String getTone() {
        return this.tone;
    }

    public void setTone(String str) {
        this.tone = str;
    }
}
