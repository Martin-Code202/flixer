package o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.OfflineFragment;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.ArrayList;
public class vH extends AbstractActivityC0360 implements qK {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected ArrayList<Intent> f11182 = new ArrayList<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected Intent f11183 = null;

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.f11183 = (Intent) bundle.getParcelable("last_intent");
            if (this.f11183 != null) {
                setIntent(this.f11183);
            }
            this.f11182.clear();
            ArrayList<Intent> parcelableArrayList = bundle.getParcelableArrayList("intent_stack");
            if (parcelableArrayList != null) {
                this.f11182 = parcelableArrayList;
            }
        }
        super.onCreate(bundle);
        if (NetflixBottomNavBar.m416()) {
            tH tHVar = new tH(this, bundle);
            this.fragmentHelper = tHVar;
            setFragmentHelper(tHVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m11935();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m11931() {
        this.fragmentHelper.mo10709();
        while (!this.f11182.isEmpty()) {
            handleBackPressed();
        }
        ((OfflineFragment) mo10792()).m2217();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Intent m11936(Activity activity) {
        return m11930(activity, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m11930(Context context, boolean z) {
        return m11928(context, null, z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m11928(Context context, String str, boolean z) {
        Intent r1 = m11932(context);
        if (C1349Bv.m4107(str)) {
            r1.putExtra("playable_id", str);
        }
        if (NetflixBottomNavBar.m416()) {
            if (z) {
                r1.addFlags(268566528);
            } else {
                r1.addFlags(131072);
            }
        } else if (z) {
            r1.addFlags(872415232);
        }
        return r1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Intent m11937(Context context, String str, String str2, boolean z) {
        Intent r1 = m11932(context);
        if (C1349Bv.m4107(str)) {
            r1.putExtra("title_id", str);
        }
        if (C1349Bv.m4107(str2)) {
            r1.putExtra("profile_id", str2);
        }
        if (NetflixBottomNavBar.m416()) {
            if (z) {
                r1.addFlags(268566528);
            } else {
                r1.addFlags(131072);
            }
        } else if (z) {
            r1.addFlags(872415232);
        }
        return r1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m11932(Context context) {
        return new Intent(context, m11934());
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static Class m11934() {
        return NetflixApplication.getInstance().m254() ? vU.class : vH.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return OfflineFragment.m2204();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        if (NetflixBottomNavBar.m416()) {
            return R.layout.base_tabs_activity;
        }
        return R.layout.offline_activity;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("last_intent", getIntent());
        bundle.putParcelableArrayList("intent_stack", this.f11182);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intent intent2 = getIntent();
        super.onNewIntent(intent);
        closeAllPopupMenus();
        if (m11929()) {
            m11935();
        }
        if (!NetflixBottomNavBar.m411(intent) && !this.fragmentHelper.mo10702(intent)) {
            this.fragmentHelper.mo10709();
            setIntent(intent);
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("primary");
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            OfflineFragment offlineFragment = (OfflineFragment) mo10189();
            if (!(findFragmentByTag instanceof OfflineFragment) || !((OfflineFragment) findFragmentByTag).m2212()) {
                this.f11182.add(intent2);
                m11938(findFragmentByTag, offlineFragment, false);
                beginTransaction.replace(R.id.primary_fragment, offlineFragment, "primary");
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                getSupportFragmentManager().executePendingTransactions();
                m13998(offlineFragment);
            } else if (intent.hasExtra("title_id")) {
                ((OfflineFragment) mo10792()).m2220();
            } else {
                while (!this.f11182.isEmpty()) {
                    this.f11182.remove(this.f11182.size() - 1);
                    getSupportFragmentManager().popBackStackImmediate();
                }
                m13998(getSupportFragmentManager().findFragmentByTag("primary"));
                ((OfflineFragment) mo10792()).m2220();
            }
            O_();
            invalidateOptionsMenu();
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.offlineShows;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasBottomNavBar() {
        return NetflixBottomNavBar.m416();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.vH.5
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                if (!C1317As.m3750(vH.this)) {
                    ((OfflineFragment) vH.this.mo10792()).onManagerReady(phVar, status);
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                if (!C1317As.m3750(vH.this)) {
                    Log.e("nf_offline", "NetflixService is NOT available!");
                    ((OfflineFragment) vH.this.mo10792()).onManagerUnavailable(phVar, status);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        super.onCreateOptionsMenu(menu, menu2);
        if (m11929()) {
            if (((OfflineFragment) mo10792()).m2216() > 0) {
                MenuItem add = menu.add(R.string.dialog_remove_downloads_title);
                add.setIcon(R.drawable.ic_offline_delete);
                add.setShowAsAction(2);
                add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.vH.2
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (!(vH.this.mo10792() instanceof OfflineFragment)) {
                            return true;
                        }
                        OfflineFragment offlineFragment = (OfflineFragment) vH.this.mo10792();
                        int r4 = offlineFragment.m2216();
                        String r5 = offlineFragment.m2214();
                        offlineFragment.m2218();
                        offlineFragment.m2215(false);
                        vH.this.invalidateOptionsMenu();
                        vO.m12021(vH.this);
                        View findViewById = vH.this.findViewById(R.id.coordinatorLayout);
                        if (findViewById != null) {
                            Snackbar.make(findViewById, C0403.m14185(vH.this, R.string.offline_state_download_removed).m14187(r4).m14186("sizeOfFile", r5).m14186("unitOfMeasure", "").m14188(), 0).show();
                            return true;
                        }
                        C1276.m16820().mo5725("Expected a R.id.coordinatorLayout here");
                        return true;
                    }
                });
            }
        } else if ((mo10792() instanceof OfflineFragment) && ((OfflineFragment) mo10792()).m2222()) {
            MenuItem add2 = menu.add(R.string.label_offline_remove_downloads);
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_edit);
            if (drawable != null) {
                drawable = BrowseExperience.m1778(drawable, this, (int) R.attr.actionBarIconColor);
            }
            add2.setIcon(drawable);
            add2.setShowAsAction(2);
            add2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: o.vH.3
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (!(vH.this.mo10792() instanceof OfflineFragment)) {
                        return true;
                    }
                    ((OfflineFragment) vH.this.mo10792()).m2215(true);
                    vH.this.O_();
                    vH.this.invalidateOptionsMenu();
                    return true;
                }
            });
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (NetflixBottomNavBar.m416()) {
            if (getNetflixActionBar() != null && getNetflixActionBar().m352(menuItem)) {
                return true;
            }
            if (this.fragmentHelper.mo10706()) {
                return this.fragmentHelper.mo10710(menuItem);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11938(Fragment fragment, Fragment fragment2, boolean z) {
        BY by = new BY();
        if (fragment2 != null) {
            fragment2.setEnterTransition(z ? new Fade() : by);
        }
        if (fragment != null) {
            fragment.setExitTransition(z ? by : new Fade());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleIntentInternally(Intent intent) {
        if (m11929()) {
            m11935();
        }
        return super.handleIntentInternally(intent);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m11935() {
        if (mo10792() instanceof OfflineFragment) {
            ((OfflineFragment) mo10792()).m2215(false);
            O_();
            invalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        if (isFinishing() || getSupportFragmentManager().isStateSaved()) {
            return false;
        }
        if (m11929()) {
            m11935();
            return true;
        } else if (this.fragmentHelper.mo10704()) {
            return true;
        } else {
            if (this.f11182.isEmpty()) {
                return false;
            }
            setIntent(this.f11182.remove(this.f11182.size() - 1));
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().executePendingTransactions();
            m13998(getSupportFragmentManager().findFragmentByTag("primary"));
            O_();
            invalidateOptionsMenu();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasUpAction() {
        if (!NetflixBottomNavBar.m416()) {
            return true;
        }
        Fragment r1 = mo10792();
        return m11929() || ((r1 instanceof OfflineFragment) && ((OfflineFragment) r1).m2212()) || this.fragmentHelper.mo10706();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void bottomTabReselected(NetflixBottomNavBar.NetflixTab netflixTab) {
        m11931();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        Fragment r2 = mo10792();
        boolean z = r2 instanceof OfflineFragment;
        if (!this.fragmentHelper.mo10705()) {
            if (m11929() && z) {
                ((OfflineFragment) r2).m2215(false);
                invalidateOptionsMenu();
            } else if (z && ((OfflineFragment) r2).m2212() && this.f11182.isEmpty()) {
                setIntent(m11932((Context) this));
                ((OfflineFragment) r2).m2220();
            } else if (isTaskRoot()) {
                startActivity(ActivityC2153sl.m10782(this));
                finish();
            } else if (!hasBottomNavBar() || !this.f11182.isEmpty()) {
                super.onBackPressed();
            }
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean m11929() {
        return (mo10792() instanceof OfflineFragment) && ((OfflineFragment) mo10792()).m2219();
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        if (!NetflixBottomNavBar.m416() || !this.fragmentHelper.mo10706()) {
            return qN.f9515;
        }
        return this.fragmentHelper.mo10701();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }
}
