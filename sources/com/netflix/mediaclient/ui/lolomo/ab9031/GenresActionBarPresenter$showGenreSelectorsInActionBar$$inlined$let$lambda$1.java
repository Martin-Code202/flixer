package com.netflix.mediaclient.ui.lolomo.ab9031;

import android.view.View;
import com.netflix.cl.model.AppView;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0344;
import o.C1080;
import o.C1300Ac;
import o.C1457Fr;
import o.C2221uu;
import o.EA;
public final class GenresActionBarPresenter$showGenreSelectorsInActionBar$$inlined$let$lambda$1 extends Lambda implements AbstractC1450Fk<View, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ C2221uu f3237;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenresActionBarPresenter$showGenreSelectorsInActionBar$$inlined$let$lambda$1(C2221uu uuVar) {
        super(1);
        this.f3237 = uuVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(View view) {
        m2077(view);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2077(View view) {
        C1457Fr.m5025(view, "it");
        C1300Ac.m3531(new C1080(AppView.browseTab, this.f3237.m11761(this.f3237.f11034)), new C0344(), true);
        this.f3237.m11748(this.f3237.m11769());
    }
}
