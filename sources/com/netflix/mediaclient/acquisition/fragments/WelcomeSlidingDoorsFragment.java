package com.netflix.mediaclient.acquisition.fragments;

import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.view.NetflixSignupButton;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.WelcomeSlidingDoorsViewModel;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C0522;
import o.C0738;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.C2059ph;
import o.FQ;
import o.zN;
public final class WelcomeSlidingDoorsFragment extends AbstractSignupFragment implements ViewPager.OnPageChangeListener {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(WelcomeSlidingDoorsFragment.class), "welcomeModel", "getWelcomeModel()Lcom/netflix/mediaclient/acquisition/viewmodels/WelcomeSlidingDoorsViewModel;"))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "WelcomeSlidingDoorsFragment";
    private HashMap _$_findViewCache;
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private final AbstractC1433Et welcomeModel$delegate = C1435Ev.m4972(new WelcomeSlidingDoorsFragment$welcomeModel$2(this));

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

    public final WelcomeSlidingDoorsViewModel getWelcomeModel() {
        AbstractC1433Et et = this.welcomeModel$delegate;
        FQ fq = $$delegatedProperties[0];
        return (WelcomeSlidingDoorsViewModel) et.mo3220();
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

    private final ImageLoader getImageLoader() {
        return NetflixActivity.getImageLoader(getActivity());
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AppView getAppView() {
        return AppView.nmLanding;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.welcome_sliding_doors_fragment_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        C1457Fr.m5025(view, "view");
        super.onViewCreated(view, bundle);
        initCards();
        initButton();
        initPager();
        initVlv();
        initLongClickListeners();
    }

    @Override // com.netflix.mediaclient.acquisition.fragments.AbstractSignupFragment
    public AbstractSignupViewModel getViewModel() {
        return getWelcomeModel();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterListeners();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListeners();
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

    private final void registerListeners() {
        ((ViewPager) _$_findCachedViewById(R.Cif.welcomeViewPager)).addOnPageChangeListener(this);
    }

    private final void unregisterListeners() {
        ((ViewPager) _$_findCachedViewById(R.Cif.welcomeViewPager)).removeOnPageChangeListener(this);
    }

    private final void initLongClickListeners() {
    }

    private final void initVlv() {
        ((C0522) _$_findCachedViewById(R.Cif.vlvImageView)).setPassActualScaleTypeToParent(true);
        C0522 r0 = (C0522) _$_findCachedViewById(R.Cif.vlvImageView);
        C1457Fr.m5016((Object) r0, "vlvImageView");
        r0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String vlvImageUrl = getWelcomeModel().getVlvImageUrl();
        ImageLoader imageLoader = getImageLoader();
        if (imageLoader != null) {
            imageLoader.mo3057((C0522) _$_findCachedViewById(R.Cif.vlvImageView), vlvImageUrl, AssetType.signupAsset, "vlvImage", StaticImgConfig.DARK, true);
        }
    }

    private final void initPager() {
        ((TabLayout) _$_findCachedViewById(R.Cif.welcomeTabLayout)).setupWithViewPager((ViewPager) _$_findCachedViewById(R.Cif.welcomeViewPager), true);
    }

    private final void initButton() {
        NetflixSignupButton netflixSignupButton = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome);
        String initCTAString = initCTAString();
        if (initCTAString == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        netflixSignupButton.setText(initCTAString);
        ((NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome)).setOnClickListener(new WelcomeSlidingDoorsFragment$initButton$1(this));
    }

    private final String initCTAString() {
        if (getWelcomeModel().isRecognisedFormerMember() && getWelcomeModel().hasFreeTrial()) {
            NetflixSignupButton netflixSignupButton = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome);
            C1457Fr.m5016((Object) netflixSignupButton, "netflixSignupButtonWelcome");
            return netflixSignupButton.getContext().getString(R.string.button_extra_free_trial);
        } else if (getWelcomeModel().isRecognisedFormerMember()) {
            NetflixSignupButton netflixSignupButton2 = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome);
            C1457Fr.m5016((Object) netflixSignupButton2, "netflixSignupButtonWelcome");
            return netflixSignupButton2.getContext().getString(R.string.button_restart_your_membership);
        } else if (getWelcomeModel().isRecognisedNeverMember()) {
            NetflixSignupButton netflixSignupButton3 = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome);
            C1457Fr.m5016((Object) netflixSignupButton3, "netflixSignupButtonWelcome");
            return netflixSignupButton3.getContext().getString(R.string.button_finishsignup_capitalized);
        } else {
            String ctaButtonStringKey = getWelcomeModel().getCtaButtonStringKey();
            if (ctaButtonStringKey == null) {
                return null;
            }
            NetflixSignupButton netflixSignupButton4 = (NetflixSignupButton) _$_findCachedViewById(R.Cif.netflixSignupButtonWelcome);
            C1457Fr.m5016((Object) netflixSignupButton4, "netflixSignupButtonWelcome");
            Context context = netflixSignupButton4.getContext();
            C1457Fr.m5016((Object) context, "netflixSignupButtonWelcome.context");
            return ContextKt.getStringResource(context, ctaButtonStringKey);
        }
    }

    private final void initCards() {
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.Cif.welcomeViewPager);
        C1457Fr.m5016((Object) viewPager, "welcomeViewPager");
        ViewPager viewPager2 = (ViewPager) _$_findCachedViewById(R.Cif.welcomeViewPager);
        C1457Fr.m5016((Object) viewPager2, "welcomeViewPager");
        Context context = viewPager2.getContext();
        C1457Fr.m5016((Object) context, "welcomeViewPager.context");
        viewPager.setAdapter(new SlidingDoorsCardPagerAdapter(context, getImageLoader(), getWelcomeModel().getCards()));
    }

    /* access modifiers changed from: private */
    public final void nextTapped() {
        BillingManager billingManager;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null && (billingManager = signupActivity.getBillingManager()) != null) {
            billingManager.restoreSubscription(new WelcomeSlidingDoorsFragment$nextTapped$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleRestore(int i, List<? extends C0738> list) {
        C2059ph serviceManager;
        SignupNativeActivity signupActivity = getSignupActivity();
        if (signupActivity != null && (serviceManager = signupActivity.getServiceManager()) != null) {
            zN.f12697.m13518(i, list, getWelcomeModel(), serviceManager, new WelcomeSlidingDoorsFragment$handleRestore$1(this));
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (i == 0) {
            C0522 r0 = (C0522) _$_findCachedViewById(R.Cif.vlvImageView);
            C1457Fr.m5016((Object) r0, "vlvImageView");
            r0.setAlpha((float) (1.0d - ((double) f)));
            C0522 r02 = (C0522) _$_findCachedViewById(R.Cif.vlvImageView);
            C1457Fr.m5016((Object) r02, "vlvImageView");
            r02.setTranslationX(-50.0f * f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }
}
