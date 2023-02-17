package o;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.st  reason: case insensitive filesystem */
public class ActivityC2162st extends AbstractActivityC0360 implements qK {
    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.base_tabs_activity;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFragmentHelper(new tH(this, bundle));
        getNetflixActionBar().m350(false);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return vB.m11825();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.myProfile;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasBottomNavBar() {
        return NetflixBottomNavBar.m416();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.st.4
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                ((vB) ActivityC2162st.this.mo10792()).onManagerReady(phVar, status);
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("MoreTabActivity", "NetflixService is NOT available!");
                ((AbstractC0517) ActivityC2162st.this.mo10792()).onManagerUnavailable(phVar, status);
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowActionBar() {
        return this.fragmentHelper.mo10706();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileActivated() {
        long nanoTime = System.nanoTime();
        C1283.m16854("MoreTabActivity", "Restarting app, time: " + nanoTime);
        finishAllActivities(this);
        startActivity(ActivityC2187tq.m11247(this, "handleProfileActivated() " + nanoTime).addFlags(67108864));
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        oB oBVar = new oB("MoreTabActivity");
        if (!NetflixBottomNavBar.m416() || !this.fragmentHelper.mo10706()) {
            return oBVar;
        }
        return this.fragmentHelper.mo10701();
    }
}
