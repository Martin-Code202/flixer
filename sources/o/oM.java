package o;

import android.view.Surface;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.servicemgr.ExitPipAction;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.nio.ByteBuffer;
public interface oM {

    public interface iF {
        /* renamed from: ˊ */
        void mo7418(IPlayer.aux aux);
    }

    /* renamed from: o.oM$ˊ  reason: contains not printable characters */
    public interface AbstractC0160 {
        void ac_();

        void ad_();

        boolean ae_();

        /* renamed from: ˊ */
        void mo2351(IPlayer.PlayerStallReason playerStallReason);

        /* renamed from: ˋ */
        void mo2352(IPlayer.aux aux);

        /* renamed from: ˎ */
        void mo2353(Watermark watermark);

        /* renamed from: ˎ */
        void mo2354(C1987mr mrVar);

        /* renamed from: ॱ */
        void mo2355(long j);

        /* renamed from: ᐝ */
        void mo2356();
    }

    void K_();

    /* renamed from: ʼॱ */
    Subtitle[] mo890();

    @Override // o.AbstractC1977mh
    /* renamed from: ʽॱ */
    Subtitle mo891();

    /* renamed from: ʾ */
    boolean mo892();

    /* renamed from: ʿ */
    AudioSource mo893();

    /* renamed from: ˈ */
    AudioSubtitleDefaultOrderInfo[] mo894();

    /* renamed from: ˉ */
    Watermark mo895();

    /* renamed from: ˊ */
    void mo897(long j, boolean z);

    /* renamed from: ˊ */
    void mo898(AbstractC0160 v);

    /* renamed from: ˊ */
    boolean mo901(AudioSource audioSource);

    /* renamed from: ˊˊ */
    StreamProfileType mo902();

    /* renamed from: ˊˋ */
    void mo903();

    /* renamed from: ˊᐝ */
    PlayerManifestData mo904();

    /* renamed from: ˋ */
    ByteBuffer mo905(long j);

    /* renamed from: ˋ */
    void mo906(Surface surface);

    /* renamed from: ˋ */
    void mo907(ExitPipAction exitPipAction);

    /* renamed from: ˋ */
    void mo909(boolean z);

    /* renamed from: ˋ */
    AudioSource[] mo7753();

    /* renamed from: ˋᐝ */
    ISubtitleDef.SubtitleProfile mo913();

    /* renamed from: ˌ */
    IPlayer.PlaybackType mo914();

    /* renamed from: ˎ */
    void mo915(float f);

    /* renamed from: ˎ */
    boolean mo918(Subtitle subtitle, boolean z);

    /* renamed from: ˏ */
    long mo7754();

    /* renamed from: ˏ */
    void mo919(int i, int i2);

    /* renamed from: ˏ */
    void mo921(AbstractC0160 v);

    /* renamed from: ˏ */
    void mo7758(boolean z);

    /* renamed from: ॱ */
    C1987mr mo924(long j);

    /* renamed from: ॱ */
    void mo926(boolean z);

    /* renamed from: ॱˋ */
    void mo927();

    /* renamed from: ॱˎ */
    long mo928();

    /* renamed from: ॱᐝ */
    void mo929();

    /* renamed from: ᐝॱ */
    void mo931();
}
