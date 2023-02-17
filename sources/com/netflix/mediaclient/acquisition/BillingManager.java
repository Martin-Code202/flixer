package com.netflix.mediaclient.acquisition;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.netflix.mediaclient.acquisition.util.DebugBillingManager;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.partner.PartnerInstallType;
import java.util.List;
import java.util.Map;
import o.AbstractC0446;
import o.AbstractC0865;
import o.AbstractC0888;
import o.AbstractC1221;
import o.AbstractC1450Fk;
import o.AbstractC1451Fl;
import o.C0683;
import o.C0738;
import o.C0900;
import o.C1456Fq;
import o.C1457Fr;
import o.EA;
public final class BillingManager implements BillingManagerInterface, AbstractC0888 {
    public static final Companion Companion = new Companion(null);
    private static int LEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE = 2;
    private static final String LEGACY_GOOGLE_PLAY_INAPP_DATA_SIGNATURE = LEGACY_GOOGLE_PLAY_INAPP_DATA_SIGNATURE;
    private static final String LEGACY_GOOGLE_PLAY_INAPP_PURCHASE_DATA = LEGACY_GOOGLE_PLAY_INAPP_PURCHASE_DATA;
    private static final String LEGACY_GOOGLE_PLAY_RESPONSE_CODE = LEGACY_GOOGLE_PLAY_RESPONSE_CODE;
    public static final String TAG = "BillingManager";
    private static final String mockedChannelId = mockedChannelId;
    private static final String mockedInstallType = mockedInstallType;
    private static boolean mockedIsNetflixPartnerloadedEnabledValue = false;
    private static boolean mockedPlayBillingEnabledValue = false;
    private static boolean shouldMockChannelId = false;
    private static boolean shouldMockInstallType = false;
    private static boolean shouldMockIsNetflixPartnerloaded = false;
    private static boolean shouldMockPlayBilling = false;
    private final Activity activity;
    private AbstractC0446 billingClient;
    private AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> billingResponseHandler = BillingManager$billingResponseHandler$1.INSTANCE;
    private Map<String, String> cachedPrices;
    private C0683 playBilling;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        private final boolean getMockedPlayBillingEnabledValue() {
            return BillingManager.mockedPlayBillingEnabledValue;
        }

        private final void setMockedPlayBillingEnabledValue(boolean z) {
            BillingManager.mockedPlayBillingEnabledValue = z;
        }

        private final boolean getMockedIsNetflixPartnerloadedEnabledValue() {
            return BillingManager.mockedIsNetflixPartnerloadedEnabledValue;
        }

        private final void setMockedIsNetflixPartnerloadedEnabledValue(boolean z) {
            BillingManager.mockedIsNetflixPartnerloadedEnabledValue = z;
        }

        private final String getMockedInstallType() {
            return BillingManager.mockedInstallType;
        }

        private final String getMockedChannelId() {
            return BillingManager.mockedChannelId;
        }

        public final boolean getShouldMockPlayBilling() {
            return BillingManager.shouldMockPlayBilling;
        }

        public final void setShouldMockPlayBilling(boolean z) {
            BillingManager.shouldMockPlayBilling = z;
        }

        public final boolean getShouldMockIsNetflixPartnerloaded() {
            return BillingManager.shouldMockIsNetflixPartnerloaded;
        }

        public final void setShouldMockIsNetflixPartnerloaded(boolean z) {
            BillingManager.shouldMockIsNetflixPartnerloaded = z;
        }

        public final boolean getShouldMockChannelId() {
            return BillingManager.shouldMockChannelId;
        }

        public final void setShouldMockChannelId(boolean z) {
            BillingManager.shouldMockChannelId = z;
        }

        public final boolean getShouldMockInstallType() {
            return BillingManager.shouldMockInstallType;
        }

        public final void setShouldMockInstallType(boolean z) {
            BillingManager.shouldMockInstallType = z;
        }

        public final int getLEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE() {
            return BillingManager.LEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE;
        }

        public final void setLEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE(int i) {
            BillingManager.LEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE = i;
        }

        public final String getLEGACY_GOOGLE_PLAY_RESPONSE_CODE() {
            return BillingManager.LEGACY_GOOGLE_PLAY_RESPONSE_CODE;
        }

        public final String getLEGACY_GOOGLE_PLAY_INAPP_PURCHASE_DATA() {
            return BillingManager.LEGACY_GOOGLE_PLAY_INAPP_PURCHASE_DATA;
        }

        public final String getLEGACY_GOOGLE_PLAY_INAPP_DATA_SIGNATURE() {
            return BillingManager.LEGACY_GOOGLE_PLAY_INAPP_DATA_SIGNATURE;
        }

        public final void setIsNetflixPartnerloadedMocking(boolean z) {
            setShouldMockIsNetflixPartnerloaded(true);
            setMockedIsNetflixPartnerloadedEnabledValue(z);
        }

        public final boolean isNetflixPartnerloaded(AbstractC1221 r2) {
            C1457Fr.m5025(r2, "configAgent");
            if (getShouldMockIsNetflixPartnerloaded()) {
                return getMockedIsNetflixPartnerloadedEnabledValue();
            }
            return PartnerInstallType.m482(r2.mo16562());
        }

        public final String getInstallType(AbstractC1221 r3) {
            C1457Fr.m5025(r3, "configAgent");
            if (getShouldMockInstallType()) {
                return getMockedInstallType();
            }
            String r0 = r3.mo16562();
            C1457Fr.m5016((Object) r0, "configAgent.installType");
            return r0;
        }

        public final String getChannelId(AbstractC1221 r2) {
            C1457Fr.m5025(r2, "configAgent");
            if (getShouldMockChannelId()) {
                return getMockedChannelId();
            }
            return r2.mo16560();
        }

        public final void setPlayBillingMocking(boolean z) {
            setShouldMockPlayBilling(true);
            setMockedPlayBillingEnabledValue(z);
        }

        public final boolean isPlayBillingEnabled(AbstractC1221 r2) {
            C1457Fr.m5025(r2, "configAgent");
            if (getShouldMockPlayBilling()) {
                return getMockedPlayBillingEnabledValue();
            }
            return !r2.mo16535() && !isNetflixPartnerloaded(r2);
        }

        public final BillingManagerInterface getBillingManager(SignupNativeActivity signupNativeActivity) {
            if (BillingManager.Companion.getShouldMockPlayBilling()) {
                DebugBillingManager debugBillingManager = signupNativeActivity != null ? signupNativeActivity.getDebugBillingManager() : null;
                if (!(debugBillingManager instanceof BillingManagerInterface)) {
                    debugBillingManager = null;
                }
                return (BillingManagerInterface) debugBillingManager;
            }
            BillingManager billingManager = signupNativeActivity != null ? signupNativeActivity.getBillingManager() : null;
            if (!(billingManager instanceof BillingManagerInterface)) {
                billingManager = null;
            }
            return billingManager;
        }
    }

    public BillingManager(Activity activity2) {
        C1457Fr.m5025(activity2, "activity");
        this.activity = activity2;
        AbstractC0446 r0 = AbstractC0446.m14320(activity2).m14325(this).m14324();
        C1457Fr.m5016((Object) r0, "BillingClient.newBuilder…his)\n            .build()");
        this.billingClient = r0;
        this.playBilling = new C0683(activity2, new Handler());
        this.playBilling.m14950(AnonymousClass1.INSTANCE);
        this.billingClient.mo14322(new AbstractC0865() { // from class: com.netflix.mediaclient.acquisition.BillingManager.2
            @Override // o.AbstractC0865
            public void onBillingSetupFinished(int i) {
                if (i == 0) {
                }
            }

            @Override // o.AbstractC0865
            public void onBillingServiceDisconnected() {
            }
        });
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: o.Fl<? super java.lang.Integer, ? super java.util.List<? extends o.ᐢ>, o.EA>, o.Fl<java.lang.Integer, java.util.List<? extends o.ᐢ>, o.EA> */
    public final AbstractC1451Fl<Integer, List<? extends C0738>, EA> getBillingResponseHandler() {
        return this.billingResponseHandler;
    }

    public final void setBillingResponseHandler(AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl) {
        C1457Fr.m5025(fl, "<set-?>");
        this.billingResponseHandler = fl;
    }

    @Override // com.netflix.mediaclient.acquisition.BillingManagerInterface
    public void invokePurchase(String str, String str2, int i, String str3, AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl) {
        C1457Fr.m5025(str, "sku");
        C1457Fr.m5025(fl, "purchaseHandler");
        this.billingResponseHandler = fl;
        if (this.activity instanceof NetflixActivity) {
            this.playBilling.m14960((NetflixActivity) this.activity, str, str2, i, str3, Companion.getLEGACY_GOOGLE_PLAY_BILLING_REQUEST_CODE());
        } else {
            Log.e(TAG, "invokePurchase can only be called on a NetflixActivity");
        }
    }

    @Override // com.netflix.mediaclient.acquisition.BillingManagerInterface
    public void fetchPrices(List<String> list, boolean z, int i, AbstractC1450Fk<? super Map<String, String>, EA> fk) {
        C1457Fr.m5025(list, "skusList");
        C1457Fr.m5025(fk, "googlePlayPricesResponseHandler");
        if (!z || this.cachedPrices == null) {
            C0900 r7 = C0900.m15627().m15631(list).m15632("subs").m15633();
            C1457Fr.m5016((Object) r7, "SkuDetailsParams\n       …UBS)\n            .build()");
            this.billingClient.mo14323(r7, new BillingManager$fetchPrices$1(this, list, i, z, fk));
            return;
        }
        fk.invoke(this.cachedPrices);
    }

    @Override // com.netflix.mediaclient.acquisition.BillingManagerInterface
    public void restoreSubscription(AbstractC1451Fl<? super Integer, ? super List<? extends C0738>, EA> fl) {
        C1457Fr.m5025(fl, "restoreHandler");
        C0738.C0739 r2 = this.billingClient.mo14321("subs");
        C1457Fr.m5016((Object) r2, "purchasesResult");
        int r3 = r2.m15119();
        fl.invoke(Integer.valueOf(r3), r2.m15118());
    }

    @Override // o.AbstractC0888
    public void onPurchasesUpdated(int i, List<? extends C0738> list) {
        this.billingResponseHandler.invoke(Integer.valueOf(i), list);
    }
}
