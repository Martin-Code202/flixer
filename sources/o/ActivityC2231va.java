package o;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.netflix.mediaclient.android.activity.NetflixActivity;
/* renamed from: o.va  reason: case insensitive filesystem */
public class ActivityC2231va extends ActivityC2132ru {
    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void initSlidingPanel() {
        super.initSlidingPanel();
        this.slidingPanel.setPanelHeight(0);
        getWindow().getAttributes().width = AD.m3317(this);
        getNetflixActionBar().m355(getActionBarStateBuilder().mo399(false).mo392());
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.DetailsActivity, o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (AD.m3292() && getRequestedOrientation() != 1) {
            setRequestedOrientation(1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.ActivityC2132ru, com.netflix.mediaclient.ui.details.DetailsActivity, com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void showCastPlayer() {
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void hideCastPlayer() {
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void notifyCastPlayerShown(boolean z) {
        if (z) {
            Intent r2 = ActivityC2153sl.m10782(this);
            r2.putExtra(NetflixActivity.EXTRA_EXPAND_CAST_PLAYER, true);
            startActivity(r2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean allowTransitionAnimation() {
        return false;
    }
}
