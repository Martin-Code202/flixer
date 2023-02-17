package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0852;
public class SceneSummary implements AbstractC0852 {
    private static final String TAG = "nf_scene";
    public int position;

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case 747804969:
                    if (key.equals("position")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.position = value.getAsInt();
                    break;
            }
        }
    }

    public String toString() {
        return "SceneSummary{position=" + this.position + '}';
    }
}
