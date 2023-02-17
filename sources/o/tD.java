package o;

import android.os.Bundle;
import android.os.Parcel;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
public class tD extends tK {

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private pC f10322 = new pW() { // from class: o.tD.2
        @Override // o.pC
        public int getNumVideos() {
            return Integer.MAX_VALUE;
        }

        @Override // o.pC
        public boolean isRichUITreatment() {
            return false;
        }

        @Override // o.pC
        public void setListPos(int i) {
        }

        @Override // o.pC
        public String getListContext() {
            return null;
        }

        @Override // o.pC
        public long getRefreshInterval() {
            return 0;
        }

        @Override // o.AbstractC2069pr
        public String getId() {
            return tD.this.m10971();
        }

        @Override // o.AbstractC2069pr
        public String getTitle() {
            return null;
        }

        @Override // o.AbstractC2069pr
        public LoMoType getType() {
            return LoMoType.FLAT_GENRE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
        }

        @Override // o.AbstractC2087qh
        public int getTrackId() {
            return 0;
        }

        @Override // o.AbstractC2087qh
        public int getListPos() {
            return 0;
        }

        @Override // o.AbstractC2087qh
        public String getRequestId() {
            return null;
        }

        @Override // o.AbstractC2087qh
        public String getImpressionToken() {
            return null;
        }

        @Override // o.AbstractC2087qh
        public int getHeroTrackId() {
            return 0;
        }

        @Override // o.AbstractC2087qh
        public boolean isHero() {
            return false;
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    public static tD m10889(String str, GenreList genreList) {
        return m10890(str, genreList, "");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static tD m10890(String str, GenreList genreList, String str2) {
        tD tDVar = new tD();
        Bundle bundle = new Bundle();
        bundle.putString("list_id", str);
        bundle.putBoolean("is_genre_list", !"lolomo".equals(str));
        if (genreList != null) {
            bundle.putParcelable("genre_parcel", genreList);
        }
        bundle.putString("genre_from_lolomo", str2);
        tDVar.setArguments(bundle);
        return tDVar;
    }

    @Override // o.tK
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public pC mo10891() {
        return this.f10322;
    }
}
