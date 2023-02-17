package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.social.NotificationTrackingInfo;
import java.util.Map;
import o.AbstractC0574;
import o.AbstractC0852;
public class NotificationGridTitleAction implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationGridTitleAction> CREATOR = new Parcelable.Creator<NotificationGridTitleAction>() { // from class: com.netflix.model.leafs.social.multititle.NotificationGridTitleAction.1
        @Override // android.os.Parcelable.Creator
        public NotificationGridTitleAction createFromParcel(Parcel parcel) {
            return new NotificationGridTitleAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationGridTitleAction[] newArray(int i) {
            return new NotificationGridTitleAction[i];
        }
    };
    private static final String TAG = "NotificationGridTitleAction";
    @SerializedName("action")
    private String action;
    @SerializedName("actionType")
    private String actionType;
    @SerializedName("boxshot")
    private String boxshot;
    @SerializedName("sdp")
    private String sdp;
    @SerializedName("trackingInfo")
    private AbstractC0574 trackingInfo;

    public NotificationGridTitleAction() {
    }

    public String getAction() {
        return this.action;
    }

    public String getBoxshot() {
        return this.boxshot;
    }

    public String getActionType() {
        return this.actionType;
    }

    public String getSdp() {
        return this.sdp;
    }

    public AbstractC0574 getTrackingInfo() {
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
                        c = 4;
                        break;
                    }
                    break;
                case -1422950858:
                    if (key.equals("action")) {
                        c = 0;
                        break;
                    }
                    break;
                case 113727:
                    if (key.equals("sdp")) {
                        c = 3;
                        break;
                    }
                    break;
                case 73235269:
                    if (key.equals("boxshot")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1851881104:
                    if (key.equals("actionType")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.action = value.getAsString();
                    break;
                case 1:
                    this.boxshot = value.getAsString();
                    break;
                case 2:
                    this.actionType = value.getAsString();
                    break;
                case 3:
                    this.sdp = value.getAsString();
                    break;
                case 4:
                    this.trackingInfo = NotificationTrackingInfo.get(value.toString());
                    break;
            }
        }
    }

    protected NotificationGridTitleAction(Parcel parcel) {
        this.action = parcel.readString();
        this.boxshot = parcel.readString();
        this.actionType = parcel.readString();
        this.sdp = parcel.readString();
        this.trackingInfo = NotificationTrackingInfo.get(parcel.readString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.action);
        parcel.writeString(this.boxshot);
        parcel.writeString(this.actionType);
        parcel.writeString(this.sdp);
        parcel.writeString(this.trackingInfo.toString());
    }
}
