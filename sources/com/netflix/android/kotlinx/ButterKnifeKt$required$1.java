package com.netflix.android.kotlinx;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1197;
import o.C1457Fr;
import o.FQ;
public final class ButterKnifeKt$required$1 extends Lambda implements AbstractC1451Fl<T, FQ<?>, V> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ int f148;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ AbstractC1451Fl f149;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButterKnifeKt$required$1(AbstractC1451Fl fl, int i) {
        super(2);
        this.f149 = fl;
        this.f148 = i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final V invoke(T t, FQ<?> fq) {
        C1457Fr.m5025(fq, "desc");
        V v = (V) ((View) this.f149.invoke(t, Integer.valueOf(this.f148)));
        if (v != null) {
            return v;
        }
        Void unused = C1197.m16469(this.f148, fq);
        throw null;
    }
}
