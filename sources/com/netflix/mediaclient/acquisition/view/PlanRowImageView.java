package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public final class PlanRowImageView extends ConstraintLayout {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "headingTextView", "getHeadingTextView()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "divider1", "getDivider1()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "divider2", "getDivider2()Landroid/view/View;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "plan1SImageView", "getPlan1SImageView()Landroid/widget/ImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "plan2SImageView", "getPlan2SImageView()Landroid/widget/ImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "plan4SImageView", "getPlan4SImageView()Landroid/widget/ImageView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanRowImageView.class), "bottomDivider", "getBottomDivider()Landroid/view/View;"))};
    private HashMap _$_findViewCache;
    private final FI bottomDivider$delegate;
    private final FI divider1$delegate;
    private final FI divider2$delegate;
    private final FI headingTextView$delegate;
    private final FI plan1SImageView$delegate;
    private final FI plan2SImageView$delegate;
    private final FI plan4SImageView$delegate;

    public PlanRowImageView(Context context) {
        this(context, 0, 0, null, 14, null);
    }

    public PlanRowImageView(Context context, int i) {
        this(context, i, 0, null, 12, null);
    }

    public PlanRowImageView(Context context, int i, int i2) {
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

    public final ImageView getPlan1SImageView() {
        return (ImageView) this.plan1SImageView$delegate.mo4986(this, $$delegatedProperties[3]);
    }

    public final ImageView getPlan2SImageView() {
        return (ImageView) this.plan2SImageView$delegate.mo4986(this, $$delegatedProperties[4]);
    }

    public final ImageView getPlan4SImageView() {
        return (ImageView) this.plan4SImageView$delegate.mo4986(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlanRowImageView(Context context, int i, int i2, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C1457Fr.m5025(context, "context");
        this.headingTextView$delegate = C1197.m16465(this, (int) R.id.rowHeading);
        this.divider1$delegate = C1197.m16478(this, (int) R.id.divider1);
        this.divider2$delegate = C1197.m16478(this, (int) R.id.divider2);
        this.plan1SImageView$delegate = C1197.m16465(this, (int) R.id.plan1SImage);
        this.plan2SImageView$delegate = C1197.m16465(this, (int) R.id.plan2SImage);
        this.plan4SImageView$delegate = C1197.m16465(this, (int) R.id.plan4SImage);
        this.bottomDivider$delegate = C1197.m16478(this, (int) R.id.bottomDivider);
        LayoutInflater.from(context).inflate(R.layout.plan_row_image_values_layout, (ViewGroup) this, true);
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
    public /* synthetic */ PlanRowImageView(Context context, int i, int i2, AttributeSet attributeSet, int i3, C1456Fq fq) {
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
            ImageView plan1SImageView = getPlan1SImageView();
            Object obj = list.get(0);
            if (!(obj instanceof Boolean)) {
                obj = null;
            }
            plan1SImageView.setImageResource(getImageResource((Boolean) obj));
            ImageView plan2SImageView = getPlan2SImageView();
            Object obj2 = list.get(1);
            if (!(obj2 instanceof Boolean)) {
                obj2 = null;
            }
            plan2SImageView.setImageResource(getImageResource((Boolean) obj2));
            ImageView plan4SImageView = getPlan4SImageView();
            Object obj3 = list.get(2);
            if (!(obj3 instanceof Boolean)) {
                obj3 = null;
            }
            plan4SImageView.setImageResource(getImageResource((Boolean) obj3));
        }
    }

    public final void hideBottomDivider() {
        View bottomDivider = getBottomDivider();
        if (bottomDivider != null) {
            bottomDivider.setVisibility(8);
        }
    }

    private final int getImageResource(Boolean bool) {
        if (bool == null || bool.booleanValue()) {
            return R.drawable.plan_selection_check_mark_background;
        }
        return R.drawable.plan_selection_mark_background;
    }
}
