package com.netflix.model.leafs;

import android.os.Parcel;
import com.google.gson.JsonElement;
import java.util.Map;
import o.AK;
import o.AbstractC2086qg;
public class SearchTrackableListSummary extends TrackableListSummary implements AbstractC2086qg {
    private static final String TAG = "SearchTrackableListSummary";
    private String displayTitle;
    private String referenceId;

    public SearchTrackableListSummary() {
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary, o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        super.populate(jsonElement);
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1809429645:
                    if (key.equals("displayString")) {
                        c = 3;
                        break;
                    }
                    break;
                case -925155509:
                    if (key.equals("reference")) {
                        c = 0;
                        break;
                    }
                    break;
                case -16211514:
                    if (key.equals("referenceId")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1604797110:
                    if (key.equals("displayTitle")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.referenceId = AK.m3375(entry.getValue());
                    break;
                case 1:
                    this.displayTitle = AK.m3375(entry.getValue());
                    break;
                case 2:
                    this.referenceId = AK.m3375(entry.getValue());
                    break;
                case 3:
                    this.displayTitle = AK.m3375(entry.getValue());
                    break;
            }
        }
    }

    protected SearchTrackableListSummary(Parcel parcel) {
        super(parcel);
        this.referenceId = parcel.readString();
        this.displayTitle = parcel.readString();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.referenceId);
        parcel.writeString(this.displayTitle);
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    @Override // o.AbstractC2086qg
    public String getReferenceId() {
        return this.referenceId;
    }
}
