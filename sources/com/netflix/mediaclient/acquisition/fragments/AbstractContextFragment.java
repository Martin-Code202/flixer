package com.netflix.mediaclient.acquisition.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.view.SignupHeadingView;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.HashMap;
import o.C0716;
import o.C1457Fr;
public abstract class AbstractContextFragment extends AbstractSignupFragment {
    private HashMap _$_findViewCache;

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.context_fragment_layout, viewGroup, false);
    }

    public final void initSignupHeading(String str) {
        SignupNativeActivity signupActivity = getSignupActivity();
        FlowMode flowMode = getViewModel().getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.STEPS) : null;
        SignupHeadingView.setStrings$default((SignupHeadingView) _$_findCachedViewById(R.Cif.signupHeading), (field == null || signupActivity == null) ? null : AUIMoneyballUtilities.INSTANCE.stepsFieldToString(signupActivity, field), str, null, 4, null);
    }

    public final void initSubHeading(CharSequence charSequence) {
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.subheaderTitle);
        C1457Fr.m5016((Object) r0, "subheaderTitle");
        r0.setText(charSequence);
    }

    public final void initContextButton(String str) {
        C1457Fr.m5025(str, "text");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.contextButton)).setText(str);
    }

    public final void initContextIcon(Drawable drawable) {
        C1457Fr.m5025(drawable, "drawable");
        ((ImageView) _$_findCachedViewById(R.Cif.contextIcon)).setImageDrawable(drawable);
    }
}
