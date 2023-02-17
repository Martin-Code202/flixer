package com.netflix.mediaclient.acquisition.viewmodels;

import o.AbstractC0574;
import org.json.JSONArray;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public final class PlanSelectionViewModel$getTrackingInfo$1 implements AbstractC0574 {
    final /* synthetic */ PlanSelectionViewModel this$0;

    PlanSelectionViewModel$getTrackingInfo$1(PlanSelectionViewModel planSelectionViewModel) {
        this.this$0 = planSelectionViewModel;
    }

    @Override // o.AbstractC0503
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("defaultPlan", this.this$0.getDefaultSelectedPlan());
        JSONArray jSONArray = new JSONArray();
        for (String str : this.this$0.getPlanOfferIds()) {
            jSONArray.put(str);
        }
        jSONObject.put("planOptions", jSONArray);
        return jSONObject;
    }
}
