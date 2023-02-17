package com.netflix.mediaclient.acquisition;

import java.util.List;
import java.util.Map;
import o.AbstractC1450Fk;
import o.AbstractC1451Fl;
import o.C0738;
import o.EA;
public interface BillingManagerInterface {
    void fetchPrices(List<String> list, boolean z, int i, AbstractC1450Fk<? super Map<String, String>, EA> fk);

    void invokePurchase(String str, String str2, int i, String str3, AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl);

    void restoreSubscription(AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl);

    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.netflix.mediaclient.acquisition.BillingManagerInterface */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void invokePurchase$default(BillingManagerInterface billingManagerInterface, String str, String str2, int i, String str3, AbstractC1451Fl fl, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokePurchase");
            }
            if ((i2 & 2) != 0) {
                str2 = "";
            }
            if ((i2 & 4) != 0) {
                i = 30;
            }
            if ((i2 & 8) != 0) {
                str3 = "";
            }
            if ((i2 & 16) != 0) {
                fl = BillingManagerInterface$invokePurchase$1.INSTANCE;
            }
            billingManagerInterface.invokePurchase(str, str2, i, str3, fl);
        }
    }
}
