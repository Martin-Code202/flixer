package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C1197;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.FI;
import o.FQ;
public final class PlanButtonView extends ConstraintLayout {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanButtonView.class), "plan1SButton", "getPlan1SButton()Landroid/widget/Button;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanButtonView.class), "plan2SButton", "getPlan2SButton()Landroid/widget/Button;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanButtonView.class), "plan4SButton", "getPlan4SButton()Landroid/widget/Button;"))};
    private HashMap _$_findViewCache;
    private final FI plan1SButton$delegate;
    private final FI plan2SButton$delegate;
    private final FI plan4SButton$delegate;

    public PlanButtonView(Context context) {
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

    public final Button getPlan1SButton() {
        return (Button) this.plan1SButton$delegate.mo4986(this, $$delegatedProperties[0]);
    }

    public final Button getPlan2SButton() {
        return (Button) this.plan2SButton$delegate.mo4986(this, $$delegatedProperties[1]);
    }

    public final Button getPlan4SButton() {
        return (Button) this.plan4SButton$delegate.mo4986(this, $$delegatedProperties[2]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlanButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C1457Fr.m5025(context, "context");
        this.plan1SButton$delegate = C1197.m16465(this, (int) R.id.plan1SButton);
        this.plan2SButton$delegate = C1197.m16465(this, (int) R.id.plan2SButton);
        this.plan4SButton$delegate = C1197.m16465(this, (int) R.id.plan4SButton);
        LayoutInflater.from(context).inflate(R.layout.plan_choice_header_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlanButtonView(Context context, AttributeSet attributeSet, int i, C1456Fq fq) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setPlanHeaderValues(List<String> list) {
        C1457Fr.m5025(list, "planNamesList");
        if (list.size() == 3) {
            getPlan1SButton().setText(getLocalizedPlanName(list.get(0)));
            getPlan2SButton().setText(getLocalizedPlanName(list.get(1)));
            getPlan4SButton().setText(getLocalizedPlanName(list.get(2)));
        }
    }

    private final String getLocalizedPlanName(String str) {
        Context context = getContext();
        C1457Fr.m5016((Object) context, "context");
        return ContextKt.getStringResource(context, str);
    }
}
