package com.netflix.android.moneyball;

import com.google.gson.Gson;
import java.util.Map;
import o.C1457Fr;
public final class Moneyball {
    public static final Moneyball INSTANCE = new Moneyball();
    private static final Gson gson = new Gson();

    private Moneyball() {
    }

    public final Gson getGson() {
        return gson;
    }

    public final FlowMode parseJsonToFlowMode(String str) {
        C1457Fr.m5025(str, "json");
        Object fromJson = new Gson().fromJson(str, new Moneyball$parseJsonToFlowMode$type$1().getType());
        C1457Fr.m5016(fromJson, "gson.fromJson(json, type)");
        return new FlowMode((Map) fromJson);
    }
}
