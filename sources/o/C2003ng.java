package o;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.io.File;
import o.C0524;
import o.C2008nl;
import o.C2011no;
/* renamed from: o.ng  reason: case insensitive filesystem */
public class C2003ng extends AbstractC1052 implements AbstractC2004nh, AbstractC2007nk {

    /* renamed from: ʽ  reason: contains not printable characters */
    private C2008nl f9138;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f9139;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0661 f9140;

    /* renamed from: ˎ  reason: contains not printable characters */
    private File f9141;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0482 f9142;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0482 f9143;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C2011no f9144;

    public C2003ng(Context context, AbstractC0661 r2) {
        this.f9139 = context;
        this.f9140 = r2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1283.m16854("nf_service_resourcefetcher", "ResourceFetcher starting doInit.");
        C2036ol.m9676(this.f9139);
        m9297();
        m9300();
        m9295();
        m16090(AbstractC0367.f13235);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9295() {
        this.f9141 = new File(this.f9139.getCacheDir(), "downloads");
        if (!this.f9141.isDirectory()) {
            this.f9141.mkdirs();
        }
        this.f9138 = new C2008nl((C0763) this.f9142.m14413());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9297() {
        int r6 = C1260.m16712();
        C1283.m16851("nf_service_resourcefetcher", "Creating Volley RequestQueue with threadPoolsize of %d", Integer.valueOf(r6));
        this.f9142 = this.f9140.mo14824(m9290(), new C1813gS(this.f9139, m9292()), r6, true, "resources");
        this.f9142.m14410();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9300() {
        int r8 = C1260.m16719();
        C1283.m16851("nf_service_resourcefetcher", "Creating MSL Volley RequestQueue with threadPoolsize of %d", Integer.valueOf(r8));
        this.f9143 = this.f9140.mo14824(new C1036(), new C1813gS(this.f9139, new C1812gR(this.f9139, this.f9140, C1260.m16720())), r8, true, "msl");
        this.f9143.m14410();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9301() {
        if (C0690.m14974() && C1339Bl.m4051(this.f9139, "prefs_clear_image_disk_cache_secondary_control_allocate_ab8722", true)) {
            C1283.m16854("nf_service_resourcefetcher", "Clearing Volley Image Disk Cache");
            this.f9138.m9314();
            C1339Bl.m4048(this.f9139, "prefs_clear_image_disk_cache_secondary_control_allocate_ab8722", false);
        }
        if (C0717.m15046() && C1339Bl.m4051(this.f9139, "prefs_clear_image_disk_cache_secondary_control_allocate_ab8930", true)) {
            C1283.m16854("nf_service_resourcefetcher", "Clearing Volley Image Disk Cache");
            this.f9138.m9314();
            C1339Bl.m4048(this.f9139, "prefs_clear_image_disk_cache_secondary_control_allocate_ab8930", false);
        }
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        super.mo1236();
        if (this.f9142 != null) {
            C1283.m16862("nf_service_resourcefetcher", "Stopping Volley RequestQueue");
            this.f9142.m14416();
            this.f9142 = null;
        }
        if (this.f9143 != null) {
            C1283.m16862("nf_service_resourcefetcher", "Stopping MSL Volley RequestQueue");
            this.f9143.m14416();
            this.f9143 = null;
        }
        C2036ol.m9672();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C2011no m9305(Context context) {
        if (this.f9144 == null) {
            synchronized (this) {
                if (this.f9144 == null) {
                    this.f9144 = m9299(context);
                }
            }
        }
        return this.f9144;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2011no m9299(Context context) {
        C1283.m16854("nf_service_resourcefetcher", "ResourceFetcher creating ImageLoader");
        if (this.f9142 == null) {
            C1283.m16865("nf_service_resourcefetcher", "Attempting to create an ImageLoader with a null RequestQueue");
            C1276.m16820().mo5727("Attempting to create an ImageLoader with a null RequestQueue");
            return null;
        }
        long r6 = C1260.m16723();
        int r8 = C1260.m16718();
        C1283.m16851("nf_service_resourcefetcher", "Received request to create new ImageLoader with socketTimeout = %d and minimumTtl = %d ms", Integer.valueOf(r8), Long.valueOf(r6));
        return new C2011no(this.f9142, m9291(context), r8, r6);
    }

    @Override // o.AbstractC2007nk
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9310(String str, AssetType assetType, AbstractC2006nj njVar) {
        m9308(str, assetType, Request.Priority.NORMAL, njVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9308(final String str, AssetType assetType, Request.Priority priority, AbstractC2006nj njVar) {
        final boolean z = assetType == AssetType.bif;
        if (z) {
            BW.m3944(str, assetType, ImageLoader.AssetLocationType.PLACEHOLDER.toString());
        }
        final AbstractC2006nj r7 = m9294(njVar, z);
        this.f9142.m14415(new C2013nq(str, r7, new C0524.AbstractC2398iF() { // from class: o.ng.5
            @Override // o.C0524.AbstractC2398iF
            public void onErrorResponse(VolleyError volleyError) {
                C1283.m16856("nf_service_resourcefetcher", volleyError, "RawFileDownloadRequest failed: ", new Object[0]);
                if (z) {
                    BW.m3937(str, volleyError);
                }
                if (r7 != null) {
                    r7.mo7553(str, (byte[]) null, new NetworkErrorStatus(volleyError));
                }
            }
        }, C1260.m16718(), priority));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9309(String str, AssetType assetType, AbstractC2006nj njVar) {
        m9303(str, assetType, Request.Priority.NORMAL, njVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9303(final String str, AssetType assetType, Request.Priority priority, final AbstractC2006nj njVar) {
        this.f9142.m14415(new C2010nn(str, njVar, new C0524.AbstractC2398iF() { // from class: o.ng.2
            @Override // o.C0524.AbstractC2398iF
            public void onErrorResponse(VolleyError volleyError) {
                C1283.m16856("nf_service_resourcefetcher", volleyError, "FileDownloadRequest failed: ", new Object[0]);
                if (njVar != null) {
                    njVar.mo8943(str, (String) null, new NetworkErrorStatus(volleyError));
                }
            }
        }, C1260.m16718(), priority, this.f9141));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9307(final String str, AssetType assetType, final AbstractC2006nj njVar) {
        C2008nl.Cif r8 = this.f9138.m9313(BG.m3859(str));
        if (r8 == null) {
            this.f9142.m14415(new C2009nm(str, njVar, new C0524.AbstractC2398iF() { // from class: o.ng.1
                @Override // o.C0524.AbstractC2398iF
                public void onErrorResponse(VolleyError volleyError) {
                    C1283.m16856("nf_service_resourcefetcher", volleyError, "fetchAndCacheResource failed: ", new Object[0]);
                    if (njVar != null) {
                        njVar.mo9311(str, null, 0, 0, new NetworkErrorStatus(volleyError));
                    }
                }
            }, C1260.m16718(), this.f9138));
        } else if (njVar != null) {
            njVar.mo9311(str, r8.m9315(), r8.m9316(), r8.m9317(), AbstractC0367.f13235);
        }
    }

    @Override // o.AbstractC2007nk
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo9302(final String str, AssetType assetType, long j, long j2, final AbstractC2006nj njVar) {
        C2012np npVar = new C2012np(str, j, j2, njVar, new C0524.AbstractC2398iF() { // from class: o.ng.4
            @Override // o.C0524.AbstractC2398iF
            public void onErrorResponse(VolleyError volleyError) {
                C1283.m16856("nf_service_resourcefetcher", volleyError, "FileDownloadRequest failed: ", new Object[0]);
                if (njVar != null) {
                    njVar.mo7553(str, (byte[]) null, new NetworkErrorStatus(volleyError));
                }
            }
        }, C1260.m16718());
        switch (assetType) {
            case subtitles:
            case imageSubtitlesMasterIndex:
            case imageSubtitlesSegmentIndex:
            case imageSubtitlesSegment:
                npVar.setTag(NetworkRequestType.CONTENT_SUBTITLES);
                break;
        }
        this.f9142.m14415(npVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9306(Object obj) {
        this.f9142.m14411(obj);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized C2011no.AbstractC0156 m9291(Context context) {
        NetflixApplication netflixApplication = (NetflixApplication) context.getApplicationContext();
        BV r6 = netflixApplication.m233();
        if (r6 == null || !(r6 instanceof C2011no.AbstractC0156)) {
            int r7 = C1260.m16722();
            C1283.m16851("nf_service_resourcefetcher", "Creating new BitmapLruCache of size %d bytes", Integer.valueOf(r7));
            If r8 = new If(r7);
            netflixApplication.m241(r8);
            return r8;
        }
        return (C2011no.AbstractC0156) r6;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ng$If */
    public static class If extends BV implements C2011no.AbstractC0156 {
        public If(int i) {
            super(i);
        }
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private AbstractC0894 m9292() {
        C1283.m16854("nf_service_resourcefetcher", "Create resource Http Stack");
        return new C2015ns(this.f9140);
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private C0763 m9290() {
        File file = new File(this.f9139.getCacheDir(), "volley");
        int r6 = C1330Bc.m4003(this.f9139);
        C1283.m16863("nf_service_resourcefetcher", "Creating new Volley DiskBasedCache, location: %s,  max size: %d bytes", file.getAbsolutePath(), Integer.valueOf(r6));
        return new C0763(file, r6);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2006nj m9294(AbstractC2006nj njVar, boolean z) {
        if (!z) {
            return njVar;
        }
        if (njVar != null) {
            return new Cif(njVar);
        }
        C1283.m16865("nf_service_resourcefetcher", "Resource fetcher callback is null!");
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9304(String str) {
        if (!this.f9141.isDirectory() || !C1349Bv.m4107(str)) {
            return false;
        }
        return new File(this.f9141, str).delete();
    }

    @Override // o.AbstractC2004nh
    /* renamed from: ˎ */
    public synchronized boolean mo6791(NetflixDataRequest netflixDataRequest) {
        if (netflixDataRequest == null) {
            C1283.m16865("nf_service_resourcefetcher", "Request is null!");
            return false;
        } else if (netflixDataRequest instanceof gV) {
            return m9298((gV) netflixDataRequest);
        } else if (netflixDataRequest instanceof AbstractC2040op) {
            return m9296((AbstractC2040op) netflixDataRequest);
        } else {
            throw new IllegalStateException("Not supported implementation of NetflixDataRequest:" + netflixDataRequest.getClass().getSimpleName());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m9296(AbstractC2040op opVar) {
        C1283.m16851("nf_service_resourcefetcher", "Adding direct request %s to queue...", m9293((NetflixDataRequest) opVar));
        int r5 = C1260.m16720();
        C1283.m16851("nf_service_resourcefetcher", "Setting default timeout value for data request to %d ms", Integer.valueOf(r5));
        if (!(opVar.m9690() || m16085() == null || m16085().mo1362() == null)) {
            opVar.m9687(new C2030of(m16085().mo1362()));
        }
        opVar.m9691(m16101().mo16512());
        opVar.setRetryPolicy(BJ.m3867(r5));
        ApiEndpointRegistry r6 = m16101().mo16547();
        if (m16100().mo16162() != null && (opVar instanceof AbstractC1103)) {
            opVar.mo5783(m16100().mo16165());
        } else if (r6 != null) {
            opVar.mo5783(m16101().mo16547());
        } else {
            C1283.m16850("nf_service_resourcefetcher", "ApiEndpointRegistry is not available!");
            return false;
        }
        if (opVar instanceof AbstractC2035ok) {
            ((AbstractC2035ok) opVar).m9667(m16101());
        }
        this.f9143.m14415(opVar);
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m9293(NetflixDataRequest netflixDataRequest) {
        if (C1349Bv.m4107(netflixDataRequest.getClass().getSimpleName())) {
            return netflixDataRequest.getClass().getSimpleName();
        }
        if (netflixDataRequest instanceof AbstractC1810gP) {
            Object tag = ((AbstractC1810gP) netflixDataRequest).getTag();
            if (tag instanceof String) {
                return (String) tag;
            }
            if (tag != null) {
                return tag.toString();
            }
            return "";
        } else if (!(netflixDataRequest instanceof AbstractC2040op)) {
            return "";
        } else {
            Object tag2 = ((AbstractC2040op) netflixDataRequest).getTag();
            if (tag2 instanceof String) {
                return (String) tag2;
            }
            if (tag2 != null) {
                return tag2.toString();
            }
            return "";
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m9298(gV gVVar) {
        if (!((AbstractC1052) m16087()).r_()) {
            C1283.m16865("nf_service_resourcefetcher", "MSL agent is not ready, droping request");
            return false;
        }
        C1283.m16851("nf_service_resourcefetcher", "Adding MSL request %s to queue...", m9293((NetflixDataRequest) gVVar));
        m16087().mo6784(gVVar);
        this.f9143.m14415(gVVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ng$if  reason: invalid class name */
    public class Cif implements AbstractC2006nj {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final AbstractC2006nj f9159;

        private Cif(AbstractC2006nj njVar) {
            if (njVar == null) {
                throw new IllegalArgumentException("Callback can not be null");
            }
            this.f9159 = njVar;
        }

        @Override // o.AbstractC2006nj
        /* renamed from: ˎ */
        public void mo8943(String str, String str2, Status status) {
            BW.m3938(str, status.mo302(), ImageLoader.AssetLocationType.PLACEHOLDER.toString());
            this.f9159.mo8943(str, str2, status);
        }

        @Override // o.AbstractC2006nj
        /* renamed from: ˎ */
        public void mo7553(String str, byte[] bArr, Status status) {
            BW.m3938(str, status.mo302(), ImageLoader.AssetLocationType.PLACEHOLDER.toString());
            this.f9159.mo7553(str, bArr, status);
        }

        @Override // o.AbstractC2006nj
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo9311(String str, String str2, long j, long j2, Status status) {
            BW.m3938(str, status.mo302(), ImageLoader.AssetLocationType.PLACEHOLDER.toString());
            this.f9159.mo9311(str, str2, j, j2, status);
        }
    }

    @Override // o.AbstractC1052
    /* renamed from: ʼ */
    public void mo5196() {
        C2036ol.m9675();
    }
}
