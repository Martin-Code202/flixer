package o;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.util.log.UIScreen;
import org.linphone.core.Privacy;
public class zT extends NetflixActivity {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f12745;

    /* renamed from: ˊ  reason: contains not printable characters */
    private EogAlert f12746;

    /* renamed from: ˋ  reason: contains not printable characters */
    private zR f12747;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ViewFlipper f12748;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C2059ph f12749;

    /* renamed from: ॱ  reason: contains not printable characters */
    private zS f12750;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f12751;

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m13553() {
        return this.f12751;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m13556(int i) {
        this.f12751 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m13546(NetflixActivity netflixActivity, boolean z) {
        Intent addFlags = new Intent(netflixActivity, m13540()).addFlags(268435456);
        if (z) {
            C1283.m16854("eog", "adding clear_task flag");
            addFlags.addFlags(Privacy.DEFAULT);
        }
        return addFlags;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private static Class<?> m13540() {
        return NetflixApplication.getInstance().m254() ? zY.class : zT.class;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f12745 = bundle.getInt("com.netflix.mediaclient.ui.ums.eog.pageIndex");
            this.f12751 = bundle.getInt("com.netflix.mediaclient.ui.ums.eog.planIndex");
            return;
        }
        this.f12745 = 0;
        this.f12751 = -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1283.m16854("eog", "Saving eog state...");
        bundle.putInt("com.netflix.mediaclient.ui.ums.eog.pageIndex", this.f12748 != null ? this.f12748.getDisplayedChild() : 0);
        bundle.putInt("com.netflix.mediaclient.ui.ums.eog.planIndex", m13553());
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        if (m13551()) {
            if (!m13549(this.f12746.isBlocking())) {
                m13558();
                super.performUpAction();
            } else if (zV.m13560(this.f12748.getDisplayedChild(), this.f12746)) {
                m13557();
            } else {
                m13558();
                C1283.m16854("eog", "finishing activity");
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        C1283.m16854("eog", "handleBackPressed");
        if (!m13551()) {
            return true;
        }
        if (zV.m13560(this.f12748.getDisplayedChild(), this.f12746)) {
            m13557();
            return true;
        } else if (m13549(this.f12746.isBlocking())) {
            C1283.m16854("eog", "finishing");
            m13558();
            finish();
            return true;
        } else {
            m13558();
            return super.handleBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m13554() {
        if (!handleBackPressed()) {
            C1283.m16854("eog", "finish");
            finish();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m13549(boolean z) {
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zT.5
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                C1283.m16854("eog", "Manager is here!");
                zT.this.m13544(phVar, status);
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("eog", "Netflix service is not fully initialized");
            }
        };
    }

    public void performAction(View view) {
        C1283.m16854("eog", String.format("performAction currentChildIndex: %d", Integer.valueOf(this.f12748.getDisplayedChild())));
        if (this.f12747.m13532(view)) {
            C1283.m16854("eog", "Handled by landing page");
        } else if (this.f12750.m13538(view)) {
            C1283.m16854("eog", "Handled by plan page");
        } else {
            C1283.m16865("eog", "Handled by nobody!");
        }
    }

    public void performPlanSelection(View view) {
        C1283.m16854("eog", String.format("performPlanSelection currentChildIndex: %d", Integer.valueOf(this.f12748.getDisplayedChild())));
        if (this.f12750.m13539(view)) {
            C1283.m16854("eog", "Handled by plan page");
        } else {
            C1283.m16865("eog", "Handled by nobody!");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13544(C2059ph phVar, Status status) {
        this.f12749 = phVar;
        this.f12746 = this.f12749.m9808();
        m13541();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m13541() {
        if (!m13551()) {
            C1283.m16850("eog", "cannot proceed with eog alert. ");
            return;
        }
        this.f12751 = this.f12751 != -1 ? this.f12751 : m13548();
        setContentView(R.layout.eog_activity);
        this.f12748 = (ViewFlipper) findViewById(R.id.eogFlipper);
        m13543();
        this.f12747 = new zR(this);
        this.f12750 = new zS(this);
        this.f12747.m13533();
        this.f12750.m13537();
        if (zV.m13562(this.f12745, this.f12746)) {
            m13552();
        }
        if (!m13549(this.f12746.isBlocking())) {
            m13542();
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int m13550() {
        if (!zV.m13564(this.f12746)) {
            return AD.m3299() ? R.layout.eog_tablet_landing_page : R.layout.eog_landing_page;
        }
        if (!AD.m3299()) {
            return R.layout.eog_landing_page_cell5;
        }
        if (!AD.m3306(getApplicationContext()) || !zV.m13563(getApplicationContext())) {
            C1283.m16854("eog", "use tablet landing page");
            return R.layout.eog_tablet_landing_page_cell5;
        }
        C1283.m16854("eog", "returning phone layout for cell5 tablet bcoz size too small");
        return R.layout.eog_landing_page_cell5;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int m13547() {
        if (!AD.m3299()) {
            return R.layout.eog_plan_page;
        }
        if (AD.m3306(getApplicationContext()) && zV.m13563(getApplicationContext())) {
            return R.layout.eog_tablet_plan_page_small;
        }
        C1283.m16854("eog", "use tablet plan page");
        return R.layout.eog_tablet_plan_page;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m13543() {
        getApplicationContext();
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.f12748.addView(layoutInflater.inflate(m13550(), (ViewGroup) null));
        this.f12748.addView(layoutInflater.inflate(m13547(), (ViewGroup) null));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public EogAlert m13555() {
        if (this.f12746 != null) {
            return this.f12746;
        }
        if (this.f12749 != null) {
            this.f12746 = this.f12749.m9808();
        }
        return this.f12746;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m13552() {
        this.f12748.showNext();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m13557() {
        this.f12748.showPrevious();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.eogPrompt;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m13551() {
        boolean z = (this.f12749 == null || this.f12746 == null) ? false : true;
        if (!z) {
            C1283.m16850("eog", "fields are null - can't proceed");
        }
        return z;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private int m13548() {
        EogAlert eogAlert = this.f12746;
        if (eogAlert == null || C1349Bv.m4113(eogAlert.currentPlanId()) || eogAlert.currentPlanId().equals(eogAlert.sdPlanPlanId())) {
            return 0;
        }
        if (eogAlert.currentPlanId().equals(eogAlert.hdPlanPlanId())) {
            return 1;
        }
        if (eogAlert.currentPlanId().equals(eogAlert.uhdPlanPlanId())) {
            return 2;
        }
        return 0;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m13542() {
        m13555().isDirty = true;
        C1283.m16854("eog", "eogAlert marked dirty; can't use same data again");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m13559() {
        String str = null;
        String str2 = null;
        EogAlert eogAlert = this.f12746;
        if (getServiceManager() == null || eogAlert == null) {
            C1283.m16854("eog", "serviceMgr or eogAlert are null");
            return;
        }
        switch (this.f12751) {
            case 0:
                str = eogAlert.sdPlanPlanId();
                str2 = eogAlert.sdPlanPlanTier();
                break;
            case 1:
                str = eogAlert.hdPlanPlanId();
                str2 = eogAlert.hdPlanPlanTier();
                break;
            case 2:
                str = eogAlert.uhdPlanPlanId();
                str2 = eogAlert.uhdPlanPlanTier();
                break;
        }
        if (C1349Bv.m4107(str) && C1349Bv.m4107(str2)) {
            m13542();
            getServiceManager().m9782(str, str2);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m13558() {
        if (!m13551()) {
            C1283.m16854("eog", "serviceMgr or eogAlert are null");
        } else {
            getServiceManager().m9803(this.f12746.messageName(), this.f12746.skipBtnImpressionType());
        }
    }
}
