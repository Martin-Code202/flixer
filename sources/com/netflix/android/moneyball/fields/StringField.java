package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.C1458Fs;
public final class StringField extends Field implements FieldValidator {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringField(String str, Map<String, Object> map, FlowMode flowMode) {
        super(str, map, flowMode);
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
    }

    public final double getMinLength() {
        if (!getData().containsKey("minLength")) {
            return C1458Fs.f5678.m5026();
        }
        if (!(getData().get("minLength") instanceof Double)) {
            return Double.parseDouble(String.valueOf(getData().get("minLength")));
        }
        Object obj = getData().get("minLength");
        if (obj != null) {
            return ((Double) obj).doubleValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    }

    public final double getMaxLength() {
        if (!getData().containsKey("maxLength")) {
            return C1458Fs.f5678.m5027();
        }
        if (!(getData().get("maxLength") instanceof Double)) {
            return Double.parseDouble(String.valueOf(getData().get("maxLength")));
        }
        Object obj = getData().get("maxLength");
        if (obj != null) {
            return ((Double) obj).doubleValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    }

    public final Boolean localize() {
        boolean z;
        if (!getData().containsKey("localize")) {
            return Boolean.FALSE;
        }
        if (getData().get("localize") instanceof Boolean) {
            Object obj = getData().get("localize");
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
            z = ((Boolean) obj).booleanValue();
        } else {
            Object obj2 = getData().get("localize");
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            z = Boolean.parseBoolean((String) obj2);
        }
        return Boolean.valueOf(z);
    }

    public final Pattern getValidationRegex() {
        if (!getData().containsKey("validationRegex")) {
            return null;
        }
        Object obj = getData().get("validationRegex");
        if (obj != null) {
            return Pattern.compile((String) obj, 2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.netflix.android.moneyball.fields.FieldValidator
    public boolean isValid() {
        boolean containsKey = getData().containsKey("minLength");
        boolean containsKey2 = getData().containsKey("maxLength");
        boolean z = getValidationRegex() != null;
        if (!(getValue() instanceof String)) {
            return false;
        }
        boolean z2 = true;
        if (z) {
            Pattern validationRegex = getValidationRegex();
            if (validationRegex != null) {
                Object value = getValue();
                if (value == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                Matcher matcher = validationRegex.matcher((String) value);
                if (matcher != null) {
                    z2 = matcher.matches();
                }
            }
            z2 = false;
        }
        if (containsKey && ((double) getValue().toString().length()) < getMinLength()) {
            z2 = false;
        }
        if (!containsKey2) {
            return z2;
        }
        Object value2 = getValue();
        if (value2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } else if (((double) ((String) value2).length()) > getMaxLength()) {
            return false;
        } else {
            return z2;
        }
    }
}
