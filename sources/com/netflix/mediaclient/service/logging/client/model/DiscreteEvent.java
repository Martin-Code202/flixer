package com.netflix.mediaclient.service.logging.client.model;

import org.json.JSONObject;
public abstract class DiscreteEvent extends Event {
    public DiscreteEvent() {
        this.type = EventType.event;
    }

    public DiscreteEvent(JSONObject jSONObject) {
        super(jSONObject);
    }
}
