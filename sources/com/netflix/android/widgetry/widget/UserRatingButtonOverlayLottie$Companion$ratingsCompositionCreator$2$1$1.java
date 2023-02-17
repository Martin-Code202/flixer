package com.netflix.android.widgetry.widget;

import io.reactivex.SingleEmitter;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0676;
import o.C1269;
import o.EA;
final class UserRatingButtonOverlayLottie$Companion$ratingsCompositionCreator$2$1$1 extends Lambda implements AbstractC1450Fk<C0676, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ SingleEmitter f167;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRatingButtonOverlayLottie$Companion$ratingsCompositionCreator$2$1$1(SingleEmitter singleEmitter) {
        super(1);
        this.f167 = singleEmitter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(C0676 r2) {
        m114(r2);
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m114(C0676 r2) {
        C1269.C1271.m16794(C1269.f15922, r2);
        this.f167.onSuccess(r2);
    }
}
