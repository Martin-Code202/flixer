package o;

import android.content.Context;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.BwCap;
import com.netflix.mediaclient.service.webclient.model.leafs.OfflineCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamProfileData;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamingCodecPrefData;
import org.json.JSONArray;
/* renamed from: o.ｌ  reason: contains not printable characters */
public class C1231 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f15757 = "nf_configuration_account";

    /* renamed from: ˋ  reason: contains not printable characters */
    private AccountConfigData f15758;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f15759;

    public C1231(Context context) {
        this.f15759 = context;
        m16571(AccountConfigData.fromJsonString(C1339Bl.m4045(this.f15759, "accountConfig", (String) null)));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16571(AccountConfigData accountConfigData) {
        this.f15758 = accountConfigData;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16577() {
        AY ay = new AY(this.f15759);
        ay.m3497("accountConfig", (String) null);
        ay.m3496("bw_user_control_auto", -1);
        ay.m3496("bw_user_manual_setting", -1);
        ay.m3494();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONArray m16576() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getMdxBlacklistAsJsonArray();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONArray m16579() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getCastWhitelistAsJsonArray();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m16572() {
        if (this.f15758 == null) {
            return false;
        }
        return this.f15758.getCastEnabled();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m16574() {
        if (this.f15758 == null) {
            return false;
        }
        return this.f15758.toDisableSuspendPlay();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public int m16582() {
        if (this.f15758 == null) {
            return 0;
        }
        return this.f15758.getVideoBufferSize();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16580(AccountConfigData accountConfigData) {
        if (accountConfigData == null) {
            C1283.m16850(f15757, "accountConfig obj is null - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f15759, "accountConfig", accountConfigData.toJsonString());
        m16571(accountConfigData);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public BwCap m16575(StreamProfileType streamProfileType) {
        return this.f15758 != null ? this.f15758.getBwCap(streamProfileType) : StreamProfileData.Companion.getBW_CAP_DEFAULT();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public StreamingCodecPrefData m16568() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getStreamingCodecPrefData();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public OfflineCodecPrefData m16569() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getOfflineCodecPrefData();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m16570() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getPreAppWidgetExperience();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m16581() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getPreAppPartnerExperience();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean m16578() {
        return this.f15758 == null || !this.f15758.isVoipEnabledOnAccount();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public String m16573() {
        if (this.f15758 == null) {
            return null;
        }
        return this.f15758.getUserPin();
    }
}
