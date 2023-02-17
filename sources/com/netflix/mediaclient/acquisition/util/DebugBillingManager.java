package com.netflix.mediaclient.acquisition.util;

import android.app.Activity;
import java.util.List;
import java.util.Map;
import o.AbstractC1450Fk;
import o.AbstractC1451Fl;
import o.C0738;
import o.C1457Fr;
import o.EA;
public final class DebugBillingManager {
    public DebugBillingManager(Activity activity) {
        C1457Fr.m5025(activity, "activity");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.netflix.mediaclient.acquisition.util.DebugBillingManager */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void invokePurchase$default(DebugBillingManager debugBillingManager, String str, String str2, int i, String str3, AbstractC1451Fl fl, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            fl = DebugBillingManager$invokePurchase$1.INSTANCE;
        }
        debugBillingManager.invokePurchase(str, str2, i, str3, fl);
    }

    public final void invokePurchase(String str, String str2, int i, String str3, AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl) {
        C1457Fr.m5025(str, "sku");
        C1457Fr.m5025(fl, "purchaseHandler");
    }

    public final void fetchPrices(List<String> list, boolean z, AbstractC1450Fk<? super Map<String, String>, EA> fk) {
        C1457Fr.m5025(list, "skusList");
        C1457Fr.m5025(fk, "googlePlayPricesResponseHandler");
    }

    public final void restoreSubscription(AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl) {
        C1457Fr.m5025(fl, "restoreHandler");
    }
}
