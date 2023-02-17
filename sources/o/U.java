package o;

import android.content.Context;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class U extends AbstractC2138s {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<String> f5809 = new ArrayList();

    /* renamed from: ʽ  reason: contains not printable characters */
    private Runnable f5810 = new Runnable() { // from class: o.U.5
        @Override // java.lang.Runnable
        public void run() {
            if (U.this.f5811.m3264()) {
                U.this.f5816.schedule(U.this.f5810, 15, TimeUnit.SECONDS);
                return;
            }
            C1283.m16854("nf_logs_pds", "Check if we have not delivered events from last time our app was runnung...");
            U.this.f5814.mo3900(new BP.AbstractC1327iF() { // from class: o.U.5.4
                @Override // o.BP.AbstractC1327iF
                /* renamed from: ॱ */
                public void mo3905(BP.If[] ifArr) {
                    if (ifArr == null || ifArr.length <= 0) {
                        C1283.m16854("nf_logs_pds", "No saved payloads found.");
                    } else {
                        U.this.m5267(ifArr, false);
                    }
                }
            });
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0100 f5811 = new C0100();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f5812;

    /* renamed from: ˎ  reason: contains not printable characters */
    private UserAgentInterface f5813;

    /* renamed from: ˏ  reason: contains not printable characters */
    private BP f5814;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging f5815;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ScheduledExecutorService f5816;

    /* renamed from: o.U$ˋ  reason: contains not printable characters */
    public interface AbstractC0101 {
        /* renamed from: ˏ */
        void mo5282(Status status);
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2138s
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5279() {
        if (this.f5811.m3269()) {
            C1283.m16854("nf_logs_pds", "PdsLog events were sent recently. We reached timeout, force send");
        }
    }

    public U(IClientLogging iClientLogging, UserAgentInterface userAgentInterface, Context context) {
        if (iClientLogging == null) {
            throw new IllegalStateException("Owner is null?");
        } else if (userAgentInterface == null) {
            throw new IllegalStateException("UserAgent is null?");
        } else {
            this.f5815 = iClientLogging;
            this.f5813 = userAgentInterface;
            this.f5812 = context;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2138s
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5280(ScheduledExecutorService scheduledExecutorService) {
        this.f5816 = scheduledExecutorService;
        m5270();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5270() {
        C1283.m16854("nf_logs_pds", "::init data repository started ");
        File file = new File(this.f5812.getFilesDir(), "pdsevents");
        file.mkdirs();
        this.f5814 = new BO(file);
        C1283.m16854("nf_logs_pds", "::init data repository done ");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5256() {
        if (this.f5811.m3264()) {
            this.f5816.schedule(this.f5810, 15, TimeUnit.SECONDS);
        } else {
            this.f5816.execute(this.f5810);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5267(BP.If[] ifArr, boolean z) {
        if (ifArr == null || ifArr.length < 1) {
            C1283.m16854("nf_logs_pds", "No saved events found");
            return;
        }
        for (BP.If r8 : ifArr) {
            final String r9 = r8.mo3882();
            if (this.f5809.contains(r9)) {
                C1283.m16855("nf_logs_pds", "We are already trying to deliver %s deliveryRequestId, skip", r9);
            } else {
                this.f5809.add(r9);
                if (z) {
                    this.f5816.schedule(new Runnable() { // from class: o.U.1
                        @Override // java.lang.Runnable
                        public void run() {
                            U.this.m5276(r9);
                        }
                    }, this.f5815.mo1508(), TimeUnit.MILLISECONDS);
                } else {
                    this.f5816.execute(new Runnable() { // from class: o.U.2
                        @Override // java.lang.Runnable
                        public void run() {
                            U.this.m5276(r9);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5276(final String str) {
        this.f5814.mo3899(str, new BP.AbstractC0068() { // from class: o.U.3
            @Override // o.BP.AbstractC0068
            /* renamed from: ˎ */
            public void mo3907(String str2, String str3, byte[] bArr, long j) {
                if (bArr == null || bArr.length < 1) {
                    C1283.m16850("nf_logs_pds", "We failed to retrieve payload. Trying to delete it");
                    U.this.m5271(str);
                    return;
                }
                try {
                    U.this.m5258(str3, new String(bArr, "utf-8"), new iF(str));
                } catch (Throwable th) {
                    C1283.m16847("nf_logs_pds", "Failed to send pdsEvent.", th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5258(String str, String str2, AbstractC0101 r8) {
        C1283.m16854("nf_logs_pds", "sendSavedPdsEventBundle start...");
        String[] r2 = m5260(str2);
        if (r2 == null || r2.length < 1) {
            C1283.m16854("nf_logs_pds", "Nothing to sent, array is null. sendSavedPdsEventBundle done.");
            r8.mo5282(AbstractC0367.f13235);
            return;
        }
        C1544bS bSVar = new C1544bS(this.f5812, r2, r8);
        AX.m3489(this.f5813, str, bSVar, true);
        this.f5815.m1505(bSVar);
        C1283.m16854("nf_logs_pds", "sendSavedPdsEventBundle done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m5262(String str, boolean z) {
        try {
            return this.f5814.mo3897(String.valueOf(System.currentTimeMillis()), str.getBytes("utf-8"), this.f5813.mo1340(), z);
        } catch (Throwable th) {
            C1283.m16847("nf_logs_pds", "Failed to save payload to repository", th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5271(String str) {
        try {
            this.f5809.remove(str);
            this.f5814.mo3898(str);
        } catch (Throwable th) {
            C1283.m16847("nf_logs_pds", "Failed to remove payload from repository", th);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m5268(String str) {
        return new JSONObject(str).optString("playbackExperience").equalsIgnoreCase("default");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5272(List<String> list, boolean z) {
        C1283.m16851("nf_logs_pds", "flushing events in queue (%d)", Integer.valueOf(list.size()));
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        if (strArr == null || strArr.length < 1) {
            C1283.m16854("nf_logs_pds", "dropping bad pds event");
            return;
        }
        try {
            if (m5268(strArr[0])) {
                m5273(list, z, false);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (String str : strArr) {
                if (m5268(str) || z2) {
                    z2 = true;
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() != 0) {
                m5273(arrayList, z, true);
            }
            if (arrayList2.size() != 0) {
                m5273(arrayList2, z, false);
            }
        } catch (Exception e) {
            C1283.m16847("nf_logs_pds", "Failed to create JSON object for logging request", e);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5273(List<String> list, boolean z, boolean z2) {
        iF iFVar = null;
        if (z) {
            String r2 = m5262(m5263(list), z2);
            this.f5809.add(r2);
            iFVar = new iF(r2);
        }
        this.f5815.m1505(new C1544bS(this.f5812, (String[]) list.toArray(new String[list.size()]), iFVar));
    }

    @Override // o.M
    /* renamed from: ˋ */
    public void mo5179(String str) {
        this.f5811.m3276(str);
    }

    @Override // o.M
    /* renamed from: ˎ */
    public void mo5180() {
        this.f5811.mo3266(true);
    }

    /* access modifiers changed from: package-private */
    public class iF implements AbstractC0101 {

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f5826;

        public iF(String str) {
            this.f5826 = str;
        }

        @Override // o.U.AbstractC0101
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo5282(Status status) {
            if (status.mo298()) {
                C1283.m16854("nf_logs_pds", "Pds events are successfully sent to backend");
                U.this.m5271(this.f5826);
                return;
            }
            C1283.m16850("nf_logs_pds", "pds events are NOT successfully sent to backend, do NOT remove them");
            U.this.f5809.remove(this.f5826);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.U$ˊ  reason: contains not printable characters */
    public class C0100 extends AC<String> {
        public C0100() {
            super("nf_pds_queue", 11, 120000, true, true);
        }

        /* access modifiers changed from: protected */
        @Override // o.AC
        /* renamed from: ˏ */
        public void mo3277(List<String> list, boolean z) {
            U.this.m5272(list, z);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m5263(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(new JSONObject(str));
        }
        return jSONArray.toString();
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2138s
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo5278() {
        this.f5811.m3270();
        m5256();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String[] m5260(String str) {
        String[] strArr = null;
        try {
            JSONArray jSONArray = new JSONArray(str);
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getJSONObject(i).toString();
                C1283.m16851("nf_logs_pds", "toPdsEvents: %d : %s", Integer.valueOf(i), strArr[i]);
            }
        } catch (JSONException e) {
            C1283.m16847("nf_logs_pds", "Unable to create JSON array from payload " + str, e);
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2138s
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5281() {
        if (ConnectivityUtils.m2970(this.f5812)) {
            C1283.m16854("nf_logs_pds", "Device is connected, lets see if we need to deliver cached events...");
            BP.If[] r5 = this.f5814.mo3901();
            if (r5 != null || r5.length > 0) {
                C1283.m16851("nf_logs_pds", "We found %d cached log entries, network is connected, lets try to deliver them", Integer.valueOf(r5.length));
                m5267(r5, false);
            }
        }
    }
}
