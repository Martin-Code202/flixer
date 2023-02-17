package o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.List;
import o.C0567;
/* renamed from: o.zq  reason: case insensitive filesystem */
public class ActivityC2383zq extends NetflixActivity {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final SparseArray<SparseIntArray> f12902 = new SparseArray<>(2);

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f12903;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f12904;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f12905;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C2059ph f12906;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private View f12907;

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<? extends AbstractC2089qj> f12908;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C0810 f12909;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0336 f12910;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f12911;

    /* renamed from: ͺ  reason: contains not printable characters */
    private TextView f12912;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f12913;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f12914;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final AdapterView.OnItemClickListener f12915 = new AdapterView.OnItemClickListener() { // from class: o.zq.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ActivityC2383zq.this.f12908 == null || i > ActivityC2383zq.this.f12908.size()) {
                C1283.m16854("ProfileSelectionActivity", "Invalid profiles set");
            } else if (i == ActivityC2383zq.this.f12908.size()) {
                C1362Ch.m4421(null, ActivityC2383zq.this.getUiScreen().f4084);
                ActivityC2383zq.this.startActivity(DialogInterface$OnClickListenerC2376zj.m13690(ActivityC2383zq.this, (String) null));
            } else if (!ActivityC2383zq.this.f12903) {
                AbstractC2089qj qjVar = (AbstractC2089qj) ActivityC2383zq.this.f12908.get(i);
                ActivityC2383zq.this.f12918 = Logger.INSTANCE.m142(new C0726(qjVar.getProfileGuid()));
                C1362Ch.m4420((UserActionLogging.CommandName) null, ActivityC2383zq.this.getUiScreen().f4084, qjVar.getProfileGuid(), UserActionLogging.RememberProfile.userChoseToRemember);
                ActivityC2383zq.this.m13752(qjVar);
                ActivityC2383zq.this.invalidateOptionsMenu();
            } else if (((AbstractC2089qj) ActivityC2383zq.this.f12908.get(i)).getProfileGuid() == null) {
                ActivityC2383zq.this.handleUserAgentErrors(AbstractC0367.f13241);
            } else {
                AbstractC2089qj qjVar2 = (AbstractC2089qj) ActivityC2383zq.this.f12908.get(i);
                C1362Ch.m4414(null, ActivityC2383zq.this.getUiScreen().f4084);
                Logger.INSTANCE.m142(new C0630(qjVar2.getProfileGuid(), C1300Ac.m3539(qjVar2)));
                ActivityC2383zq.this.startActivity(DialogInterface$OnClickListenerC2376zj.m13690(ActivityC2383zq.this, ((AbstractC2089qj) ActivityC2383zq.this.f12908.get(i)).getProfileGuid()));
            }
        }
    };

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private String f12916;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0616 f12917;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Long f12918;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f12919;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final C0567.Cif f12920 = new C0567.Cif() { // from class: o.zq.5
        @Override // o.C0567.Cif
        public void N_() {
        }
    };

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(1, 1);
        sparseIntArray.put(2, 2);
        sparseIntArray.put(3, 2);
        sparseIntArray.put(4, 2);
        f12902.put(1, sparseIntArray);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray2.put(1, 2);
        sparseIntArray2.put(2, 3);
        sparseIntArray2.put(3, 3);
        sparseIntArray2.put(4, 3);
        f12902.put(2, sparseIntArray2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m13725(Context context) {
        Intent r2 = m13737(context);
        r2.putExtra("app_was_restarted", true);
        return r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m13731(Context context) {
        Intent r1 = m13725(context);
        r1.addFlags(268435456);
        return r1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Intent m13737(Context context) {
        return m13743(context, false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m13743(Context context, boolean z) {
        Intent addFlags = new Intent(context, m13726()).addFlags(131072);
        if (z) {
            addFlags.putExtra("extra_edit_mode", true);
        }
        return addFlags;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Class<?> m13726() {
        return NetflixApplication.getInstance().m254() ? ActivityC2377zk.class : ActivityC2383zq.class;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m13742(Activity activity, AppView appView) {
        if (appView == null) {
            return m13737(activity);
        }
        return m13737(activity).putExtra("extra_destination", appView.name());
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            PerformanceProfiler.INSTANCE.m663(Sessions.PROFILE_GATE);
        }
        this.f12919 = getResources().getDimensionPixelSize(R.dimen.profile_avatar_view_group_width);
        setContentView(R.layout.profile_selection_activity);
        this.f12917 = new C0616(findViewById(R.id.profile_selection_parent), this.f12920);
        this.f12907 = findViewById(R.id.profile_selection_content);
        this.f12912 = (TextView) findViewById(R.id.profile_selection_title);
        this.f12909 = (C0810) findViewById(R.id.profile_selection_grid_view);
        this.f12909.setOnItemClickListener(this.f12915);
        this.f12909.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.zq.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ActivityC2383zq.this.m13739();
            }
        });
        this.f12916 = getIntent().getStringExtra("extra_destination");
        if (bundle == null) {
            m13724();
            this.f12914 = getIntent().getBooleanExtra("extra_start_kids_bool", false);
            this.f12903 = getIntent().getBooleanExtra("extra_edit_mode", false);
            this.f12904 = this.f12903;
            m13751();
        } else {
            this.f12905 = bundle.getBoolean("is_loading", false);
            this.f12903 = bundle.getBoolean("is_profile_edit_mode", false);
            C1283.m16848("ProfileSelectionActivity", "Recovered state, isLoading: %b", Boolean.valueOf(this.f12905));
            m13751();
        }
        m13748();
        m13734(getIntent());
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        super.finish();
        PerformanceProfiler.INSTANCE.m672(Sessions.PROFILE_GATE);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zq.2
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                ActivityC2383zq.this.f12906 = phVar;
                ActivityC2383zq.this.m13740(true);
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                ActivityC2383zq.this.f12906 = null;
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1283.m16848("ProfileSelectionActivity", "Saving loading state: %b", Boolean.valueOf(this.f12905));
        bundle.putBoolean("is_loading", this.f12905);
        bundle.putBoolean("is_profile_edit_mode", this.f12903);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13748() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13740(boolean z) {
        List<? extends AbstractC2089qj> r5 = this.f12906.m9833();
        if (r5 == null) {
            C1283.m16865("ProfileSelectionActivity", "No profiles found for user!");
            this.f12906.m9825().mo1515().mo5713(new IllegalStateException("No profiles found for user!"));
            return;
        }
        this.f12908 = r5;
        this.f12910 = new C0336();
        this.f12909.setAdapter((ListAdapter) this.f12910);
        m13732();
        m13745();
        if (this.f12905) {
            C1283.m16854("ProfileSelectionActivity", "We're in loading state - showing loading view");
            m13729(false);
        }
        C1283.m16848("ProfileSelectionActivity", "shouldAutoSelectProfile: %s, shouldStartKids: %s", Boolean.valueOf(z), Boolean.valueOf(this.f12914));
        if (z && this.f12914) {
            int i = 0;
            AbstractC2089qj qjVar = null;
            for (AbstractC2089qj qjVar2 : this.f12906.m9833()) {
                if (qjVar2.isKidsProfile()) {
                    qjVar = qjVar2;
                    i++;
                }
            }
            if (i == 1) {
                C1283.m16848("ProfileSelectionActivity", "Found one Kids profile - switching to: %s", qjVar.getProfileName());
                m13752(qjVar);
                return;
            }
            C1283.m16848("ProfileSelectionActivity", "Num Kids profiles found: %d", Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13732() {
        int i = f12902.get(AD.m3284((Context) this)).get(AD.m3290((Context) this));
        int count = this.f12910.getCount();
        int i2 = count > 3 ? count - 2 : count;
        this.f12913 = Math.min(i2, i);
        C1283.m16848("ProfileSelectionActivity", "max cols: %d, limited cols: %d, num cols: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f12913));
        this.f12909.setNumColumns(this.f12913);
        m13739();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13739() {
        int r5 = AD.m3317(this);
        int i = this.f12919 * this.f12913;
        int i2 = (r5 - i) / 2;
        C1283.m16848("ProfileSelectionActivity", "screen: %d, grid: %d, padding: %d", Integer.valueOf(r5), Integer.valueOf(i), Integer.valueOf(i2));
        if (!BX.m3957()) {
            this.f12909.setPadding(i2, 0, 0, 0);
        } else {
            this.f12909.setPadding(0, 0, i2, 0);
        }
        m13733(i2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13733(int i) {
        View findViewById = findViewById(R.id.profile_selection_promo_view);
        if (C1339Bl.m4051(this, "user_profile_was_selected", false) || this.f12908 == null || this.f12908.size() > 1) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        int dimension = (int) ((((float) this.f12919) - getResources().getDimension(R.dimen.profile_promo_view_avatar_group_width)) / 2.0f);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).setMargins(i + dimension, 0, i + dimension, (int) getResources().getDimension(R.dimen.double_padding));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13745() {
        C1283.m16846("ProfileSelectionActivity", "Showing content view...");
        this.f12917.mo14663(false);
        this.f12907.setEnabled(true);
        this.f12909.setEnabled(true);
        if (this.f12907.getVisibility() != 0) {
            BQ.m3914(this.f12907, false);
        } else if (this.f12907.getAlpha() < 1.0f) {
            this.f12907.animate().alpha(1.0f).setDuration(150).start();
        }
        m13730(false, false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13729(boolean z) {
        C1283.m16846("ProfileSelectionActivity", "Showing loading view...");
        this.f12917.mo14570(false);
        this.f12907.setEnabled(false);
        this.f12909.setEnabled(false);
        if (z) {
            this.f12907.animate().alpha(0.2f).setDuration(400).start();
        } else {
            this.f12907.setAlpha(0.2f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileReadyToSelect() {
        C1283.m16846("ProfileSelectionActivity", "handleProfileReadyToSelect()");
        this.f12905 = false;
        m13740(false);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileActivated() {
        long nanoTime = System.nanoTime();
        C1283.m16854("ProfileSelectionActivity", "Restarting app, time: " + nanoTime);
        finishAllActivities(this);
        startActivity(ActivityC2187tq.m11247(this, "handleProfileActivated() " + nanoTime).addFlags(67108864));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfileSelectionResult(int i, String str) {
        StatusCode r3 = StatusCode.m264(i);
        if (r3 == StatusCode.OK) {
            C1283.m16846("ProfileSelectionActivity", "Profile selection was successful.  Parent class should finish this activity in a moment...");
            C1362Ch.m4418(IClientLogging.CompletionReason.success, IClientLogging.ModalView.homeScreen, (UIError) null);
            C0726.m16815(this.f12918);
            C1339Bl.m4048((Context) this, "user_profile_was_selected", true);
            return;
        }
        NetflixStatus netflixStatus = new NetflixStatus(r3);
        C0510 r5 = C1300Ac.m3532(netflixStatus);
        netflixStatus.m312(str);
        netflixStatus.m311(true);
        Logger.INSTANCE.m147(C0726.m14366(this.f12918, r5));
        C1362Ch.m4418(IClientLogging.CompletionReason.failed, getUiScreen().f4084, AbstractC1358Cd.m4353(netflixStatus, str, ActionOnUIError.displayedError));
        m13727(netflixStatus, str);
        handleUserAgentErrors(netflixStatus, false);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleNetworkErrorDialog() {
        if (this.f12908 == null || this.f12908.size() <= 1) {
            C1283.m16854("ProfileSelectionActivity", "finish onhandleProfileSelectionResult failed");
            finishAllActivities(this);
            return;
        }
        C1283.m16854("ProfileSelectionActivity", "relaunch onhandleProfileSelectionResult failed");
        finishAllActivities(this);
        startActivity(ActivityC2187tq.m11247(this, "handleNetwotkErrorDialog()"));
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return !this.f12903;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return !this.f12903;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        if (!this.f12905 && !this.f12903) {
            super.onCreateOptionsMenu(menu, menu2);
            MenuItem add = menu.add(0, R.id.edit_profile_action_bar_pen, 0, getString(R.string.profile_edit_actionbar_hint));
            add.setShowAsAction(1);
            add.setIcon(R.drawable.ic_profile_actionbar_edit);
            add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.zq.3
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    ActivityC2383zq.this.f12903 = !ActivityC2383zq.this.f12903;
                    ActivityC2383zq.this.m13751();
                    return true;
                }
            });
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13730(boolean z, boolean z2) {
        String str;
        NetflixActionBar.iF.AbstractC0010 r3 = getActionBarStateBuilder().mo399(!z && !this.f12903).mo396((!z2 && z) || this.f12903).mo403(this.f12903);
        if (this.f12903) {
            r3.mo394((CharSequence) getResources().getString(R.string.profile_edit_actionbar_title));
            str = getResources().getString(R.string.profile_edit_actionbar_title);
        } else {
            r3.mo401(NetflixBottomNavBar.m416() ? NetflixActionBar.LogoType.CENTERED : NetflixActionBar.LogoType.START_ALIGNED);
            str = getResources().getString(R.string.accessibility_switch_profile_title);
        }
        getNetflixActionBar().m355(r3.mo392());
        setTitle(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m13751() {
        m13730(false, false);
        C1316Ar.m3739(getApplicationContext(), getTitle().toString());
        this.f12912.animate().alpha(this.f12903 ? 0.0f : 1.0f).setDuration(400).start();
        for (int i = 0; i < this.f12909.getChildCount(); i++) {
            View childAt = this.f12909.getChildAt(i);
            if (childAt == null) {
                C1283.m16850("ProfileSelectionActivity", "Something weird happened: null grid child view!");
            } else if (i < this.f12908.size()) {
                childAt.findViewById(R.id.top_edit_img).setVisibility(this.f12903 ? 0 : 8);
                m13735(childAt, R.id.profile_avatar_img);
            }
        }
        invalidateOptionsMenu();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13735(View view, int i) {
        view.findViewById(i).animate().alpha(this.f12903 ? 0.2f : 1.0f).setDuration(400).start();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m13752(AbstractC2089qj qjVar) {
        if (this.f12906 == null || !this.f12906.mo9519()) {
            C1283.m16850("ProfileSelectionActivity", "Manager is not ready");
            Logger.INSTANCE.m147(C0726.m14366(this.f12918, C1300Ac.m3532(AbstractC0367.f13255)));
            C1362Ch.m4418(IClientLogging.CompletionReason.failed, getUiScreen().f4084, AbstractC1358Cd.m4353(AbstractC0367.f13255, "", ActionOnUIError.handledSilently));
            return;
        }
        AbstractC2089qj r3 = this.f12906.m9826();
        if (r3 != null && !r3.isKidsProfile()) {
            getSupportActionBar().hide();
        }
        if (!this.f12911 && this.f12916 == null && r3 != null && C1349Bv.m4126(r3.getProfileGuid(), qjVar.getProfileGuid())) {
            C1283.m16854("ProfileSelectionActivity", "Selected profile is the same as the current one - skipping profile change...");
            C1362Ch.m4418(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.homeScreen, AbstractC1358Cd.m4353(AbstractC0367.f13241, "", ActionOnUIError.handledSilently));
            Logger.INSTANCE.m147(C0726.m14366(this.f12918, C1300Ac.m3532(AbstractC0367.f13241)));
            startActivity(ActivityC2153sl.m10782(this));
            finish();
        } else if (!ConnectivityUtils.m2954(this)) {
            C1283.m16865("ProfileSelectionActivity", "Network is NOT connected, prevent action and report to user!");
            handleUserAgentErrors(AbstractC0367.f13238, false);
            C1362Ch.m4418(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.homeScreen, AbstractC1358Cd.m4353(AbstractC0367.f13238, "", ActionOnUIError.displayedError));
            Logger.INSTANCE.m147(C0726.m14366(this.f12918, C1300Ac.m3532(AbstractC0367.f13238)));
        } else {
            this.f12905 = true;
            m13729(true);
            this.f12906.m9801(qjVar.getProfileGuid());
            this.f12911 = false;
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (!handleBackPressed()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (!this.f12903 || this.f12904) {
            return false;
        }
        this.f12903 = false;
        m13751();
        return true;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f12905 || this.f12908 == null || this.f12908.size() <= 0;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.profilesGate;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfilesListUpdated() {
        this.f12908 = this.f12906.m9833();
        this.f12910.notifyDataSetChanged();
        this.f12909.setAdapter((ListAdapter) this.f12910);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zq$ˋ  reason: contains not printable characters */
    public class C0336 extends BaseAdapter {
        private C0336() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ActivityC2383zq.this.f12908.size();
            return size < 5 ? size + 1 : size;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC2089qj getItem(int i) {
            if (i < ActivityC2383zq.this.f12908.size()) {
                return (AbstractC2089qj) ActivityC2383zq.this.f12908.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ActivityC2383zq.this.getLayoutInflater().inflate(R.layout.profile_selection_avatar_view, viewGroup, false);
                view.setTag(new C0335((C0522) view.findViewById(R.id.profile_avatar_img), (TextView) view.findViewById(R.id.profile_avatar_title), view.findViewById(R.id.top_edit_img)));
            }
            C0335 r7 = (C0335) view.getTag();
            AbstractC2089qj r8 = getItem(i);
            if (i == ActivityC2383zq.this.f12908.size()) {
                r7.f12927.setImageResource(R.drawable.profile_selection_add);
                r7.f12928.setText(R.string.profile_add_button);
                r7.f12926.setVisibility(8);
            } else {
                r7.f12928.setText(r8.getProfileName());
                NetflixActivity.getImageLoader(ActivityC2383zq.this).mo3057(r7.f12927, r8.getAvatarUrl(), AssetType.profileAvatar, null, StaticImgConfig.DARK, true);
                r7.f12926.setVisibility(ActivityC2383zq.this.f12903 ? 0 : 8);
                r7.f12927.setAlpha(ActivityC2383zq.this.f12903 ? 0.2f : 1.0f);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ActivityC2383zq.this.m13732();
        }
    }

    /* renamed from: o.zq$ˊ  reason: contains not printable characters */
    static class C0335 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final View f12926;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C0522 f12927;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final TextView f12928;

        public C0335(C0522 r1, TextView textView, View view) {
            this.f12927 = r1;
            this.f12928 = textView;
            this.f12926 = view;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m13724() {
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("extra_start_kids_bool", false));
        Boolean valueOf2 = Boolean.valueOf(getIntent().getBooleanExtra("extra_stop_kids_bool", false));
        String stringExtra = getIntent().getStringExtra("extra_kids_door_name");
        if ((valueOf.booleanValue() || valueOf2.booleanValue()) && C1349Bv.m4107(stringExtra)) {
            C1300Ac.m3537(new C1200());
            C1364Cj.m4442(UIViewLogging.UIViewCommandName.valueOf(stringExtra), IClientLogging.ModalView.homeScreen, (C1359Ce) null);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13727(Status status, String str) {
        Logger.INSTANCE.m134(C0634.class.getSimpleName(), C1300Ac.m3532(status));
        Logger.INSTANCE.m142(new C0634());
        C1362Ch.m4388(getUiScreen().f4084, IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, str, ActionOnUIError.displayedError));
        C1362Ch.m4423(null, getUiScreen().f4084);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13734(Intent intent) {
        if (intent != null) {
            this.f12911 = intent.getBooleanExtra("app_was_restarted", false);
            C1283.m16863("ProfileSelectionActivity", "Got new value for 'app was restorted' flag: %b", Boolean.valueOf(this.f12911));
        }
    }
}
