package o;

import android.os.Handler;
import android.os.HandlerThread;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.api.diagnostics.IDiagnosis;
import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* renamed from: o.b  reason: case insensitive filesystem */
public class C1524b extends AbstractC1052 implements IDiagnosis {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6104 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    private HandlerThread f6105;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Handler f6106;

    /* renamed from: ˏ  reason: contains not printable characters */
    private IDiagnosis.AbstractC0014 f6107 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ArrayList<C1072> f6108 = new ArrayList<>();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private nW f6109;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m5706() {
        if (this.f6105 == null) {
            this.f6105 = new HandlerThread("nf_nw_diag");
            this.f6105.start();
        }
        if (this.f6106 == null) {
            this.f6106 = new Handler(this.f6105.getLooper());
        }
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m5704() {
        if (this.f6105 != null) {
            this.f6105.quit();
            this.f6105 = null;
        }
        if (this.f6106 != null) {
            this.f6106.removeCallbacksAndMessages(null);
            this.f6106 = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        this.f6109 = new nW(m16093(), m16101());
        m16090(AbstractC0367.f13235);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5708(final C1072 r3) {
        C1283.m16862("nf_service_diagnosisagent", "runNetworkConnectivityTest");
        if (this.f6106 != null) {
            r3.m16149(IDiagnosis.UrlStatus.TEST_ONGOING);
            if (this.f6107 != null) {
                this.f6107.mo501();
            }
            this.f6106.post(new Runnable() { // from class: o.b.4
                @Override // java.lang.Runnable
                public void run() {
                    HttpURLConnection httpURLConnection = null;
                    int r32 = StatusCode.OK.m271();
                    int i = r32;
                    int i2 = r32;
                    boolean z = true;
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(r3.m16150()).openConnection();
                        do {
                        } while (new BufferedInputStream(httpURLConnection2.getInputStream()).read(new byte[1024]) >= 0);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (MalformedURLException e) {
                        C1283.m16847("nf_service_diagnosisagent", "invalid URL:", e);
                        int r8 = StatusCode.NET_MALFORMED_URL_ERROR.m271();
                        i = r8;
                        i2 = r8;
                        z = false;
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                    } catch (IOException e2) {
                        C1283.m16847("nf_service_diagnosisagent", "IOError:", e2);
                        int r82 = StatusCode.NET_NETWORK_IO_EXCEPTION.m271();
                        i = r82;
                        i2 = r82;
                        z = false;
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                    r3.m16145(i);
                    r3.m16144(i2);
                    r3.m16146(z);
                    r3.m16149(IDiagnosis.UrlStatus.COMPLETED);
                    C1524b.this.m5710();
                }
            });
        }
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean m5709() {
        Iterator<C1072> it = this.f6108.iterator();
        while (it.hasNext()) {
            if (!it.next().m16147()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m5710() {
        C1283.m16862("nf_service_diagnosisagent", "notifyDiagnosisComplete");
        m5704();
        if (this.f6107 != null && this.f6104) {
            this.f6107.mo502();
            try {
                m16086().mo1512().mo5226(new C0104(this.f6108, m5709() ? Logblob.Severity.info : Logblob.Severity.error));
            } catch (JSONException e) {
                C1283.m16850("nf_service_diagnosisagent", "JSONException:");
            }
        }
        this.f6104 = false;
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis
    /* renamed from: ˎ */
    public void mo499(IDiagnosis.AbstractC0014 r1) {
        this.f6107 = r1;
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis
    /* renamed from: ˊ */
    public void mo496() {
        this.f6107 = null;
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis
    /* renamed from: ˎ */
    public void mo498() {
        C1283.m16862("nf_service_diagnosisagent", "startNetworkDiagnosis");
        mo500();
        m5706();
        this.f6104 = true;
        String externalForm = m16101().mo16547().mo9651("").toExternalForm();
        C1283.m16863("nf_service_diagnosisagent", "apiUrl=%s", externalForm);
        this.f6108.add(new C1072(externalForm, IDiagnosis.UrlStatus.NOT_TESTED));
        this.f6108.add(new C1072("http://www.google.com", IDiagnosis.UrlStatus.NOT_TESTED));
        final C1072 r5 = this.f6108.get(0);
        r5.m16149(IDiagnosis.UrlStatus.TEST_ONGOING);
        if (this.f6107 != null) {
            this.f6107.mo501();
        }
        m16101().mo16524(m16101().mo16511(), new C0452() { // from class: o.b.2
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo5712(Status status) {
                int r3 = status.mo302().m271();
                r5.m16145(r3);
                r5.m16144(r3);
                r5.m16146(status.mo298());
                r5.m16149(IDiagnosis.UrlStatus.COMPLETED);
                if (C1524b.this.f6108.size() >= 2) {
                    C1524b.this.m5708((C1072) C1524b.this.f6108.get(1));
                }
            }
        });
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis
    /* renamed from: ॱ */
    public void mo500() {
        C1283.m16854("nf_service_diagnosisagent", "abortDiagnosis");
        this.f6104 = false;
        this.f6108.clear();
        m5704();
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis
    /* renamed from: ˋ */
    public List<C1072> mo497() {
        return this.f6108;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.b$ˊ  reason: contains not printable characters */
    public class C0104 extends AbstractC1542bQ {
        public C0104(List<C1072> list, Logblob.Severity severity) {
            JSONArray jSONArray = new JSONArray();
            for (C1072 r0 : list) {
                jSONArray.put(r0.m16151());
            }
            this.f6135 = severity;
            this.f6134.put("name", "NetworkDiagnostics");
            this.f6134.put(NetflixActivity.EXTRA_SOURCE, "DiagnosticPage");
            this.f6134.put("resultArray", jSONArray);
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˋ */
        public String mo680() {
            return LogBlobType.NETWORK_DIAGNOSIS.m602();
        }

        @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˏ */
        public boolean mo1556() {
            return true;
        }
    }
}
