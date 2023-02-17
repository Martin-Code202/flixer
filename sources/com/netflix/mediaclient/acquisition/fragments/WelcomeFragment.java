package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.BillingManagerInterface;
import com.netflix.mediaclient.acquisition.Constants;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.view.PlanValuesView;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.PlanGridRowData;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.acquisition.viewmodels.WelcomeViewModel;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AD;
import o.AbstractC1433Et;
import o.C0522;
import o.C0738;
import o.C0754;
import o.C1080;
import o.C1276;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.C2059ph;
import o.FQ;
import o.zN;
public final class WelcomeFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(WelcomeFragment.class), "welcomeModel", "getWelcomeModel()Lcom/netflix/mediaclient/acquisition/viewmodels/WelcomeViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PLAY_BILLING_DEVELOPER_PAYLOAD = "developerPayload";
    public static final String KEY_SELECTED_TAB = "selectedTab";
    public static final String TAG = "WelcomeFragment";
    private HashMap _$_findViewCache;
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private String selectedTab = Constants.Companion.getFIELD_TIN_CANCEL();
    private final AbstractC1433Et welcomeModel$delegate = C1435Ev.m4972(new WelcomeFragment$welcomeModel$2(this));

    public static /* synthetic */ void welcomeModel$annotations() {
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

    public final WelcomeViewModel getWelcomeModel() {
        AbstractC1433Et et = this.welcomeModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (WelcomeViewModel) et.mo3220();
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
    public AppView getAppView() {
        return AppView.nmLanding;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.welcome_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initClickListeners();
        initLongClickListeners();
        initNonMemberData();
        initFormerMemberData();
        initNeverMemberData();
        initViewModelBinding();
        initButtonStyles();
        initPrices();
        initTINTabs();
        initTINButtonClickListeners();
        initVlvHeight();
        initAdvertisingLogging();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        C1276.m16820().mo5728("WelcomeFragment restore state bundle is null: " + (bundle == null));
        C1276.m16820().mo5727("WelcomeFragment onViewStateRestored");
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getWelcomeModel();
    }

    public final LifecycleRegistry getLifecycleRegistry$NetflixApp_release() {
        return this.lifecycleRegistry;
    }

    public final void setLifecycleRegistry$NetflixApp_release(LifecycleRegistry lifecycleRegistry2) {
        C1457Fr.m5025(lifecycleRegistry2, "<set-?>");
        this.lifecycleRegistry = lifecycleRegistry2;
    }

    @Override // android.support.v4.app.Fragment, android.arch.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        return this.lifecycleRegistry;
    }

    private final void initViewModelBinding() {
        loadCancelImageUrl(getWelcomeModel().getCancelImageUrl());
        loadDevicesTvImageUrl(getWelcomeModel().getDevicesTvImageUrl());
        loadDevicesDownloadImageUrl(getWelcomeModel().getDevicesDownloadImageUrl());
        loadDevicesComputerImageUrl(getWelcomeModel().getDevicesComputerImageUrl());
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome)).setLoadingData(getWelcomeModel().isLoading());
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonDevices)).setLoadingData(getWelcomeModel().isLoading());
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonCancel)).setLoadingData(getWelcomeModel().isLoading());
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonPrice)).setLoadingData(getWelcomeModel().isLoading());
    }

    private final void initButtonStyles() {
        initCTAButtonStyle(((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome)).getButton());
        initCTAButtonStyle(((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonDevices)).getButton());
        initCTAButtonStyle(((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonCancel)).getButton());
        initCTAButtonStyle(((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonPrice)).getButton());
    }

    private final void initCTAButtonStyle(C0754 r2) {
        r2.setMinHeight(52);
        r2.setTextSize(15.0f);
        r2.setLetterSpacing(0.15f);
        r2.setTypeface(Typeface.DEFAULT);
    }

    private final void initClickListeners() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome)).setOnClickListener(new WelcomeFragment$initClickListeners$1(this));
    }

    private final void initLongClickListeners() {
    }

    private final void initVlvHeight() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.Cif.vlvInfoGroup);
        C1457Fr.m5016((Object) linearLayout, "vlvInfoGroup");
        ViewTreeObserver viewTreeObserver = linearLayout.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new WelcomeFragment$initVlvHeight$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleRestore(int i, List<? extends C0738> list) {
        C2059ph serviceManager;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null && (serviceManager = signupActivity.getServiceManager()) != null) {
            C1457Fr.m5016((Object) serviceManager, "serviceManager");
            zN.f12697.m13518(i, list, getWelcomeModel(), serviceManager, new WelcomeFragment$handleRestore$1(this));
        }
    }

    private final void initTINTabs() {
        ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).setup();
        ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).addTab(createTabSpec(Constants.Companion.getFIELD_TIN_CANCEL(), cancelTabName(), R.id.welcome_fragment_cancel_tab, R.id.cancelTabContent, R.drawable.tin_tab_icon_cancel));
        ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).addTab(createTabSpec(Constants.Companion.getFIELD_TIN_DEVICES(), devicesTabName(), R.id.welcome_fragment_devices_tab, R.id.devicesTabContent, R.drawable.tin_tab_icon_devices));
        ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).addTab(createTabSpec(Constants.Companion.getFIELD_TIN_PRICING(), priceTabName(), R.id.welcome_fragment_price_tab, R.id.priceTabContent, R.drawable.tin_tab_icon_price));
        initPlanGrid();
        ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).setOnTabChangedListener(new WelcomeFragment$initTINTabs$1(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        C1457Fr.m5025(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(KEY_SELECTED_TAB, this.selectedTab);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        if (bundle == null || (str = bundle.getString(KEY_SELECTED_TAB)) == null) {
            str = Constants.Companion.getFIELD_TIN_CANCEL();
        }
        this.selectedTab = str;
        ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).setCurrentTabByTag(this.selectedTab);
    }

    /* access modifiers changed from: private */
    public final void switchTab(String str) {
        AppView appView;
        if (C1457Fr.m5018((Object) str, (Object) Constants.Companion.getFIELD_TIN_CANCEL())) {
            appView = AppView.tinCancellation;
        } else if (C1457Fr.m5018((Object) str, (Object) Constants.Companion.getFIELD_TIN_DEVICES())) {
            appView = AppView.tinDevices;
        } else if (C1457Fr.m5018((Object) str, (Object) Constants.Companion.getFIELD_TIN_PRICING())) {
            appView = AppView.tinPlans;
        } else {
            appView = null;
        }
        Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C1080(appView, null)));
        this.selectedTab = str;
        scrollTabsToTop();
    }

    private final void initTINButtonClickListeners() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonCancel)).setOnClickListener(new WelcomeFragment$initTINButtonClickListeners$1(this));
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonDevices)).setOnClickListener(new WelcomeFragment$initTINButtonClickListeners$2(this));
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonPrice)).setOnClickListener(new WelcomeFragment$initTINButtonClickListeners$3(this));
    }

    /* access modifiers changed from: protected */
    public final String cancelTabName() {
        if (!zN.f12697.m13526() || !AD.m3307(getActivity())) {
            String string = getString(R.string.cancel_anytime_small_screen);
            C1457Fr.m5016((Object) string, "getString(R.string.cancel_anytime_small_screen)");
            return string;
        }
        String string2 = getString(R.string.cancel_anytime);
        C1457Fr.m5016((Object) string2, "getString(R.string.cancel_anytime)");
        return string2;
    }

    /* access modifiers changed from: protected */
    public final String devicesTabName() {
        if (!zN.f12697.m13526() || !AD.m3307(getActivity())) {
            String string = getString(R.string.watch_anywhere_mobile_optimized);
            C1457Fr.m5016((Object) string, "getString(R.string.watch…nywhere_mobile_optimized)");
            return string;
        }
        String string2 = getString(R.string.watch_anywhere);
        C1457Fr.m5016((Object) string2, "getString(R.string.watch_anywhere)");
        return string2;
    }

    /* access modifiers changed from: protected */
    public final String priceTabName() {
        if (!zN.f12697.m13526() || !AD.m3307(getActivity())) {
            String string = getString(R.string.watch_pricing_small_screen);
            C1457Fr.m5016((Object) string, "getString(R.string.watch_pricing_small_screen)");
            return string;
        }
        String string2 = getString(R.string.watch_pricing);
        C1457Fr.m5016((Object) string2, "getString(R.string.watch_pricing)");
        return string2;
    }

    /* access modifiers changed from: private */
    public final void initPlanGrid() {
        if (((PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView)) != null) {
            ((PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView)).setHeadingTextColorId(R.color.grey70);
            ((PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView)).setDividerColorId(R.color.signup_welcome_plan_divider);
            WelcomeViewModel welcomeModel = getWelcomeModel();
            PlanValuesView planValuesView = (PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView);
            C1457Fr.m5016((Object) planValuesView, "planChoiceValuesView");
            Context context = planValuesView.getContext();
            C1457Fr.m5016((Object) context, "planChoiceValuesView.context");
            List<PlanGridRowData> planSelectionRows = welcomeModel.planSelectionRows(context);
            Context context2 = getContext();
            if (context2 != null) {
                ((PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView)).initRows(planSelectionRows, zN.f12697.m13526() ? Integer.valueOf(ContextCompat.getColor(context2, R.color.signup_welcome_tabs_background_alternate)) : null, Integer.valueOf(ContextCompat.getColor(context2, R.color.transparent)));
            }
        }
    }

    private final void initPrices() {
        BillingManagerInterface billingManager = BillingManager.Companion.getBillingManager(getSignupActivity());
        List<String> skusList = getWelcomeModel().getSkusList();
        if (skusList != null && billingManager != null) {
            billingManager.fetchPrices(skusList, false, 3, new WelcomeFragment$initPrices$1(this));
        }
    }

    private final void initNonMemberData() {
        if (getWelcomeModel().hasFreeTrial()) {
            setWelcomeTabsButtonText(R.string.button_join_free_for_a_month);
        } else {
            setWelcomeTabsButtonText(R.string.button_join_now);
        }
    }

    private final void initFormerMemberData() {
        if (!getWelcomeModel().isRecognisedFormerMember()) {
            return;
        }
        if (getWelcomeModel().hasFreeTrial()) {
            setWelcomeTabsButtonText(R.string.button_extra_free_trial);
        } else {
            setWelcomeTabsButtonText(R.string.button_restart_your_membership);
        }
    }

    private final void initNeverMemberData() {
        if (getWelcomeModel().isRecognisedNeverMember()) {
            setWelcomeTabsButtonText(R.string.button_finishsignup_capitalized);
        }
    }

    private final void setWelcomeTabsButtonText(int i) {
        NetflixSignupButton netflixSignupButton = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome);
        C1457Fr.m5016((Object) netflixSignupButton, "netflixSignupButtonWelcome");
        String string = netflixSignupButton.getContext().getString(i);
        C1457Fr.m5016((Object) string, "netflixSignupButtonWelco…tString(expectedStringId)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome)).setText(string);
        NetflixSignupButton netflixSignupButton2 = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonDevices);
        C1457Fr.m5016((Object) netflixSignupButton2, "netflixSignupButtonDevices");
        String string2 = netflixSignupButton2.getContext().getString(i);
        C1457Fr.m5016((Object) string2, "netflixSignupButtonDevic…tString(expectedStringId)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonDevices)).setText(string2);
        NetflixSignupButton netflixSignupButton3 = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonCancel);
        C1457Fr.m5016((Object) netflixSignupButton3, "netflixSignupButtonCancel");
        String string3 = netflixSignupButton3.getContext().getString(i);
        C1457Fr.m5016((Object) string3, "netflixSignupButtonCance…tString(expectedStringId)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonCancel)).setText(string3);
        NetflixSignupButton netflixSignupButton4 = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonPrice);
        C1457Fr.m5016((Object) netflixSignupButton4, "netflixSignupButtonPrice");
        String string4 = netflixSignupButton4.getContext().getString(i);
        C1457Fr.m5016((Object) string4, "netflixSignupButtonPrice…tString(expectedStringId)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonPrice)).setText(string4);
    }

    private final void initAdvertisingLogging() {
        if (getWelcomeModel().isRecognisedFormerMember()) {
            logAdvertisingId(getServiceManager(), "nmLanding_rejoin");
        } else {
            logAdvertisingId(getServiceManager(), SignupConstants.LoggingEvent.WELCOME);
        }
    }

    private final TabHost.TabSpec createTabSpec(String str, String str2, int i, int i2, int i3) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.welcome_tin_tab_header_layout, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        inflate.setId(i);
        TextView textView = (TextView) inflate.findViewById(R.id.welcome_tin_tab_header_textview);
        if (textView != null) {
            textView.setText(str2);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.welcome_tin_tab_header_imageview);
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
        TabHost.TabSpec newTabSpec = ((TabHost) _$_findCachedViewById(R.Cif.tabHost)).newTabSpec(str);
        newTabSpec.setContent(i2);
        newTabSpec.setIndicator(inflate);
        return newTabSpec;
    }

    /* access modifiers changed from: private */
    public final void nextTapped() {
        BillingManager billingManager;
        getWelcomeModel().isLoading().setValue(true);
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null && (billingManager = signupActivity.getBillingManager()) != null) {
            billingManager.restoreSubscription(new WelcomeFragment$nextTapped$1(this));
        }
    }

    private final void scrollTabsToTop() {
        TabHost tabHost = (TabHost) _$_findCachedViewById(R.Cif.tabHost);
        C1457Fr.m5016((Object) tabHost, "tabHost");
        ((ScrollView) _$_findCachedViewById(R.Cif.welcomeScrollView)).smoothScrollTo(0, tabHost.getTop());
    }

    /* access modifiers changed from: private */
    public final void loadVlvImageUrl(String str) {
        C0522 r0 = (C0522) _$_findCachedViewById(R.Cif.vlvImageView);
        C1457Fr.m5016((Object) r0, "vlvImageView");
        loadVlVImageUrl(str, r0, "vlvImage", ImageView.ScaleType.CENTER_CROP);
    }

    private final void loadCancelImageUrl(String str) {
        C0522 r2 = (C0522) _$_findCachedViewById(R.Cif.tinCancelImageView);
        C1457Fr.m5016((Object) r2, "tinCancelImageView");
        loadImageUrl$default(this, str, r2, "tinCancelImage", null, 8, null);
    }

    private final void loadDevicesTvImageUrl(String str) {
        C0522 r0 = (C0522) _$_findCachedViewById(R.Cif.tinDevicesTvImageView);
        C1457Fr.m5016((Object) r0, "tinDevicesTvImageView");
        loadImageUrl(str, r0, "tinDevicesTvImage", ImageView.ScaleType.FIT_XY);
    }

    private final void loadDevicesDownloadImageUrl(String str) {
        C0522 r0 = (C0522) _$_findCachedViewById(R.Cif.tinDevicesDownloadImageView);
        C1457Fr.m5016((Object) r0, "tinDevicesDownloadImageView");
        loadImageUrl(str, r0, "tinDevicesDownloadImage", ImageView.ScaleType.FIT_XY);
    }

    private final void loadDevicesComputerImageUrl(String str) {
        C0522 r0 = (C0522) _$_findCachedViewById(R.Cif.tinDevicesComputerImageView);
        C1457Fr.m5016((Object) r0, "tinDevicesComputerImageView");
        loadImageUrl(str, r0, "tinDevicesComputerImage", ImageView.ScaleType.FIT_XY);
    }

    static /* synthetic */ void loadVlVImageUrl$default(WelcomeFragment welcomeFragment, String str, C0522 r3, String str2, ImageView.ScaleType scaleType, int i, Object obj) {
        if ((i & 8) != 0) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        welcomeFragment.loadVlVImageUrl(str, r3, str2, scaleType);
    }

    private final void loadVlVImageUrl(String str, C0522 r4, String str2, ImageView.ScaleType scaleType) {
        r4.setPassActualScaleTypeToParent(true);
        r4.setScaleType(scaleType);
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            signupActivity.runWhenManagerIsReady(new WelcomeFragment$loadVlVImageUrl$1(this, r4, str2, str));
        }
    }

    static /* synthetic */ void loadImageUrl$default(WelcomeFragment welcomeFragment, String str, C0522 r3, String str2, ImageView.ScaleType scaleType, int i, Object obj) {
        if ((i & 8) != 0) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        welcomeFragment.loadImageUrl(str, r3, str2, scaleType);
    }

    private final void loadImageUrl(String str, C0522 r4, String str2, ImageView.ScaleType scaleType) {
        r4.setPassActualScaleTypeToParent(true);
        r4.setScaleType(scaleType);
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            signupActivity.runWhenManagerIsReady(new WelcomeFragment$loadImageUrl$1(this, r4, str, str2));
        }
    }
}
