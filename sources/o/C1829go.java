package o;

import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.go  reason: case insensitive filesystem */
public class C1829go {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static JSONObject m6692(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String[] split = str.split("\r\n");
        for (String str2 : split) {
            String[] split2 = str2.split("=", 2);
            if (split2.length != 2 || !C1349Bv.m4107(split2[0])) {
                C1283.m16855("MdxTargetMessage", "ignore %s", str2);
            } else if (!m6690(split2[0], split2[1], jSONObject2)) {
                jSONObject.putOpt(split2[0], split2[1]);
            }
        }
        if (jSONObject2.length() > 0) {
            jSONObject.put("appBody", jSONObject2);
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m6690(String str, String str2, JSONObject jSONObject) {
        if (!str.startsWith("appBody.")) {
            return false;
        }
        String replace = str.replace("appBody.", "");
        String[] split = replace.split("\\.");
        if (split.length > 3 || split.length == 0) {
            C1283.m16855("MdxTargetMessage", "can not parse %s", str);
            return false;
        } else if (split.length == 1) {
            jSONObject.put(replace, str2);
            return true;
        } else if (split.length == 2) {
            String[] r6 = m6691(split[0]);
            if (r6 == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject(split[0]);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put(split[0], optJSONObject);
                }
                optJSONObject.put(split[1], str2);
                return true;
            }
            String str3 = r6[0];
            int intValue = Integer.valueOf(r6[1]).intValue();
            JSONArray optJSONArray = jSONObject.optJSONArray(str3);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put(str3, optJSONArray);
            }
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(intValue);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            optJSONObject2.put(split[1], str2);
            optJSONArray.put(intValue, optJSONObject2);
            return true;
        } else {
            JSONObject optJSONObject3 = jSONObject.optJSONObject(split[0]);
            if (optJSONObject3 == null) {
                optJSONObject3 = new JSONObject();
                jSONObject.put(split[0], optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject(split[1]);
            if (optJSONObject4 == null) {
                optJSONObject4 = new JSONObject();
                optJSONObject3.put(split[1], optJSONObject4);
            }
            optJSONObject4.put(split[2], str2);
            return true;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String[] m6691(String str) {
        if (!str.contains("[") || !str.endsWith("]")) {
            return null;
        }
        return str.replace("[", ".").replace("]", ".").split("\\.");
    }
}
