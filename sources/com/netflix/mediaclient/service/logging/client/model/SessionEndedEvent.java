package com.netflix.mediaclient.service.logging.client.model;

import o.AK;
import org.json.JSONObject;
public abstract class SessionEndedEvent extends SessionEvent {
    public static final String DURATION = "duration";
    private static final String EXT = ".ended";
    protected long duration;

    public SessionEndedEvent(JSONObject jSONObject) {
        super(jSONObject);
        this.duration = AK.m3388(jSONObject, DURATION, 0);
    }

    public SessionEndedEvent(String str) {
        super(str);
        this.type = EventType.sessionEnded;
        this.name = str + EXT;
        this.sessionId = new DeviceUniqueId();
        this.duration = 0;
    }

    public SessionEndedEvent(String str, DeviceUniqueId deviceUniqueId, long j) {
        super(str);
        this.type = EventType.sessionEnded;
        this.name = str + EXT;
        this.sessionId = deviceUniqueId;
        this.duration = j;
    }

    public SessionEndedEvent(SessionStartedEvent sessionStartedEvent, long j) {
        super(sessionStartedEvent.getSessionName());
        this.type = EventType.sessionEnded;
        this.name = this.sessionName + EXT;
        this.sessionId = sessionStartedEvent.getSessionId();
        this.duration = j;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.SessionEvent, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put(DURATION, this.duration);
        return jSONObject;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.SessionEvent, com.netflix.mediaclient.service.logging.client.model.Event
    public String toString() {
        return super.toString() + " <duration=" + this.duration + ">";
    }
}
