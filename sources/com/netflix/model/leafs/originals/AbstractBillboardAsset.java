package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import o.AK;
import o.AbstractC0851;
import o.AbstractC0852;
import o.C1349Bv;
public abstract class AbstractBillboardAsset implements AbstractC0852, AbstractC0851 {
    private final String TAG = getTag();
    private String artWorkType;
    private Integer height;
    private String tone;
    private String url;
    private Integer width;

    public abstract String getTag();

    public AbstractBillboardAsset(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public String getUrl() {
        return this.url;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String getTone() {
        return this.tone;
    }

    public String getArtWorkType() {
        return this.artWorkType;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1221029593:
                        if (key.equals("height")) {
                            c = 2;
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
                            c = 3;
                            break;
                        }
                        break;
                    case 113126854:
                        if (key.equals("width")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1749853550:
                        if (key.equals("artWorkType")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.url = AK.m3375(value);
                        break;
                    case 1:
                        this.width = Integer.valueOf(AK.m3379(value));
                        break;
                    case 2:
                        this.height = Integer.valueOf(AK.m3379(value));
                        break;
                    case 3:
                        this.tone = C1349Bv.m4126(AK.m3375(value), Tone.LIGHT) ? Tone.LIGHT : Tone.DARK;
                        break;
                    case 4:
                        this.artWorkType = AK.m3375(value);
                        break;
                }
            }
        }
    }
}
