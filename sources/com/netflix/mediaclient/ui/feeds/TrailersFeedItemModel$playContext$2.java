package com.netflix.mediaclient.ui.feeds;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.oB;
import o.qN;
import o.rW;
public final class TrailersFeedItemModel$playContext$2 extends Lambda implements AbstractC1449Fj<qN> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ rW f3076;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedItemModel$playContext$2(rW rWVar) {
        super(0);
        this.f3076 = rWVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final qN invoke() {
        if (this.f3076.f9720 != null) {
            return new qN(this.f3076.f9720.getRequestId(), this.f3076.f9720.getTrackId(), -1, this.f3076.m10214());
        }
        return new oB("TrailersFeedItemModel");
    }
}
