package o;

import android.content.Context;
import com.netflix.mediaclient.media.VideoResolutionRange;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.DeviceCategory;
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
public abstract class iW {

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static boolean f7661;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f7662 = iW.class.getSimpleName();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static boolean f7663;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static boolean f7664;

    /* renamed from: ͺ  reason: contains not printable characters */
    private static boolean f7665;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private static boolean f7666;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static boolean f7667;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private static boolean f7668;

    /* renamed from: ʻ  reason: contains not printable characters */
    private String[] f7669;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f7670;

    /* renamed from: ʽ  reason: contains not printable characters */
    private IBladeRunnerClient.ManifestRequestFlavor f7671;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f7672;

    /* renamed from: ˎ  reason: contains not printable characters */
    private UserAgentInterface f7673;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final AbstractC1221 f7674;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7675 = 2;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private ConnectivityUtils.NetType f7676;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f7677;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private VideoResolutionRange f7678;

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract boolean mo7607();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract boolean mo7608(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract boolean mo7610();

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract boolean mo7612();

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo7614(JSONObject jSONObject);

    static {
        m7599();
    }

    public iW(Context context, UserAgentInterface userAgentInterface, AbstractC1221 r4, ConnectivityUtils.NetType netType) {
        this.f7672 = context;
        this.f7674 = r4;
        this.f7673 = userAgentInterface;
        this.f7676 = netType;
        this.f7670 = AV.m3472() && this.f7674.g_();
        this.f7678 = this.f7674.mo16522();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public iW m7605(IBladeRunnerClient.ManifestRequestFlavor manifestRequestFlavor) {
        this.f7671 = manifestRequestFlavor;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public iW m7611(String str) {
        this.f7677 = str;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public iW m7606(String[] strArr) {
        this.f7669 = strArr;
        return this;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private String m7583() {
        return "manifest";
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String m7600() {
        return "/" + m7583();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7609(JSONArray jSONArray) {
        if (this.f7674.mo16541() == DeviceCategory.PHONE) {
            jSONArray.put("playready-h264mpl13-dash");
            jSONArray.put("none-h264mpl13-dash");
        }
        jSONArray.put("none-h264mpl30-dash");
        jSONArray.put("playready-h264mpl30-dash");
        if (this.f7678.getMaxHeight() >= 720 && this.f7670) {
            jSONArray.put("playready-h264mpl31-dash");
            jSONArray.put("none-h264mpl31-dash");
            C1283.m16854(f7662, "device supports 720P");
        }
        if (this.f7678.getMaxHeight() >= 1080 && this.f7670) {
            jSONArray.put("playready-h264mpl40-dash");
            jSONArray.put("none-h264mpl40-dash");
            C1283.m16854(f7662, "device supports 1080P");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7596(JSONArray jSONArray) {
        C1283.m16854(f7662, "add AVC High Proflies");
        jSONArray.put("playready-h264hpl22-dash");
        jSONArray.put("playready-h264hpl30-dash");
        if (this.f7678.getMaxHeight() >= 540) {
            jSONArray.put("playready-h264hpl31-dash");
            C1283.m16854(f7662, "add AVC High Proflies 540 & 720P");
        }
        if (this.f7678.getMaxHeight() >= 1080 && this.f7670) {
            jSONArray.put("playready-h264hpl40-dash");
            C1283.m16854(f7662, "add AVC High Proflies 1080P");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7592(JSONArray jSONArray) {
        jSONArray.put("hevc-main10-L30-dash-cenc");
        if (this.f7678.getMaxHeight() >= 720 && this.f7670 && C1914jo.m8022()) {
            jSONArray.put("hevc-main10-L31-dash-cenc");
        }
        C1283.m16854(f7662, "device supports HEVC");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7587(JSONArray jSONArray) {
        jSONArray.put("vp9-profile0-L21-dash-cenc");
        jSONArray.put("vp9-profile0-L30-dash-cenc");
        if (this.f7678.getMaxHeight() >= 720 && this.f7670 && C1914jo.m8019()) {
            jSONArray.put("vp9-profile0-L31-dash-cenc");
            C1283.m16854(f7662, "add VP9 720P");
        }
        if (this.f7678.getMaxHeight() >= 1080 && this.f7670 && C1914jo.m8019()) {
            jSONArray.put("vp9-profile0-L40-dash-cenc");
            C1283.m16854(f7662, "add VP9 1080P");
        }
        C1283.m16854(f7662, "device supports VP9");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7589(JSONArray jSONArray) {
        jSONArray.put("hevc-hdr-main10-L30-dash-cenc-prk");
        jSONArray.put("hevc-hdr-main10-L31-dash-cenc-prk");
        jSONArray.put("hevc-hdr-main10-L40-dash-cenc-prk");
        C1283.m16854(f7662, "device supports Hdr10");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m7585(JSONArray jSONArray) {
        jSONArray.put("hevc-dv5-main10-L30-dash-cenc-prk");
        jSONArray.put("hevc-dv5-main10-L31-dash-cenc-prk");
        jSONArray.put("hevc-dv5-main10-L40-dash-cenc-prk");
        jSONArray.put("hevc-dv5-main10-L41-dash-cenc-prk");
        C1283.m16854(f7662, "device supports Dolby Vision");
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m7584(JSONArray jSONArray) {
        boolean h_ = this.f7674.h_();
        boolean r2 = this.f7674.mo16544();
        jSONArray.put("heaac-2-dash");
        if (r2) {
            jSONArray.put("ddplus-2.0-dash");
        }
        if (h_) {
            jSONArray.put("ddplus-5.1-dash");
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m7601(JSONArray jSONArray) {
        jSONArray.put("simplesdh").put("dfxp-ls-sdh").put("nflx-cmisc");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m7602(JSONArray jSONArray) {
        jSONArray.put("BIF320");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7590(JSONObject jSONObject) {
        jSONObject.putOpt("osName", "android");
        jSONObject.putOpt("osVersion", String.valueOf(C1317As.m3758()));
        jSONObject.putOpt("application", "samurai");
        jSONObject.putOpt("clientVersion", this.f7677);
        jSONObject.putOpt("uiVersion", this.f7677);
        jSONObject.putOpt("player", this instanceof C1900ja ? "offline" : "streaming");
        jSONObject.putOpt("hardware", this.f7674.mo16559());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7593(JSONObject jSONObject) {
        jSONObject.put("method", m7583());
        if (this.f7671 != null) {
            jSONObject.put("flavor", this.f7671.m942());
        }
        jSONObject.put("useHttpsStreams", true);
        jSONObject.put("drmType", "widevine");
        jSONObject.put("supportsWatermark", true);
        jSONObject.put("supportsPreReleasePin", true);
        if (mo7612()) {
            jSONObject.put("supportsEveVP9", true);
        }
        ConnectivityUtils.m2957(jSONObject, this.f7676);
        jSONObject.put("viewableIds", new JSONArray((Collection) Arrays.asList(this.f7669)));
        m7590(jSONObject);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public String m7604() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONArray r5 = mo7613();
            m7584(r5);
            m7601(r5);
            m7602(r5);
            jSONObject.put("profiles", r5);
            m7593(jSONObject);
            mo7614(jSONObject);
            jSONObject2 = new JSONObject();
            jSONObject2.put(LoggingRequest.VERSION, this.f7675);
            jSONObject2.put("params", jSONObject);
            jSONObject2.put("url", m7600());
            jSONObject2.put("languages", new JSONArray((Collection) Arrays.asList(this.f7673.mo1383().getLanguages())));
        } catch (Exception e) {
            C1283.m16856(f7662, e, "error creating manifest params", new Object[0]);
        }
        return jSONObject2.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONArray mo7613() {
        JSONArray jSONArray = new JSONArray();
        if (mo7610() && m7586()) {
            m7587(jSONArray);
        }
        if (mo7607() && m7595() && mo7608(this.f7672)) {
            m7596(jSONArray);
        }
        m7609(jSONArray);
        if (m7582() && m7603() && m7591()) {
            m7592(jSONArray);
        }
        if (m7588() && m7594()) {
            m7589(jSONArray);
        }
        if (m7597() && m7598()) {
            m7585(jSONArray);
        }
        return jSONArray;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m7582() {
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m7586() {
        return (this.f7670 && C1914jo.m8019()) || C1914jo.m8025();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m7603() {
        return this.f7674.mo16554();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean m7591() {
        return (this.f7670 && C1914jo.m8022()) || C1914jo.m8021();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean m7595() {
        return (this.f7670 && C1914jo.m8014() && C1914jo.m8015()) || C1914jo.m8015();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean m7588() {
        return this.f7674.i_();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean m7594() {
        return this.f7670 && C1914jo.m8027() && C1317As.m3772(this.f7672);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean m7597() {
        return this.f7674.j_();
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean m7598() {
        return this.f7670 && C1914jo.m8028() && C1317As.m3746(this.f7672);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private static void m7599() {
        f7661 = false;
        f7667 = false;
        f7665 = false;
        f7664 = false;
        f7666 = false;
        f7663 = false;
        f7668 = false;
    }
}
