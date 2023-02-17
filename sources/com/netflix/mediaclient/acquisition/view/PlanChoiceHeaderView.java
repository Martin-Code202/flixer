package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.List;
import o.AbstractC1450Fk;
import o.C1456Fq;
import o.C1457Fr;
import o.EA;
public final class PlanChoiceHeaderView extends LinearLayout {
    private HashMap _$_findViewCache;
    private AbstractC1450Fk<? super String, EA> onPlanChanged;
    private PlanButtonView planHeaderView;

    public PlanChoiceHeaderView(Context context) {
        this(context, null, 2, null);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlanChoiceHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C1457Fr.m5025(context, "context");
        this.onPlanChanged = PlanChoiceHeaderView$onPlanChanged$1.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlanChoiceHeaderView(Context context, AttributeSet attributeSet, int i, C1456Fq fq) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: o.Fk<? super java.lang.String, o.EA>, o.Fk<java.lang.String, o.EA> */
    public final AbstractC1450Fk<String, EA> getOnPlanChanged() {
        return this.onPlanChanged;
    }

    public final void setOnPlanChanged(AbstractC1450Fk<? super String, EA> fk) {
        C1457Fr.m5025(fk, "<set-?>");
        this.onPlanChanged = fk;
    }

    public final void addPlanChoiceHeaderLayout(String str, List<String> list, List<String> list2) {
        C1457Fr.m5025(list, "planNamesList");
        C1457Fr.m5025(list2, "planOfferIdList");
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        this.planHeaderView = new PlanButtonView(context, null, 2, null);
        PlanButtonView planButtonView = this.planHeaderView;
        if (planButtonView == null) {
            C1457Fr.m5017("planHeaderView");
        }
        planButtonView.setPlanHeaderValues(list);
        PlanButtonView planButtonView2 = this.planHeaderView;
        if (planButtonView2 == null) {
            C1457Fr.m5017("planHeaderView");
        }
        addView(planButtonView2);
        if ((!list2.isEmpty()) && list2.size() == 3) {
            if (str != null) {
                selectPlanButton(list2.indexOf(str));
            }
            PlanButtonView planButtonView3 = this.planHeaderView;
            if (planButtonView3 == null) {
                C1457Fr.m5017("planHeaderView");
            }
            planButtonView3.getPlan1SButton().setOnClickListener(new PlanChoiceHeaderView$addPlanChoiceHeaderLayout$1(this, list2));
            PlanButtonView planButtonView4 = this.planHeaderView;
            if (planButtonView4 == null) {
                C1457Fr.m5017("planHeaderView");
            }
            planButtonView4.getPlan2SButton().setOnClickListener(new PlanChoiceHeaderView$addPlanChoiceHeaderLayout$2(this, list2));
            PlanButtonView planButtonView5 = this.planHeaderView;
            if (planButtonView5 == null) {
                C1457Fr.m5017("planHeaderView");
            }
            planButtonView5.getPlan4SButton().setOnClickListener(new PlanChoiceHeaderView$addPlanChoiceHeaderLayout$3(this, list2));
        }
    }

    public final void selectPlanButton(int i) {
        PlanButtonView planButtonView = this.planHeaderView;
        if (planButtonView == null) {
            C1457Fr.m5017("planHeaderView");
        }
        planButtonView.getPlan1SButton().setSelected(i == 0);
        PlanButtonView planButtonView2 = this.planHeaderView;
        if (planButtonView2 == null) {
            C1457Fr.m5017("planHeaderView");
        }
        planButtonView2.getPlan2SButton().setSelected(i == 1);
        PlanButtonView planButtonView3 = this.planHeaderView;
        if (planButtonView3 == null) {
            C1457Fr.m5017("planHeaderView");
        }
        planButtonView3.getPlan4SButton().setSelected(i == 2);
    }
}
