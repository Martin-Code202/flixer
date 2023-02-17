package com.netflix.mediaclient.acquisition.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.view.SignupInlineWarningView;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.WarnUserViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.FQ;
public final class WarnUserFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(WarnUserFragment.class), "warnUserViewModel", "getWarnUserViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/WarnUserViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "WarnUserFragment";
    private HashMap _$_findViewCache;
    private final AbstractC1433Et warnUserViewModel$delegate = C1435Ev.m4972(new WarnUserFragment$warnUserViewModel$2(this));

    private final WarnUserViewModel getWarnUserViewModel() {
        AbstractC1433Et et = this.warnUserViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (WarnUserViewModel) et.mo3220();
    }

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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public Void getAppView() {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.warn_user_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initWarning();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getWarnUserViewModel();
    }

    private final void initWarning() {
        WarnUserViewModel warnUserViewModel = getWarnUserViewModel();
        NetflixApplication instance = NetflixApplication.getInstance();
        C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
        ((SignupInlineWarningView) _$_findCachedViewById(R.Cif.warnUserWarningView)).setWarningText(warnUserViewModel.localizedErrorString(instance));
    }
}
