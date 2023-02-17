package com.netflix.mediaclient.service.mdx.protocol.target;

import android.os.SystemClock;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import com.netflix.mediaclient.service.mdx.logging.connection.ConnectLogblob;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import o.AbstractC1399Dp;
import o.AbstractC1700eM;
import o.AbstractC1744fD;
import o.AbstractC1823gi;
import o.AbstractC1833gs;
import o.BJ;
import o.C1283;
import o.C1349Bv;
import o.C1411Eb;
import o.C1418Ei;
import o.C1702eO;
import o.C1747fG;
import o.C1749fI;
import o.C1766fZ;
import o.C1767fa;
import o.C1793fz;
import o.C1815ga;
import o.C1816gb;
import o.C1819ge;
import o.C1821gg;
import o.C1822gh;
import o.C1834gt;
import o.C1835gu;
import o.C1836gv;
import o.C1837gw;
import o.DV;
import o.oD;
import org.json.JSONException;
import org.json.JSONObject;
public class SessionMdxTarget extends AbstractC1823gi {

    /* renamed from: ʻ  reason: contains not printable characters */
    private PairingScheme f1388;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private oD f1389;

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1835gu f1390;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f1391;

    /* renamed from: ʽ  reason: contains not printable characters */
    private AbstractC1833gs f1392;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private long f1393 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AtomicLong f1394 = new AtomicLong();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f1395;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private byte[] f1396;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final MsgTransportType f1397;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1837gw f1398;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f1399;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f1400;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private List<AbstractC1744fD> f1401 = new ArrayList();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AbstractC1700eM f1402;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private NetflixSecurityScheme f1403;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private JSONObject f1404;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f1405;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f1406 = 0;

    /* access modifiers changed from: package-private */
    public enum MsgTransportType {
        HTTP,
        WEBSOCKET,
        CAST
    }

    /* access modifiers changed from: package-private */
    public enum NetflixSecurityScheme {
        MSL,
        NTBA
    }

    /* access modifiers changed from: package-private */
    public enum PairingScheme {
        PAIRING,
        REGPAIR,
        REGPAIR_V2
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Long m771() {
        return Long.valueOf(this.f1394.get());
    }

    public SessionMdxTarget(String str, String str2, String str3, AbstractC1833gs gsVar, oD oDVar, AbstractC1700eM eMVar, C1767fa faVar) {
        super(str, str2, str3, faVar);
        this.f1392 = gsVar;
        this.f1390 = new C1835gu(this, this.f1392.mo749());
        this.f1398 = new C1837gw(eMVar, str);
        this.f1389 = oDVar;
        this.f1397 = MsgTransportType.CAST;
        this.f1403 = NetflixSecurityScheme.MSL;
        this.f1388 = PairingScheme.REGPAIR_V2;
        this.f1402 = eMVar;
        this.f1405 = "9080";
        C1283.m16863("SessionMdxTarget", "SessionMdxTarget %s", str);
    }

    public SessionMdxTarget(boolean z, boolean z2, int i, String str, String str2, String str3, AbstractC1833gs gsVar, oD oDVar, AbstractC1700eM eMVar, C1767fa faVar, String str4) {
        super(str, str2, str3, faVar);
        this.f1392 = gsVar;
        this.f1390 = new C1835gu(this, this.f1392.mo749());
        this.f1398 = new C1837gw(eMVar, str);
        this.f1389 = oDVar;
        this.f1397 = z2 ? MsgTransportType.WEBSOCKET : MsgTransportType.HTTP;
        this.f1403 = z ? NetflixSecurityScheme.NTBA : NetflixSecurityScheme.MSL;
        if (i == 1) {
            this.f1388 = PairingScheme.REGPAIR;
        } else if (i == 2 || i == 3) {
            this.f1388 = PairingScheme.REGPAIR_V2;
            this.f1391 = i == 3;
        } else {
            this.f1388 = PairingScheme.PAIRING;
        }
        this.f1402 = eMVar;
        this.f1405 = str4;
        C1283.m16863("SessionMdxTarget", "SessionMdxTarget %s", str);
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ॱ  reason: contains not printable characters */
    public SessionMdxTarget mo791() {
        return this;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m798() {
        return this.f1398 != null && this.f1398.m6750();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m788(final boolean z) {
        if (!z) {
            MdxConnectionLogblobLogger.m685();
        }
        this.f1390.m6727().post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget.3
            @Override // java.lang.Runnable
            public void run() {
                SessionMdxTarget.this.f1399 = z;
                SessionMdxTarget.this.f1401.clear();
                if (!SessionMdxTarget.this.m800()) {
                    SessionMdxTarget.this.f1401.add(new C1747fG());
                }
                SessionMdxTarget.this.f1401.add(new C1749fI());
                SessionMdxTarget.this.f1390.m6728();
            }
        });
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m773() {
        this.f1390.m6727().post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget.2
            @Override // java.lang.Runnable
            public void run() {
                SessionMdxTarget.this.m761();
            }
        });
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo792(final AbstractC1744fD fDVar) {
        C1283.m16863("SessionMdxTarget", "sendCommand %s", fDVar.m6349());
        this.f1390.m6727().post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget.4
            @Override // java.lang.Runnable
            public void run() {
                if ("PLAYER_GET_CAPABILITIES".equals(fDVar.m6349()) && SessionMdxTarget.this.f1404 != null) {
                    C1283.m16862("SessionMdxTarget", "sendCommand, return cached capbility.");
                    SessionMdxTarget.this.f1402.mo6064(SessionMdxTarget.this.m6671(), SessionMdxTarget.this.f1404.toString());
                } else if (!"GET_AUDIO_SUBTITLES".equals(fDVar.m6349()) || !SessionMdxTarget.this.f1398.m6758()) {
                    SessionMdxTarget.this.f1398.m6753(fDVar);
                    SessionMdxTarget.this.f1401.add(fDVar);
                    SessionMdxTarget.this.f1390.m6731(TargetStateEvent.SendMessageRequested);
                } else {
                    C1283.m16862("SessionMdxTarget", "sendCommand, return cached audio aubtitles.");
                }
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m787(JSONObject jSONObject) {
        String optString = jSONObject.optString("errorcode");
        C1283.m16855("SessionMdxTarget", "handleIncomingErrorMessage %s %s", optString, jSONObject.optString("errorstring"));
        char c = 65535;
        switch (optString.hashCode()) {
            case 53:
                if (optString.equals("5")) {
                    c = 1;
                    break;
                }
                break;
            case 54:
                if (optString.equals("6")) {
                    c = 0;
                    break;
                }
                break;
            case 1567:
                if (optString.equals("10")) {
                    c = 3;
                    break;
                }
                break;
            case 1568:
                if (optString.equals("11")) {
                    c = 2;
                    break;
                }
                break;
            case 1569:
                if (optString.equals("12")) {
                    c = 4;
                    break;
                }
                break;
            case 1570:
                if (optString.equals("13")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                this.f1390.m6731(TargetStateEvent.SendMessageFailedBadPair);
                this.f6977.m6364(TargetSessionMessageType.MESSAGE_TYPE_ERROR_BADPAIR);
                return;
            case 2:
                this.f1390.m6731(TargetStateEvent.SendMessageFailedNeedNewSession);
                this.f6977.m6364(TargetSessionMessageType.MESSAGE_TYPE_ERROR_BADSESSION);
                return;
            case 3:
            case 4:
            case 5:
                this.f1390.m6731(TargetStateEvent.PairFail);
                return;
            default:
                return;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m780(JSONObject jSONObject) {
        if (!m796()) {
            C1283.m16865("SessionMdxTarget", "device has no pair, cannot handleIncomingSessionMessage");
            return;
        }
        this.f1394.set(System.currentTimeMillis());
        C1834gt.If r6 = C1834gt.m6706(jSONObject, this.f1396, this.f1402, m6671());
        if (r6 == null) {
            C1283.m16865("SessionMdxTarget", "handleIncomingSessionMessage fail to parse");
            return;
        }
        if (r6.m6710() != null) {
            C1283.m16863("SessionMdxTarget", "has appMsg: %s", r6.m6710().m6675());
        }
        switch (r6.m6709()) {
            case MESSAGE_TYPE_STARTSESSION:
                C1819ge geVar = (C1819ge) r6.m6710();
                if (geVar.m6650()) {
                    this.f1406 = geVar.m6649();
                    this.f1390.m6731(TargetStateEvent.StartSessionSucceed);
                    C1283.m16855("SessionMdxTarget", "handleIncomingSessionMessage start session %d", Integer.valueOf(this.f1406));
                    return;
                }
                this.f1406 = 0;
                this.f1390.m6731(TargetStateEvent.StartSessionFail);
                C1283.m16865("SessionMdxTarget", "handleIncomingSessionMessage start session failed");
                return;
            case MESSAGE_TYPE_HANDSHAKE:
                if (((C1766fZ) r6.m6710()).m6360()) {
                    this.f1390.m6731(TargetStateEvent.HandShakeSucceed);
                    C1283.m16865("SessionMdxTarget", "handleIncomingSessionMessage handshake accepted");
                    return;
                }
                this.f1390.m6731(TargetStateEvent.HandShakeFailed);
                C1283.m16865("SessionMdxTarget", "handleIncomingSessionMessage handshake failed");
                return;
            case MESSAGE_TYPE_ENDSESSOIN:
                this.f1406 = 0;
                C1283.m16855("SessionMdxTarget", "handleIncomingSessionMessage session %d ended", Integer.valueOf(this.f1406));
                return;
            case MESSAGE_TYPE_CAPABILITY:
                this.f1404 = r6.m6710().m6675();
                this.f1402.mo6064(m6671(), this.f1404.toString());
                this.f1390.m6730(r6.m6709());
                return;
            case MESSAGE_TYPE_CURRENT_STATE:
                this.f1398.m6756(((C1821gg) r6.m6710()).m6661());
                this.f1390.m6730(r6.m6709());
                return;
            case MESSAGE_TYPE_STATE_CHANGED:
                this.f1398.m6757(((C1822gh) r6.m6710()).m6662());
                return;
            case MESSAGE_TYPE_AUDIO_SUBTITLES_CHANGED:
            case MESSAGE_TYPE_AUDIO_SUBTITLE_SETTINGS:
                JSONObject r11 = r6.m6710().m6675();
                if (r11.has("audio_tracks") && r11.has("timed_text_track")) {
                    this.f1398.m6755(r11.toString());
                    return;
                }
                return;
            case MESSAGE_TYPE_DIALOG_SHOW:
                this.f1402.mo6058(m6671(), r6.m6710().m6675().toString());
                return;
            case MESSAGE_TYPE_DIALOG_CANCEL:
                this.f1402.mo6060(m6671(), r6.m6710().m6675().toString());
                return;
            case MESSAGE_TYPE_META_DATA_CHANGED:
                this.f1402.mo6068(m6671(), r6.m6710().m6675().toString());
                return;
            case MESSAGE_TYPE_PIN_VERIFICATION_SHOW:
                try {
                    C1816gb gbVar = new C1816gb(r6.m6710().m6675());
                    this.f1402.mo6061(m6671(), gbVar.m6645(), gbVar.m6648(), gbVar.m6646(), gbVar.m6647());
                    return;
                } catch (JSONException e) {
                    C1283.m16850("SessionMdxTarget", "failed to parse MESSAGE_TYPE_PIN_VERIFICATION_SHOW");
                    return;
                }
            case MESSAGE_TYPE_PIN_VERIFICATION_NOT_REQUIRED:
                try {
                    this.f1402.mo6066(m6671(), new C1815ga(r6.m6710().m6675()).m6644());
                    return;
                } catch (JSONException e2) {
                    C1283.m16850("SessionMdxTarget", "failed to parse MESSAGE_TYPE_PIN_VERIFICATION_NOT_REQUIRED");
                    return;
                }
            case MESSAGE_TYPE_ERROR_BADPAIR:
                this.f1390.m6731(TargetStateEvent.SendMessageFailedBadPair);
                this.f6977.m6364(r6.m6709());
                return;
            case MESSAGE_TYPE_ERROR_BADSESSION:
                this.f1390.m6731(TargetStateEvent.SendMessageFailedNeedNewSession);
                this.f6977.m6364(r6.m6709());
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0025: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v2 java.lang.String) */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m785(JSONObject jSONObject) {
        oD.C0159 r7 = this.f1389.mo6793();
        if (r7 == null || !this.f1390.m6732()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.f1390.m6732() ? "not expecting." : "";
            C1283.m16863("SessionMdxTarget", "won't process pairing result %s", objArr);
            return;
        }
        C1836gv.If r8 = C1836gv.m6735(jSONObject, r7.f9231, this.f1389.mo6785(), this.f1389.mo6782(), m758().equals(NetflixSecurityScheme.MSL));
        if (r8 != null) {
            if (r8.m6743()) {
                this.f1396 = r8.m6741();
                this.f1395 = r8.m6740();
                this.f1400 = r8.m6744();
                if (m789()) {
                    if (MdxConnectionLogblobLogger.m688()) {
                        this.f6977.m6373().m702(m789() ? MdxTargetType.Cast : MdxTargetType.Nrdp, m6671(), m6669(), !this.f1395.equals(this.f1400));
                    } else {
                        this.f6977.m6373().m699(ConnectLogblob.LaunchOrigin.Launch, m789() ? MdxTargetType.Cast : MdxTargetType.Nrdp, m6671(), m6669(), !this.f1395.equals(this.f1400));
                    }
                }
            } else {
                this.f6977.m6361(r8.m6739());
                m765();
            }
            this.f1390.m6731(r8.m6742());
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m789() {
        return m754().equals(MsgTransportType.CAST);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m794(boolean z) {
        this.f1390.m6731(z ? TargetStateEvent.SendMessageSucceed : TargetStateEvent.SendMessageFail);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m793(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if ("targetrestarting".equals(jSONObject.optString("messageType")) && this.f1391 && (optJSONObject = jSONObject.optJSONObject("payload")) != null) {
            m757(Math.max(optJSONObject.optLong(SessionEndedEvent.DURATION, 0), 32000L));
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m784() {
        return this.f1391 && SystemClock.elapsedRealtime() > this.f1393;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m757(long j) {
        C1283.m16851("SessionMdxTarget", "set cross-profile time %d ms.", Long.valueOf(j));
        this.f1390.m6729(j);
        this.f1393 = SystemClock.elapsedRealtime() + j;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public String m790() {
        return this.f1398.m6751();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public C1702eO m782() {
        try {
            return new C1702eO(this.f1404);
        } catch (Exception e) {
            C1283.m16854("SessionMdxTarget", "device capbility not cached");
            return null;
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public BJ.C0067 m795() {
        return this.f1398.m6754();
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private MsgTransportType m754() {
        return this.f1397;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private NetflixSecurityScheme m758() {
        return this.f1403;
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private long m759() {
        return System.currentTimeMillis();
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private String m762() {
        if (m754().equals(MsgTransportType.CAST)) {
            return "cast://";
        }
        if (m754().equals(MsgTransportType.WEBSOCKET)) {
            return "ws://";
        }
        return "http://";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m768(String str) {
        return m762() + m6667() + ":" + this.f1405 + "/" + str;
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private PairingScheme m760() {
        return this.f1388;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m755(DV dv, C1411Eb eb) {
        return "1," + m769(dv) + "," + m769(eb);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m769(AbstractC1399Dp dp) {
        try {
            return C1418Ei.m4892(dp.mo3114(this.f1389.mo6785(), this.f1389.mo6782()));
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m766(String str) {
        if (m796()) {
            return C1834gt.m6707(m762(), this.f1395, m6671(), this.f1400, String.valueOf(m759()), str, this.f1396);
        }
        C1283.m16855("SessionMdxTarget", "device has no pair, cannot send session message %s", str);
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m753(AbstractC1744fD fDVar) {
        String r4 = fDVar.m6352(this.f1406);
        String r5 = m766(r4);
        C1283.m16863("SessionMdxTarget", "sendMessageMdxTarget %s", r4);
        if (C1349Bv.m4107(r5)) {
            this.f1392.a_(r5, m768("session"), m6671());
            return true;
        }
        C1283.m16850("SessionMdxTarget", "sendMessageMdxTarget failed");
        return false;
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m765() {
        this.f1396 = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˌ  reason: contains not printable characters */
    private void m761() {
        C1283.m16862("SessionMdxTarget", "resetState");
        m765();
        this.f1399 = false;
        this.f1401.clear();
        this.f1390.m6733();
        this.f1398.m6752();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public boolean m799() {
        return this.f1399;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public boolean m772() {
        return !mo791().equals(PairingScheme.PAIRING);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public boolean m796() {
        return this.f1396 != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public boolean m800() {
        return false;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public void m797() {
        m765();
        oD.C0159 r9 = this.f1389.mo6793();
        if (r9 == null) {
            C1283.m16865("SessionMdxTarget", "doPair has invalid MSL credention");
            return;
        }
        this.f1392.a_(C1836gv.m6737(false, m760().equals(PairingScheme.REGPAIR_V2), m758().equals(NetflixSecurityScheme.MSL), m762(), String.valueOf(m759()), m755(r9.f9232, r9.f9233), r9.f9231, this.f1389.mo6785(), this.f1389.mo6782()), m768("pairingrequest"), m6671());
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public void m778() {
        m765();
        oD.C0159 r9 = this.f1389.mo6793();
        if (r9 == null) {
            C1283.m16865("SessionMdxTarget", "doRegpair has invalid MSL credention");
            return;
        }
        this.f1392.a_(C1836gv.m6737(true, m760().equals(PairingScheme.REGPAIR_V2), m758().equals(NetflixSecurityScheme.MSL), m762(), String.valueOf(m759()), m755(r9.f9232, r9.f9233), r9.f9231, this.f1389.mo6785(), this.f1389.mo6782()), m768("regpairrequest"), m6671());
        if (this.f1391) {
            m757(32000);
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void m777() {
        String r4 = m766(C1834gt.m6703());
        C1283.m16863("SessionMdxTarget", "startSession [%s]", r4);
        if (C1349Bv.m4107(r4)) {
            this.f1392.a_(r4, m768("session"), m6671());
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public void m775() {
        C1283.m16862("SessionMdxTarget", "doHandShake");
        m753(new C1793fz());
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m776() {
        C1283.m16862("SessionMdxTarget", "getCapability");
        m753(new C1747fG());
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public void m774() {
        C1283.m16862("SessionMdxTarget", "getState");
        m753(new C1749fI());
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public boolean m783() {
        return !this.f1401.isEmpty();
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public boolean m779() {
        if (this.f1401.isEmpty()) {
            C1283.m16862("SessionMdxTarget", "sendPendingMessage, no message is currently pending");
            return false;
        }
        C1283.m16863("SessionMdxTarget", "has %d, sending %s", Integer.valueOf(this.f1401.size()), this.f1401.get(0).m6349());
        return m753(this.f1401.get(0));
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public void m781() {
        if (!this.f1401.isEmpty()) {
            C1283.m16863("SessionMdxTarget", "has %d, removing %s", Integer.valueOf(this.f1401.size()), this.f1401.get(0).m6349());
            this.f1401.remove(0);
            return;
        }
        C1283.m16862("SessionMdxTarget", "pendingMessageSent, but no message is currently pending");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m786(int i, String str) {
        C1283.m16863("SessionMdxTarget", "reportError %d %s", Integer.valueOf(i), str);
        m761();
        this.f1402.mo6057(m6671(), i, str);
    }
}
