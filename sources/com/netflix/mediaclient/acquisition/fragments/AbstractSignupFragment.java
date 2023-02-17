package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.util.AUIKeyboardUtilities;
import com.netflix.mediaclient.acquisition.view.SignupBackType;
import com.netflix.mediaclient.acquisition.view.SignupNativeConfig;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupViewModel;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import java.util.HashMap;
import o.AbstractC0367;
import o.C0345;
import o.C1457Fr;
import o.C2059ph;
import o.zN;
public abstract class AbstractSignupFragment extends Fragment {
    private HashMap _$_findViewCache;
    private final boolean enableDebounceOnTextViews = SignupNativeConfig.INSTANCE.getDebounceEnabled();
    private boolean hasActiveRequest;

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public abstract AppView getAppView();

    public abstract AbstractSignupViewModel getViewModel();

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        SignupNativeActivity signupActivity;
        super.onCreate(bundle);
        MoneyballData currentMoneyballData = getCurrentMoneyballData();
        if (currentMoneyballData != null) {
            getViewModel().setFlowMode(currentMoneyballData.getFlowMode());
            getViewModel().setContextData(currentMoneyballData.getContextData());
            getViewModel().initActions();
        }
        if (getViewModel().getFlowMode() == null && (signupActivity = getSignupActivity()) != null) {
            signupActivity.onFlowModeEmpty();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            AUIKeyboardUtilities.INSTANCE.dismissKeyboard(signupActivity);
        }
    }

    public final boolean getEnableDebounceOnTextViews() {
        return this.enableDebounceOnTextViews;
    }

    /* access modifiers changed from: protected */
    public final boolean getHasActiveRequest() {
        return this.hasActiveRequest;
    }

    /* access modifiers changed from: protected */
    public final void setHasActiveRequest(boolean z) {
        this.hasActiveRequest = z;
    }

    public final SignupNativeActivity getSignupActivity() {
        return (SignupNativeActivity) C0345.m13893(getActivity(), SignupNativeActivity.class);
    }

    public final MoneyballData getCurrentMoneyballData() {
        SignupViewModel flowModel;
        MutableLiveData<MoneyballData> currentMoneyballData;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity == null || (flowModel = signupActivity.getFlowModel()) == null || (currentMoneyballData = flowModel.getCurrentMoneyballData()) == null) {
            return null;
        }
        return currentMoneyballData.getValue();
    }

    public final void setCurrentMoneyballData(MoneyballData moneyballData) {
        SignupViewModel flowModel;
        MutableLiveData<MoneyballData> currentMoneyballData;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null && (flowModel = signupActivity.getFlowModel()) != null && (currentMoneyballData = flowModel.getCurrentMoneyballData()) != null) {
            currentMoneyballData.setValue(moneyballData);
        }
    }

    public final C2059ph getServiceManager() {
        return C2059ph.m9741(getSignupActivity());
    }

    public final void handleMoneyballResponse(MoneyballData moneyballData, Status status) {
        C1457Fr.m5025(status, "status");
        this.hasActiveRequest = false;
        if (!C1457Fr.m5018(status, AbstractC0367.f13235)) {
            SignupNativeActivity signupActivity = getSignupActivity();
            if (signupActivity != null) {
                signupActivity.showErrorDialogForStatus(status);
                return;
            }
            return;
        }
        setCurrentMoneyballData(moneyballData);
    }

    public SignupBackType backBehavior() {
        return SignupBackType.INTERRUPT_WITH_DIALOG;
    }

    public void logAdvertisingId(C2059ph phVar, String str) {
        C1457Fr.m5025(str, "eventType");
        zN.f12697.m13527(phVar, str);
    }
}
