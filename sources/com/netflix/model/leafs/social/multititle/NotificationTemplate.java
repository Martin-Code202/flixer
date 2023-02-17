package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AbstractC0852;
public class NotificationTemplate implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationTemplate> CREATOR = new Parcelable.Creator<NotificationTemplate>() { // from class: com.netflix.model.leafs.social.multititle.NotificationTemplate.1
        @Override // android.os.Parcelable.Creator
        public NotificationTemplate createFromParcel(Parcel parcel) {
            return new NotificationTemplate(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationTemplate[] newArray(int i) {
            return new NotificationTemplate[i];
        }
    };
    private static final String TAG = "NotificationTemplate";
    @SerializedName("bodyText")
    private String bodyText;
    @SerializedName("ctaButton")
    private NotificationCtaButton ctaButton;
    @SerializedName("headlineText")
    private String headlineText;
    @SerializedName("modules")
    private List<NotificationModule> modules;

    protected NotificationTemplate() {
    }

    public String getHeadlineText() {
        return this.headlineText;
    }

    public String getBodyText() {
        return this.bodyText;
    }

    public NotificationCtaButton getCtaButton() {
        return this.ctaButton;
    }

    public List<NotificationModule> getModules() {
        return this.modules;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1613873887:
                    if (key.equals("headlineText")) {
                        c = 0;
                        break;
                    }
                    break;
                case -352138910:
                    if (key.equals("ctaButton")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1227433863:
                    if (key.equals("modules")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1702646255:
                    if (key.equals("bodyText")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.headlineText = value.getAsString();
                    break;
                case 1:
                    this.bodyText = value.getAsString();
                    break;
                case 2:
                    this.ctaButton = new NotificationCtaButton();
                    this.ctaButton.populate(value);
                    break;
                case 3:
                    this.modules = populateModuleList(value.getAsJsonArray());
                    break;
            }
        }
    }

    private List<NotificationModule> populateModuleList(JsonArray jsonArray) {
        this.modules = new ArrayList();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            JsonObject asJsonObject = next.getAsJsonObject();
            if (asJsonObject.has("layout")) {
                this.modules.add(populateAndGetModule(asJsonObject.getAsJsonPrimitive("layout").getAsString(), next));
            }
        }
        return this.modules;
    }

    private NotificationModule populateAndGetModule(String str, JsonElement jsonElement) {
        if (str.equalsIgnoreCase("hero_with_action_buttons")) {
            NotificationHeroModule notificationHeroModule = new NotificationHeroModule();
            notificationHeroModule.populate(jsonElement);
            return notificationHeroModule;
        }
        NotificationGridModule notificationGridModule = new NotificationGridModule();
        notificationGridModule.populate(jsonElement);
        return notificationGridModule;
    }

    protected NotificationTemplate(Parcel parcel) {
        this.headlineText = parcel.readString();
        this.bodyText = parcel.readString();
        this.ctaButton = (NotificationCtaButton) parcel.readParcelable(NotificationCtaButton.class.getClassLoader());
        this.modules = new ArrayList();
        parcel.readList(this.modules, NotificationModule.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.headlineText);
        parcel.writeString(this.bodyText);
        parcel.writeParcelable(this.ctaButton, 0);
        parcel.writeList(this.modules);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
