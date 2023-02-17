package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.Logblob;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import o.BP;
import org.json.JSONException;
public class O extends AbstractC2107r {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ScheduledExecutorService f5779;

    /* renamed from: ʼ  reason: contains not printable characters */
    private BP f5780;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final List<String> f5781 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    private UserAgentInterface f5782;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final IClientLogging f5783;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f5784;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0098 f5785 = new C0098();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1221 f5786;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Runnable f5787 = new Runnable() { // from class: o.O.1
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("nf_logblob", "Check if we have not delivered events from last time our app was runnung...");
            O.this.f5780.mo3900(new BP.AbstractC1327iF() { // from class: o.O.1.2
                @Override // o.BP.AbstractC1327iF
                /* renamed from: ॱ */
                public void mo3905(BP.If[] ifArr) {
                    if (ifArr == null || ifArr.length <= 0) {
                        C1283.m16854("nf_logblob", "No saved payloads found.");
                    } else {
                        O.this.m5217(ifArr, false);
                    }
                }
            });
        }
    };

    public interface If {
        /* renamed from: ॱ  reason: contains not printable characters */
        void mo5228(Status status);
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2107r
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo5222() {
        if (this.f5785.m3269()) {
            C1283.m16854("nf_logblob", "LogBlog events were sent recently. We reached timeout, force send");
        }
    }

    public O(IClientLogging iClientLogging, UserAgentInterface userAgentInterface, Context context, AbstractC1221 r6) {
        if (iClientLogging == null) {
            throw new IllegalStateException("Owner is null?");
        } else if (userAgentInterface == null) {
            throw new IllegalStateException("UserAgent is null?");
        } else {
            this.f5783 = iClientLogging;
            this.f5782 = userAgentInterface;
            this.f5784 = context;
            this.f5786 = r6;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2107r
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5224(ScheduledExecutorService scheduledExecutorService) {
        this.f5779 = scheduledExecutorService;
        m5218();
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2107r
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5223() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5218() {
        C1283.m16854("nf_logblob", "::init data repository started ");
        File file = new File(this.f5784.getFilesDir(), "logblobs");
        file.mkdirs();
        this.f5780 = new BO(file);
        C1283.m16854("nf_logblob", "::init data repository done ");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5207() {
        if (this.f5785.m3264()) {
            this.f5779.schedule(this.f5787, 15, TimeUnit.SECONDS);
        } else {
            this.f5779.execute(this.f5787);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5217(BP.If[] ifArr, boolean z) {
        if (ifArr == null || ifArr.length < 1) {
            C1283.m16854("nf_logblob", "No saved events found");
            return;
        }
        for (BP.If r8 : ifArr) {
            final String r9 = r8.mo3882();
            if (this.f5781.contains(r9)) {
                C1283.m16865("nf_logblob", "We are already trying to deliver %s deliveryRequestId, skip");
            } else {
                this.f5781.add(r9);
                if (z) {
                    this.f5779.schedule(new Runnable() { // from class: o.O.4
                        @Override // java.lang.Runnable
                        public void run() {
                            O.this.m5208(r9);
                        }
                    }, this.f5783.mo1508(), TimeUnit.MILLISECONDS);
                } else {
                    this.f5779.execute(new Runnable() { // from class: o.O.2
                        @Override // java.lang.Runnable
                        public void run() {
                            O.this.m5208(r9);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5208(final String str) {
        this.f5780.mo3899(str, new BP.AbstractC0068() { // from class: o.O.3
            @Override // o.BP.AbstractC0068
            /* renamed from: ˎ */
            public void mo3907(String str2, String str3, byte[] bArr, long j) {
                if (bArr == null || bArr.length < 1) {
                    C1283.m16850("nf_logblob", "We failed to retrieve payload. Trying to delete it");
                    O.this.m5221(str);
                    return;
                }
                try {
                    O.this.m5211(str3, new String(bArr, "utf-8"), new C0099(str));
                } catch (Throwable th) {
                    C1283.m16847("nf_logblob", "Failed to send logblobs.", th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5211(String str, String str2, If r9) {
        C1283.m16854("nf_logblob", "sendLogblobs starts...");
        List<Logblob> r3 = C1546bU.m5763(str2);
        if (r3 == null || r3.size() < 1) {
            C1283.m16854("nf_logblob", "Nothing to sent, array is null. SendLogblobs done.");
            r9.mo5228(AbstractC0367.f13235);
            return;
        }
        try {
            this.f5783.m1505(AX.m3489(this.f5782, str, new C1547bV(this.f5784, r3, m5206(), r9), true));
            C1283.m16854("nf_logblob", "sendLogblobs done.");
        } catch (JSONException e) {
            C1283.m16856("nf_logblob", e, "Failed to add common parameters to JSON logbob?!", new Object[0]);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m5210(String str) {
        try {
            return this.f5780.mo3895(String.valueOf(System.currentTimeMillis()), str.getBytes("utf-8"), this.f5782.mo1340());
        } catch (Throwable th) {
            C1283.m16847("nf_logblob", "Failed to save payload to repository", th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5221(String str) {
        try {
            this.f5781.remove(str);
            this.f5780.mo3898(str);
        } catch (Throwable th) {
            C1283.m16847("nf_logblob", "Failed to remove payload from repository", th);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5219(List<Logblob> list, boolean z) {
        if (list == null || list.size() < 1) {
            C1283.m16854("nf_logblob", "dropping bad logblob");
            return;
        }
        try {
            String r2 = C1546bU.m5764(list);
            C0099 r3 = null;
            if (z) {
                String r4 = m5210(r2);
                this.f5781.add(r4);
                r3 = new C0099(r4);
            }
            this.f5783.m1505(new C1547bV(this.f5784, list, m5206(), r3));
        } catch (Exception e) {
            C1283.m16847("nf_logblob", "Failed to create JSON object for logging request", e);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private Logblob.C0028 m5206() {
        return new Logblob.C0028(this.f5786.d_().mo14449(), this.f5783.mo1520(), this.f5783.mo1517(), this.f5786.d_().mo14452());
    }

    @Override // o.oQ
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5226(Logblob logblob) {
        String r5 = this.f5783.mo1520();
        String r6 = this.f5783.mo1517();
        if (logblob instanceof AbstractC1542bQ) {
            try {
                ((AbstractC1542bQ) logblob).m5757(this.f5784, this.f5786, r5, r6);
            } catch (JSONException e) {
                C1283.m16856("nf_logblob", e, "Failed to populate JSON", new Object[0]);
            }
        } else if (logblob != null) {
            C1283.m16855("nf_logblob", "Unable to set common data by framework, logblob does not implement BaseLogblob %s ", logblob.toString());
        } else {
            C1283.m16850("nf_logblob", "Message is null!");
        }
        if (!this.f5785.m3276(logblob) && logblob.mo1556()) {
            this.f5785.mo3266(true);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2107r
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5225() {
        this.f5785.m3270();
        m5207();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.O$ˋ  reason: contains not printable characters */
    public class C0099 implements If {

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f5798;

        public C0099(String str) {
            this.f5798 = str;
        }

        @Override // o.O.If
        /* renamed from: ॱ */
        public void mo5228(Status status) {
            if (status.mo298()) {
                C1283.m16854("nf_logblob", "Logblobs are succcesfully sent to backend");
                O.this.m5221(this.f5798);
                return;
            }
            C1283.m16850("nf_logblob", "Logblobs are NOT succcesfully sent to backend, do NOT remove them");
            O.this.f5781.remove(this.f5798);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.O$ˊ  reason: contains not printable characters */
    public class C0098 extends AC<Logblob> {
        public C0098() {
            super("nf_logblob_queue", 30, 60000, true, true);
        }

        /* access modifiers changed from: protected */
        @Override // o.AC
        /* renamed from: ˏ */
        public void mo3277(List<Logblob> list, boolean z) {
            O.this.m5219(list, z);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2107r
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5227() {
        if (ConnectivityUtils.m2970(this.f5784)) {
            C1283.m16854("nf_logblob", "Device is connected, lets see if we need to deliver cached events...");
            BP.If[] r2 = this.f5780.mo3901();
            if (r2 != null || r2.length > 0) {
                C1283.m16854("nf_logblob", "We found %d cached log entries, network is connected, lets try to deliver them");
                m5217(r2, false);
            }
        }
    }
}
