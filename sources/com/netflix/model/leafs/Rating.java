package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AK;
import o.AbstractC0847;
import o.AbstractC0852;
public class Rating extends AbstractC0847 implements AbstractC0852 {
    private static final String TAG = "Rating";
    private float average;
    private float predicted;

    public Rating(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public float getAverage() {
        return this.average;
    }

    public float getPredicted() {
        return this.predicted;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1348014280:
                    if (key.equals("predicted")) {
                        c = 1;
                        break;
                    }
                    break;
                case -631448035:
                    if (key.equals("average")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.average = AK.m3385(value);
                    break;
                case 1:
                    this.predicted = AK.m3385(value);
                    break;
            }
        }
    }
}
