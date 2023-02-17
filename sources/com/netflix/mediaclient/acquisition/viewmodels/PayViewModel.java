package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.BooleanField;
import com.netflix.android.moneyball.fields.ChoiceField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.OptionField;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import kotlin.TypeCastException;
import o.AbstractC0574;
public final class PayViewModel extends AbstractSignupViewModel {
    private final String CODE_REDEEM_ACTION_ID = "codeRedeemAction";
    private final String MODE = "payAndStartMembershipWithContext";
    private final String NEXT_ACTION_ID = "nextAction";
    private final String START_MEMBERSHIP_GIFT_MOP_ACTION_ID = "startMembershipWithGiftOnlyAction";

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
        ActionField actionField;
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField("paymentChoice") : null;
        if (field == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.ChoiceField");
        }
        ChoiceField choiceField = (ChoiceField) field;
        OptionField option = choiceField.getOption("giftOption");
        if ((option != null ? option.getField(this.CODE_REDEEM_ACTION_ID) : null) != null) {
            Field field2 = option.getField(this.CODE_REDEEM_ACTION_ID);
            if (!(field2 instanceof ActionField)) {
                field2 = null;
            }
            actionField = (ActionField) field2;
        } else {
            Field field3 = option != null ? option.getField(this.START_MEMBERSHIP_GIFT_MOP_ACTION_ID) : null;
            if (!(field3 instanceof ActionField)) {
                field3 = null;
            }
            actionField = (ActionField) field3;
        }
        setNextAction(actionField);
        FlowMode flowMode2 = getFlowMode();
        Field field4 = flowMode2 != null ? flowMode2.getField(SignupConstants.Field.HAS_ACCEPTED_TERMS_OF_USE) : null;
        if (field4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.BooleanField");
        }
        ((BooleanField) field4).setValue(true);
        choiceField.setOption(option);
    }

    public final StringField getCode() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField("code") : null);
    }

    public final StringField getZipcode() {
        FlowMode flowMode = getFlowMode();
        return (StringField) (flowMode != null ? flowMode.getField("zipcode") : null);
    }

    public final AbstractC0574 getTrackingInfo() {
        return PayViewModel$getTrackingInfo$1.INSTANCE;
    }
}
