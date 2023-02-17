package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import java.util.Map;
import o.AbstractC0851;
import o.AbstractC0852;
public class PostPlayImpression implements AbstractC0852, AbstractC0851 {
    private String TAG = "PostPlayImpression";
    boolean success;

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            if (!(value instanceof JsonNull)) {
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1867169789:
                        if (key.equals(FalkorPathResult.SUCCESS)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.success = value.getAsBoolean();
                        continue;
                }
            }
        }
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
