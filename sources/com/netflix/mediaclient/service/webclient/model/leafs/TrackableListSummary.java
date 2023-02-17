package com.netflix.mediaclient.service.webclient.model.leafs;

import android.os.Parcel;
import o.AbstractC2087qh;
@Deprecated
public class TrackableListSummary extends ListSummary implements AbstractC2087qh {
    private int heroTrackId;
    private String impressionToken;
    private int listPos;
    private String requestId;
    private int trackId;

    public TrackableListSummary() {
        super(0);
    }

    protected TrackableListSummary(int i, int i2, int i3, String str) {
        super(i);
        this.trackId = i2;
        this.listPos = i3;
        this.requestId = str;
    }

    protected TrackableListSummary(Parcel parcel) {
        super(parcel);
        this.trackId = parcel.readInt();
        this.listPos = parcel.readInt();
        this.requestId = parcel.readString();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.webclient.model.leafs.ListSummary, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.trackId);
        parcel.writeInt(this.listPos);
        parcel.writeString(this.requestId);
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        return this.trackId;
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        return this.requestId;
    }

    public void setListPos(int i) {
        this.listPos = i;
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        return this.listPos;
    }

    @Override // java.lang.Object
    public String toString() {
        return "TrackableListSummary [trackId=" + this.trackId + ", listPos=" + this.listPos + ", requestId=" + this.requestId + "]";
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        return this.heroTrackId;
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        return this.impressionToken;
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return false;
    }
}
