package o;

import android.os.Bundle;
import android.support.transition.Transition;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import o.AbstractC0459;
/* renamed from: o.ƭ  reason: contains not printable characters */
public abstract class AbstractActivityC0360 extends NetflixActivity {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Fragment f13115;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Fragment f13116;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ViewGroup f13117;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ViewGroup f13118;

    /* renamed from: ॱ  reason: contains not printable characters */
    private LinearLayout f13119;

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract Fragment mo10189();

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(mo10187());
        this.f13119 = (LinearLayout) findViewById(R.id.fragment_host_container);
        this.f13117 = (ViewGroup) findViewById(R.id.primary_fragment);
        if (!mo10188()) {
            ViewGroup.LayoutParams layoutParams = this.f13117.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            }
        }
        this.f13118 = (ViewGroup) findViewById(R.id.secondary_fragment);
        setupCastPlayerFrag(bundle);
        if (bundle == null) {
            this.f13116 = mo10189();
            this.f13115 = mo10481();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.primary_fragment, this.f13116, "primary");
            if (this.f13115 != null) {
                beginTransaction.add(R.id.secondary_fragment, this.f13115, "secondary");
            }
            beginTransaction.commit();
        } else {
            this.f13116 = getSupportFragmentManager().findFragmentByTag("primary");
            this.f13115 = getSupportFragmentManager().findFragmentByTag("secondary");
        }
        setFragmentPadding(this.f13116);
        setFragmentPadding(this.f13115);
        if (this.f13119 != null) {
            m13999();
        }
        if (this.f13118 != null) {
            this.f13118.setVisibility(this.f13115 == null ? 8 : 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        O_();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public int getActionBarParentViewId() {
        if (hasBottomNavBar()) {
            return R.id.coordinatorLayout;
        }
        return super.getActionBarParentViewId();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m13999() {
        this.f13119.setOrientation(AD.m3284(this) == 2 ? 0 : 1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13117.getLayoutParams();
        layoutParams.weight = 0.6f;
        this.f13117.setLayoutParams(layoutParams);
        if (this.f13115 != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13118.getLayoutParams();
            layoutParams2.weight = 1.0f;
            this.f13118.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public boolean mo10188() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public Fragment mo10481() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.fragment_host_activity;
    }

    /* renamed from: ʽ */
    public Fragment mo10792() {
        return this.f13116;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m13998(Fragment fragment) {
        this.f13116 = fragment;
        setFragmentPadding(fragment);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public ViewGroup m13997() {
        return this.f13117;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public Fragment m14001() {
        return this.f13115;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        boolean isLoadingData = ((AbstractC0459) this.f13116).isLoadingData();
        if (this.f13115 != null) {
            return isLoadingData | ((AbstractC0459) this.f13115).isLoadingData();
        }
        return isLoadingData;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r2) {
        super.setLoadingStatusCallback(r2);
        if (this.f13116 != null) {
            ((AbstractC0459) this.f13116).setLoadingStatusCallback(r2);
        }
        if (this.f13115 != null) {
            ((AbstractC0459) this.f13115).setLoadingStatusCallback(r2);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m14000() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            C1283.m16862("FragmentHostActivity", "requestExternalStoragePermission requesting permission.");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
            return;
        }
        C1283.m16862("FragmentHostActivity", "requestExternalStoragePermission already have permission.");
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setFragmentsHiddenState(boolean z, Transition transition) {
        Fragment fragment = this.f13116;
        if (fragment != null && fragment.isHidden() != z) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (z) {
                fragment.setExitTransition(transition);
                beginTransaction.hide(fragment);
            } else {
                fragment.setEnterTransition(transition);
                beginTransaction.show(fragment);
            }
            beginTransaction.commitNowAllowingStateLoss();
            if (!z) {
                O_();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean O_() {
        if (this.fragmentHelper.mo10706() || !(this.f13116 instanceof AbstractC0517) || this.f13116.isHidden()) {
            return false;
        }
        return ((AbstractC0517) this.f13116).af_();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onPaddingChanged() {
        super.onPaddingChanged();
        setFragmentPadding(this.f13116);
        setFragmentPadding(this.f13115);
    }
}
