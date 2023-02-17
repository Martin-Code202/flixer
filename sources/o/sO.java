package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.netflix.mediaclient.R;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class sO extends sW {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f10068;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f10069;

    public sO() {
        this(0, null, 3, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sO(int i, String str) {
        super(false, 1, null);
        C1457Fr.m5025(str, "text");
        this.f10068 = i;
        this.f10069 = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sO(int i, String str, int i2, C1456Fq fq) {
        this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? "" : str);
    }

    @Override // o.sW
    /* renamed from: ˋ */
    public int mo10597() {
        return this.f10068;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final String m10619() {
        return this.f10069;
    }

    public static final class If extends RecyclerView.ViewHolder {

        /* renamed from: ॱ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f10070 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(If.class), "gridHeadline", "getGridHeadline()Lcom/netflix/mediaclient/android/widget/NetflixTextView;"))};

        /* renamed from: ˏ  reason: contains not printable characters */
        private final FI f10071 = C1197.m16471(this, (int) R.id.grid_headline);

        /* renamed from: ˊ  reason: contains not printable characters */
        public final C0716 m10620() {
            return (C0716) this.f10071.mo4986(this, f10070[0]);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public If(View view) {
            super(view);
            C1457Fr.m5025(view, "itemView");
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m10621(sO sOVar) {
            C1457Fr.m5025(sOVar, "headline");
            m10620().setText(sOVar.m10619());
        }
    }
}
