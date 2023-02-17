package com.netflix.mediaclient.service.mdx.protocol.event;

import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
public enum Events {
    mdx_init("init"),
    mdx_mdxstate("mdxstate"),
    mdx_initerror("initerror"),
    mdx_discovery_devicelost("devicelost"),
    mdx_discovery_remoteDeviceReady("remoteDeviceReady"),
    mdx_discovery_devicefound("devicefound"),
    mdx_pair_pairingresponse("pairingresponse"),
    mdx_pair_regpairresponse("regpairresponse"),
    mdx_pair_pairingdeleted("pairingdeleted"),
    mdx_session_message(DeepErrorElement.Debug.MESSAGE),
    mdx_session_startSessionResponse("startSessionResponse"),
    mdx_session_messagedelivered("messagedelivered"),
    mdx_session_messagingerror("messagingerror"),
    mdx_session_sessionended("sessionended"),
    mdx_targetrestarting("targetrestarting");
    

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected String f1387;

    private Events(String str) {
        this.f1387 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final String m750() {
        return this.f1387;
    }
}
