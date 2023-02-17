package com.netflix.mediaclient.service.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IVoip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import o.AbstractC1052;
import o.AbstractC1156;
import o.AbstractC1221;
import o.AbstractC2027oc;
import o.AbstractC2033oi;
import o.C0501;
import o.C0504;
import o.C0510;
import o.C1281;
import o.C1283;
import o.C1349Bv;
import o.C1356Cb;
import o.C2026ob;
import o.nZ;
import o.oS;
import o.qA;
import org.json.JSONException;
import org.json.JSONObject;
public abstract class BaseVoipEngine implements IVoip {

    /* renamed from: ˉ  reason: contains not printable characters */
    private static final ThreadFactory f2306 = new ThreadFactory() { // from class: com.netflix.mediaclient.service.voip.BaseVoipEngine.2

        /* renamed from: ॱ  reason: contains not printable characters */
        private final AtomicInteger f2332 = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "VoipTask #" + this.f2332.getAndIncrement());
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    protected AbstractC2033oi f2307;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected nZ f2308;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected List<IVoip.If> f2309 = Collections.synchronizedList(new ArrayList());

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected AtomicBoolean f2310 = new AtomicBoolean(false);

    /* renamed from: ʽ  reason: contains not printable characters */
    protected BroadcastReceiver f2311;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected Handler f2312 = new Handler(Looper.getMainLooper());

    /* renamed from: ʾ  reason: contains not printable characters */
    protected Runnable f2313 = new Runnable() { // from class: com.netflix.mediaclient.service.voip.BaseVoipEngine.5
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("nf_voip", "Back to landing page!");
            BaseVoipEngine.this.f2310.set(false);
            if (BaseVoipEngine.this.f2309 != null) {
                for (IVoip.If r0 : BaseVoipEngine.this.f2309) {
                    r0.mo1548(BaseVoipEngine.this.f2323);
                }
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    protected AudioManager.OnAudioFocusChangeListener f2314 = new AudioManager.OnAudioFocusChangeListener() { // from class: com.netflix.mediaclient.service.voip.BaseVoipEngine.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    protected AtomicBoolean f2315 = new AtomicBoolean(false);

    /* renamed from: ˊ  reason: contains not printable characters */
    protected AbstractC1221 f2316;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected long f2317;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected UserAgentInterface f2318;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected ServiceState f2319 = ServiceState.NOT_STARTED;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected oS f2320;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected AbstractC1156 f2321;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected C2026ob f2322;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected IVoip.Cif f2323 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected Context f2324;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected IVoip.ConnectivityState f2325 = IVoip.ConnectivityState.NO_CONNECTION;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected Long f2326;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected AudioManager f2327;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected AbstractC2027oc f2328;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected AtomicBoolean f2329 = new AtomicBoolean(false);

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected VoipCallConfigData f2330;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected UUID f2331;

    public enum ServiceState {
        NOT_STARTED,
        STARTING,
        STARTED,
        STOPPING,
        STOPPED
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract BroadcastReceiver mo1438();

    public BaseVoipEngine(Context context, AbstractC1156 r4, oS oSVar, UserAgentInterface userAgentInterface, AbstractC1221 r7, VoipCallConfigData voipCallConfigData) {
        this.f2324 = context;
        this.f2321 = r4;
        this.f2320 = oSVar;
        this.f2318 = userAgentInterface;
        this.f2316 = r7;
        this.f2330 = voipCallConfigData;
        this.f2322 = new C2026ob(context, (AbstractC1052) r4);
        this.f2328 = ((qA) C1281.m16832(qA.class)).mo3695(context);
        this.f2327 = (AudioManager) context.getSystemService("audio");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1436(VoipCallConfigData voipCallConfigData) {
        this.f2330 = voipCallConfigData;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m1441() {
        return this.f2316 == null || !((AbstractC1052) this.f2316).r_() || !this.f2316.q_();
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo1434(IVoip.If r3) {
        if (this.f2309.contains(r3)) {
            C1283.m16865("nf_voip", "Listener is already added!");
        } else {
            this.f2309.add(r3);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized boolean mo1431(IVoip.If r2) {
        return this.f2309.remove(r2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m1433() {
        C1283.m16854("nf_voip", "--- DESTROY VOIP engine");
        this.f2314 = null;
        this.f2313 = null;
        this.f2311 = null;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˊ  reason: contains not printable characters */
    public long mo1430() {
        return this.f2317;
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo1437() {
        return this.f2310.get();
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean mo1446() {
        return this.f2325 != IVoip.ConnectivityState.NO_CONNECTION && m1441();
    }

    @Override // com.netflix.mediaclient.servicemgr.IVoip
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean mo1428() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m1445() {
        return "sip:" + this.f2330.getCallAttributes().getDesinationNumber() + "@" + this.f2330.getCallAttributes().getDestinationAddress() + ":" + this.f2330.getCallAttributes().getDestinationPORT();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m1429() {
        C1283.m16854("nf_voip", "Registering VOIP receiver...");
        if (this.f2324 == null) {
            C1283.m16854("nf_voip", "Context is null, nothing to register.");
            return;
        }
        this.f2324.registerReceiver(mo1438(), m1421());
        C1283.m16854("nf_voip", "Registered VOIP receiver");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static IntentFilter m1421() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.CALL_CANCEL");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.VOIP");
        intentFilter.setPriority(999);
        return intentFilter;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m1423(String str) {
        return "com.netflix.mediaclient.intent.action.CALL_CANCEL".equalsIgnoreCase(str);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m1432() {
        if (this.f2324 == null) {
            C1283.m16854("nf_voip", "Context is null, nothing to unregister.");
            return;
        }
        try {
            C1283.m16854("nf_voip", "Unregistering VOIP receiver...");
            this.f2324.unregisterReceiver(mo1438());
            C1283.m16854("nf_voip", "Unregistered VOIP receiver");
        } catch (Exception e) {
            C1283.m16854("nf_voip", "unregister VOIP receiver  " + e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m1439() {
        if (this.f2327 == null) {
            return;
        }
        if (this.f2327.getMode() == 3) {
            C1283.m16854("nf_voip", "[AudioManager] already in MODE_IN_COMMUNICATION, skipping...");
            return;
        }
        C1283.m16854("nf_voip", "[AudioManager] Mode: MODE_IN_COMMUNICATION");
        this.f2327.setMode(3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m1442() {
        if (this.f2329.getAndSet(true)) {
            C1283.m16865("nf_voip", "Already asked for audip focus...");
            return;
        }
        AudioManager audioManager = (AudioManager) this.f2324.getSystemService("audio");
        if (audioManager != null) {
            try {
                audioManager.requestAudioFocus(this.f2314, 0, 1);
            } catch (Throwable th) {
                C1283.m16847("nf_voip", "Failed to request audio focus", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public void m1440() {
        if (this.f2329.getAndSet(false)) {
            C1283.m16854("nf_voip", "We had audio focus, release it.");
            AudioManager audioManager = (AudioManager) this.f2324.getSystemService("audio");
            if (audioManager != null) {
                try {
                    audioManager.abandonAudioFocus(this.f2314);
                } catch (Throwable th) {
                    C1283.m16847("nf_voip", "Failed to request audio focus release", th);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m1435() {
        this.f2325 = IVoip.ConnectivityState.GREEN;
        this.f2328.mo3629(this.f2320, this.f2312);
        C1356Cb.m4340(CustomerServiceLogging.CallQuality.green);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void m1443() {
        CustomerServiceLogging.TerminationReason terminationReason;
        if (this.f2325 != IVoip.ConnectivityState.NO_CONNECTION) {
            terminationReason = CustomerServiceLogging.TerminationReason.failedAfterConnected;
        } else {
            terminationReason = CustomerServiceLogging.TerminationReason.failedBeforeConnected;
        }
        C1356Cb.m4342(terminationReason, IClientLogging.CompletionReason.failed, m1424(terminationReason, null, "networkFailed"));
        Logger.INSTANCE.m130("cs.CallCommand");
        Logger.INSTANCE.m147(C0504.m14366(this.f2326, m1422(terminationReason, null, "networkFailed")));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m1447() {
        CustomerServiceLogging.TerminationReason terminationReason;
        Logger.INSTANCE.m130("cs.CallCommand");
        if (this.f2325 != IVoip.ConnectivityState.NO_CONNECTION) {
            terminationReason = CustomerServiceLogging.TerminationReason.canceledByUserAfterConnected;
        } else {
            terminationReason = CustomerServiceLogging.TerminationReason.canceledByUserBeforeConnected;
        }
        Logger.INSTANCE.m147(C0504.m14486(this.f2326, m1425(terminationReason)));
        C1356Cb.m4342(terminationReason, IClientLogging.CompletionReason.canceled, (Error) null);
        this.f2325 = IVoip.ConnectivityState.NO_CONNECTION;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m1425(CustomerServiceLogging.TerminationReason terminationReason) {
        JSONObject jSONObject = null;
        if (this.f2307 != null) {
            try {
                jSONObject = new JSONObject(this.f2307.m9654());
                if (terminationReason != null) {
                    jSONObject.put("terminationReason", terminationReason.name());
                }
            } catch (JSONException e) {
                C1283.m16856("nf_voip", e, "Failed to create call stats JSON!", new Object[0]);
            }
        } else {
            try {
                jSONObject = new JSONObject();
                if (terminationReason != null) {
                    jSONObject.put("terminationReason", terminationReason.name());
                }
            } catch (JSONException e2) {
                C1283.m16856("nf_voip", e2, "Failed to create call stats JSON!", new Object[0]);
            }
        }
        return jSONObject;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public void m1444() {
        if (this.f2321 != null) {
            this.f2321.mo9648(this.f2330.getUserToken(), this.f2307);
        }
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected static void m1427() {
        Process.setThreadPriority(10);
        Process.setThreadPriority(-19);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m1426(VoipCallConfigData voipCallConfigData) {
        return voipCallConfigData != null && voipCallConfigData.getCallAttributes() != null && C1349Bv.m4107(voipCallConfigData.getCallAttributes().getDesinationNumber()) && C1349Bv.m4107(voipCallConfigData.getCallAttributes().getDestinationPORT()) && C1349Bv.m4107(voipCallConfigData.getCallAttributes().getDestinationAddress());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static Error m1424(CustomerServiceLogging.TerminationReason terminationReason, Integer num, String str) {
        ArrayList arrayList = new ArrayList();
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        arrayList.add(deepErrorElement);
        deepErrorElement.setFatal(true);
        deepErrorElement.setErrorCode(String.valueOf(num));
        DeepErrorElement.Debug debug = new DeepErrorElement.Debug();
        try {
            JSONObject jSONObject = new JSONObject();
            if (num != null) {
                jSONObject.put("sipCode", num);
            }
            if (C1349Bv.m4107(str)) {
                jSONObject.put("reason", str);
            }
            debug.setMessage(jSONObject);
        } catch (JSONException e) {
        }
        deepErrorElement.setDebug(debug);
        return new Error(RootCause.clientFailure, arrayList);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static C0510 m1422(CustomerServiceLogging.TerminationReason terminationReason, String str, String str2) {
        C0501 r1 = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sipCode", str);
            if (C1349Bv.m4107(str2)) {
                jSONObject.put("reason", str2);
            }
            r1 = new C0501(jSONObject);
        } catch (JSONException e) {
        }
        return new C0510(str2, r1);
    }
}
