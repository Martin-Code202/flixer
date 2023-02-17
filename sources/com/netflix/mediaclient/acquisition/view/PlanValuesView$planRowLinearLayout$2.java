package com.netflix.mediaclient.acquisition.view;

import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
/* access modifiers changed from: package-private */
public final class PlanValuesView$planRowLinearLayout$2 extends Lambda implements AbstractC1449Fj<ViewGroup> {
    final /* synthetic */ PlanValuesView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlanValuesView$planRowLinearLayout$2(PlanValuesView planValuesView) {
        super(0);
        this.this$0 = planValuesView;
    }

    @Override // o.AbstractC1449Fj
    public final ViewGroup invoke() {
        return (ViewGroup) this.this$0.findViewById(R.id.planChoiceValuesView);
    }
}
