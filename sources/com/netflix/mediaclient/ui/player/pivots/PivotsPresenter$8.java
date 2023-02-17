package com.netflix.mediaclient.ui.player.pivots;

import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import io.reactivex.disposables.Disposable;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0385;
import o.AbstractC0409;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2322xq;
import o.C2325xt;
import o.EA;
public final class PivotsPresenter$8 extends Lambda implements AbstractC1450Fk<IPlayerFragment.PublisherEvents, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ C2322xq f3666;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PivotsPresenter$8(C2322xq xqVar) {
        super(1);
        this.f3666 = xqVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(IPlayerFragment.PublisherEvents publisherEvents) {
        m2601(publisherEvents);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2601(IPlayerFragment.PublisherEvents publisherEvents) {
        this.f3666.m12985().mo2229();
        if (publisherEvents != null) {
            switch (publisherEvents) {
                case ON_PLAYER_BUFFERING:
                    this.f3666.m14156(C2322xq.m12977(this.f3666, false, null, false, false, null, null, null, 0, false, 510, null), publisherEvents);
                    return;
                case ON_PLAYER_STOPPED:
                    this.f3666.m12969();
                    this.f3666.m14156(C2322xq.m12977(this.f3666, false, null, false, false, null, null, null, -1, false, 382, null), publisherEvents);
                    return;
                case ON_HIDE_PLAYER_CONTROLS:
                    this.f3666.m14156(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.HIDE, false, false, null, null, null, 0, false, 501, null), publisherEvents);
                    return;
                case ON_SHOW_PLAYER_CONTROLS:
                    this.f3666.m14156(C2322xq.m12977(this.f3666, true, C1457Fr.m5018(Config_Ab9454_InPlayerPivots.f1097.m534(), Config_Ab9454_InPlayerPivots.Companion.InitialDisplayExperience.UP_NEXT_BUTTON) ? PivotsUIView.PivotsListVisibility.HIDE : PivotsUIView.PivotsListVisibility.SHOW_PARTIALLY, false, true, null, null, null, 0, false, 244, null), publisherEvents);
                    return;
                case ON_PLAYER_LOADING_NEXT:
                    if (C1457Fr.m5018(this.f3666.m12985().mo2225(), VideoType.EPISODE) || C1457Fr.m5018(this.f3666.m12985().mo2225(), VideoType.SHOW)) {
                        this.f3666.m12984().m13006(this.f3666.m12985().mo2267(), this.f3666.m12985().mo2255());
                    } else {
                        this.f3666.m14156(C2322xq.m12977(this.f3666, false, null, false, false, null, null, null, 0, false, 447, null), publisherEvents);
                    }
                    if (!C1457Fr.m5018(Config_Ab9454_InPlayerPivots.f1097.m537(), Config_Ab9454_InPlayerPivots.Companion.RowType.CONTINUE_WATCHING)) {
                        this.f3666.m12984().m13005(this.f3666.m12985().mo2267(), this.f3666.m12985().mo2225(), this.f3666.m12985().mo2255());
                        return;
                    }
                    return;
                case INTENT_ON_PLAYER_TOUCH_FLING_UP:
                    this.f3666.m14156(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.SHOW, false, false, null, null, null, 0, false, 501, null), publisherEvents);
                    return;
                case INTENT_ON_PLAYER_TOUCH_FLING_DOWN:
                    AbstractC0409 r0 = this.f3666.m14155();
                    if (r0 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
                    } else if (!(!C1457Fr.m5018(((C2325xt) r0).m12995(), PivotsUIView.PivotsListVisibility.HIDE))) {
                        return;
                    } else {
                        if (C1457Fr.m5018(Config_Ab9454_InPlayerPivots.f1097.m534(), Config_Ab9454_InPlayerPivots.Companion.InitialDisplayExperience.UP_NEXT_BUTTON)) {
                            this.f3666.m14156(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.HIDE, true, true, null, null, null, 0, false, 497, null), publisherEvents);
                            return;
                        } else {
                            this.f3666.m14156(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.SHOW_PARTIALLY, false, true, null, null, null, 0, true, 245, null), publisherEvents);
                            return;
                        }
                    }
                case INTENT_CLICK_TO_SHOW_PIVOTS:
                    AbstractC0385.m14153(this.f3666, C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.SHOW, false, false, null, null, null, 0, false, 501, null), null, 2, null);
                    return;
                case INTENT_ON_PLAYER_SNAP_UP:
                    this.f3666.m14154(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.SHOW, false, false, null, null, null, 0, false, 501, null), publisherEvents);
                    return;
                case INTENT_ON_PLAYER_SNAP_DOWN:
                    if (C1457Fr.m5018(Config_Ab9454_InPlayerPivots.f1097.m534(), Config_Ab9454_InPlayerPivots.Companion.InitialDisplayExperience.UP_NEXT_BUTTON)) {
                        this.f3666.m14154(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.HIDE, true, true, null, null, null, 0, false, 497, null), publisherEvents);
                        return;
                    } else {
                        this.f3666.m14154(C2322xq.m12977(this.f3666, false, PivotsUIView.PivotsListVisibility.SHOW_PARTIALLY, false, true, null, null, null, 0, true, 245, null), publisherEvents);
                        return;
                    }
                case ON_DESTROY:
                    this.f3666.m12981().clear();
                    Disposable disposable = this.f3666.f12244;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Disposable disposable2 = this.f3666.f12245;
                    if (disposable2 != null) {
                        disposable2.dispose();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
