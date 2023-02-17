package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.mediaclient.acquisition.BillingManagerInterface;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.EA;
/* access modifiers changed from: package-private */
public final class ConfirmFragment$fetchPricing$$inlined$let$lambda$1 extends Lambda implements AbstractC1450Fk<Map<String, ? extends String>, EA> {
    final /* synthetic */ BillingManagerInterface $billingManager$inlined;
    final /* synthetic */ ConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConfirmFragment$fetchPricing$$inlined$let$lambda$1(ConfirmFragment confirmFragment, BillingManagerInterface billingManagerInterface) {
        super(1);
        this.this$0 = confirmFragment;
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
            String str = map.get(String.valueOf(this.this$0.getConfirmViewModel().getOfferId()));
            this.this$0.getConfirmViewModel().setPriceString(str);
            if (str != null) {
                this.this$0.updatePriceStrings(str);
            }
        } else if (this.this$0.getConfirmViewModel().getPriceString() != null) {
            ConfirmFragment confirmFragment = this.this$0;
            String priceString = this.this$0.getConfirmViewModel().getPriceString();
            if (priceString == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            confirmFragment.updatePriceStrings(priceString);
        }
    }
}
