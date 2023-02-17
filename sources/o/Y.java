package o;

import android.content.Context;
import android.graphics.PointF;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import o.BP;
import org.json.JSONException;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public class Y implements AbstractC2063pl {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ScheduledExecutorService f5860;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final PointF f5861 = new PointF();

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1581cC f5862;

    /* renamed from: ˊ  reason: contains not printable characters */
    private N f5863;

    /* renamed from: ˋ  reason: contains not printable characters */
    private UserAgentInterface f5864;

    /* renamed from: ˎ  reason: contains not printable characters */
    private BP f5865;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0103 f5866;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f5867;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Runnable f5868 = new Runnable() { // from class: o.Y.4
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("nf_presentation", "Check if we have not delivered events from last time our app was runnung...");
            Y.this.f5865.mo3900(new BP.AbstractC1327iF() { // from class: o.Y.4.3
                @Override // o.BP.AbstractC1327iF
                /* renamed from: ॱ */
                public void mo3905(BP.If[] ifArr) {
                    if (ifArr == null || ifArr.length <= 0) {
                        C1283.m16854("nf_presentation", "No saved payloads found.");
                    } else {
                        Y.this.m5333(ifArr);
                    }
                }
            });
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final List<String> f5869 = new ArrayList();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f5870;

    Y(Context context, N n, UserAgentInterface userAgentInterface) {
        this.f5863 = n;
        this.f5867 = context;
        this.f5864 = userAgentInterface;
        this.f5862 = new C1581cC(n.m16101(), userAgentInterface);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5347(ScheduledExecutorService scheduledExecutorService) {
        this.f5870 = true;
        this.f5860 = scheduledExecutorService;
        m5331();
        m5346();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5331() {
        int i = 150;
        int f_ = this.f5863.m16101().f_();
        if (f_ != -1) {
            i = f_;
        }
        this.f5866 = new C0103(i);
    }

    @Override // o.AbstractC2063pl
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5354(final AbstractC2087qh qhVar, final List<String> list, final List<String> list2, final int i, final int i2, final UiLocation uiLocation) {
        if (this.f5870) {
            this.f5860.execute(new Runnable() { // from class: o.Y.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Y.this.f5866.m3276(new C1630cv(qhVar, list, list2, i, i2, uiLocation));
                    } catch (Throwable th) {
                        C1276.m16820().mo5729("Exception while reporting presentation events", th);
                    }
                }
            });
        }
    }

    @Override // o.AbstractC2063pl
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5351(double d, double d2) {
        if (this.f5870) {
            if (d > 0.0d || d2 > 0.0d) {
                synchronized (this.f5861) {
                    PointF pointF = this.f5861;
                    pointF.x = (float) (((double) pointF.x) + d);
                    PointF pointF2 = this.f5861;
                    pointF2.y = (float) (((double) pointF2.y) + d2);
                    C1283.m16851("nf_presentation", "User scrolled %f - %f since last flush", Float.valueOf(this.f5861.x), Float.valueOf(this.f5861.y));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Y$ˋ  reason: contains not printable characters */
    public class C0103 extends AC<C1630cv> {
        public C0103(int i) {
            super("nf_pt_queue", i, 300000, true, true);
        }

        /* access modifiers changed from: protected */
        @Override // o.AC
        /* renamed from: ˏ */
        public void mo3277(List<C1630cv> list, boolean z) {
            Y.this.m5336(list, z);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5336(List<C1630cv> list, boolean z) {
        if (list.size() == 0) {
            C1283.m16854("nf_presentation", "Dropping presentation message - 0 events");
            return;
        }
        m5328();
        C1632cx cxVar = new C1632cx(this.f5867, this.f5863.m16101(), this.f5864);
        cxVar.m5994(list);
        try {
            String jSONObject = cxVar.m5993().toString();
            if (z) {
                String r5 = m5329(jSONObject);
                this.f5869.add(r5);
                m5340(this.f5864.mo1340(), r5, cxVar, new If(jSONObject));
                return;
            }
            m5332(cxVar);
        } catch (Exception e) {
            C1283.m16847("nf_presentation", "Failed to create JSON object for presentation request", e);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5328() {
        try {
            if (this.f5861.x > 0.0f || this.f5861.y > 0.0f) {
                JSONObject jSONObject = new JSONObject();
                synchronized (this.f5861) {
                    jSONObject.put("horizontal", (double) this.f5861.x);
                    jSONObject.put("vertical", (double) this.f5861.y);
                }
                C1362Ch.m4394("onLolomoScroll", (IClientLogging.ModalView) null, jSONObject);
                this.f5861.x = 0.0f;
                this.f5861.y = 0.0f;
            }
        } catch (JSONException e) {
            C1283.m16847("nf_presentation", "Failed to create JSON object for lolomo_scroll cl event", e);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m5346() {
        C1283.m16854("nf_presentation", "PtManager::init data repository started ");
        File file = new File(this.f5867.getFilesDir(), "ptevents");
        file.mkdirs();
        this.f5865 = new BO(file);
        C1283.m16854("nf_presentation", "PtManager::init data repository done ");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5327() {
        if (this.f5866.m3264()) {
            this.f5860.schedule(this.f5868, 15, TimeUnit.SECONDS);
        } else {
            this.f5860.execute(this.f5868);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5355() {
        if (this.f5866.m3269()) {
            C1283.m16854("nf_presentation", "Presentation tracking events were send recently ms. We reached timeout, force send");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m5329(String str) {
        try {
            return this.f5865.mo3895(String.valueOf(System.currentTimeMillis()), str.getBytes("utf-8"), this.f5864.mo1340());
        } catch (Throwable th) {
            C1283.m16847("nf_presentation", "Failed to save payload to repository", th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5335(String str) {
        try {
            this.f5869.remove(str);
            this.f5865.mo3898(str);
        } catch (Throwable th) {
            C1283.m16847("nf_presentation", "Failed to remove payload from repository", th);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5333(BP.If[] ifArr) {
        if (ifArr == null || ifArr.length < 1) {
            C1283.m16854("nf_presentation", "No saved events found");
            return;
        }
        for (BP.If r8 : ifArr) {
            final String r9 = r8.mo3882();
            if (this.f5869.contains(r9)) {
                C1283.m16865("nf_presentation", "We are already trying to deliver %s deliveryRequestId, skip");
            } else {
                this.f5869.add(r9);
                this.f5860.schedule(new Runnable() { // from class: o.Y.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Y.this.m5344(r9);
                    }
                }, this.f5863.mo1508(), TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5344(final String str) {
        this.f5865.mo3899(str, new BP.AbstractC0068() { // from class: o.Y.3
            @Override // o.BP.AbstractC0068
            /* renamed from: ˎ */
            public void mo3907(String str2, String str3, byte[] bArr, long j) {
                if (bArr == null || bArr.length < 1) {
                    C1283.m16850("nf_presentation", "We failed to retrieve payload. Trying to delete it");
                    Y.this.m5335(str);
                    return;
                }
                C1632cx cxVar = new C1632cx();
                try {
                    String str4 = new String(bArr, "utf-8");
                    cxVar.m5992(str4);
                    Y.this.m5340(str3, str, cxVar, new If(str4));
                } catch (Throwable th) {
                    C1283.m16847("nf_presentation", "Failed to send events. Try to delete it.", th);
                    Y.this.m5335(str);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5353() {
        if (this.f5866 != null) {
            this.f5866.m3265();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5352(boolean z) {
        if (this.f5866 != null) {
            this.f5866.m3268(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5350() {
        if (this.f5866 != null) {
            this.f5866.m3270();
            m5327();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5349(boolean z) {
        if (this.f5866 != null) {
            this.f5866.mo3266(z);
        }
    }

    /* access modifiers changed from: package-private */
    public class If implements AbstractC1634cz {
        public If(String str) {
        }

        @Override // o.AbstractC1634cz
        public void onEventsDeliveryFailed(final String str) {
            if (!C1349Bv.m4113(str)) {
                Y.this.f5860.schedule(new Runnable() { // from class: o.Y.If.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Y.this.m5344(str);
                    }
                }, Y.this.f5863.mo1508(), TimeUnit.MILLISECONDS);
            }
        }

        @Override // o.AbstractC1634cz
        public void onEventsDelivered(String str) {
            Y.this.f5863.m5198();
            Y.this.m5335(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5340(String str, String str2, C1632cx cxVar, AbstractC1634cz czVar) {
        NetflixDataRequest r1 = this.f5862.m5812(str, str2, cxVar, czVar);
        if (r1 != null) {
            this.f5863.m16092(r1);
        } else if (czVar != null) {
            czVar.onEventsDelivered(str2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5332(C1632cx cxVar) {
        this.f5863.m16092(this.f5862.m5812(this.f5864.mo1340(), null, cxVar, null));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5348() {
        if (this.f5865 == null) {
            C1283.m16865("nf_presentation", "Presentation tracking not initialized, CLv2 is used.");
        } else if (ConnectivityUtils.m2970(this.f5867)) {
            C1283.m16854("nf_presentation", "Device is connected, lets see if we need to deliver cached events...");
            BP.If[] r5 = this.f5865.mo3901();
            if (r5 != null && r5.length > 0) {
                C1283.m16851("nf_presentation", "We found %d cached log entries, network is connected, lets try to deliver them", Integer.valueOf(r5.length));
                m5333(r5);
            }
        }
    }
}
