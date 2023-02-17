package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AK;
import o.AbstractC0852;
public class Delivery implements AbstractC0852 {
    private static final String TAG = "Delivery";
    private boolean has51Audio;
    private boolean hasHD;
    private boolean hasUltraHD;
    private String quality;

    public Delivery(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public String getQuality() {
        return this.quality;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case 99048726:
                    if (key.equals("hasHD")) {
                        c = 0;
                        break;
                    }
                    break;
                case 651215103:
                    if (key.equals("quality")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1627230912:
                    if (key.equals("has51Audio")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1698703790:
                    if (key.equals("hasUltraHD")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.hasHD = AK.m3384(value);
                    break;
                case 1:
                    this.hasUltraHD = AK.m3384(value);
                    break;
                case 2:
                    this.has51Audio = AK.m3384(value);
                    break;
                case 3:
                    this.quality = AK.m3375(value);
                    break;
            }
        }
    }
}
