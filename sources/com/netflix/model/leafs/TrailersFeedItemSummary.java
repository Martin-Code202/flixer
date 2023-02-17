package com.netflix.model.leafs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0852;
public class TrailersFeedItemSummary extends TrackableListSummary implements AbstractC0852 {
    public static final Parcelable.Creator<TrailersFeedItemSummary> CREATOR = new Parcelable.Creator<TrailersFeedItemSummary>() { // from class: com.netflix.model.leafs.TrailersFeedItemSummary.1
        @Override // android.os.Parcelable.Creator
        public TrailersFeedItemSummary createFromParcel(Parcel parcel) {
            return new TrailersFeedItemSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrailersFeedItemSummary[] newArray(int i) {
            return new TrailersFeedItemSummary[i];
        }
    };
    private static final String TAG = "TrailersFeedItemSummary";
    private String displayName;
    private String id;

    public TrailersFeedItemSummary() {
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary, o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        super.populate(jsonElement);
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = value.getAsString();
                    break;
            }
        }
    }

    public TrailersFeedItemSummary(Parcel parcel) {
        super(parcel);
        this.id = parcel.readString();
        this.displayName = parcel.readString();
    }

    public String getId() {
        return this.id;
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.displayName);
    }

    @Override // com.netflix.model.leafs.TrackableListSummary
    public String toString() {
        return "TrailersFeedItemSummary {id='" + this.id + "', displayName='" + this.displayName + "', trackId='" + getTrackId() + "'}";
    }
}
