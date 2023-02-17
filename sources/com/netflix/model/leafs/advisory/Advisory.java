package com.netflix.model.leafs.advisory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import o.AbstractC0852;
public abstract class Advisory implements AbstractC0852 {
    private static final String TAG = "Advisory";
    public float displayDelay;
    public float displayDuration;
    public DisplayLocation timeLocation = DisplayLocation.START;

    public abstract JsonObject getData(JsonElement jsonElement);

    public abstract String getMessage();

    public abstract String getSecondaryMessage();

    public abstract Type getType();

    public static Advisory make(Type type, JsonObject jsonObject) {
        Advisory concreteInstance = getConcreteInstance(type);
        concreteInstance.populate(jsonObject);
        return concreteInstance;
    }

    public static Advisory getConcreteInstance(Type type) {
        switch (type) {
            case PRODUCT_PLACEMENT_ADVISORY:
                return new ProductPlacementAdvisory();
            case CONTENT_ADVISORY:
                return new ContentAdvisory();
            case EXPIRY_NOTICE:
                return new ExpiringContentAdvisory();
            default:
                throw new IllegalArgumentException("Advisory ... Unknown Type");
        }
    }

    public static ArrayList<Advisory> asList(JsonArray jsonArray) {
        ArrayList<Advisory> arrayList = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject asJsonObject = jsonArray.get(i).getAsJsonObject();
                Advisory make = make(Type.fromString(asJsonObject.get("type").getAsString()), asJsonObject);
                if (make != null) {
                    arrayList.add(make);
                }
            }
        }
        return arrayList;
    }

    public enum Type {
        EXPIRY_NOTICE,
        CONTENT_ADVISORY,
        PRODUCT_PLACEMENT_ADVISORY,
        UNKNOWN;

        public static Type fromString(String str) {
            try {
                return valueOf(str.toUpperCase(Locale.ENGLISH));
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public enum DisplayLocation {
        START,
        END,
        UNKNOWN;

        public static DisplayLocation fromString(String str) {
            try {
                return valueOf(str.toUpperCase());
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public float getDuration() {
        return this.displayDuration;
    }

    public float getDelay() {
        return this.displayDelay;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1416457340:
                    if (key.equals("displayTimeLocation")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3076010:
                    if (key.equals(Event.DATA)) {
                        c = 3;
                        break;
                    }
                    break;
                case 310064551:
                    if (key.equals("displayTimeGap")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1107814518:
                    if (key.equals("displayDuration")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.timeLocation = DisplayLocation.fromString(value.getAsString());
                    break;
                case 1:
                    this.displayDuration = value.getAsFloat();
                    break;
                case 2:
                    this.displayDelay = value.getAsFloat();
                    break;
                case 3:
                    getData(value);
                    break;
            }
        }
    }
}
