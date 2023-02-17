package com.netflix.mediaclient.acquisition.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.cl.model.InputKind;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.kotlinx.TextViewKt;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.util.AUITermsOfUseUtilities;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.view.SignupHeadingView;
import com.netflix.mediaclient.acquisition.view.SignupInlineWarningView;
import com.netflix.mediaclient.acquisition.view.TermsOfUseView;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.RegistrationViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC0744;
import o.AbstractC1433Et;
import o.C0403;
import o.C0586;
import o.C0716;
import o.C0965;
import o.C1027;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1458Fs;
import o.C1461Fv;
import o.EI;
import o.FQ;
public final class RegistrationFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(RegistrationFragment.class), "registrationViewModel", "getRegistrationViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/RegistrationViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String EMAIL_OPT_IN = "email_consent_opt_in";
    private HashMap _$_findViewCache;
    private final AbstractC1433Et registrationViewModel$delegate = C1435Ev.m4972(new RegistrationFragment$registrationViewModel$2(this));

    /* access modifiers changed from: private */
    public final RegistrationViewModel getRegistrationViewModel() {
        AbstractC1433Et et = this.registrationViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (RegistrationViewModel) et.mo3220();
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
    public AppView getAppView() {
        return AppView.registration;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.registration_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initViews();
        initWarning();
        initRxValidationsAndClickListeners();
        initAdvertisingLogging();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getRegistrationViewModel();
    }

    private final void initViews() {
        EditText editText = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
        StringField email = getRegistrationViewModel().getEmail();
        editText.setText(String.valueOf(email != null ? email.getValue() : null));
        EditText editText2 = (EditText) _$_findCachedViewById(R.Cif.passwordEditText);
        StringField password = getRegistrationViewModel().getPassword();
        editText2.setText(String.valueOf(password != null ? password.getValue() : null));
        initPasswordEditTextSoftKeyboardActions();
        initSignupHeading();
        initCheckboxes();
        initCTAButton();
        initInputStates();
    }

    private final void initPasswordEditTextSoftKeyboardActions() {
        if (!hasCheckboxes()) {
            EditText editText = (EditText) _$_findCachedViewById(R.Cif.passwordEditText);
            C1457Fr.m5016((Object) editText, "passwordEditText");
            editText.setImeOptions(2);
        }
        ((EditText) _$_findCachedViewById(R.Cif.passwordEditText)).setOnEditorActionListener(new RegistrationFragment$initPasswordEditTextSoftKeyboardActions$1(this));
    }

    private final void initInputStates() {
        StringField email = getRegistrationViewModel().getEmail();
        if (!TextUtils.isEmpty(String.valueOf(email != null ? email.getValue() : null))) {
            getRegistrationViewModel().setShowEmailState(true);
            setEmailValidationError();
        }
        StringField password = getRegistrationViewModel().getPassword();
        if (!TextUtils.isEmpty(String.valueOf(password != null ? password.getValue() : null))) {
            getRegistrationViewModel().setShowPasswordState(true);
            setPasswordValidationError();
        }
    }

    private final void initSignupHeading() {
        Field field;
        SignupNativeActivity signupActivity;
        CharSequence stepsFieldToString;
        String str;
        String str2;
        String str3;
        FlowMode flowMode = getRegistrationViewModel().getFlowMode();
        if (flowMode != null && (field = flowMode.getField(SignupConstants.Field.STEPS)) != null && (signupActivity = getSignupActivity()) != null && (stepsFieldToString = AUIMoneyballUtilities.INSTANCE.stepsFieldToString(signupActivity, field)) != null) {
            SignupHeadingView signupHeadingView = (SignupHeadingView) _$_findCachedViewById(R.Cif.signupHeading);
            CharSequence charSequence = stepsFieldToString;
            String registrationFormTitle = getRegistrationViewModel().getRegistrationFormTitle();
            if (registrationFormTitle != null) {
                FragmentActivity activity = getActivity();
                String stringResource = activity != null ? ContextKt.getStringResource(activity, registrationFormTitle) : null;
                signupHeadingView = signupHeadingView;
                charSequence = charSequence;
                str = stringResource;
            } else {
                str = null;
            }
            String str4 = str;
            StringBuilder append = new StringBuilder().append("");
            String valuePropMessage = getRegistrationViewModel().getValuePropMessage();
            if (valuePropMessage != null) {
                FragmentActivity activity2 = getActivity();
                String stringResource2 = activity2 != null ? ContextKt.getStringResource(activity2, valuePropMessage) : null;
                signupHeadingView = signupHeadingView;
                charSequence = charSequence;
                str4 = str4;
                append = append;
                str2 = stringResource2;
            } else {
                str2 = null;
            }
            StringBuilder append2 = append.append(str2).append('\n').append("");
            String valuePropMessageSecondary = getRegistrationViewModel().getValuePropMessageSecondary();
            if (valuePropMessageSecondary != null) {
                FragmentActivity activity3 = getActivity();
                String stringResource3 = activity3 != null ? ContextKt.getStringResource(activity3, valuePropMessageSecondary) : null;
                signupHeadingView = signupHeadingView;
                charSequence = charSequence;
                str4 = str4;
                append2 = append2;
                str3 = stringResource3;
            } else {
                str3 = null;
            }
            signupHeadingView.setStrings(charSequence, str4, EI.m4806(append2.append(str3).toString()));
        }
    }

    private final void initWarning() {
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null) {
            ((SignupInlineWarningView) _$_findCachedViewById(R.Cif.registrationWarningView)).setWarningText(getRegistrationViewModel().localizedErrorString(signupActivity));
        }
    }

    private final void initRxValidationsAndClickListeners() {
        Observable<Boolean> observable;
        EditText editText = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
        C1457Fr.m5016((Object) editText, "emailEditText");
        Observable<Boolean> textChangesSignUpFormValidation = TextViewKt.textChangesSignUpFormValidation(editText, new RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$1(this), getEnableDebounceOnTextViews(), new RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$2(this), new RegistrationFragment$initRxValidationsAndClickListeners$emailValidationObservable$3(this));
        EditText editText2 = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
        C1457Fr.m5016((Object) editText2, "emailEditText");
        AbstractC0744<Boolean> r0 = C0965.m15785(editText2);
        C1457Fr.m5016((Object) r0, "RxView.focusChanges(this)");
        r0.skip(1).subscribe(new RegistrationFragment$initRxValidationsAndClickListeners$1(this));
        EditText editText3 = (EditText) _$_findCachedViewById(R.Cif.passwordEditText);
        C1457Fr.m5016((Object) editText3, "passwordEditText");
        Observable<Boolean> textChangesSignUpFormValidation2 = TextViewKt.textChangesSignUpFormValidation(editText3, new RegistrationFragment$initRxValidationsAndClickListeners$passwordValidationObservable$1(this), getEnableDebounceOnTextViews(), new RegistrationFragment$initRxValidationsAndClickListeners$passwordValidationObservable$2(this), new RegistrationFragment$initRxValidationsAndClickListeners$passwordValidationObservable$3(this));
        EditText editText4 = (EditText) _$_findCachedViewById(R.Cif.passwordEditText);
        C1457Fr.m5016((Object) editText4, "passwordEditText");
        AbstractC0744<Boolean> r02 = C0965.m15785(editText4);
        C1457Fr.m5016((Object) r02, "RxView.focusChanges(this)");
        r02.skip(1).subscribe(new RegistrationFragment$initRxValidationsAndClickListeners$2(this));
        if (((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).isCheckboxVisible()) {
            observable = ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).checkedChanges().doOnNext(new RegistrationFragment$initRxValidationsAndClickListeners$touValidationObservable$1(this));
        } else {
            observable = Observable.just(true);
        }
        Observable combineLatest = Observable.combineLatest(textChangesSignUpFormValidation, textChangesSignUpFormValidation2, observable, RegistrationFragment$initRxValidationsAndClickListeners$buttonEnabledObservable$1.INSTANCE);
        C1457Fr.m5016((Object) combineLatest, "Observable.combineLatest…swordValid && touValid })");
        combineLatest.takeUntil(C0965.m15784((NetflixSignupButton) _$_findCachedViewById(R.Cif.registrationButton))).distinctUntilChanged().subscribe(new RegistrationFragment$initRxValidationsAndClickListeners$3(this));
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.registrationButton)).setOnClickListener(new RegistrationFragment$initRxValidationsAndClickListeners$4(this));
    }

    public final void handleSubmitForm() {
        boolean r4 = C1457Fr.m5018((Object) getRegistrationViewModel().isLoading().getValue(), (Object) true);
        if (!getRegistrationViewModel().getAllFieldsValidated() || r4) {
            getRegistrationViewModel().setShowEmailState(true);
            getRegistrationViewModel().setShowPasswordState(true);
            setEmailValidationError();
            setPasswordValidationError();
            TermsOfUseView termsOfUseView = (TermsOfUseView) _$_findCachedViewById(R.Cif.touView);
            BooleanField hasAcceptedTermsOfUse = getRegistrationViewModel().getHasAcceptedTermsOfUse();
            termsOfUseView.setErrorVisible(hasAcceptedTermsOfUse != null && !((Boolean) hasAcceptedTermsOfUse.getValue()).booleanValue());
            return;
        }
        getRegistrationViewModel().isLoading().setValue(true);
        ActionField nextAction = getRegistrationViewModel().getNextAction();
        if (nextAction != null) {
            Long r7 = Logger.INSTANCE.m142(new C0586());
            RegistrationViewModel registrationViewModel = getRegistrationViewModel();
            SignupNativeActivity signupActivity = getSignupActivity();
            registrationViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new RegistrationFragment$handleSubmitForm$1$1(this));
            Logger.INSTANCE.m140(r7);
        }
    }

    public final boolean hasCheckboxes() {
        StringField termsOfUseRegion = getRegistrationViewModel().getTermsOfUseRegion();
        Object value = termsOfUseRegion != null ? termsOfUseRegion.getValue() : null;
        if (!(value instanceof String)) {
            value = null;
        }
        return getRegistrationViewModel().getEmailPreference() != null || C1457Fr.m5018((String) value, SignupConstants.Field.REST_OF_WORLD);
    }

    public final void initCheckboxes() {
        StringField emailConsentLabelId = getRegistrationViewModel().getEmailConsentLabelId();
        if (getRegistrationViewModel().getEmailPreference() != null) {
            CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.emailCheckbox);
            if (checkBox != null) {
                checkBox.setVisibility(0);
            }
            CheckBox checkBox2 = (CheckBox) _$_findCachedViewById(R.Cif.emailCheckbox);
            if (checkBox2 != null) {
                checkBox2.setOnCheckedChangeListener(new RegistrationFragment$initCheckboxes$1(this));
            }
            if (C1457Fr.m5018((Object) EMAIL_OPT_IN, emailConsentLabelId != null ? emailConsentLabelId.getValue() : null)) {
                CheckBox checkBox3 = (CheckBox) _$_findCachedViewById(R.Cif.emailCheckbox);
                if (checkBox3 != null) {
                    checkBox3.setText(getString(R.string.label_email_consent_opt_in));
                }
            } else {
                CheckBox checkBox4 = (CheckBox) _$_findCachedViewById(R.Cif.emailCheckbox);
                if (checkBox4 != null) {
                    checkBox4.setText(getString(R.string.label_email_consent_opt_out));
                }
            }
        }
        if (getRegistrationViewModel().getHasAcceptedTermsOfUse() != null) {
            StringField termsOfUseRegion = getRegistrationViewModel().getTermsOfUseRegion();
            Object value = termsOfUseRegion != null ? termsOfUseRegion.getValue() : null;
            if (!(value instanceof String)) {
                value = null;
            }
            String str = (String) value;
            ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).setText(AUITermsOfUseUtilities.INSTANCE.getTouMessage(getContext(), str));
            ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).setCheckboxVisible(AUITermsOfUseUtilities.INSTANCE.isTouCheckboxVisible(str));
            BooleanField hasAcceptedTermsOfUse = getRegistrationViewModel().getHasAcceptedTermsOfUse();
            if (hasAcceptedTermsOfUse != null) {
                hasAcceptedTermsOfUse.setValue(Boolean.valueOf(true == ((TermsOfUseView) _$_findCachedViewById(R.Cif.touView)).hasAcceptedTermsOfUse()));
            }
        }
    }

    public final void initCTAButton() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.registrationButton)).setLoadingData(getRegistrationViewModel().isLoading());
        NetflixSignupButton netflixSignupButton = (NetflixSignupButton) _$_findCachedViewById(R.Cif.registrationButton);
        C1457Fr.m5016((Object) netflixSignupButton, "registrationButton");
        String string = netflixSignupButton.getContext().getString(R.string.button_continue);
        C1457Fr.m5016((Object) string, "registrationButton.conte…R.string.button_continue)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.registrationButton)).setText(string);
    }

    /* access modifiers changed from: private */
    public final void setEmailValidationError() {
        StringField email = getRegistrationViewModel().getEmail();
        boolean z = email != null && email.isValid();
        if (!z && getRegistrationViewModel().getShowEmailState()) {
            Long r5 = Logger.INSTANCE.m142(new C1027(InputKind.email));
            StringField email2 = getRegistrationViewModel().getEmail();
            double minLength = email2 != null ? email2.getMinLength() : C1458Fs.f5678.m5026();
            StringField email3 = getRegistrationViewModel().getEmail();
            double maxLength = email3 != null ? email3.getMaxLength() : C1458Fs.f5678.m5027();
            EditText editText = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
            C1457Fr.m5016((Object) editText, "emailEditText");
            if (TextUtils.isEmpty(editText.getText())) {
                C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
                C1457Fr.m5016((Object) r0, "emailEditTextErrorMessage");
                r0.setText(getString(R.string.error_required_email));
            } else {
                EditText editText2 = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
                C1457Fr.m5016((Object) editText2, "emailEditText");
                if (((double) editText2.getText().length()) >= minLength) {
                    EditText editText3 = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
                    C1457Fr.m5016((Object) editText3, "emailEditText");
                    if (((double) editText3.getText().length()) <= maxLength) {
                        C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
                        C1457Fr.m5016((Object) r02, "emailEditTextErrorMessage");
                        r02.setText(getString(R.string.registration_validation_error_email));
                    }
                }
                C0716 r03 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
                C1457Fr.m5016((Object) r03, "emailEditTextErrorMessage");
                C0716 r1 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
                C1457Fr.m5016((Object) r1, "emailEditTextErrorMessage");
                r03.setText(C0403.m14185(r1.getContext(), R.string.invalid_length_email).m14186("minLength", Double.valueOf(minLength)).m14186("maxLength", Double.valueOf(maxLength)).m14188());
            }
            ((TextInputLayout) _$_findCachedViewById(R.Cif.emailTextInputLayout)).setBackgroundResource(R.drawable.text_input_layout_error_background);
            C0716 r04 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
            C1457Fr.m5016((Object) r04, "emailEditTextErrorMessage");
            r04.setVisibility(0);
            Logger.INSTANCE.m147(C1027.m16017(r5));
        } else if (!z || !getRegistrationViewModel().getShowEmailState()) {
            ((TextInputLayout) _$_findCachedViewById(R.Cif.emailTextInputLayout)).setBackgroundResource(R.drawable.text_input_layout_focused_background);
            C0716 r05 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
            C1457Fr.m5016((Object) r05, "emailEditTextErrorMessage");
            r05.setVisibility(8);
        } else {
            Long r52 = Logger.INSTANCE.m142(new C1027(InputKind.email));
            ((TextInputLayout) _$_findCachedViewById(R.Cif.emailTextInputLayout)).setBackgroundResource(R.drawable.text_input_layout_validated_background);
            C0716 r06 = (C0716) _$_findCachedViewById(R.Cif.emailEditTextErrorMessage);
            C1457Fr.m5016((Object) r06, "emailEditTextErrorMessage");
            r06.setVisibility(8);
            Logger.INSTANCE.m147(C1027.m16017(r52));
        }
    }

    /* access modifiers changed from: private */
    public final void setPasswordValidationError() {
        StringField password = getRegistrationViewModel().getPassword();
        boolean z = password != null && password.isValid();
        if (!z && getRegistrationViewModel().getShowPasswordState()) {
            Long r5 = Logger.INSTANCE.m142(new C1027(InputKind.password));
            StringField password2 = getRegistrationViewModel().getPassword();
            double minLength = password2 != null ? password2.getMinLength() : C1458Fs.f5678.m5026();
            StringField password3 = getRegistrationViewModel().getPassword();
            double maxLength = password3 != null ? password3.getMaxLength() : C1458Fs.f5678.m5027();
            EditText editText = (EditText) _$_findCachedViewById(R.Cif.passwordEditText);
            C1457Fr.m5016((Object) editText, "passwordEditText");
            if (TextUtils.isEmpty(editText.getText())) {
                C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
                C1457Fr.m5016((Object) r0, "passwordEditTextErrorMessage");
                r0.setText(getString(R.string.error_required_password));
            } else {
                EditText editText2 = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
                C1457Fr.m5016((Object) editText2, "emailEditText");
                if (((double) editText2.getText().length()) >= minLength) {
                    EditText editText3 = (EditText) _$_findCachedViewById(R.Cif.emailEditText);
                    C1457Fr.m5016((Object) editText3, "emailEditText");
                    if (((double) editText3.getText().length()) <= maxLength) {
                        C0716 r02 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
                        C1457Fr.m5016((Object) r02, "passwordEditTextErrorMessage");
                        r02.setText(getString(R.string.registration_validation_error_password));
                    }
                }
                C0716 r03 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
                C1457Fr.m5016((Object) r03, "passwordEditTextErrorMessage");
                C0716 r1 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
                C1457Fr.m5016((Object) r1, "passwordEditTextErrorMessage");
                r03.setText(C0403.m14185(r1.getContext(), R.string.invalid_length_password).m14186("minLength", Double.valueOf(minLength)).m14186("maxLength", Double.valueOf(maxLength)).m14188());
            }
            ((TextInputLayout) _$_findCachedViewById(R.Cif.passwordTextInputLayout)).setBackgroundResource(R.drawable.text_input_layout_error_background);
            C0716 r04 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
            C1457Fr.m5016((Object) r04, "passwordEditTextErrorMessage");
            r04.setVisibility(0);
            Logger.INSTANCE.m147(C1027.m16017(r5));
        } else if (!z || !getRegistrationViewModel().getShowPasswordState()) {
            ((TextInputLayout) _$_findCachedViewById(R.Cif.passwordTextInputLayout)).setBackgroundResource(R.drawable.text_input_layout_focused_background);
            C0716 r05 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
            C1457Fr.m5016((Object) r05, "passwordEditTextErrorMessage");
            r05.setVisibility(8);
        } else {
            Long r52 = Logger.INSTANCE.m142(new C1027(InputKind.password));
            ((TextInputLayout) _$_findCachedViewById(R.Cif.passwordTextInputLayout)).setBackgroundResource(R.drawable.text_input_layout_validated_background);
            C0716 r06 = (C0716) _$_findCachedViewById(R.Cif.passwordEditTextErrorMessage);
            C1457Fr.m5016((Object) r06, "passwordEditTextErrorMessage");
            r06.setVisibility(8);
            Logger.INSTANCE.m147(C1027.m16017(r52));
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getRegistrationViewModel().setShowEmailState(false);
        getRegistrationViewModel().setShowPasswordState(false);
    }

    private final void initAdvertisingLogging() {
        logAdvertisingId(getServiceManager(), "registration");
    }
}
