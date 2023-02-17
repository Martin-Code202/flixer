package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.Map;
import kotlin.TypeCastException;
public final class StartMembershipViewModel extends AbstractSignupViewModel {
    private final int FREE_TRIAL_IN_DAYS = 30;
    private final int GOOGLE_PLAY_RETRY_SIGNUP_LIMIT = 3;
    private final String MODE = SignupConstants.Mode.START_MEMBERSHIP_ON_CONTEXT;
    private final String NEXT_ACTION_ID = SignupConstants.Action.START_MEMBERSHIP;
    private String PREV_ACTION_ID = SignupConstants.Action.CANCEL_ACTION;
    private int simpleHawkRetryCount;

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

    public final int getGOOGLE_PLAY_RETRY_SIGNUP_LIMIT() {
        return this.GOOGLE_PLAY_RETRY_SIGNUP_LIMIT;
    }

    public final int getFREE_TRIAL_IN_DAYS() {
        return this.FREE_TRIAL_IN_DAYS;
    }

    public final int getSimpleHawkRetryCount() {
        return this.simpleHawkRetryCount;
    }

    public final void setSimpleHawkRetryCount(int i) {
        this.simpleHawkRetryCount = i;
    }

    public final void incrementSimpleHawkRetryCount() {
        this.simpleHawkRetryCount++;
    }

    public final String getSelectedSku() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object obj = (flowMode == null || (data = flowMode.getData()) == null) ? null : data.get("fields");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        }
        Object obj2 = ((Map) obj).get(SignupConstants.Field.PLAN_CHOICE);
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        return (String) obj2;
    }

    public final String getFreeTrialEndDate() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object obj = (flowMode == null || (data = flowMode.getData()) == null) ? null : data.get("fields");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        }
        Object obj2 = ((Map) obj).get(SignupConstants.Field.FREE_TRIAL_END_DATE);
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        return (String) obj2;
    }

    public final String getPartnerID() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object obj = (flowMode == null || (data = flowMode.getData()) == null) ? null : data.get("fields");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        }
        Object obj2 = ((Map) obj).get(SignupConstants.Field.PARTNER_ID);
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        return (String) obj2;
    }

    public final BooleanField getHasFreeTrial() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.HAS_FREE_TRIAL) : null;
        if (!(field instanceof BooleanField)) {
            field = null;
        }
        return (BooleanField) field;
    }

    public final int getFreeTrialInDays() {
        BooleanField hasFreeTrial = getHasFreeTrial();
        Object value = hasFreeTrial != null ? hasFreeTrial.getValue() : null;
        if (value == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        } else if (((Boolean) value).booleanValue()) {
            return this.FREE_TRIAL_IN_DAYS;
        } else {
            return 0;
        }
    }

    public final StringField getDevPayload() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.DEV_PAYLOAD) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final StringField getReceipt() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.RECEIPT) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final StringField getPartnerResponse() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.PARTNER_RESPONSE) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final StringField getPartnerResponseSignature() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.PARTNER_RESPONSE_SIGNATURE) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final String getCsPhoneNumber() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.CS_PHONE_NUMBER)) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        String str = (String) value;
        return str != null ? str : "https://netflix.com/help";
    }

    public final boolean getPlayStoreFallbackEnabled() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.PLAYSTORE_FALLBACK_ENABLED)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }
}
