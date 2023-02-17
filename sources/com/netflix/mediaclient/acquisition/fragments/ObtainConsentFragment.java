package com.netflix.mediaclient.acquisition.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.ObtainConsentViewModel;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC0744;
import o.AbstractC1433Et;
import o.C0403;
import o.C0716;
import o.C0754;
import o.C1090;
import o.C1435Ev;
import o.C1452Fm;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.FQ;
public final class ObtainConsentFragment extends AbstractSignupFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(ObtainConsentFragment.class), "obtainConsentViewModel", "getObtainConsentViewModel()Lcom/netflix/mediaclient/acquisition/viewmodels/ObtainConsentViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String MIN_AGE_KEY = "MIN_AGE";
    private HashMap _$_findViewCache;
    private final AbstractC1433Et obtainConsentViewModel$delegate = C1435Ev.m4972(new ObtainConsentFragment$obtainConsentViewModel$2(this));

    /* access modifiers changed from: private */
    public final ObtainConsentViewModel getObtainConsentViewModel() {
        AbstractC1433Et et = this.obtainConsentViewModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (ObtainConsentViewModel) et.mo3220();
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
        return AppView.obtainConsent;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.obtain_consent_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initViews();
        initClickHandlers();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getObtainConsentViewModel();
    }

    private final void initViews() {
        String str;
        TextView textView = (TextView) _$_findCachedViewById(R.Cif.touCheckboxText);
        C1457Fr.m5016((Object) textView, "touCheckboxText");
        textView.setText(Html.fromHtml(getString(R.string.label_check_termsOfUse)));
        TextView textView2 = (TextView) _$_findCachedViewById(R.Cif.touCheckboxText);
        C1457Fr.m5016((Object) textView2, "touCheckboxText");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        StringField termsOfUseMinimumVerificationAge = getObtainConsentViewModel().getTermsOfUseMinimumVerificationAge();
        Object value = termsOfUseMinimumVerificationAge != null ? termsOfUseMinimumVerificationAge.getValue() : null;
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.allCheckbox);
        C1457Fr.m5016((Object) checkBox, "allCheckbox");
        Context context = getContext();
        if (context != null) {
            checkBox = checkBox;
            str = C0403.m14185(context, R.string.label_check_all).m14186(MIN_AGE_KEY, value).m14188();
        } else {
            str = null;
        }
        checkBox.setText(str);
    }

    private final void initClickHandlers() {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.allCheckbox);
        C1457Fr.m5016((Object) checkBox, "allCheckbox");
        setupRequiredCheckBox(checkBox, new ObtainConsentFragment$initClickHandlers$1(this));
        CheckBox checkBox2 = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox2, "touCheckbox");
        setupRequiredCheckBox(checkBox2, new ObtainConsentFragment$initClickHandlers$2(this));
        CheckBox checkBox3 = (CheckBox) _$_findCachedViewById(R.Cif.thirdPartyCheckbox);
        C1457Fr.m5016((Object) checkBox3, "thirdPartyCheckbox");
        setupRequiredCheckBox(checkBox3, new ObtainConsentFragment$initClickHandlers$3(this));
        CheckBox checkBox4 = (CheckBox) _$_findCachedViewById(R.Cif.abroadCheckbox);
        C1457Fr.m5016((Object) checkBox4, "abroadCheckbox");
        setupRequiredCheckBox(checkBox4, new ObtainConsentFragment$initClickHandlers$4(this));
        ((CheckBox) _$_findCachedViewById(R.Cif.offersCheckbox)).setOnCheckedChangeListener(new ObtainConsentFragment$initClickHandlers$5(this));
        ((C0754) _$_findCachedViewById(R.Cif.consentButton)).setOnClickListener(new ObtainConsentFragment$initClickHandlers$6(this));
    }

    private final void setupRequiredCheckBox(CheckBox checkBox, Consumer<Boolean> consumer) {
        AbstractC0744<Boolean> r0 = C1090.m16182(checkBox);
        C1457Fr.m5016((Object) r0, "RxCompoundButton.checkedChanges(this)");
        r0.skip(1).doOnNext(consumer).subscribe(new ObtainConsentFragment$setupRequiredCheckBox$1(this, checkBox));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkForErrorMessage() {
        /*
            r3 = this;
            int r0 = com.netflix.mediaclient.R.Cif.allCheckbox
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            java.lang.String r1 = "allCheckbox"
            o.C1457Fr.m5016(r0, r1)
            boolean r0 = r3.isError(r0)
            if (r0 != 0) goto L_0x004c
            int r0 = com.netflix.mediaclient.R.Cif.touCheckbox
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            java.lang.String r1 = "touCheckbox"
            o.C1457Fr.m5016(r0, r1)
            boolean r0 = r3.isError(r0)
            if (r0 != 0) goto L_0x004c
            int r0 = com.netflix.mediaclient.R.Cif.thirdPartyCheckbox
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            java.lang.String r1 = "thirdPartyCheckbox"
            o.C1457Fr.m5016(r0, r1)
            boolean r0 = r3.isError(r0)
            if (r0 != 0) goto L_0x004c
            int r0 = com.netflix.mediaclient.R.Cif.abroadCheckbox
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            java.lang.String r1 = "abroadCheckbox"
            o.C1457Fr.m5016(r0, r1)
            boolean r0 = r3.isError(r0)
            if (r0 == 0) goto L_0x004e
        L_0x004c:
            r2 = 1
            goto L_0x004f
        L_0x004e:
            r2 = 0
        L_0x004f:
            int r0 = com.netflix.mediaclient.R.Cif.consentErrorMessage
            android.view.View r0 = r3._$_findCachedViewById(r0)
            o.კ r0 = (o.C0716) r0
            java.lang.String r1 = "consentErrorMessage"
            o.C1457Fr.m5016(r0, r1)
            if (r2 == 0) goto L_0x0060
            r1 = 0
            goto L_0x0062
        L_0x0060:
            r1 = 8
        L_0x0062:
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netflix.mediaclient.acquisition.fragments.ObtainConsentFragment.checkForErrorMessage():void");
    }

    /* access modifiers changed from: private */
    public final void handleSubmitForm() {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.allCheckbox);
        C1457Fr.m5016((Object) checkBox, "allCheckbox");
        if (checkBox.isChecked()) {
            CheckBox checkBox2 = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
            C1457Fr.m5016((Object) checkBox2, "touCheckbox");
            if (checkBox2.isChecked()) {
                CheckBox checkBox3 = (CheckBox) _$_findCachedViewById(R.Cif.thirdPartyCheckbox);
                C1457Fr.m5016((Object) checkBox3, "thirdPartyCheckbox");
                if (checkBox3.isChecked()) {
                    CheckBox checkBox4 = (CheckBox) _$_findCachedViewById(R.Cif.abroadCheckbox);
                    C1457Fr.m5016((Object) checkBox4, "abroadCheckbox");
                    if (checkBox4.isChecked()) {
                        ActionField nextAction = getObtainConsentViewModel().getNextAction();
                        if (nextAction != null) {
                            ObtainConsentViewModel obtainConsentViewModel = getObtainConsentViewModel();
                            SignupNativeActivity signupActivity = getSignupActivity();
                            obtainConsentViewModel.next(nextAction, signupActivity != null ? signupActivity.getServiceManager() : null, new ObtainConsentFragment$handleSubmitForm$1$1(this));
                            return;
                        }
                        return;
                    }
                }
            }
        }
        showErrors();
    }

    /* access modifiers changed from: private */
    public final void setAllCheckboxes(boolean z) {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox, "touCheckbox");
        checkBox.setChecked(z);
        CheckBox checkBox2 = (CheckBox) _$_findCachedViewById(R.Cif.thirdPartyCheckbox);
        C1457Fr.m5016((Object) checkBox2, "thirdPartyCheckbox");
        checkBox2.setChecked(z);
        CheckBox checkBox3 = (CheckBox) _$_findCachedViewById(R.Cif.abroadCheckbox);
        C1457Fr.m5016((Object) checkBox3, "abroadCheckbox");
        checkBox3.setChecked(z);
        CheckBox checkBox4 = (CheckBox) _$_findCachedViewById(R.Cif.offersCheckbox);
        C1457Fr.m5016((Object) checkBox4, "offersCheckbox");
        checkBox4.setChecked(z);
    }

    private final void showErrors() {
        boolean z = false;
        Iterator r4 = C1452Fm.m5010(new CheckBox[]{(CheckBox) _$_findCachedViewById(R.Cif.allCheckbox), (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox), (CheckBox) _$_findCachedViewById(R.Cif.thirdPartyCheckbox), (CheckBox) _$_findCachedViewById(R.Cif.abroadCheckbox)});
        while (r4.hasNext()) {
            CheckBox checkBox = (CheckBox) r4.next();
            C1457Fr.m5016((Object) checkBox, "it");
            if (!checkBox.isChecked()) {
                showError(checkBox, true);
                z = true;
            }
        }
        if (z) {
            C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.consentErrorMessage);
            C1457Fr.m5016((Object) r0, "consentErrorMessage");
            r0.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void showError(CheckBox checkBox, boolean z) {
        checkBox.setActivated(z);
    }

    private final boolean isError(CheckBox checkBox) {
        return checkBox.isActivated();
    }
}
