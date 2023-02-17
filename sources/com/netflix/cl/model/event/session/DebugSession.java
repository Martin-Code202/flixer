package com.netflix.cl.model.event.session;

import com.netflix.mediaclient.service.logging.client.model.Event;
import o.AbstractC1274;
import org.json.JSONException;
import org.json.JSONObject;
public final class DebugSession extends AbstractC1274 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final JSONObject f521;

    public enum DebugSessionType {
        Performance("performance"),
        AppRestartError("appRestartError");
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f525;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m150() {
            return this.f525;
        }

        private DebugSessionType(String str) {
            this.f525 = str;
        }
    }

    public DebugSession(JSONObject jSONObject, DebugSessionType debugSessionType) {
        m14630("DebugSession");
        if (jSONObject != null) {
            try {
                jSONObject.put("type", debugSessionType.m150());
            } catch (JSONException e) {
            }
        }
        this.f521 = jSONObject;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14629(jSONObject, Event.DATA, this.f521);
        return jSONObject;
    }
}
