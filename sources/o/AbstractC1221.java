package o;

import android.util.Pair;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.media.VideoResolutionRange;
import com.netflix.mediaclient.service.configuration.ImageResolutionClass;
import com.netflix.mediaclient.service.offline.agent.OfflineUnavailableReason;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.BreadcrumbLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.BwCap;
import com.netflix.mediaclient.service.webclient.model.leafs.ConsolidatedLoggingSessionSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.ErrorLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.OfflineCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.PdsAndLogblobConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamingCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.Ｆ  reason: contains not printable characters */
public interface AbstractC1221 {
    AbstractC0518 d_();

    boolean e_();

    int f_();

    boolean g_();

    boolean h_();

    boolean i_();

    boolean j_();

    boolean k_();

    StreamingCodecPrefData l_();

    OfflineCodecPrefData m_();

    int n_();

    String o_();

    String p_();

    boolean q_();

    /* renamed from: ʹ  reason: contains not printable characters */
    String mo16502();

    /* renamed from: ʻˊ  reason: contains not printable characters */
    String mo16503();

    /* renamed from: ʻˋ  reason: contains not printable characters */
    String mo16504();

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    ABTestConfigData mo16505();

    /* renamed from: ʼˊ  reason: contains not printable characters */
    String mo16506();

    /* renamed from: ʼˋ  reason: contains not printable characters */
    boolean mo16507();

    /* renamed from: ʼᐝ  reason: contains not printable characters */
    boolean mo16508();

    /* renamed from: ʽˊ  reason: contains not printable characters */
    void mo16509();

    /* renamed from: ʽˋ  reason: contains not printable characters */
    void mo16510();

    /* renamed from: ʽᐝ  reason: contains not printable characters */
    boolean mo16511();

    /* renamed from: ʾॱ  reason: contains not printable characters */
    AbstractC1378Cu mo16512();

    /* renamed from: ʿॱ  reason: contains not printable characters */
    boolean mo16513();

    /* renamed from: ˈ  reason: contains not printable characters */
    int mo16514();

    /* renamed from: ˉ  reason: contains not printable characters */
    AbstractC0346 mo16515();

    /* renamed from: ˊ  reason: contains not printable characters */
    int mo16516();

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo16517(NonMemberData nonMemberData);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo16518(String str, String str2, AbstractC1254 v);

    /* renamed from: ˊˊ  reason: contains not printable characters */
    BreadcrumbLoggingSpecification mo16519();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    AbstractC0402 mo16520();

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    ErrorLoggingSpecification mo16521();

    /* renamed from: ˋ  reason: contains not printable characters */
    VideoResolutionRange mo16522();

    /* renamed from: ˋ  reason: contains not printable characters */
    ConsolidatedLoggingSessionSpecification mo16523(String str);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo16524(boolean z, AbstractC1254 v);

    /* renamed from: ˋˋ  reason: contains not printable characters */
    String mo16525();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    void mo16526();

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    VoipConfiguration mo16527();

    /* renamed from: ˌ  reason: contains not printable characters */
    SubtitleDownloadRetryPolicy mo16528();

    /* renamed from: ˍ  reason: contains not printable characters */
    boolean mo16529();

    /* renamed from: ˎ  reason: contains not printable characters */
    int mo16530();

    /* renamed from: ˎˎ  reason: contains not printable characters */
    NonMemberData mo16531();

    /* renamed from: ˎˏ  reason: contains not printable characters */
    void mo16532();

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo16533(StatusCode statusCode);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo16534(oR oRVar, AbstractC1254 v);

    /* renamed from: ˏˎ  reason: contains not printable characters */
    boolean mo16535();

    /* renamed from: ˏˏ  reason: contains not printable characters */
    void mo16536();

    /* renamed from: ˑ  reason: contains not printable characters */
    PdsAndLogblobConfig mo16537();

    /* renamed from: ͺॱ  reason: contains not printable characters */
    SignInConfigData mo16538();

    /* renamed from: ـ  reason: contains not printable characters */
    int mo16539();

    /* renamed from: ॱ  reason: contains not printable characters */
    BwCap mo16540(StreamProfileType streamProfileType);

    /* renamed from: ॱ  reason: contains not printable characters */
    DeviceCategory mo16541();

    /* renamed from: ॱʻ  reason: contains not printable characters */
    boolean mo16542();

    /* renamed from: ॱʼ  reason: contains not printable characters */
    boolean mo16543();

    /* renamed from: ॱʽ  reason: contains not printable characters */
    boolean mo16544();

    /* renamed from: ॱˋ  reason: contains not printable characters */
    int mo16545();

    /* renamed from: ॱͺ  reason: contains not printable characters */
    Pair<String, byte[]> mo16546();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    ApiEndpointRegistry mo16547();

    /* renamed from: ᐝ  reason: contains not printable characters */
    boolean mo16548();

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    String mo16549();

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    boolean mo16550();

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    int mo16551();

    /* renamed from: ᐧ  reason: contains not printable characters */
    C0351 mo16552();

    /* renamed from: ᐨ  reason: contains not printable characters */
    ImageResolutionClass mo16553();

    /* renamed from: ᶥ  reason: contains not printable characters */
    boolean mo16554();

    /* renamed from: ㆍ  reason: contains not printable characters */
    OfflineUnavailableReason mo16555();

    /* renamed from: ꓸ  reason: contains not printable characters */
    String mo16556();

    /* renamed from: ꜞ  reason: contains not printable characters */
    boolean mo16557();

    /* renamed from: ꜟ  reason: contains not printable characters */
    boolean mo16558();

    /* renamed from: ꞌ  reason: contains not printable characters */
    String mo16559();

    /* renamed from: ﹳ  reason: contains not printable characters */
    String mo16560();

    @Deprecated
    /* renamed from: ﾞ  reason: contains not printable characters */
    boolean mo16561();

    /* renamed from: ﾟ  reason: contains not printable characters */
    String mo16562();
}
