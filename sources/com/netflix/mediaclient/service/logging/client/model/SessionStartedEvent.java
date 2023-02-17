package com.netflix.mediaclient.service.logging.client.model;

import org.json.JSONObject;
public abstract class SessionStartedEvent extends SessionEvent {
    private static final String EXT = ".started";

    public SessionStartedEvent(JSONObject jSONObject) {
        super(jSONObject);
    }

    public SessionStartedEvent(String str) {
        super(str);
        this.type = EventType.sessionStarted;
        this.name = str + EXT;
        this.sessionId = new DeviceUniqueId();
    }
}
