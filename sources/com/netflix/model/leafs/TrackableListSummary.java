package com.netflix.model.leafs;

import android.os.Parcel;
import com.google.gson.JsonElement;
import java.util.Map;
import o.AK;
import o.AbstractC0852;
import o.AbstractC2087qh;
public class TrackableListSummary extends ListSummary implements AbstractC2087qh, AbstractC0852 {
    private static final String TAG = "TrackableListSummary";
    private int heroTrackId;
    private String impressionToken;
    private int listPos;
    private String requestId;
    private int roarTrackId;
    private int trackId;

    public TrackableListSummary() {
    }

    @Override // com.netflix.model.leafs.ListSummary, o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        super.populate(jsonElement);
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1067396154:
                    if (key.equals("trackId")) {
                        c = 0;
                        break;
                    }
                    break;
                case -847438664:
                    if (key.equals("roarTrackId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 181951702:
                    if (key.equals("listPos")) {
                        c = 3;
                        break;
                    }
                    break;
                case 311922284:
                    if (key.equals("heroTrackId")) {
                        c = 2;
                        break;
                    }
                    break;
                case 693933066:
                    if (key.equals("requestId")) {
                        c = 4;
                        break;
                    }
                    break;
                case 780801392:
                    if (key.equals("impressionToken")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.trackId = AK.m3379(entry.getValue());
                    break;
                case 1:
                    this.roarTrackId = AK.m3379(entry.getValue());
                    break;
                case 2:
                    this.heroTrackId = AK.m3379(entry.getValue());
                    break;
                case 3:
                    this.listPos = AK.m3379(entry.getValue());
                    break;
                case 4:
                    this.requestId = AK.m3375(entry.getValue());
                    break;
                case 5:
                    this.impressionToken = AK.m3375(entry.getValue());
                    break;
            }
        }
    }

    protected TrackableListSummary(Parcel parcel) {
        super(parcel);
        this.trackId = parcel.readInt();
        this.roarTrackId = parcel.readInt();
        this.heroTrackId = parcel.readInt();
        this.listPos = parcel.readInt();
        this.requestId = parcel.readString();
        this.impressionToken = parcel.readString();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.model.leafs.ListSummary
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.trackId);
        parcel.writeInt(this.roarTrackId);
        parcel.writeInt(this.heroTrackId);
        parcel.writeInt(this.listPos);
        parcel.writeString(this.requestId);
        parcel.writeString(this.impressionToken);
    }

    public void setTrackId(int i) {
        this.trackId = i;
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        return this.trackId;
    }

    public int getRoarTrackId() {
        return this.roarTrackId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        return this.requestId;
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        return this.impressionToken;
    }

    public void setListPos(int i) {
        this.listPos = i;
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        return this.listPos;
    }

    public String toString() {
        return "TrackableListSummary [trackId=" + this.trackId + ", listPos=" + this.listPos + ", requestId=" + this.requestId + "]";
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        return this.heroTrackId;
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return false;
    }
}
