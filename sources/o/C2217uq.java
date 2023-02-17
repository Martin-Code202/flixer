package o;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import o.C2215uo;
import o.tF;
/* renamed from: o.uq  reason: case insensitive filesystem */
public final class C2217uq extends tF {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2217uq(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r5, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r5, i);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(pCVar, "lomo");
        C1457Fr.m5025(lolomoRecyclerViewAdapter, "parentAdapter");
        C1457Fr.m5025(r5, "config");
    }

    @Override // o.tF, o.C2215uo
    /* renamed from: ॱ */
    public C2215uo.AbstractC0235 onCreateViewHolder(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "parent");
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        layoutParams.leftMargin = m15489().mo15084();
        layoutParams.topMargin = m15489().mo15084();
        layoutParams.rightMargin = m15489().mo15084();
        layoutParams.bottomMargin = m15489().mo15084();
        if (i == 0) {
            Context context = viewGroup.getContext();
            C1457Fr.m5016((Object) context, "parent.context");
            uI uIVar = new uI(context, null, 0, 6, null);
            uIVar.setId(R.id.short_form_view_ab9296);
            AbstractC0954 r1 = m15489();
            C1457Fr.m5016((Object) r1, "config");
            return new Cif(this, viewGroup, uIVar, r1);
        }
        C2215uo.If r0 = m11720(viewGroup, m15489(), layoutParams);
        C1457Fr.m5016((Object) r0, "createLoadingViewHolder(parent, config, lp)");
        return r0;
    }

    /* access modifiers changed from: protected */
    @Override // o.tF, o.AbstractC2195ty
    /* renamed from: ˊ */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        C1457Fr.m5025(phVar, "serviceManager");
        C1457Fr.m5025(oUVar, "updateVideosManagerCallback");
        oF r0 = phVar.m9764();
        pC r1 = m11301();
        C1457Fr.m5016((Object) r1, "lomo");
        r0.mo9497(i, i2, r1.getId(), oUVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.tF, o.C2215uo
    /* renamed from: ˎ */
    public void mo10900(C2215uo.AbstractC0235 r3, int i, boolean z) {
        C1457Fr.m5025(r3, "holder");
        tU r0 = m11288();
        C1457Fr.m5016((Object) r0, "lomoContext");
        r3.mo10906(r0, C0878.f14760.m15591(), i, z);
    }

    @Override // o.tF, o.AbstractC2195ty, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < m11286().size()) {
            return 0;
        }
        return 1;
    }

    @Override // o.tF, o.AbstractC0837
    /* renamed from: ॱॱ */
    public boolean mo10904() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.tF, o.AbstractC2195ty
    /* renamed from: ͺ */
    public int mo10896() {
        pC r0 = m11301();
        C1457Fr.m5016((Object) r0, "lomo");
        return Math.min(r0.getNumVideos(), m11286().size() + Math.min(m15489().mo15082(), 3));
    }

    /* renamed from: o.uq$if  reason: invalid class name */
    public final class Cif extends tF.C0210 {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2217uq f11021;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(C2217uq uqVar, ViewGroup viewGroup, uI uIVar, AbstractC0954 r5) {
            super(viewGroup, uIVar, r5);
            C1457Fr.m5025(viewGroup, "parent");
            C1457Fr.m5025(uIVar, "view");
            C1457Fr.m5025(r5, "config");
            this.f11021 = uqVar;
        }
    }
}
