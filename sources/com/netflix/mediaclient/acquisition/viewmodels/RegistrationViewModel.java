package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.Map;
public final class RegistrationViewModel extends AbstractSignupViewModel {
    private final String MODE = "registrationWithContext";
    private final String NEXT_ACTION_ID = "registerOnlyAction";
    private boolean allFieldsValidated;
    private boolean showEmailState;
    private boolean showPasswordState;

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
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.EMAIL) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final StringField getPassword() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.PASSWORD) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final StringField getEmailConsentLabelId() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.EMAIL_CONSENT_LABEL_ID) : null;
        if (!(field instanceof StringField)) {
            field = null;
        }
        return (StringField) field;
    }

    public final BooleanField getEmailPreference() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.EMAIL_PREFERENCE) : null;
        if (!(field instanceof BooleanField)) {
            field = null;
        }
        return (BooleanField) field;
    }

    public final BooleanField getHasAcceptedTermsOfUse() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.HAS_ACCEPTED_TERMS_OF_USE) : null;
        if (!(field instanceof BooleanField)) {
            field = null;
        }
        return (BooleanField) field;
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

    public final boolean getAllFieldsValidated() {
        return this.allFieldsValidated;
    }

    public final void setAllFieldsValidated(boolean z) {
        this.allFieldsValidated = z;
    }

    public final boolean getShowEmailState() {
        return this.showEmailState;
    }

    public final void setShowEmailState(boolean z) {
        this.showEmailState = z;
    }

    public final boolean getShowPasswordState() {
        return this.showPasswordState;
    }

    public final void setShowPasswordState(boolean z) {
        this.showPasswordState = z;
    }

    public final Map<?, ?> getMessagesData() {
        Map<String, Field> fields;
        Field field;
        FlowMode flowMode = getFlowMode();
        if (flowMode == null || (fields = flowMode.getFields()) == null || (field = fields.get(SignupConstants.Field.MESSAGES)) == null) {
            return null;
        }
        return field.getData();
    }

    public final String getCtaButton() {
        Object obj;
        RegistrationViewModel registrationViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            registrationViewModel = registrationViewModel;
            obj = messagesData.get("ctaButton");
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return registrationViewModel.getMessagesString((Map) obj);
    }

    public final String getRegistrationFormSubtitle() {
        Object obj;
        RegistrationViewModel registrationViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            registrationViewModel = registrationViewModel;
            obj = messagesData.get(SignupConstants.Message.REG_SUBTITLE);
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return registrationViewModel.getMessagesString((Map) obj);
    }

    public final String getRegistrationFormTitle() {
        Object obj;
        RegistrationViewModel registrationViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            registrationViewModel = registrationViewModel;
            obj = messagesData.get(SignupConstants.Message.REG_TITLE);
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return registrationViewModel.getMessagesString((Map) obj);
    }

    public final String getValuePropMessage() {
        Object obj;
        RegistrationViewModel registrationViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            registrationViewModel = registrationViewModel;
            obj = messagesData.get(SignupConstants.Message.VALUE_PROP_MESSAGE);
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return registrationViewModel.getMessagesString((Map) obj);
    }

    public final String getValuePropMessageSecondary() {
        Object obj;
        RegistrationViewModel registrationViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            registrationViewModel = registrationViewModel;
            obj = messagesData.get(SignupConstants.Message.VALUE_PROP_MESSAGE_SECONDARY);
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return registrationViewModel.getMessagesString((Map) obj);
    }

    private final String getMessagesString(Map<?, ?> map) {
        Object obj = map != null ? map.get("string") : null;
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }
}
