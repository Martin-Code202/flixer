package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AK;
import o.AbstractC0852;
import o.C1283;
import o.C1349Bv;
import org.json.JSONException;
import org.json.JSONObject;
public class OnRampEligibility implements AbstractC0852 {
    private static final String FIELD_IS_ELIGIBLE = "onrampEligibilty";
    private static final String FIELD_STATUS_CODE = "statusCode";
    private static final String STATUS_CODE_SUCCESS = "success";
    private static final String TAG = "OnRampEligibility";
    boolean onRampEligibility;
    String statusCode;

    public enum Action {
        FETCH,
        RECORD,
        UNKNOWN;

        public static Action fromString(String str) {
            try {
                return valueOf(str.toUpperCase());
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public boolean isEligible() {
        return this.onRampEligibility && "success".equals(this.statusCode);
    }

    public OnRampEligibility(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FIELD_IS_ELIGIBLE, this.onRampEligibility);
            jSONObject.put(FIELD_STATUS_CODE, this.statusCode);
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed in json string " + e);
        }
        C1283.m16854(TAG, "user string=" + jSONObject.toString());
        return jSONObject.toString();
    }

    public OnRampEligibility(String str) {
        try {
            JSONObject jSONObject = C1349Bv.m4113(str) ? new JSONObject() : new JSONObject(str);
            this.onRampEligibility = AK.m3381(jSONObject, FIELD_IS_ELIGIBLE, false);
            this.statusCode = AK.m3376(jSONObject, FIELD_STATUS_CODE, (String) null);
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed to create json string=" + str + " exception =" + e);
        }
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        if (jsonElement != null) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -888372969:
                        if (key.equals(FIELD_IS_ELIGIBLE)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 247507199:
                        if (key.equals(FIELD_STATUS_CODE)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.statusCode = value.getAsString();
                        break;
                    case 1:
                        this.onRampEligibility = value.getAsBoolean();
                        break;
                }
            }
        }
    }
}
