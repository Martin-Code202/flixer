package com.netflix.mediaclient.acquisition.fragments;

import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.view.PlanValuesView;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0786;
import o.C1070;
import o.C1457Fr;
import o.EA;
/* access modifiers changed from: package-private */
public final class PlanSelectionFragment$initPlanChoiceHeader$1 extends Lambda implements AbstractC1450Fk<String, EA> {
    final /* synthetic */ PlanSelectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlanSelectionFragment$initPlanChoiceHeader$1(PlanSelectionFragment planSelectionFragment) {
        super(1);
        this.this$0 = planSelectionFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* bridge */ /* synthetic */ EA invoke(String str) {
        invoke(str);
        return EA.f5503;
    }

    public final void invoke(String str) {
        C1457Fr.m5025(str, "planType");
        this.this$0.getPlanSelectionModel().setPlanSelected(str);
        Long r3 = Logger.INSTANCE.m142(new C0786(str));
        Long r4 = Logger.INSTANCE.m142(new C1070(str));
        ((PlanValuesView) this.this$0._$_findCachedViewById(R.Cif.planChoiceValuesView)).selectPlan(this.this$0.getPlanSelectionModel().getPlanSelected(), this.this$0.getPlanSelectionModel().getPlanOfferIds());
        Logger.INSTANCE.m140(r4);
        Logger.INSTANCE.m140(r3);
    }
}
