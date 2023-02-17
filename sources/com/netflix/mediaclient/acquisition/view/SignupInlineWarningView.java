package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import java.util.HashMap;
import o.C1456Fq;
import o.C1457Fr;
import o.Ge;
public final class SignupInlineWarningView extends ConstraintLayout {
    private HashMap _$_findViewCache;

    public SignupInlineWarningView(Context context) {
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
    public SignupInlineWarningView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.signupWarningViewStyle);
        C1457Fr.m5025(context, "context");
        LayoutInflater.from(context).inflate(R.layout.signup_inline_warning_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SignupInlineWarningView(Context context, AttributeSet attributeSet, int i, C1456Fq fq) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final String getWarningText() {
        TextView textView = (TextView) _$_findCachedViewById(R.Cif.signupInlineWarningTextView);
        return String.valueOf(textView != null ? textView.getText() : null);
    }

    public final void setWarningText(String str) {
        TextView textView = (TextView) _$_findCachedViewById(R.Cif.signupInlineWarningTextView);
        if (textView != null) {
            textView.setText(str);
        }
        String str2 = str;
        setVisibility(str2 == null || Ge.m5063(str2) ? 8 : 0);
    }
}
