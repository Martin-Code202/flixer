package o;

import android.view.Menu;
import android.view.MenuItem;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.search.SearchActivity;
/* renamed from: o.zu  reason: case insensitive filesystem */
public class C2389zu {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static MenuItem m13827(NetflixActivity netflixActivity, Menu menu) {
        return menu.add(0, R.id.ab_menu_search_item, 0, R.string.search).setIcon(R.drawable.ic_search_ab).setIntent(SearchActivity.m2775(netflixActivity)).setShowAsActionFlags(1);
    }
}
