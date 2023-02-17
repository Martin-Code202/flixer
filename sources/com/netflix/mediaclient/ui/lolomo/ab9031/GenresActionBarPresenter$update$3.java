package com.netflix.mediaclient.ui.lolomo.ab9031;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1283;
import o.C1457Fr;
import o.EA;
public final class GenresActionBarPresenter$update$3 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final GenresActionBarPresenter$update$3 f3245 = new GenresActionBarPresenter$update$3();

    GenresActionBarPresenter$update$3() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2085(th);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2085(Throwable th) {
        C1457Fr.m5025(th, "ex");
        C1283.m16855("GenresActionBarPresenter", "subgenres fetchGenres error %s", th);
    }
}
