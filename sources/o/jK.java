package o;

import com.netflix.mediaclient.media.manifest.Location;
import com.netflix.mediaclient.media.manifest.Store;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.Url;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import org.json.JSONArray;
import org.json.JSONObject;
public class jK {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static VideoTrack m7948(JSONObject jSONObject) {
        VideoTrack videoTrack = new VideoTrack();
        videoTrack.type = jSONObject.optInt("type", 0);
        videoTrack.new_track_id = jSONObject.optString("new_track_id", "");
        videoTrack.track_id = jSONObject.optString("track_id", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("streams");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                Stream r5 = m7946((JSONObject) optJSONArray.opt(i));
                if (r5 != null) {
                    videoTrack.streams.add(r5);
                }
            }
        }
        return videoTrack;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Stream m7946(JSONObject jSONObject) {
        Stream stream = null;
        if (jSONObject != null) {
            stream = new Stream();
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Url r6 = m7945((JSONObject) optJSONArray.opt(i));
                    if (r6 != null) {
                        stream.urls.add(r6);
                    }
                }
            }
            stream.new_stream_id = jSONObject.optString("new_stream_id", "");
            stream.type = jSONObject.optInt("type", 0);
            stream.bitrate = jSONObject.optInt("bitrate", 0);
            stream.vmaf = jSONObject.optInt("vmaf", 0);
            stream.trackType = jSONObject.optString("trackType", "");
            stream.downloadable_id = jSONObject.optString("downloadable_id", "");
            stream.size = Long.valueOf(jSONObject.optLong("size", 0));
            stream.isDrm = jSONObject.optBoolean("isDrm", false);
            stream.content_profile = jSONObject.optString("content_profile", "");
            stream.res_w = jSONObject.optInt("res_w", 0);
            stream.res_h = jSONObject.optInt("res_h", 0);
            stream.peakBitrate = jSONObject.optInt("peakBitrate", 0);
        }
        return stream;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Url m7945(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Url url = new Url();
        url.cdn_id = jSONObject.optInt("cdn_id", 0);
        url.url = jSONObject.optString("url", "");
        url.store = m7944(jSONObject.optJSONObject("store"));
        return url;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Store m7944(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Store store = new Store();
        store.name = jSONObject.optString("name", "");
        store.rank = jSONObject.optInt("rank", 0);
        store.type = jSONObject.optString("type", "");
        store.lowgrade = jSONObject.optBoolean("trackType", false);
        store.location = m7947(jSONObject.optJSONObject("location"));
        store.cdn_id = jSONObject.optInt("cdn_id", 0);
        return store;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Location m7947(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Location location = new Location();
        location.id = jSONObject.optString("id", "");
        location.rank = jSONObject.optInt("rank", 0);
        location.level = jSONObject.optInt("level", 0);
        location.weight = jSONObject.optInt("weight", 0);
        return location;
    }
}
