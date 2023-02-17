package com.netflix.android.kotlinx;

import android.support.v4.app.Fragment;
import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
public final class ButterKnifeKt$viewFinder$7 extends Lambda implements AbstractC1451Fl<Fragment, Integer, View> {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final ButterKnifeKt$viewFinder$7 f152 = new ButterKnifeKt$viewFinder$7();

    ButterKnifeKt$viewFinder$7() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ View invoke(Fragment fragment, Integer num) {
        return m100(fragment, num.intValue());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final View m100(Fragment fragment, int i) {
        C1457Fr.m5025(fragment, "$receiver");
        View view = fragment.getView();
        if (view == null) {
            C1457Fr.m5019();
        }
        return view.findViewById(i);
    }
}
