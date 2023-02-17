package com.netflix.android.moneyball;

import com.netflix.android.moneyball.fields.ChoiceField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.FieldFactory;
import com.netflix.android.moneyball.fields.OptionField;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TypeCastException;
import o.C1438Ey;
import o.C1457Fr;
import o.C1462Fw;
import o.EI;
import o.ES;
import o.FF;
public interface GetField {
    OptionField findOptionField(String str, ChoiceField choiceField);

    Field getField(String str);

    <T> T getFieldValue(String str);

    Map<String, Field> getFields();

    void initFields(Map<String, ? extends Object> map, FlowMode flowMode);

    void setFields(Map<String, ? extends Field> map);

    public static final class DefaultImpls {
        public static OptionField findOptionField(GetField getField, String str, ChoiceField choiceField) {
            T t;
            boolean z;
            C1457Fr.m5025(str, "id");
            C1457Fr.m5025(choiceField, "choice");
            Iterator<T> it = choiceField.getOptions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (next.getField(str) != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            return t;
        }

        public static <T> T getFieldValue(GetField getField, String str) {
            C1457Fr.m5025(str, "id");
            Field field = getField.getField(str);
            T t = field != null ? (T) field.getValue() : null;
            if (!(t instanceof Object)) {
                return null;
            }
            return t;
        }

        public static Field getField(GetField getField, String str) {
            Object obj;
            boolean z;
            C1457Fr.m5025(str, "id");
            if (getField.getFields().isEmpty()) {
                return null;
            }
            Field field = getField.getFields().get(str);
            if (field != null) {
                return field;
            }
            Map<String, Field> fields = getField.getFields();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Field> entry : fields.entrySet()) {
                if (entry.getValue() instanceof ChoiceField) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = ES.m4858(linkedHashMap).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                Field field2 = (Field) ((Pair) next).m3222();
                if (field2 != null) {
                    if (getField.findOptionField(str, (ChoiceField) field2) != null) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        obj = next;
                        break;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.ChoiceField");
                }
            }
            Pair pair = (Pair) obj;
            if (pair == null) {
                return field;
            }
            Object r0 = pair.m3223();
            if (r0 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.ChoiceField");
            }
            OptionField findOptionField = getField.findOptionField(str, (ChoiceField) r0);
            if (findOptionField != null) {
                return findOptionField.getField(str);
            }
            return null;
        }

        public static void initFields(GetField getField, Map<String, ? extends Object> map, FlowMode flowMode) {
            C1457Fr.m5025(map, "dataFields");
            C1457Fr.m5025(flowMode, "flowMode");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof Map) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Set<Map.Entry> entrySet = linkedHashMap.entrySet();
            Map<String, ? extends Field> linkedHashMap2 = new LinkedHashMap<>(FF.m4987(ES.m4860(EI.m4812(entrySet, 10)), 16));
            for (Map.Entry entry2 : entrySet) {
                Object key = entry2.getKey();
                FieldFactory fieldFactory = FieldFactory.INSTANCE;
                String str = (String) entry2.getKey();
                Object value = entry2.getValue();
                if (value == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                }
                Pair r15 = C1438Ey.m4973(key, fieldFactory.createField(str, C1462Fw.m5041(value), flowMode, null));
                linkedHashMap2.put(r15.m3221(), r15.m3223());
            }
            getField.setFields(linkedHashMap2);
        }
    }
}
