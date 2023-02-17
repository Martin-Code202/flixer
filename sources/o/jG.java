package o;

import android.graphics.Point;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.NccpAudioSource;
import com.netflix.mediaclient.media.NccpSubtitle;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class jG implements Comparable<jG>, jI {

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private static long f7926 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f7927 = jG.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private byte[] f7928;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f7929;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f7930;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private PlayerManifestData f7931;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f7932;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private String f7933;

    /* renamed from: ʾ  reason: contains not printable characters */
    private String f7934;

    /* renamed from: ʿ  reason: contains not printable characters */
    private String f7935;

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f7936 = 2000;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AudioSubtitleDefaultOrderInfo[] f7937;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private StreamProfileType f7938;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f7939;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private long f7940;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected JSONObject f7941;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f7942;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f7943;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private long f7944;

    /* renamed from: ͺ  reason: contains not printable characters */
    private long f7945;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f7946;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private PlayerPrefetchSource f7947;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f7948;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Watermark f7949;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f7950;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f7951;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f7952;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f7953;

    public jG(String str) {
        this.f7941 = new JSONObject(str);
        this.f7940 = this.f7941.optLong("timestamp", System.currentTimeMillis());
        this.f7932 = this.f7941.getLong("movieId");
        this.f7952 = this.f7941.getString("playbackContextId");
        this.f7950 = this.f7941.getLong(SessionEndedEvent.DURATION);
        this.f7946 = this.f7941.optLong("expiration", 0);
        if (this.f7946 < System.currentTimeMillis()) {
            C1283.m16850(f7927, "expiryTime is less than currentTime " + this.f7946);
        }
        JSONArray jSONArray = this.f7941.getJSONArray("video_tracks");
        this.f7953 = jSONArray.length();
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(0);
            JSONObject optJSONObject = jSONObject.optJSONObject("drmHeader");
            if (optJSONObject != null) {
                this.f7928 = C1418Ei.m4894(optJSONObject.getString("bytes"));
                this.f7930 = true;
            }
            int optInt = jSONObject.optInt("maxWidth", 0);
            int optInt2 = jSONObject.optInt("maxHeight", 0);
            int optInt3 = jSONObject.optInt("pixelAspectX", 0);
            int optInt4 = jSONObject.optInt("pixelAspectY", 0);
            this.f7951 = jSONObject.optInt("maxCroppedWidth", 0);
            this.f7948 = jSONObject.optInt("maxCroppedHeight", 0);
            if (jSONObject.optString("flavor") != null) {
                this.f7943 = jSONObject.optString("flavor");
                this.f7938 = iK.m7447(this.f7943);
            }
            C1283.m16851(f7927, "flavor: %s ", this.f7938);
            if (optInt <= 0 || optInt2 <= 0 || optInt3 <= 0 || optInt4 <= 0) {
                this.f7929 = 9;
                this.f7939 = 16;
            } else {
                this.f7929 = 100;
                this.f7939 = (int) (((((long) optInt) * ((long) optInt3)) * 100) / ((long) (optInt2 * optInt4)));
                this.f7951 = (int) ((((long) this.f7951) * ((long) this.f7939)) / ((long) optInt));
                this.f7948 = (int) ((((long) this.f7948) * ((long) this.f7929)) / ((long) optInt2));
            }
            this.f7934 = m7903(jSONObject.optString("profile", "default"));
            this.f7936 = m7899() ? SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS : 2000;
        }
        C1283.m16854(f7927, "parsing defaultTrackOrderList");
        JSONArray optJSONArray = this.f7941.optJSONArray("defaultTrackOrderList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f7937 = new AudioSubtitleDefaultOrderInfo[optJSONArray.length()];
            for (int i = 0; i < this.f7937.length; i++) {
                this.f7937[i] = new AudioSubtitleDefaultOrderInfo(optJSONArray.getJSONObject(i), this.f7940);
            }
        }
        this.f7945 = this.f7930 ? 900000 : 7200000;
        this.f7944 = System.currentTimeMillis();
        m7905();
        m7901();
        this.f7931 = new PlayerManifestData(this.f7950, m7898(), m7919(), this.f7936, this.f7934, this.f7943, m7934());
        if (this.f7931 != null) {
            C1283.m16854(f7927, "Display data from manifest is " + this.f7931.getPlaybackDisplaySpec());
        }
        C1283.m16854(f7927, "parsing manifest end.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7916() {
        this.f7942 = true;
    }

    @Override // o.jI
    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject mo7908() {
        return this.f7941;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public Long m7933() {
        return Long.valueOf(this.f7932);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public byte[] m7935() {
        return this.f7928;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m7906() {
        return this.f7952;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m7910() {
        return this.f7930;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public long m7920() {
        return this.f7950;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public Point m7929() {
        return new Point(this.f7939, this.f7929);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public Point m7925() {
        return new Point(this.f7951, this.f7948);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public AudioSubtitleDefaultOrderInfo[] m7928() {
        return this.f7937;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public PlayerManifestData m7930() {
        return this.f7931;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public List<VideoTrack> m7931() {
        C1283.m16854(f7927, "parseVideoTracks");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = null;
        try {
            jSONArray = this.f7941.getJSONArray("video_tracks");
        } catch (JSONException e) {
            C1283.m16854(f7927, "no video_tracks");
        }
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                VideoTrack r5 = jK.m7948((JSONObject) jSONArray.opt(i));
                if (r5 != null) {
                    arrayList.add(r5);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public List<VideoTrack> m7934() {
        C1283.m16854(f7927, "getVideoTracks");
        return m7931();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public Subtitle[] m7932() {
        C1283.m16854(f7927, "parsing timedtexttracks");
        if (this.f7941 == null) {
            C1283.m16854(f7927, "timedtexttracks, manifest JSONObject is not loaded ");
            return new Subtitle[0];
        }
        JSONArray optJSONArray = this.f7941.optJSONArray("timedtexttracks");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                Subtitle[] subtitleArr = new Subtitle[optJSONArray.length()];
                for (int i = 0; i < subtitleArr.length; i++) {
                    subtitleArr[i] = NccpSubtitle.newInstance(optJSONArray.getJSONObject(i), i);
                }
                return subtitleArr;
            } catch (JSONException e) {
                C1283.m16865(f7927, "exception when parsing timedtexttracks");
            }
        }
        return new Subtitle[0];
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public List<SubtitleTrackData> m7927(long j) {
        if (this.f7941 == null) {
            C1283.m16854(f7927, "getSubtitleTracks, manifest JSONObject is not loaded ");
            return null;
        }
        C1283.m16854(f7927, "parsing timedtexttracks");
        JSONArray optJSONArray = this.f7941.optJSONArray("timedtexttracks");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new SubtitleTrackData(optJSONArray.getJSONObject(i), i, j));
            }
            return arrayList;
        } catch (JSONException e) {
            C1283.m16865(f7927, "exception when parsing timedtexttracks " + e);
            return null;
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public jM[] m7936() {
        if (this.f7941 == null) {
            C1283.m16854(f7927, "getTrickplayUrls, manifest JSONObject is not loaded ");
            return new jM[0];
        }
        C1283.m16854(f7927, "parsing trickplays");
        JSONArray optJSONArray = this.f7941.optJSONArray("trickplays");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                jM[] jMVarArr = new jM[optJSONArray.length()];
                for (int i = 0; i < jMVarArr.length; i++) {
                    jMVarArr[i] = new jM(optJSONArray.getJSONObject(i));
                }
                return jMVarArr;
            } catch (JSONException e) {
                C1283.m16865(f7927, " exception when parsing trickplays");
            }
        }
        return new jM[0];
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public AudioSource[] m7907() {
        if (this.f7941 == null) {
            C1283.m16854(f7927, "getAudioTrackList, manifest JSONObject is not loaded ");
            return new AudioSource[0];
        }
        C1283.m16854(f7927, "parsing audio_tracks");
        JSONArray optJSONArray = this.f7941.optJSONArray("audio_tracks");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                AudioSource[] audioSourceArr = new AudioSource[optJSONArray.length()];
                for (int i = 0; i < audioSourceArr.length; i++) {
                    audioSourceArr[i] = NccpAudioSource.newInstance(optJSONArray.getJSONObject(i), i);
                }
                return audioSourceArr;
            } catch (JSONException e) {
                C1283.m16865(f7927, " exception when parsing audio_tracks");
            }
        }
        return new AudioSource[0];
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public String m7909() {
        return this.f7934;
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public PlayerPrefetchSource m7911() {
        return this.f7947;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7923(PlayerPrefetchSource playerPrefetchSource) {
        this.f7947 = playerPrefetchSource;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public long m7914() {
        if (this.f7942) {
            return Long.MIN_VALUE;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f7944;
        if (f7926 > 0) {
            return f7926 - currentTimeMillis;
        }
        return this.f7945 - currentTimeMillis;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m7902() {
        if (this.f7947 != null) {
            return this.f7947.m1561();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public long m7912() {
        return this.f7946;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String[] m7898() {
        List<VideoTrack> r1 = m7934();
        HashSet hashSet = new HashSet();
        for (Stream stream : r1.get(0).streams) {
            hashSet.add(Integer.valueOf(stream.bitrate));
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        String[] strArr = new String[hashSet.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = ((Integer) arrayList.get(i)).toString();
        }
        return strArr;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int compareTo(jG jGVar) {
        int r2 = jGVar.m7902() - m7902();
        if (r2 != 0) {
            return r2;
        }
        long r3 = m7914();
        long r5 = jGVar.m7914();
        if (r3 > r5) {
            return 1;
        }
        if (r3 < r5) {
            return -1;
        }
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static List<jG> m7904(JSONObject jSONObject) {
        return m7897(jSONObject, false, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static List<jG> m7900(JSONObject jSONObject) {
        return m7897(jSONObject, true, true);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static List<jG> m7897(JSONObject jSONObject, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        C1283.m16854(f7927, "parsing manifest response start ...");
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (C1349Bv.m4126(next, "timestamp")) {
                    C1283.m16854(f7927, "skip bad entry to break manifest fetch loop");
                } else {
                    String string = jSONObject.getString(next);
                    if (z2) {
                        try {
                            arrayList.add(new jC(string));
                        } catch (JSONException e) {
                            C1283.m16847(f7927, "parsing error:", e);
                            C1276.m16820().mo5731(new Throwable("parseManifestResponse adding manifest error:", e));
                        }
                    } else if (z) {
                        arrayList.add(new jH(string));
                    } else {
                        arrayList.add(new jG(string));
                    }
                }
            }
        } catch (JSONException e2) {
            C1283.m16847(f7927, "parseManifestResponse error:", e2);
            C1276.m16820().mo5731(new Throwable("parseManifestResponse error:", e2));
        }
        C1283.m16854(f7927, "parsing manifest response end.");
        return arrayList;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public JSONObject m7913() {
        JSONObject r1 = mo7915();
        if (r1 != null) {
            return r1.optJSONObject("license");
        }
        return null;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public String m7924() {
        return this.f7935;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public String m7921() {
        return this.f7933;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7905() {
        JSONObject r1 = mo7915();
        if (r1 != null) {
            JSONObject optJSONObject = r1.optJSONObject("license");
            JSONObject optJSONObject2 = r1.optJSONObject("ldl");
            if (optJSONObject != null && optJSONObject.has("href")) {
                this.f7935 = optJSONObject.optString("href");
            }
            if (optJSONObject2 != null && optJSONObject2.has("href")) {
                this.f7933 = optJSONObject2.optString("href");
            }
        }
    }

    @Override // o.jI
    /* renamed from: ˉ  reason: contains not printable characters */
    public JSONObject mo7915() {
        if (this.f7941 == null || !this.f7941.has("links")) {
            return null;
        }
        return this.f7941.optJSONObject("links");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7901() {
        if (this.f7941.has("watermarkInfo")) {
            try {
                this.f7949 = Watermark.createWatermark(this.f7941.getJSONObject("watermarkInfo"));
                C1283.m16851(f7927, "watermark : %s", this.f7949);
            } catch (Exception e) {
                C1283.m16850(f7927, "error retrieving watermark");
            }
        }
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public Watermark m7918() {
        return this.f7949;
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public PlayerManifestData.PlaybackDisplaySpec m7919() {
        return new PlayerManifestData.PlaybackDisplaySpec(m7929(), m7925());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7917(int i) {
        if (this.f7941 != null || i <= 0) {
            try {
                JSONArray jSONArray = this.f7941.getJSONArray("video_tracks");
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (!C1349Bv.m4113(jSONObject.getString("profile"))) {
                            int optInt = jSONObject.optInt("maxHeight", Integer.MAX_VALUE);
                            C1283.m16863(f7927, "has video track with max height %d", Integer.valueOf(optInt));
                            if (optInt > i) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("streams");
                                if (jSONArray2.length() != 0) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                        int optInt2 = jSONArray2.getJSONObject(i3).optInt("res_h");
                                        if (optInt2 <= i) {
                                            C1283.m16863(f7927, "add stream with height %d", Integer.valueOf(optInt2));
                                            jSONArray3.put(jSONArray2.getJSONObject(i3));
                                        } else {
                                            C1283.m16863(f7927, "remove stream with height %d", Integer.valueOf(optInt2));
                                        }
                                    }
                                    jSONObject.put("streams", jSONArray3);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                C1283.m16854(f7927, "limitVideoHeight fail to parse video_tracks.");
            }
        } else {
            C1283.m16851(f7927, "will not limit video height %d", Integer.valueOf(i));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m7903(String str) {
        if (!C1349Bv.m4107(str)) {
            return "";
        }
        if (str.startsWith("playready-h264hpl")) {
            return "AVC-HP";
        }
        if (str.startsWith("vp9-profile0-L")) {
            return "VP9";
        }
        if (str.startsWith("hevc-main10-L")) {
            return "HEVC";
        }
        if (str.startsWith("hevc-hdr-main10-L")) {
            return "HDR10";
        }
        if (str.startsWith("hevc-dv5-main10-L")) {
            return "DolbyVision";
        }
        if (str.contains("h264mp")) {
            return "AVC";
        }
        return "unknown";
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private boolean m7899() {
        String str = this.f7934;
        char c = 65535;
        switch (str.hashCode()) {
            case 85183:
                if (str.equals("VP9")) {
                    c = 1;
                    break;
                }
                break;
            case 1942359175:
                if (str.equals("AVC-HP")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public StreamProfileType m7926() {
        return this.f7938 != null ? this.f7938 : StreamProfileType.CE3;
    }
}
