package com.netflix.model.leafs.advisory;

import android.annotation.SuppressLint;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.model.leafs.advisory.Advisory;
import java.util.Map;
@SuppressLint({"ParcelCreator"})
public class ProductPlacementAdvisory extends Advisory {
    private static final String TAG = "ProductPlacementAdvisory";
    public String text;

    @Override // com.netflix.model.leafs.advisory.Advisory
    public Advisory.Type getType() {
        return Advisory.Type.PRODUCT_PLACEMENT_ADVISORY;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public String getMessage() {
        return this.text;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public String getSecondaryMessage() {
        return null;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public JsonObject getData(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case 3556653:
                    if (key.equals("text")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.text = value.getAsString();
                    break;
            }
        }
        return asJsonObject;
    }
}
