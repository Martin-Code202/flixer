package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.acquisition.BillingManagerInterface;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
/* access modifiers changed from: package-private */
public final class OrderFinalFragment$fetchPricing$$inlined$let$lambda$1 extends Lambda implements AbstractC1450Fk<Map<String, ? extends String>, EA> {
    final /* synthetic */ BillingManagerInterface $billingManager$inlined;
    final /* synthetic */ OrderFinalFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderFinalFragment$fetchPricing$$inlined$let$lambda$1(OrderFinalFragment orderFinalFragment, BillingManagerInterface billingManagerInterface) {
        super(1);
        this.this$0 = orderFinalFragment;
        this.$billingManager$inlined = billingManagerInterface;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* bridge */ /* synthetic */ EA invoke(Map<String, ? extends String> map) {
        invoke((Map<String, String>) map);
        return EA.f5503;
    }

    public final void invoke(Map<String, String> map) {
        if (map != null) {
            this.this$0.updatePriceStrings(map.get(String.valueOf(this.this$0.getOrderFinalViewModel().getOfferId())));
        }
    }
}
