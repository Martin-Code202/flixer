package o;

import android.support.v4.app.Fragment;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.zx  reason: case insensitive filesystem */
public class ActivityC2392zx extends AbstractActivityC0360 {
    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return C2393zy.m13853(getIntent());
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r4) {
        String stringExtra = getIntent().getStringExtra("Title");
        if (!C1349Bv.m4113(stringExtra)) {
            r4.mo394((CharSequence) stringExtra).mo396(true);
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.suggestionTitleResults;
    }

    @Override // o.AbstractActivityC0360, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static Class<?> m13837() {
        return NetflixApplication.getInstance().m254() ? ActivityC2380zn.class : ActivityC2392zx.class;
    }
}
