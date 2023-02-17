package o;

import android.content.Context;
import com.netflix.mediaclient.acquisition.BillingManager;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
/* renamed from: o.Ⅱ  reason: contains not printable characters */
public class C1056 implements AUIApiEndpointRegistry {

    /* renamed from: ʽ  reason: contains not printable characters */
    private AbstractC1194 f15203;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f15204;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1221 f15205;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f15206 = m16110();

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f15207 = m16105();

    /* renamed from: ॱ  reason: contains not printable characters */
    private UserAgentInterface f15208;

    public C1056(Context context, UserAgentInterface userAgentInterface, C1079 r4, AbstractC1853hl hlVar, C1260 r6) {
        this.f15204 = context;
        this.f15208 = userAgentInterface;
        this.f15203 = r4;
        this.f15205 = r6;
    }

    @Override // com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry
    /* renamed from: ˊ */
    public synchronized Map<String, String> mo1448() {
        return m16111();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private synchronized Map<String, String> m16111() {
        AW aw;
        aw = new AW();
        aw.put("responseFormat", "json");
        aw.put("pathFormat", AUIApiEndpointRegistry.ResponsePathFormat.HIERARCHICAL.f2344);
        C0351 r4 = this.f15203.mo16164();
        aw.put("appVer", Integer.toString(r4.m13946()));
        aw.put("appVersion", r4.m13945());
        aw.put("appType", r4.m13951());
        aw.put("deviceLocale", String.valueOf(C2020nx.m9367().m3976()));
        aw.put("isPlayBillingEnabled", String.valueOf(BillingManager.Companion.isPlayBillingEnabled(this.f15205)));
        aw.put("installType", BillingManager.Companion.getInstallType(this.f15205));
        aw.put("isNetflixPreloaded", String.valueOf(this.f15205.mo16561()));
        String channelId = BillingManager.Companion.getChannelId(this.f15205);
        if (C1349Bv.m4107(channelId)) {
            aw.put("channelId", channelId);
        }
        String r6 = this.f15205.mo16502();
        if (C1349Bv.m4107(r6)) {
            aw.put("gAdvId", r6);
        }
        aw.put(Device.ESN, this.f15205.d_().mo14449());
        aw.put("netflixClientPlatform", "androidNative");
        aw.put("inApp", "true");
        if (this.f15208 != null && C1349Bv.m4107(this.f15208.mo1354())) {
            aw.put("availableLocales", this.f15208.mo1354());
        }
        m16109(aw);
        return aw;
    }

    @Override // com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry
    /* renamed from: ˏ */
    public synchronized Map<String, String> mo1450(AUIApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        AW aw;
        aw = new AW();
        aw.put("responseFormat", "json");
        aw.put("appVersion", this.f15203.mo16164().m13945());
        C0351 r4 = this.f15203.mo16164();
        aw.put("appVer", Integer.toString(r4.m13946()));
        aw.put("appVersion", r4.m13945());
        aw.put("appType", r4.m13951());
        aw.put("isPlayBillingEnabled", String.valueOf(BillingManager.Companion.isPlayBillingEnabled(this.f15205)));
        aw.put("installType", BillingManager.Companion.getInstallType(this.f15205));
        aw.put("isNetflixPreloaded", String.valueOf(this.f15205.mo16561()));
        String channelId = BillingManager.Companion.getChannelId(this.f15205);
        if (C1349Bv.m4107(channelId)) {
            aw.put("channelId", channelId);
        }
        aw.put(Device.ESN, this.f15205.d_().mo14449());
        aw.put("netflixClientPlatform", "androidNative");
        aw.put("inApp", "true");
        if (this.f15208 != null && C1349Bv.m4107(this.f15208.mo1354())) {
            aw.put("languages", this.f15208.mo1354());
            aw.put("availableLocales", this.f15208.mo1354());
        }
        m16109(aw);
        return aw;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˏ */
    public String mo1455(String str) {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˊ */
    public String mo1451(String str) {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˋ */
    public URL mo1452(String str) {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ॱ */
    public String mo1458(String str) {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry, com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˎ */
    public void mo1449(String str) {
        this.f15207 = str;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˎ */
    public String mo1454() {
        return this.f15207;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˋ */
    public Map<String, String> mo1453() {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˏ */
    public Map<String, String> mo1456(ApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ˏ */
    public AbstractC2039oo mo1457() {
        return null;
    }

    @Override // com.netflix.mediaclient.service.webclient.ApiEndpointRegistry
    /* renamed from: ॱ */
    public boolean mo1459() {
        return true;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m16107() {
        return true;
    }

    @Override // o.AbstractC2032oh
    /* renamed from: ʽ */
    public URL mo9650(String str) {
        return null;
    }

    @Override // o.AbstractC2032oh
    /* renamed from: ᐝ */
    public URL mo9651(String str) {
        return m16108(this.f15207, str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private URL m16108(String str, String str2) {
        StringBuilder r2 = m16106();
        r2.append(str);
        if (str2 != null) {
            r2.append(str2);
        }
        r2.append(this.f15206);
        try {
            return new URL(r2.toString());
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Unable to create URL", e);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private StringBuilder m16106() {
        StringBuilder sb = new StringBuilder();
        if (m16107()) {
            sb.append("https://");
        } else {
            sb.append("http://");
        }
        return sb;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String m16110() {
        return "/aui/pathEvaluator";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1329Bb<String, String> m16109(AbstractC1329Bb<String, String> bb) {
        return bb;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private String m16105() {
        return "android.prod.cloud.netflix.com";
    }
}
