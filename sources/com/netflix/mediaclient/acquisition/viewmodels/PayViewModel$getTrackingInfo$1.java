package com.netflix.mediaclient.acquisition.viewmodels;

import o.AbstractC0574;
import org.json.JSONArray;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public final class PayViewModel$getTrackingInfo$1 implements AbstractC0574 {
    public static final PayViewModel$getTrackingInfo$1 INSTANCE = new PayViewModel$getTrackingInfo$1();

    PayViewModel$getTrackingInfo$1() {
    }

    @Override // o.AbstractC0503
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("creditOption");
        jSONArray.put("giftOption");
        jSONObject.put("paymentOptions", jSONArray);
        return jSONObject;
    }
}
