package com.netflix.model.leafs.social;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import o.AbstractC0852;
public class IrisNotificationsListSummary implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<IrisNotificationsListSummary> CREATOR = new Parcelable.Creator<IrisNotificationsListSummary>() { // from class: com.netflix.model.leafs.social.IrisNotificationsListSummary.1
        @Override // android.os.Parcelable.Creator
        public IrisNotificationsListSummary createFromParcel(Parcel parcel) {
            return new IrisNotificationsListSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IrisNotificationsListSummary[] newArray(int i) {
            return new IrisNotificationsListSummary[i];
        }
    };
    private static final String TAG = "SocialNotificationsListSummary";
    @SerializedName("baseTrackId")
    private int baseTrackId;
    @SerializedName("length")
    private long length;
    @SerializedName("mdpTrackId")
    private int mdpTrackId;
    @SerializedName("playerTrackId")
    private int playerTrackId;
    @SerializedName("requestId")
    private String requestId;

    public long getLength() {
        return this.length;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getBaseTrackId() {
        return this.baseTrackId;
    }

    public int getMDPTrackId() {
        return this.mdpTrackId;
    }

    public int getPlayerTrackId() {
        return this.playerTrackId;
    }

    public IrisNotificationsListSummary() {
    }

    protected IrisNotificationsListSummary(Parcel parcel) {
        String[] strArr = new String[5];
        parcel.readStringArray(strArr);
        this.length = Long.valueOf(strArr[0]).longValue();
        this.requestId = strArr[1];
        this.baseTrackId = Integer.valueOf(strArr[2]).intValue();
        this.mdpTrackId = Integer.valueOf(strArr[3]).intValue();
        this.playerTrackId = Integer.valueOf(strArr[4]).intValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{String.valueOf(this.length), this.requestId, String.valueOf(this.baseTrackId), String.valueOf(this.mdpTrackId), String.valueOf(this.playerTrackId)});
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int) getLength();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IrisNotificationsListSummary)) {
            return false;
        }
        IrisNotificationsListSummary irisNotificationsListSummary = (IrisNotificationsListSummary) obj;
        return getLength() == irisNotificationsListSummary.getLength() && getBaseTrackId() == irisNotificationsListSummary.getBaseTrackId() && getMDPTrackId() == irisNotificationsListSummary.getMDPTrackId() && getPlayerTrackId() == irisNotificationsListSummary.getPlayerTrackId();
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -2078436403:
                    if (key.equals("mdpTrackId")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1106363674:
                    if (key.equals("length")) {
                        c = 0;
                        break;
                    }
                    break;
                case 693933066:
                    if (key.equals("requestId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1234061237:
                    if (key.equals("baseTrackId")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1585578405:
                    if (key.equals("playerTrackId")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.length = (long) value.getAsInt();
                    break;
                case 1:
                    this.requestId = value.getAsString();
                    break;
                case 2:
                    this.baseTrackId = value.getAsInt();
                    break;
                case 3:
                    this.mdpTrackId = value.getAsInt();
                    break;
                case 4:
                    this.playerTrackId = value.getAsInt();
                    break;
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return "FalkorSocialNotificationsListSummary [mLength=" + this.length + ", mRequestId=" + this.requestId + ", mBaseTrackId=" + this.baseTrackId + ", mMDPTrackId=" + this.mdpTrackId + ", mPlayerTrackId=" + this.playerTrackId + "]";
    }
}
