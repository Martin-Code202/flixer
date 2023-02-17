package o;

import android.content.Intent;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
public final class AF {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3326(String str) {
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_install", "Refferer property is empty in intent, just exit");
            return null;
        }
        C1283.m16851("nf_install", "Refferer: %s", str);
        if (!m3325(str)) {
            C1283.m16854("nf_install", "Refferer is URL encoded, decode...");
            str = m3324(str);
        } else {
            C1283.m16854("nf_install", "Refferer was not URL encoded!");
        }
        C1283.m16851("nf_install", "Refferer: %s", str);
        HashMap hashMap = new HashMap();
        String[] split = str.split("&");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                String[] split2 = str2.split("(?<!=)=(?!=)");
                if (split2 != null && split2.length >= 2) {
                    hashMap.put(split2[0], split2[1]);
                    C1283.m16851("nf_install", "Key: %s, value: %s", split2[0], split2[1]);
                }
            }
        }
        if (!hashMap.containsKey("token")) {
            C1283.m16850("nf_install", "Token not found, exit!");
            return null;
        }
        String str3 = (String) hashMap.get("token");
        if (C1349Bv.m4113(str3)) {
            C1283.m16865("nf_install", "Token is empty, exit!");
            return null;
        }
        C1283.m16851("nf_install", "Token: %s, check if it URL encoded or just Base64...", str3);
        if (!C1323Aw.m3802(str3)) {
            return str3;
        }
        C1283.m16854("nf_install", "Token is Base64 string, we need to URL encode it.");
        return m3327(str3);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3323(Intent intent) {
        if (intent.hasExtra("referrer")) {
            return m3326(intent.getStringExtra("referrer"));
        }
        C1283.m16850("nf_install", "Refferer property not found in intent, just exit");
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m3324(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m3327(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m3325(String str) {
        return str.startsWith("token=");
    }
}
