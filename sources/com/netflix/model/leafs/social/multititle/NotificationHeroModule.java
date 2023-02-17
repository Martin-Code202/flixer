package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AbstractC0852;
public class NotificationHeroModule extends NotificationModule implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationHeroModule> CREATOR = new Parcelable.Creator<NotificationHeroModule>() { // from class: com.netflix.model.leafs.social.multititle.NotificationHeroModule.1
        @Override // android.os.Parcelable.Creator
        public NotificationHeroModule createFromParcel(Parcel parcel) {
            return new NotificationHeroModule(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationHeroModule[] newArray(int i) {
            return new NotificationHeroModule[i];
        }
    };
    private static final String TAG = "NotificationHeroModule";
    @SerializedName("actions")
    private List<NotificationHeroTitleAction> actions = new ArrayList();
    @SerializedName("bodyCopy")
    private String bodyCopy;
    @SerializedName("heroImage")
    private String heroImage;
    @SerializedName("titleId")
    private int titleId;
    @SerializedName("videoType")
    private VideoType videoType;

    public NotificationHeroModule() {
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -2016684671:
                    if (key.equals("heroImage")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1307249261:
                    if (key.equals("titleId")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1161803523:
                    if (key.equals("actions")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1332961877:
                    if (key.equals("videoType")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1702149175:
                    if (key.equals("bodyCopy")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.bodyCopy = value.getAsString();
                    break;
                case 1:
                    this.heroImage = value.getAsString();
                    break;
                case 2:
                    this.titleId = value.getAsInt();
                    break;
                case 3:
                    this.videoType = VideoType.create(value.getAsString().concat("s"));
                    break;
                case 4:
                    populateActions(value.getAsJsonArray());
                    break;
            }
        }
    }

    public String getBodyCopy() {
        return this.bodyCopy;
    }

    public String getHeroImage() {
        return this.heroImage;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public VideoType getVideoType() {
        return this.videoType;
    }

    public List<NotificationHeroTitleAction> getActions() {
        return this.actions;
    }

    private void populateActions(JsonArray jsonArray) {
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            NotificationHeroTitleAction notificationHeroTitleAction = new NotificationHeroTitleAction();
            notificationHeroTitleAction.populate(it.next());
            this.actions.add(notificationHeroTitleAction);
        }
    }

    protected NotificationHeroModule(Parcel parcel) {
        this.bodyCopy = parcel.readString();
        this.heroImage = parcel.readString();
        this.titleId = parcel.readInt();
        this.videoType = VideoType.create(parcel.readInt());
        parcel.readList(this.actions, NotificationHeroTitleAction.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bodyCopy);
        parcel.writeString(this.heroImage);
        parcel.writeInt(this.titleId);
        parcel.writeInt(this.videoType.getKey());
        parcel.writeList(this.actions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
