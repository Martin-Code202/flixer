package com.netflix.android.kotlinx;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1133;
import o.C1457Fr;
public final class ButterKnifeKt$viewFinder$10 extends Lambda implements AbstractC1451Fl<C1133.Cif, Integer, View> {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final ButterKnifeKt$viewFinder$10 f151 = new ButterKnifeKt$viewFinder$10();

    ButterKnifeKt$viewFinder$10() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ View invoke(C1133.Cif ifVar, Integer num) {
        return m99(ifVar, num.intValue());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final View m99(C1133.Cif ifVar, int i) {
        C1457Fr.m5025(ifVar, "$receiver");
        return ifVar.m16309().findViewById(i);
    }
}
