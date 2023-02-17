package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.EI;
public final class ChoiceField extends Field {
    private String _value = "";
    private OptionField option;
    private List<OptionField> options = EI.m4805();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChoiceField(String str, Map<String, Object> map, FlowMode flowMode) {
        super(str, map, flowMode);
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
        Object attrWithDefault = getAttrWithDefault("value", "");
        if (attrWithDefault == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        this._value = (String) attrWithDefault;
        Object attr = getAttr(SignupConstants.Key.PLAN_OPTIONS);
        if (attr instanceof List) {
            initOptions((List) attr);
        }
    }

    public final List<OptionField> getOptions() {
        return this.options;
    }

    public final void setOptions(List<OptionField> list) {
        C1457Fr.m5025(list, "<set-?>");
        this.options = list;
    }

    public final OptionField getOption() {
        return this.option;
    }

    public final void setOption(OptionField optionField) {
        Object value = optionField != null ? optionField.getValue() : null;
        if (!(value instanceof String)) {
            value = null;
        }
        this._value = (String) value;
        this.option = optionField;
    }

    public final int getIndex() {
        if (this.option == null) {
            return 0;
        }
        List<OptionField> list = this.options;
        OptionField optionField = this.option;
        if (optionField != null) {
            return list.indexOf(optionField);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.OptionField");
    }

    public final void initOptions(List<? extends Map<String, Object>> list) {
        C1457Fr.m5025(list, "opts");
        List<? extends Map<String, Object>> list2 = list;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            OptionField optionField = new OptionField(getId(), it.next(), getFlowMode());
            if (C1457Fr.m5018(optionField.getValue(), (Object) this._value)) {
                setOption(optionField);
            }
            arrayList.add(optionField);
        }
        this.options = arrayList;
    }

    @Override // com.netflix.android.moneyball.fields.Field
    public Object getValue() {
        OptionField optionField = this.option;
        if ((optionField != null ? optionField.getValue() : null) == null) {
            String str = this._value;
            return str != null ? str : "";
        }
        OptionField optionField2 = this.option;
        Object value = optionField2 != null ? optionField2.getValue() : null;
        if (value != null) {
            return (String) value;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.netflix.android.moneyball.fields.Field
    public void setValue(Object obj) {
        T t;
        T t2;
        C1457Fr.m5025(obj, "newVal");
        List<OptionField> list = this.options;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                T next = it.next();
                if (C1457Fr.m5018(next.getValue(), obj)) {
                    t2 = next;
                    break;
                }
            }
            t = t2;
        } else {
            t = null;
        }
        if (t != null) {
            setOption(t);
            this._value = (String) obj;
        }
    }

    public final OptionField getOption(String str) {
        T t;
        C1457Fr.m5025(str, "value");
        Iterator<T> it = this.options.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (C1457Fr.m5018(next.getValue(), (Object) str)) {
                t = next;
                break;
            }
        }
        return t;
    }
}
