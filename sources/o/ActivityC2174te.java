package o;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.util.log.UIScreen;
import o.qH;
/* renamed from: o.te  reason: case insensitive filesystem */
public class ActivityC2174te extends DetailsActivity {

    /* renamed from: ˏ  reason: contains not printable characters */
    private VideoType f10523 = VideoType.UNKNOWN;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static Class<? extends ActivityC2174te> m11118() {
        return NetflixApplication.getInstance().m254() ? qD.class : ActivityC2174te.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (!getIntent().hasExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)) {
            throw new IllegalStateException("Start intent must provide extra value: extra_video_type_string_value");
        }
        this.f10523 = VideoType.create(getIntent().getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE));
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setTheme() {
        setTheme(R.style.res_2131952232_theme_netflix_kids_netflixactionbaroverlay_character);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        return ((AbstractC2123rl) mo10792()).V_();
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (!handleBackPressed()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        if (menu2 != null) {
            new C0405("KidsShowDetailsActivity", this).m14189(menu2);
        }
        uM.m11540(this, menu);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.te.1
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                ActivityC2174te.this.setupInteractiveTracking(new qH.C0166(), ActivityC2174te.this.m1649());
                ((oV) ActivityC2174te.this.mo10792()).onManagerReady(phVar, status);
                ActivityC2174te.this.m1644();
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                ((oV) ActivityC2174te.this.mo10792()).onManagerUnavailable(phVar, status);
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return C2175tf.m11135(this.f2886, getIntent().getIntExtra("extra_kids_color_id", R.color.kids_default));
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.characterDetails;
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity
    /* renamed from: ˋॱ */
    public VideoType mo1643() {
        return this.f10523;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean allowTransitionAnimation() {
        return false;
    }
}
