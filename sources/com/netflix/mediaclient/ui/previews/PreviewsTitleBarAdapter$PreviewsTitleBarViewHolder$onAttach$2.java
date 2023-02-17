package com.netflix.mediaclient.ui.previews;

import android.widget.ProgressBar;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C2367zc;
import o.EA;
public final class PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$2 extends Lambda implements AbstractC1450Fk<Integer, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ C2367zc.Cif f3823;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$2(C2367zc.Cif ifVar) {
        super(1);
        this.f3823 = ifVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Integer num) {
        m2761(num);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2761(Integer num) {
        ProgressBar progressBar = this.f3823.m13597();
        C1457Fr.m5016((Object) num, "progress");
        progressBar.setProgress(num.intValue());
    }
}
