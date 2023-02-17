package o;

import android.os.Bundle;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
/* renamed from: o.us  reason: case insensitive filesystem */
public class C2219us extends tD {

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f11024 = "lolomo";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static tD m11739(String str, String str2, GenreList genreList) {
        return m11740(str, str2, genreList, "");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static tD m11740(String str, String str2, GenreList genreList, String str3) {
        C2219us usVar = new C2219us();
        Bundle bundle = new Bundle();
        bundle.putString("list_id", str);
        bundle.putString("genre_filter", str2);
        bundle.putBoolean("is_genre_list", !"lolomo".equals(str));
        if (genreList != null) {
            bundle.putParcelable("genre_parcel", genreList);
        }
        bundle.putString("genre_from_lolomo", str3);
        usVar.setArguments(bundle);
        return usVar;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11024 = getArguments().getString("genre_filter", "lolomo");
    }

    @Override // o.tK, o.AbstractC0517
    public boolean af_() {
        NetflixActionBar netflixActionBar;
        C2221uu r5;
        NetflixActivity r2 = m14534();
        String r3 = m10971();
        if (r3 == null || r2 == null || (netflixActionBar = r2.getNetflixActionBar()) == null || (r5 = netflixActionBar.m367()) == null) {
            return false;
        }
        r5.m11767(this.f11024, r3);
        C2221uu.m11747(netflixActionBar, this.f10381, false);
        return true;
    }
}
