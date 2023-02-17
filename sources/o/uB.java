package o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.util.log.UIScreen;
public class uB extends AbstractActivityC0360 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private pC f10677;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m11324(Context context, pC pCVar) {
        Intent intent = new Intent(context, m11325());
        intent.putExtra("lomo_parcel", pCVar);
        context.startActivity(intent);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static Class<?> m11325() {
        return NetflixApplication.getInstance().m254() ? uJ.class : uB.class;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f10677 = (pC) getIntent().getParcelableExtra("lomo_parcel");
        super.onCreate(bundle);
        NetflixActionBar netflixActionBar = getNetflixActionBar();
        if (netflixActionBar != null) {
            netflixActionBar.m355(getActionBarStateBuilder().mo399(false).mo394((CharSequence) this.f10677.getTitle()).mo392());
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity
    public int getActionBarParentViewId() {
        return R.id.toolbar_host_view_group;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˎ */
    public boolean mo10188() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return tK.m10960(this.f10677);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        String id = this.f10677.getId();
        char c = 65535;
        switch (id.hashCode()) {
            case 635217018:
                if (id.equals("MyListFakeId")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return UIScreen.myListGallery;
            default:
                return UIScreen.transientUI;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.uB.5
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                if (!C1317As.m3750(uB.this) && (uB.this.mo10792() instanceof AbstractC0517)) {
                    ((AbstractC0517) uB.this.mo10792()).onManagerReady(phVar, status);
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                if (!C1317As.m3750(uB.this)) {
                    Log.e("nf_gallery_lomo", "NetflixService is NOT available!");
                    if (uB.this.mo10792() instanceof AbstractC0517) {
                        ((AbstractC0517) uB.this.mo10792()).onManagerUnavailable(phVar, status);
                    }
                }
            }
        };
    }
}
