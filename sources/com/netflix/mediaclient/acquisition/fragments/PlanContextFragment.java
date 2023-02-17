package com.netflix.mediaclient.acquisition.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.view.SignupBackType;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.PlanSelectionViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C1435Ev;
import o.C1457Fr;
import o.C1461Fv;
import o.FQ;
public final class PlanContextFragment extends AbstractContextFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanContextFragment.class), "planSelectionModel", "getPlanSelectionModel()Lcom/netflix/mediaclient/acquisition/viewmodels/PlanSelectionViewModel;"))};
    private HashMap _$_findViewCache;
    private final AbstractC1433Et planSelectionModel$delegate = C1435Ev.m4972(new PlanContextFragment$planSelectionModel$2(this));

    public interface PlanContextClickListener {
        void onPlanContextConfirm();
    }

    private final PlanSelectionViewModel getPlanSelectionModel() {
        AbstractC1433Et et = this.planSelectionModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (PlanSelectionViewModel) et.mo3220();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractContextFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractContextFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
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

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractContextFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AppView getAppView() {
        return AppView.planSelectionContext;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initSignupHeading(getString(R.string.title_plan));
        initPlanSelectionSubHeading();
        String string = getString(R.string.button_see_plans);
        C1457Fr.m5016((Object) string, "getString(R.string.button_see_plans)");
        initContextButton(string);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.context_icon_checkmark);
        if (drawable != null) {
            C1457Fr.m5016((Object) drawable, "it");
            initContextIcon(drawable);
        }
        initAdvertisingLogging();
        initClickListeners();
    }

    private final void initPlanSelectionSubHeading() {
        if (getPlanSelectionModel().hasFreeTrial()) {
            initSubHeading(getString(R.string.label_plan_context));
        } else {
            initSubHeading(getString(R.string.label_plan_context_nft));
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getPlanSelectionModel();
    }

    private final void initClickListeners() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.contextButton)).setOnClickListener(new PlanContextFragment$initClickListeners$1(this));
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public SignupBackType backBehavior() {
        return SignupBackType.NORMAL_BACK;
    }

    private final void initAdvertisingLogging() {
        logAdvertisingId(getServiceManager(), "planSelectionWithContext");
    }

    /* access modifiers changed from: private */
    public final PlanContextClickListener getPlanContextClickListener() {
        return getSignupActivity();
    }
}
