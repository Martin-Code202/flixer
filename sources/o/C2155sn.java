package o;

import android.content.Intent;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.sn  reason: case insensitive filesystem */
public class C2155sn {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<C0207> m10805(final NetflixActivity netflixActivity) {
        ArrayList arrayList = new ArrayList();
        if (netflixActivity.getServiceManager() == null) {
            C1283.m16865("AppActions", "Service manager is null, no app section");
            return arrayList;
        } else if (!netflixActivity.getServiceManager().mo9519()) {
            C1283.m16865("AppActions", "Service manager not ready, no app section");
            return arrayList;
        } else if (netflixActivity.getServiceManager().m9826() == null) {
            C1283.m16865("AppActions", "Current profile is null, no app section");
            return arrayList;
        } else {
            if (netflixActivity.showSettingsInMenu()) {
                arrayList.add(new C0207(netflixActivity.getString(R.string.label_sliding_menu_title_app), new Runnable() { // from class: o.sn.5
                    @Override // java.lang.Runnable
                    public void run() {
                        netflixActivity.startActivity(zC.m13380(netflixActivity));
                    }
                }));
            }
            if (netflixActivity.showAccountInMenu()) {
                arrayList.add(new C0207(netflixActivity.getString(R.string.label_sliding_menu_item_account), new Runnable() { // from class: o.sn.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1283.m16854("AppActions", "Get autologin token...");
                        if (!netflixActivity.getServiceManager().mo9519()) {
                            C1283.m16850("AppActions", "Service is not available!");
                            return;
                        }
                        final C2154sm smVar = new C2154sm(netflixActivity);
                        final NetworkErrorStatus networkErrorStatus = new NetworkErrorStatus(BK.f4581);
                        final AnonymousClass2 r5 = new Runnable() { // from class: o.sn.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                smVar.m10804((String) null, networkErrorStatus);
                            }
                        };
                        netflixActivity.getHandler().postDelayed(r5, 10000);
                        netflixActivity.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.sn.2.5
                            @Override // o.AbstractC2061pj, o.oU
                            public void onAutoLoginTokenCreated(String str, Status status) {
                                netflixActivity.getHandler().removeCallbacks(r5);
                                smVar.m10804(str, status);
                            }
                        });
                    }
                }));
            }
            if (netflixActivity.showContactUsInSlidingMenu() && netflixActivity.getServiceManager().m9823() != null && netflixActivity.getServiceManager().m9823().mo9649() && ConnectivityUtils.m2970(netflixActivity)) {
                arrayList.add(new C0207(netflixActivity.getString(R.string.label_contact_us), new Runnable() { // from class: o.sn.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent r2 = ActivityC1313Ao.m3721(netflixActivity);
                        IClientLogging.ModalView modalView = netflixActivity.getUiScreen().f4084;
                        if (modalView != null) {
                            r2.putExtra(NetflixActivity.EXTRA_SOURCE, modalView.name());
                        }
                        r2.putExtra(NetflixActivity.EXTRA_ENTRY, CustomerServiceLogging.EntryPoint.appMenu.name());
                        netflixActivity.startActivity(r2);
                    }
                }));
            }
            if (netflixActivity.showSignOutInMenu()) {
                arrayList.add(new C0207(netflixActivity.getString(R.string.label_sign_out), new Runnable() { // from class: o.sn.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityC2194tx.m11261(netflixActivity);
                    }
                }));
            }
            return arrayList;
        }
    }

    /* renamed from: o.sn$ˋ  reason: contains not printable characters */
    public static class C0207 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f10238;

        /* renamed from: ˎ  reason: contains not printable characters */
        public Runnable f10239;

        public C0207(String str, Runnable runnable) {
            this.f10238 = str;
            this.f10239 = runnable;
        }
    }
}
