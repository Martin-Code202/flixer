package o;

import android.content.Context;
import android.net.Uri;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.logging.client.model.Version;
import java.net.URLEncoder;
public final class zH {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C2059ph f12604;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f12605;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f12606;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f12607;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f12608;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f12609;

    public zH(C2059ph phVar, String str, String str2, boolean z, String str3) {
        if (phVar == null) {
            throw new IllegalArgumentException("Service Manager can not be null!");
        }
        this.f12604 = phVar;
        this.f12606 = str2;
        this.f12607 = z;
        this.f12608 = str3;
        m13429(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m13430() {
        return this.f12605;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m13429(String str) {
        StringBuilder sb = new StringBuilder();
        if (Uri.parse(str).getQuery() != null) {
            sb.append(str).append('&');
        } else {
            sb.append(str).append("?");
        }
        sb.append(Device.ESN).append('=').append(m13428(this.f12604.m9777().mo14449())).append('&');
        sb.append("sw_version").append('=').append(m13428(this.f12604.m9775())).append('&');
        sb.append(Version.OS).append('=').append(String.valueOf(C1317As.m3758())).append('&');
        sb.append("device_cat").append('=').append(m13428(this.f12604.m9778().m2972())).append('&');
        sb.append(LoggingRequest.LOCALE).append('=').append(m13428(this.f12606)).append('&');
        sb.append("inapp").append("=true&");
        sb.append("isNetflixPreloaded").append('=').append(this.f12604.m9827().mo16561() ? "true" : "false").append('&');
        sb.append("isPlayBillingEnabled").append('=').append(this.f12607 ? "true" : "false");
        sb.append('&').append("installType").append('=').append(this.f12604.m9827().mo16562());
        String r6 = this.f12604.m9827().mo16560();
        if (C1349Bv.m4107(r6)) {
            sb.append('&').append("channelId").append('=').append(r6);
        }
        String r7 = this.f12604.m9827().mo16502();
        if (C1349Bv.m4107(r7)) {
            sb.append('&').append("gAdvId").append('=').append(r7);
        }
        if (this.f12608 != null) {
            sb.append('&').append("uuid").append('=').append(this.f12608);
        }
        if (this.f12609 != null) {
            sb.append('&').append("titleVideoId").append('=').append(this.f12609);
        }
        Context r8 = this.f12604.m9814();
        if (C1339Bl.m4047(r8, "isAutomation")) {
            sb.append('&').append("isAutomation").append('=').append(C1339Bl.m4051(r8, "isAutomation", false));
        }
        if (C1339Bl.m4047(r8, "allocAutomation")) {
            sb.append('&').append("allocAutomation").append('=').append(C1339Bl.m4051(r8, "allocAutomation", true));
        }
        this.f12605 = sb.toString();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m13431(String str) {
        this.f12609 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m13428(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }
}
