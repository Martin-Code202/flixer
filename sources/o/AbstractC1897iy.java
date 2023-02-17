package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import java.util.List;
import org.json.JSONObject;
/* renamed from: o.iy  reason: case insensitive filesystem */
public interface AbstractC1897iy {

    /* renamed from: o.iy$If */
    public interface If {
        /* renamed from: ʻ */
        PlayerManifestData mo7628();

        /* renamed from: ʼ */
        String mo7629();

        /* renamed from: ʽ */
        JSONObject mo7630();

        /* renamed from: ˊ */
        Subtitle mo7631();

        /* renamed from: ˊॱ */
        String mo7632();

        /* renamed from: ˋ */
        AudioSubtitleDefaultOrderInfo[] mo7633();

        /* renamed from: ˋॱ */
        Long mo7634();

        /* renamed from: ˎ */
        Object mo7635();

        /* renamed from: ˏ */
        AudioSource[] mo7636();

        /* renamed from: ˏॱ */
        String mo7637();

        /* renamed from: ͺ */
        List<VideoTrack> mo7638();

        /* renamed from: ॱ */
        Subtitle[] mo7639();

        /* renamed from: ॱˊ */
        Watermark mo7640();

        /* renamed from: ॱˋ */
        JSONObject mo7641();

        /* renamed from: ॱॱ */
        byte[] mo7642();

        /* renamed from: ᐝ */
        byte[] mo7643();

        /* renamed from: ᐝॱ */
        C1618cl mo7644();
    }

    /* renamed from: o.iy$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˏ */
        void mo932(long j, If v, String str, Status status);
    }

    /* renamed from: ˊ */
    void mo7279(long j);

    /* renamed from: ˊ */
    void mo7280(long j, Cif ifVar);

    /* renamed from: ˋ */
    void mo7281(long j);

    /* renamed from: ˋ */
    void mo7282(long j, long j2);

    /* renamed from: ˎ */
    void mo7284(long j);

    /* renamed from: ˏ */
    void mo7287(long j);

    /* renamed from: ॱ */
    void mo7289(long j);
}
