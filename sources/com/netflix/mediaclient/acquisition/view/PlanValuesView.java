package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.viewmodels.PlanGridRowData;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C0549;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.EI;
import o.EL;
import o.FQ;
public final class PlanValuesView extends LinearLayout {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanValuesView.class), "planRowLinearLayout", "getPlanRowLinearLayout()Landroid/view/ViewGroup;"))};
    private HashMap _$_findViewCache;
    private int dividerColorId;
    private int headingTextColorId;
    private int numOfRows;
    private final AbstractC1433Et planRowLinearLayout$delegate;

    public PlanValuesView(Context context) {
        this(context, null, 2, null);
    }

    private final ViewGroup getPlanRowLinearLayout() {
        AbstractC1433Et et = this.planRowLinearLayout$delegate;
        FQ fq = $$delegatedProperties[0];
        return (ViewGroup) et.mo3220();
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
    public PlanValuesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C1457Fr.m5025(context, "context");
        this.planRowLinearLayout$delegate = C1435Ev.m4972(new PlanValuesView$planRowLinearLayout$2(this));
        this.headingTextColorId = R.color.black;
        this.dividerColorId = R.color.signup_divider_light;
        setOrientation(1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlanValuesView(Context context, AttributeSet attributeSet, int i, C1456Fq fq) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final int getHeadingTextColorId() {
        return this.headingTextColorId;
    }

    public final void setHeadingTextColorId(int i) {
        this.headingTextColorId = i;
    }

    public final int getDividerColorId() {
        return this.dividerColorId;
    }

    public final void setDividerColorId(int i) {
        this.dividerColorId = i;
    }

    public static /* synthetic */ void initRows$default(PlanValuesView planValuesView, List list, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        planValuesView.initRows(list, num, num2);
    }

    public final void initRows(List<PlanGridRowData> list, Integer num, Integer num2) {
        C1457Fr.m5025(list, SignupConstants.Field.PLAN_ROWS);
        removeAllRows();
        this.numOfRows = list.size();
        for (EL el : EI.m4842(list)) {
            int r8 = el.m4814();
            PlanGridRowData planGridRowData = (PlanGridRowData) el.m4815();
            if (r8 % 2 == 1) {
                initRow(planGridRowData, num, num2);
            } else {
                initRow$default(this, planGridRowData, null, num2, 2, null);
            }
        }
    }

    static /* synthetic */ void initRow$default(PlanValuesView planValuesView, PlanGridRowData planGridRowData, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        planValuesView.initRow(planGridRowData, num, num2);
    }

    private final void initRow(PlanGridRowData planGridRowData, Integer num, Integer num2) {
        if (!(!planGridRowData.getValues().isEmpty())) {
            addPlanValueRowImageLayout(planGridRowData.getLocalizedHeading(), planGridRowData.getValues(), num, num2);
        } else if ((planGridRowData.getValues().get(0) instanceof String) || (planGridRowData.getValues().get(0) instanceof Double)) {
            addPlanValueRowLayout(planGridRowData.getLocalizedHeading(), planGridRowData.getValues(), num, num2);
        } else if (planGridRowData.getValues().get(0) instanceof Boolean) {
            addPlanValueRowImageLayout(planGridRowData.getLocalizedHeading(), planGridRowData.getValues(), num, num2);
        }
    }

    public static /* synthetic */ void addPlanValueRowLayout$default(PlanValuesView planValuesView, String str, List list, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        planValuesView.addPlanValueRowLayout(str, list, num, num2);
    }

    public final void addPlanValueRowLayout(String str, List<? extends Object> list, Integer num, Integer num2) {
        C1457Fr.m5025(list, "planValuesList");
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        PlanRowTextView planRowTextView = new PlanRowTextView(context, this.headingTextColorId, this.dividerColorId, null, 8, null);
        planRowTextView.setPlanRowValues(str, list);
        if (num != null) {
            planRowTextView.setBackgroundColor(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            View bottomDivider = planRowTextView.getBottomDivider();
            if (bottomDivider != null) {
                bottomDivider.setBackgroundColor(num2.intValue());
            }
        }
        getPlanRowLinearLayout().addView(planRowTextView);
    }

    static /* synthetic */ void addPlanValueRowImageLayout$default(PlanValuesView planValuesView, String str, List list, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        planValuesView.addPlanValueRowImageLayout(str, list, num, num2);
    }

    private final void addPlanValueRowImageLayout(String str, List<? extends Object> list, Integer num, Integer num2) {
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        PlanRowImageView planRowImageView = new PlanRowImageView(context, this.headingTextColorId, this.dividerColorId, null, 8, null);
        if (getPlanRowLinearLayout().getChildCount() == this.numOfRows - 1) {
            planRowImageView.hideBottomDivider();
        }
        planRowImageView.setPlanRowValues(str, list);
        if (num != null) {
            planRowImageView.setBackgroundColor(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            View bottomDivider = planRowImageView.getBottomDivider();
            if (bottomDivider != null) {
                bottomDivider.setBackgroundColor(num2.intValue());
            }
        }
        getPlanRowLinearLayout().addView(planRowImageView);
    }

    private final void removeAllRows() {
        getPlanRowLinearLayout().removeAllViews();
    }

    public final void selectPlan(String str, List<String> list) {
        C1457Fr.m5025(list, "offerIdList");
        if (str != null) {
            int indexOf = list.indexOf(str);
            for (View view : C0549.m14593(getPlanRowLinearLayout())) {
                if (view instanceof PlanRowTextView) {
                    ((PlanRowTextView) view).getPlan1STextView().setActivated(indexOf == 0);
                    ((PlanRowTextView) view).getPlan2STextView().setActivated(indexOf == 1);
                    ((PlanRowTextView) view).getPlan4STextView().setActivated(indexOf == 2);
                } else if (view instanceof PlanRowImageView) {
                    ((PlanRowImageView) view).getPlan1SImageView().setActivated(indexOf == 0);
                    ((PlanRowImageView) view).getPlan2SImageView().setActivated(indexOf == 1);
                    ((PlanRowImageView) view).getPlan4SImageView().setActivated(indexOf == 2);
                }
            }
        }
    }
}
