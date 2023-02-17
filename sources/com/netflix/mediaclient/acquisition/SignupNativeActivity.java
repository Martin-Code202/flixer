package com.netflix.mediaclient.acquisition;

import android.app.Activity;
import android.app.AlertDialog;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment;
import com.netflix.mediaclient.acquisition.fragments.ConfirmFragment;
import com.netflix.mediaclient.acquisition.fragments.CreditPaymentFragment;
import com.netflix.mediaclient.acquisition.fragments.GiftCardPaymentFragment;
import com.netflix.mediaclient.acquisition.fragments.PaymentSelectionFragment;
import com.netflix.mediaclient.acquisition.fragments.PlanContextFragment;
import com.netflix.mediaclient.acquisition.fragments.PlanSelectionFragment;
import com.netflix.mediaclient.acquisition.fragments.RegistrationContextFragment;
import com.netflix.mediaclient.acquisition.fragments.RegistrationFragment;
import com.netflix.mediaclient.acquisition.fragments.StartMembershipOnContextFragment;
import com.netflix.mediaclient.acquisition.fragments.WelcomeFragment;
import com.netflix.mediaclient.acquisition.fragments.WelcomeSlidingDoorsFragment;
import com.netflix.mediaclient.acquisition.util.DebugBillingManager;
import com.netflix.mediaclient.acquisition.view.SignupBackType;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.acquisition.viewmodels.SignupViewModel;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1194;
import o.AbstractC1433Et;
import o.ActivityC2186tp;
import o.BX;
import o.C0729;
import o.C0738;
import o.C0807;
import o.C1212;
import o.C1276;
import o.C1317As;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.C2059ph;
import o.EI;
import o.FQ;
import o.oV;
import o.zJ;
import o.zN;
import org.json.JSONObject;
public class SignupNativeActivity extends NetflixActivity implements PaymentSelectionFragment.PaymentSelectionClickListener, PlanContextFragment.PlanContextClickListener, RegistrationContextFragment.RegistrationContextClickListener {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(SignupNativeActivity.class), "flowModel", "getFlowModel()Lcom/netflix/mediaclient/acquisition/viewmodels/SignupViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SUPPRESS_NAVIGATE_ON_RESTORE = "suppress";
    private static final String TAG = TAG;
    private static final int VIEW_FLIPPER_FRAGMENT_CONTAINER_INDEX = 1;
    private static final int VIEW_FLIPPER_SPINNER_INDEX = 0;
    private HashMap _$_findViewCache;
    public BillingManager billingManager;
    public DebugBillingManager debugBillingManager;
    private final AbstractC1433Et flowModel$delegate = C1435Ev.m4972(new SignupNativeActivity$flowModel$2(this));
    private final FragmentManager fragmentManager;
    private Long lastNavigationSessionId;
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private boolean loggingIn;
    private Boolean suppressNavigateToFlowMode = false;

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

    public final SignupViewModel getFlowModel() {
        AbstractC1433Et et = this.flowModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (SignupViewModel) et.mo3220();
    }

    public SignupNativeActivity() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        C1457Fr.m5016((Object) supportFragmentManager, "supportFragmentManager");
        this.fragmentManager = supportFragmentManager;
    }

    public final BillingManager getBillingManager() {
        BillingManager billingManager2 = this.billingManager;
        if (billingManager2 == null) {
            C1457Fr.m5017("billingManager");
        }
        return billingManager2;
    }

    public final void setBillingManager(BillingManager billingManager2) {
        C1457Fr.m5025(billingManager2, "<set-?>");
        this.billingManager = billingManager2;
    }

    public final DebugBillingManager getDebugBillingManager() {
        DebugBillingManager debugBillingManager2 = this.debugBillingManager;
        if (debugBillingManager2 == null) {
            C1457Fr.m5017("debugBillingManager");
        }
        return debugBillingManager2;
    }

    public final void setDebugBillingManager(DebugBillingManager debugBillingManager2) {
        C1457Fr.m5025(debugBillingManager2, "<set-?>");
        this.debugBillingManager = debugBillingManager2;
    }

    public final boolean getLoggingIn() {
        return this.loggingIn;
    }

    public final void setLoggingIn(boolean z) {
        this.loggingIn = z;
    }

    public final AbstractSignupFragment getCurrentFragment() {
        Fragment findFragmentById = this.fragmentManager.findFragmentById(R.id.signup_fragment_container);
        if (!(findFragmentById instanceof AbstractSignupFragment)) {
            findFragmentById = null;
        }
        return (AbstractSignupFragment) findFragmentById;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final String getTAG() {
            return SignupNativeActivity.TAG;
        }

        public final int getVIEW_FLIPPER_SPINNER_INDEX() {
            return SignupNativeActivity.VIEW_FLIPPER_SPINNER_INDEX;
        }

        public final int getVIEW_FLIPPER_FRAGMENT_CONTAINER_INDEX() {
            return SignupNativeActivity.VIEW_FLIPPER_FRAGMENT_CONTAINER_INDEX;
        }

        public final Intent createStartIntent(Context context) {
            C1457Fr.m5025(context, "context");
            return new Intent(context, SignupNativeActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        startRenderNavigationLevelSession();
        super.onCreate(bundle);
        setContentView(R.layout.signup_activity_layout);
        C1276.m16820().mo5728("SignupNativeActivity onCreate");
        initWindow();
        initViewModelObserver();
        initBillingManager();
        initSignupHeaderObserver();
        initProgressSpinner();
        initSavedBundleProps(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onConfigureActionBarState(NetflixActionBar.iF.AbstractC0010 r3) {
        C1457Fr.m5025(r3, "builder");
        r3.mo403(false).mo396(false).mo399(true).mo401(NetflixActionBar.LogoType.START_ALIGNED);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == BillingManager.Companion.getLEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE() && intent != null) {
            int intExtra = intent.getIntExtra(BillingManager.Companion.getLEGACY_GOOGLE_PLAY_RESPONSE_CODE(), 0);
            List<? extends C0738> r7 = intExtra != 0 ? null : EI.m4806(new C0738(intent.getStringExtra(BillingManager.Companion.getLEGACY_GOOGLE_PLAY_INAPP_PURCHASE_DATA()), intent.getStringExtra(BillingManager.Companion.getLEGACY_GOOGLE_PLAY_INAPP_DATA_SIGNATURE())));
            BillingManager billingManager2 = this.billingManager;
            if (billingManager2 == null) {
                C1457Fr.m5017("billingManager");
            }
            billingManager2.getBillingResponseHandler().invoke(Integer.valueOf(intExtra), r7);
        }
    }

    private final void initSavedBundleProps(Bundle bundle) {
        this.suppressNavigateToFlowMode = bundle != null ? Boolean.valueOf(bundle.getBoolean(KEY_SUPPRESS_NAVIGATE_ON_RESTORE)) : null;
    }

    private final void initProgressSpinner() {
        showProgressSpinner();
    }

    private final void initWindow() {
        C1317As.m3765((Activity) this);
    }

    public final LifecycleRegistry getLifecycleRegistry$NetflixApp_release() {
        return this.lifecycleRegistry;
    }

    public final void setLifecycleRegistry$NetflixApp_release(LifecycleRegistry lifecycleRegistry2) {
        C1457Fr.m5025(lifecycleRegistry2, "<set-?>");
        this.lifecycleRegistry = lifecycleRegistry2;
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.arch.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void onCreateOptionsMenu(Menu menu, Menu menu2) {
        C1457Fr.m5025(menu, "menu");
        SignInButtonInHeaderType value = getFlowModel().getSignInButtonType().getValue();
        if (value != null) {
            switch (value) {
                case SIGN_IN:
                    addSignInMenuOption(menu);
                    break;
                case SIGN_OUT:
                    addSignOutMenuOption(menu);
                    break;
            }
        }
        super.onCreateOptionsMenu(menu, menu2);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showHelpInMenu() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.signupPrompt;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: private */
    public final void startNavigation() {
        if (getFlowModel().getCurrentFlowMode() == null) {
            fetchMode("welcome");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void setTheme() {
        setTheme(R.style.res_2131952241_theme_signup_native);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new SignupNativeActivity$createManagerStatusListener$1(this);
    }

    /* access modifiers changed from: private */
    public final void updateCurrentAppLocale(C2059ph phVar) {
        phVar.m9794(zN.f12697.m13525(this).toLanguageTag());
    }

    private final void showInterruptDialog() {
        new AlertDialog.Builder(new ContextThemeWrapper(this, (int) R.style.SignupInterruptDialog)).setMessage(R.string.signup_interrupt_by_user).setPositiveButton(R.string.button_yes, new SignupNativeActivity$showInterruptDialog$1(this)).setNegativeButton(R.string.button_no, SignupNativeActivity$showInterruptDialog$2.INSTANCE).show();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        FlowMode currentFlowMode = getFlowModel().getCurrentFlowMode();
        String id = currentFlowMode != null ? currentFlowMode.getId() : null;
        if (id == null || C1457Fr.m5018((Object) id, (Object) "welcome")) {
            return false;
        }
        if (C1457Fr.m5018((Object) id, (Object) SignupConstants.Mode.CONFIRM_MEMBERSHIP_STARTED)) {
            launchProfilesGate();
            return true;
        }
        AbstractSignupFragment currentFragment = getCurrentFragment();
        if (currentFragment == null) {
            return false;
        }
        switch (currentFragment.backBehavior()) {
            case NORMAL_BACK:
                this.fragmentManager.popBackStack();
                return true;
            case INTERRUPT_WITH_DIALOG:
                showInterruptDialog();
                return true;
            default:
                return true;
        }
    }

    public final void fetchMode(String str) {
        C1457Fr.m5025(str, "mode");
        C2059ph serviceManager = getServiceManager();
        C1457Fr.m5016((Object) serviceManager, "serviceManager");
        AbstractC1194 r0 = serviceManager.m9757();
        if (r0 != null) {
            r0.mo16169(str, new SignupNativeActivity$fetchMode$1(this));
        }
    }

    public final void onFlowModeEmpty() {
        AbstractSignupViewModel viewModel;
        FlowMode flowMode;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("eventName", "FlowModeEmpty");
        FlowMode currentFlowMode = getFlowModel().getCurrentFlowMode();
        jSONObject.put("flowModelFlowId", currentFlowMode != null ? currentFlowMode.getFlowId() : null);
        AbstractSignupFragment currentFragment = getCurrentFragment();
        jSONObject.put("viewModelFlowId", (currentFragment == null || (viewModel = currentFragment.getViewModel()) == null || (flowMode = viewModel.getFlowMode()) == null) ? null : flowMode.getFlowId());
        jSONObject.put("suppressNavigate", this.suppressNavigateToFlowMode);
        Logger.INSTANCE.m131(new C0729(jSONObject));
        finish();
        startActivity(zN.f12697.m13529(this));
    }

    private final void initSignupHeaderObserver() {
        getFlowModel().getSignInButtonType().observe(this, new SignupNativeActivity$initSignupHeaderObserver$1(this));
    }

    private final void initViewModelObserver() {
        getFlowModel().getCurrentMoneyballData().observe(this, new SignupNativeActivity$initViewModelObserver$1(this));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putBoolean(KEY_SUPPRESS_NAVIGATE_ON_RESTORE, true);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToFlowMode(FlowMode flowMode) {
        AbstractSignupViewModel viewModel;
        MutableLiveData<Boolean> isLoading;
        if (flowMode != null) {
            hideProgressSpinner();
            getFlowModel().updateSignInButtonInHeader(flowMode);
            if (SignupMode.INSTANCE.isSignupSimplicityFlow(flowMode.getFlowId())) {
                launchSignupSimplicity(flowMode.getId());
                return;
            }
            AbstractSignupFragment mapToFragment = SignupMode.INSTANCE.mapToFragment(flowMode);
            updateNavigationLevel(mapToFragment != null ? mapToFragment.getAppView() : null);
            AbstractSignupFragment currentFragment = getCurrentFragment();
            if (!(currentFragment == null || (viewModel = currentFragment.getViewModel()) == null || (isLoading = viewModel.isLoading()) == null)) {
                isLoading.setValue(false);
            }
            if (mapToFragment != null) {
                launchFragment(mapToFragment);
            } else if (SignupMode.INSTANCE.isLoginMode(flowMode.getId())) {
                startActivity(ActivityC2186tp.m11240(this));
            } else if (SignupMode.INSTANCE.isMemberMode(flowMode.getId())) {
                launchProfilesGate();
            } else if (SignupMode.INSTANCE.isSignupSimplicityFlow(flowMode.getFlowId())) {
                launchSignupSimplicity(flowMode.getId());
            } else if (SignupMode.INSTANCE.isOnboardingMode(flowMode.getId())) {
                launchOnboarding(flowMode);
            } else if (SignupMode.INSTANCE.isOnboardingSwitchFlowMode(flowMode)) {
                launchSwitchFlowOnboarding(flowMode);
            } else if (SignupMode.INSTANCE.isSwitchFlowMode(flowMode.getId())) {
                launchSwitchFlowMode(flowMode);
            } else {
                C1276.m16820().mo5725("Android Signup Native activity: We do not know how to handle mode " + flowMode.getId());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateNavigationLevel(AppView appView) {
        Long l;
        Long l2 = this.lastNavigationSessionId;
        if (l2 != null) {
            l2.longValue();
            Logger.INSTANCE.m140(this.lastNavigationSessionId);
        }
        SignupNativeActivity signupNativeActivity = this;
        if (appView != null) {
            signupNativeActivity = signupNativeActivity;
            l = Logger.INSTANCE.m142(new C1212(appView, null));
        } else {
            l = null;
        }
        signupNativeActivity.lastNavigationSessionId = l;
    }

    private final void launchSwitchFlowMode(FlowMode flowMode) {
        String str = (String) flowMode.getFieldValue(SignupConstants.Field.TARGET_FLOW);
        String str2 = (String) flowMode.getFieldValue(SignupConstants.Field.TARGET_MODE);
        String str3 = (String) flowMode.getFieldValue(SignupConstants.Field.TARGET_NETFLIX_CLIENT_PLATFORM);
        if (str == null) {
            C1276.m16820().mo5725("Android Signup Native activity: Switch flow did not provide a targetFlow");
        } else if (str2 == null) {
            C1276.m16820().mo5725("Android Signup Native activity: Switch flow did not provide a targetMode");
        } else if (C1457Fr.m5018((Object) str3, (Object) "androidWebView")) {
            launchSignupSimplicity(str2);
        } else {
            AbstractSignupFragment mapToFragment = SignupMode.INSTANCE.mapToFragment(flowMode);
            if (mapToFragment != null) {
                launchFragment(mapToFragment);
            }
        }
    }

    private final void launchOnboarding(FlowMode flowMode) {
        startActivity(OnBoardingActivity.Companion.createStartIntent(this).putExtra("nextUrl", SignupViewModel.Companion.getShaktiInboundUrl(flowMode.getFlowId(), flowMode.getId())));
        finish();
    }

    private final void launchSwitchFlowOnboarding(FlowMode flowMode) {
        Field field = flowMode.getField(SignupConstants.Field.TARGET_FLOW);
        Object value = field != null ? field.getValue() : null;
        if (value == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) value;
        Field field2 = flowMode.getField(SignupConstants.Field.TARGET_MODE);
        Object value2 = field2 != null ? field2.getValue() : null;
        if (value2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        startActivity(OnBoardingActivity.Companion.createStartIntent(this).putExtra("nextUrl", SignupViewModel.Companion.getShaktiInboundUrl(str, (String) value2)));
        finish();
    }

    private final void launchSignupSimplicity(String str) {
        startActivity(zJ.m13442(this).addFlags(268468224).putExtra("nextUrl", SignupViewModel.Companion.getShaktiInboundUrl(SignupConstants.Flow.SIGNUP_SIMPLICITY, str)));
        finish();
    }

    private final void logAndLaunchFragment(AbstractSignupFragment abstractSignupFragment) {
        updateNavigationLevel(abstractSignupFragment.getAppView());
        launchFragment(abstractSignupFragment);
    }

    private final void launchFragment(Fragment fragment) {
        String str;
        Class<?> cls;
        Fragment fragment2 = fragment;
        if (!(fragment2 instanceof AbstractSignupFragment)) {
            fragment2 = null;
        }
        AbstractSignupFragment abstractSignupFragment = (AbstractSignupFragment) fragment2;
        boolean r4 = abstractSignupFragment == null ? false : C1457Fr.m5018(abstractSignupFragment.backBehavior(), SignupBackType.NORMAL_BACK);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.setTransition(4097);
        AbstractSignupFragment currentFragment = getCurrentFragment();
        if (currentFragment == null || (cls = currentFragment.getClass()) == null || (str = cls.getSimpleName()) == null) {
            str = "";
        }
        String simpleName = fragment.getClass().getSimpleName();
        C1457Fr.m5016((Object) simpleName, "nextFragmentName");
        if (fragmentShouldAnimateBackwards(str, simpleName)) {
            beginTransaction.setCustomAnimations(17432578, 17432579);
        } else if (fragmentShouldAnimateForward(str, simpleName)) {
            ((C0807) _$_findCachedViewById(R.Cif.signupActivitySpinnerContentFlipper)).setBackgroundColor(getResources().getColor(R.color.signup_background_light));
            beginTransaction.setCustomAnimations(R.anim.aui_slide_in_right, R.anim.aui_slide_out_left);
        }
        beginTransaction.replace(R.id.signup_fragment_container, fragment, simpleName);
        if (r4) {
            beginTransaction.addToBackStack(fragment.getClass().getName());
        }
        beginTransaction.commit();
    }

    private final boolean fragmentShouldAnimateBackwards(String str, String str2) {
        return C1457Fr.m5018(str, StartMembershipOnContextFragment.class.getSimpleName()) && C1457Fr.m5018(str2, ConfirmFragment.class.getSimpleName());
    }

    private final boolean fragmentShouldAnimateForward(String str, String str2) {
        if (!C1457Fr.m5018((Object) str, (Object) WelcomeFragment.class.getSimpleName()) && !C1457Fr.m5018((Object) str, (Object) WelcomeSlidingDoorsFragment.class.getSimpleName()) && !C1457Fr.m5018((Object) str2, (Object) WelcomeFragment.class.getSimpleName()) && !C1457Fr.m5018((Object) str2, (Object) WelcomeSlidingDoorsFragment.class.getSimpleName())) {
            return true;
        }
        return false;
    }

    private final void addSignInMenuOption(Menu menu) {
        MenuItem add = menu.add(0, R.id.menu_sign_in, 0, getString(R.string.label_sign_in));
        add.setShowAsAction(1);
        add.setOnMenuItemClickListener(new SignupNativeActivity$addSignInMenuOption$1(this));
    }

    private final void addSignOutMenuOption(Menu menu) {
        MenuItem add = menu.add(0, R.id.menu_sign_out, 0, getString(R.string.label_sign_out));
        add.setShowAsAction(1);
        add.setOnMenuItemClickListener(new SignupNativeActivity$addSignOutMenuOption$1(this));
    }

    private final String errorStringFromRequestStatus(Status status) {
        String string = getResources().getString(R.string.generic_retryable_failure);
        C1457Fr.m5016((Object) string, "resources.getString(R.st…eneric_retryable_failure)");
        return string;
    }

    public final void showErrorDialogForStatus(Status status) {
        C1457Fr.m5025(status, "status");
        showError(errorStringFromRequestStatus(status));
    }

    /* access modifiers changed from: protected */
    public final void showError(String str) {
        C1457Fr.m5025(str, DeepErrorElement.Debug.MESSAGE);
        new AlertDialog.Builder(new ContextThemeWrapper(this, (int) R.style.SignupInterruptDialog)).setMessage(str).setCancelable(false).setPositiveButton(R.string.label_ok, new SignupNativeActivity$showError$dialogBuilder$1(this)).show();
    }

    private final void showProgressSpinner() {
        C0807 r0 = (C0807) _$_findCachedViewById(R.Cif.signupActivitySpinnerContentFlipper);
        C1457Fr.m5016((Object) r0, "signupActivitySpinnerContentFlipper");
        r0.setDisplayedChild(Companion.getVIEW_FLIPPER_SPINNER_INDEX());
        ((C0807) _$_findCachedViewById(R.Cif.signupActivitySpinnerContentFlipper)).setBackgroundColor(getResources().getColor(R.color.window_bg));
    }

    /* access modifiers changed from: private */
    public final void hideProgressSpinner() {
        C0807 r0 = (C0807) _$_findCachedViewById(R.Cif.signupActivitySpinnerContentFlipper);
        C1457Fr.m5016((Object) r0, "signupActivitySpinnerContentFlipper");
        r0.setDisplayedChild(Companion.getVIEW_FLIPPER_FRAGMENT_CONTAINER_INDEX());
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public ContextWrapper wrapContextLocale(Context context) {
        C1457Fr.m5025(context, "context");
        ContextWrapper r0 = BX.m3947(context, zN.f12697.m13525(context));
        C1457Fr.m5016((Object) r0, "LocalizationUtils.wrap(context, locale)");
        return r0;
    }

    private final void initBillingManager() {
        this.billingManager = new BillingManager(this);
    }

    private final void launchProfilesGate() {
        if (!this.loggingIn) {
            showProgressSpinner();
            this.loggingIn = true;
            getServiceManager().m9755(new SignupNativeActivity$launchProfilesGate$MemberHomeCallback(this));
        }
    }

    public final void endRenderNavigationLevelLogging() {
        Logger.INSTANCE.m133("RenderNavigationLevel");
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.PaymentSelectionFragment.PaymentSelectionClickListener
    public void onPaymentGiftCardClick() {
        logAndLaunchFragment(new GiftCardPaymentFragment());
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.PaymentSelectionFragment.PaymentSelectionClickListener
    public void onPaymentCreditCardClick() {
        logAndLaunchFragment(new CreditPaymentFragment());
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.PlanContextFragment.PlanContextClickListener
    public void onPlanContextConfirm() {
        logAndLaunchFragment(new PlanSelectionFragment());
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.RegistrationContextFragment.RegistrationContextClickListener
    public void onRegistrationContextConfirm() {
        logAndLaunchFragment(new RegistrationFragment());
    }
}
