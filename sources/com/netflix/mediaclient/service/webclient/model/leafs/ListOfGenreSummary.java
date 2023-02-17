package com.netflix.mediaclient.service.webclient.model.leafs;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.Locale;
import o.C1349Bv;
@Deprecated
public class ListOfGenreSummary extends TrackableListSummary implements GenreList {
    public static final Parcelable.Creator<ListOfGenreSummary> CREATOR = new Parcelable.Creator<ListOfGenreSummary>() { // from class: com.netflix.mediaclient.service.webclient.model.leafs.ListOfGenreSummary.1
        @Override // android.os.Parcelable.Creator
        public ListOfGenreSummary createFromParcel(Parcel parcel) {
            return new ListOfGenreSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ListOfGenreSummary[] newArray(int i) {
            return new ListOfGenreSummary[i];
        }
    };
    private final String genreId;
    private final String genreName;
    private final String genreType;

    public ListOfGenreSummary(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        super(i, i2, i3, str);
        this.genreName = C1349Bv.m4128(str2);
        this.genreId = str3;
        this.genreType = str4;
    }

    @Override // o.AbstractC2069pr
    public String getId() {
        return this.genreId;
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

    @Override // com.netflix.mediaclient.servicemgr.interface_.genre.GenreList
    public GenreList.GenreType getGenreType() {
        if (this.genreType == null) {
            return GenreList.GenreType.LOLOMO;
        }
        return GenreList.GenreType.valueOf(this.genreType.toUpperCase(Locale.ENGLISH));
    }

    public ListOfGenreSummary(Parcel parcel) {
        super(parcel);
        this.genreName = parcel.readString();
        this.genreId = parcel.readString();
        this.genreType = parcel.readString();
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.TrackableListSummary, com.netflix.mediaclient.service.webclient.model.leafs.ListSummary, android.os.Parcelable
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

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.TrackableListSummary, java.lang.Object
    public String toString() {
        return "ListOfGenreSummary [genreName=" + this.genreName + ", genreId=" + this.genreId + ", genreType=" + this.genreType + "]";
    }
}
