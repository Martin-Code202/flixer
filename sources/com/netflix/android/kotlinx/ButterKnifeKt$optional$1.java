package com.netflix.android.kotlinx;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1457Fr;
import o.FQ;
public final class ButterKnifeKt$optional$1 extends Lambda implements AbstractC1451Fl<T, FQ<?>, V> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ AbstractC1451Fl f146;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ int f147;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButterKnifeKt$optional$1(AbstractC1451Fl fl, int i) {
        super(2);
        this.f146 = fl;
        this.f147 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final V invoke(T t, FQ<?> fq) {
        C1457Fr.m5025(fq, "desc");
        return (V) ((View) this.f146.invoke(t, Integer.valueOf(this.f147)));
    }
}
