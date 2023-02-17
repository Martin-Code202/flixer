package com.netflix.mediaclient.ui.player.v2.presenter;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
import o.xH;
import o.xX;
public final class PlayerSkipCreditsUIPresenter$5 extends Lambda implements AbstractC1450Fk<xH, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ xX f3780;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerSkipCreditsUIPresenter$5(xX xXVar) {
        super(1);
        this.f3780 = xXVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(xH xHVar) {
        m2710(xHVar);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2710(xH xHVar) {
        if (C1457Fr.m5018(xHVar, xH.C2287AUx.f11975)) {
            this.f3780.m12867(true);
            this.f3780.f12107.mo2734(R.string.label_skip_intro_button);
            this.f3780.f12107.mo2737(IPlayerSkipCreditsUIView.SkipCreditsType.INTRO);
            this.f3780.f12107.mo13088();
        } else if (C1457Fr.m5018(xHVar, xH.C0262.f11994)) {
            this.f3780.m12867(true);
            this.f3780.f12107.mo2734(R.string.label_skip_recap_button);
            this.f3780.f12107.mo2737(IPlayerSkipCreditsUIView.SkipCreditsType.RECAP);
            this.f3780.f12107.mo13088();
        }
    }
}
