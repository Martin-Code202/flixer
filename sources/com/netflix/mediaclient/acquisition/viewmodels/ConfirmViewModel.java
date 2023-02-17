package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.List;
import java.util.Map;
import o.EI;
public final class ConfirmViewModel extends AbstractSignupViewModel {
    private final String CHANGE_PLAN_ACTION_ID = "changePlanAction";
    private final String MODE = "confirm";
    private final String NEXT_ACTION_ID = SignupConstants.Action.CONFIRM_ORDER_ACTION;
    private ActionField changePlanAction;
    private String priceString = "";

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    public final String getCHANGE_PLAN_ACTION_ID() {
        return this.CHANGE_PLAN_ACTION_ID;
    }

    public final ActionField getChangePlanAction() {
        return this.changePlanAction;
    }

    public final void setChangePlanAction(ActionField actionField) {
        this.changePlanAction = actionField;
    }

    public final String getFirstName() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.FIRST_NAME)) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        return (String) value;
    }

    public final String getLastName() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.LAST_NAME)) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        return (String) value;
    }

    public final String getEmail() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.EMAIL)) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        return (String) value;
    }

    public final String getUserMessage() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.USER_MESSAGE)) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        return (String) value;
    }

    public final boolean getPlayStoreFallbackEnabled() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.PLAYSTORE_FALLBACK_ENABLED)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }

    public final BooleanField getHasAcceptedTermsOfUse() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.HAS_ACCEPTED_TERMS_OF_USE) : null;
        if (!(field instanceof BooleanField)) {
            field = null;
        }
        return (BooleanField) field;
    }

    public final String getFreeTrialEndDate() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", SignupConstants.Field.FREE_TRIAL_END_DATE));
        if (!(pathValue instanceof String)) {
            pathValue = null;
        }
        return (String) pathValue;
    }

    public final boolean getHasFreeTrial() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.HAS_FREE_TRIAL)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }

    public final boolean getRecognizedFormerMember() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.RECOGNIZED_FORMER_MEMBER)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }

    public final Double getPlanMaxScreen() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", "selectedPlan", SignupConstants.Field.PLAN_MAX_SCREEN_COUNT, "value"));
        if (!(pathValue instanceof Double)) {
            pathValue = null;
        }
        return (Double) pathValue;
    }

    public final String getOfferId() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804("fields", "selectedPlan", SignupConstants.Field.OFFER_ID, "value"));
        if (!(pathValue instanceof String)) {
            pathValue = null;
        }
        return (String) pathValue;
    }

    public final StringField getTermsOfUseRegion() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.TERMS_OF_USE_REGION) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final StringField getTermsOfUseMinimumVerificationAge() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.TERMS_OF_USE_MINIMUM_VERIFICATION_AGE) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final String getPriceString() {
        return this.priceString;
    }

    public final void setPriceString(String str) {
        this.priceString = str;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public void initActions() {
        super.initActions();
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(this.CHANGE_PLAN_ACTION_ID) : null;
        if (!(field instanceof ActionField)) {
            field = null;
        }
        this.changePlanAction = (ActionField) field;
    }
}
