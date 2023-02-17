package com.netflix.android.moneyball.fields;

import java.util.Map;
import o.C1457Fr;
public interface DataBacked {
    Object getAttr(String str);

    Object getAttrWithDefault(String str, Object obj);

    Map<String, Object> getData();

    public static final class DefaultImpls {
        public static Object getAttr(DataBacked dataBacked, String str) {
            C1457Fr.m5025(str, "key");
            if (dataBacked.getData().containsKey(str)) {
                return dataBacked.getData().get(str);
            }
            return null;
        }

        public static Object getAttrWithDefault(DataBacked dataBacked, String str, Object obj) {
            C1457Fr.m5025(str, "key");
            C1457Fr.m5025(obj, "default");
            if (!dataBacked.getData().containsKey(str)) {
                return obj;
            }
            Object obj2 = dataBacked.getData().get(str);
            return obj2 != null ? obj2 : obj;
        }
    }
}
