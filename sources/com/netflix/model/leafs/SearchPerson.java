package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0852;
import o.AbstractC2081qb;
public class SearchPerson implements AbstractC2081qb, AbstractC0852 {
    private static final String TAG = "Person";
    private String entityId;
    private String id;
    private String imgUrl;
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
                case -1185088852:
                    if (key.equals("imgUrl")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 110371416:
                    if (key.equals("title")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = value.getAsString();
                    break;
                case 1:
                    this.entityId = value.getAsString();
                    break;
                case 2:
                    this.title = value.getAsString();
                    break;
                case 3:
                    this.imgUrl = value.getAsString();
                    break;
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getName() {
        return this.title;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String toString() {
        return "SearchPerson [id=" + this.id + ", title=" + this.title + ", imgUrl=" + this.imgUrl + "]";
    }
}
