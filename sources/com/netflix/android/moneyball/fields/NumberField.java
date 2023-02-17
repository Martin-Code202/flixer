package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Map;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.C1458Fs;
public final class NumberField extends Field implements FieldValidator {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NumberField(String str, Map<String, Object> map, FlowMode flowMode) {
        super(str, map, flowMode);
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
    }

    @Override // com.netflix.android.moneyball.fields.Field
    public Object getValue() {
        if (super.getValue() instanceof String) {
            String obj = super.getValue().toString();
            return obj.length() > 0 ? Double.valueOf(Double.parseDouble(obj)) : obj;
        } else if (!(super.getValue() instanceof Number)) {
            return super.getValue();
        } else {
            Object value = super.getValue();
            if (value != null) {
                return Double.valueOf(((Number) value).doubleValue());
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
        }
    }

    @Override // com.netflix.android.moneyball.fields.Field
    public void setValue(Object obj) {
        C1457Fr.m5025(obj, "newVal");
        Object obj2 = obj;
        if (obj instanceof String) {
            String obj3 = obj.toString();
            obj2 = obj3.length() > 0 ? Double.valueOf(Double.parseDouble(obj3)) : obj3;
        }
        if (obj instanceof Number) {
            obj2 = Double.valueOf(((Number) obj).doubleValue());
        }
        super.setValue(obj2);
    }

    public final double getMinValue() {
        if (!getData().containsKey("minValue")) {
            return C1458Fs.f5678.m5026();
        }
        if (getData().get("minValue") instanceof String) {
            return Double.parseDouble(String.valueOf(getData().get("minValue")));
        }
        Object obj = getData().get("minValue");
        if (obj != null) {
            return ((Number) obj).doubleValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    }

    public final double getMaxValue() {
        if (!getData().containsKey("maxValue")) {
            return C1458Fs.f5678.m5027();
        }
        if (getData().get("maxValue") instanceof String) {
            Object obj = getData().get("maxValue");
            if (obj != null) {
                return Double.parseDouble((String) obj);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj2 = getData().get("maxValue");
        if (obj2 != null) {
            return ((Number) obj2).doubleValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    }

    @Override // com.netflix.android.moneyball.fields.FieldValidator
    public boolean isValid() {
        boolean z = getMinValue() > C1458Fs.f5678.m5026();
        boolean z2 = getMaxValue() < C1458Fs.f5678.m5027();
        if (!(getValue() instanceof Number)) {
            return false;
        }
        boolean z3 = true;
        if (z) {
            Object value = getValue();
            if (value == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
            } else if (((Double) value).doubleValue() < getMinValue()) {
                z3 = false;
            }
        }
        if (!z2) {
            return z3;
        }
        Object value2 = getValue();
        if (value2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
        } else if (((Double) value2).doubleValue() > getMaxValue()) {
            return false;
        } else {
            return z3;
        }
    }
}
