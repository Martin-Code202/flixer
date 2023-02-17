package com.netflix.mediaclient.acquisition.fragments;

import java.util.HashMap;
import java.util.Map;
import o.C0524;
import o.C0834;
import org.json.JSONObject;
public final class CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$1 extends C0834 {
    final /* synthetic */ CreditPaymentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreditPaymentFragment$fetchSecureMOPKey$secureMOPRequest$1(CreditPaymentFragment creditPaymentFragment, int i, String str, JSONObject jSONObject, C0524.If r11, C0524.AbstractC2398iF iFVar) {
        super(i, str, jSONObject, r11, iFVar);
        this.this$0 = creditPaymentFragment;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }
}
