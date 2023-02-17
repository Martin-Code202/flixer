package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.ChoiceField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.NumberField;
import com.netflix.android.moneyball.fields.OptionField;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.util.crypto.NetflixPublicKey;
import com.netflix.mediaclient.acquisition.util.crypto.SecureMOP;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.List;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.Ge;
public final class CreditOptionPayViewModel extends AbstractSignupViewModel {
    private final String MODE = SignupConstants.Mode.CREDIT_OPTION;
    private final String NEXT_ACTION_ID = "nextAction";
    private String creditExpirationDate = "";

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public void initActions() {
        ChoiceField paymentChoice = getPaymentChoice();
        OptionField option = paymentChoice != null ? paymentChoice.getOption("creditOption") : null;
        if (option == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.OptionField");
        }
        BooleanField hasAcceptedTermsOfUse = getHasAcceptedTermsOfUse();
        if (hasAcceptedTermsOfUse != null) {
            hasAcceptedTermsOfUse.setValue(true);
        }
        ChoiceField paymentChoice2 = getPaymentChoice();
        if (paymentChoice2 != null) {
            paymentChoice2.setOption(option);
        }
        Field field = option.getField("nextAction");
        if (field == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.ActionField");
        }
        setNextAction((ActionField) field);
    }

    public final StringField getCreditData() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField("creditData") : null);
    }

    public final StringField getCreditCardNumber() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField("creditCardNumber") : null);
    }

    public final StringField getCreditZipcode() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField("creditZipcode") : null);
    }

    public final StringField getCreditCardSecurityCode() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField("creditCardSecurityCode") : null);
    }

    public final String getCreditExpirationDate() {
        return this.creditExpirationDate;
    }

    public final void setCreditExpirationDate(String str) {
        C1457Fr.m5025(str, "value");
        List r6 = Ge.m5087((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
        if (r6.size() == 2) {
            if (((CharSequence) r6.get(0)).length() > 0) {
                if (((CharSequence) r6.get(1)).length() > 0) {
                    NumberField creditExpirationMonth = getCreditExpirationMonth();
                    if (creditExpirationMonth != null) {
                        creditExpirationMonth.setValue(Integer.valueOf(Integer.parseInt((String) r6.get(0))));
                    }
                    NumberField creditExpirationYear = getCreditExpirationYear();
                    if (creditExpirationYear != null) {
                        creditExpirationYear.setValue(Integer.valueOf(Integer.parseInt((String) r6.get(1)) + 2000));
                    }
                }
            }
        }
    }

    public final NumberField getCreditExpirationMonth() {
        FlowMode flowMode = getFlowMode();
        return (NumberField) (flowMode != null ? flowMode.getField("creditExpirationMonth") : null);
    }

    public final NumberField getCreditExpirationYear() {
        FlowMode flowMode = getFlowMode();
        return (NumberField) (flowMode != null ? flowMode.getField("creditExpirationYear") : null);
    }

    public final StringField getPlanChoice() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.PLAN_CHOICE) : null);
    }

    public final StringField getFirstName() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.FIRST_NAME) : null);
    }

    public final StringField getLastName() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField(SignupConstants.Field.LAST_NAME) : null);
    }

    public final BooleanField getHasAcceptedTermsOfUse() {
        FlowMode flowMode = getFlowMode();
        return (BooleanField) (flowMode != null ? flowMode.getField(SignupConstants.Field.HAS_ACCEPTED_TERMS_OF_USE) : null);
    }

    public final ChoiceField getPaymentChoice() {
        FlowMode flowMode = getFlowMode();
        return (ChoiceField) (flowMode != null ? flowMode.getField("paymentChoice") : null);
    }

    public final String toEncryptedString(NetflixPublicKey netflixPublicKey) {
        C1457Fr.m5025(netflixPublicKey, "publicKey");
        StringField creditCardNumber = getCreditCardNumber();
        if (creditCardNumber != null && !creditCardNumber.isValid()) {
            return "";
        }
        StringField creditZipcode = getCreditZipcode();
        if (creditZipcode != null && !creditZipcode.isValid()) {
            return "";
        }
        StringField creditCardSecurityCode = getCreditCardSecurityCode();
        if (creditCardSecurityCode != null && !creditCardSecurityCode.isValid()) {
            return "";
        }
        NumberField creditExpirationMonth = getCreditExpirationMonth();
        if (creditExpirationMonth != null && !creditExpirationMonth.isValid()) {
            return "";
        }
        NumberField creditExpirationYear = getCreditExpirationYear();
        if (creditExpirationYear != null && !creditExpirationYear.isValid()) {
            return "";
        }
        StringField creditCardNumber2 = getCreditCardNumber();
        Object value = creditCardNumber2 != null ? creditCardNumber2.getValue() : null;
        StringField creditZipcode2 = getCreditZipcode();
        Object value2 = creditZipcode2 != null ? creditZipcode2.getValue() : null;
        StringField creditCardSecurityCode2 = getCreditCardSecurityCode();
        Object value3 = creditCardSecurityCode2 != null ? creditCardSecurityCode2.getValue() : null;
        NumberField creditExpirationMonth2 = getCreditExpirationMonth();
        Object value4 = creditExpirationMonth2 != null ? creditExpirationMonth2.getValue() : null;
        if (value4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
        }
        double doubleValue = ((Double) value4).doubleValue();
        NumberField creditExpirationYear2 = getCreditExpirationYear();
        Object value5 = creditExpirationYear2 != null ? creditExpirationYear2.getValue() : null;
        if (value5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
        }
        return SecureMOP.INSTANCE.encrypt(netflixPublicKey, "{\"cc\":{\"num\":\"" + value + "\",\"zip\": \"" + value2 + "\",\"cvv\":\"" + value3 + "\",\"expMon\":\"" + String.valueOf(Math.round(doubleValue)) + "\",\"expYr\":\"" + String.valueOf(Math.round(((Double) value5).doubleValue())) + "\"}}");
    }
}
