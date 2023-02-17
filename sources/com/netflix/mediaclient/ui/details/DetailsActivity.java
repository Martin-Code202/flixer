package com.netflix.mediaclient.ui.details;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import o.AJ;
import o.AbstractActivityC0360;
import o.AbstractC0367;
import o.AbstractC0459;
import o.C0567;
import o.C1004;
import o.C1087;
import o.C1276;
import o.C1283;
import o.C1300Ac;
import o.C1317As;
import o.C1328Ba;
import o.C1359Ce;
import o.C1362Ch;
import o.C1364Cj;
import o.C2059ph;
import o.C2114rc;
import o.C2136ry;
import o.oB;
import o.oN;
import o.oP;
import o.oV;
import o.oX;
import o.pE;
import o.qH;
import o.qK;
import o.qW;
import o.uM;
public abstract class DetailsActivity extends AbstractActivityC0360 implements C0567.Cif, oV, qK {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static boolean f2879;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean f2880;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean f2881;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Action f2882;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f2883;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected oX f2884 = new oB("DetailsActivity");

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final BroadcastReceiver f2885 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.details.DetailsActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!C1317As.m3750(DetailsActivity.this)) {
                C1283.m16846("DetailsActivity", "Received request to reload data");
                if (DetailsActivity.this.getServiceManager() != null && DetailsActivity.this.getServiceManager().mo9519()) {
                    DetailsActivity.this.m1629();
                }
            }
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    protected String f2886;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f2887;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected int f2888 = -1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f2889;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C2059ph f2890;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f2891;

    public enum Action {
        AddToMyList,
        RemoveFromMyList,
        Download,
        Like,
        Dislike
    }

    public interface If {
        void P_();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public abstract VideoType mo1643();

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m1631(Context context) {
        context.sendBroadcast(new Intent("com.netflix.mediaclient.ui.login.ACTION_FINISH_DETAILS_ACTIVITIES"));
    }

    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f2889 = bundle.getBoolean("notification_beacon_sent");
        } else {
            m1638();
        }
        m1650();
        this.f2882 = (Action) getIntent().getSerializableExtra("extra_action");
        this.f2887 = getIntent().getStringExtra("extra_action_token");
        m1648((oX) getIntent().getParcelableExtra(NetflixActivity.EXTRA_PLAY_CONTEXT));
        this.f2888 = getIntent().getIntExtra("extra_model_view_id", -1);
        setTitle(getResources().getString(R.string.accessibility_details_activity_title, getIntent().getStringExtra("extra_video_title")));
        super.onCreate(bundle);
        m1625();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r2) {
        r2.mo396(false);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m1638() {
        m1645();
        m1621();
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private void m1621() {
        if (f2879) {
            C1283.m16854("DetailsActivity", "Received a start DP TTR session while already tracking another");
            m1647(IClientLogging.CompletionReason.canceled, null);
        }
        f2879 = true;
        startRenderNavigationLevelSession();
        PerformanceProfiler.INSTANCE.m663(Sessions.DP_TTR);
        runWhenManagerIsReady(new NetflixActivity.If() { // from class: com.netflix.mediaclient.ui.details.DetailsActivity.5
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                DetailsActivity.this.setupInteractiveTracking(new qH.C0166(), DetailsActivity.this.m1649());
                NetflixActivity.getImageLoader(DetailsActivity.this).mo3055(qH.C0166.f9444).mo9573();
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1647(IClientLogging.CompletionReason completionReason, Status status) {
        if (!f2879) {
            C1276.m16820().mo5725("Received a end DP TTR session while not tracking any");
        }
        if (f2881) {
            f2880 = true;
            C1283.m16854("DetailsActivity", "Defer DP_TTR end until DP_TTI is complete.");
            return;
        }
        f2879 = false;
        endRenderNavigationLevelSession(completionReason, status);
        PerformanceProfiler.INSTANCE.m665(Sessions.DP_TTR, m1646(completionReason));
        flushPerformanceProfilerEvents();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m1645() {
        if (f2881) {
            C1283.m16854("DetailsActivity", "Received a start DP TTI session while already tracking another");
            m1639(IClientLogging.CompletionReason.canceled);
        }
        f2881 = true;
        PerformanceProfiler.INSTANCE.m663(Sessions.DP_TTI);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1639(IClientLogging.CompletionReason completionReason) {
        if (!f2881) {
            C1276.m16820().mo5725("Received a end DP TTI session while not tracking any");
        }
        f2881 = false;
        PerformanceProfiler.INSTANCE.m665(Sessions.DP_TTI, m1646(completionReason));
        logMetadataRenderedEvent(false);
        if (f2880) {
            f2880 = false;
            m1647(completionReason, null);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Map<String, String> m1646(IClientLogging.CompletionReason completionReason) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", completionReason.name());
        if (mo1643() != null) {
            hashMap.put("videoType", mo1643().name());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            m1624();
        }
        super.onDestroy();
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m1624() {
        if (f2881) {
            m1639(IClientLogging.CompletionReason.canceled);
        }
        if (f2879) {
            m1647(IClientLogging.CompletionReason.canceled, null);
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        m1624();
        super.finish();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("notification_beacon_sent", this.f2889);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        uM.m11540(this, menu);
        AJ.m3368(menu, this);
        this.f2891 = true;
        C2114rc.m10347(this, menu);
        super.onCreateOptionsMenu(menu, menu2);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (AJ.m3366(menuItem, this)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        C1283.m16850("DetailsActivity", "performUpAction");
        if (!C1087.m16179() || !getServiceManager().m9789() || isTaskRoot()) {
            super.performUpAction();
            return;
        }
        C1364Cj.m4442(UIViewLogging.UIViewCommandName.upButton, getUiScreen().f4084, getDataContext());
        C1300Ac.m3533();
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public oN.AbstractC0161 m1649() {
        return new oN.AbstractC0161() { // from class: com.netflix.mediaclient.ui.details.DetailsActivity.3
            @Override // o.oN.AbstractC0161
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo1655(IClientLogging.CompletionReason completionReason) {
                if (DetailsActivity.f2879) {
                    DetailsActivity.this.m1647(completionReason, null);
                }
            }
        };
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1283.m16846("DetailsActivity", "ServiceManager ready");
        this.f2890 = phVar;
        if (this.f2891) {
            invalidateOptionsMenu();
        }
        setupInteractiveTracking(new qH.C0166(), m1649());
        ((oV) mo10792()).onManagerReady(phVar, status);
        Fragment r2 = m14001();
        if (r2 != null) {
            ((oV) r2).onManagerReady(phVar, status);
        }
        if (!this.f2889) {
            this.f2889 = true;
            C1328Ba.m3985(this.f2890, getIntent());
        }
        m1628();
        m1644();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m1644() {
        setLoadingStatusCallback(new AbstractC0459.AbstractC0460() { // from class: com.netflix.mediaclient.ui.details.DetailsActivity.2
            @Override // o.AbstractC0459.AbstractC0460
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo1654(Status status) {
                IClientLogging.CompletionReason completionReason = status.mo298() ? IClientLogging.CompletionReason.success : IClientLogging.CompletionReason.failed;
                if (DetailsActivity.f2881) {
                    DetailsActivity.this.m1639(completionReason);
                }
                if (status.mo301() && DetailsActivity.f2879) {
                    DetailsActivity.this.m1647(completionReason, status);
                }
                DetailsActivity.this.setLoadingStatusCallback(null);
                if (!DetailsActivity.this.isFinishing()) {
                    C1283.m16854("DetailsActivity", "DetailsPage is loaded, reporting navigate.ended for movieDetails");
                    C1362Ch.m4388(DetailsActivity.this.getUiScreen().f4084, completionReason, (UIError) null);
                    if (status.mo301()) {
                        DetailsActivity.this.handleFalkorAgentErrors(status);
                    }
                }
            }
        });
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        C1283.m16865("DetailsActivity", "ServiceManager unavailable");
        ((oV) mo10792()).onManagerUnavailable(phVar, status);
        Fragment r2 = m14001();
        if (r2 != null) {
            ((oV) r2).onManagerUnavailable(phVar, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void m1650() {
        this.f2886 = getIntent().getStringExtra(NetflixActivity.EXTRA_VIDEO_ID);
        this.f2883 = getIntent().getStringExtra("extra_episode_id");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1642(String str, String str2) {
        this.f2886 = str;
        this.f2883 = str2;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m1628() {
        if (m1637() == null) {
            C1283.m16854("DetailsActivity", "No action task specified");
            return;
        }
        if (Action.AddToMyList.equals(m1637())) {
            C1283.m16854("DetailsActivity", "Action add to my list started");
            m1622();
        } else if (Action.RemoveFromMyList.equals(m1637())) {
            C1283.m16854("DetailsActivity", "Action remove from my list started");
            m1626();
        } else if (Action.Download.equals(m1637())) {
            C1283.m16854("DetailsActivity", "Action download started");
            m1630();
        } else if (m1637() == Action.Like) {
            C1283.m16854("DetailsActivity", "Action like started");
            m1627(2);
        } else if (m1637() == Action.Dislike) {
            C1283.m16854("DetailsActivity", "Action dislike started");
            m1627(1);
        }
        this.f2882 = null;
        this.f2887 = null;
        setIntent(null);
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private void m1625() {
        registerReceiverLocallyWithAutoUnregister(this.f2885, "com.netflix.mediaclient.intent.action.DETAIL_PAGE_REFRESH");
        registerFinishReceiverWithAutoUnregister("com.netflix.mediaclient.ui.login.ACTION_FINISH_DETAILS_ACTIVITIES");
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public int m1652() {
        int trackId = this.f2884.getTrackId();
        if (trackId <= 0) {
            C1276.m16820().mo5725("DetailsActivity invalid trackid!");
        }
        return trackId;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public C2136ry m1653() {
        Fragment r4 = mo10792();
        String str = "";
        if (r4 instanceof qW) {
            str = ((qW) r4).m9988();
        }
        return new C2136ry(m1634(), str, mo1643(), mo1635());
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m1622() {
        C1362Ch.m4389((UserActionLogging.CommandName) null, getUiScreen().f4084);
        this.f2890.m9764().mo9469(this.f2886, mo1643(), m1652(), this.f2887, new C0032("DetailsActivity"));
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m1626() {
        C1362Ch.m4422(null, getUiScreen().f4084);
        this.f2890.m9764().mo9483(this.f2886, mo1643(), this.f2887, new C0032("DetailsActivity"));
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m1630() {
        C1283.m16854("DetailsActivity", "handleAddToDownloads");
        VideoType r3 = mo1643();
        if (r3 == VideoType.SHOW) {
            r3 = VideoType.EPISODE;
        }
        this.f2890.m9832().mo7141(this.f2883, r3, mo1635());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1627(int i) {
        C1283.m16851("DetailsActivity", "handleRateTitle %s", Integer.valueOf(i));
        if (i == 2 || i == 1) {
            final String stringExtra = getIntent().getStringExtra("extra_video_title");
            this.f2890.m9764().mo9468(m1634(), mo1643(), i, m1652(), new oP("DetailsActivity") { // from class: com.netflix.mediaclient.ui.details.DetailsActivity.4
                @Override // o.oP, o.oU
                public void onVideoRatingSet(pE pEVar, Status status) {
                    String str;
                    super.onVideoRatingSet(pEVar, status);
                    if (status.mo298()) {
                        str = DetailsActivity.this.getString(R.string.label_ok_rate_deep_link, new Object[]{stringExtra});
                    } else {
                        str = DetailsActivity.this.getString(R.string.label_error_rate_deep_link);
                    }
                    C1004.m15961(DetailsActivity.this, str, 1);
                }
            });
            return;
        }
        C1276.m16820().mo5725(String.format(Locale.US, "Only Thumbs.THUMBS_UP or Thumbs.THUMBS_DOWN are allowed by deeplink action, got %s", Integer.valueOf(i)));
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public String m1651() {
        return this.f2883;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public String m1634() {
        return this.f2886;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1641(String str) {
        this.f2886 = str;
    }

    @Override // o.C0567.Cif
    public void N_() {
        m1632(mo10792());
        m1632(m14001());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1632(Fragment fragment) {
        if (fragment != null && (fragment instanceof C0567.Cif)) {
            C1283.m16846("DetailsActivity", "Found frag to execute retry request...");
            ((C0567.Cif) fragment).N_();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m1629() {
        m1633(mo10792());
        m1633(m14001());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1633(Fragment fragment) {
        if (fragment != null && (fragment instanceof If)) {
            C1283.m16846("DetailsActivity", "Found frag to execute reload request...");
            ((If) fragment).P_();
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1648(oX oXVar) {
        if (oXVar != null) {
            this.f2884 = oXVar;
        } else {
            C1276.m16820().mo5725("DetailsActivity setting playcontext with null");
        }
    }

    @Override // o.qK
    /* renamed from: ʼ  reason: contains not printable characters */
    public oX mo1635() {
        return this.f2884;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.movieDetails;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public C1359Ce getDataContext() {
        return new C1359Ce(this.f2884, this.f2886);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public Action m1637() {
        return this.f2882;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1640(Action action, String str) {
        this.f2882 = action;
        this.f2887 = str;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public String m1636() {
        return this.f2887;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.details.DetailsActivity$ˋ  reason: contains not printable characters */
    public class C0032 extends oP {
        public C0032(String str) {
            super(str);
        }

        @Override // o.oP, o.oU
        public void onQueueAdd(Status status) {
            super.onQueueAdd(status);
            int i = R.string.label_error_adding_to_list;
            if (AbstractC0367.f13235 == status) {
                i = R.string.label_ok_add_to_my_list_deep_link;
            } else if (status.mo302() == StatusCode.ALREADY_IN_QUEUE) {
                i = R.string.label_warning_add_to_my_list_deep_link_title_exist;
            } else if (status.mo302() == StatusCode.NOT_VALID) {
                i = R.string.label_error_add_to_my_list_deep_link;
            }
            C1004.m15958(DetailsActivity.this, i, 1);
        }

        @Override // o.oP, o.oU
        public void onQueueRemove(Status status) {
            super.onQueueRemove(status);
            int i = R.string.label_error_remove_from_list_deep_link;
            if (AbstractC0367.f13235 == status) {
                i = R.string.label_ok_remove_from_my_list_deep_link;
            } else if (status.mo302() == StatusCode.NOT_IN_QUEUE) {
                C1283.m16865("DetailsActivity", "It was already removed");
                i = R.string.label_ok_remove_from_my_list_deep_link;
            }
            C1004.m15958(DetailsActivity.this, i, 1);
        }
    }
}
