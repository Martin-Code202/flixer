package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import java.util.ArrayList;
import java.util.List;
import o.AK;
import o.C1349Bv;
import org.json.JSONArray;
import org.json.JSONObject;
public class Error {
    public static final String DEEP_ERROR = "deepError";
    public static final String ROOT_CAUSE = "rootCause";
    @SerializedName(DEEP_ERROR)
    @Since(1.0d)
    protected final List<DeepErrorElement> deepError = new ArrayList();
    @SerializedName(ROOT_CAUSE)
    @Since(1.0d)
    protected RootCause rootCause;

    public Error() {
    }

    public Error(JSONObject jSONObject) {
        String r2 = AK.m3376(jSONObject, ROOT_CAUSE, (String) null);
        if (r2 != null) {
            this.rootCause = RootCause.valueOf(r2);
        }
        JSONArray r3 = AK.m3377(jSONObject, DEEP_ERROR);
        if (r3 != null) {
            for (int i = 0; i < r3.length(); i++) {
                this.deepError.add(DeepErrorElement.createInstance(r3.getJSONObject(i)));
            }
        }
    }

    public Error(RootCause rootCause2, List<DeepErrorElement> list) {
        this.rootCause = rootCause2;
        if (list != null) {
            this.deepError.addAll(list);
        }
    }

    public RootCause getRootCause() {
        return this.rootCause;
    }

    public List<DeepErrorElement> getDeepError() {
        return this.deepError;
    }

    public String toString() {
        try {
            return "Error: " + toJSONObject().toString();
        } catch (Throwable th) {
            return "Error [rootCause=" + this.rootCause + "]";
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.rootCause != null) {
            jSONObject.put(ROOT_CAUSE, this.rootCause.name());
        }
        if (this.deepError != null && this.deepError.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (DeepErrorElement deepErrorElement : this.deepError) {
                jSONArray.put(deepErrorElement.toJSONObject());
            }
            jSONObject.put(DEEP_ERROR, jSONArray);
        }
        return jSONObject;
    }

    public static UIError createInstance(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return new UIError(new JSONObject(str));
    }

    public static Error createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new Error(jSONObject);
    }

    public void setRootCause(RootCause rootCause2) {
        this.rootCause = rootCause2;
    }

    public void addDeepErrors(List<DeepErrorElement> list) {
        this.deepError.addAll(list);
    }

    public void addDeepError(DeepErrorElement deepErrorElement) {
        this.deepError.add(deepErrorElement);
    }
}
