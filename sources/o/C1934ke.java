package o;

import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import com.netflix.mediaclient.servicemgr.IPlayer;
import org.json.JSONObject;
/* renamed from: o.ke  reason: case insensitive filesystem */
public class C1934ke implements IPlayer.aux {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f8381 = "100";

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f8382;

    /* renamed from: ˎ  reason: contains not printable characters */
    private StreamingPlaybackErrorCode f8383;

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject f8384 = new JSONObject();

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8385 = "";

    public C1934ke(lX lXVar) {
        if (lXVar != null) {
            this.f8385 = lXVar.m8711();
            this.f8381 = lXVar.m8713();
            this.f8384 = lXVar.m8710();
        }
    }

    public C1934ke(StreamingPlaybackErrorCode streamingPlaybackErrorCode, boolean z) {
        this.f8383 = streamingPlaybackErrorCode;
        this.f8381 = this.f8383.m1004() + "";
        this.f8382 = z;
    }

    public String toString() {
        return "StreamingPlaybackError{mCode=" + this.f8383 + ", mUserDisplayErrorString='" + this.f8385 + "', mUiDisplayErrorCode='" + this.f8381 + "', mErrExtraInfo=" + this.f8384 + '}';
    }

    public C1934ke(String str, String str2, JSONObject jSONObject) {
        this.f8385 = str;
        this.f8381 = str2;
        this.f8384 = jSONObject;
    }

    public C1934ke(StreamingPlaybackErrorCode streamingPlaybackErrorCode) {
        this.f8383 = streamingPlaybackErrorCode;
        this.f8381 = this.f8383.m1004() + "";
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˎ */
    public String mo1000() {
        return this.f8385;
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˊ */
    public int mo998() {
        return 0;
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˏ */
    public String mo1001() {
        return this.f8381;
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ˋ */
    public boolean mo999() {
        return this.f8382;
    }

    @Override // com.netflix.mediaclient.servicemgr.IPlayer.aux
    /* renamed from: ʼ */
    public boolean mo997() {
        return this.f8383 == StreamingPlaybackErrorCode.RESTART_APP_SESSION_ERROR;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m8379() {
        return this.f8384;
    }
}
