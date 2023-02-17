package com.netflix.mediaclient.service.mdx.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import o.AD;
import o.AbstractC1700eM;
import o.AbstractC1779fl;
import o.AbstractC1823gi;
import o.AbstractC1830gp;
import o.AbstractC1833gs;
import o.C1283;
import o.C1339Bl;
import o.C1349Bv;
import o.C1357Cc;
import o.C1767fa;
import o.C1781fn;
import o.C1783fp;
import o.C1784fq;
import o.C1785fr;
import o.C1786fs;
import o.C1788fu;
import o.C1789fv;
import o.C1790fw;
import o.C1791fx;
import o.C1792fy;
import o.C1828gn;
import o.C1829go;
import o.C1832gr;
import o.oD;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MdxStackNetflix extends AbstractC1779fl implements AbstractC1833gs {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final List<Pair<Long, String>> f1340 = new ArrayList();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Context f1341;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f1342;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1767fa f1343;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Map<String, C1828gn> f1344 = new HashMap();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final oD f1345;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f1346;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Handler f1347;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private HandlerThread f1348;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1700eM f1349;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f1350;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final JSONArray f1351;

    private native synchronized void nativeInit(Object obj, String str);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeLaunchNetflix(String str, String str2);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native synchronized void nativeRelease();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeSendMessage(String str, String str2, long j);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeSetNetworkInterface(String str, boolean z, String str2, String str3);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeStartMdx(boolean z, String str);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeStopMdx();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeStopWakeup();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeWakeup(String str, int i);

    public MdxStackNetflix(Context context, final oD oDVar, AbstractC1700eM eMVar, Looper looper, boolean z, JSONArray jSONArray, String str, C1767fa faVar) {
        AD.m3304(context.getApplicationContext(), "mdx_jni");
        this.f1345 = oDVar;
        this.f1349 = eMVar;
        this.f1341 = context;
        this.f1342 = z;
        this.f1351 = jSONArray;
        this.f1343 = faVar;
        this.f1348 = new HandlerThread("NativeMdxThread");
        this.f1348.start();
        this.f1347 = new Handler(this.f1348.getLooper()) { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        MdxStackNetflix.this.m734(message.obj);
                        return;
                    case 2:
                    default:
                        return;
                    case 3:
                        ((Runnable) message.obj).run();
                        return;
                    case 4:
                        if (message.obj instanceof String) {
                            String str2 = (String) message.obj;
                            AbstractC1823gi r6 = MdxStackNetflix.this.mo741(str2);
                            if (r6 == null || !(r6 instanceof AbstractC1830gp)) {
                                C1283.m16855("MdxControllerNative", "%s no longer has DIAL target.", str2);
                                return;
                            }
                            C1283.m16855("MdxControllerNative", "%s launch timeout.", str2);
                            ((AbstractC1830gp) r6).mo6678(false, oDVar, MdxStackNetflix.this.f1349);
                            return;
                        }
                        C1283.m16865("MdxControllerNative", "MDX_EVENT_LAUNCH_TIMEOUT does not have UUID, bug!!!");
                        return;
                    case 5:
                        if (message.obj instanceof String) {
                            String str3 = (String) message.obj;
                            AbstractC1823gi r62 = MdxStackNetflix.this.mo741(str3);
                            if (r62 == null || !(r62 instanceof C1828gn)) {
                                C1283.m16855("MdxControllerNative", "MDX_EVENT_DIALV2_LAUNCH_TIMEOUT, %s has not DIAL V2 target.", str3);
                                return;
                            }
                            C1283.m16855("MdxControllerNative", "%s DIAL V2 launch timeout.", str3);
                            ((C1828gn) r62).m6687(MdxStackNetflix.this.f1349);
                            MdxStackNetflix.this.nativeStopWakeup();
                            MdxStackNetflix.this.m729();
                            return;
                        }
                        C1283.m16865("MdxControllerNative", "MDX_EVENT_DIALV2_LAUNCH_TIMEOUT does not have UUID, bug!!!");
                        return;
                }
            }
        };
        nativeInit(new WeakReference(this), str);
    }

    @Override // o.AbstractC1779fl
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1823gi mo741(String str) {
        synchronized (this.f6762) {
            Iterator it = this.f6762.iterator();
            while (it.hasNext()) {
                AbstractC1823gi giVar = (AbstractC1823gi) it.next();
                if (giVar.mo6670(str)) {
                    return giVar;
                }
            }
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m745(String str) {
        this.f1350 = str;
        m6408(this.f1350);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m748(final String str) {
        this.f1347.post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.3
            @Override // java.lang.Runnable
            public void run() {
                MdxStackNetflix.this.nativeLaunchNetflix("uuid:" + str, "intent=sync");
            }
        });
        this.f1347.sendMessageDelayed(this.f1347.obtainMessage(4, str), 22000);
    }

    @Override // o.AbstractC1833gs
    public void a_(final String str, final String str2, final String str3) {
        C1283.m16863("MdxControllerNative", "sendMessage message=%s url=%s uuid=%s", str, str2, str3);
        this.f1347.post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.1
            @Override // java.lang.Runnable
            public void run() {
                long r3 = MdxStackNetflix.this.m712();
                MdxStackNetflix.this.nativeSendMessage(str, str2, r3);
                MdxStackNetflix.this.m725(Long.valueOf(r3), str3);
            }
        });
    }

    @Override // o.AbstractC1833gs
    /* renamed from: ᐝ  reason: contains not printable characters */
    public Looper mo749() {
        return this.f1347.getLooper();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m744(final String str, final boolean z, final String str2, final String str3) {
        this.f1347.removeMessages(3);
        C1283.m16851("MdxControllerNative", "setMdxNetworkInterface %s %b", str, Boolean.valueOf(z));
        this.f1347.sendMessage(this.f1347.obtainMessage(3, new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.5
            @Override // java.lang.Runnable
            public void run() {
                MdxStackNetflix.this.nativeSetNetworkInterface(str, z, str2, str3);
                MdxStackNetflix.this.f1346 = str3;
            }
        }));
    }

    @Override // o.AbstractC1779fl
    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo740() {
        this.f1347.post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.4
            @Override // java.lang.Runnable
            public void run() {
                MdxStackNetflix.this.nativeRelease();
                MdxStackNetflix.this.f1348.quit();
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m747() {
        this.f1347.post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.7
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (MdxStackNetflix.this.f1351 == null) {
                    str = new JSONObject().toString();
                } else {
                    str = MdxStackNetflix.this.f1351.toString();
                }
                MdxStackNetflix.this.nativeStartMdx(MdxStackNetflix.this.f1342, str);
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m743() {
        this.f1347.post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.6
            @Override // java.lang.Runnable
            public void run() {
                MdxStackNetflix.this.nativeStopMdx();
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m742() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m746(final String str, final int i, String str2) {
        C1283.m16851("MdxControllerNative", "wakeupDialV2Device %s %d", str, Integer.valueOf(i));
        this.f1347.post(new Runnable() { // from class: com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix.10
            @Override // java.lang.Runnable
            public void run() {
                MdxStackNetflix.this.nativeWakeup(str, i);
            }
        });
        this.f1347.sendMessageDelayed(this.f1347.obtainMessage(5, str2), TimeUnit.SECONDS.toMillis((long) (i * 2)));
    }

    private void postMdxEventFromNative(String str) {
        this.f1347.obtainMessage(1, str).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m734(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            if (jSONObject.length() != 1) {
                C1283.m16865("MdxControllerNative", "event has more than one elements. ignored");
                return;
            }
            C1283.m16862("MdxControllerNative", "process event");
            if (jSONObject.has(C1786fs.f6813.m750())) {
                jSONObject.getJSONObject(C1786fs.f6813.m750());
                m731();
            } else if (jSONObject.has(C1781fn.f6782.m750())) {
                new C1781fn(jSONObject.getJSONObject(C1781fn.f6782.m750()));
            } else if (jSONObject.has(C1784fq.f6796.m750())) {
                if (!new C1784fq(jSONObject.getJSONObject(C1784fq.f6796.m750())).m6450()) {
                    m736();
                } else {
                    m705();
                }
            } else if (jSONObject.has(C1789fv.f6819.m750())) {
                m717(new C1789fv(jSONObject.getJSONObject(C1789fv.f6819.m750())).m6460());
            } else if (jSONObject.has(C1783fp.f6794.m750())) {
                m727(new C1783fp(jSONObject.getJSONObject(C1783fp.f6794.m750())).m6449());
            } else if (jSONObject.has(C1790fw.f6821.m750())) {
                C1790fw fwVar = new C1790fw(jSONObject.getJSONObject(C1790fw.f6821.m750()));
                m726(fwVar.m6461(), fwVar.m6462());
            } else if (jSONObject.has(C1791fx.f6825.m750())) {
                m706(new C1791fx(jSONObject.getJSONObject(C1791fx.f6825.m750())).m6463());
            } else if (jSONObject.has(C1788fu.f6816.m750())) {
                m721(true, (long) new C1788fu(jSONObject.getJSONObject(C1788fu.f6816.m750())).m6459());
            } else if (jSONObject.has(C1792fy.f6832.m750())) {
                m721(false, (long) new C1792fy(jSONObject.getJSONObject(C1792fy.f6832.m750())).m6464());
            } else {
                C1283.m16865("MdxControllerNative", "unknwon event");
            }
        } catch (Exception e) {
            C1283.m16855("MdxControllerNative", "process event failure %s", e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m731() {
        C1283.m16862("MdxControllerNative", "handleInitialized");
        m735();
        m705();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m736() {
        C1283.m16862("MdxControllerNative", "handleNotReady");
        this.f1340.clear();
        m6407();
        this.f1349.mo6062();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m705() {
        C1283.m16862("MdxControllerNative", "handleReady");
        this.f1340.clear();
        m6407();
        m739(this.f1346);
        this.f1349.mo6062();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m726(String str, int i) {
        boolean z = i > 0;
        synchronized (this.f6762) {
            AbstractC1823gi r7 = mo741(str);
            if (r7 != null) {
                C1283.m16855("MdxControllerNative", "handleRemoteDeviceReady %s %s launchStatus %d.", str, r7.m6669(), Integer.valueOf(i));
                if (r7 instanceof C1832gr) {
                    C1832gr grVar = (C1832gr) r7;
                    if (grVar.m6700(i) && !z && grVar.m6698()) {
                        SessionMdxTarget r9 = grVar.mo791();
                        if (r9 == null || !r9.m784()) {
                            grVar.m6701();
                            this.f1343.m6362("uuid=" + str);
                            if (r7.mo6670(this.f1350)) {
                                this.f1349.mo6057(str, 200, r7.m6669());
                            }
                        } else {
                            C1283.m16865("MdxControllerNative", "handleRemoteDeviceReady ignore xprofile device lost.");
                        }
                    }
                } else {
                    C1283.m16865("MdxControllerNative", "handleRemoteDeviceReady ignored.");
                }
                this.f1349.mo6062();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m727(C1785fr frVar) {
        if (frVar != null) {
            if (!C1349Bv.m4113(frVar.f6808) || !C1349Bv.m4113(frVar.f6804)) {
                C1283.m16863("MdxControllerNative", "handleDeviceFound %s", frVar);
                synchronized (this.f6762) {
                    if (frVar.m6454()) {
                        ListIterator listIterator = this.f6762.listIterator();
                        while (listIterator.hasNext()) {
                            AbstractC1823gi giVar = (AbstractC1823gi) listIterator.next();
                            if (giVar.mo6670(frVar.f6808)) {
                                giVar.mo6672(frVar.m6455(), frVar.f6801);
                                C1283.m16862("MdxControllerNative", "handleDeviceFound MDX device already recorded");
                                return;
                            } else if (giVar.m6667().equals(frVar.m6455())) {
                                C1283.m16862("MdxControllerNative", "handleDeviceFound MDX device associate with DIAL");
                                C1832gr grVar = (C1832gr) giVar;
                                grVar.m6699(new SessionMdxTarget(false, false, 2, frVar.f6808, frVar.f6801, frVar.m6455(), this, this.f1345, this.f1349, this.f1343, frVar.m6456()));
                                this.f1347.removeMessages(4, grVar.m6671());
                                grVar.mo6678(true, this.f1345, this.f1349);
                                this.f1343.m6365("uuid=" + frVar.f6808 + " dialUuid=" + frVar.f6804 + " serviceType=" + frVar.f6799);
                                C1357Cc.m4343(this.f1341, frVar);
                                return;
                            }
                        }
                        if (!listIterator.hasNext()) {
                            C1283.m16862("MdxControllerNative", "handleDeviceFound MDX device recorded");
                            SessionMdxTarget sessionMdxTarget = new SessionMdxTarget(false, !this.f1342, 2, frVar.f6808, frVar.f6801, frVar.m6455(), this, this.f1345, this.f1349, this.f1343, frVar.m6456());
                            listIterator.add(sessionMdxTarget);
                            m720(sessionMdxTarget);
                            C1357Cc.m4343(this.f1341, frVar);
                        }
                    } else {
                        ListIterator listIterator2 = this.f6762.listIterator();
                        while (listIterator2.hasNext()) {
                            AbstractC1823gi giVar2 = (AbstractC1823gi) listIterator2.next();
                            if (giVar2.m6671().equals(frVar.f6808)) {
                                giVar2.mo6672(frVar.m6455(), frVar.f6801);
                                if (giVar2 instanceof C1828gn) {
                                    C1828gn gnVar = (C1828gn) giVar2;
                                    this.f1347.removeMessages(5, gnVar.m6671());
                                    gnVar.m6686();
                                    m729();
                                }
                                C1283.m16862("MdxControllerNative", "handleDeviceFound DIAL device already recorded");
                                return;
                            } else if (giVar2.m6667().equals(frVar.m6455())) {
                                C1283.m16862("MdxControllerNative", "handleDeviceFound DIAL device associate with MDX");
                                C1832gr r15 = m718(frVar);
                                r15.m6699((SessionMdxTarget) giVar2);
                                listIterator2.set(r15);
                                m720(r15);
                                this.f1343.m6365("uuid=" + frVar.f6808 + " dialUuid=" + frVar.f6804 + " serviceType=" + frVar.f6799);
                                C1357Cc.m4343(this.f1341, frVar);
                                return;
                            }
                        }
                        if (!listIterator2.hasNext()) {
                            C1283.m16862("MdxControllerNative", "handleDeviceFound DIAL device recorded");
                            listIterator2.add(m718(frVar));
                            C1357Cc.m4343(this.f1341, frVar);
                        }
                    }
                    this.f1349.mo6062();
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m717(String[] strArr) {
        SessionMdxTarget sessionMdxTarget;
        if (strArr.length != 0) {
            synchronized (this.f6762) {
                Iterator it = this.f6762.iterator();
                for (String str : strArr) {
                    C1283.m16863("MdxControllerNative", "handleDeviceLost %s", str);
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AbstractC1823gi giVar = (AbstractC1823gi) it.next();
                        if (giVar.mo6670(str)) {
                            if (giVar instanceof SessionMdxTarget) {
                                sessionMdxTarget = (SessionMdxTarget) giVar;
                            } else {
                                sessionMdxTarget = giVar.mo791();
                            }
                            if (sessionMdxTarget == null || !sessionMdxTarget.m6671().equals(str)) {
                                if (giVar instanceof C1828gn) {
                                    C1283.m16863("MdxControllerNative", "handleDeviceLost,  DIAL V2 device %s is down.", giVar.m6669());
                                    ((C1828gn) giVar).m6688();
                                } else {
                                    C1283.m16863("MdxControllerNative", "handleDeviceLost, remove DIAL device %s.", giVar.m6669());
                                    it.remove();
                                }
                            } else if (sessionMdxTarget.m784()) {
                                C1283.m16863("MdxControllerNative", "handleDeviceLost, ignore xprofile MDX device lost %s %s", sessionMdxTarget.m6671(), sessionMdxTarget.m6669());
                            } else {
                                C1283.m16863("MdxControllerNative", "handleDeviceLost, remove MDX device %s %s", sessionMdxTarget.m6671(), sessionMdxTarget.m6669());
                                if (giVar instanceof SessionMdxTarget) {
                                    it.remove();
                                } else {
                                    ((C1832gr) giVar).m6701();
                                }
                            }
                            this.f1343.m6362("uuid=" + str);
                            if (giVar.mo6670(this.f1350)) {
                                this.f1349.mo6057(str, 200, giVar.m6669());
                            }
                        }
                    }
                    if (!it.hasNext()) {
                        C1283.m16862("MdxControllerNative", "handleDeviceLost, not in device list, BUG!!!");
                    }
                }
            }
            this.f1349.mo6062();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m706(String str) {
        C1283.m16863("MdxControllerNative", "handleIncommingMdxMessage %s", str);
        try {
            JSONObject r4 = C1829go.m6692(str);
            String string = r4.getString("action");
            if ("pairingresponse".equals(string) || "regpairreply".equals(string) || "regpairerror".equals(string)) {
                SessionMdxTarget r7 = m6410(r4.getString("targetuuid"));
                if (r7 != null) {
                    r7.m785(r4);
                } else {
                    C1283.m16862("MdxControllerNative", "handleIncommingMdxMessage, no device to handle pairing message");
                }
            } else if ("session".equals(string)) {
                SessionMdxTarget r72 = m6410(r4.getString("fromuuid"));
                if (r72 != null) {
                    r72.m780(r4);
                } else {
                    C1283.m16862("MdxControllerNative", "handleIncommingMdxMessage, no device to handle session message");
                }
            } else if ("broadcast".equals(string)) {
                SessionMdxTarget r73 = m6410(r4.getString("fromuuid"));
                if (r73 != null) {
                    r73.m793(r4);
                } else {
                    C1283.m16862("MdxControllerNative", "handleIncommingMdxMessage, no device to handle broadcast message");
                }
            } else if (ExceptionClEvent.CATEGORY_VALUE.equals(string)) {
                SessionMdxTarget r74 = m6410(r4.getString("fromuuid"));
                if (r74 != null) {
                    r74.m787(r4);
                } else {
                    C1283.m16862("MdxControllerNative", "handleIncommingMdxMessage, no device to handle error message");
                }
            } else {
                C1283.m16863("MdxControllerNative", "handleIncommingMdxMessage, not handling %s", string);
            }
        } catch (JSONException e) {
            C1283.m16863("MdxControllerNative", "handleIncommingMdxMessage, JSONException %s", e);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m721(boolean z, long j) {
        String r5 = m730(j);
        SessionMdxTarget r6 = m6410(r5);
        if (r6 != null) {
            r6.m794(z);
        } else {
            C1283.m16863("MdxControllerNative", "onSendMessageResult, no target to handle message. %s %b", r5, Boolean.valueOf(z));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private long m712() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m730(long j) {
        long r2 = m712();
        Iterator<Pair<Long, String>> it = this.f1340.iterator();
        while (it.hasNext()) {
            Pair<Long, String> next = it.next();
            long longValue = ((Long) next.first).longValue();
            if (longValue == j) {
                String str = (String) next.second;
                it.remove();
                return str;
            } else if (7000 + longValue < r2) {
                it.remove();
            }
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m720(AbstractC1823gi giVar) {
        SessionMdxTarget r1;
        if (giVar.mo6670(this.f1350) && (r1 = giVar.mo791()) != null) {
            r1.m788(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m725(Long l, String str) {
        C1283.m16863("MdxControllerNative", "add transaction %d %s", l, str);
        long r4 = m712();
        Iterator<Pair<Long, String>> it = this.f1340.iterator();
        while (it.hasNext() && 7000 + ((Long) it.next().first).longValue() < r4) {
            it.remove();
        }
        this.f1340.add(Pair.create(l, str));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1832gr m718(C1785fr frVar) {
        if (frVar.f6798 == null) {
            return new C1832gr(frVar.f6808, frVar.f6801, frVar.m6455(), this, this.f1343);
        }
        C1828gn gnVar = new C1828gn(frVar.f6808, frVar.f6801, frVar.m6455(), this, this.f1343, frVar.f6798.f6812, frVar.f6798.f6811, this.f1346);
        m728(gnVar);
        return gnVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m728(C1828gn gnVar) {
        this.f1344.put(gnVar.m6671(), gnVar);
        m729();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m729() {
        JSONArray jSONArray = new JSONArray();
        for (C1828gn gnVar : this.f1344.values()) {
            try {
                jSONArray.put(gnVar.m6684());
            } catch (Exception e) {
                C1283.m16855("MdxControllerNative", "fail to persist %s %s", gnVar.m6669(), e);
                return;
            }
        }
        C1283.m16863("MdxControllerNative", "persist DialV2 %s ", jSONArray);
        C1339Bl.m4039(this.f1341, "dial_v2_devices", jSONArray.toString());
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m735() {
        try {
            JSONArray jSONArray = new JSONArray(C1339Bl.m4045(this.f1341, "dial_v2_devices", (String) null));
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    C1828gn r7 = C1828gn.m6682(jSONArray.getJSONObject(i), this, this.f1343);
                    if (r7.m6689()) {
                        this.f1344.put(r7.m6671(), r7);
                        C1283.m16855("MdxControllerNative", "load DialV2 %s ", r7.m6671());
                    } else {
                        C1283.m16855("MdxControllerNative", "won't load DialV2 %s ", r7.m6671());
                    }
                }
            }
        } catch (JSONException e) {
            C1283.m16855("MdxControllerNative", " fail to load persist %s %s", "dial_v2_devices", e);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m739(String str) {
        synchronized (this.f6762) {
            for (C1828gn gnVar : this.f1344.values()) {
                if (str.equals(gnVar.m6685())) {
                    this.f6762.add(gnVar);
                    C1283.m16855("MdxControllerNative", "list  DialV2 %s ", gnVar.m6671());
                }
            }
        }
    }
}
