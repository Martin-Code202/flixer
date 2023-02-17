package o;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Locale;
/* renamed from: o.ᓹ  reason: contains not printable characters */
public final class C0848 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Date f14682 = new Date(System.currentTimeMillis() + 7776000000L);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static <T> T m15506(JsonObject jsonObject, String str, Class<T> cls) {
        if (!jsonObject.has(str)) {
            return null;
        }
        try {
            return (T) ((Gson) C1281.m16832(Gson.class)).fromJson(jsonObject.get(str), (Class<Object>) cls);
        } catch (IncompatibleClassChangeError e) {
            C1283.m16856("FalkorParseUtils", e, "spy-8880: IncompatibleClassChangeError - gson reflection fail", new Object[0]);
            C1276.m16820().mo5725("spy-8880: IncompatibleClassChangeError - gson reflection fail");
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static <T> T m15508(JsonObject jsonObject, String str, Type type) {
        if (!jsonObject.has(str)) {
            return null;
        }
        try {
            return (T) ((Gson) C1281.m16832(Gson.class)).fromJson(jsonObject.get(str), type);
        } catch (JsonSyntaxException e) {
            C1283.m16856("FalkorParseUtils", e, "spy-8880: JsonSyntaxException - gson reflection fail", new Object[0]);
            C1276.m16820().mo5725("spy-8880: JsonSyntaxException - gson reflection fail");
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m15509(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            return null;
        }
        JsonObject asJsonObject = jsonObject.getAsJsonObject(str);
        if (asJsonObject.has("deviceCommand")) {
            return asJsonObject.get("deviceCommand").getAsString();
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static JsonObject m15512(String str, String str2) {
        try {
            JsonObject asJsonObject = new JsonParser().parse(str2).getAsJsonObject();
            m15511(asJsonObject);
            return asJsonObject.getAsJsonObject("value");
        } catch (Exception e) {
            C1283.m16846(str, "String response to parse = " + str2);
            throw new FalkorException("Error in creating JsonObject", e);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m15511(JsonObject jsonObject) {
        return jsonObject.has(ExceptionClEvent.CATEGORY_VALUE) || jsonObject.has("innerErrors");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m15514(JsonObject jsonObject, String str) {
        if (!m15511(jsonObject)) {
            return null;
        }
        JsonObject asJsonObject = jsonObject.getAsJsonObject(ExceptionClEvent.CATEGORY_VALUE);
        if (asJsonObject.has(DeepErrorElement.Debug.MESSAGE)) {
            return asJsonObject.get(DeepErrorElement.Debug.MESSAGE).toString();
        }
        if (asJsonObject.has("innerErrors")) {
            return asJsonObject.get("innerErrors").toString();
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m15510(String str) {
        return str != null && str.toLowerCase(Locale.US).contains("notvalidrequest");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m15507(String str) {
        return str != null && str.toLowerCase(Locale.US).contains("alreadyinqueue");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m15505(String str) {
        return str != null && str.toLowerCase(Locale.US).contains("notinqueue");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m15504(JsonObject jsonObject) {
        return jsonObject.isJsonNull() || jsonObject.toString().equals("{}");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Object m15513(String str, JsonElement jsonElement, Class<?> cls) {
        try {
            return ((Gson) C1281.m16832(Gson.class)).fromJson(jsonElement, (Class<Object>) cls);
        } catch (IncompatibleClassChangeError e) {
            C1283.m16856("FalkorParseUtils", e, "spy-8880: IncompatibleClassChangeError - gson reflection fail", new Object[0]);
            C1276.m16820().mo5725("spy-8880: IncompatibleClassChangeError - gson reflection fail");
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Date m15503(JsonElement jsonElement) {
        long j;
        if (jsonElement == null || !jsonElement.isJsonObject() || !jsonElement.getAsJsonObject().has("$expires")) {
            return null;
        }
        try {
            j = jsonElement.getAsJsonObject().get("$expires").getAsLong();
        } catch (Exception e) {
            j = 0;
            C1276.m16820().mo5729("Bad $expires :" + jsonElement.toString(), e);
        }
        if (j < 0) {
            return new Date(System.currentTimeMillis() - j);
        }
        if (j == 0) {
            return new Date(System.currentTimeMillis() + 5000);
        }
        if (j == 1) {
            return f14682;
        }
        return new Date(j);
    }
}
