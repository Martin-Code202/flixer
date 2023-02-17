package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C0716;
import o.C1197;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.FI;
import o.FQ;
public final class PlanRowTextView extends ConstraintLayout {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "headingTextView", "getHeadingTextView()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "divider1", "getDivider1()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "divider2", "getDivider2()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "plan1STextView", "getPlan1STextView()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "plan2STextView", "getPlan2STextView()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "plan4STextView", "getPlan4STextView()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowTextView.class), "bottomDivider", "getBottomDivider()Landroid/view/View;"))};
    private HashMap _$_findViewCache;
    private final FI bottomDivider$delegate;
    private final FI divider1$delegate;
    private final FI divider2$delegate;
    private final FI headingTextView$delegate;
    private final FI plan1STextView$delegate;
    private final FI plan2STextView$delegate;
    private final FI plan4STextView$delegate;

    public PlanRowTextView(Context context) {
        this(context, 0, 0, null, 14, null);
    }

    public PlanRowTextView(Context context, int i) {
        this(context, i, 0, null, 12, null);
    }

    public PlanRowTextView(Context context, int i, int i2) {
        this(context, i, i2, null, 8, null);
    }

    private final View getDivider1() {
        return (View) this.divider1$delegate.mo4986(this, $$delegatedProperties[1]);
    }

    private final View getDivider2() {
        return (View) this.divider2$delegate.mo4986(this, $$delegatedProperties[2]);
    }

    private final C0716 getHeadingTextView() {
        return (C0716) this.headingTextView$delegate.mo4986(this, $$delegatedProperties[0]);
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

    public final View getBottomDivider() {
        return (View) this.bottomDivider$delegate.mo4986(this, $$delegatedProperties[6]);
    }

    public final C0716 getPlan1STextView() {
        return (C0716) this.plan1STextView$delegate.mo4986(this, $$delegatedProperties[3]);
    }

    public final C0716 getPlan2STextView() {
        return (C0716) this.plan2STextView$delegate.mo4986(this, $$delegatedProperties[4]);
    }

    public final C0716 getPlan4STextView() {
        return (C0716) this.plan4STextView$delegate.mo4986(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlanRowTextView(Context context, int i, int i2, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C1457Fr.m5025(context, "context");
        this.headingTextView$delegate = C1197.m16465(this, (int) R.id.rowHeading);
        this.divider1$delegate = C1197.m16478(this, (int) R.id.divider1);
        this.divider2$delegate = C1197.m16478(this, (int) R.id.divider2);
        this.plan1STextView$delegate = C1197.m16465(this, (int) R.id.plan1S);
        this.plan2STextView$delegate = C1197.m16465(this, (int) R.id.plan2S);
        this.plan4STextView$delegate = C1197.m16465(this, (int) R.id.plan4S);
        this.bottomDivider$delegate = C1197.m16478(this, (int) R.id.bottomDivider);
        LayoutInflater.from(context).inflate(R.layout.plan_row_values_layout, (ViewGroup) this, true);
        getHeadingTextView().setTextColor(ContextCompat.getColor(context, i));
        View divider1 = getDivider1();
        if (divider1 != null) {
            divider1.setBackgroundColor(ContextCompat.getColor(context, i2));
        }
        View divider2 = getDivider2();
        if (divider2 != null) {
            divider2.setBackgroundColor(ContextCompat.getColor(context, i2));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlanRowTextView(Context context, int i, int i2, AttributeSet attributeSet, int i3, C1456Fq fq) {
        this(context, (i3 & 2) != 0 ? R.color.black : i, (i3 & 4) != 0 ? R.color.signup_divider_light : i2, (i3 & 8) != 0 ? null : attributeSet);
    }

    public final void setPlanRowValues(String str, List<? extends Object> list) {
        C1457Fr.m5025(list, "planValuesList");
        if (str != null) {
            getHeadingTextView().setText(str);
        } else {
            getHeadingTextView().setVisibility(8);
        }
        if ((!list.isEmpty()) && list.size() == 3) {
            getPlan1STextView().setText(getString(list.get(0)));
            getPlan2STextView().setText(getString(list.get(1)));
            getPlan4STextView().setText(getString(list.get(2)));
        }
    }

    private final String getString(Object obj) {
        if (obj instanceof Double) {
            return getStringFromDoubleValue(((Number) obj).doubleValue());
        }
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    private final String getStringFromDoubleValue(double d) {
        return String.valueOf((int) d);
    }
}
