package com.netflix.mediaclient.ui.lolomo.ab9031;

import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.EA;
public final class ListOfGenresAdapter$GenreViewHolder$5 extends Lambda implements AbstractC1449Fj<EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ PublishSubject f3249;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListOfGenresAdapter$GenreViewHolder$5(PublishSubject publishSubject) {
        super(0);
        this.f3249 = publishSubject;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // o.AbstractC1449Fj
    public /* synthetic */ EA invoke() {
        m2088();
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2088() {
        this.f3249.onComplete();
    }
}
