package com.netflix.mediaclient.ui.iris.notifications.multititle;

import android.arch.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.sR;
public final class MultiTitleNotificationsActivity$viewModel$2 extends Lambda implements AbstractC1449Fj<MultiTitleNotificationViewModel> {

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ sR f3167;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTitleNotificationsActivity$viewModel$2(sR sRVar) {
        super(0);
        this.f3167 = sRVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final MultiTitleNotificationViewModel invoke() {
        return (MultiTitleNotificationViewModel) ViewModelProviders.of(this.f3167).get(MultiTitleNotificationViewModel.class);
    }
}
