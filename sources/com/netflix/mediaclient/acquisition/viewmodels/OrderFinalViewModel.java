package com.netflix.mediaclient.acquisition.viewmodels;

import android.text.TextUtils;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCodesData;
import java.util.List;
import java.util.Map;
import o.AbstractC1449Fj;
import o.C1457Fr;
import o.C2059ph;
import o.EA;
import o.EI;
public final class OrderFinalViewModel extends AbstractSignupViewModel {
    private final String MODE = SignupConstants.Mode.CONFIRM_MEMBERSHIP_STARTED;
    private final String NEXT_ACTION_ID = "continueAction";
    private PhoneCodesData phoneCodesData;

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    public final StringField getEmail() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.EMAIL) : null);
    }

    public final StringField getFirstName() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.FIRST_NAME) : null);
    }

    public final StringField getLastName() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.LAST_NAME) : null);
    }

    public final StringField getPassword() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.PASSWORD) : null);
    }

    public final BooleanField getHasFreeTrial() {
        FlowMode flowMode = getFlowMode();
        return (BooleanField) (flowMode != null ? flowMode.getField(SignupConstants.Field.HAS_FREE_TRIAL) : null);
    }

    public final StringField getFreeTrialEndDate() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.FREE_TRIAL_END_DATE) : null);
    }

    public final boolean getPlayStoreFallbackEnabled() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.PLAYSTORE_FALLBACK_ENABLED)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }

    public final StringField getMobilePhone() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.MOBILE_PHONE) : null);
    }

    public final StringField getCountryCode() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.COUNTRY_CODE) : null);
    }

    public final PhoneCodesData getPhoneCodesData() {
        return this.phoneCodesData;
    }

    public final void setPhoneCodesData(PhoneCodesData phoneCodesData2) {
        this.phoneCodesData = phoneCodesData2;
    }

    public final String getOfferId() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        return (String) ((flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", "selectedPlan", "value", SignupConstants.Field.OFFER_ID, "value")));
    }

    public final Boolean getPlanHasHd() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        return (Boolean) ((flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", "selectedPlan", "value", SignupConstants.Field.PLAN_HAS_HD, "value")));
    }

    public final Boolean getPlanHasUltraHd() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        return (Boolean) ((flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", "selectedPlan", "value", SignupConstants.Field.PLAN_HAS_ULTRA_HD, "value")));
    }

    public final Double getPlanMaxScreen() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        return (Double) ((flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", "selectedPlan", "value", SignupConstants.Field.PLAN_MAX_SCREEN_COUNT, "value")));
    }

    public final String getFullName() {
        StringField firstName = getFirstName();
        String valueOf = String.valueOf(firstName != null ? firstName.getValue() : null);
        StringField lastName = getLastName();
        String valueOf2 = String.valueOf(lastName != null ? lastName.getValue() : null);
        if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(valueOf2)) {
            return null;
        }
        return "" + valueOf + ' ' + valueOf2;
    }

    public final void sendToMemberHome(C2059ph phVar, AbstractC1449Fj<EA> fj) {
        C1457Fr.m5025(fj, "completion");
        if (phVar != null) {
            phVar.m9755(new OrderFinalViewModel$sendToMemberHome$LoginManagerCallback(fj));
        }
    }
}
