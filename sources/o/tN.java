package o;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import o.AbstractC0837;
public class tN extends AbstractC2195ty<C0213, CD> {
    public tN(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r4, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r4, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0213 onCreateViewHolder(ViewGroup viewGroup, int i) {
        C2180tj tjVar = new C2180tj(viewGroup.getContext());
        tjVar.setId(R.id.kids_character_view);
        return new C0213(viewGroup, tjVar, m15489(), R.id.kids_character_view);
    }

    @Override // o.AbstractC2195ty, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ͺ */
    public int mo10896() {
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10910(C0213 r2, CD cd, int i, boolean z) {
        r2.m10984(m11288(), cd, i, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10900(C0213 r1, int i, boolean z) {
        r1.m10983();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tN$ˊ  reason: contains not printable characters */
    public static class C0213 extends AbstractC0837.AbstractC0838 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C2180tj f10402;

        /* renamed from: ˏ  reason: contains not printable characters */
        private C0489 f10403;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final FrameLayout f10404 = ((FrameLayout) this.itemView);

        C0213(ViewGroup viewGroup, C2180tj tjVar, AbstractC0954 r8, int i) {
            super(viewGroup, new FrameLayout(viewGroup.getContext()), r8, i);
            this.f10402 = tjVar;
            this.f10403 = new C0489(viewGroup.getContext());
            this.f10404.addView(this.f10402, new FrameLayout.LayoutParams(-1, -1));
            this.f10404.addView(this.f10403, new FrameLayout.LayoutParams(-2, -2));
            ((FrameLayout.LayoutParams) this.f10403.getLayoutParams()).gravity = 17;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public void m10984(tU tUVar, CD cd, int i, boolean z) {
            this.f10403.setVisibility(8);
            this.f10402.setVisibility(0);
            this.f10402.mo2123((pJ) cd, (AbstractC2087qh) tUVar.mo10878(), i, z, false);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m10983() {
            this.f10402.setVisibility(8);
            this.f10403.setVisibility(0);
        }
    }
}
