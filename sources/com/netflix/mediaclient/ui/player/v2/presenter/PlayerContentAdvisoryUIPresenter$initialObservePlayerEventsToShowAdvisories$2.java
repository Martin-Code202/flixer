package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.model.leafs.advisory.Advisory;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.EA;
import o.xH;
import o.xN;
public final class PlayerContentAdvisoryUIPresenter$initialObservePlayerEventsToShowAdvisories$2 extends Lambda implements AbstractC1450Fk<Pair<? extends xH, ? extends LinkedHashMap<Advisory, Boolean>>, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ xN f3726;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerContentAdvisoryUIPresenter$initialObservePlayerEventsToShowAdvisories$2(xN xNVar) {
        super(1);
        this.f3726 = xNVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Pair<? extends xH, ? extends LinkedHashMap<Advisory, Boolean>> pair) {
        m2659(pair);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2659(Pair<? extends xH, ? extends LinkedHashMap<Advisory, Boolean>> pair) {
        C1283.m16851("AdvisoryUIPresenter", "Showing Advisories if any. Size is %s", Integer.valueOf(((LinkedHashMap) pair.m3223()).size()));
        this.f3726.m12814((LinkedHashMap) pair.m3223());
        this.f3726.m12810();
    }
}
