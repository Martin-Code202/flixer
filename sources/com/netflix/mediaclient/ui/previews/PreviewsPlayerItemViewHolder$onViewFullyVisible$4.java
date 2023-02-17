package com.netflix.mediaclient.ui.previews;

import com.netflix.mediaclient.servicemgr.IPlayer;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2369ze;
import o.EA;
import o.yS;
public final class PreviewsPlayerItemViewHolder$onViewFullyVisible$4 extends Lambda implements AbstractC1450Fk<IPlayer.aux, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ yS f3816;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewsPlayerItemViewHolder$onViewFullyVisible$4(yS ySVar) {
        super(1);
        this.f3816 = ySVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(IPlayer.aux aux) {
        m2754(aux);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2754(IPlayer.aux aux) {
        if (this.f3816.f12438 < 3) {
            this.f3816.m13276(true);
            yS ySVar = this.f3816;
            StringBuilder append = new StringBuilder().append("retry on playback error - (");
            C1457Fr.m5016((Object) aux, "playbackError");
            ySVar.m13269(append.append(aux.mo1000()).append(')').toString());
            this.f3816.f12438++;
            return;
        }
        PublishSubject publishSubject = this.f3816.f12434;
        if (publishSubject != null) {
            publishSubject.onNext(new C2369ze.Cif.If(this.f3816.getAdapterPosition()));
        }
    }
}
