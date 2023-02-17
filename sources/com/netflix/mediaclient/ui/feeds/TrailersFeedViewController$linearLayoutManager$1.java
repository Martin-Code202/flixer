package com.netflix.mediaclient.ui.feeds;

import android.content.Context;
import com.netflix.android.widgetry.widget.TrackedLinearLayoutManager;
import o.C1276;
public final class TrailersFeedViewController$linearLayoutManager$1 extends TrackedLinearLayoutManager {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ TrailersFeedViewController f3100;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrailersFeedViewController$linearLayoutManager$1(TrailersFeedViewController trailersFeedViewController, Context context, int i, boolean z) {
        super(context, i, z);
        this.f3100 = trailersFeedViewController;
    }

    @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
    /* renamed from: ˊ */
    public String mo104() {
        return "TrailersFeedViewController";
    }

    @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
    /* renamed from: ˏ */
    public void mo105(String str) {
        C1276.m16820().mo5725("setTrackingName is unsupported");
    }
}
