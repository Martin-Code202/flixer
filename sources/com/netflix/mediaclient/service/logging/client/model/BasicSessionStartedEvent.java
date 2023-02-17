package com.netflix.mediaclient.service.logging.client.model;

import com.netflix.mediaclient.servicemgr.IClientLogging;
import o.C1349Bv;
public class BasicSessionStartedEvent extends SessionStartedEvent {
    public BasicSessionStartedEvent(String str, String str2, IClientLogging.ModalView modalView) {
        super(str);
        if (!C1349Bv.m4113(str2)) {
            this.category = str2;
        }
        this.modalView = modalView;
    }
}
