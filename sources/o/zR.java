package o;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
public class zR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0522 f12706;

    /* renamed from: ʼ  reason: contains not printable characters */
    private LinearLayout f12707;

    /* renamed from: ʽ  reason: contains not printable characters */
    private LinearLayout f12708;

    /* renamed from: ˊ  reason: contains not printable characters */
    private TextView f12709;

    /* renamed from: ˋ  reason: contains not printable characters */
    private TextView f12710;

    /* renamed from: ˎ  reason: contains not printable characters */
    private TextView f12711;

    /* renamed from: ˏ  reason: contains not printable characters */
    private TextView f12712;

    /* renamed from: ॱ  reason: contains not printable characters */
    private zT f12713;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C0522 f12714;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private TextView f12715;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f12716;

    zR(zT zTVar) {
        this.f12713 = zTVar;
        this.f12709 = (TextView) zTVar.findViewById(R.id.eogLpTitle);
        this.f12710 = (TextView) zTVar.findViewById(R.id.eogLpBody);
        this.f12712 = (TextView) zTVar.findViewById(R.id.eogLpContinue);
        this.f12711 = (TextView) zTVar.findViewById(R.id.eogLpPlans);
        this.f12716 = (TextView) zTVar.findViewById(R.id.eogLpSkip);
        this.f12715 = (TextView) zTVar.findViewById(R.id.eogLpAccount);
        this.f12708 = (LinearLayout) zTVar.findViewById(R.id.eogLpSkipHeader);
        this.f12707 = (LinearLayout) zTVar.findViewById(R.id.eogLpPlansHeader);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m13533() {
        if (this.f12713.m13551()) {
            EogAlert r7 = this.f12713.m13555();
            this.f12709.setText(r7.title());
            if (C1349Bv.m4107(r7.body())) {
                this.f12710.setText(C1349Bv.m4102(r7.body()));
            }
            this.f12712.setText(r7.continueBtnText());
            this.f12711.setText(r7.seeOtherPlansText());
            this.f12716.setText(r7.skipBtnText());
            this.f12715.setText(m13531(this.f12713, r7));
            this.f12715.setMovementMethod(LinkMovementMethod.getInstance());
            zT zTVar = this.f12713;
            if (zT.m13549(r7.isBlocking())) {
                this.f12708.setVisibility(8);
            }
            if (zV.m13564(r7)) {
                this.f12706 = (C0522) this.f12713.findViewById(R.id.eog_img1);
                this.f12714 = (C0522) this.f12713.findViewById(R.id.eog_img2);
                if (C1349Bv.m4107(r7.urlImage1()) && this.f12706 != null) {
                    NetflixActivity.getImageLoader(this.f12713).mo3057(this.f12706, r7.urlImage1(), AssetType.boxArt, "", BrowseExperience.m1769(), true);
                }
                if (C1349Bv.m4107(r7.urlImage2()) && this.f12714 != null) {
                    NetflixActivity.getImageLoader(this.f12713).mo3057(this.f12714, r7.urlImage2(), AssetType.boxArt, "", BrowseExperience.m1769(), true);
                }
            }
            if (!zV.m13565(r7)) {
                this.f12707.setVisibility(8);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static SpannableString m13531(final NetflixActivity netflixActivity, EogAlert eogAlert) {
        if (C1349Bv.m4113(eogAlert.footerText()) && C1349Bv.m4113(eogAlert.footerLinkText()) && C1349Bv.m4113(eogAlert.footerSuffix())) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (C1349Bv.m4107(eogAlert.footerText())) {
            sb.append(eogAlert.footerText());
        }
        if (C1349Bv.m4107(eogAlert.footerLinkText())) {
            sb.append(eogAlert.footerLinkText());
        }
        if (C1349Bv.m4107(eogAlert.footerSuffix())) {
            sb.append(eogAlert.footerSuffix());
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        AnonymousClass1 r4 = new ClickableSpan() { // from class: o.zR.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                new Runnable() { // from class: o.zR.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1283.m16854("eog_landing", "Get autologin token...");
                        final C2154sm smVar = new C2154sm(netflixActivity);
                        final NetworkErrorStatus networkErrorStatus = new NetworkErrorStatus(BK.f4581);
                        final AnonymousClass2 r5 = new Runnable() { // from class: o.zR.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                smVar.m10804((String) null, networkErrorStatus);
                            }
                        };
                        netflixActivity.getHandler().postDelayed(r5, 10000);
                        netflixActivity.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.zR.1.1.3
                            @Override // o.AbstractC2061pj, o.oU
                            public void onAutoLoginTokenCreated(String str, Status status) {
                                netflixActivity.getHandler().removeCallbacks(r5);
                                smVar.m10804(str, status);
                            }
                        });
                    }
                }.run();
            }
        };
        int length = spannableString.length();
        if (C1349Bv.m4107(eogAlert.footerSuffix())) {
            length -= eogAlert.footerSuffix().length();
        }
        spannableString.setSpan(r4, eogAlert.footerText().length(), length, 0);
        return spannableString;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m13532(View view) {
        if (view == null) {
            C1283.m16850("eog_landing", "EogLandingPage:: null view? This should never happen!");
            return true;
        }
        switch (view.getId()) {
            case R.id.eogLpContinueHeader /* 2131427735 */:
                this.f12713.m13559();
                if (zT.m13549(this.f12713.m13555().isBlocking())) {
                    this.f12713.startActivity(ActivityC2153sl.m10779(this.f12713));
                }
                this.f12713.finish();
                return true;
            case R.id.eogLpPlansHeader /* 2131427739 */:
                if (zV.m13565(this.f12713.m13555())) {
                    this.f12713.m13552();
                    return true;
                }
                C1283.m16865("eog_landing", "showPlans view should be invisible..");
                return true;
            case R.id.eogLpSkipHeader /* 2131427741 */:
                this.f12713.m13554();
                return true;
            default:
                return false;
        }
    }
}
