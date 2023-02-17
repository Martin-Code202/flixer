package o;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.util.log.UIScreen;
public class sC extends AbstractActivityC0360 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f9979 = sC.class.getSimpleName();

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f9980;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f9981;

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˎ */
    public boolean mo10188() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9980 = bundle.getBoolean("notification_beacon_sent");
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static Class<?> m10520() {
        return NetflixApplication.getInstance().m254() ? sH.class : sC.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        C1283.m16853(f9979, "onNewIntent: ", intent);
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("notification_beacon_sent", this.f9980);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.fragment_host_activity_no_mini_player;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return new sF();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.sC.4
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                C1283.m16854(sC.f9979, "Manager is here!");
                ((oV) sC.this.mo10792()).onManagerReady(phVar, status);
                sC.this.f9981 = true;
                if (!sC.this.f9980) {
                    sC.this.f9980 = true;
                    C1328Ba.m3985(phVar, sC.this.getIntent());
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16854(sC.f9979, "Manager isn't available!");
                ((oV) sC.this.mo10792()).onManagerUnavailable(phVar, status);
            }
        };
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.socialNotifications;
    }

    @Override // o.AbstractActivityC0360, o.AbstractC0459
    public boolean isLoadingData() {
        return this.f9981 && mo10792() != null && ((AbstractC0517) mo10792()).isLoadingData();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m10518(C1999nc ncVar) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.NOTIFICATION_IRIS");
        C1999nc.m9277(intent, ncVar);
        return intent;
    }
}
