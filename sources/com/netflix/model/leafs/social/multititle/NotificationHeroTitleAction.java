package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.social.NotificationTrackingInfo;
import java.util.Map;
import o.AbstractC0852;
public class NotificationHeroTitleAction implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationHeroTitleAction> CREATOR = new Parcelable.Creator<NotificationHeroTitleAction>() { // from class: com.netflix.model.leafs.social.multititle.NotificationHeroTitleAction.1
        @Override // android.os.Parcelable.Creator
        public NotificationHeroTitleAction createFromParcel(Parcel parcel) {
            return new NotificationHeroTitleAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationHeroTitleAction[] newArray(int i) {
            return new NotificationHeroTitleAction[i];
        }
    };
    private static final String TAG = "NotificationHeroTitleAction";
    @SerializedName("action")
    private String action;
    @SerializedName("actionType")
    private String actionType;
    @SerializedName("trackingInfo")
    private NotificationTrackingInfo trackingInfo;
    @SerializedName("videoType")
    private VideoType videoType;

    public NotificationHeroTitleAction() {
    }

    public String getAction() {
        return this.action;
    }

    public String getActionType() {
        return this.actionType;
    }

    public VideoType getVideoType() {
        return this.videoType;
    }

    public NotificationTrackingInfo getTrackingInfo() {
        return this.trackingInfo;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1884240891:
                    if (key.equals("trackingInfo")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1422950858:
                    if (key.equals("action")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1332961877:
                    if (key.equals("videoType")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1851881104:
                    if (key.equals("actionType")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.action = value.getAsString();
                    break;
                case 1:
                    this.actionType = value.getAsString();
                    break;
                case 2:
                    this.videoType = VideoType.create(value.getAsString().concat("s"));
                    break;
                case 3:
                    this.trackingInfo = NotificationTrackingInfo.get(value.toString());
                    break;
            }
        }
    }

    protected NotificationHeroTitleAction(Parcel parcel) {
        this.action = parcel.readString();
        this.actionType = parcel.readString();
        this.videoType = VideoType.create(parcel.readInt());
        this.trackingInfo = NotificationTrackingInfo.get(parcel.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.action);
        parcel.writeString(this.actionType);
        parcel.writeInt(this.videoType.getKey());
        parcel.writeString(this.trackingInfo.toString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
