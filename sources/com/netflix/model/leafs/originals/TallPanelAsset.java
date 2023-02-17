package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import o.AK;
import o.AbstractC0851;
import o.AbstractC0852;
public class TallPanelAsset implements AbstractC0851, AbstractC0852 {
    private static final String TAG = "TallPanelAsset";
    private String url;

    public String getUrl() {
        return this.url;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case 116079:
                        if (key.equals("url")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.url = AK.m3375(value);
                        break;
                }
            }
        }
    }
}
