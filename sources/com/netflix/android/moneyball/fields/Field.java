package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.DataBacked;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Map;
import kotlin.TypeCastException;
import o.C1457Fr;
public class Field implements DataBacked {
    private final Map<String, Object> data;
    private final FlowMode flowMode;
    private final String id;

    public Field(String str, Map<String, Object> map, FlowMode flowMode2) {
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode2, "flowMode");
        this.id = str;
        this.data = map;
        this.flowMode = flowMode2;
    }

    @Override // com.netflix.android.moneyball.fields.DataBacked
    public Object getAttr(String str) {
        C1457Fr.m5025(str, "key");
        return DataBacked.DefaultImpls.getAttr(this, str);
    }

    @Override // com.netflix.android.moneyball.fields.DataBacked
    public Object getAttrWithDefault(String str, Object obj) {
        C1457Fr.m5025(str, "key");
        C1457Fr.m5025(obj, "default");
        return DataBacked.DefaultImpls.getAttrWithDefault(this, str, obj);
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.netflix.android.moneyball.fields.DataBacked
    public Map<String, Object> getData() {
        return this.data;
    }

    public FlowMode getFlowMode() {
        return this.flowMode;
    }

    public Object getValue() {
        return getAttrWithDefault("value", "");
    }

    public void setValue(Object obj) {
        C1457Fr.m5025(obj, "value");
        getData().put("value", obj);
    }

    public final boolean isHidden() {
        Object attrWithDefault = getAttrWithDefault("hidden", false);
        if (attrWithDefault instanceof String) {
            return Boolean.parseBoolean((String) attrWithDefault);
        }
        if (attrWithDefault != null) {
            return ((Boolean) attrWithDefault).booleanValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
