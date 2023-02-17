package com.netflix.mediaclient.ui.lolomo.ab9031;

import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0344;
import o.C1080;
import o.C1300Ac;
import o.C1317As;
import o.C1457Fr;
import o.C2221uu;
import o.C2222uv;
import o.EA;
public final class GenresActionBarPresenter$onCreate$1 extends Lambda implements AbstractC1450Fk<View, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ C2221uu f3239;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenresActionBarPresenter$onCreate$1(C2221uu uuVar) {
        super(1);
        this.f3239 = uuVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(View view) {
        m2079(view);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2079(View view) {
        C1457Fr.m5025(view, "<anonymous parameter 0>");
        if (!C1317As.m3750(this.f3239.f11029)) {
            GenreList r4 = C2222uv.f11041.m11779("lolomo");
            if (!C1457Fr.m5018(r4, C2222uv.f11041.m11774())) {
                C1300Ac.m3531(new C1080(AppView.netflixLogo, null), new C0344(), true);
                this.f3239.f11029.m10798(r4, "lolomo");
            }
        }
    }
}
