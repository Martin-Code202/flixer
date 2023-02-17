package com.netflix.android.kotlinx;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
public final class ButterKnifeKt$viewFinder$8 extends Lambda implements AbstractC1451Fl<RecyclerView.ViewHolder, Integer, View> {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final ButterKnifeKt$viewFinder$8 f153 = new ButterKnifeKt$viewFinder$8();

    ButterKnifeKt$viewFinder$8() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ View invoke(RecyclerView.ViewHolder viewHolder, Integer num) {
        return m101(viewHolder, num.intValue());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final View m101(RecyclerView.ViewHolder viewHolder, int i) {
        C1457Fr.m5025(viewHolder, "$receiver");
        return viewHolder.itemView.findViewById(i);
    }
}
