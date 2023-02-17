package com.netflix.model.leafs.social.multititle;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.netflix.model.leafs.social.NotificationTrackingInfo;
import java.util.Map;
import o.AbstractC0574;
import o.AbstractC0852;
public class NotificationCtaButton implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<NotificationCtaButton> CREATOR = new Parcelable.Creator<NotificationCtaButton>() { // from class: com.netflix.model.leafs.social.multititle.NotificationCtaButton.1
        @Override // android.os.Parcelable.Creator
        public NotificationCtaButton createFromParcel(Parcel parcel) {
            return new NotificationCtaButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationCtaButton[] newArray(int i) {
            return new NotificationCtaButton[i];
        }
    };
    private static final String TAG = "NotificationCtaButton";
    @SerializedName("action")
    private String action;
    @SerializedName("buttonText")
    private CharSequence buttonText;
    @SerializedName("trackingInfo")
    private AbstractC0574 trackingInfo;

    public NotificationCtaButton() {
    }

    public String getAction() {
        return this.action;
    }

    public CharSequence getButtonText() {
        return this.buttonText;
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
                        c = 2;
                        break;
                    }
                    break;
                case -1422950858:
                    if (key.equals("action")) {
                        c = 0;
                        break;
                    }
                    break;
                case 358545279:
                    if (key.equals("buttonText")) {
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
                    this.buttonText = value.getAsString();
                    break;
                case 2:
                    this.trackingInfo = NotificationTrackingInfo.get(value.toString());
                    break;
            }
        }
    }

    public NotificationCtaButton(Parcel parcel) {
        this.action = parcel.readString();
        this.buttonText = parcel.readString();
        this.trackingInfo = NotificationTrackingInfo.get(parcel.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.action);
        parcel.writeString(this.buttonText.toString());
        parcel.writeString(this.trackingInfo.toString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
