package com.netflix.mediaclient.ui.previews;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1457Fr;
import o.EA;
public final class PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$3 extends Lambda implements AbstractC1450Fk<Throwable, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$3 f3824 = new PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$3();

    PreviewsTitleBarAdapter$PreviewsTitleBarViewHolder$onAttach$3() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Throwable th) {
        m2762(th);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m2762(Throwable th) {
        C1457Fr.m5025(th, "it");
        C1276.m16820().mo5725("progress update error - " + th);
    }
}
