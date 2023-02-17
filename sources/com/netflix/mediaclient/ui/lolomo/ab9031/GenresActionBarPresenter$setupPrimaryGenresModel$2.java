package com.netflix.mediaclient.ui.lolomo.ab9031;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1457Fr;
import o.EA;
public final class GenresActionBarPresenter$setupPrimaryGenresModel$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final GenresActionBarPresenter$setupPrimaryGenresModel$2 f3241 = new GenresActionBarPresenter$setupPrimaryGenresModel$2();

    GenresActionBarPresenter$setupPrimaryGenresModel$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2081(th);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2081(Throwable th) {
        C1457Fr.m5025(th, "ex");
        C1283.m16868("GenresActionBarPresenter", th, "primary fetchGenres error %s", th);
    }
}
