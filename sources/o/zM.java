package o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.util.log.UIScreen;
public class zM extends NetflixActivity implements zU {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean f12693;

    /* renamed from: ˊ  reason: contains not printable characters */
    CM f12694;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m13505(Context context, C2059ph phVar) {
        return C1272.m16797(C0597.class, context) == ABTestConfig.Cell.CELL_1 && phVar != null && phVar.m9826() != null && !phVar.m9826().isKidsProfile() && !f12693;
    }

    @Override // o.zU
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13507(int i) {
        if (!f12693) {
            f12693 = true;
            C1362Ch.m4416(IClientLogging.CompletionReason.success, (UIError) null, this.f12694.m4215());
            C1362Ch.m4386(IClientLogging.CompletionReason.success, (UIError) null, this.f12694.m4217(), String.valueOf(i));
            zQ zQVar = new zQ();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(17432576, 17432577);
            beginTransaction.replace(R.id.fragment_container, zQVar);
            beginTransaction.commit();
        }
    }

    @Override // o.zU
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo13508() {
        if (!f12693) {
            f12693 = true;
            C1362Ch.m4416(IClientLogging.CompletionReason.canceled, (UIError) null, this.f12694.m4215());
            C1362Ch.m4386(IClientLogging.CompletionReason.canceled, (UIError) null, this.f12694.m4217(), "0");
            finish();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m13506() {
        getServiceManager().m9761();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m13504(Activity activity, CL cl) {
        Intent intent = new Intent(activity, m13503());
        intent.putExtra("extra_survey", cl);
        activity.startActivity(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Class<?> m13503() {
        return NetflixApplication.getInstance().m254() ? zP.class : zM.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_survey);
        BW.m3942(getUiScreen().f4084);
        CL cl = (CL) getIntent().getParcelableExtra("extra_survey");
        if (cl == null || cl.m4212() == 0) {
            finish();
            return;
        }
        this.f12694 = cl.m4210();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        C1362Ch.m4411((UserActionLogging.CommandName) null, getUiScreen().f4084);
        zL r3 = zL.m13496(cl);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.fragment_container, r3);
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m13506();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        mo13508();
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.survey;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }
}
