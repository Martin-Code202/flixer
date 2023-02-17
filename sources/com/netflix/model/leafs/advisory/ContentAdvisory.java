package com.netflix.model.leafs.advisory;

import android.annotation.SuppressLint;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.model.leafs.advisory.Advisory;
import java.util.ArrayList;
import java.util.Map;
import o.AK;
@SuppressLint({"ParcelCreator"})
public class ContentAdvisory extends Advisory {
    private static final String TAG = "ContentAdvisory";
    public ArrayList<String> advisories = new ArrayList<>();
    public String i18nAdvisories;
    public String i18nRating;
    public String rating;

    @Override // com.netflix.model.leafs.advisory.Advisory
    public String getMessage() {
        return this.i18nRating;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public String getSecondaryMessage() {
        return this.i18nAdvisories;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public Advisory.Type getType() {
        return Advisory.Type.CONTENT_ADVISORY;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public JsonObject getData(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1729984165:
                    if (key.equals("i18nRating")) {
                        c = 2;
                        break;
                    }
                    break;
                case -938102371:
                    if (key.equals("rating")) {
                        c = 0;
                        break;
                    }
                    break;
                case -648601833:
                    if (key.equals("advisories")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1146480597:
                    if (key.equals("i18nAdvisories")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.rating = value.getAsString();
                    break;
                case 1:
                    this.advisories = new ArrayList<>(AK.m3382(value.getAsJsonArray()));
                    break;
                case 2:
                    this.i18nRating = value.getAsString();
                    break;
                case 3:
                    this.i18nAdvisories = value.getAsString();
                    break;
            }
        }
        return asJsonObject;
    }
}
