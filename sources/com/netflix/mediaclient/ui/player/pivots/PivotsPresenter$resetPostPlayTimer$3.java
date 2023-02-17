package com.netflix.mediaclient.ui.player.pivots;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.C2322xq;
import o.EA;
public final class PivotsPresenter$resetPostPlayTimer$3 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final PivotsPresenter$resetPostPlayTimer$3 f3678 = new PivotsPresenter$resetPostPlayTimer$3();

    PivotsPresenter$resetPostPlayTimer$3() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2612(th);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2612(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5725(C2322xq.f12240.m12990() + "- ON_SHOW_POST_PLAY_MARK onError");
    }
}
