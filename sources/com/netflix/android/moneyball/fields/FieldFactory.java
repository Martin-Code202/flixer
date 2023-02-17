package com.netflix.android.moneyball.fields;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.TypeCastException;
import o.C1349Bv;
import o.C1457Fr;
import o.Ge;
public final class FieldFactory {
    public static final FieldFactory INSTANCE = new FieldFactory();

    private FieldFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v7. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Object */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final Field createField(String str, Map<String, Object> map, FlowMode flowMode, String str2) {
        Class cls;
        C1457Fr.m5025(str, "id");
        C1457Fr.m5025(map, Event.DATA);
        C1457Fr.m5025(flowMode, "flowMode");
        Class cls2 = Field.class;
        if (str2 != null) {
            try {
                Class cls3 = Class.forName(str2);
                C1457Fr.m5016((Object) cls3, "Class.forName(type)");
                cls = cls3;
            } catch (ClassNotFoundException e) {
                cls = Field.class;
            }
            cls2 = cls;
        }
        if (map.containsKey("fieldType")) {
            Object obj = map.get("fieldType");
            if (obj != null) {
                String str3 = (String) obj;
                switch (str3.hashCode()) {
                    case -1808118735:
                        if (str3.equals("String")) {
                            cls2 = StringField.class;
                            break;
                        }
                        cls2 = Field.class;
                        break;
                    case -1206964986:
                        if (str3.equals("localizationKey")) {
                            cls2 = StringField.class;
                            break;
                        }
                        cls2 = Field.class;
                        break;
                    case -335760659:
                        if (str3.equals("Numeric")) {
                            cls2 = NumberField.class;
                            break;
                        }
                        cls2 = Field.class;
                        break;
                    case 1729365000:
                        if (str3.equals("Boolean")) {
                            cls2 = BooleanField.class;
                            break;
                        }
                        cls2 = Field.class;
                        break;
                    case 1955883606:
                        if (str3.equals("Action")) {
                            cls2 = ActionField.class;
                            break;
                        }
                        cls2 = Field.class;
                        break;
                    case 2017610177:
                        if (str3.equals("Choice")) {
                            cls2 = ChoiceField.class;
                            break;
                        }
                        cls2 = Field.class;
                        break;
                    default:
                        cls2 = Field.class;
                        break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (map.containsKey(SignupConstants.Key.PLAN_OPTIONS)) {
            cls2 = ChoiceField.class;
        } else if (map.containsKey("withFields") || map.containsKey("mode")) {
            cls2 = ActionField.class;
        } else if (map.get("value") instanceof Boolean) {
            cls2 = BooleanField.class;
        } else if (map.get("value") instanceof Number) {
            cls2 = NumberField.class;
        } else {
            if (map.get("value") instanceof String) {
                Object obj2 = map.get("value");
                if (obj2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                } else if (C1349Bv.m4103((String) obj2)) {
                    cls2 = NumberField.class;
                }
            }
            if (map.get("value") instanceof String) {
                Object obj3 = map.get("value");
                if (obj3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                String str4 = (String) obj3;
                if (Ge.m5070("true", str4, true) || Ge.m5070("false", str4, true)) {
                    cls2 = BooleanField.class;
                } else {
                    cls2 = StringField.class;
                }
            } else if (map.containsKey("minLength") || map.containsKey("maxLength") || map.containsKey("validationRegex")) {
                cls2 = StringField.class;
            }
        }
        Constructor<?>[] constructors = cls2.getConstructors();
        if (constructors.length != 1) {
            return new Field(str, map, flowMode);
        }
        try {
            Object newInstance = constructors[0].newInstance(str, map, flowMode);
            if (newInstance != null) {
                return (Field) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.Field");
        } catch (Exception e2) {
            return new Field(str, map, flowMode);
        }
    }
}
