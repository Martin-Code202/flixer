package com.netflix.mediaclient.service.mdx.logging;

import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import com.netflix.mediaclient.servicemgr.Logblob;
import o.AbstractC1542bQ;
import o.C1283;
import org.json.JSONException;
public class MdxLogblob extends AbstractC1542bQ {

    public enum LogBlobEvent {
        START_MDX("startMdx"),
        STOP_MDX("stopMdx"),
        FAIL_TO_SEND_MESSAGE("failToSendMsg"),
        APPLICATION_STOPPED("appStopped"),
        FAIL_TO_LAUNCH("failToLaunch"),
        FAIL_TO_CONNECT("failToConnect"),
        NETFLIX_MDX_DEVICE_FOUND("netflixDeviceFound"),
        NETFLIX_MDX_DEVICE_LOST("netflixDeviceLost"),
        CAST_DEVICE_FOUND("castDeviceFound"),
        CAST_DEVICE_LOST("castDeviceLost"),
        PAIRING_FAILED("pairingFailed"),
        ERROR_DISPLAYED("errorDisplayed"),
        SESSION_MDX_TARGET_ERROR("sessionMdxError");
        

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private final String f1318;

        private LogBlobEvent(String str) {
            this.f1318 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public String m681() {
            return this.f1318;
        }
    }

    public MdxLogblob(LogBlobEvent logBlobEvent) {
        try {
            this.f6134.put("event", logBlobEvent.m681());
        } catch (JSONException e) {
            C1283.m16847("nf_mdxLogblob", "MdxLogblob", e);
        }
    }

    public MdxLogblob(LogBlobEvent logBlobEvent, String str, Logblob.Severity severity) {
        try {
            this.f6135 = severity;
            this.f6134.put("event", logBlobEvent.m681());
            this.f6134.put("errormsg", str);
        } catch (JSONException e) {
            C1283.m16847("nf_mdxLogblob", "MdxLogblob", e);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo680() {
        return LogBlobType.MDX_LOGBLOB_TYPE.m602();
    }
}
