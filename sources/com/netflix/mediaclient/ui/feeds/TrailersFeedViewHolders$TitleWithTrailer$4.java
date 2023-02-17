package com.netflix.mediaclient.ui.feeds;

import android.media.AudioManager;
import android.view.View;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.servicemgr.IPlayer;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0534;
import o.C1244;
import o.C1457Fr;
import o.EA;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$4 extends Lambda implements AbstractC1450Fk<EA, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3119;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$4(rZ.Cif ifVar) {
        super(1);
        this.f3119 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(EA ea) {
        m1902(ea);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m1902(EA ea) {
        C1457Fr.m5025(ea, "it");
        if (C1457Fr.m5018(this.f3119.m10265().m2344(), IPlayer.PlayerState.Error)) {
            this.f3119.m10252().m16048("retry-play");
            this.f3119.f9761.m1832();
            this.f3119.m10295(true);
            Logger.INSTANCE.m142(new C1244());
            Logger.INSTANCE.m130("PlayCommand");
            return;
        }
        View view = this.f3119.itemView;
        C1457Fr.m5016((Object) view, "itemView");
        AudioManager audioManager = (AudioManager) view.getContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, audioManager.getStreamVolume(3), 1);
            this.f3119.f9754.m1931(true);
            Logger.INSTANCE.m142(new C0534());
            Logger.INSTANCE.m130("UnmuteCommand");
        }
    }
}
