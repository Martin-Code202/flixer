package o;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.MediaType;
import org.json.JSONException;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public class lB {
    @SerializedName("bitrate")
    protected int bitrate;
    @SerializedName("dlid")
    protected String downloadableId;
    @SerializedName("type")
    protected String type;
    @SerializedName("vmaf")
    protected int vmaf;

    protected lB() {
    }

    public lB(JSONObject jSONObject) {
        try {
            this.downloadableId = jSONObject.getString("downloadable_id");
            this.bitrate = jSONObject.isNull("bitrate") ? 0 : jSONObject.getInt("bitrate");
            this.vmaf = jSONObject.isNull("vmaf") ? 0 : jSONObject.getInt("vmaf");
            this.type = MediaType.m1133(jSONObject.getInt("type")) == MediaType.AUDIO_STREAM ? "audio" : "video";
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
