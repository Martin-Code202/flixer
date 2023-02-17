package com.netflix.mediaclient.ui.feeds;

import android.app.Application;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.C0371;
import o.C1457Fr;
final class TrailersFeedViewModel$deviceOrientationDetector$2 extends Lambda implements AbstractC1449Fj<C0371> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ TrailersFeedViewModel f3158;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrailersFeedViewModel$deviceOrientationDetector$2(TrailersFeedViewModel trailersFeedViewModel) {
        super(0);
        this.f3158 = trailersFeedViewModel;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final C0371 invoke() {
        Application application = this.f3158.getApplication();
        C1457Fr.m5016((Object) application, "getApplication()");
        return new C0371(application);
    }
}
