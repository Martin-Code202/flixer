package com.netflix.mediaclient.ui.lolomo.ab9031;

import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1317As;
import o.C1457Fr;
import o.C2221uu;
import o.EA;
public final class GenresActionBarPresenter$setupPrimaryGenresModel$1 extends Lambda implements AbstractC1450Fk<GenreList, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ C2221uu f3240;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenresActionBarPresenter$setupPrimaryGenresModel$1(C2221uu uuVar) {
        super(1);
        this.f3240 = uuVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(GenreList genreList) {
        m2080(genreList);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2080(GenreList genreList) {
        C1457Fr.m5025(genreList, "genreList");
        if (!C1317As.m3750(this.f3240.f11029)) {
            String id = genreList.getId();
            C1283.m16848("GenresActionBarPresenter", "setSelectedPrimaryGenre filter id: old=%s, new=%s", this.f3240.f11034, id);
            if (!C1457Fr.m5018((Object) this.f3240.f11034, (Object) id)) {
                this.f3240.f11029.m10798(genreList, id);
            }
        }
    }
}
