package com.netflix.mediaclient.ui.lolomo.ab9031;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
public final class GenresActionBarPresenter$setupSubGenresModel$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final GenresActionBarPresenter$setupSubGenresModel$2 f3243 = new GenresActionBarPresenter$setupSubGenresModel$2();

    GenresActionBarPresenter$setupSubGenresModel$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2083(th);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m2083(Throwable th) {
        C1457Fr.m5025(th, "ex");
        C1276.m16820().mo5729("subGenresModel.changes error %s", th);
    }
}
