package com.netflix.mediaclient.service.logging.client.model;

import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
public class CustomEvent extends Event {
    JSONObject customData;

    public CustomEvent(String str, IClientLogging.ModalView modalView, JSONObject jSONObject) {
        this.name = str;
        this.modalView = modalView;
        if (jSONObject != null) {
            this.customData = jSONObject;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        return this.customData;
    }
}
