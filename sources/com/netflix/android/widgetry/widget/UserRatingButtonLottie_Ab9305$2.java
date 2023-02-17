package com.netflix.android.widgetry.widget;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
public final class UserRatingButtonLottie_Ab9305$2 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final UserRatingButtonLottie_Ab9305$2 f165 = new UserRatingButtonLottie_Ab9305$2();

    UserRatingButtonLottie_Ab9305$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m112(th);
        return EA.f5503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m112(Throwable th) {
        C1457Fr.m5025(th, "e");
        C1276.m16820().mo5729("Unable to load the thumbs lottie file, ratings is unclickable", th);
    }
}
