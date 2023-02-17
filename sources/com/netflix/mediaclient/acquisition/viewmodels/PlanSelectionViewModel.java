package com.netflix.mediaclient.acquisition.viewmodels;

import android.content.Context;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ChoiceField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.OptionField;
import com.netflix.android.moneyball.fields.StringField;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import o.AbstractC0574;
import o.C0403;
import o.C1457Fr;
import o.EI;
import o.zN;
public final class PlanSelectionViewModel extends AbstractSignupViewModel {
    private final String MODE = SignupConstants.Mode.START_MEMBERSHIP_ON_CONTEXT;
    private final String NEXT_ACTION_ID = SignupConstants.Action.PLAN_SELECTION;
    private String planSelected;
    private Map<String, String> playBillingPrices;

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    public final String getPlanSelected() {
        return this.planSelected;
    }

    public final void setPlanSelected(String str) {
        this.planSelected = str;
    }

    public final List<String> getSkusList() {
        FlowMode flowMode = getFlowMode();
        if (!C1457Fr.m5018((Object) (flowMode != null ? flowMode.getFlowId() : null), (Object) SignupConstants.Flow.SIMPLE_SILVER_SIGN_UP)) {
            return null;
        }
        FlowMode flowMode2 = getFlowMode();
        Field field = flowMode2 != null ? flowMode2.getField(SignupConstants.Field.PLAN_CHOICE) : null;
        if (field == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.ChoiceField");
        }
        List<OptionField> options = ((ChoiceField) field).getOptions();
        if (!(options instanceof List)) {
            options = null;
        }
        if (options == null) {
            return null;
        }
        List<OptionField> list = options;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Field field2 = it.next().getField(SignupConstants.Field.OFFER_ID);
            Object value = field2 != null ? field2.getValue() : null;
            if (value == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) value);
        }
        return arrayList;
    }

    public final ChoiceField getPlanChoice() {
        FlowMode flowMode = getFlowMode();
        Field field = flowMode != null ? flowMode.getField(SignupConstants.Field.PLAN_CHOICE) : null;
        if (!(field instanceof ChoiceField)) {
            field = null;
        }
        return (ChoiceField) field;
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

    public final boolean getPlayStoreFallbackEnabled() {
        Field field;
        FlowMode flowMode = getFlowMode();
        return (flowMode == null || (field = flowMode.getField(SignupConstants.Field.PLAYSTORE_FALLBACK_ENABLED)) == null || !((Boolean) field.getValue()).booleanValue()) ? false : true;
    }

    public final List<Map<Object, Object>> getRowMessages() {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object obj = (flowMode == null || (data = flowMode.getData()) == null) ? null : data.get("fields");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
        }
        Map map = (Map) obj;
        Object obj2 = map != null ? map.get(SignupConstants.Field.PLAN_ROWS) : null;
        if (!(obj2 instanceof List)) {
            obj2 = null;
        }
        return (List) obj2;
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

    public final Map<String, String> getPlayBillingPrices() {
        return this.playBillingPrices;
    }

    public final void setPlayBillingPrices(Map<String, String> map) {
        this.playBillingPrices = map;
    }

    private final List<OptionField> getAllPlanChoices() {
        ChoiceField planChoice = getPlanChoice();
        if (planChoice != null) {
            return planChoice.getOptions();
        }
        return null;
    }

    private final <T extends Field> T getPlanValues(OptionField optionField, String str, Class<T> cls) {
        Field field = optionField.getField(str);
        if (cls.isInstance(field)) {
            return cls.cast(field);
        }
        return null;
    }

    public final String getDefaultSelectedPlan() {
        ChoiceField planChoice = getPlanChoice();
        Object value = planChoice != null ? planChoice.getValue() : null;
        if (!(value instanceof String)) {
            value = null;
        }
        this.planSelected = (String) value;
        return this.planSelected;
    }

    public final String getMoneyballField(Map<Object, ? extends Object> map) {
        C1457Fr.m5025(map, "row");
        Object obj = map.get(SignupConstants.Field.MONEYBALL_FIELD);
        if (obj == null) {
            return null;
        }
        Object obj2 = obj;
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        return (String) obj2;
    }

    public final String getPlanRowHeading(Context context, Map<Object, ? extends Object> map) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(map, "row");
        Object obj = map.get(SignupConstants.Field.MESSAGES);
        if (!(obj instanceof Map)) {
            obj = null;
        }
        Map map2 = (Map) obj;
        Object obj2 = map2 != null ? map2.get(SignupConstants.Field.LABEL) : null;
        if (!(obj2 instanceof Map)) {
            obj2 = null;
        }
        Map<String, String> map3 = (Map) obj2;
        String str = map3 != null ? map3.get("string") : null;
        String stringResource = str != null ? ContextKt.getStringResource(context, str) : null;
        if (getExpectedString(map3) != null) {
            return C0403.m14185(context, R.string.text_price_after).m14186("endDate", zN.f12697.m13522(getFlowMode())).m14188();
        }
        return stringResource;
    }

    private final String getExpectedField(String str) {
        Map<String, Object> data;
        FlowMode flowMode = getFlowMode();
        Object obj = (flowMode == null || (data = flowMode.getData()) == null) ? null : data.get("fields");
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
        }
        Object obj2 = ((Map) obj).get(str);
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        return (String) obj2;
    }

    private final String getExpectedString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        String str = map.get(SignupConstants.Field.EXPECT);
        if (!(str instanceof List)) {
            str = null;
        }
        List list = (List) str;
        if (list == null) {
            return null;
        }
        if (!list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }

    private final Object getPlanValueFromPlanChoiceOptions(OptionField optionField, String str) {
        Field field = optionField.getField(str);
        if (field != null) {
            return field.getValue();
        }
        return null;
    }

    public final List<String> getPlanChoiceHeaderNames() {
        List<OptionField> allPlanChoices = getAllPlanChoices();
        ArrayList arrayList = new ArrayList();
        if (allPlanChoices != null) {
            for (OptionField optionField : allPlanChoices) {
                StringField stringField = (StringField) getPlanValues(optionField, SignupConstants.Field.PLAN_NAME, StringField.class);
                Object value = stringField != null ? stringField.getValue() : null;
                if (value == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                arrayList.add((String) value);
            }
        }
        return arrayList;
    }

    public final List<Object> initPlanValues(String str) {
        ArrayList arrayList = new ArrayList();
        List<OptionField> allPlanChoices = getAllPlanChoices();
        if (allPlanChoices != null) {
            for (OptionField optionField : allPlanChoices) {
                if (str != null) {
                    if (C1457Fr.m5018((Object) str, (Object) SignupConstants.Field.PLAN_PRICE)) {
                        Map<String, String> map = this.playBillingPrices;
                        String str2 = map != null ? map.get(optionField.getValue()) : null;
                        if (str2 != null) {
                            arrayList.add(str2);
                        }
                    } else {
                        Object planValueFromPlanChoiceOptions = getPlanValueFromPlanChoiceOptions(optionField, str);
                        if (planValueFromPlanChoiceOptions != null) {
                            arrayList.add(planValueFromPlanChoiceOptions);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<String> getPlanOfferIds() {
        ArrayList arrayList = new ArrayList();
        List<OptionField> allPlanChoices = getAllPlanChoices();
        if (allPlanChoices != null) {
            for (OptionField optionField : allPlanChoices) {
                StringField stringField = (StringField) getPlanValues(optionField, SignupConstants.Field.OFFER_ID, StringField.class);
                if ((stringField != null ? stringField.getValue() : null) instanceof String) {
                    Object value = stringField.getValue();
                    if (value == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    arrayList.add((String) value);
                }
            }
        }
        return arrayList;
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

    public final String getCtaButtonText() {
        Object obj;
        PlanSelectionViewModel planSelectionViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            planSelectionViewModel = planSelectionViewModel;
            obj = messagesData.get("ctaButton");
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return planSelectionViewModel.getMessagesString((Map) obj);
    }

    public final String getHeaderSubtitleMessage() {
        Object obj;
        PlanSelectionViewModel planSelectionViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            planSelectionViewModel = planSelectionViewModel;
            obj = messagesData.get("headerSubtitleMessage");
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return planSelectionViewModel.getMessagesString((Map) obj);
    }

    public final String getHeaderTitleMessage() {
        Object obj;
        PlanSelectionViewModel planSelectionViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            planSelectionViewModel = planSelectionViewModel;
            obj = messagesData.get("headerTitleMessage");
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return planSelectionViewModel.getMessagesString((Map) obj);
    }

    public final String getTextDisclaimer() {
        Object obj;
        PlanSelectionViewModel planSelectionViewModel = this;
        Map<?, ?> messagesData = getMessagesData();
        if (messagesData != null) {
            planSelectionViewModel = planSelectionViewModel;
            obj = messagesData.get(SignupConstants.Message.TEXT_DISCLAIMER);
        } else {
            obj = null;
        }
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return planSelectionViewModel.getMessagesString((Map) obj);
    }

    private final String getMessagesString(Map<?, ?> map) {
        Object obj = map != null ? map.get("string") : null;
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }

    public final AbstractC0574 getTrackingInfo() {
        return new PlanSelectionViewModel$getTrackingInfo$1(this);
    }
}
