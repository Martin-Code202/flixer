package o;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.NetworkErrorJson;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.AbstractC1952kz;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public class lL extends lC {
    @SerializedName("actualbt")
    protected Long actualbt;
    @SerializedName("actualbw")
    protected Long actualbw;
    @SerializedName("adlid")
    protected String adlid;
    @SerializedName("abitrate")
    protected Integer audioBitrate;
    @SerializedName("brokendlid")
    protected Long brokendlid;
    @SerializedName("cachehit")
    protected Boolean cachehit;
    @SerializedName("carrier")
    protected String carrier;
    @SerializedName("cdnid")
    protected String cdnid;
    @SerializedName("cdnname")
    protected String cdnname;
    @SerializedName("cronetbw")
    protected Integer cronetbw;
    @SerializedName("deviceerrorstring")
    protected String deviceErrorString;
    @SerializedName("deviceerrorcode")
    protected String deviceerrorcode;
    @SerializedName("downloadables")
    protected List<lB> downloadables = new ArrayList();
    @SerializedName("errorcode")
    protected String errorcode;
    @SerializedName("errormsg")
    protected String errormsg;
    @SerializedName("errorstring")
    protected String errorstring;
    @SerializedName("fastplay")
    protected Boolean fastplay;
    @SerializedName("filetoken")
    protected String filetoken;
    @SerializedName("groupname")
    protected String groupname;
    @SerializedName("headerCacheDataAudio")
    protected Long headerCacheDataAudio;
    @SerializedName("headerCacheDataVideo")
    protected Long headerCacheDataVideo;
    @SerializedName("headerCacheHit")
    protected Boolean headerCacheHit;
    @SerializedName("histbw")
    protected Integer histbw;
    @SerializedName("histniqr")
    protected Double histniqr;
    @SerializedName("histp25")
    protected Integer histp25;
    @SerializedName("histp50")
    protected Integer histp50;
    @SerializedName("histp75")
    protected Integer histp75;
    @SerializedName("httperr")
    protected Long httperr;
    @SerializedName("uiLabel")
    private String mUiLabel;
    @SerializedName("manifestage")
    protected Long manifestAge;
    @SerializedName("manifestCacheSource")
    protected String manifestCacheSource;
    @SerializedName("mcc")
    protected Integer mcc;
    @SerializedName("mnc")
    protected Integer mnc;
    @SerializedName("mid")
    protected Long movieId;
    @SerializedName("nccperr")
    protected Long nccperr;
    @SerializedName("netspec")
    protected CurrentNetworkInfo.NetSpec netspec;
    @SerializedName("nettype")
    protected CurrentNetworkInfo.NetType nettype;
    @SerializedName("nwerr")
    protected NetworkErrorJson nwerr;
    @SerializedName("pipeline")
    protected boolean pipelineEnabled = false;
    @SerializedName("playbackcontextid")
    protected String playbackcontextid;
    @SerializedName("playdelay")
    protected Long playdelay;
    @SerializedName("eventlist")
    protected Map<String, Long> startPlayEvents;
    @SerializedName("trackid")
    protected Long trackingId;
    @SerializedName("usedldl")
    protected Boolean usedldl;
    @SerializedName("vdlid")
    protected String vdlId;
    @SerializedName("vbitrate")
    protected Integer videoBitrate;

    protected lL() {
    }

    public lL(String str) {
        super("startplay", str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lL m8634(Long l) {
        this.movieId = l;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8626(long j) {
        this.trackingId = Long.valueOf(j);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8628(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("video_tracks");
            JSONArray jSONArray2 = jSONObject.getJSONArray("audio_tracks");
            ArrayList<JSONObject> arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList.add(jSONArray2.getJSONObject(i2));
            }
            for (JSONObject jSONObject2 : arrayList) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("streams");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    this.downloadables.add(new lB(jSONArray3.getJSONObject(i3)));
                }
            }
            this.playbackcontextid = jSONObject.getString("playbackContextId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lL m8642(String str) {
        this.adlid = str;
        Iterator<lB> it = this.downloadables.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            lB next = it.next();
            if (next.downloadableId.equals(str)) {
                this.audioBitrate = Integer.valueOf(next.bitrate);
                break;
            }
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8644(long j) {
        super.m8545(j);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m8633() {
        if (this.moffms == null) {
            return 0;
        }
        return this.moffms.longValue();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lL m8641(Long l) {
        this.playdelay = l;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lL m8625(AbstractC1952kz.If r7) {
        if (r7 != null) {
            this.cdnid = Integer.toString(r7.f8472);
            AbstractC1952kz.C0141[] r2 = r7.f8467;
            int length = r2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AbstractC1952kz.C0141 r5 = r2[i];
                if (this.cdnid.equals(r5.f8480)) {
                    this.cdnname = r5.f8483;
                    break;
                }
                i++;
            }
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8627(AbstractC1952kz.C0142 r2) {
        this.vdlId = r2.f8490;
        this.videoBitrate = Integer.valueOf(r2.f8491);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lL m8640(Long l) {
        this.actualbw = l;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lL m8623(Long l) {
        this.actualbt = l;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lL m8637(lX lXVar) {
        if (lXVar == null) {
            m8546(f8502);
            this.errorcode = null;
            this.errorstring = null;
            this.deviceerrorcode = null;
            this.deviceErrorString = null;
            this.errormsg = null;
        } else {
            m8546(Logblob.Severity.error);
            this.errorcode = lXVar.m8715();
            this.errorstring = lXVar.m8712();
            this.deviceerrorcode = lXVar.m8708();
            this.deviceErrorString = lXVar.m8716();
            this.errormsg = lXVar.m8709();
        }
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lL m8635(String str) {
        if (TextUtils.isEmpty(str)) {
            this.groupname = "control";
        } else {
            this.groupname = str;
        }
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public lL m8629(int i) {
        if (i > 0) {
            this.cronetbw = Integer.valueOf(i);
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lL m8643(AbstractC1952kz.C0143 r3) {
        if (r3 != null) {
            this.histbw = Integer.valueOf(r3.f8493);
            this.histniqr = Double.valueOf(r3.f8492);
            this.histp75 = Integer.valueOf(r3.f8495);
            this.histp50 = Integer.valueOf(r3.f8496);
            this.histp25 = Integer.valueOf(r3.f8494);
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lL m8624(String str) {
        this.mUiLabel = str;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8638(Boolean bool) {
        this.cachehit = bool;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8646(boolean z, long j, long j2) {
        this.headerCacheHit = Boolean.valueOf(z);
        if (z) {
            this.headerCacheDataAudio = Long.valueOf(j);
            this.headerCacheDataVideo = Long.valueOf(j2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8631(Long l) {
        this.manifestAge = l;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lL m8636(Map<String, Long> map) {
        this.startPlayEvents = new HashMap(map);
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8630(Boolean bool) {
        this.usedldl = bool;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8632(String str) {
        this.manifestCacheSource = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8645(CurrentNetworkInfo currentNetworkInfo) {
        this.carrier = currentNetworkInfo.m1038();
        this.mcc = currentNetworkInfo.m1037();
        this.mnc = currentNetworkInfo.m1041();
        this.nettype = currentNetworkInfo.m1039();
        this.netspec = currentNetworkInfo.m1040();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lL m8639(long j) {
        m8547(j);
        return this;
    }
}
