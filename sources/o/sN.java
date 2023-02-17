package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.mediaclient.R;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class sN extends sW {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f10062;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f10063;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f10064;

    public sN() {
        this(0, null, null, 7, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sN(int i, String str, String str2) {
        super(false, 1, null);
        C1457Fr.m5025(str, "notificationTitle");
        C1457Fr.m5025(str2, "notificationText");
        this.f10062 = i;
        this.f10064 = str;
        this.f10063 = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sN(int i, String str, String str2, int i2, C1456Fq fq) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }

    @Override // o.sW
    /* renamed from: ˋ */
    public int mo10597() {
        return this.f10062;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final String m10615() {
        return this.f10064;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m10614() {
        return this.f10063;
    }

    public static final class iF extends RecyclerView.ViewHolder {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f10065 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(iF.class), "notificationTitle", "getNotificationTitle()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(iF.class), "notificationText", "getNotificationText()Lcom/netflix/mediaclient/android/widget/NetflixTextView;"))};

        /* renamed from: ˋ  reason: contains not printable characters */
        private final FI f10066 = C1197.m16471(this, (int) R.id.notification_title);

        /* renamed from: ˎ  reason: contains not printable characters */
        private final FI f10067 = C1197.m16471(this, (int) R.id.notification_text);

        /* renamed from: ˋ  reason: contains not printable characters */
        public final C0716 m10616() {
            return (C0716) this.f10067.mo4986(this, f10065[1]);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final C0716 m10617() {
            return (C0716) this.f10066.mo4986(this, f10065[0]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public iF(View view) {
            super(view);
            C1457Fr.m5025(view, "itemView");
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final void m10618(sN sNVar) {
            C1457Fr.m5025(sNVar, "headline");
            m10617().setText(sNVar.m10615());
            m10616().setText(sNVar.m10614());
        }
    }
}
