package com.netflix.mediaclient.acquisition.util;

import com.netflix.cl.Logger;
import java.util.Map;
import o.C0729;
import o.C1438Ey;
import o.C1457Fr;
import o.ES;
import org.json.JSONObject;
public final class AUILoggingUtilities {
    public static final AUILoggingUtilities INSTANCE = new AUILoggingUtilities();

    private AUILoggingUtilities() {
    }

    public final void logDebugEvent(String str, Map<String, String> map) {
        C1457Fr.m5025(str, "eventName");
        C1457Fr.m5025(map, "eventData");
        Logger.INSTANCE.m131(new C0729(new JSONObject(ES.m4862(C1438Ey.m4973("eventName", str), C1438Ey.m4973("eventData", new JSONObject(map))))));
    }
}
