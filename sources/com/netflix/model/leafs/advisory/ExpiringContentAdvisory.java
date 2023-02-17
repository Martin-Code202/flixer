package com.netflix.model.leafs.advisory;

import android.annotation.SuppressLint;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.model.leafs.advisory.Advisory;
import java.util.Locale;
import java.util.Map;
@SuppressLint({"ParcelCreator"})
public class ExpiringContentAdvisory extends Advisory {
    private static final String TAG = "ExpiryAdvisory";
    public ContentType contentType = ContentType.SEASON;
    public long expirationTime;
    public String localizedDate;
    public long videoId;
    public boolean willExpire;

    public enum ContentType {
        MOVIE,
        SERIES,
        SHOW,
        SEASON,
        UNKNOWN;

        public static ContentType fromString(String str) {
            try {
                return valueOf(str.toUpperCase(Locale.ENGLISH));
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public enum ContentAction {
        NEVER_SHOW_AGAIN,
        LOG_WHEN_SHOWN,
        UNKNOWN;

        public static ContentAction fromString(String str) {
            try {
                return valueOf(str.toUpperCase(Locale.ENGLISH));
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public String getMessage() {
        return "";
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public String getSecondaryMessage() {
        return null;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public Advisory.Type getType() {
        return Advisory.Type.EXPIRY_NOTICE;
    }

    @Override // com.netflix.model.leafs.advisory.Advisory
    public JsonObject getData(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -668327396:
                    if (key.equals("expirationTime")) {
                        c = 3;
                        break;
                    }
                    break;
                case -18680943:
                    if (key.equals("willExpire")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (key.equals("type")) {
                        c = 2;
                        break;
                    }
                    break;
                case 112202875:
                    if (key.equals("video")) {
                        c = 0;
                        break;
                    }
                    break;
                case 696250825:
                    if (key.equals("localizedDate")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.videoId = value.getAsLong();
                    break;
                case 1:
                    this.willExpire = value.getAsBoolean();
                    break;
                case 2:
                    this.contentType = ContentType.valueOf(value.getAsString().toUpperCase());
                    break;
                case 3:
                    this.expirationTime = value.getAsLong();
                    break;
                case 4:
                    this.localizedDate = value.getAsString();
                    break;
            }
        }
        return asJsonObject;
    }
}
