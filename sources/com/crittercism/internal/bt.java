package com.crittercism.internal;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
public final class bt {
    public final URL a;
    public final String b;
    public final byte[] c;
    final Map<String, String> d;

    public bt(String str, URL url, byte[] bArr, Map<String, String> map) {
        this.b = str;
        this.a = url;
        this.c = bArr;
        this.d = new HashMap(map);
    }

    public static Map<String, String> a(au auVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("CRAppId", auVar.e);
        hashMap.put("CRVersion", "5.8.7");
        hashMap.put("CRPlatform", "android");
        hashMap.put("CRDevelopmentPlatform", auVar.h);
        hashMap.put("CRDeviceId", auVar.h());
        return hashMap;
    }

    public static bt a(URL url, JSONObject jSONObject, Map<String, String> map) {
        map.put("Content-type", "application/json");
        return new bt("POST", url, jSONObject.toString().getBytes("UTF8"), map);
    }
}
