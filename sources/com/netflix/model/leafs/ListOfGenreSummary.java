package com.netflix.model.leafs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.Locale;
import java.util.Map;
import o.AbstractC0852;
import o.C1349Bv;
public class ListOfGenreSummary extends TrackableListSummary implements GenreList, AbstractC0852 {
    public static final Parcelable.Creator<ListOfGenreSummary> CREATOR = new Parcelable.Creator<ListOfGenreSummary>() { // from class: com.netflix.model.leafs.ListOfGenreSummary.1
        @Override // android.os.Parcelable.Creator
        public ListOfGenreSummary createFromParcel(Parcel parcel) {
            return new ListOfGenreSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ListOfGenreSummary[] newArray(int i) {
            return new ListOfGenreSummary[i];
        }
    };
    private static final String TAG = "ListOfGenreSummary";
    protected String genreId;
    protected String genreName;
    protected String genreType;

    public ListOfGenreSummary() {
    }

    public ListOfGenreSummary(String str, String str2, GenreList.GenreType genreType2) {
        this.genreName = str;
        this.genreId = str2;
        this.genreType = genreType2.toString();
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary, o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        super.populate(jsonElement);
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -79774210:
                    if (key.equals("genreId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 646545070:
                    if (key.equals("genreName")) {
                        c = 0;
                        break;
                    }
                    break;
                case 646746973:
                    if (key.equals("genreType")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.genreName = C1349Bv.m4128(entry.getValue().getAsString());
                    break;
                case 1:
                    this.genreId = entry.getValue().getAsString();
                    break;
                case 2:
                    this.genreType = entry.getValue().getAsString();
                    break;
            }
        }
    }

    @Override // o.AbstractC2069pr
    public String getId() {
        return this.genreId;
    }

    @Override // com.netflix.mediaclient.servicemgr.interface_.genre.GenreList
    public GenreList.GenreType getGenreType() {
        if (this.genreType == null) {
            return GenreList.GenreType.LOLOMO;
        }
        return GenreList.GenreType.valueOf(this.genreType.toUpperCase(Locale.ENGLISH));
    }

    @Override // o.AbstractC2069pr
    public String getTitle() {
        return this.genreName;
    }

    @Override // o.AbstractC2069pr
    public LoMoType getType() {
        return LoMoType.STANDARD;
    }

    public int getNumVideos() {
        return getLength();
    }

    public ListOfGenreSummary(Parcel parcel) {
        super(parcel);
        this.genreName = parcel.readString();
        this.genreId = parcel.readString();
        this.genreType = parcel.readString();
    }

    @Override // com.netflix.model.leafs.TrackableListSummary, com.netflix.model.leafs.ListSummary
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.genreName);
        parcel.writeString(this.genreId);
        parcel.writeString(this.genreType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.netflix.model.leafs.TrackableListSummary
    public String toString() {
        return "ListOfGenreSummary [genreName=" + this.genreName + ", genreId=" + this.genreId + ", genreType=" + this.genreType + "]";
    }
}
