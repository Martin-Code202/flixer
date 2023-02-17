package o;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.android.preapp.model.PreAppWidgetInstallEvent;
import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
/* renamed from: o.w  reason: case insensitive filesystem */
public class C2257w implements ApplicationPerformanceMetricsLogging {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1476aH f11385;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C1359Ce f11386;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Map<String, C1474aF> f11387 = Collections.synchronizedMap(new HashMap());

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1475aG f11388;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final K f11389;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final Map<String, AbstractC1472aD> f11390 = Collections.synchronizedMap(new HashMap());

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1469aA f11391;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private IClientLogging.ModalView f11392;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1482aN f11393;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ScheduledExecutorService f11394;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Map<String, C1474aF> f11395 = Collections.synchronizedMap(new HashMap());

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Map<String, C1473aE> f11396 = Collections.synchronizedMap(new HashMap());

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final C0248 f11397 = new C0248();

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Runnable f11398 = new Runnable() { // from class: o.w.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (C2257w.this.f11395) {
                C1283.m16863("nf_log_apm", "Flush pending UIAssetRequestSession size=%d", Integer.valueOf(C2257w.this.f11395.size()));
                Iterator it = C2257w.this.f11395.entrySet().iterator();
                while (it.hasNext()) {
                    C1474aF aFVar = (C1474aF) ((Map.Entry) it.next()).getValue();
                    if (aFVar == null) {
                        C1283.m16863("nf_log_apm", "UIAssetRequestSession removing null session url=%s", aFVar.m5372());
                        it.remove();
                    } else {
                        boolean z = false;
                        if (!aFVar.m5376()) {
                            z = true;
                            C1489aU r10 = aFVar.m5373();
                            if (r10 != null) {
                                C1283.m16863("nf_log_apm", "UIAssetRequestSession flushing url=%s", aFVar.m5372());
                                C2257w.this.m12212(aFVar, r10);
                            }
                        }
                        if (z) {
                            it.remove();
                        }
                    }
                }
            }
        }
    };

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private long f11399;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1478aJ f11400;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private AtomicBoolean f11401 = new AtomicBoolean(false);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Map<String, C1477aI> f11402 = Collections.synchronizedMap(new HashMap());

    C2257w(K k, ScheduledExecutorService scheduledExecutorService) {
        this.f11389 = k;
        this.f11394 = scheduledExecutorService;
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ॱ */
    public void mo1498(boolean z, boolean z2) {
        C1283.m16854("nf_log_apm", "Application session created");
        Long r7 = AP.m3397();
        long currentTimeMillis = System.currentTimeMillis();
        C1283.m16854("nf_log_apm", "Application ID is ready, start application session...");
        m12200(z, z2, r7.longValue(), currentTimeMillis);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12200(boolean z, boolean z2, long j, long j2) {
        this.f11391 = new C1469aA();
        this.f11391.mo5386(j);
        this.f11389.mo4786(this.f11391);
        C1283.m16854("nf_log_apm", "Application session start event posting...");
        C1484aP r4 = this.f11391.m5366(z, z2);
        m12207(r4, this.f11386, this.f11392);
        this.f11389.mo4783(r4);
        C1283.m16854("nf_log_apm", "Application session start event posted.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12246() {
        C1283.m16854("nf_log_apm", "Application session ended");
        if (this.f11391 == null) {
            C1283.m16865("nf_log_apm", "Application session does NOT exist!");
            return;
        }
        this.f11389.mo4785(this.f11391);
        C1283.m16854("nf_log_apm", "Application session end event posting...");
        C1481aM r2 = this.f11391.m5365();
        m12207(r2, this.f11386, this.f11392);
        this.f11389.mo4783(r2);
        this.f11391 = null;
        C1283.m16854("nf_log_apm", "Application session end event posted.");
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1486(ApplicationPerformanceMetricsLogging.Trigger trigger) {
        m12247(trigger, 0);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12247(ApplicationPerformanceMetricsLogging.Trigger trigger, long j) {
        if (this.f11393 != null) {
            C1283.m16854("nf_log_apm", "User session already exist");
            return;
        }
        C1283.m16854("nf_log_apm", "User session started");
        C1482aN aNVar = new C1482aN();
        C1283.m16854("nf_log_apm", "User session start event posting...");
        C1556be r3 = aNVar.m5384(trigger, j);
        AP.m3398();
        long longValue = AP.m3400().longValue();
        C1283.m16854("nf_log_apm", "We never used nrdp.log.sessionid, use it now if user session exist in nrdp");
        C1283.m16854("nf_log_apm", "User session is created. Set it to event and post event");
        this.f11389.mo4785(this.f11393);
        this.f11393 = aNVar;
        this.f11393.mo5386(longValue);
        this.f11399 = longValue;
        this.f11389.mo4786(this.f11393);
        r3.setSessionId(this.f11393.m5779());
        m12219(r3, this.f11386, this.f11392);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12219(C1556be beVar, C1359Ce ce, IClientLogging.ModalView modalView) {
        m12207(beVar, ce, modalView);
        this.f11389.mo4783(beVar);
        C1283.m16854("nf_log_apm", "User session start event posted.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12242(ApplicationPerformanceMetricsLogging.EndReason endReason, long j) {
        C1283.m16854("nf_log_apm", "User session ended");
        if (this.f11393 == null) {
            C1283.m16865("nf_log_apm", "User session does NOT exist!");
            return;
        }
        C1558bg r6 = this.f11393.m5385(endReason, j, this.f11386, this.f11392);
        if (r6 == null) {
            C1283.m16854("nf_log_apm", "User session still waits on session id, do not post at this time.");
            return;
        }
        this.f11389.mo4785(this.f11393);
        C1283.m16854("nf_log_apm", "User session end event posting...");
        this.f11389.mo4783(r6);
        this.f11393 = null;
        C1283.m16854("nf_log_apm", "User session end event posted.");
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1487(ApplicationPerformanceMetricsLogging.UiStartupTrigger uiStartupTrigger, IClientLogging.ModalView modalView, Long l, Display display, C1487aS aSVar, C1491aV aVVar) {
        if (this.f11400 != null) {
            C1283.m16865("nf_log_apm", "UI startup session already exist, we do not recreate it!");
            return;
        }
        C1283.m16854("nf_log_apm", "UI startup session created");
        C1478aJ aJVar = new C1478aJ(uiStartupTrigger, modalView, display, aSVar, aVVar);
        if (l != null) {
            aJVar.m5778(l.longValue());
        }
        this.f11389.mo4785(this.f11400);
        this.f11400 = aJVar;
        this.f11389.mo4786(aJVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12245(boolean z, UIError uIError) {
        if (this.f11400 != null) {
            C1283.m16854("nf_log_apm", "UI startup session ended");
            this.f11389.mo4785(this.f11400);
            C1283.m16854("nf_log_apm", "UI startup session end event posting...");
            C1495aZ r2 = this.f11400.m5381(z, uIError);
            m12207(r2, this.f11386, this.f11392);
            this.f11389.mo4783(r2);
            this.f11400 = null;
            C1283.m16854("nf_log_apm", "UI startup session end event posted.");
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˏ */
    public void mo1492(long j) {
        C1283.m16854("nf_log_apm", "UI browse startup session started.");
        C1475aG aGVar = new C1475aG();
        aGVar.m5778(j);
        this.f11389.mo4785(this.f11388);
        this.f11389.mo4786(aGVar);
        this.f11388 = aGVar;
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1485(long j, boolean z, UIError uIError) {
        if (this.f11388 == null) {
            C1283.m16854("nf_log_apm", "UI browse startup session is null - bailing early");
            return;
        }
        C1283.m16854("nf_log_apm", "UI browse startup session ended");
        this.f11389.mo4785(this.f11388);
        C1283.m16854("nf_log_apm", "UI browse startup session end event posting...");
        C1492aW r2 = this.f11388.m5377(j, z, uIError);
        m12207(r2, this.f11386, this.f11392);
        this.f11389.mo4783(r2);
        this.f11388 = null;
        C1283.m16854("nf_log_apm", "UI browse startup session end event posted.");
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1491(boolean z, IClientLogging.ModalView modalView, String str) {
        C1473aE aEVar = new C1473aE();
        this.f11396.put(str, aEVar);
        this.f11389.mo4786(aEVar);
        C1283.m16854("nf_log_apm", "UI modeless session start event posting...");
        C1494aY r3 = aEVar.m5369(z, modalView);
        m12207(r3, this.f11386, this.f11392);
        this.f11389.mo4783(r3);
        C1283.m16854("nf_log_apm", "UI modeless session start event posted.");
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1488(String str) {
        C1473aE aEVar = this.f11396.get(str);
        if (aEVar != null) {
            C1283.m16854("nf_log_apm", "UI modeless session ended");
            this.f11389.mo4785(aEVar);
            C1283.m16854("nf_log_apm", "UI modeless session end event posting...");
            C1554bc r3 = aEVar.m5370();
            m12207(r3, this.f11386, this.f11392);
            this.f11389.mo4783(r3);
            C1283.m16854("nf_log_apm", "UI modeless session end event posted.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12248(String str, long j) {
        this.f11389.mo4783(new PreAppWidgetInstallEvent(PreAppWidgetInstallEvent.WidgetInstallAction.ADD, str, j));
        C1283.m16854("nf_log_apm", "preapp add widget done");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12231(String str, long j) {
        this.f11389.mo4783(new PreAppWidgetInstallEvent(PreAppWidgetInstallEvent.WidgetInstallAction.DELETE, str, j));
        C1283.m16854("nf_log_apm", "preapp delete widget done");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12243(String str) {
        this.f11389.mo4783(new C1470aB(str));
        C1283.m16854("nf_log_apm", "local setting event done");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12235(boolean z, IClientLogging.ModalView modalView) {
        this.f11392 = modalView;
        C1553bb bbVar = new C1553bb(z, modalView);
        m12207(bbVar, this.f11386, this.f11392);
        this.f11389.mo4783(bbVar);
        C1283.m16854("nf_log_apm", "UI impression event event posted.");
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ॱ */
    public void mo1497(boolean z, IClientLogging.ModalView modalView) {
        this.f11392 = modalView;
        C1552ba baVar = new C1552ba(z, modalView);
        m12207(baVar, this.f11386, this.f11392);
        this.f11389.mo4783(baVar);
        C1283.m16854("nf_log_apm", "UI view changed event posted.");
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˋ */
    public void mo1484(boolean z, IClientLogging.ModalView modalView, long j) {
        this.f11392 = modalView;
        C1552ba baVar = new C1552ba(z, modalView);
        baVar.setTime(j);
        m12207(baVar, this.f11386, this.f11392);
        this.f11389.mo4783(baVar);
        C1283.m16854("nf_log_apm", "UI view changed event posted.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m12249(String str, String str2) {
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_log_apm", "Data request session: url is empty, can not create session!");
            return false;
        } else if (C1349Bv.m4113(str2)) {
            C1283.m16850("nf_log_apm", "Data request session: requestId is empty, can not create session!");
            return false;
        } else if (!this.f11389.m5170("uiQOE.uiDataRequest")) {
            C1283.m16854("nf_log_apm", "Data request started. Data request tracking is not enabled. Done.");
            return false;
        } else {
            C1477aI aIVar = new C1477aI(str, str2);
            this.f11389.mo4786(aIVar);
            this.f11402.put(str2, aIVar);
            C1283.m16854("nf_log_apm", "Data session start done.");
            return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12238(String str, List<FalkorPathResult> list, IClientLogging.CompletionReason completionReason, HttpResponse httpResponse, Error error) {
        C1477aI remove = this.f11402.remove(str);
        if (remove != null) {
            C1283.m16854("nf_log_apm", "Data request session ended");
            this.f11389.mo4785(remove);
            C1283.m16854("nf_log_apm", "Data request session end event posting...");
            C1493aX r3 = remove.m5380(completionReason, httpResponse, error);
            m12207(r3, this.f11386, this.f11392);
            this.f11389.mo4783(r3);
            C1283.m16854("nf_log_apm", "Data request session end event posted.");
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ॱ */
    public String mo1495(String str, AssetType assetType, String str2) {
        if (this.f11387.get(str) != null) {
            return null;
        }
        if (!this.f11389.m5170("uiQOE.uiAssetRequest")) {
            C1283.m16854("nf_log_apm", "Asset request started. Asset request tracking is not enabled. Done.");
            return null;
        }
        C1283.m16851("nf_log_apm", "startAssetRequestSession %s", str);
        C1474aF aFVar = new C1474aF(str, assetType, str2);
        this.f11389.mo4786(aFVar);
        this.f11387.put(str, aFVar);
        C1283.m16854("nf_log_apm", "Asset session start done.");
        return str;
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ॱ */
    public boolean mo1499(String str) {
        return this.f11395.containsKey(str) || this.f11387.get(str) != null;
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1490(String str, JSONObject jSONObject) {
        C1283.m16851("nf_log_apm", "setUiAssetNetworkStats %s", str);
        C1474aF aFVar = this.f11387.get(str);
        if (aFVar == null) {
            aFVar = this.f11395.get(str);
        }
        if (aFVar == null) {
            C1283.m16851("nf_log_apm", "setUiAssetNetworkStats session not found for %s", str);
        } else {
            aFVar.m5371(jSONObject);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˎ */
    public void mo1489(String str, IClientLogging.CompletionReason completionReason, HttpResponse httpResponse, Error error, String str2) {
        C1474aF remove = this.f11387.remove(str);
        if (remove != null) {
            C1283.m16851("nf_log_apm", "endAssetRequestSession %s", str);
            C1489aU r6 = remove.m5373();
            if (r6 == null) {
                r6 = remove.m5374(completionReason, httpResponse, error, str2);
                m12207(r6, this.f11386, this.f11392);
                remove.m5375(r6);
            }
            if (remove.m5376()) {
                C1283.m16854("nf_log_apm", "endAssetRequestSession waiting for NetworkStats");
                this.f11395.put(str, remove);
                this.f11394.schedule(this.f11398, 10000, TimeUnit.MILLISECONDS);
                return;
            }
            m12212(remove, r6);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12212(C1474aF aFVar, C1489aU aUVar) {
        this.f11389.mo4785(aFVar);
        C1283.m16854("nf_log_apm", "UIAssetRequestSession end event posting...");
        this.f11389.mo4783(aUVar);
        C1283.m16854("nf_log_apm", "UIAssetRequestSession end event posted.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m12232() {
        return this.f11393 != null;
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ॱ */
    public void mo1496(Event event) {
        m12207(event, this.f11386, this.f11392);
        this.f11389.mo4783(event);
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˋ */
    public void mo1483(C1626cr crVar) {
        SessionStartedEvent r2 = crVar.m5960();
        this.f11389.mo4786(crVar);
        m12207(r2, this.f11386, this.f11392);
        this.f11389.mo4783(r2);
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˏ */
    public void mo1494(C1626cr crVar) {
        SessionEndedEvent r2 = crVar.m5961();
        m12207(r2, this.f11386, this.f11392);
        this.f11389.mo4785(crVar);
        this.f11389.mo4783(r2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12244(String str, int i) {
        this.f11389.mo4783(new C1501af(str, i));
        C1283.m16854("nf_log_apm", "AB test loaded event done");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12237(String str, int i) {
        this.f11389.mo4783(new C1503ah(str, i));
        C1283.m16854("nf_log_apm", "AB test received event done");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12233() {
        this.f11389.mo4783(new C1502ag());
        C1283.m16854("nf_log_apm", "All AB config data loaded event done");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12236() {
        this.f11389.mo4783(new C1504ai());
        C1283.m16854("nf_log_apm", "All AB config data received event done");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12239(C1359Ce ce) {
        this.f11386 = ce;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12207(Event event, C1359Ce ce, IClientLogging.ModalView modalView) {
        if (event != null) {
            event.setDataContext(ce);
            event.setModalView(modalView);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m12240(Intent intent, boolean z) {
        String action = intent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case -1265811207:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_AB_TEST_LOADED_EVENT")) {
                    c = 11;
                    break;
                }
                break;
            case -271475386:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_DATA_REQUEST_STARTED")) {
                    c = 0;
                    break;
                }
                break;
            case -265472107:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_AB_TEST_RECEIVED_EVENT")) {
                    c = '\f';
                    break;
                }
                break;
            case 106923713:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_PREAPP_DELETE_WIDGET")) {
                    c = 7;
                    break;
                }
                break;
            case 232550649:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_PREAPP_ADD_WIDGET")) {
                    c = 6;
                    break;
                }
                break;
            case 505806412:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_AB_CONFIG_DATA_LOADED_EVENT")) {
                    c = '\r';
                    break;
                }
                break;
            case 508138771:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_DIALOG_REMOVED")) {
                    c = 3;
                    break;
                }
                break;
            case 699566579:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_LOCAL_SETTINGS_BW")) {
                    c = '\n';
                    break;
                }
                break;
            case 1136189369:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_DATA_SHARED_CONTEXT_SESSION_STARTED")) {
                    c = '\b';
                    break;
                }
                break;
            case 1219569424:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_UI_MODAL_VIEW_IMPRESSION")) {
                    c = 5;
                    break;
                }
                break;
            case 1452010536:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_AB_CONFIG_DATA_RECEIVED_EVENT")) {
                    c = 14;
                    break;
                }
                break;
            case 1743034559:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_DATA_REQUEST_ENDED")) {
                    c = 1;
                    break;
                }
                break;
            case 1882536685:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_UI_MODAL_VIEW_CHANGED")) {
                    c = 4;
                    break;
                }
                break;
            case 1955271892:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_DIALOG_DISPLAYED")) {
                    c = 2;
                    break;
                }
                break;
            case 2039471090:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_APM_DATA_SHARED_CONTEXT_SESSION_ENDED")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                m12217(intent);
                return true;
            case 1:
                m12197(intent);
                return true;
            case 2:
                m12204(intent, z);
                return true;
            case 3:
                m12203(intent);
                return true;
            case 4:
                m12198(intent, z);
                return true;
            case 5:
                m12210(intent, z);
                return true;
            case 6:
                m12195(intent);
                return true;
            case 7:
                m12224(intent);
                return true;
            case '\b':
                m12206(intent);
                return true;
            case '\t':
                m12209(intent);
                return true;
            case '\n':
                m12227(intent);
                return true;
            case 11:
                m12193(intent);
                return true;
            case '\f':
                m12196(intent);
                return true;
            case '\r':
                m12222(intent);
                return true;
            case 14:
                m12215(intent);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12206(Intent intent) {
        C1283.m16854("nf_log_apm", "SHARED_CONTEXT_SESSION_STARTED");
        m12234(intent.getStringExtra("uuid"));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12209(Intent intent) {
        C1283.m16854("nf_log_apm", "SHARED_CONTEXT_SESSION_ENDED");
        m12230();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12204(Intent intent, boolean z) {
        C1283.m16854("nf_log_apm", "DIALOG_DISPLAYED");
        mo1491(z, IClientLogging.ModalView.valueOf(intent.getStringExtra("dialog_type")), intent.getStringExtra("dialog_id"));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12203(Intent intent) {
        C1283.m16854("nf_log_apm", "DIALOG_REMOVED");
        mo1488(intent.getStringExtra("dialog_id"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12217(Intent intent) {
        C1283.m16854("nf_log_apm", "Handle data request started intent. Running it on main thread.");
        m12249(intent.getStringExtra("url"), intent.getStringExtra("request_id"));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12197(Intent intent) {
        C1283.m16854("nf_log_apm", "Handle data request ended intent. Running it on main thread.");
        String stringExtra = intent.getStringExtra("request_id");
        IClientLogging.CompletionReason valueOf = IClientLogging.CompletionReason.valueOf(intent.getStringExtra("reason"));
        UIError uIError = null;
        HttpResponse httpResponse = null;
        List<FalkorPathResult> list = null;
        try {
            uIError = Error.createInstance(intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE));
            httpResponse = HttpResponse.createInstance(intent.getStringExtra("http_response"));
            list = FalkorPathResult.createList(intent.getStringExtra("falkorPathResults"));
        } catch (Exception e) {
            C1283.m16847("nf_log_apm", "Failed to parse properties", e);
        }
        m12238(stringExtra, list, valueOf, httpResponse, uIError);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12198(Intent intent, boolean z) {
        C1283.m16854("nf_log_apm", "UI_MODAL_VIEW_CHANGED");
        mo1497(z, IClientLogging.ModalView.valueOf(intent.getStringExtra("view")));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12210(Intent intent, boolean z) {
        C1283.m16854("nf_log_apm", "UI_MODAL_VIEW_IMPRESSION_EVENT");
        m12235(z, IClientLogging.ModalView.valueOf(intent.getStringExtra("view")));
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m12195(Intent intent) {
        C1283.m16854("nf_log_apm", "PREAPP_ADD_WIDGET");
        m12248(intent.getStringExtra("widgetData"), intent.getLongExtra("eventTime", System.currentTimeMillis()));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m12224(Intent intent) {
        C1283.m16854("nf_log_apm", "PREAPP_DELETE_WIDGET");
        m12231(intent.getStringExtra("widgetData"), intent.getLongExtra("eventTime", System.currentTimeMillis()));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m12227(Intent intent) {
        C1283.m16854("nf_log_apm", "LOCAL_SETTINGS_CHANGE_BANDWIDTH");
        m12243(intent.getStringExtra("localSettingData"));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m12193(Intent intent) {
        C1283.m16854("nf_log_apm", "AB_TEST_LOADED_EVENT");
        m12244(intent.getStringExtra("ABTestID"), intent.getIntExtra("ABTestCellID", -1));
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m12196(Intent intent) {
        C1283.m16854("nf_log_apm", "AB_TEST_RECEIVED_EVENT");
        m12237(intent.getStringExtra("ABTestID"), intent.getIntExtra("ABTestCellID", -1));
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m12215(Intent intent) {
        C1283.m16854("nf_log_apm", "AB_CONFIG_DATA_RECEIVED_EVENT");
        m12236();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m12222(Intent intent) {
        C1283.m16854("nf_log_apm", "AB_CONFIG_DATA_LOADED_EVENT");
        m12233();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public IClientLogging.ModalView m12241() {
        return this.f11392;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m12226() {
        m12211(new C1480aL(), this.f11386, this.f11392);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12211(AbstractC1472aD aDVar, C1359Ce ce, IClientLogging.ModalView modalView) {
        AbstractC1472aD aDVar2 = this.f11390.get(aDVar.mo5364());
        if (aDVar2 != null) {
            this.f11389.mo4785(aDVar2);
        }
        this.f11390.put(aDVar.mo5364(), aDVar);
        this.f11389.mo4786(aDVar);
        Event r3 = aDVar.mo5368();
        m12207(r3, ce, modalView);
        this.f11389.mo4783(r3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12218(String str, C1359Ce ce, IClientLogging.ModalView modalView) {
        AbstractC1472aD aDVar = this.f11390.get(str);
        if (aDVar != null) {
            this.f11389.mo4785(aDVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m12223() {
        m12218("wiredNetworkConnection", this.f11386, this.f11392);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m12201() {
        m12211(new C1479aK(), this.f11386, this.f11392);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m12205() {
        m12218("wifiNetworkConnection", this.f11386, this.f11392);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m12214() {
        m12211(new C1471aC(), this.f11386, this.f11392);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m12216() {
        m12218("mobileNetworkConnection", this.f11386, this.f11392);
    }

    @Override // com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging
    /* renamed from: ˏ */
    public void mo1493(Context context) {
        this.f11397.m12252(context);
    }

    /* renamed from: o.w$ˊ  reason: contains not printable characters */
    class C0248 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean f11404;

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f11405;

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f11407;

        private C0248() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m12252(Context context) {
            C1283.m16854("nf_log_apm", "handleConnectivityChange started");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                C1283.m16865("nf_log_apm", "Connectivity manager is gone! Connectivity is lost!");
                m12250();
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                C1283.m16865("nf_log_apm", "Connectivity manager exist, but no active connection! Connectivity is lost!");
                m12250();
                return;
            }
            boolean isConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
            int type = activeNetworkInfo.getType();
            switch (type) {
                case 0:
                case 6:
                    this.f11404 = false;
                    this.f11405 = isConnectedOrConnecting;
                    this.f11407 = false;
                    if (isConnectedOrConnecting) {
                        C2257w.this.m12214();
                    } else {
                        C2257w.this.m12216();
                    }
                    C2257w.this.m12223();
                    C2257w.this.m12205();
                    return;
                case 1:
                    this.f11404 = isConnectedOrConnecting;
                    this.f11405 = false;
                    this.f11407 = false;
                    if (isConnectedOrConnecting) {
                        C2257w.this.m12201();
                    } else {
                        C2257w.this.m12205();
                    }
                    C2257w.this.m12223();
                    C2257w.this.m12216();
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                default:
                    C1283.m16854("nf_log_apm", "Not supported network type " + type);
                    return;
                case 9:
                    this.f11404 = false;
                    this.f11405 = false;
                    this.f11407 = isConnectedOrConnecting;
                    if (isConnectedOrConnecting) {
                        C2257w.this.m12226();
                    } else {
                        C2257w.this.m12223();
                    }
                    C2257w.this.m12205();
                    C2257w.this.m12216();
                    return;
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m12250() {
            m12251();
            C2257w.this.m12223();
            C2257w.this.m12205();
            C2257w.this.m12216();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m12251() {
            this.f11404 = false;
            this.f11405 = false;
            this.f11407 = false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12234(String str) {
        if (str == null) {
            throw new IllegalArgumentException("UUID can not be null!");
        } else if (this.f11385 != null) {
            C1283.m16850("nf_log_apm", "Shared context session already exist, we do not recreate it!");
        } else {
            C1283.m16854("nf_log_apm", "Shared context session created");
            this.f11385 = new C1476aH(str);
            this.f11389.mo4786(this.f11385);
            this.f11389.mo4783(this.f11385.m5379());
            C1283.m16854("nf_log_apm", "Shared context start done.");
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m12230() {
        if (this.f11385 != null) {
            C1283.m16854("nf_log_apm", "Shared context session ended");
            C1486aR r2 = this.f11385.m5378();
            C1283.m16854("nf_log_apm", "Shared context session end event posting...");
            this.f11389.mo4783(r2);
            this.f11389.mo4785(this.f11385);
            this.f11385 = null;
            C1283.m16854("nf_log_apm", "Shared context session end done.");
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public synchronized void m12229() {
        this.f11401.set(true);
        m12216();
        m12205();
        m12223();
        m12230();
        mo1485(0L, true, (UIError) null);
        m12245(true, (UIError) null);
        HashSet<String> hashSet = new HashSet(this.f11402.size());
        hashSet.addAll(this.f11402.keySet());
        for (String str : hashSet) {
            m12238(str, (List<FalkorPathResult>) null, IClientLogging.CompletionReason.canceled, (HttpResponse) null, (Error) null);
        }
        HashSet<String> hashSet2 = new HashSet(this.f11387.size());
        hashSet2.addAll(this.f11387.keySet());
        for (String str2 : hashSet2) {
            mo1489(str2, IClientLogging.CompletionReason.canceled, (HttpResponse) null, (Error) null, (String) null);
        }
        HashSet<String> hashSet3 = new HashSet(this.f11396.size());
        hashSet3.addAll(this.f11396.keySet());
        for (String str3 : hashSet3) {
            mo1488(str3);
        }
        this.f11402.clear();
        this.f11387.clear();
        this.f11390.clear();
        this.f11396.clear();
        m12242(ApplicationPerformanceMetricsLogging.EndReason.logout, System.currentTimeMillis());
        m12246();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m12228() {
        return this.f11401.get();
    }
}
