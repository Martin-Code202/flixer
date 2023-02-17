package com.netflix.android.kotlinx;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0467;
import o.AbstractC1451Fl;
import o.C1457Fr;
public final class ButterKnifeKt$viewFinder$9 extends Lambda implements AbstractC1451Fl<AbstractC0467, Integer, View> {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final ButterKnifeKt$viewFinder$9 f154 = new ButterKnifeKt$viewFinder$9();

    ButterKnifeKt$viewFinder$9() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ View invoke(AbstractC0467 r3, Integer num) {
        return m102(r3, num.intValue());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final View m102(AbstractC0467 r2, int i) {
        C1457Fr.m5025(r2, "$receiver");
        return r2.m14352().findViewById(i);
    }
}
