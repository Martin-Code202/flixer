package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import o.AK;
import org.json.JSONArray;
import org.json.JSONObject;
public class SessionKey {
    public static final String SESSION_CATEGORY = "category";
    public static final String SESSION_ID = "sessionId";
    public static final String SESSION_NAME = "sessionName";
    @SerializedName("sessionCategory")
    @Since(1.0d)
    private String category;
    @SerializedName("sessionId")
    @Since(1.0d)
    private DeviceUniqueId id;
    @SerializedName("sessionName")
    @Since(1.0d)
    private String name;

    public SessionKey() {
    }

    public SessionKey(DeviceUniqueId deviceUniqueId, String str, String str2) {
        this.id = deviceUniqueId;
        this.category = str;
        this.name = str2;
    }

    public DeviceUniqueId getId() {
        return this.id;
    }

    public String getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "SessionKey [id=" + this.id + ", category=" + this.category + ", name=" + this.name + "]";
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.id != null) {
            jSONObject.put("sessionId", "" + this.id.getValue());
        }
        if (this.category != null) {
            jSONObject.put("category", this.category);
        }
        if (this.name != null) {
            jSONObject.put("sessionName", this.name);
        }
        return jSONObject;
    }

    public JSONArray toJSONArray() {
        JSONArray jSONArray = new JSONArray();
        if (this.id != null) {
            jSONArray.put("" + this.id.getValue());
        }
        if (this.category != null) {
            jSONArray.put(this.category);
        }
        if (this.name != null) {
            jSONArray.put(this.name);
        }
        return jSONArray;
    }

    public static SessionKey createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SessionKey sessionKey = new SessionKey();
        long r4 = AK.m3388(jSONObject, "sessionId", -1);
        if (r4 > 0) {
            sessionKey.id = new DeviceUniqueId(r4);
        }
        sessionKey.category = AK.m3376(jSONObject, "category", (String) null);
        sessionKey.name = AK.m3376(jSONObject, "sessionName", (String) null);
        return sessionKey;
    }
}
