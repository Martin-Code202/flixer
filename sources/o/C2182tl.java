package o;

import android.support.v4.widget.DrawerLayout;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.ViewUtils;
/* renamed from: o.tl  reason: case insensitive filesystem */
public class C2182tl extends C2160ss {
    public C2182tl(NetflixActivity netflixActivity, DrawerLayout drawerLayout) {
        super(netflixActivity, drawerLayout, false);
        this.f10261.setBackgroundColor(netflixActivity.getResources().getColor(R.color.medium_grey));
        this.f10261.setVisibility(0);
        drawerLayout.findViewById(R.id.header_separator_notifications).setVisibility(8);
        drawerLayout.findViewById(R.id.header_separator_switch_profile).getLayoutParams().height = netflixActivity.getResources().getDimensionPixelSize(R.dimen.drawer_kids_separator_height);
        drawerLayout.findViewById(R.id.header_separator_settings).getLayoutParams().height = netflixActivity.getResources().getDimensionPixelSize(R.dimen.drawer_kids_separator_height);
        ViewUtils.m3011(this.f10253);
        ViewUtils.m3011(this.f10245);
        this.f10245.setLayoutParams(new LinearLayout.LayoutParams(-1, netflixActivity.getResources().getDimensionPixelSize(R.dimen.kids_sliding_menu_item_height)));
        drawerLayout.findViewById(R.id.layout_content).setBackgroundResource(R.color.white);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2160ss
    /* renamed from: ˏ */
    public void mo10847() {
        super.mo10847();
        this.f10265.setImageResource(R.drawable.ic_change_profile_kids);
    }
}
