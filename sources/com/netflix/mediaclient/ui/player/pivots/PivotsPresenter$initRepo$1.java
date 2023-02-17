package com.netflix.mediaclient.ui.player.pivots;

import android.util.Pair;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0385;
import o.AbstractC1450Fk;
import o.AbstractC2074pw;
import o.C1457Fr;
import o.C1462Fw;
import o.C2322xq;
import o.CH;
import o.EA;
import o.EI;
public final class PivotsPresenter$initRepo$1 extends Lambda implements AbstractC1450Fk<Pair<Status, List<? extends AbstractC2074pw>>, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ C2322xq f3668;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PivotsPresenter$initRepo$1(C2322xq xqVar) {
        super(1);
        this.f3668 = xqVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Pair<Status, List<? extends AbstractC2074pw>> pair) {
        m2603(pair);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2603(Pair<Status, List<AbstractC2074pw>> pair) {
        C1457Fr.m5025(pair, "it");
        Status status = (Status) pair.first;
        List list = (List) pair.second;
        C1457Fr.m5016((Object) status, "res");
        if (status.mo301()) {
            this.f3668.m12970();
            return;
        }
        C2322xq xqVar = this.f3668;
        C2322xq xqVar2 = this.f3668;
        C1457Fr.m5016((Object) list, "cwVideoList");
        List<AbstractC2074pw> list2 = list;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list2, 10));
        for (AbstractC2074pw pwVar : list2) {
            if (pwVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.model.branches.FalkorVideo");
            }
            arrayList.add((CH) pwVar);
        }
        AbstractC0385.m14153(xqVar, C2322xq.m12977(xqVar2, false, null, false, false, C1462Fw.m5045(arrayList), PivotsUIView.PivotsListAssetType.HORIZONTAL_BOX_ART, null, 0, false, 463, null), null, 2, null);
    }
}
