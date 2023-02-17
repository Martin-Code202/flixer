package com.netflix.android.kotlinx;

import android.view.View;
import com.netflix.mediaclient.common.ui.LifecycleController;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
public final class ButterKnifeKt$lifecycleFinder$1 extends Lambda implements AbstractC1451Fl<LifecycleController<?>, Integer, View> {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final ButterKnifeKt$lifecycleFinder$1 f145 = new ButterKnifeKt$lifecycleFinder$1();

    ButterKnifeKt$lifecycleFinder$1() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ View invoke(LifecycleController<?> lifecycleController, Integer num) {
        return m95(lifecycleController, num.intValue());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final View m95(LifecycleController<?> lifecycleController, int i) {
        C1457Fr.m5025(lifecycleController, "$receiver");
        return lifecycleController.m457().findViewById(i);
    }
}
