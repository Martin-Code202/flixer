package o;

import android.content.Context;
import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import o.BP;
import org.json.JSONObject;
public class V extends AbstractC2362z {

    /* renamed from: ʼ  reason: contains not printable characters */
    private BP f5828;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final List<String> f5829 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f5830;

    /* renamed from: ˋ  reason: contains not printable characters */
    private UserAgentInterface f5831;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0102 f5832 = new C0102();

    /* renamed from: ˏ  reason: contains not printable characters */
    private Handler f5833;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging f5834;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Runnable f5835 = new Runnable() { // from class: o.V.3
        @Override // java.lang.Runnable
        public void run() {
            if (V.this.f5832.m3264()) {
                V.this.f5836.schedule(V.this.f5835, 10, TimeUnit.SECONDS);
                return;
            }
            C1283.m16854("nf_releaseLicense", "Check if we have not delivered events from last time our app was running...");
            V.this.f5828.mo3900(new BP.AbstractC1327iF() { // from class: o.V.3.4
                @Override // o.BP.AbstractC1327iF
                /* renamed from: ॱ */
                public void mo3905(BP.If[] ifArr) {
                    if (ifArr == null || ifArr.length <= 0) {
                        C1283.m16854("nf_releaseLicense", "No saved payloads found.");
                    } else {
                        V.this.m5302(ifArr, false);
                    }
                }
            });
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private ScheduledExecutorService f5836;

    /* renamed from: o.V$iF  reason: case insensitive filesystem */
    public interface AbstractC1467iF {
        /* renamed from: ˊ */
        void mo5307(JSONObject jSONObject, Status status);
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2362z
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5303() {
        if (this.f5832.m3269()) {
            C1283.m16854("nf_releaseLicense", "releaseLicense events were sent recently. We reached timeout, force send");
        }
    }

    public V(IClientLogging iClientLogging, UserAgentInterface userAgentInterface, Context context) {
        if (iClientLogging == null) {
            throw new IllegalStateException("Owner is null?");
        } else if (userAgentInterface == null) {
            throw new IllegalStateException("UserAgent is null?");
        } else {
            this.f5834 = iClientLogging;
            this.f5831 = userAgentInterface;
            this.f5830 = context;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2362z
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5305(ScheduledExecutorService scheduledExecutorService) {
        this.f5836 = scheduledExecutorService;
        m5284();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5284() {
        File file = new File(this.f5830.getFilesDir(), "streamingReleaseLicense");
        file.mkdirs();
        this.f5828 = new BO(file);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5287() {
        if (this.f5832.m3264()) {
            this.f5836.schedule(this.f5835, 10, TimeUnit.SECONDS);
        } else {
            this.f5836.execute(this.f5835);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5302(BP.If[] ifArr, boolean z) {
        if (ifArr == null || ifArr.length < 1) {
            C1283.m16854("nf_releaseLicense", "No saved events found");
            return;
        }
        for (BP.If r8 : ifArr) {
            final String r9 = r8.mo3882();
            if (!this.f5829.contains(r9)) {
                this.f5829.add(r9);
                if (z) {
                    this.f5836.schedule(new Runnable() { // from class: o.V.1
                        @Override // java.lang.Runnable
                        public void run() {
                            V.this.m5298(r9);
                        }
                    }, this.f5834.mo1508(), TimeUnit.MILLISECONDS);
                } else {
                    this.f5836.execute(new Runnable() { // from class: o.V.2
                        @Override // java.lang.Runnable
                        public void run() {
                            V.this.m5298(r9);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5298(final String str) {
        this.f5828.mo3899(str, new BP.AbstractC0068() { // from class: o.V.4
            @Override // o.BP.AbstractC0068
            /* renamed from: ˎ */
            public void mo3907(String str2, String str3, byte[] bArr, long j) {
                if (bArr == null || bArr.length < 1) {
                    C1283.m16850("nf_releaseLicense", "We failed to retrieve payload. Trying to delete it");
                    V.this.m5295(str);
                    return;
                }
                try {
                    V.this.m5299(str3, new String(bArr, "utf-8"), new If(str));
                } catch (Throwable th) {
                    C1283.m16847("nf_releaseLicense", "Failed to send releaseLicense.", th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5299(String str, String str2, AbstractC1467iF iFVar) {
        if (str2 == null) {
            C1283.m16854("nf_releaseLicense", "Nothing to send, payload is null. sendSavedReleaseLicenseEvents done.");
            iFVar.mo5307(null, AbstractC0367.f13235);
            return;
        }
        this.f5834.m1505(AX.m3489(this.f5831, str, new C1588cJ(this.f5830, str2, iFVar), true));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m5288(String str) {
        try {
            return this.f5828.mo3895(String.valueOf(System.currentTimeMillis()), str.getBytes("utf-8"), this.f5831.mo1340());
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5295(String str) {
        try {
            this.f5829.remove(str);
            this.f5828.mo3898(str);
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5296(List<String> list, boolean z) {
        if (list == null || list.size() < 1) {
            C1283.m16854("nf_releaseLicense", "no events to send");
            return;
        }
        for (String str : list) {
            If r4 = null;
            if (z) {
                try {
                    String r5 = m5288(str);
                    this.f5829.add(r5);
                    r4 = new If(r5);
                } catch (Exception e) {
                    C1283.m16847("nf_releaseLicense", "Failed to create JSON object for logging request", e);
                }
            }
            this.f5834.m1505(new C1588cJ(this.f5830, str, r4));
        }
    }

    @Override // o.P
    /* renamed from: ˊ */
    public void mo5229(String str) {
        this.f5832.m3276(str);
    }

    @Override // o.P
    /* renamed from: ˎ */
    public void mo5230(Handler handler) {
        this.f5833 = handler;
    }

    /* access modifiers changed from: package-private */
    public class If implements AbstractC1467iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f5845;

        public If(String str) {
            this.f5845 = str;
        }

        @Override // o.V.AbstractC1467iF
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo5307(JSONObject jSONObject, Status status) {
            if (status.mo298()) {
                C1283.m16854("nf_releaseLicense", "releaseLicense events are successfully sent to backend");
                V.this.m5295(this.f5845);
                V.this.m5293(jSONObject, status);
                return;
            }
            C1283.m16850("nf_releaseLicense", "releaseLicense events are NOT successfully sent to backend, do NOT remove them");
            V.this.f5829.remove(this.f5845);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5293(JSONObject jSONObject, Status status) {
        if (this.f5828 != null) {
            int r2 = status.mo302().m271();
            this.f5833.obtainMessage(6, r2, r2, jSONObject).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.V$ˊ  reason: contains not printable characters */
    public class C0102 extends AC<String> {
        public C0102() {
            super("nf_releaseLicense_queue", false, false);
        }

        /* access modifiers changed from: protected */
        @Override // o.AC
        /* renamed from: ˏ */
        public void mo3277(List<String> list, boolean z) {
            V.this.m5296(list, z);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2362z
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5304() {
        this.f5832.m3270();
        m5287();
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2362z
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5306() {
        if (ConnectivityUtils.m2970(this.f5830)) {
            C1283.m16854("nf_releaseLicense", "Device is connected, lets see if we need to deliver cached events...");
            BP.If[] r5 = this.f5828.mo3901();
            if (r5 != null || r5.length > 0) {
                C1283.m16851("nf_releaseLicense", "We found %d cached log entries, network is connected, lets try to deliver them", Integer.valueOf(r5.length));
                m5302(r5, false);
            }
        }
    }
}
