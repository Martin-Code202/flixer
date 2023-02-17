package com.netflix.android.widgetry.widget;

import io.reactivex.SingleEmitter;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.EA;
final class UserRatingButtonOverlayLottie$Companion$ratingsCompositionCreator$2$1$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ SingleEmitter f168;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRatingButtonOverlayLottie$Companion$ratingsCompositionCreator$2$1$2(SingleEmitter singleEmitter) {
        super(1);
        this.f168 = singleEmitter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m115(th);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m115(Throwable th) {
        C1457Fr.m5025(th, "e");
        this.f168.onError(th);
    }
}
