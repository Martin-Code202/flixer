package com.netflix.mediaclient.ui.feeds;

import com.netflix.model.leafs.originals.ListOfTagSummary;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.rW;
import org.json.JSONObject;
public final class TrailersFeedItemModel$tagsTrackingInfo$2 extends Lambda implements AbstractC1449Fj<JSONObject> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ rW f3077;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedItemModel$tagsTrackingInfo$2(rW rWVar) {
        super(0);
        this.f3077 = rWVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final JSONObject invoke() {
        ListOfTagSummary[] r0 = this.f3077.mo4191();
        if (r0 != null) {
            if (!(r0.length == 0)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (ListOfTagSummary listOfTagSummary : this.f3077.f9716) {
                    jSONObject2.put(listOfTagSummary.getId(), listOfTagSummary.getPosition());
                }
                jSONObject.put("titleDescriptorTagMap", jSONObject2);
                return jSONObject;
            }
        }
        return null;
    }
}
