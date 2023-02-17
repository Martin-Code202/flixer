package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import o.C2215uo;
/* renamed from: o.uf  reason: case insensitive filesystem */
public class C2206uf extends C2215uo<pJ> {
    @Override // o.C2215uo, o.AbstractC2195ty, o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // o.C2215uo, o.AbstractC2195ty, o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // o.C2215uo, o.AbstractC0837
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo10895(RecyclerView recyclerView, int i) {
        super.mo10895(recyclerView, i);
    }

    public C2206uf(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r4, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r4, i);
    }

    @Override // o.C2215uo
    /* renamed from: ॱ */
    public C2215uo.AbstractC0235 onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        layoutParams.leftMargin = m15489().mo15084();
        layoutParams.topMargin = m15489().mo15084();
        layoutParams.rightMargin = m15489().mo15084();
        layoutParams.bottomMargin = m15489().mo15084();
        if (i != 0) {
            return m11720(viewGroup, m15489(), layoutParams);
        }
        C0806 r3 = new C0806(viewGroup.getContext());
        r3.setId(R.id.roar_movie_boxart);
        r3.setLayoutParams(layoutParams);
        return new C2215uo.Cif(viewGroup, r3, m15489());
    }
}
