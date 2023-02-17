package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Map;
import o.C1457Fr;
import o.Ge;
public final class BooleanField extends Field {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BooleanField(String str, Map<String, Object> map, FlowMode flowMode) {
        super(str, map, flowMode);
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
    }

    @Override // com.netflix.android.moneyball.fields.Field
    public Object getValue() {
        Object value = super.getValue();
        if ((value instanceof String) && Ge.m5070("true", (String) value, true)) {
            return true;
        }
        if (value instanceof Boolean) {
            return value;
        }
        return false;
    }

    @Override // com.netflix.android.moneyball.fields.Field
    public void setValue(Object obj) {
        C1457Fr.m5025(obj, "newVal");
        if ((obj instanceof String) && Ge.m5070("true", (String) obj, true)) {
            Boolean bool = Boolean.TRUE;
            C1457Fr.m5016((Object) bool, "java.lang.Boolean.TRUE");
            super.setValue(bool);
        } else if (obj instanceof Boolean) {
            super.setValue(obj);
        } else {
            Boolean bool2 = Boolean.FALSE;
            C1457Fr.m5016((Object) bool2, "java.lang.Boolean.FALSE");
            super.setValue(bool2);
        }
    }
}
