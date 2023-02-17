package com.netflix.mediaclient.ui.lolomo;

import android.support.v7.widget.RecyclerView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.tM;
public final class GenreSelectorDialog_Ab9031$loadData$1 extends Lambda implements AbstractC1450Fk<List<? extends GenreList>, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ tM f3193;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenreSelectorDialog_Ab9031$loadData$1(tM tMVar) {
        super(1);
        this.f3193 = tMVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(List<? extends GenreList> list) {
        m2017(list);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2017(List<? extends GenreList> list) {
        C1457Fr.m5025(list, "it");
        if (this.f3193.m10978().mo11735() > 1) {
            tM.m10975(this.f3193).mo14663(false);
            RecyclerView recyclerView = (RecyclerView) this.f3193.findViewById(R.Cif.genre_select_recyclerview);
            C1457Fr.m5016((Object) recyclerView, "genre_select_recyclerview");
            recyclerView.setVisibility(0);
            RecyclerView recyclerView2 = (RecyclerView) this.f3193.findViewById(R.Cif.genre_select_recyclerview);
            C1457Fr.m5016((Object) recyclerView2, "genre_select_recyclerview");
            recyclerView2.getAdapter().notifyDataSetChanged();
            return;
        }
        RecyclerView recyclerView3 = (RecyclerView) this.f3193.findViewById(R.Cif.genre_select_recyclerview);
        C1457Fr.m5016((Object) recyclerView3, "genre_select_recyclerview");
        recyclerView3.setVisibility(8);
        tM.m10975(this.f3193).mo14660(false);
    }
}
