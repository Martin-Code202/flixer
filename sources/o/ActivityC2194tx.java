package o;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.tx  reason: case insensitive filesystem */
public class ActivityC2194tx extends AbstractActivityC2189ts {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m11258(Context context) {
        return new Intent(context, m11265());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m11261(final Activity activity) {
        new AlertDialog.Builder(activity).setMessage(R.string.label_logout_dialog_title).setNegativeButton(R.string.label_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.label_sign_out, new DialogInterface.OnClickListener() { // from class: o.tx.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.INSTANCE.m142(new C0379());
                activity.startActivity(ActivityC2194tx.m11258(activity));
                activity.overridePendingTransition(0, 0);
                if (!NetflixBottomNavBar.m416()) {
                    activity.finish();
                }
            }
        }).show();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m11260(final ContextThemeWrapper contextThemeWrapper, int i) {
        new AlertDialog.Builder(contextThemeWrapper).setMessage(i).setNegativeButton(R.string.label_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.label_sign_out, new DialogInterface.OnClickListener() { // from class: o.tx.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Logger.INSTANCE.m142(new C0379());
                contextThemeWrapper.startActivity(ActivityC2194tx.m11258(contextThemeWrapper));
            }
        }).show();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Class<?> m11265() {
        return NetflixApplication.getInstance().m254() ? tC.class : ActivityC2194tx.class;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC2189ts, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.tx.1
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                phVar.m9760(new C0225(Logger.INSTANCE.m142(new C0974())));
                Logger.INSTANCE.m142(new C0379());
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
            }
        };
    }

    /* renamed from: o.tx$ˊ  reason: contains not printable characters */
    class C0225 extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        private Long f10634;

        public C0225(Long l) {
            super("LogoutActivity");
            this.f10634 = l;
        }

        @Override // o.oP, o.oU
        public void onLogoutComplete(Status status) {
            super.onLogoutComplete(status);
            if (status.mo298()) {
                Logger.INSTANCE.m140(this.f10634);
                ActivityC2194tx.this.m11259();
                return;
            }
            Logger.INSTANCE.m147(C0974.m14366(this.f10634, C1300Ac.m3532(status)));
            ActivityC2194tx.this.m11266(status, ActivityC2194tx.this.getString(R.string.label_error_signing_out));
            C1004.m15958(ActivityC2194tx.this, (int) R.string.label_error_signing_out, 1);
            ActivityC2194tx.this.finish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11266(Status status, String str) {
        C1362Ch.m4388(getUiScreen().f4084, IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, str, ActionOnUIError.displayedError));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11259() {
        C1283.m16862("LogoutActivity", "Handling logout completion...");
        PerformanceProfiler.INSTANCE.m668();
        C1362Ch.m4388(getUiScreen().f4084, IClientLogging.CompletionReason.success, (UIError) null);
        C1004.m15958(this, (int) R.string.label_signed_out, 1);
        m11262(this, "handleLogoutComplete()");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m11262(NetflixActivity netflixActivity, String str) {
        C2059ph serviceManager = netflixActivity.getServiceManager();
        if (serviceManager == null) {
            C1283.m16865("LogoutActivity", "ServiceManager is null - can't flush caches!");
        } else {
            serviceManager.m9764().mo9476();
        }
        NetflixActivity.finishAllActivities(netflixActivity);
        netflixActivity.startActivity(ActivityC2187tq.m11247(netflixActivity, str));
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.logout;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldReportNavigationActionEndedOnStop() {
        return false;
    }
}
