package com.netflix.mediaclient.ui.feeds;

import com.netflix.cl.model.AppView;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1276;
import o.C1283;
import o.C1300Ac;
import o.C1457Fr;
import o.EA;
import o.rW;
import o.rZ;
public final class TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$5 extends Lambda implements AbstractC1450Fk<Boolean, EA> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ rW f3134;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ rZ.Cif f3135;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewHolders$TitleWithTrailer$subscribeTo$5(rZ.Cif ifVar, rW rWVar) {
        super(1);
        this.f3135 = ifVar;
        this.f3134 = rWVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(Boolean bool) {
        m1915(bool);
        return EA.f5503;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1915(Boolean bool) {
        C1283.m16854(rZ.Cif.m10253(this.f3135, (String) null, 1, (Object) null), "highlight(" + this.f3135.getAdapterPosition() + ") " + bool);
        if (C1457Fr.m5018(this.f3135.f9750, this.f3134)) {
            C1283.m16854(rZ.Cif.m10253(this.f3135, (String) null, 1, (Object) null), "highlight(" + this.f3135.getAdapterPosition() + ") " + bool);
            rZ.Cif ifVar = this.f3135;
            C1457Fr.m5016((Object) bool, "highlight");
            rZ.Cif.m10276(ifVar, bool.booleanValue(), false, 2, null);
            if (!bool.booleanValue()) {
                C1283.m16854(rZ.Cif.m10253(this.f3135, (String) null, 1, (Object) null), "auto-pause(" + this.f3135.getAdapterPosition() + ')');
                this.f3135.f9764 = true;
                this.f3135.m10293(false);
                this.f3135.m10252().m16048("highlight-auto-pause");
            } else if (this.f3135.m10265().m2331() && this.f3135.f9764) {
                this.f3135.m10295(false);
                this.f3135.m10252().m16048("highlight-auto-resume");
            }
            if (bool.booleanValue()) {
                String r7 = this.f3134.mo4199();
                String r8 = this.f3134.mo4203();
                if (r7 == null || r8 == null) {
                    C1276.m16820().mo5725("item without videoId/imageId");
                    return;
                }
                TrailersFeedItemSummary r9 = this.f3135.f9754.m1951();
                if (r9 != null) {
                    C1300Ac.m3530(r9.getId(), this.f3135.f9754.m1925(), r7, r8, this.f3134.m10212(), this.f3134.m10214(), AppView.previews);
                    return;
                }
                return;
            }
            return;
        }
        C1283.m16854(rZ.Cif.m10253(this.f3135, (String) null, 1, (Object) null), "highlight(" + this.f3135.getAdapterPosition() + ") " + bool + " but invalid data");
    }
}
