package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import org.json.JSONException;
/* access modifiers changed from: package-private */
/* renamed from: o.hw  reason: case insensitive filesystem */
public class C1865hw {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f7447;

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1868hz f7448;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final long f7449;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final hA f7450;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final File f7451;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f7452 = System.currentTimeMillis();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final oQ f7453;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f7454;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Context f7455;

    C1865hw(Context context, hA hAVar, IClientLogging iClientLogging, File file) {
        this.f7455 = context;
        this.f7450 = hAVar;
        this.f7453 = iClientLogging.mo1512();
        this.f7451 = file;
        this.f7449 = file.length();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7359(C1868hz hzVar, long j) {
        this.f7448 = hzVar;
        this.f7447 = System.currentTimeMillis();
        this.f7454 = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7361(long j) {
        if (this.f7448 == null) {
            C1283.m16862("nf_cdnUrlDownloadEvent", "onDownloadStop  didn't receive onDownloadStart. Not an error, ignoring");
            return;
        }
        m7357(j, false);
        this.f7448 = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7360(long j) {
        if (this.f7448 == null) {
            C1283.m16862("nf_cdnUrlDownloadEvent", "onDownloadComplete  didn't receive onDownloadStart. Not an error, ignoring");
            return;
        }
        m7357(j, true);
        this.f7448 = null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7357(long j, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - this.f7447;
        long j2 = j - this.f7454;
        if (currentTimeMillis <= 0 || j2 < 0) {
            C1283.m16862("nf_cdnUrlDownloadEvent", "onDownloadComplete not sending dl report.");
            return;
        }
        final iF iFVar = new iF(z);
        try {
            iFVar.m7362(this.f7450, this.f7448, this.f7447, this.f7454, currentTimeMillis, j2, ConnectivityUtils.m2958(this.f7455));
            new BackgroundTask().m285(new Runnable() { // from class: o.hw.3
                @Override // java.lang.Runnable
                public void run() {
                    C1865hw.this.f7453.mo5226(iFVar);
                }
            });
        } catch (JSONException e) {
            C1283.m16856("nf_cdnUrlDownloadEvent", e, "onDownloadComplete jsonException", new Object[0]);
        } catch (Exception e2) {
            C1283.m16856("nf_cdnUrlDownloadEvent", e2, "onDownloadComplete exception", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.hw$iF */
    public class iF extends AbstractC1542bQ {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final boolean f7459;

        iF(boolean z) {
            this.f7459 = z;
        }

        @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˏ */
        public boolean mo1556() {
            return this.f7459;
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˋ */
        public String mo680() {
            return LogBlobType.OFFLINE_CDN_URL_DOWNLOAD.m602();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public void m7362(hA hAVar, C1868hz hzVar, long j, long j2, long j3, long j4, ConnectivityUtils.NetType netType) {
            this.f6134.put("offlinedlreport", LogBlobType.OFFLINE_CDN_URL_DOWNLOAD.m602());
            this.f6134.put("oxid", hAVar.f7056);
            this.f6134.put("dxid", hAVar.f7059);
            this.f6134.put("downloadstarttime", j);
            this.f6134.put("startbyteoffset", j2);
            this.f6134.put("playbackcontextid", hAVar.f7058);
            this.f6134.put("cdnid", hzVar.f7477);
            this.f6134.put("dlid", hAVar.f7055);
            this.f6134.put("bytes", j4);
            this.f6134.put(SessionEndedEvent.DURATION, j3);
            this.f6134.put("dlFilePath", C1865hw.this.f7451.getAbsolutePath());
            this.f6134.put("fileSizeAtStart", C1865hw.this.f7449);
            this.f6134.put("fileSizeNow", C1865hw.this.f7451.length());
            this.f6134.put("birthTime", C1865hw.this.f7452);
            ConnectivityUtils.m2957(this.f6134, netType);
        }
    }
}
