package o;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class sM extends sW {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f10052;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0574 f10053;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f10054;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final CharSequence f10055;

    public sM() {
        this(0, null, null, null, 15, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sM(int i, CharSequence charSequence, String str, AbstractC0574 r7) {
        super(false, 1, null);
        C1457Fr.m5025(charSequence, "buttonText");
        C1457Fr.m5025(str, "url");
        this.f10054 = i;
        this.f10055 = charSequence;
        this.f10052 = str;
        this.f10053 = r7;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sM(int i, CharSequence charSequence, String str, AbstractC0574 r5, int i2, C1456Fq fq) {
        this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? "" : charSequence, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? null : r5);
    }

    @Override // o.sW
    /* renamed from: ˋ */
    public int mo10597() {
        return this.f10054;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final CharSequence m10607() {
        return this.f10055;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m10606() {
        return this.f10052;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final AbstractC0574 m10605() {
        return this.f10053;
    }

    public static final class iF extends RecyclerView.ViewHolder {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f10056 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(iF.class), "callToActionButton", "getCallToActionButton()Lcom/netflix/mediaclient/android/widget/NetflixTextButton;"))};

        /* renamed from: ˋ  reason: contains not printable characters */
        private AbstractC0574 f10057;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f10058;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final FI f10059 = C1197.m16471(this, (int) R.id.call_to_action_button);

        /* renamed from: ˊ  reason: contains not printable characters */
        private final C0754 m10608() {
            return (C0754) this.f10059.mo4986(this, f10056[0]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public iF(final View view) {
            super(view);
            C1457Fr.m5025(view, "itemView");
            m10608().setOnClickListener(new View.OnClickListener(this) { // from class: o.sM.iF.2

                /* renamed from: ˏ  reason: contains not printable characters */
                final /* synthetic */ iF f10061;

                {
                    this.f10061 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C0693.m14984((sR) C0345.m13893(view.getContext(), sR.class), new Intent("android.intent.action.VIEW", Uri.parse(this.f10061.f10058)));
                    this.f10061.m10612(this.f10061.f10057);
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final void m10612(AbstractC0574 r4) {
            C1300Ac.m3531(new C1080(AppView.notificationLandingItem, r4), new C0642(), true);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m10613(sM sMVar) {
            C1457Fr.m5025(sMVar, "row");
            m10608().setText(sMVar.m10607());
            this.f10058 = sMVar.m10606();
            this.f10057 = sMVar.m10605();
        }
    }
}
