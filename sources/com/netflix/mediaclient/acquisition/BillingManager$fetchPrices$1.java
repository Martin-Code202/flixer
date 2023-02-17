package com.netflix.mediaclient.acquisition;

import android.util.Log;
import com.netflix.mediaclient.acquisition.util.AUILoggingUtilities;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import o.AbstractC0868;
import o.AbstractC1450Fk;
import o.C0924;
import o.C1438Ey;
import o.EI;
import o.ES;
import o.FF;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public final class BillingManager$fetchPrices$1 implements AbstractC0868 {
    final /* synthetic */ AbstractC1450Fk $googlePlayPricesResponseHandler;
    final /* synthetic */ int $retryCount;
    final /* synthetic */ List $skusList;
    final /* synthetic */ boolean $useCachedPrices;
    final /* synthetic */ BillingManager this$0;

    BillingManager$fetchPrices$1(BillingManager billingManager, List list, int i, boolean z, AbstractC1450Fk fk) {
        this.this$0 = billingManager;
        this.$skusList = list;
        this.$retryCount = i;
        this.$useCachedPrices = z;
        this.$googlePlayPricesResponseHandler = fk;
    }

    @Override // o.AbstractC0868
    public final void onSkuDetailsResponse(int i, List<? extends C0924> list) {
        if (i == 0 && list != null && list.size() == this.$skusList.size()) {
            List<? extends C0924> list2 = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap(FF.m4987(ES.m4860(EI.m4812((Iterable) list2, 10)), 16));
            for (T t : list2) {
                Pair r17 = C1438Ey.m4973(t.m15730(), t.m15729());
                linkedHashMap.put(r17.m3221(), r17.m3223());
            }
            BillingManager.access$setCachedPrices$p(this.this$0, linkedHashMap);
            this.$googlePlayPricesResponseHandler.invoke(linkedHashMap);
            AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_PRICE_FETCHING_END, ES.m4862(C1438Ey.m4973("reason", FalkorPathResult.SUCCESS), C1438Ey.m4973(Event.DATA, new JSONObject(ES.m4864(C1438Ey.m4973("skuPriceData", list.toString()))).toString())));
            return;
        }
        Log.e(BillingManager.TAG, "Make sure your device has a Google Play account");
        if (this.$retryCount > 1) {
            this.this$0.fetchPrices(this.$skusList, this.$useCachedPrices, this.$retryCount - 1, this.$googlePlayPricesResponseHandler);
            return;
        }
        this.$googlePlayPricesResponseHandler.invoke(null);
        AUILoggingUtilities.INSTANCE.logDebugEvent(SignupConstants.Events.SIMPLICITY_PRICE_FETCHING_END, ES.m4864(C1438Ey.m4973("reason", "timeout")));
    }
}
