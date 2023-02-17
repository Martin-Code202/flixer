package com.netflix.mediaclient.ui.lolomo;

import android.support.v7.widget.RecyclerView;
import com.netflix.mediaclient.R;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.tM;
public final class GenreSelectorDialog_Ab9031$loadData$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ tM f3194;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenreSelectorDialog_Ab9031$loadData$2(tM tMVar) {
        super(1);
        this.f3194 = tMVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2018(th);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2018(Throwable th) {
        C1457Fr.m5025(th, "it");
        RecyclerView recyclerView = (RecyclerView) this.f3194.findViewById(R.Cif.genre_select_recyclerview);
        C1457Fr.m5016((Object) recyclerView, "genre_select_recyclerview");
        recyclerView.setVisibility(8);
        tM.m10975(this.f3194).mo14660(false);
    }
}
