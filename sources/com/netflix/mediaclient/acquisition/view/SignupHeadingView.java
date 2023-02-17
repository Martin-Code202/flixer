package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import o.C0716;
import o.C1004;
import o.C1456Fq;
import o.C1457Fr;
import o.EI;
public final class SignupHeadingView extends LinearLayout {
    public static final Companion Companion = new Companion(null);
    public static final String SUB_HEADING_TAG = "SubHeadingText";
    private HashMap _$_findViewCache;

    public SignupHeadingView(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public SignupHeadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public SignupHeadingView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
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
    public SignupHeadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        C1457Fr.m5025(context, "context");
        View.inflate(context, R.layout.signup_heading_layout, this);
        setOrientation(1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SignupHeadingView(Context context, AttributeSet attributeSet, int i, int i2, int i3, C1456Fq fq) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }
    }

    public static /* synthetic */ void setStepLabelString$default(SignupHeadingView signupHeadingView, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        signupHeadingView.setStepLabelString(charSequence);
    }

    public final void setStepLabelString(CharSequence charSequence) {
        if (charSequence != null) {
            C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.stepLabel);
            C1457Fr.m5016((Object) r0, "stepLabel");
            r0.setText(charSequence);
            C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.stepLabel);
            C1457Fr.m5016((Object) r02, "stepLabel");
            r02.setVisibility(0);
            return;
        }
        C0716 r03 = (C0716) _$_findCachedViewById(R.Cif.stepLabel);
        C1457Fr.m5016((Object) r03, "stepLabel");
        r03.setVisibility(8);
    }

    public static /* synthetic */ void setHeadingString$default(SignupHeadingView signupHeadingView, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        signupHeadingView.setHeadingString(charSequence);
    }

    public final void setHeadingString(CharSequence charSequence) {
        if (charSequence != null) {
            C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.headerTitle);
            C1457Fr.m5016((Object) r0, "headerTitle");
            r0.setText(charSequence);
            C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.stepLabel);
            C1457Fr.m5016((Object) r02, "stepLabel");
            r02.setVisibility(0);
            return;
        }
        C0716 r03 = (C0716) _$_findCachedViewById(R.Cif.headerTitle);
        C1457Fr.m5016((Object) r03, "headerTitle");
        r03.setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.netflix.mediaclient.acquisition.view.SignupHeadingView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setSubHeadingStrings$default(SignupHeadingView signupHeadingView, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = EI.m4805();
        }
        signupHeadingView.setSubHeadingStrings(list);
    }

    public final void setSubHeadingStrings(List<? extends CharSequence> list) {
        C1457Fr.m5025(list, "subHeadingStrings");
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                TextView textView = new TextView(getContext(), null, 0, R.style.res_2131952089_signupnativeheadertext_medium);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = C1004.m15954(getContext(), 10);
                textView.setTag(SUB_HEADING_TAG);
                textView.setLayoutParams(layoutParams);
                textView.setText(it.next());
                addView(textView);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.netflix.mediaclient.acquisition.view.SignupHeadingView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setStrings$default(SignupHeadingView signupHeadingView, CharSequence charSequence, CharSequence charSequence2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            list = EI.m4805();
        }
        signupHeadingView.setStrings(charSequence, charSequence2, list);
    }

    public final void setStrings(CharSequence charSequence, CharSequence charSequence2, List<? extends CharSequence> list) {
        C1457Fr.m5025(list, "subHeadingStrings");
        setStepLabelString(charSequence);
        setHeadingString(charSequence2);
        setSubHeadingStrings(list);
    }
}
