package o;

import android.os.Bundle;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
public class tS extends tQ {

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private String f10443 = "lolomo";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static tS m11022(String str, GenreList genreList) {
        tS tSVar = new tS();
        String id = genreList != null ? genreList.getId() : "lolomo";
        Bundle bundle = new Bundle();
        bundle.putString("genre_id", id);
        bundle.putString("genre_filter", str);
        bundle.putBoolean("is_genre_list", !"lolomo".equals(id));
        if (genreList != null) {
            bundle.putParcelable("genre_parcel", genreList);
        }
        tSVar.setArguments(bundle);
        return tSVar;
    }

    @Override // o.tQ, o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10443 = getArguments().getString("genre_filter", "lolomo");
    }

    @Override // o.tQ, o.AbstractC0517
    public boolean af_() {
        NetflixActionBar netflixActionBar;
        C2221uu r4;
        NetflixActivity r2 = m14534();
        if (r2 == null || isHidden() || this.f10422 == null || (netflixActionBar = r2.getNetflixActionBar()) == null || (r4 = netflixActionBar.m367()) == null) {
            return false;
        }
        r4.m11767(this.f10443, this.f10422);
        mo11018(netflixActionBar);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.tQ
    /* renamed from: ॱ */
    public void mo11018(NetflixActionBar netflixActionBar) {
        if (this.f10430 != null) {
            C2221uu.m11747(netflixActionBar, this.f10430, !this.f10421 || m11016());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.tQ
    /* renamed from: ˋ */
    public void mo11014(View view) {
        if (C0727.m15069()) {
            this.f10411 = new C0527(view, this.f10429, C0527.f13715);
            this.f10411.mo14659(0, this.f13651 + this.f13649, 0, this.f13650);
            return;
        }
        super.mo11014(view);
    }
}
