package com.netflix.mediaclient.ui.previews;

import android.support.v4.app.FragmentActivity;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.C1457Fr;
import o.C2365za;
import o.EA;
public final class PreviewsSlideShowFragment$onCreateView$1 extends Lambda implements AbstractC1449Fj<EA> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ C2365za f3818;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewsSlideShowFragment$onCreateView$1(C2365za zaVar) {
        super(0);
        this.f3818 = zaVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // o.AbstractC1449Fj
    public /* synthetic */ EA invoke() {
        m2756();
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2756() {
        FragmentActivity activity = this.f3818.getActivity();
        if (activity != null) {
            C1457Fr.m5016((Object) activity, "activity");
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
