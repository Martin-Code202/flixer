package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.Map;
import o.AbstractC0852;
import o.AbstractC2083qd;
public class SearchCollectionEntity implements AbstractC0852, AbstractC2083qd {
    private static final String TAG = "SearchCollectionEntity";
    private String displayString;
    private String entityId;
    private String entityType;
    private String id;
    private String imgUrl;
    private String referenceId;
    private int trackId;
    private String videoType;

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -2102099874:
                    if (key.equals("entityId")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1809429645:
                    if (key.equals("displayString")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1482998339:
                    if (key.equals("entityType")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1185088852:
                    if (key.equals("imgUrl")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1067396154:
                    if (key.equals("trackId")) {
                        c = 3;
                        break;
                    }
                    break;
                case -16211514:
                    if (key.equals("referenceId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1153650071:
                    if (key.equals("boxartUrl")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1332961877:
                    if (key.equals("videoType")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = value.getAsString();
                    break;
                case 1:
                    this.referenceId = value.getAsString();
                    break;
                case 2:
                    this.entityId = value.getAsString();
                    break;
                case 3:
                    this.trackId = value.getAsInt();
                    break;
                case 4:
                    this.videoType = value.getAsString();
                    break;
                case 5:
                    this.entityType = value.getAsString();
                    break;
                case 6:
                    this.displayString = value.getAsString();
                    break;
                case 7:
                case '\b':
                    this.imgUrl = value.getAsString();
                    break;
            }
        }
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public String getId() {
        return this.id;
    }

    @Override // o.AbstractC2083qd
    public String getTitle() {
        return this.displayString;
    }

    public VideoType getType() {
        return VideoType.create(this.videoType);
    }

    public String getEntityType() {
        return this.entityType;
    }

    public String getVideoType() {
        return this.videoType;
    }

    @Override // o.AbstractC2083qd
    public String getEntityId() {
        return this.entityId;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public String getDisplayString() {
        return this.displayString;
    }

    public String toString() {
        return "SearchCollectionEntity [id=" + this.id + ", entityId=" + this.entityId + ", displayString=" + this.displayString + "]";
    }

    public String getImageUrl() {
        return this.imgUrl;
    }
}
