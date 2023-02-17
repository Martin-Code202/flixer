package com.netflix.mediaclient.ui.iris.notifications.multititle;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.C1462Fw;
import o.EA;
import o.sP;
final class MultiTitleNotificationViewModel$updateRows$2 extends Lambda implements AbstractC1450Fk<Object[], EA> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ List f3163;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiTitleNotificationViewModel$updateRows$2(List list) {
        super(1);
        this.f3163 = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Object[] objArr) {
        m1973(objArr);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1973(Object[] objArr) {
        C1457Fr.m5025(objArr, "heroTitles");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.HeroTitle");
            }
            if (((sP) obj).m10632() == null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List list = this.f3163;
        if (list == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
        C1462Fw.m5043(list).removeAll(arrayList2);
    }
}
