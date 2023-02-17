package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
public final class ObtainConsentViewModel extends AbstractSignupViewModel {
    private final String MODE = SignupConstants.Mode.OBTAIN_CONSENT;
    private final String NEXT_ACTION_ID = "nextAction";

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    public final BooleanField getHasAcceptedTermsOfUse() {
        FlowMode flowMode = getFlowMode();
        return (BooleanField) (flowMode != null ? flowMode.getField(SignupConstants.Field.HAS_ACCEPTED_TERMS_OF_USE) : null);
    }

    public final BooleanField getThirdPartyConsent() {
        FlowMode flowMode = getFlowMode();
        return (BooleanField) (flowMode != null ? flowMode.getField(SignupConstants.Field.THIRD_PARTY_CONSENT) : null);
    }

    public final BooleanField getInformationAbroadConsent() {
        FlowMode flowMode = getFlowMode();
        return (BooleanField) (flowMode != null ? flowMode.getField(SignupConstants.Field.INFORMATION_ABROAD_CONSENT) : null);
    }

    public final BooleanField getEmailConsent() {
        FlowMode flowMode = getFlowMode();
        return (BooleanField) (flowMode != null ? flowMode.getField(SignupConstants.Field.EMAIL_CONSENT) : null);
    }

    public final StringField getTermsOfUseMinimumVerificationAge() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.TERMS_OF_USE_MINIMUM_VERIFICATION_AGE) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }
}
