package o;

import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.PlayerFragment;
/* renamed from: o.wd  reason: case insensitive filesystem */
public class C2262wd extends C2263we {
    C2262wd(PlayerFragment playerFragment) {
        super(playerFragment);
        this.f11602 = (int) playerFragment.getResources().getDimension(R.dimen.player_big_margin_bottom);
    }

    @Override // o.C2263we, o.vZ
    /* renamed from: ॱ */
    public void mo12116() {
        if (this.f11438 != null && this.f11438.m14535() && this.f11302 != null && (this.f11302.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11302.getLayoutParams();
            marginLayoutParams.setMargins(this.f11438.mo2226().m12501(this.f11302), marginLayoutParams.topMargin, marginLayoutParams.getMarginEnd(), marginLayoutParams.bottomMargin);
            this.f11302.setLayoutParams(marginLayoutParams);
        }
    }
}
