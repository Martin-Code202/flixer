package o;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.service.webclient.model.leafs.AUIContextData;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCodesData;
import com.netflix.mediaclient.service.webclient.model.leafs.TermsOfUseData;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
/* renamed from: o.ﭞ  reason: contains not printable characters */
public final class C1121 {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static MoneyballData m16270(String str) {
        Map<String, Object> r8;
        MoneyballData moneyballData = new MoneyballData();
        Type type = new TypeToken<Map<String, Object>>() { // from class: o.ﭞ.3
        }.getType();
        JsonObject r4 = C0848.m15512("nf_moneyball_data", str);
        if (C0848.m15504(r4)) {
            C1283.m16850("nf_moneyball_data", "Empty response for moneyball request!");
            FalkorException falkorException = new FalkorException("Empty response for moneyball request: " + str);
            C1276.m16820().mo5731(falkorException);
            throw falkorException;
        }
        Map map = (Map) C0848.m15508(r4, "aui", type);
        if (map == null) {
            throw new FalkorException("Couldn't find the aui object in moneyball response: " + str);
        }
        if (map.containsKey("context")) {
            moneyballData.setContextData(m16269((Map) map.get("context")));
        }
        if (map.containsKey("phoneCodes")) {
            moneyballData.setPhoneCodesData(m16267((List) map.get("phoneCodes")));
        }
        if (map.containsKey("termsOfUse")) {
            moneyballData.setTermsOfUseData(m16271((Map) map.get("termsOfUse")));
        }
        if (map.keySet().size() > 0) {
            for (String str2 : map.keySet()) {
                if (!"context".equalsIgnoreCase(str2) && !"phoneCodes".equalsIgnoreCase(str2) && !"termsOfUse".equalsIgnoreCase(str2) && (r8 = m16268((Map) map.get(str2))) != null) {
                    moneyballData.setFlowMode(new FlowMode(r8));
                }
            }
        }
        return moneyballData;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static PhoneCodesData m16267(List<Map<String, String>> list) {
        return new PhoneCodesData(list);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static TermsOfUseData m16271(Map<String, String> map) {
        return new TermsOfUseData(map.get("region"), map.get("showCheckbox"), map.get("minAge"));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static AUIContextData m16269(Map<String, Object> map) {
        String geo_key = AUIContextData.getGEO_KEY();
        String userinfo_key = AUIContextData.getUSERINFO_KEY();
        Map linkedTreeMap = new LinkedTreeMap();
        Map linkedTreeMap2 = new LinkedTreeMap();
        if (map.containsKey(geo_key)) {
            linkedTreeMap = (Map) map.get(geo_key);
        }
        if (map.containsKey(userinfo_key)) {
            linkedTreeMap2 = (Map) map.get(userinfo_key);
        }
        return new AUIContextData(linkedTreeMap, linkedTreeMap2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Map<String, Object> m16268(Map<String, Object> map) {
        if (map.size() == 0) {
            return new LinkedTreeMap();
        }
        if (map.containsKey("result")) {
            return (Map) map.get("result");
        }
        return m16268((Map) map.get(map.keySet().toArray()[0]));
    }
}
