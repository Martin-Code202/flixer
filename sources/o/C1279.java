package o;

import android.content.Context;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.volley.FtlController;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
/* renamed from: o.ﾓ  reason: contains not printable characters */
public class C1279 implements ApiEndpointRegistry {

    /* renamed from: ʼ  reason: contains not printable characters */
    private UserAgentInterface f15981;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f15982 = AbstractC0488.m14428();

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f15983 = m16828();

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f15984 = m16823();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final FtlController f15985;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f15986;

    /* renamed from: ॱ  reason: contains not printable characters */
    private URL f15987;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC1853hl f15988;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC1221 f15989;

    public C1279(Context context, UserAgentInterface userAgentInterface, AbstractC1221 r4, AbstractC1853hl hlVar, IClientLogging iClientLogging) {
        this.f15986 = context;
        this.f15985 = new FtlController(iClientLogging);
        this.f15981 = userAgentInterface;
        this.f15989 = r4;
        this.f15988 = hlVar;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˋ */
    public synchronized Map<String, String> mo1453() {
        return m16825();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized Map<String, String> m16825() {
        AW aw;
        aw = new AW();
        aw.put("responseFormat", "json");
        aw.put("progressive", "false");
        aw.put("pathFormat", ApiEndpointRegistry.ResponsePathFormat.HIERARCHICAL.f2348);
        C0351 r3 = this.f15989.mo16552();
        aw.put("appType", r3.m13951());
        aw.put("dbg", String.valueOf(!C1337Bj.m4030()));
        if (!C1337Bj.m4030()) {
            aw.put("revision", "latest");
        }
        aw.put("qlty", AV.m3472() ? "hd" : "sd");
        aw.put("ffbc", r3.m13953());
        aw.put("osBoard", r3.m13950());
        aw.put("osDevice", r3.m13947());
        aw.put("osDisplay", r3.m13944());
        aw.put("appVer", Integer.toString(r3.m13946()));
        aw.put("appVersion", r3.m13945());
        aw.put("mId", r3.m13949());
        aw.put("api", Integer.toString(r3.m13952()));
        aw.put("mnf", r3.m13948());
        aw.put("store", C1325Ay.m3829(this.f15986));
        aw.put("memLevel", C1337Bj.m4024());
        aw.put("lackLocale", String.valueOf(C2020nx.m9365(this.f15986)));
        aw.put("deviceLocale", String.valueOf(C2020nx.m9367().m3976()));
        aw.put("chipset", this.f15989.mo16559());
        aw.put("chipsetHardware", this.f15989.mo16506());
        aw.put("netflixClientPlatform", "androidNative");
        if (C1349Bv.m4107(this.f15989.mo16504())) {
            aw.put("roBspVer", this.f15989.mo16504());
        }
        aw.put("devmod", this.f15982);
        if (C1337Bj.m4033()) {
            aw.put("isPartnerBuild", Boolean.TRUE.toString());
        }
        String r5 = this.f15989.mo16560();
        if (C1349Bv.m4107(r5)) {
            aw.put("channelId", r5);
        }
        String r6 = this.f15989.mo16502();
        if (C1349Bv.m4107(r6)) {
            aw.put("gAdvId", r6);
        }
        aw.put("isNetflixPreloaded", String.valueOf(this.f15989.mo16561()));
        aw.put("installType", this.f15989.mo16562());
        aw.put("isPlayBillingEnabled", String.valueOf(!this.f15989.mo16535()));
        String r7 = this.f15989.d_() != null ? this.f15989.d_().mo14449() : null;
        if (C1349Bv.m4107(r7)) {
            aw.put(Device.ESN, r7);
        }
        return aw;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˏ */
    public synchronized Map<String, String> mo1456(ApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        AW aw;
        aw = new AW();
        aw.put("responseFormat", "json");
        aw.put("progressive", "false");
        aw.put("ffbc", this.f15989.mo16552().m13953());
        aw.put("appVersion", this.f15989.mo16552().m13945());
        aw.put("netflixClientPlatform", "androidNative");
        if (!C1337Bj.m4030()) {
            aw.put("revision", "latest");
        }
        if (this.f15981 != null && C1349Bv.m4107(this.f15981.mo1354())) {
            aw.put("languages", this.f15981.mo1354());
        }
        if (!(this.f15981 == null || this.f15981.mo1383() == null || !this.f15981.mo1383().isKidsProfile())) {
            aw.put("prfType", this.f15981.mo1383().getProfileType().toString());
        }
        if (this.f15988 != null && this.f15988.mo7118()) {
            aw.put("dlEnabled", Boolean.TRUE.toString());
        }
        if (C1061.m16114().mo14168()) {
            aw.put("isFirstLolomoAfterOnRamp", Boolean.TRUE.toString());
        }
        if (responsePathFormat != null) {
            aw.put("pathFormat", responsePathFormat.f2348);
        } else {
            aw.put("pathFormat", ApiEndpointRegistry.ResponsePathFormat.GRAPH.f2348);
        }
        aw.put("res", this.f15989.mo16553().f1083);
        aw.put("imgpref", m16824());
        C1061.m16114().mo14174().mo276(this.f15986, aw);
        return aw;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private String m16824() {
        String r2 = this.f15989.mo16549();
        if (C1349Bv.m4107(r2)) {
            return r2;
        }
        return C1317As.m3758() >= 14 ? "webp" : "jpg";
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˎ */
    public void mo1449(String str) {
        this.f15983 = str;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˎ */
    public String mo1454() {
        return this.f15983;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m16822() {
        return true;
    }

    @Override // o.AbstractC2032oh
    /* renamed from: ʽ */
    public URL mo9650(String str) {
        if (this.f15987 != null) {
            return this.f15987;
        }
        StringBuilder sb = new StringBuilder();
        if (mo1459()) {
            sb.append("https://");
        } else {
            sb.append("http://");
        }
        sb.append(m16827());
        sb.append("/appboot/").append(str);
        try {
            this.f15987 = new URL(sb.toString());
            return this.f15987;
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Unable to create URL", e);
        }
    }

    @Override // o.AbstractC2032oh
    /* renamed from: ᐝ */
    public URL mo9651(String str) {
        return m16826(this.f15983, str);
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˋ */
    public URL mo1452(String str) {
        return m16826(C2034oj.m9657(this.f15986), str);
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˏ */
    public AbstractC2039oo mo1457() {
        return this.f15985;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private URL m16826(String str, String str2) {
        StringBuilder r2 = m16830();
        r2.append(str);
        if (str2 != null) {
            r2.append(str2);
        }
        r2.append(this.f15984);
        try {
            return new URL(r2.toString());
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Unable to create URL", e);
        }
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˊ */
    public String mo1451(String str) {
        StringBuilder r1 = m16830();
        r1.append(this.f15983);
        if (str != null) {
            r1.append(str);
        }
        r1.append("/android/samurai/config");
        return r1.toString();
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ॱ */
    public String mo1458(String str) {
        StringBuilder r1 = m16830();
        r1.append(C2034oj.m9657(this.f15986));
        if (str != null) {
            r1.append(str);
        }
        r1.append("/android/samurai/config");
        return r1.toString();
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˏ */
    public String mo1455(String str) {
        StringBuilder r1 = m16830();
        r1.append(this.f15983);
        if (str != null) {
            r1.append(str);
        }
        return r1.toString();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private StringBuilder m16830() {
        StringBuilder sb = new StringBuilder();
        if (m16822()) {
            sb.append("https://");
        } else {
            sb.append("http://");
        }
        return sb;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private String m16823() {
        return "/android/6.1/api";
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String m16828() {
        return "android.prod.cloud.netflix.com";
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String m16827() {
        return "android-appboot.netflix.com";
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ॱ */
    public boolean mo1459() {
        return true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m16829(String str) {
        return str == "android.int.cloud.netflix.com" || str == "android.test.cloud.netflix.com";
    }
}
