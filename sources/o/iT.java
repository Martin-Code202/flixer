package o;

import android.content.Context;
import android.util.Pair;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import com.netflix.mediaclient.service.player.bladerunnerclient.BladeRunnerPrefetchResponseHandler;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.OfflineLicenseResponse;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.FetchLicenseRequest;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadVideoQuality;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
public class iT extends BladeRunnerPrefetchResponseHandler implements IBladeRunnerClient {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String f7647 = "nf_bladerunner";

    /* renamed from: ʻ  reason: contains not printable characters */
    private AbstractC1250 f7648;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f7649;

    /* renamed from: ˏ  reason: contains not printable characters */
    private UserAgentInterface f7650;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1221 f7651;

    public iT(AbstractC1250 r1, Context context, AbstractC1221 r3, UserAgentInterface userAgentInterface) {
        this.f7649 = context;
        this.f7651 = r3;
        this.f7650 = userAgentInterface;
        this.f7648 = r1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7572(Long[] lArr, IBladeRunnerClient.ManifestRequestFlavor manifestRequestFlavor, iX iXVar) {
        C1901jb jbVar = new C1901jb(this.f7651, this.f7650, ConnectivityUtils.m2958(this.f7649), this.f7649);
        String[] strArr = new String[lArr.length];
        int i = 0;
        for (Long l : lArr) {
            i++;
            strArr[i] = Long.toString(l.longValue());
        }
        C1910jk jkVar = new C1910jk(this.f7649, jbVar.m7611(AD.m3301(this.f7649)).m7605(manifestRequestFlavor).m7606(strArr).m7604(), manifestRequestFlavor, iXVar, this, lArr);
        if (IBladeRunnerClient.ManifestRequestFlavor.PREFETCH == manifestRequestFlavor) {
            m939(lArr, jkVar);
        }
        this.f7648.mo15842(jkVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7565(String str, String str2, String str3, DownloadVideoQuality downloadVideoQuality, iX iXVar) {
        this.f7648.mo15842(new C1906jg(this.f7649, new C1900ja(this.f7649, this.f7651, this.f7650, ConnectivityUtils.m2958(this.f7649)).m7986(downloadVideoQuality).m7987(str2, str3).m7611(AD.m3301(this.f7649)).m7606(new String[]{str}).m7604(), IBladeRunnerClient.ManifestRequestFlavor.OFFLINE, iXVar));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7571(String str, String str2, String str3, String str4, DownloadVideoQuality downloadVideoQuality, jG jGVar, iX iXVar) {
        C1283.m16854(f7647, "refreshOfflineManifest");
        if (jGVar == null || jGVar.mo7915() == null) {
            m7565(str, str2, str3, downloadVideoQuality, iXVar);
            return;
        }
        Pair<VideoTrack, Stream> r6 = jJ.m7940(jGVar, str4);
        String str5 = null;
        if (!(r6 == null || r6.second == null)) {
            str5 = ((Stream) r6.second).content_profile;
        }
        this.f7648.mo15842(new C1912jm(this.f7649, new C1900ja(this.f7649, this.f7651, this.f7650, ConnectivityUtils.m2958(this.f7649)).m7986(downloadVideoQuality).m7987(str2, str3).m7985(str5).m7611(AD.m3301(this.f7649)).m7606(new String[]{str}).m7604(), jGVar, iXVar));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7575(C1923jx jxVar, iX iXVar) {
        C1904je jeVar = new C1904je(this.f7649, new C1902jc(this.f7650).m7993(jxVar.m8093()).m7990(jxVar).m7992(), false, jxVar.m8093(), iXVar, this, jxVar.m8087());
        if (jxVar.m8093().equals(IBladeRunnerClient.LicenseRequestFlavor.LIMITED)) {
            m936(jxVar.m8087(), jeVar);
        }
        this.f7648.mo15842(jeVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7566(String str, String str2, final iX iXVar) {
        String r8 = new iY(this.f7650, this.f7651.mo16513()).m7619(m7560(str), str2).m7621();
        AnonymousClass5 r9 = new AbstractC1903jd() { // from class: o.iT.5
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ˏ */
            public void mo6962(OfflineLicenseResponse offlineLicenseResponse, Status status) {
                super.mo6962(offlineLicenseResponse, status);
                C1283.m16851(iT.f7647, " license fetched status: %s", status);
                if (status.mo298() && offlineLicenseResponse.m952()) {
                    status = iT.this.m7561(iT.this.f7649, offlineLicenseResponse.f1669, iT.this.f7650.mo1328().m3975());
                    C1283.m16851(iT.f7647, " license fetched status: %s", status);
                }
                iT.this.m7556(status.mo302());
                iXVar.mo6962(offlineLicenseResponse, status);
            }
        };
        C1283.m16854(f7647, "fetching offline license");
        this.f7648.mo15842(new FetchLicenseRequest(this.f7649, FetchLicenseRequest.LicenseReqType.OFFLINE, r8, false, IBladeRunnerClient.LicenseRequestFlavor.OFFLINE, r9));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7556(StatusCode statusCode) {
        this.f7651.mo16533(statusCode);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7567(String str, String str2, boolean z, iX iXVar) {
        this.f7648.mo15842(new C1911jl(this.f7649, new iU(z, str2).m7581(m7560(str)).mo7578(), iXVar));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7564(String str) {
        if (!C1349Bv.m4113(str)) {
            C1283.m16854(f7647, "activateOfflineLicense");
            AnonymousClass4 r2 = new AbstractC1903jd() { // from class: o.iT.4
                @Override // o.AbstractC1903jd, o.iX
                /* renamed from: ˎ  reason: contains not printable characters */
                public void mo7576(JSONObject jSONObject, Status status) {
                    super.mo7576(jSONObject, status);
                    C1283.m16851(iT.f7647, "license activated : res: %s", status);
                }
            };
            C1283.m16854(f7647, "activating license");
            this.f7648.mo15842(new C1908ji(this.f7649, m7573(str), r2));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7570(IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke, String str, String str2, final iX iXVar) {
        String r8 = new iY(this.f7650, this.f7651.mo16513()).m7619(m7560(str), str2).m7618(offlineRefreshInvoke).m7621();
        AnonymousClass1 r9 = new AbstractC1903jd() { // from class: o.iT.1
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ˏ */
            public void mo6962(OfflineLicenseResponse offlineLicenseResponse, Status status) {
                super.mo6962(offlineLicenseResponse, status);
                C1283.m16851(iT.f7647, "refresh license fetched status: %s", status);
                if (status.mo298() && offlineLicenseResponse.m952()) {
                    status = iT.this.m7561(iT.this.f7649, offlineLicenseResponse.f1669, iT.this.f7650.mo1328().m3975());
                    C1283.m16851(iT.f7647, "refresh license fetched status: %s", status);
                }
                iXVar.mo6962(offlineLicenseResponse, status);
            }
        };
        C1283.m16854(f7647, "refreshing offline license");
        this.f7648.mo15842(new FetchLicenseRequest(this.f7649, FetchLicenseRequest.LicenseReqType.OFFLINE, r8, true, IBladeRunnerClient.LicenseRequestFlavor.OFFLINE, r9));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7574(List<String> list, iX iXVar) {
        this.f7648.mo15842(new C1913jn(this.f7649, new iZ().m7624(list).m7623(), iXVar));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m7573(String str) {
        C1283.m16851(f7647, "building param for link %s", str);
        return new iV().m7581(m7560(str)).mo7578();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m7555(String str, String str2) {
        return new iV().m7581(m7560(str)).m7580("xid", str2).mo7578();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static JSONObject m7560(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16851(f7647, "error parsing link %s", str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private Status m7561(Context context, long j, Locale locale) {
        String r2 = m7559(context, j, locale);
        NetflixStatus netflixStatus = new NetflixStatus(StatusCode.DL_WARNING_DL_N_TIMES_BEFORE_DATE, 0);
        netflixStatus.m312(r2);
        netflixStatus.m311(true);
        return netflixStatus;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m7559(Context context, long j, Locale locale) {
        String r4 = ((AbstractC2102qv) C1281.m16832(AbstractC2102qv.class)).mo10118(context, j, locale);
        C1283.m16851(f7647, "yearly warning msg: %s", r4);
        return r4;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7568(C1923jx jxVar, iX iXVar) {
        FetchLicenseRequest r5 = m938(jxVar.m8087());
        if (r5 != null) {
            C1283.m16851(f7647, "%d has pending LDL request, may PROMOTE.", jxVar.m8087());
            synchronized (r5) {
                if (!r5.isRequestInFlight() && !r5.isCanceled()) {
                    C1283.m16854(f7647, "PROMOTE pending LDL request in the queue.");
                    r5.cancel();
                    m7575(jxVar, iXVar);
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m7569(long j, iX iXVar) {
        C1910jk r5 = m940(Long.valueOf(j));
        if (r5 == null) {
            return false;
        }
        C1283.m16851(f7647, "%d has pending manifest prefetch request, may PROMOTE.", Long.valueOf(j));
        synchronized (r5) {
            if (r5.isRequestInFlight() || r5.isCanceled()) {
                return false;
            }
            C1283.m16854(f7647, "PROMOTE pending manifest prefetch request in the queue.");
            r5.cancel();
            m7572(new Long[]{Long.valueOf(j)}, IBladeRunnerClient.ManifestRequestFlavor.STANDARD, iXVar);
            r5.m8011();
            return true;
        }
    }
}
