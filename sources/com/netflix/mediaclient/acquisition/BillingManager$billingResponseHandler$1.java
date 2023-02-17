package com.netflix.mediaclient.acquisition;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C0738;
import o.EA;
final class BillingManager$billingResponseHandler$1 extends Lambda implements AbstractC1451Fl<Integer, List<? extends C0738>, EA> {
    public static final BillingManager$billingResponseHandler$1 INSTANCE = new BillingManager$billingResponseHandler$1();

    BillingManager$billingResponseHandler$1() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ EA invoke(Integer num, List<? extends C0738> list) {
        invoke(num.intValue(), list);
        return EA.f5503;
    }

    public final void invoke(int i, List<? extends C0738> list) {
    }
}
