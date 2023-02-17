package com.netflix.mediaclient.service.logging.client.model;

import com.netflix.mediaclient.servicemgr.IClientLogging;
import o.C1349Bv;
public final class BasicSessionEndedEvent extends SessionEndedEvent {
    public BasicSessionEndedEvent(String str, String str2, long j, IClientLogging.ModalView modalView) {
        super(str, new DeviceUniqueId(), j);
        if (!C1349Bv.m4113(str2)) {
            this.category = str2;
        }
        this.modalView = modalView;
    }
}
