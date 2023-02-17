package o;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import com.netflix.mediaclient.util.log.UIScreen;
import o.AbstractC0496;
import o.qO;
import o.tP;
/* renamed from: o.wv  reason: case insensitive filesystem */
public class ActivityC2280wv extends AbstractActivityC0360 implements AbstractC0496.Cif, qK {

    /* renamed from: ˊ  reason: contains not printable characters */
    private IPlayerFragment f11715;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m12564(Context context, String str, VideoType videoType, oX oXVar) {
        Intent intent = new Intent(context, ActivityC2280wv.class);
        intent.addFlags(131072);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_ID, str);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        intent.putExtra(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.f11715 == null || this.f11715.mo2268() == null || !m12568(this.f11715.mo2268().getPlayableId(), intent)) {
            super.onNewIntent(intent);
            if (this.f11715 == null) {
                C1276.m16820().mo5727("SPY-8343 - PlayerActivity received onNewIntent() prior to onCreate() - skipping to avoid crash");
                return;
            }
            C1283.m16854("PlayerActivity", "PlayerActivity::onNewIntent - playerActivity got new intent " + intent);
            String stringExtra = intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID);
            if (C1349Bv.m4107(stringExtra)) {
                VideoType create = VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE));
                oX oXVar = (oX) intent.getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT);
                if (oXVar == null) {
                    oXVar = new oB("PlayerActivity");
                }
                int intExtra = intent.getIntExtra("extra_bookmark_seconds_from_start_param", -1);
                if (this.f11715.mo2226() == null || !this.f11715.mo2265()) {
                    this.f11715.mo2260(stringExtra, create, oXVar, intExtra);
                } else {
                    this.f11715.mo2259(stringExtra, create, oXVar);
                    return;
                }
            } else {
                C1276.m16820().mo5725("Unable to start handle the new intent without a video id");
            }
            this.f11715.mo2266();
            return;
        }
        C1283.m16854("PlayerActivity", "Got same video ID - resuming the playback...");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        Intent intent = getIntent();
        if (intent.hasExtra(NetflixActivity.EXTRA_VIDEO_ID)) {
            oX oXVar = (oX) intent.getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT);
            if (C0910.m15708()) {
                this.f11715 = C2283wy.m12663(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID), VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)), oXVar, -1, intent.getIntExtra("EXTRA_AUTO_PLAY_COUNT", 0));
            } else if (C0913.m15712()) {
                this.f11715 = C2284wz.m12720(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID), VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)), oXVar, -1, intent.getIntExtra("EXTRA_AUTO_PLAY_COUNT", 0));
            } else if (C0889.m15606()) {
                this.f11715 = wA.f11408.m12254(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID), VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)), oXVar, -1, intent.getIntExtra("EXTRA_AUTO_PLAY_COUNT", 0));
            } else if (C0650.m14799() || Config_Ab9454_InPlayerPivots.m517()) {
                this.f11715 = wB.m12257(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID), VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)), oXVar, -1, intent.getIntExtra("EXTRA_AUTO_PLAY_COUNT", 0));
            } else {
                this.f11715 = PlayerFragment.m2419(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID), VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)), oXVar, -1, intent.getIntExtra("EXTRA_AUTO_PLAY_COUNT", 0));
            }
        }
        if (this.f11715 == null) {
            C1276.m16820().mo5725("Unable to create primary fragment in PlayerActivity as video id was not passed in the intent.");
            finish();
        } else {
            Bundle arguments = this.f11715.getArguments();
            if (intent.hasExtra("SeamlessMode")) {
                arguments.putBoolean("SeamlessMode", intent.getBooleanExtra("SeamlessMode", false));
            }
            if (intent.hasExtra("extra_bookmark_seconds_from_start_param")) {
                arguments.putInt("extra_bookmark_seconds_from_start_param", intent.getIntExtra("extra_bookmark_seconds_from_start_param", -1));
            }
            if (intent.hasExtra("advisory_disabled")) {
                arguments.putBoolean("advisory_disabled", intent.getBooleanExtra("advisory_disabled", false));
            }
            if (intent.hasExtra("is_pin_verified")) {
                arguments.putBoolean("is_pin_verified", intent.getBooleanExtra("is_pin_verified", false));
            }
            if (intent.hasExtra("extra_skip_preplay")) {
                arguments.putBoolean("extra_skip_preplay", intent.getBooleanExtra("extra_skip_preplay", false));
            }
        }
        return (Fragment) this.f11715;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m12568(String str, Intent intent) {
        return C1349Bv.m4126(str, intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C0889.m15606()) {
            setRequestedOrientation(6);
        }
        m12567();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m12567() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (isInMultiWindowMode()) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().addFlags(1024);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˎ */
    public boolean mo10188() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.fragment_host_activity_no_mini_player_no_fab;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (this.f11715 != null) {
            this.f11715.mo2232();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.wv.5
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                ((AbstractC0517) ActivityC2280wv.this.mo10792()).onManagerReady(phVar, status);
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("PlayerActivity", "NetflixService is NOT available!");
                ((AbstractC0517) ActivityC2280wv.this.mo10792()).onManagerUnavailable(phVar, status);
            }
        };
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.playback;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public C1359Ce getDataContext() {
        String str;
        oX r2 = mo1635();
        if (this.f11715 == null || this.f11715.mo2268() == null) {
            str = getIntent().getStringExtra(NetflixActivity.EXTRA_VIDEO_ID);
        } else {
            str = this.f11715.mo2268().getPlayableId();
        }
        return new C1359Ce(r2, str);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldAttachToolbar() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (C1330Bc.m4002(this)) {
            C1283.m16862("PlayerActivity", "another activity on top, finish SPY-11284");
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showMdxInMenu() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    @Override // o.AbstractActivityC0360, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
        C1283.m16854("PlayerActivity", "Check if MDX status is changed");
        if (this.f11715 != null) {
            this.f11715.mo2233();
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f11715 == null || !this.f11715.mo2254(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f11715 == null || !this.f11715.mo2263(i, keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.f11715 != null) {
            this.f11715.mo2236(z);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        return this.f11715 != null && this.f11715.mo2231();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, o.qO.AbstractC0170
    public qO.Cif getEpisodeRowListener() {
        if (this.f11715 == null) {
            return null;
        }
        return this.f11715.mo2230();
    }

    @Override // o.AbstractC0496.Cif, com.netflix.mediaclient.ui.player.IPlayerFragment
    public AbstractC0496.iF ab_() {
        if (this.f11715 == null) {
            return null;
        }
        return this.f11715.ab_();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, o.C1305Ag.AbstractC0066
    public void onPlayVerified(boolean z, PlayVerifierVault playVerifierVault) {
        if (this.f11715 != null) {
            this.f11715.mo2244(z, playVerifierVault);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12565(int i) {
        int i2 = getResources().getConfiguration().orientation;
        if (Build.VERSION.SDK_INT == 27 && tP.Cif.m10990() && i2 != i) {
            setRequestedOrientation(i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        m12565(7);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m12565(6);
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        if (this.f11715 != null) {
            return this.f11715.m2227();
        }
        oX oXVar = (oX) getIntent().getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT);
        if (oXVar == null) {
            return new oB("PlayerActivity");
        }
        return oXVar;
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (C1317As.m3742(NetflixApplication.getInstance()) && this.f11715 != null) {
            dismissAllVisibleDialog();
            this.f11715.mo2228();
        }
        super.onUserLeaveHint();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m12566(Context context) {
        context.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.END_PIP"));
    }
}
