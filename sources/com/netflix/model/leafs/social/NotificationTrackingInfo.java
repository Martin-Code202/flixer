package com.netflix.model.leafs.social;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import o.AbstractC0574;
import o.C1276;
import org.json.JSONException;
import org.json.JSONObject;
public class NotificationTrackingInfo implements AbstractC0574, Parcelable {
    public static final Parcelable.Creator<NotificationTrackingInfo> CREATOR = new Parcelable.Creator<NotificationTrackingInfo>() { // from class: com.netflix.model.leafs.social.NotificationTrackingInfo.1
        @Override // android.os.Parcelable.Creator
        public NotificationTrackingInfo createFromParcel(Parcel parcel) {
            return new NotificationTrackingInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NotificationTrackingInfo[] newArray(int i) {
            return new NotificationTrackingInfo[i];
        }
    };
    private static final String TAG = "NotificationTrackingInfo";
    private JSONObject json;

    private NotificationTrackingInfo(Parcel parcel) {
        this.json = tryToCreateJson(parcel.readString());
    }

    private NotificationTrackingInfo(String str) {
        this.json = tryToCreateJson(str);
    }

    private JSONObject tryToCreateJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1276.m16820().mo5729(String.format(Locale.US, "%s: Couldn't initialize JSONObject from String: %s.", TAG, str), e);
            return new JSONObject();
        }
    }

    public static NotificationTrackingInfo get(String str) {
        return new NotificationTrackingInfo(str);
    }

    public String getTitleId() {
        try {
            return this.json.getString("titleId");
        } catch (JSONException e) {
            C1276.m16820().mo5729(String.format(Locale.US, "%s: Could not get titleId for %s", TAG, this.json.toString()), e);
            return null;
        }
    }

    public void addProperty(String str, String str2) {
        try {
            this.json.put(str, str2);
        } catch (JSONException e) {
            C1276.m16820().mo5729(String.format(Locale.US, "%s: Could not add key: %s and value %s for json %s", TAG, str, str2, this.json.toString()), e);
        }
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        return this.json;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.json.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.json.toString());
    }
}
