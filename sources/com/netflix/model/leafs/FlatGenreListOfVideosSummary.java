package com.netflix.model.leafs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0852;
import o.C1349Bv;
public class FlatGenreListOfVideosSummary extends TrackableListSummary implements AbstractC0852 {
    public static final Parcelable.Creator<FlatGenreListOfVideosSummary> CREATOR = new Parcelable.Creator<FlatGenreListOfVideosSummary>() { // from class: com.netflix.model.leafs.FlatGenreListOfVideosSummary.1
        @Override // android.os.Parcelable.Creator
        public FlatGenreListOfVideosSummary createFromParcel(Parcel parcel) {
            return new FlatGenreListOfVideosSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FlatGenreListOfVideosSummary[] newArray(int i) {
            return new FlatGenreListOfVideosSummary[i];
        }
    };
    private static final String TAG = "FlatGenreListOfVideosSummary";
    private String displayName;
    private String id;

    public FlatGenreListOfVideosSummary() {
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary, o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        String str;
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
                case 1714148973:
                    if (key.equals("displayName")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = value.getAsString();
                    break;
                case 1:
                    if (value == null || value.isJsonNull()) {
                        str = "";
                    } else {
                        str = C1349Bv.m4128(value.getAsString());
                    }
                    this.displayName = str;
                    break;
            }
        }
    }

    public FlatGenreListOfVideosSummary(Parcel parcel) {
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

    @Override // com.netflix.model.leafs.TrackableListSummary, o.AbstractC2087qh
    public int getListPos() {
        return 0;
    }

    @Override // com.netflix.model.leafs.TrackableListSummary
    public String toString() {
        return "FlatGenreListOfVideosSummary {id='" + this.id + "', displayName='" + this.displayName + "', trackId='" + getTrackId() + "'}";
    }
}
