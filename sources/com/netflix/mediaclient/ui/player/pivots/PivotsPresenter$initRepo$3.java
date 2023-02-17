package com.netflix.mediaclient.ui.player.pivots;

import android.util.Pair;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0385;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C1462Fw;
import o.C2322xq;
import o.CH;
import o.EA;
public final class PivotsPresenter$initRepo$3 extends Lambda implements AbstractC1450Fk<Pair<Status, List<? extends CH>>, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ C2322xq f3670;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PivotsPresenter$initRepo$3(C2322xq xqVar) {
        super(1);
        this.f3670 = xqVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Pair<Status, List<? extends CH>> pair) {
        m2605(pair);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2605(Pair<Status, List<CH>> pair) {
        C1457Fr.m5025(pair, "it");
        Status status = (Status) pair.first;
        List list = (List) pair.second;
        C1457Fr.m5016((Object) status, "res");
        if (status.mo301()) {
            this.f3670.m12970();
            return;
        }
        C2322xq xqVar = this.f3670;
        C2322xq xqVar2 = this.f3670;
        if (list == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.netflix.model.branches.FalkorVideo>");
        }
        AbstractC0385.m14153(xqVar, C2322xq.m12977(xqVar2, false, null, false, false, C1462Fw.m5045(list), PivotsUIView.PivotsListAssetType.HORIZONTAL_BOX_ART, null, 0, false, 463, null), null, 2, null);
    }
}
