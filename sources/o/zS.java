package o;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.servicemgr.IClientLogging;
public class zS {

    /* renamed from: ʻ  reason: contains not printable characters */
    private TextView f12725 = ((TextView) this.f12729.findViewById(R.id.eogPpHdPlanName));

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private Drawable f12726 = ContextCompat.getDrawable(this.f12729.getApplicationContext(), R.drawable.eog_plan_bg_inactive);

    /* renamed from: ʼ  reason: contains not printable characters */
    private TextView f12727 = ((TextView) this.f12729.findViewById(R.id.eogPpUhdPlanName));

    /* renamed from: ʽ  reason: contains not printable characters */
    private TextView f12728 = ((TextView) this.f12729.findViewById(R.id.eogPpAccount));

    /* renamed from: ˊ  reason: contains not printable characters */
    private zT f12729;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private CheckBox f12730 = ((CheckBox) this.f12729.findViewById(R.id.eogPpHdCheckbox));

    /* renamed from: ˋ  reason: contains not printable characters */
    private TextView f12731 = ((TextView) this.f12729.findViewById(R.id.eogPpSdPlanName));

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private CheckBox f12732 = ((CheckBox) this.f12729.findViewById(R.id.eogPpUhdCheckbox));

    /* renamed from: ˎ  reason: contains not printable characters */
    private TextView f12733 = ((TextView) this.f12729.findViewById(R.id.eogPpSelect));

    /* renamed from: ˏ  reason: contains not printable characters */
    private TextView f12734 = ((TextView) this.f12729.findViewById(R.id.eogPpSdPlanValue));

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private TextView f12735 = ((TextView) this.f12729.findViewById(R.id.eogPpDisclaimer));

    /* renamed from: ͺ  reason: contains not printable characters */
    private CheckBox f12736 = ((CheckBox) this.f12729.findViewById(R.id.eogPpSdCheckbox));

    /* renamed from: ॱ  reason: contains not printable characters */
    private TextView f12737 = ((TextView) this.f12729.findViewById(R.id.eogPpTitle));

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private TextView f12738 = ((TextView) this.f12729.findViewById(R.id.eogPpContinue));

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private LinearLayout f12739 = ((LinearLayout) this.f12729.findViewById(R.id.eogPpUhdPlanHeader));

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private LinearLayout f12740 = ((LinearLayout) this.f12729.findViewById(R.id.eogPpSdPlanHeader));

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private TextView f12741 = ((TextView) this.f12729.findViewById(R.id.eogPpUhdPlanValue));

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private LinearLayout f12742 = ((LinearLayout) this.f12729.findViewById(R.id.eogPpHdPlanHeader));

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f12743 = ((TextView) this.f12729.findViewById(R.id.eogPpHdPlanValue));

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Drawable f12744 = ContextCompat.getDrawable(this.f12729.getApplicationContext(), R.drawable.eog_plan_bg_active);

    zS(zT zTVar) {
        this.f12729 = zTVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m13537() {
        if (this.f12729.m13551()) {
            EogAlert r3 = this.f12729.m13555();
            this.f12737.setText(r3.title());
            this.f12733.setText(zV.m13567(r3) ? r3.body() : r3.selectPlanText());
            this.f12731.setText(r3.sdPlanText());
            this.f12734.setText(r3.sdPlanPrice());
            this.f12725.setText(r3.hdPlanText());
            this.f12743.setText(r3.hdPlanPrice());
            this.f12727.setText(r3.uhdPlanText());
            this.f12741.setText(r3.uhdPlanPrice());
            m13535(this.f12729.m13553());
            this.f12728.setText(zR.m13531(this.f12729, this.f12729.m13555()));
            this.f12728.setMovementMethod(LinkMovementMethod.getInstance());
            this.f12738.setText(r3.continueBtnText());
            this.f12735.setText(r3.disclaimerText());
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m13538(View view) {
        if (view == null) {
            C1283.m16850("eog_plan_page", "EogPlanPage:: null view? This should never happen!");
            return true;
        }
        switch (view.getId()) {
            case R.id.eogPpContinueHeader /* 2131427745 */:
                this.f12729.m13559();
                if (zT.m13549(this.f12729.m13555().isBlocking())) {
                    this.f12729.startActivity(ActivityC2153sl.m10779(this.f12729));
                }
                this.f12729.finish();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m13539(View view) {
        if (view == null) {
            C1283.m16850("eog_plan_page", "EogPlanPage:: null view? This should never happen!");
            return true;
        }
        switch (view.getId()) {
            case R.id.eogPpHdCheckbox /* 2131427747 */:
            case R.id.eogPpHdPlanHeader /* 2131427748 */:
                C1283.m16854("eog_plan_page", "Clicked on HD plan");
                m13535(1);
                m13534(1);
                return true;
            case R.id.eogPpHdPlanName /* 2131427749 */:
            case R.id.eogPpHdPlanValue /* 2131427750 */:
            case R.id.eogPpHeader /* 2131427751 */:
            case R.id.eogPpPlanHeader /* 2131427752 */:
            case R.id.eogPpSdPlanName /* 2131427755 */:
            case R.id.eogPpSdPlanValue /* 2131427756 */:
            case R.id.eogPpSelect /* 2131427757 */:
            case R.id.eogPpTitle /* 2131427758 */:
            default:
                return false;
            case R.id.eogPpSdCheckbox /* 2131427753 */:
            case R.id.eogPpSdPlanHeader /* 2131427754 */:
                C1283.m16854("eog_plan_page", "Clicked on SD plan");
                m13535(0);
                m13534(0);
                return true;
            case R.id.eogPpUhdCheckbox /* 2131427759 */:
            case R.id.eogPpUhdPlanHeader /* 2131427760 */:
                C1283.m16854("eog_plan_page", "Clicked on UHD plan");
                m13535(2);
                m13534(2);
                return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13535(int i) {
        m13536();
        switch (i) {
            case 0:
                this.f12736.setChecked(true);
                this.f12740.setBackground(this.f12744);
                break;
            case 1:
                this.f12730.setChecked(true);
                this.f12742.setBackground(this.f12744);
                break;
            case 2:
                this.f12732.setChecked(true);
                this.f12739.setBackground(this.f12744);
                break;
            default:
                this.f12730.setChecked(true);
                break;
        }
        this.f12729.m13556(i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13536() {
        this.f12736.setChecked(false);
        this.f12730.setChecked(false);
        this.f12732.setChecked(false);
        this.f12740.setBackground(this.f12726);
        this.f12742.setBackground(this.f12726);
        this.f12739.setBackground(this.f12726);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13534(int i) {
        EogAlert r2 = this.f12729.m13555();
        if (r2 == null) {
            C1283.m16850("eog_plan_page", "skip cl logging for plan change - eogAlert null");
            return;
        }
        String str = null;
        switch (i) {
            case 0:
                str = r2.sdPlanPlanId();
                break;
            case 1:
                str = r2.hdPlanPlanId();
                break;
            case 2:
                str = r2.uhdPlanPlanId();
                break;
        }
        if (!C1349Bv.m4113(str)) {
            Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C1070(str)));
            C1362Ch.m4379(null, IClientLogging.ModalView.eogPlanSelector);
            C1362Ch.m4385(IClientLogging.CompletionReason.success, (UIError) null, str);
        }
    }
}
