package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0852;
import o.AbstractC2083qd;
import o.C1349Bv;
public class SearchSuggestion implements AbstractC2083qd, AbstractC0852 {
    private static final String TAG = "SearchSuggestion";
    private String entityId;
    private String title;

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -2102099874:
                    if (key.equals("entityId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 110371416:
                    if (key.equals("title")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.title = value.getAsString();
                    break;
                case 1:
                    this.entityId = value.getAsString();
                    break;
            }
        }
    }

    @Override // o.AbstractC2083qd
    public String getTitle() {
        return C1349Bv.m4129(this.title);
    }

    @Override // o.AbstractC2083qd
    public String getEntityId() {
        return this.entityId;
    }

    public String toString() {
        return "SearchSuggestion [title=" + this.title + "]";
    }
}
