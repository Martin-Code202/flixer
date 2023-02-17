package com.netflix.mediaclient.ui.lolomo.ab9031;

import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
public final class ListOfGenresAdapter$GenreViewHolder$4 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ PublishSubject f3248;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListOfGenresAdapter$GenreViewHolder$4(PublishSubject publishSubject) {
        super(1);
        this.f3248 = publishSubject;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2087(th);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m2087(Throwable th) {
        C1457Fr.m5025(th, "it");
        this.f3248.onComplete();
    }
}
