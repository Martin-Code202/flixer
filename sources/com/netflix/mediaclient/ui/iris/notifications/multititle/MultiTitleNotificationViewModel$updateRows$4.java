package com.netflix.mediaclient.ui.iris.notifications.multititle;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.C1462Fw;
import o.EA;
import o.sW;
final class MultiTitleNotificationViewModel$updateRows$4 extends Lambda implements AbstractC1449Fj<EA> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ List f3165;

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ MultiTitleNotificationViewModel f3166;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiTitleNotificationViewModel$updateRows$4(MultiTitleNotificationViewModel multiTitleNotificationViewModel, List list) {
        super(0);
        this.f3166 = multiTitleNotificationViewModel;
        this.f3165 = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // o.AbstractC1449Fj
    public /* synthetic */ EA invoke() {
        m1975();
        return EA.f5503;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1975() {
        List<sW> value = this.f3166.m1970().getValue();
        if (value == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationsRow>");
        }
        C1462Fw.m5045(value).addAll(this.f3165);
        this.f3166.m1970().postValue(this.f3166.m1970().getValue());
    }
}
