package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.model.leafs.blades.CreditMarks;
public class wY extends C0647 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f11550 = 1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f11551;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f11552 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f11553;

    public interface If {
        /* renamed from: ॱ  reason: contains not printable characters */
        void mo12396(View view, int i);
    }

    public wY(Context context) {
        super(context);
    }

    public wY(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public wY(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // o.C0647
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12393(boolean z) {
        if (this.f11550 == 0 || (this.f11553 && !super.m14792())) {
            super.mo12393(z);
            this.f11552 = false;
            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class);
            if (netflixActivity != null) {
                C1283.m16846("SkipCreditsButton", "Logging session started for SkipCredits Button");
                switch (this.f11550) {
                    case 0:
                        this.f11551 = netflixActivity.reportUiModelessViewSessionStart(IClientLogging.ModalView.skipPrePlayRecapButton);
                        return;
                    case 1:
                        this.f11551 = netflixActivity.reportUiModelessViewSessionStart(IClientLogging.ModalView.skipCreditsButton);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // o.C0647
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12391(boolean z) {
        NetflixActivity netflixActivity;
        if (super.m14792()) {
            super.mo12391(z);
            if (this.f11551 != null && (netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class)) != null) {
                switch (this.f11550) {
                    case 0:
                        C1283.m16846("SkipCreditsButton", "hide preplay button");
                        netflixActivity.reportUiModelessViewSessionEnded(IClientLogging.ModalView.skipPrePlayRecapButton, this.f11551);
                        return;
                    case 1:
                        C1283.m16846("SkipCreditsButton", "Logging session ended for SkipCredits");
                        netflixActivity.reportUiModelessViewSessionEnded(IClientLogging.ModalView.skipCreditsButton, this.f11551);
                        this.f11551 = null;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setShowSkipButtonIndependentlyOfPlayerControls(boolean z) {
        this.f11552 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m12394() {
        return this.f11552;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12390() {
        this.f11552 = true;
        this.f11553 = false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m12392(long j, final CreditMarks creditMarks, int i, final If r7) {
        if (this.f11550 == 0) {
            setText(R.string.label_skip_recap_button);
            setOnClickListener(new View.OnClickListener() { // from class: o.wY.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    wY.this.m12386(UIViewLogging.UIViewCommandName.skipPrePlayRecapButton);
                    r7.mo12396(wY.this.getRootView(), -1);
                    wY.this.mo12391(true);
                }
            });
        } else if (m12388(creditMarks, j, i)) {
            if (!this.f11553) {
                C1283.m16846("SkipCreditsButton", "Within CreditMarks - Setting onclick listener");
                setText(R.string.label_skip_intro_button);
                setOnClickListener(new View.OnClickListener() { // from class: o.wY.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        wY.this.m12386(UIViewLogging.UIViewCommandName.skipCreditsButton);
                        r7.mo12396(wY.this.getRootView(), creditMarks.endCredit());
                        wY.this.mo12391(true);
                    }
                });
                this.f11553 = true;
            }
        } else if (!m12387(creditMarks, j, i)) {
            C1283.m16846("SkipCreditsButton", "Not within creditmarks");
            mo12391(false);
            this.f11553 = false;
        } else if (!this.f11553) {
            C1283.m16846("SkipCreditsButton", "Within CreditMarks - Setting onclick listener");
            setText(R.string.label_skip_recap_button);
            setOnClickListener(new View.OnClickListener() { // from class: o.wY.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    wY.this.m12386(UIViewLogging.UIViewCommandName.skipCreditsButton);
                    r7.mo12396(wY.this.getRootView(), creditMarks.endRecap());
                    wY.this.mo12391(true);
                }
            });
            this.f11553 = true;
        }
        return this.f11553;
    }

    public void setBottomMargin(int i) {
        if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
            C1283.m16848("SkipCreditsButton", "Setting bottomMargin to %s", Integer.valueOf(i));
            ((FrameLayout.LayoutParams) getLayoutParams()).setMargins(((FrameLayout.LayoutParams) getLayoutParams()).getMarginStart(), ((FrameLayout.LayoutParams) getLayoutParams()).topMargin, ((FrameLayout.LayoutParams) getLayoutParams()).getMarginEnd(), i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12386(UIViewLogging.UIViewCommandName uIViewCommandName) {
        C1364Cj.m4434(uIViewCommandName, IClientLogging.ModalView.skipCreditsButton, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m12388(CreditMarks creditMarks, long j, int i) {
        return creditMarks.startCredit() >= 0 && creditMarks.endCredit() >= 0 && j > ((long) creditMarks.startCredit()) && j < ((long) (creditMarks.endCredit() - i));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m12387(CreditMarks creditMarks, long j, int i) {
        return creditMarks.startRecap() >= 0 && creditMarks.startRecap() >= 0 && j > ((long) creditMarks.startRecap()) && j < ((long) (creditMarks.endRecap() - i));
    }

    public void setIsWithinCreditMarks(boolean z) {
        this.f11553 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m12395() {
        return this.f11550;
    }

    public void setSkipCreditsButtonType(int i) {
        this.f11550 = i;
    }
}
