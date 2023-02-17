package o;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationViewModel;
import com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsActivity$viewModel$2;
import com.netflix.mediaclient.util.log.UIScreen;
import com.netflix.model.leafs.social.multititle.NotificationLandingPage;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.json.JSONObject;
public class sR extends AbstractActivityC0360 implements qK {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Cif f10100 = new Cif(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f10101 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(sR.class), "viewModel", "getViewModel()Lcom/netflix/mediaclient/ui/iris/notifications/multititle/MultiTitleNotificationViewModel;"))};

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1433Et f10102 = C1435Ev.m4972(new MultiTitleNotificationsActivity$viewModel$2(this));

    /* renamed from: ˎ  reason: contains not printable characters */
    public NotificationLandingPage f10103;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final MultiTitleNotificationViewModel m10658() {
        AbstractC1433Et et = this.f10102;
        FQ fq = f10101[0];
        return (MultiTitleNotificationViewModel) et.mo3220();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public NotificationLandingPage m10660() {
        NotificationLandingPage notificationLandingPage = this.f10103;
        if (notificationLandingPage == null) {
            C1457Fr.m5017("landingPage");
        }
        return notificationLandingPage;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10661(NotificationLandingPage notificationLandingPage) {
        C1457Fr.m5025(notificationLandingPage, "<set-?>");
        this.f10103 = notificationLandingPage;
    }

    /* renamed from: o.sR$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final Intent m10663(NetflixActivity netflixActivity, NotificationLandingPage notificationLandingPage) {
            C1457Fr.m5025(netflixActivity, "activity");
            C1457Fr.m5025(notificationLandingPage, "landingPage");
            Intent intent = new Intent(netflixActivity, m10664());
            intent.putExtra("landingPage", notificationLandingPage);
            return intent;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final Class<?> m10664() {
            return NetflixApplication.getInstance().m254() ? sX.class : sR.class;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NetflixActionBar netflixActionBar = getNetflixActionBar();
        if (netflixActionBar != null) {
            netflixActionBar.m355(getActionBarStateBuilder().mo399(false).mo394("").mo392());
        }
        Parcelable parcelableExtra = super.getIntent().getParcelableExtra("landingPage");
        C1457Fr.m5016((Object) parcelableExtra, "super.getIntent().getPar…lableExtra(\"landingPage\")");
        m10661((NotificationLandingPage) parcelableExtra);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new iF(this, this);
    }

    public static final class iF implements oV {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ sR f10104;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ sR f10105;

        iF(sR sRVar, sR sRVar2) {
            this.f10105 = sRVar;
            this.f10104 = sRVar2;
        }

        @Override // o.oV
        public void onManagerReady(C2059ph phVar, Status status) {
            C1457Fr.m5025(phVar, "svcManager");
            C1457Fr.m5025(status, "res");
            if (!C1317As.m3750(this.f10105)) {
                sP.f10073.m10650(this.f10105.getServiceManager());
                this.f10105.m10658().m1969(this.f10105.m10660());
                this.f10105.m10658().m1970().observe(this.f10104, new Cif(this));
            }
        }

        /* renamed from: o.sR$iF$if  reason: invalid class name */
        static final class Cif<T> implements Observer<List<sW>> {

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ iF f10106;

            Cif(iF iFVar) {
                this.f10106 = iFVar;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final void onChanged(List<sW> list) {
                if (this.f10106.f10105.mo10792() instanceof sV) {
                    Fragment r0 = this.f10106.f10105.mo10792();
                    if (r0 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsFrag");
                    }
                    ((sV) r0).m10685(list);
                }
            }
        }

        @Override // o.oV
        public void onManagerUnavailable(C2059ph phVar, Status status) {
            C1457Fr.m5025(status, "res");
            if (!C1317As.m3750(this.f10105) && (this.f10105.mo10792() instanceof sV)) {
                Fragment r0 = this.f10105.mo10792();
                if (r0 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsFrag");
                }
                ((sV) r0).onManagerUnavailable(phVar, status);
                sP.f10073.m10650(null);
            }
        }
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
        return new sV();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.notificationLanding;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return true;
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        oX oXVar = qN.f9515;
        C1457Fr.m5016((Object) oXVar, "PlayContextImp.OFFLINE_MY_DOWNLOADS_CONTEXT");
        return oXVar;
    }

    /* renamed from: o.sR$ˊ  reason: contains not printable characters */
    static final class C0191 implements AbstractC0574 {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final C0191 f10107 = new C0191();

        C0191() {
        }

        @Override // o.AbstractC0503
        public final JSONObject toJSONObject() {
            return new JSONObject().put("actionType", "dismissButton");
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        m10659(C0191.f10107);
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10659(AbstractC0574 r4) {
        C1457Fr.m5025(r4, "trackingInfo");
        C1300Ac.m3531(new C1080(AppView.notificationLandingItem, r4), new C0642(), true);
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        C1300Ac.m3533();
        finish();
    }
}
