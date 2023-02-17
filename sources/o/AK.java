package o;

import android.util.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AK {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static JSONObject m3380(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.getJSONObject(str);
        }
        return jSONObject2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static JSONArray m3377(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.getJSONArray(str);
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3376(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.getString(str);
        }
        return str2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m3386(JSONObject jSONObject, String str, int i) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.getInt(str);
        }
        return i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Integer m3374(JSONObject jSONObject, String str, Integer num) {
        if (!jSONObject.isNull(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return num;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static long m3388(JSONObject jSONObject, String str, long j) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.getLong(str);
        }
        return j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3381(JSONObject jSONObject, String str, boolean z) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.getBoolean(str);
        }
        return z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static JSONObject m3390(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Name and/or value are null");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static JSONObject m3383(Pair<String, String>[] pairArr) {
        if (pairArr == null) {
            throw new IllegalArgumentException("Name and/or value are null");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Pair<String, String> pair : pairArr) {
                jSONObject.put((String) pair.first, pair.second);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static List<String> m3382(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAsString());
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m3379(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return 0;
        }
        if (!jsonElement.isJsonPrimitive() || !"null".equals(jsonElement.getAsString())) {
            return jsonElement.getAsInt();
        }
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static float m3385(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return 0.0f;
        }
        if (!jsonElement.isJsonPrimitive() || !"null".equals(jsonElement.getAsString())) {
            return jsonElement.getAsFloat();
        }
        return 0.0f;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3375(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3384(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return false;
        }
        return jsonElement.getAsBoolean();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3391(JsonElement jsonElement) {
        return jsonElement == null || jsonElement.isJsonNull();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static JSONObject m3378(JsonObject jsonObject) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            jSONObject.put(entry.getKey(), m3392(entry.getValue()));
        }
        return jSONObject;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static JSONArray m3389(JsonArray jsonArray) {
        JSONArray jSONArray = new JSONArray();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            jSONArray.put(m3392(it.next()));
        }
        return jSONArray;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Object m3387(JsonPrimitive jsonPrimitive) {
        if (jsonPrimitive.isBoolean()) {
            return Boolean.valueOf(jsonPrimitive.getAsBoolean());
        }
        if (jsonPrimitive.isNumber()) {
            return jsonPrimitive.getAsNumber();
        }
        if (jsonPrimitive.isString()) {
            return jsonPrimitive.getAsString();
        }
        return null;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static Object m3392(JsonElement jsonElement) {
        if (jsonElement.isJsonObject()) {
            return m3378(jsonElement.getAsJsonObject());
        }
        if (jsonElement.isJsonArray()) {
            return m3389(jsonElement.getAsJsonArray());
        }
        if (jsonElement.isJsonPrimitive()) {
            return m3387(jsonElement.getAsJsonPrimitive());
        }
        return null;
    }
}
