package com.netflix.mediaclient.acquisition.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.BillingManagerInterface;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.view.PlanChoiceHeaderView;
import com.netflix.mediaclient.acquisition.view.PlanValuesView;
import com.netflix.mediaclient.acquisition.view.SignupHeadingView;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.PlanGridRowData;
import com.netflix.mediaclient.acquisition.viewmodels.PlanSelectionViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC0574;
import o.AbstractC1433Et;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.EI;
import o.FQ;
public final class PlanSelectionFragment extends AbstractSignupPresentationLoggingFragment {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(PlanSelectionFragment.class), "planSelectionModel", "getPlanSelectionModel()Lcom/netflix/mediaclient/acquisition/viewmodels/PlanSelectionViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SELECTED_PLAN = "selectedPlan";
    private HashMap _$_findViewCache;
    private final AbstractC1433Et planSelectionModel$delegate = C1435Ev.m4972(new PlanSelectionFragment$planSelectionModel$2(this));

    /* access modifiers changed from: private */
    public final PlanSelectionViewModel getPlanSelectionModel() {
        AbstractC1433Et et = this.planSelectionModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (PlanSelectionViewModel) et.mo3220();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
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

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment, com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment, android.support.v4.app.Fragment
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
        return AppView.planSelection;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.plan_selection_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initPrices();
        initPlanSelectionHeading();
        initPlanChoiceHeader();
        initPlanRowValues();
        initContinueButtonText();
        initClickListeners();
        selectDefaultPlan();
        initTextDisclaimer();
        initAdvertisingLogging();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getPlanSelectionModel();
    }

    private final void initPlanSelectionHeading() {
        if (getPlanSelectionModel().isRecognisedFormerMember()) {
            initFormerMemberHeading();
        } else {
            initNewMemberHeading();
        }
    }

    private final void initPlanChoiceHeader() {
        ((PlanChoiceHeaderView) _$_findCachedViewById(R.Cif.planChoiceHeader)).addPlanChoiceHeaderLayout(getPlanSelectionModel().getDefaultSelectedPlan(), getPlanSelectionModel().getPlanChoiceHeaderNames(), getPlanSelectionModel().getPlanOfferIds());
        ((PlanChoiceHeaderView) _$_findCachedViewById(R.Cif.planChoiceHeader)).setOnPlanChanged(new PlanSelectionFragment$initPlanChoiceHeader$1(this));
    }

    /* access modifiers changed from: private */
    public final void initPlanRowValues() {
        List<Map<Object, Object>> rowMessages;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (!(signupActivity == null || (rowMessages = getPlanSelectionModel().getRowMessages()) == null)) {
            List<Map<Object, Object>> list = rowMessages;
            ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list, 10));
            for (T t : list) {
                String moneyballField = getPlanSelectionModel().getMoneyballField(t);
                String planRowHeading = getPlanSelectionModel().getPlanRowHeading(signupActivity, t);
                if (planRowHeading == null) {
                    planRowHeading = "";
                }
                if (C1457Fr.m5018((Object) moneyballField, (Object) SignupConstants.Field.PLAN_PRICE) && !getPlanSelectionModel().hasFreeTrial()) {
                    PlanValuesView planValuesView = (PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView);
                    C1457Fr.m5016((Object) planValuesView, "planChoiceValuesView");
                    planRowHeading = planValuesView.getContext().getString(R.string.monthly_price);
                    C1457Fr.m5016((Object) planRowHeading, "planChoiceValuesView.con…g(R.string.monthly_price)");
                }
                arrayList.add(new PlanGridRowData(planRowHeading, getPlanSelectionModel().initPlanValues(moneyballField)));
            }
            PlanValuesView.initRows$default((PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView), arrayList, null, null, 6, null);
        }
    }

    private final void initContinueButtonText() {
        String string = getString(R.string.button_continue);
        C1457Fr.m5016((Object) string, "getString(R.string.button_continue)");
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.planSelectionContinueButton)).setText(string);
    }

    private final void selectDefaultPlan() {
        ((PlanValuesView) _$_findCachedViewById(R.Cif.planChoiceValuesView)).selectPlan(getPlanSelectionModel().getDefaultSelectedPlan(), getPlanSelectionModel().getPlanOfferIds());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        C1457Fr.m5025(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString("selectedPlan", getPlanSelectionModel().getPlanSelected());
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String string;
        super.onActivityCreated(bundle);
        if (bundle != null && (string = bundle.getString("selectedPlan")) != null) {
            int indexOf = getPlanSelectionModel().getPlanOfferIds().indexOf(string);
            ((PlanChoiceHeaderView) _$_findCachedViewById(R.Cif.planChoiceHeader)).getOnPlanChanged().invoke(string);
            ((PlanChoiceHeaderView) _$_findCachedViewById(R.Cif.planChoiceHeader)).selectPlanButton(indexOf);
        }
    }

    private final void initClickListeners() {
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.planSelectionContinueButton)).setLoadingData(getPlanSelectionModel().isLoading());
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.planSelectionContinueButton)).setOnClickListener(new PlanSelectionFragment$initClickListeners$1(this));
    }

    private final void initPrices() {
        BillingManagerInterface billingManager = BillingManager.Companion.getBillingManager(getSignupActivity());
        List<String> skusList = getPlanSelectionModel().getSkusList();
        if (skusList != null && billingManager != null) {
            billingManager.fetchPrices(skusList, true, 3, new PlanSelectionFragment$initPrices$1(this));
        }
    }

    private final void initFormerMemberHeading() {
        SignupHeadingView signupHeadingView = (SignupHeadingView) _$_findCachedViewById(R.Cif.planSelectionHeading);
        C1457Fr.m5016((Object) signupHeadingView, "planSelectionHeading");
        signupHeadingView.setVisibility(8);
        View _$_findCachedViewById = _$_findCachedViewById(R.Cif.planSelectionHeadingFormer);
        C1457Fr.m5016((Object) _$_findCachedViewById, "planSelectionHeadingFormer");
        _$_findCachedViewById.setVisibility(0);
    }

    private final void initNewMemberHeading() {
        CharSequence charSequence;
        String str;
        String str2;
        View _$_findCachedViewById = _$_findCachedViewById(R.Cif.planSelectionHeadingFormer);
        C1457Fr.m5016((Object) _$_findCachedViewById, "planSelectionHeadingFormer");
        _$_findCachedViewById.setVisibility(8);
        FlowMode flowMode = getPlanSelectionModel().getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.STEPS) : null;
        if (field != null) {
            AUIMoneyballUtilities aUIMoneyballUtilities = AUIMoneyballUtilities.INSTANCE;
            SignupHeadingView signupHeadingView = (SignupHeadingView) _$_findCachedViewById(R.Cif.planSelectionHeading);
            C1457Fr.m5016((Object) signupHeadingView, "planSelectionHeading");
            Context context = signupHeadingView.getContext();
            C1457Fr.m5016((Object) context, "planSelectionHeading.context");
            charSequence = aUIMoneyballUtilities.stepsFieldToString(context, field);
        } else {
            charSequence = null;
        }
        SignupHeadingView signupHeadingView2 = (SignupHeadingView) _$_findCachedViewById(R.Cif.planSelectionHeading);
        CharSequence charSequence2 = charSequence;
        String headerTitleMessage = getPlanSelectionModel().getHeaderTitleMessage();
        if (headerTitleMessage != null) {
            FragmentActivity activity = getActivity();
            String stringResource = activity != null ? ContextKt.getStringResource(activity, headerTitleMessage) : null;
            signupHeadingView2 = signupHeadingView2;
            charSequence2 = charSequence2;
            str = stringResource;
        } else {
            str = null;
        }
        String str3 = str;
        StringBuilder append = new StringBuilder().append("");
        String headerSubtitleMessage = getPlanSelectionModel().getHeaderSubtitleMessage();
        if (headerSubtitleMessage != null) {
            FragmentActivity activity2 = getActivity();
            String stringResource2 = activity2 != null ? ContextKt.getStringResource(activity2, headerSubtitleMessage) : null;
            signupHeadingView2 = signupHeadingView2;
            charSequence2 = charSequence2;
            str3 = str3;
            append = append;
            str2 = stringResource2;
        } else {
            str2 = null;
        }
        signupHeadingView2.setStrings(charSequence2, str3, EI.m4806(append.append(str2).toString()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (r4 != null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initTextDisclaimer() {
        /*
            r7 = this;
            com.netflix.mediaclient.acquisition.viewmodels.PlanSelectionViewModel r0 = r7.getPlanSelectionModel()
            java.lang.String r4 = r0.getTextDisclaimer()
            if (r4 == 0) goto L_0x001d
            r5 = r4
            r6 = r5
            android.support.v4.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x0019
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r4 = com.netflix.mediaclient.acquisition.kotlinx.ContextKt.getStringResource(r0, r6)
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            if (r4 == 0) goto L_0x001d
            goto L_0x0029
        L_0x001d:
            r0 = 2131887571(0x7f1205d3, float:1.9409753E38)
            java.lang.String r4 = r7.getString(r0)
            java.lang.String r0 = "getString(R.string.text_disclaimer)"
            o.C1457Fr.m5016(r4, r0)
        L_0x0029:
            int r0 = com.netflix.mediaclient.R.Cif.textDisclaimer
            android.view.View r0 = r7._$_findCachedViewById(r0)
            o.კ r0 = (o.C0716) r0
            java.lang.String r1 = "textDisclaimer"
            o.C1457Fr.m5016(r0, r1)
            android.text.method.MovementMethod r1 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r1)
            int r0 = com.netflix.mediaclient.R.Cif.textDisclaimer
            android.view.View r0 = r7._$_findCachedViewById(r0)
            o.კ r0 = (o.C0716) r0
            java.lang.String r1 = "textDisclaimer"
            o.C1457Fr.m5016(r0, r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            o.zN$if r1 = o.zN.f12697
            android.text.Spanned r1 = r1.m13520(r4)
            if (r1 != 0) goto L_0x005c
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r3 = "null cannot be cast to non-null type android.text.Spannable"
            r2.<init>(r3)
            throw r2
        L_0x005c:
            android.text.Spannable r1 = (android.text.Spannable) r1
            com.netflix.mediaclient.acquisition.kotlinx.TextViewKt.setUnderlineStrippedText(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netflix.mediaclient.acquisition.fragments.PlanSelectionFragment.initTextDisclaimer():void");
    }

    private final void initAdvertisingLogging() {
        if (getPlanSelectionModel().isRecognisedFormerMember()) {
            logAdvertisingId(getServiceManager(), "planSelection_rejoin");
        } else {
            logAdvertisingId(getServiceManager(), "planSelection");
        }
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupPresentationLoggingFragment
    public AbstractC0574 getTrackingInfo() {
        return getPlanSelectionModel().getTrackingInfo();
    }
}
