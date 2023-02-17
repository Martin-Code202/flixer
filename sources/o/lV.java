package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.StopReason;
import com.netflix.mediaclient.servicemgr.ExitPipAction;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import o.AbstractC1933kd;
import org.json.JSONObject;
public interface lV {
    /* renamed from: ʻ */
    void mo8578();

    /* renamed from: ʼ */
    void mo8579();

    /* renamed from: ʽ */
    lX mo8580();

    /* renamed from: ˊ */
    lX mo8581(ISubtitleDef.SubtitleFailure subtitleFailure, Status status);

    /* renamed from: ˊ */
    void mo8582();

    /* renamed from: ˋ */
    void mo8585(long j);

    /* renamed from: ˋ */
    void mo8586(long j, long j2, String str, long j3);

    /* renamed from: ˋ */
    void mo8587(long j, String str);

    /* renamed from: ˋ */
    void mo8589(String str);

    /* renamed from: ˋॱ */
    void mo8591();

    /* renamed from: ˎ */
    void mo8592(long j);

    /* renamed from: ˎ */
    void mo8593(StopReason stopReason, long j);

    /* renamed from: ˎ */
    void mo8597(JSONObject jSONObject);

    /* renamed from: ˏ */
    lX mo8598(StreamingPlaybackErrorCode streamingPlaybackErrorCode, Status status);

    /* renamed from: ˏ */
    void mo8600(long j, AbstractC1933kd.iF iFVar);

    /* renamed from: ˏ */
    void mo8602(String str);

    /* renamed from: ˏ */
    void mo8603(String str, int i, String str2, int i2);

    /* renamed from: ˏ */
    void mo8604(String str, long j, String str2);

    /* renamed from: ˏ */
    void mo8606(JSONObject jSONObject, AbstractC1221 v);

    /* renamed from: ˏॱ */
    int mo8608();

    /* renamed from: ॱ */
    lX mo8609(String str);

    /* renamed from: ॱ */
    void mo8612(ExitPipAction exitPipAction, long j);

    /* renamed from: ᐝ */
    void mo8614();
}
