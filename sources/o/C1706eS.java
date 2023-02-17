package o;

import android.os.Handler;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.eS  reason: case insensitive filesystem */
public class C1706eS implements SessionManagerListener<Session>, Cast.MessageReceivedCallback {

    /* renamed from: ʼ  reason: contains not printable characters */
    private CastSession f6590;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1711eX f6591;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final CastContext f6592;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1767fa f6593;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f6594;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f6595;

    public C1706eS(CastContext castContext, Handler handler, String str, C1767fa faVar, AbstractC1711eX eXVar) {
        this.f6592 = castContext;
        this.f6594 = handler;
        this.f6595 = str;
        this.f6591 = eXVar;
        this.f6593 = faVar;
        this.f6592.getSessionManager().addSessionManagerListener(this);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6262(String str) {
        C1283.m16851("CafSessionManager", "sendMessage - message: %s", str);
        m6257(m6260(str));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6261(String str, String str2) {
        m6257(m6254(str, str2));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m6260(String str) {
        String r2 = m6256(str);
        if (C1349Bv.m4113(r2)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FalkorPathResult.PATH, r2).put("body", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            C1283.m16850("CafSessionManager", "createMessage failed");
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m6256(String str) {
        int length;
        int indexOf;
        int indexOf2 = str.indexOf("action=");
        if (indexOf2 < 0 || (indexOf = str.indexOf("\r\n", indexOf2)) <= (length = indexOf2 + "action=".length())) {
            return null;
        }
        return str.substring(length, indexOf);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6257(final String str) {
        C1283.m16851("CafSessionManager", "sendCastMessage - message: %s", str);
        this.f6594.post(new Runnable() { // from class: o.eS.4
            @Override // java.lang.Runnable
            public void run() {
                if (C1706eS.this.f6590 == null || !C1706eS.this.f6590.isConnected()) {
                    C1283.m16865("CafSessionManager", "sendCastMessage - session doesn't exist or isn't connected - ignoring message");
                } else {
                    C1706eS.this.f6590.sendMessage("urn:x-cast:mdx-netflix-com:service:target:2", str).setResultCallback(new ResultCallback<Status>() { // from class: o.eS.4.5
                        /* renamed from: ˋ  reason: contains not printable characters */
                        public void onResult(Status status) {
                            if (status.isSuccess()) {
                                C1283.m16854("CafSessionManager", "SendMessage(), success");
                                C1706eS.this.m6255(true);
                            } else if (status.getStatus().getStatusCode() == 15) {
                                C1283.m16854("CafSessionManager", "SendMessage(), has timed out");
                                C1706eS.this.m6255(false);
                            } else {
                                C1706eS.this.m6255(false);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6255(boolean z) {
        this.f6591.mo6334(z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m6254(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "castHandShake").put("uuid", str).put("controlleruuid", this.f6595).put("friendlyName", str2).put("payload", "intent=sync");
            return jSONObject.toString();
        } catch (JSONException e) {
            C1283.m16850("CafSessionManager", "createCastHandShakeMessage failed, e");
            return null;
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarting(Session session) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionStarting - session: %s", session.toString());
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarted(Session session, String str) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionStarted - session: %s, sessionId: %s", session.toString(), str);
        this.f6590 = (CastSession) session;
        try {
            this.f6590.setMessageReceivedCallbacks("urn:x-cast:mdx-netflix-com:service:target:2", this);
            this.f6591.mo6336();
        } catch (IOException e) {
            C1283.m16844("CafSessionManager", "onSessionStarted - error registering for message callbacks - error: %s", e.getMessage());
            this.f6590 = null;
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStartFailed(Session session, int i) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionStartFailed - session: %s, error: %s", session.toString(), CastStatusCodes.getStatusCodeString(i));
        this.f6591.mo6331();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnding(Session session) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionEnding - session: %s", session.toString());
        try {
            if (this.f6590 != null) {
                this.f6590.removeMessageReceivedCallbacks("urn:x-cast:mdx-netflix-com:service:target:2");
                CastDevice castDevice = this.f6590.getCastDevice();
                if (castDevice == null) {
                    C1283.m16850("CafSessionManager", "CafSessionManager onSessionEnding - device not found, so can't remove callbacks or log disconnect");
                } else {
                    this.f6593.m6373().m701(MdxTargetType.Cast, castDevice.getDeviceId(), castDevice.getFriendlyName());
                }
            }
        } catch (IOException e) {
            C1283.m16844("CafSessionManager", "CafSessionManager onSessionEnding - failed to remove message received callbacks - error: %s", e.getMessage());
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnded(Session session, int i) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionEnded - session: %s, error: %s", session.toString(), CastStatusCodes.getStatusCodeString(i));
        this.f6590 = null;
        this.f6591.mo6332();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResuming(Session session, String str) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionResuming - session: %s, sessionId: %s", session.toString(), str);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumed(Session session, boolean z) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionResumed - session: %s, wasSuspended: %b", session.toString(), Boolean.valueOf(z));
        this.f6590 = (CastSession) session;
        try {
            this.f6590.setMessageReceivedCallbacks("urn:x-cast:mdx-netflix-com:service:target:2", this);
            this.f6591.mo6335();
        } catch (IOException e) {
            C1283.m16844("CafSessionManager", "onSessionResumed - error registering for message callbacks - error: %s", e.getMessage());
            this.f6590 = null;
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumeFailed(Session session, int i) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionResumeFailed - session: %s, error: %s", session.toString(), CastStatusCodes.getStatusCodeString(i));
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionSuspended(Session session, int i) {
        C1283.m16851("CafSessionManager", "CafSessionManager onSessionSuspended - session: %s, reason: %s", session.toString(), Integer.valueOf(i));
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        String str3;
        C1283.m16851("CafSessionManager", "onMessageReceived - message: %s", str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("body");
            String optString2 = jSONObject.optString("url");
            if (optString2.contains("/")) {
                str3 = optString2.substring(optString2.lastIndexOf("/"));
            } else {
                str3 = optString2;
            }
            this.f6591.mo6333(jSONObject.optString("type"), str3, optString);
        } catch (JSONException e) {
            C1283.m16844("CafSessionManager", "onMessageReceived - error parsing message: %s", e.getMessage());
        }
    }
}
