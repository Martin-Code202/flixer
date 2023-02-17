package o;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment;
import com.netflix.mediaclient.util.log.UIScreen;
import o.zE;
public class zC extends AbstractActivityC0360 implements BandwidthPreferenceDialogFragment.AbstractC0031, zE.iF {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f12554;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final BroadcastReceiver f12555 = new BroadcastReceiver() { // from class: o.zC.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RecyclerView listView;
            C1283.m16862("nf_settings", "mOsvSpaceUpdatedReceiver");
            Fragment r2 = zC.this.mo10792();
            if ((r2 instanceof zE) && (listView = ((zE) r2).getListView()) != null && listView.getAdapter() != null) {
                listView.getAdapter().notifyDataSetChanged();
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m13380(Activity activity) {
        return new Intent(activity, m13381());
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static Class<?> m13381() {
        return NetflixApplication.getInstance().m254() ? zD.class : zC.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AbstractC1853hl r1 = getServiceManager().m9832();
        if (r1 != null) {
            r1.mo7139();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return zE.m13412();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.fragment_host_activity_no_mini_player;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 1:
                if (iArr.length > 0 && iArr[0] == 0) {
                    C1283.m16862("nf_settings", "permission is granted");
                    return;
                } else if (iArr.length > 0 && iArr[0] == -1) {
                    C1283.m16863("nf_settings", "onRequestPermissionsResult showRationale=%b", Boolean.valueOf(ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")));
                    Fragment r6 = mo10792();
                    if (r6 != null && (r6 instanceof zE)) {
                        ((zE) r6).m13421();
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerReceiverLocallyWithAutoUnregister(this.f12555, "com.netflix.mediaclient.intent.offline.osv.space.usage.updated");
    }

    @Override // o.zE.iF
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public String mo13382() {
        AbstractC1853hl r3;
        if (this.f12554 == null && (r3 = getServiceManager().m9832()) != null) {
            pY r4 = r3.mo7136();
            pZ pZVar = (pZ) r4.mo4075(r4.mo9597());
            if (pZVar != null) {
                this.f12554 = BG.m3861(getApplicationContext(), pZVar.mo7012());
            }
        }
        return this.f12554;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showMdxInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.settings;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zC.2
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                ((zE) zC.this.mo10792()).onManagerReady(phVar, status);
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("nf_settings", "NetflixService is NOT available!");
                ((zE) zC.this.mo10792()).onManagerUnavailable(phVar, status);
            }
        };
    }

    @Override // com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment.AbstractC0031
    /* renamed from: ॱ */
    public void mo1602(Context context) {
        ((zE) mo10792()).m13420(context);
    }
}
