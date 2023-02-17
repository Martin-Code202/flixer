package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import o.AbstractC0852;
import o.C1281;
public class NotificationLandingPage implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationLandingPage> CREATOR = new Parcelable.Creator<NotificationLandingPage>() { // from class: com.netflix.model.leafs.social.multititle.NotificationLandingPage.1
        @Override // android.os.Parcelable.Creator
        public NotificationLandingPage createFromParcel(Parcel parcel) {
            return new NotificationLandingPage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationLandingPage[] newArray(int i) {
            return new NotificationLandingPage[i];
        }
    };
    private static final String TAG = "NotificationLandingPage";
    @SerializedName("json")
    private JsonObject json;
    @SerializedName("payloadVersion")
    private String payloadVersion;
    @SerializedName("template")
    private NotificationTemplate template;
    @SerializedName("templateId")
    private String templateId;
    @SerializedName("templateType")
    private String templateType;
    @SerializedName("trackId")
    private int trackId;

    private static JsonObject convertStringToJsonObject(String str) {
        return ((JsonElement) ((Gson) C1281.m16832(Gson.class)).fromJson(str, (Class<Object>) JsonElement.class)).getAsJsonObject();
    }

    public NotificationLandingPage() {
    }

    public String getPayloadVersion() {
        return this.payloadVersion;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public NotificationTemplate getTemplate() {
        return this.template;
    }

    public void populate(String str) {
        populate(convertStringToJsonObject(str));
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        this.json = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : this.json.entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1321546630:
                    if (key.equals("template")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1067396154:
                    if (key.equals("trackId")) {
                        c = 4;
                        break;
                    }
                    break;
                case -975961388:
                    if (key.equals("templateType")) {
                        c = 2;
                        break;
                    }
                    break;
                case -905341078:
                    if (key.equals("payloadVersion")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1304010549:
                    if (key.equals("templateId")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.payloadVersion = value.getAsString();
                    break;
                case 1:
                    this.templateId = value.getAsString();
                    break;
                case 2:
                    this.templateType = value.getAsString();
                    break;
                case 3:
                    this.template = new NotificationTemplate();
                    this.template.populate(value);
                    break;
                case 4:
                    this.trackId = value.getAsInt();
                    break;
            }
        }
    }

    public String serializeToJsonString() {
        return this.json.toString();
    }

    public NotificationLandingPage(Parcel parcel) {
        this.payloadVersion = parcel.readString();
        this.templateId = parcel.readString();
        this.templateType = parcel.readString();
        this.template = (NotificationTemplate) parcel.readParcelable(NotificationTemplate.class.getClassLoader());
        this.trackId = parcel.readInt();
        this.json = convertStringToJsonObject(parcel.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.payloadVersion);
        parcel.writeString(this.templateId);
        parcel.writeString(this.templateType);
        parcel.writeParcelable(this.template, 0);
        parcel.writeInt(this.trackId);
        parcel.writeString(this.json.toString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
