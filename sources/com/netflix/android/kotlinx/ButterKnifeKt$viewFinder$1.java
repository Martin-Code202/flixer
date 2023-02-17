package com.netflix.android.kotlinx;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
public final class ButterKnifeKt$viewFinder$1 extends Lambda implements AbstractC1451Fl<View, Integer, View> {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final ButterKnifeKt$viewFinder$1 f150 = new ButterKnifeKt$viewFinder$1();

    ButterKnifeKt$viewFinder$1() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ View invoke(View view, Integer num) {
        return m98(view, num.intValue());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final View m98(View view, int i) {
        C1457Fr.m5025(view, "$receiver");
        return view.findViewById(i);
    }
}
