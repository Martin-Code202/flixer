package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import o.AK;
import o.C1349Bv;
import org.json.JSONException;
import org.json.JSONObject;
public abstract class SessionEvent extends Event {
    public static final String CATEGORY_VALUE = "uiQOE";
    public static final String SESSION_ID = "sessionId";
    public static final String SESSION_NAME = "sessionName";
    @SerializedName("sessionId")
    @Since(1.0d)
    protected DeviceUniqueId sessionId;
    @SerializedName("sessionName")
    @Since(1.0d)
    protected transient String sessionName;

    public SessionEvent(String str) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Session name can not be null!");
        }
        this.category = CATEGORY_VALUE;
        this.sessionName = str;
    }

    public SessionEvent(JSONObject jSONObject) {
        super(jSONObject);
        this.sessionId = new DeviceUniqueId(AK.m3388(jSONObject, "sessionId", 0));
        this.sessionName = AK.m3376(jSONObject, "sessionName", (String) null);
    }

    public DeviceUniqueId getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(DeviceUniqueId deviceUniqueId) {
        this.sessionId = deviceUniqueId;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.sessionName != null) {
            jSONObject.put("sessionName", this.sessionName);
        }
        if (this.sessionId != null) {
            jSONObject.put("sessionId", this.sessionId.getValue());
        }
        return jSONObject;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public String toString() {
        JSONObject jSONObject = null;
        try {
            jSONObject = getCustomData();
        } catch (JSONException e) {
        }
        return "SessionEvent [sessionName=" + this.sessionName + ", sessionId=" + this.sessionId + ", type=" + this.type + ", category=" + this.category + ", name=" + this.name + ", activeSessions=" + this.activeSessions + ", time=" + this.time + ", sequence=" + this.sequence + ", uptime=" + this.uptime + ", modalView=" + this.modalView + ", dataContext=" + this.dataContext + ", kids=" + this.kids + ", getCustomData()=" + jSONObject + "]";
    }
}
