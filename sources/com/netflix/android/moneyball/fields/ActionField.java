package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import o.C1349Bv;
import o.C1457Fr;
import o.C1461Fv;
import o.EI;
import o.ES;
import o.FQ;
public final class ActionField extends Field {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5037(new MutablePropertyReference1Impl(C1461Fv.m5035(ActionField.class), "withFields", "getWithFields()Ljava/util/List;"))};
    private final Map withFields$delegate;

    private final List<String> getWithFields() {
        return (List) ES.m4853(this.withFields$delegate, $$delegatedProperties[0].getName());
    }

    private final void setWithFields(List<String> list) {
        this.withFields$delegate.put($$delegatedProperties[0].getName(), list);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionField(String str, Map<String, Object> map, FlowMode flowMode) {
        super(str, map, flowMode);
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
        this.withFields$delegate = map;
        Object attrWithDefault = getAttrWithDefault("withFields", "");
        if (attrWithDefault instanceof String) {
            String[] r0 = C1349Bv.m4118((String) attrWithDefault, ",");
            C1457Fr.m5016((Object) r0, "safeSplit(lWithFields, \",\")");
            List<String> r4 = EI.m4804((String[]) Arrays.copyOf(r0, r0.length));
            ArrayList arrayList = new ArrayList(EI.m4812((Iterable) r4, 10));
            for (String str2 : r4) {
                arrayList.add(C1349Bv.m4119(str2));
            }
            setWithFields(arrayList);
        } else if (attrWithDefault == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        } else {
            setWithFields((List) attrWithDefault);
        }
    }

    public final String getMode() {
        Object attrWithDefault = getAttrWithDefault("mode", "");
        if (attrWithDefault != null) {
            return (String) attrWithDefault;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    public final List<Field> getRequiredFields() {
        if (!(!getWithFields().isEmpty())) {
            return EI.m4805();
        }
        List<String> withFields = getWithFields();
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) withFields, 10));
        Iterator<T> it = withFields.iterator();
        while (it.hasNext()) {
            arrayList.add(getFlowMode().getField(it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((Field) obj) != null) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    public final ActionExecutionResult execute() {
        return new ActionExecutionResult(this, getRequiredFields(), null, null, 12, null);
    }
}
