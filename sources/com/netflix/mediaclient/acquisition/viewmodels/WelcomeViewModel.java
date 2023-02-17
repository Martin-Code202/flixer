package com.netflix.mediaclient.acquisition.viewmodels;

import android.content.Context;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.webclient.model.leafs.AUIContextData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import o.C0403;
import o.C1457Fr;
import o.C1464Fy;
import o.EI;
import o.zN;
public final class WelcomeViewModel extends AbstractSignupViewModel {
    private final String MODE = "welcome";
    private final String NEXT_ACTION_ID = "startAction";
    private String PREV_ACTION_ID = "signInAction";
    private final String backupVlvImageUrl = "https://assets.nflxext.com/ffe/siteui/vlv3/afbfd84e-c987-4438-99f2-8d0738d30d68/80f89692-9533-4b7b-ab0c-359825415564/US-en-20170918-popsignuptwoweeks-perspective_alpha_website_small.jpg";
    private final String cancelImageUrl = "https://assets.nflxext.com/ffe/siteui/acquisition/home/thisIsNetflix/modules/small/asset_cancelanytime_withdevice.jpg";
    private final String devicesComputerImageUrl = "https://assets.nflxext.com/ffe/siteui/acquisition/home/thisIsNetflix/modules/asset_mobile_tablet_UI_2.png";
    private final String devicesDownloadImageUrl = "https://assets.nflxext.com/ffe/siteui/acquisition/home/thisIsNetflix/modules/asset_website_UI.png";
    private final String devicesTvImageUrl = "https://assets.nflxext.com/ffe/siteui/acquisition/home/thisIsNetflix/modules/asset_TV_UI.png";
    private Map<String, String> playBillingPrices;

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getPREV_ACTION_ID() {
        return this.PREV_ACTION_ID;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public void setPREV_ACTION_ID(String str) {
        this.PREV_ACTION_ID = str;
    }

    public final List<String> getSkusList() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        if (!C1457Fr.m5018((Object) (flowMode != null ? flowMode.getFlowId() : null), (Object) SignupConstants.Flow.SIMPLE_SILVER_SIGN_UP)) {
            return null;
        }
        FlowMode flowMode2 = getFlowMode();
        Object pathValue = (flowMode2 == null || (data = flowMode2.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", SignupConstants.Key.OFFERS));
        if (pathValue == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        }
        List<Map> list = (List) pathValue;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list, 10));
        for (Map map : list) {
            Object obj = map.get(SignupConstants.Key.ID);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) obj);
        }
        return arrayList;
    }

    public final boolean getPlayStoreFallbackEnabled() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.PLAYSTORE_FALLBACK_ENABLED)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }

    public final Map<String, String> getPlayBillingPrices() {
        return this.playBillingPrices;
    }

    public final void setPlayBillingPrices(Map<String, String> map) {
        this.playBillingPrices = map;
    }

    public final String getBackupVlvImageUrl() {
        return this.backupVlvImageUrl;
    }

    public final String getCancelImageUrl() {
        return this.cancelImageUrl;
    }

    public final String getDevicesTvImageUrl() {
        return this.devicesTvImageUrl;
    }

    public final String getDevicesDownloadImageUrl() {
        return this.devicesDownloadImageUrl;
    }

    public final String getDevicesComputerImageUrl() {
        return this.devicesComputerImageUrl;
    }

    public final String getVlvImageUrl(Context context) {
        C1457Fr.m5025(context, "context");
        FlowMode flowMode = getFlowMode();
        String sizedCdnUrl = flowMode != null ? WelcomeViewModelKt.getSizedCdnUrl(flowMode, context) : null;
        if (sizedCdnUrl != null) {
            return sizedCdnUrl;
        }
        return this.backupVlvImageUrl;
    }

    public final List<PlanGridRowData> planSelectionRows(Context context) {
        PlanGridRowData planSelectionRowData$default;
        C1457Fr.m5025(context, "context");
        List<PlanGridRowData> r5 = EI.m4835((Collection) EI.m4838((Iterable) EI.m4804(getPlanSelectionPriceRowData(context, getPriceHeader(context)), getPlanSelectionRowData(ContextKt.getStringResource(context, "text_hd_available"), "hasHD"), getPlanSelectionRowData(ContextKt.getStringResource(context, "text_ultra_hd"), "hasUHD"), getPlanSelectionRowData(ContextKt.getStringResource(context, "text_screens_same_time"), "maxConcurrentStreams"), getPlanSelectionRowData(ContextKt.getStringResource(context, "text_watchable_devices"), "canPlayOnDevices"), getPlanSelectionRowData$default(this, ContextKt.getStringResource(context, "text_unlimited_watching"), null, 2, null), getPlanSelectionRowData$default(this, ContextKt.getStringResource(context, "text_cancel_anytime"), null, 2, null))));
        if (hasFreeTrial() && (planSelectionRowData$default = getPlanSelectionRowData$default(this, ContextKt.getStringResource(context, "text_first_month_free"), null, 2, null)) != null) {
            r5.add(planSelectionRowData$default);
        }
        return r5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.netflix.mediaclient.acquisition.viewmodels.WelcomeViewModel */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String localizedStringWithParams$default(WelcomeViewModel welcomeViewModel, Context context, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return welcomeViewModel.localizedStringWithParams(context, str, map);
    }

    private final String localizedStringWithParams(Context context, String str, Map<String, ? extends Object> map) {
        String stringResource = ContextKt.getStringResource(context, str);
        if (stringResource == null) {
            return null;
        }
        if (map != null ? !map.isEmpty() : false) {
            C1464Fy fy = C1464Fy.f5682;
            Object[] objArr = {map};
            int length = objArr.length;
            C1457Fr.m5016((Object) String.format(stringResource, Arrays.copyOf(objArr, 1)), "java.lang.String.format(format, *args)");
        }
        return stringResource;
    }

    private final String getPriceHeader(Context context) {
        C0403 r2 = C0403.m14185(context, getPriceHeaderKey());
        String r3 = zN.f12697.m13522(getFlowMode());
        if (r3 != null) {
            r2 = r2.m14186("endDate", r3);
        }
        String r0 = r2.m14188();
        C1457Fr.m5016((Object) r0, "formatter.format()");
        return r0;
    }

    private final PlanGridRowData getNetflixMOPPriceRowData(Context context, String str) {
        return getPlanSelectionRowData(str, "formattedPlanPrice");
    }

    private final PlanGridRowData getGooglePlayPriceRowData(String str) {
        String str2;
        Map<String, Object> data;
        if (str == null) {
            return null;
        }
        FlowMode flowMode = getFlowMode();
        Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", SignupConstants.Key.OFFERS));
        if (!(pathValue instanceof List)) {
            pathValue = null;
        }
        List list = (List) pathValue;
        if (list == null) {
            return null;
        }
        List<Map> list2 = list;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list2, 10));
        for (Map map : list2) {
            Object obj = map.get(SignupConstants.Key.ID);
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str3 = (String) obj;
            if (str3 != null) {
                Map<String, String> map2 = this.playBillingPrices;
                str2 = map2 != null ? map2.get(str3) : null;
            } else {
                str2 = null;
            }
            arrayList.add(str2);
        }
        List r5 = EI.m4838((Iterable) arrayList);
        if (r5.size() != list.size()) {
            return null;
        }
        return new PlanGridRowData(str, r5);
    }

    private final PlanGridRowData getPlanSelectionPriceRowData(Context context, String str) {
        FlowMode flowMode = getFlowMode();
        if (doesFlowGetPricesFromGooglePlay(flowMode != null ? flowMode.getFlowId() : null)) {
            return getGooglePlayPriceRowData(str);
        }
        return getNetflixMOPPriceRowData(context, str);
    }

    public final boolean doesFlowGetPricesFromGooglePlay(String str) {
        return C1457Fr.m5018((Object) str, (Object) SignupConstants.Flow.SIMPLE_SILVER_SIGN_UP);
    }

    static /* synthetic */ PlanGridRowData getPlanSelectionRowData$default(WelcomeViewModel welcomeViewModel, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return welcomeViewModel.getPlanSelectionRowData(str, str2);
    }

    private final PlanGridRowData getPlanSelectionRowData(String str, String str2) {
        ArrayList arrayList;
        Map<String, Object> data;
        if (str == null) {
            return null;
        }
        FlowMode flowMode = getFlowMode();
        Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", SignupConstants.Key.OFFERS));
        if (!(pathValue instanceof List)) {
            pathValue = null;
        }
        List list = (List) pathValue;
        if (list == null) {
            return null;
        }
        if (str2 != null) {
            List<Map> list2 = list;
            ArrayList arrayList2 = new ArrayList(EI.m4812((Iterable) list2, 10));
            for (Map map : list2) {
                arrayList2.add(map.get(str2));
            }
            arrayList = EI.m4838((Iterable) arrayList2);
        } else {
            List<Map> list3 = list;
            ArrayList arrayList3 = new ArrayList(EI.m4812((Iterable) list3, 10));
            for (Map map2 : list3) {
                arrayList3.add(true);
            }
            arrayList = arrayList3;
        }
        return new PlanGridRowData(str, arrayList);
    }

    private final boolean shouldDisplayPreTax() {
        Map<String, ?> geo;
        AUIContextData contextData = getContextData();
        Object obj = (contextData == null || (geo = contextData.getGeo()) == null) ? null : geo.get("showPreTaxDisclaimer");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        return (bool != null ? bool.booleanValue() : false) && !AUIMoneyballUtilities.INSTANCE.isFlowModeGooglePlay(getFlowMode());
    }

    private final int getPriceHeaderKey() {
        boolean shouldDisplayPreTax = shouldDisplayPreTax();
        return zN.f12697.m13522(getFlowMode()) == null ? shouldDisplayPreTax ? R.string.monthly_price_pretax : R.string.monthly_price : shouldDisplayPreTax ? R.string.text_price_after_pretax : R.string.text_price_after;
    }

    public final boolean hasFreeTrial() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.HAS_FREE_TRIAL)) == null) ? null : field.getValue();
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isRecognisedFormerMember() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.RECOGNIZED_FORMER_MEMBER)) == null) ? null : field.getValue();
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isRecognisedNeverMember() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.RECOGNIZED_NEVER_MEMBER)) == null) ? null : field.getValue();
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
