package com.netflix.mediaclient.ui.player.pivots;

import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0409;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2322xq;
import o.EA;
public final class PivotsPresenter$3 extends Lambda implements AbstractC1450Fk<IPlayerFragment.PublisherEvents, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ C2322xq f3662;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PivotsPresenter$3(C2322xq xqVar) {
        super(1);
        this.f3662 = xqVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(IPlayerFragment.PublisherEvents publisherEvents) {
        m2597(publisherEvents);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2597(IPlayerFragment.PublisherEvents publisherEvents) {
        this.f3662.m12969();
        switch (Config_Ab9454_InPlayerPivots.f1097.m534()) {
            case UP_NEXT_BUTTON:
                C2322xq xqVar = this.f3662;
                AbstractC0409 r1 = C2322xq.m12977(this.f3662, true, PivotsUIView.PivotsListVisibility.HIDE, false, true, null, null, null, -1, false, 372, null);
                C1457Fr.m5016((Object) publisherEvents, "it");
                xqVar.m14156(r1, publisherEvents);
                return;
            case EXPANDED:
                C2322xq xqVar2 = this.f3662;
                AbstractC0409 r12 = C2322xq.m12977(this.f3662, true, PivotsUIView.PivotsListVisibility.SHOW, false, false, null, null, null, -1, false, 372, null);
                C1457Fr.m5016((Object) publisherEvents, "it");
                xqVar2.m14156(r12, publisherEvents);
                return;
            case COLLAPSED:
                C2322xq xqVar3 = this.f3662;
                AbstractC0409 r13 = C2322xq.m12977(this.f3662, true, PivotsUIView.PivotsListVisibility.SHOW_PARTIALLY, false, true, null, null, null, -1, false, 116, null);
                C1457Fr.m5016((Object) publisherEvents, "it");
                xqVar3.m14156(r13, publisherEvents);
                return;
            default:
                return;
        }
    }
}
