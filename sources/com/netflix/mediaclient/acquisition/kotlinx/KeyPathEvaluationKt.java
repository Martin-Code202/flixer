package com.netflix.mediaclient.acquisition.kotlinx;

import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import java.util.List;
import java.util.Map;
import o.C1457Fr;
import o.EI;
public final class KeyPathEvaluationKt {
    public static final Object getPathValue(Object obj, List<String> list) {
        C1457Fr.m5025(obj, "$receiver");
        C1457Fr.m5025(list, FalkorPathResult.PATH);
        if (list.isEmpty()) {
            return obj;
        }
        if (obj instanceof Map) {
            return getPathValue((Map<Object, ? extends Object>) ((Map) obj), list);
        }
        if (obj instanceof List) {
            return getPathValue((List<? extends Object>) ((List) obj), list);
        }
        return null;
    }

    public static final Object getPathValue(Map<Object, ? extends Object> map, List<String> list) {
        C1457Fr.m5025(map, "$receiver");
        C1457Fr.m5025(list, FalkorPathResult.PATH);
        if (list.isEmpty()) {
            return map;
        }
        Object obj = map.get(list.get(0));
        if (obj != null) {
            return getPathValue(obj, EI.m4822((Iterable) list, 1));
        }
        return null;
    }

    public static final Object getPathValue(List<? extends Object> list, List<String> list2) {
        C1457Fr.m5025(list, "$receiver");
        C1457Fr.m5025(list2, FalkorPathResult.PATH);
        if (list2.isEmpty()) {
            return list;
        }
        try {
            Object r0 = EI.m4834(list, Integer.parseInt(list2.get(0)));
            if (r0 != null) {
                return getPathValue(r0, EI.m4822((Iterable) list2, 1));
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
