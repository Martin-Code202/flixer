package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.List;
import o.C0567;
import o.C0779;
import o.C1348Bu;
import o.C2155sn;
import o.sF;
public class vB extends AbstractC0517 {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected ViewGroup f11076;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private If f11077;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected View f11078;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected View f11079;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final AdapterView.OnItemClickListener f11080 = new AdapterView.OnItemClickListener() { // from class: o.vB.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C2155sn.C0207 r1 = vB.this.f11077.getItem(i);
            if (r1 != null && r1.f10239 != null) {
                r1.f10239.run();
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private final BroadcastReceiver f11081 = new BroadcastReceiver() { // from class: o.vB.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            vB.this.m11833();
            vB.this.m11840();
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    private final Runnable f11082 = new Runnable() { // from class: o.vB.7
        @Override // java.lang.Runnable
        public void run() {
            if (!C1317As.m3750(vB.this.getActivity())) {
                vB.this.f11088.m10577();
            }
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C0874 f11083;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C2059ph f11084;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected NetflixActivity f11085;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C0779 f11086;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected LinearLayout f11087;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private sJ f11088;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f11089 = false;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Long f11090;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected C0616 f11091;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final BroadcastReceiver f11092 = new BroadcastReceiver() { // from class: o.vB.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            vB.this.m11829();
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected View f11093;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f11094;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static vB m11825() {
        return new vB();
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f11085 = (NetflixActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.more_fragment, viewGroup, false);
        this.f11087 = (LinearLayout) inflate.findViewById(R.id.scrollable_content);
        this.f11087.setOnClickListener(null);
        this.f11091 = new C0616(inflate, new C0567.Cif() { // from class: o.vB.6
            @Override // o.C0567.Cif
            public void N_() {
            }
        });
        this.f11093 = inflate.findViewById(R.id.touch_blocker);
        this.f11078 = inflate.findViewById(R.id.header_separator_notifications);
        this.f11079 = inflate.findViewById(R.id.header_notifications);
        if (this.f11079 != null) {
            TextView textView = (TextView) this.f11079.findViewById(R.id.row_text);
            textView.setText(this.f11085.getString(R.string.notifications));
            textView.setPadding(0, 0, 0, 0);
        }
        this.f11076 = (ViewGroup) inflate.findViewById(R.id.notifications_fragment_container);
        this.f11086 = (C0779) inflate.findViewById(R.id.profile_selector);
        inflate.findViewById(R.id.manage_profiles).setOnClickListener(new View.OnClickListener() { // from class: o.vB.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (vB.this.getActivity() != null) {
                    vB.this.startActivity(ActivityC2383zq.m13743((Context) vB.this.getActivity(), true));
                }
            }
        });
        this.f11086.setProfileSelectedListener(new C0779.If() { // from class: o.vB.8
            @Override // o.C0779.If
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo11841(AbstractC2089qj qjVar) {
                if (qjVar != null) {
                    vB.this.f11090 = Logger.INSTANCE.m142(new C0726(qjVar.getProfileGuid()));
                    C1362Ch.m4420((UserActionLogging.CommandName) null, vB.this.m14534().getUiScreen().f4084, qjVar.getProfileGuid(), UserActionLogging.RememberProfile.userChoseToRemember);
                    vB.this.m11837(qjVar);
                }
            }
        });
        this.f11086.setAddProfileListener(new View.OnClickListener() { // from class: o.vB.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity r2 = vB.this.m14534();
                if (r2 != null) {
                    C1362Ch.m4421(null, r2.getUiScreen().f4084);
                    vB.this.startActivity(DialogInterface$OnClickListenerC2376zj.m13690(r2, (String) null));
                }
            }
        });
        this.f11083 = (C0874) this.f11087.findViewById(R.id.app_list_view);
        this.f11083.setFocusable(false);
        m11833();
        this.f11085.registerReceiverWithAutoUnregister(this.f11081, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        m11820(true, false, false);
        return inflate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11837(AbstractC2089qj qjVar) {
        NetflixActivity r3 = m14534();
        if (r3 == null) {
            C1283.m16854("MoreFragment", "startChangeProfile - ignoring because fragment is missing activity");
        } else if (this.f11084 == null || !this.f11084.mo9519()) {
            C1283.m16850("MoreFragment", "Manager is not ready");
            Logger.INSTANCE.m147(C0726.m14366(this.f11090, C1300Ac.m3532(AbstractC0367.f13255)));
            C1362Ch.m4418(IClientLogging.CompletionReason.failed, r3.getUiScreen().f4084, AbstractC1358Cd.m4353(AbstractC0367.f13255, "", ActionOnUIError.handledSilently));
        } else {
            AbstractC2089qj r4 = this.f11084.m9826();
            if (r4 != null && C1349Bv.m4126(r4.getProfileGuid(), qjVar.getProfileGuid())) {
                C1283.m16854("MoreFragment", "Selected profile is the same as the current one - skipping profile change...");
                C1362Ch.m4418(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.homeScreen, AbstractC1358Cd.m4353(AbstractC0367.f13241, "", ActionOnUIError.handledSilently));
                Logger.INSTANCE.m147(C0726.m14366(this.f11090, C1300Ac.m3532(AbstractC0367.f13241)));
                startActivity(ActivityC2153sl.m10782(r3));
                r3.finish();
            } else if (!ConnectivityUtils.m2954(r3)) {
                C1283.m16865("MoreFragment", "Network is NOT connected, prevent action and report to user!");
                r3.handleUserAgentErrors(AbstractC0367.f13238, false);
                C1362Ch.m4418(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.homeScreen, AbstractC1358Cd.m4353(AbstractC0367.f13238, "", ActionOnUIError.displayedError));
                Logger.INSTANCE.m147(C0726.m14366(this.f11090, C1300Ac.m3532(AbstractC0367.f13238)));
            } else {
                m11820(false, true, true);
                this.f11084.m9801(qjVar.getProfileGuid());
            }
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m11830() {
        C1283.m16846("MoreFragment", "Showing content view...");
        this.f11091.mo14663(false);
        this.f11087.setVisibility(0);
        this.f11093.setVisibility(8);
        View view = getView();
        NetflixActivity r4 = m14534();
        if (!isHidden() && view != null && r4 != null) {
            view.setEnabled(true);
            if (view.getVisibility() != 0) {
                BQ.m3914(view, false);
            } else if (view.getAlpha() < 1.0f) {
                view.animate().alpha(1.0f).setDuration(150).start();
            }
            if (r4.getBottomNavBar() != null) {
                r4.getBottomNavBar().setEnabled(true);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11820(boolean z, boolean z2, boolean z3) {
        C1283.m16846("MoreFragment", "Showing loading view...");
        this.f11091.mo14570(false);
        this.f11093.setVisibility(0);
        View view = getView();
        NetflixActivity r4 = m14534();
        if (view != null) {
            view.setEnabled(false);
            if (z) {
                view.setVisibility(8);
            } else if (z2) {
                view.animate().alpha(0.4f).setDuration(400).start();
            } else {
                view.setAlpha(0.4f);
            }
            if (z3 && r4.getBottomNavBar() != null) {
                r4.getBottomNavBar().setEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m11829() {
        if (this.f11084 != null) {
            UmaAlert r1 = this.f11084.m9820();
            this.f11089 = r1 != null && !r1.isConsumed() && r1.blocking();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11827(boolean z) {
        if (this.f11076 == null) {
            C1283.m16846("MoreFragment", "notificationsFragmentContainer is null - can't set visibility");
        } else if (z) {
            C1283.m16846("MoreFragment", "Showing notifications header");
            this.f11076.setVisibility(0);
            this.f11078.setVisibility(0);
            this.f11079.setVisibility(0);
            m11839(true);
        } else {
            C1348Bu.If.m4099(this.f11082);
            C1283.m16846("MoreFragment", "Hiding notifications header");
            this.f11076.setVisibility(8);
            this.f11078.setVisibility(8);
            this.f11079.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m11833() {
        List<C2155sn.C0207> r2 = C2155sn.m10805(this.f11085);
        if (r2 == null || r2.size() <= 0) {
            this.f11083.setVisibility(8);
            return;
        }
        this.f11077 = new If(r2);
        this.f11083.setAdapter((ListAdapter) this.f11077);
        this.f11083.setOnItemClickListener(this.f11080);
        this.f11083.setVisibility(0);
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        this.f11084 = phVar;
        m11836();
        m11834();
        m11818();
        m11833();
        m11821();
        m11829();
        if (this.f11088 != null) {
            this.f11088.onManagerReady(phVar, status);
        }
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        if (this.f11088 != null) {
            this.f11088.onManagerUnavailable(phVar, status);
        }
        this.f11084 = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f11079 != null && this.f11079.getVisibility() == 0) {
            m11839(true);
        }
        m11821();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_UPDATED");
        intentFilter.addAction("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_CONSUMED");
        LocalBroadcastManager.getInstance(this.f11085).registerReceiver(this.f11092, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m11839(false);
        LocalBroadcastManager.getInstance(this.f11085).unregisterReceiver(this.f11092);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11839(boolean z) {
        if (this.f11088 == null) {
            return;
        }
        if (z && !this.f11094) {
            this.f11088.m10580(true);
            this.f11094 = true;
            C1348Bu.If.m4100(this.f11082, 1000);
        } else if (!z && this.f11094) {
            this.f11088.m10580(false);
            this.f11094 = false;
            C1348Bu.If.m4099(this.f11082);
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean m11823() {
        if (this.f11084 != null && this.f11084.mo9519()) {
            return false;
        }
        C1283.m16846("MoreFragment", "Manager is not ready - can't update");
        return true;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m11821() {
        m11835();
        m11840();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m11835() {
        if (!m11823()) {
            AbstractC2089qj r2 = this.f11084.m9826();
            if (r2 == null) {
                C1283.m16846("MoreFragment", "Profile is null - can't update profile info");
            } else if (this.f11084.m9833() == null) {
                C1283.m16846("MoreFragment", "getAllProfiles returned null - can't update profile info");
            } else {
                List<AbstractC2089qj> arrayList = new ArrayList<>(this.f11084.m9833());
                if (arrayList.size() > 5) {
                    C1276.m16820().mo5725("More than 5 profiles!");
                    arrayList = arrayList.subList(0, 5);
                }
                this.f11086.setProfiles(arrayList, r2);
                m11830();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m11840() {
        if (!m11823()) {
            this.f11084.m9765();
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m11834() {
        if (!m11823() && this.f11084.m9822()) {
            View findViewById = this.f11087.findViewById(R.id.my_list);
            m11838(findViewById, this.f11085.getString(R.string.label_my_list_2), ContextCompat.getDrawable(this.f11085, R.drawable.ic_mylist_check_drawer));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.vB.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!vB.this.f11089) {
                        uB.m11324(vB.this.f11085, new tO("MyListFakeId", vB.this.f11085.getString(R.string.label_my_list_2), LoMoType.INSTANT_QUEUE, LoMoType.INSTANT_QUEUE.m1575()));
                    }
                }
            });
            findViewById.setVisibility(0);
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m11836() {
        AbstractC2089qj r3;
        if (!m11823() && (r3 = this.f11084.m9826()) != null) {
            if (!r3.isKidsProfile()) {
                C1283.m16846("MoreFragment", "Inflating notifications into layout");
                this.f11076.setVisibility(0);
                this.f11088 = (sJ) this.f11085.getSupportFragmentManager().findFragmentByTag("NOTIFICATIONS_FRAGMENT");
                if (this.f11088 == null) {
                    this.f11088 = new sJ();
                    FragmentTransaction beginTransaction = this.f11085.getSupportFragmentManager().beginTransaction();
                    beginTransaction.add(R.id.notifications_fragment_container, this.f11088, "NOTIFICATIONS_FRAGMENT");
                    beginTransaction.commitAllowingStateLoss();
                }
                this.f11088.m10578(new sF.iF() { // from class: o.vB.15
                    @Override // o.sF.iF
                    /* renamed from: ˋ */
                    public void mo10591(boolean z) {
                        vB.this.m11827(z);
                    }
                });
                m11827(this.f11088.m10589());
                View findViewById = this.f11087.findViewById(R.id.header_notifications);
                findViewById.setBackgroundResource(R.drawable.selectable_item_background);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.vB.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        vB.this.f11085.startActivity(new Intent(vB.this.f11085, sC.m10520()));
                    }
                });
                this.f11088.m10583();
                return;
            }
            this.f11078.setVisibility(8);
            this.f11079.setVisibility(8);
            this.f11076.setVisibility(8);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m11818() {
        if (C0654.m14815(this.f11085)) {
            C1283.m16854("MoreFragment", "Showing Watch History Row for Ab8505");
            View findViewById = this.f11087.findViewById(R.id.watch_history);
            m11838(findViewById, C2149si.f10161.m10733(this.f11085), ContextCompat.getDrawable(this.f11085, R.drawable.ic_history_white_24dp));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: o.vB.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    vB.this.f11085.startActivity(ActivityC2150sj.f10162.m10741(vB.this.f11085));
                }
            });
            findViewById.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11838(View view, String str, Drawable drawable) {
        view.findViewById(R.id.row_separator).setVisibility(0);
        ((TextView) view.findViewById(R.id.row_text)).setText(str);
        BrowseExperience.m1776((ImageView) view.findViewById(R.id.row_icon), drawable, R.attr.actionBarIconColor);
    }

    /* access modifiers changed from: package-private */
    public class If extends BaseAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final List<C2155sn.C0207> f11107;

        If(List<C2155sn.C0207> list) {
            this.f11107 = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f11107.size();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C2155sn.C0207 getItem(int i) {
            return this.f11107.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = vB.this.f11085.getLayoutInflater().inflate(R.layout.more_menu_row, viewGroup, false);
            }
            ((TextView) view.findViewById(R.id.row_text)).setText(getItem(i).f10238);
            return view;
        }
    }

    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        C1004.m15952(view, 1, this.f13651);
        C1004.m15952(view, 3, this.f13650);
    }
}
