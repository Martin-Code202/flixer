package com.netflix.mediaclient.acquisition.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.RegistrationViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C1435Ev;
import o.C1457Fr;
import o.C1461Fv;
import o.FQ;
public final class RegistrationContextFragment extends AbstractContextFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(RegistrationContextFragment.class), "registrationModel", "getRegistrationModel()Lcom/netflix/mediaclient/acquisition/viewmodels/RegistrationViewModel;"))};
    private HashMap _$_findViewCache;
    private final AbstractC1433Et registrationModel$delegate = C1435Ev.m4972(new RegistrationContextFragment$registrationModel$2(this));

    public interface RegistrationContextClickListener {
        void onRegistrationContextConfirm();
    }

    private final RegistrationViewModel getRegistrationModel() {
        AbstractC1433Et et = this.registrationModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (RegistrationViewModel) et.mo3220();
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
        return AppView.registrationContext;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initSignupHeading(getString(R.string.title_registration));
        initSubHeading(getString(R.string.label_reg_context));
        String string = getString(R.string.button_continue);
        C1457Fr.m5016((Object) string, "getString(R.string.button_continue)");
        initContextButton(string);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.context_icon_devices);
        if (drawable != null) {
            C1457Fr.m5016((Object) drawable, "it");
            initContextIcon(drawable);
        }
        initAdvertisingLogging();
        initClickListeners();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getRegistrationModel();
    }

    private final void initClickListeners() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.contextButton)).setOnClickListener(new RegistrationContextFragment$initClickListeners$1(this));
    }

    private final void initAdvertisingLogging() {
        logAdvertisingId(getServiceManager(), "registrationWithContext");
    }

    /* access modifiers changed from: private */
    public final RegistrationContextClickListener getRegistrationContextClickListener() {
        return getSignupActivity();
    }
}
