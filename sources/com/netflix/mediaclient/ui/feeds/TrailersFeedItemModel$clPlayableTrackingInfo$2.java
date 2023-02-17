package com.netflix.mediaclient.ui.feeds;

import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import kotlin.jvm.internal.Lambda;
import o.AbstractC0574;
import o.AbstractC1449Fj;
import o.C1457Fr;
import o.pF;
import o.rW;
import org.json.JSONObject;
public final class TrailersFeedItemModel$clPlayableTrackingInfo$2 extends Lambda implements AbstractC1449Fj<AbstractC0574> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ rW f3074;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedItemModel$clPlayableTrackingInfo$2(rW rWVar) {
        super(0);
        this.f3074 = rWVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final AbstractC0574 invoke() {
        return new AbstractC0574(this) { // from class: com.netflix.mediaclient.ui.feeds.TrailersFeedItemModel$clPlayableTrackingInfo$2.3

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ TrailersFeedItemModel$clPlayableTrackingInfo$2 f3075;

            {
                this.f3075 = r1;
            }

            @Override // o.AbstractC0503
            public final JSONObject toJSONObject() {
                pF r4 = this.f3075.f3074.mo4192();
                if (r4 == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uiLabel", "" + AppView.previews);
                jSONObject.put("location", UiLocation.BROWSE.m1563());
                TrailersFeedItemSummary trailersFeedItemSummary = this.f3075.f3074.f9720;
                if (trailersFeedItemSummary != null) {
                    jSONObject.put("listId", trailersFeedItemSummary.getId());
                    jSONObject.put("requestId", trailersFeedItemSummary.getRequestId());
                    jSONObject.put("trackId", trailersFeedItemSummary.getTrackId());
                }
                C1457Fr.m5016((Object) r4, "it");
                jSONObject.put("videoId", r4.getPlayableId());
                jSONObject.put("row", 0);
                jSONObject.put("rank", this.f3075.f3074.m10214());
                return jSONObject;
            }
        };
    }
}
