package com.netflix.model.leafs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import java.util.List;
import java.util.Map;
import o.AK;
import o.AbstractC0852;
import o.C1349Bv;
import o.pC;
import o.pW;
public class ListOfMoviesSummary extends TrackableListSummary implements pC, pW, AbstractC0852 {
    public static final Parcelable.Creator<ListOfMoviesSummary> CREATOR = new Parcelable.Creator<ListOfMoviesSummary>() { // from class: com.netflix.model.leafs.ListOfMoviesSummary.1
        @Override // android.os.Parcelable.Creator
        public ListOfMoviesSummary createFromParcel(Parcel parcel) {
            return new ListOfMoviesSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ListOfMoviesSummary[] newArray(int i) {
            return new ListOfMoviesSummary[i];
        }
    };
    private static final String TAG = "ListOfMoviesSummary";
    private String displayName;
    private LoMoType enumType;
    private long expiryTimestamp = Long.MAX_VALUE;
    private String id;
    private String listContext;
    private List<String> moreImgs;
    private long refreshInterval;
    private boolean renderRichUITreatment;
    private String videoId;

    public ListOfMoviesSummary() {
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
                case -1027260046:
                    if (key.equals("renderRichUITreatment")) {
                        c = 6;
                        break;
                    }
                    break;
                case -219259387:
                    if (key.equals("moreImgs")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 335574307:
                    if (key.equals("expiryTimestamp")) {
                        c = 5;
                        break;
                    }
                    break;
                case 452782838:
                    if (key.equals("videoId")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1263587121:
                    if (key.equals("listContext")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1714148973:
                    if (key.equals("displayName")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1919275200:
                    if (key.equals("refreshInterval")) {
                        c = 4;
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
                case 2:
                    this.listContext = value.getAsString();
                    break;
                case 3:
                    this.moreImgs = AK.m3382(entry.getValue().getAsJsonArray());
                    break;
                case 4:
                    this.refreshInterval = value.getAsLong();
                    break;
                case 5:
                    this.expiryTimestamp = value.getAsLong();
                    break;
                case 6:
                    this.renderRichUITreatment = value.getAsBoolean();
                    break;
                case 7:
                    this.videoId = value.getAsString();
                    break;
            }
        }
    }

    public ListOfMoviesSummary(Parcel parcel) {
        super(parcel);
        this.id = parcel.readString();
        this.displayName = parcel.readString();
        this.listContext = parcel.readString();
        this.refreshInterval = parcel.readLong();
        this.renderRichUITreatment = parcel.readByte() != 0;
        this.expiryTimestamp = parcel.readLong();
        this.videoId = parcel.readString();
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.displayName);
        parcel.writeString(this.listContext);
        parcel.writeLong(this.refreshInterval);
        parcel.writeByte((byte) (this.renderRichUITreatment ? 1 : 0));
        parcel.writeLong(this.expiryTimestamp);
        parcel.writeString(this.videoId);
    }

    @Override // o.AbstractC2069pr
    public String getTitle() {
        return this.displayName;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // o.AbstractC2069pr
    public String getId() {
        return this.id;
    }

    @Override // o.pC
    public int getNumVideos() {
        return getLength();
    }

    @Override // o.AbstractC2069pr
    public LoMoType getType() {
        if (this.enumType == null) {
            this.enumType = LoMoType.m1573(this.listContext);
        }
        return this.enumType;
    }

    @Override // o.pC
    public long getRefreshInterval() {
        return this.refreshInterval;
    }

    public boolean isExpired() {
        return this.expiryTimestamp < System.currentTimeMillis();
    }

    @Override // o.pC
    public String getListContext() {
        return this.listContext;
    }

    public List<String> getMoreImages() {
        return this.moreImgs;
    }

    public boolean isBillboard() {
        return getType() == LoMoType.BILLBOARD;
    }

    @Override // o.pC
    public boolean isRichUITreatment() {
        return this.renderRichUITreatment;
    }

    public String getVideoId() {
        return this.videoId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.netflix.model.leafs.TrackableListSummary
    public String toString() {
        return "ListOfMoviesSummary{id='" + this.id + "', displayName='" + this.displayName + "', listContext='" + this.listContext + "', moreImgs=" + this.moreImgs + ", refreshInterval=" + this.refreshInterval + ", expiryTimestamp=" + this.expiryTimestamp + ", renderRichUITreatment='" + this.renderRichUITreatment + "'}";
    }
}
