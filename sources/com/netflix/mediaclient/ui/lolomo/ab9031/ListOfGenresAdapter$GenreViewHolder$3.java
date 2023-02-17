package com.netflix.mediaclient.ui.lolomo.ab9031;

import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0344;
import o.C1080;
import o.C1300Ac;
import o.C1457Fr;
import o.C2225uy;
import o.EA;
public final class ListOfGenresAdapter$GenreViewHolder$3 extends Lambda implements AbstractC1450Fk<Integer, EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ PublishSubject f3246;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ C2225uy.C0238 f3247;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListOfGenresAdapter$GenreViewHolder$3(C2225uy.C0238 r2, PublishSubject publishSubject) {
        super(1);
        this.f3247 = r2;
        this.f3246 = publishSubject;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Integer num) {
        m2086(num);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2086(Integer num) {
        List<GenreList> r0 = this.f3247.m11790().mo11734();
        C1457Fr.m5016((Object) num, "position");
        C1300Ac.m3531(new C1080(AppView.categorySelectorItem, this.f3247.m11789(r0.get(num.intValue()))), new C0344(), true);
        this.f3246.onNext(num);
        this.f3247.m11790().m11738(num.intValue());
    }
}
