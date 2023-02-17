package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Iterator;
import o.C1349Bv;
import org.json.JSONObject;
public class ABTestConfigData extends HashMap<String, ABTestConfig> {
    private static final String TAG = "nf_config";
    static Gson gson = new GsonBuilder().create();

    public ABTestConfigData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            ABTestConfig aBTestConfig = (ABTestConfig) gson.fromJson(jSONObject.optString(next), (Class<Object>) ABTestConfig.class);
            if (aBTestConfig != null) {
                put(next, aBTestConfig);
            }
        }
    }

    public ABTestConfig getConfigForId(String str) {
        return (ABTestConfig) get(str);
    }

    public static ABTestConfigData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return new ABTestConfigData(str);
    }

    public String toJsonString() {
        return gson.toJson(this);
    }
}
