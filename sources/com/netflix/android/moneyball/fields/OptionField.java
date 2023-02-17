package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.GetField;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Map;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.ES;
public final class OptionField extends Field implements GetField {
    private Map<String, ? extends Field> fields = ES.m4861();

    @Override // com.netflix.android.moneyball.GetField
    public OptionField findOptionField(String str, ChoiceField choiceField) {
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(choiceField, "choice");
        return GetField.DefaultImpls.findOptionField(this, str, choiceField);
    }

    @Override // com.netflix.android.moneyball.GetField
    public Field getField(String str) {
        C1457Fr.m5025(str, "id");
        return GetField.DefaultImpls.getField(this, str);
    }

    @Override // com.netflix.android.moneyball.GetField
    public <T> T getFieldValue(String str) {
        C1457Fr.m5025(str, "id");
        return (T) GetField.DefaultImpls.getFieldValue(this, str);
    }

    @Override // com.netflix.android.moneyball.GetField
    public void initFields(Map<String, ? extends Object> map, FlowMode flowMode) {
        C1457Fr.m5025(map, "dataFields");
        C1457Fr.m5025(flowMode, "flowMode");
        GetField.DefaultImpls.initFields(this, map, flowMode);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends com.netflix.android.moneyball.fields.Field>, java.util.Map<java.lang.String, com.netflix.android.moneyball.fields.Field> */
    @Override // com.netflix.android.moneyball.GetField
    public Map<String, Field> getFields() {
        return this.fields;
    }

    @Override // com.netflix.android.moneyball.GetField
    public void setFields(Map<String, ? extends Field> map) {
        C1457Fr.m5025(map, "<set-?>");
        this.fields = map;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OptionField(String str, Map<String, Object> map, FlowMode flowMode) {
        super(str, map, flowMode);
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
        Object attrWithDefault = getAttrWithDefault("fields", ES.m4861());
        if (attrWithDefault == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
        initFields((Map) attrWithDefault, flowMode);
    }
}
