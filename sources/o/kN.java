package o;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.manifestwrapper.DashManifestConverterException;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.NetflixDataSourceUtil;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import o.kH;
import o.kO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class kN extends kO {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final StreamProfileType f8232;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f8233;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long f8234;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Long f8235;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0133[] f8236;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0133[] f8237;

    public kN(jG jGVar, kO.iF iFVar) {
        super(jGVar, null, iFVar);
        this.f8234 = jGVar.m7920();
        this.f8235 = jGVar.m7933();
        this.f8233 = m8271(jGVar);
        this.f8232 = jGVar.m7926();
        if (this.f8266 != null) {
            this.f8266.post(new Runnable() { // from class: o.kN.4
                @Override // java.lang.Runnable
                public void run() {
                    kN.this.m8272(kN.this.f8264, kN.this.f8265);
                }
            });
        } else {
            m8272(this.f8264, this.f8265);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kN$ˊ  reason: contains not printable characters */
    public class C0132 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final kD f8256;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f8258;

        C0132(JSONObject jSONObject) {
            this.f8258 = jSONObject.getString("url");
            this.f8256 = kD.m8189(jSONObject);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public String m8287() {
            return this.f8258;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public kD m8286() {
            return this.f8256;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kN$iF  reason: case insensitive filesystem */
    public class C1927iF {

        /* renamed from: ʻ  reason: contains not printable characters */
        private int f8244 = -1;

        /* renamed from: ʼ  reason: contains not printable characters */
        private int f8245 = -1;

        /* renamed from: ʽ  reason: contains not printable characters */
        private int f8246;

        /* renamed from: ˊ  reason: contains not printable characters */
        protected final int f8247;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private int f8248;

        /* renamed from: ˋ  reason: contains not printable characters */
        protected final String f8249;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final C0132[] f8250;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private final String f8252;

        /* renamed from: ॱ  reason: contains not printable characters */
        protected final String f8253;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private int f8254 = -1;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private int f8255 = -1;

        public String toString() {
            return "NfStream{downloadableId='" + this.f8253 + "', bitrateKbps=" + this.f8247 + ", contentProfile='" + this.f8249 + "'}";
        }

        C1927iF(String str, JSONObject jSONObject) {
            this.f8252 = str;
            this.f8253 = jSONObject.getString("downloadable_id");
            this.f8247 = jSONObject.getInt("bitrate");
            JSONArray jSONArray = jSONObject.getJSONArray("urls");
            int length = jSONArray.length();
            this.f8250 = new C0132[length];
            for (int i = 0; i < length; i++) {
                this.f8250[i] = new C0132(jSONArray.getJSONObject(i));
            }
            this.f8249 = jSONObject.getString("content_profile");
            if (jSONObject.has("moov") && jSONObject.has("sidx")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("moov");
                JSONObject jSONObject3 = jSONObject.getJSONObject("sidx");
                C1283.m16863("DashManifestConverter", "stream has moov: %s, sidx: %s", jSONObject2, jSONObject3);
                this.f8255 = jSONObject2.getInt("offset");
                this.f8254 = jSONObject2.getInt("size");
                this.f8244 = jSONObject3.getInt("offset");
                this.f8245 = jSONObject3.getInt("size");
            }
            this.f8246 = jSONObject.optInt("res_w", -1);
            this.f8248 = jSONObject.optInt("res_h", -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public String m8280() {
            return this.f8253;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public Representation m8281() {
            SegmentBase.SingleSegmentBase singleSegmentBase;
            String r10 = this.f8250[0].m8287();
            String r11 = NetflixDataSourceUtil.m1024(this.f8253);
            if (m8279()) {
                singleSegmentBase = new SegmentBase.SingleSegmentBase(new RangedUri(r11, (long) this.f8255, (long) (this.f8254 + this.f8245)), 1, 0, (long) this.f8255, (long) (this.f8254 + this.f8245));
            } else {
                long r13 = (long) NetflixDataSourceUtil.m1025(kN.this.f8234);
                singleSegmentBase = new SegmentBase.SingleSegmentBase(new RangedUri(r11, 0, r13), 1, 0, 0, r13);
            }
            return Representation.newInstance(this.f8252, -1, mo8278(this.f8253), r10, singleSegmentBase, null, m8283());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ */
        public Format mo8278(String str) {
            String str2 = "video/avc";
            if (C1349Bv.m4107(this.f8249)) {
                if (this.f8249.startsWith("hevc-")) {
                    str2 = "video/hevc";
                } else if (this.f8249.startsWith("vp9-")) {
                    str2 = "video/x-vnd.on2.vp9";
                }
            }
            return Format.createVideoContainerFormat(str, "video/mp4", str2, null, this.f8247 * 1000, this.f8246, this.f8248, -1.0f, null, 0);
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˏ  reason: contains not printable characters */
        public String m8283() {
            return kP.m8292(this.f8252, this.f8253, kN.this.f8235);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public kD[] m8282() {
            kD[] kDVarArr = new kD[this.f8250.length];
            for (int i = 0; i < this.f8250.length; i++) {
                kDVarArr[i] = this.f8250[i].m8286();
            }
            return kDVarArr;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public kH.Cif m8284() {
            if (m8279()) {
                return new kH.Cif(this.f8255, this.f8254 + this.f8245, m8283());
            }
            return new kH.Cif(0, NetflixDataSourceUtil.m1025(kN.this.f8234), m8283());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱॱ  reason: contains not printable characters */
        public boolean m8285() {
            return C1349Bv.m4107(this.f8249) && (this.f8249.startsWith("nodrm-h264") || this.f8249.startsWith("none-h264"));
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        private boolean m8279() {
            return this.f8244 > 0;
        }
    }

    class If extends C1927iF {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final int f8239;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final int f8240;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final String f8241;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final String f8243;

        If(String str, JSONObject jSONObject, String str2) {
            super(str, jSONObject);
            this.f8239 = jSONObject.getInt("channels");
            this.f8241 = jSONObject.getString("language");
            this.f8243 = str2;
            this.f8240 = str2.equals(kN.this.f8233) ? 1 : 0;
        }

        /* access modifiers changed from: protected */
        @Override // o.kN.C1927iF
        /* renamed from: ˏ  reason: contains not printable characters */
        public Format mo8278(String str) {
            String str2 = "audio/mp4a-latm";
            if (C1349Bv.m4107(this.f8249)) {
                if (this.f8249.startsWith("heaac-")) {
                    str2 = "audio/mp4a-latm";
                } else if (this.f8249.startsWith("ddplus-")) {
                    str2 = "audio/eac3";
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1921jv(this.f8243));
            return Format.createAudioContainerFormat(str, "audio/mp4", str2, null, this.f8247 * 1000, this.f8239, VoipConfiguration.MAX_SAMPLERATE_48K, null, this.f8240, this.f8241).copyWithMetadata(new Metadata(arrayList));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.kN$ˋ  reason: contains not printable characters */
    public class C0133 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final boolean f8259;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final boolean f8261;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f8262;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C1927iF[] f8263;

        C0133(JSONObject jSONObject) {
            this.f8262 = jSONObject.getString("new_track_id");
            String string = jSONObject.getString("track_id");
            JSONArray jSONArray = jSONObject.getJSONArray("streams");
            this.f8259 = kN.m8277(jSONObject);
            this.f8261 = jSONObject.has("drmHeader");
            int length = jSONArray.length();
            if (this.f8259) {
                this.f8263 = new If[length];
            } else {
                this.f8263 = new C1927iF[length];
            }
            for (int i = 0; i < length; i++) {
                if (this.f8259) {
                    this.f8263[i] = new If(this.f8262, jSONArray.getJSONObject(i), string);
                } else {
                    this.f8263[i] = new C1927iF(this.f8262, jSONArray.getJSONObject(i));
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public AdaptationSet m8289(int i) {
            ArrayList arrayList = new ArrayList();
            C1927iF[] iFVarArr = this.f8263;
            for (C1927iF iFVar : iFVarArr) {
                if (!this.f8261 || !iFVar.m8285()) {
                    arrayList.add(iFVar.m8281());
                } else {
                    C1283.m16863("DashManifestConverter", "skip stream %s", iFVar);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new AdaptationSet(i, this.f8259 ? 1 : 2, arrayList, null, null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public Map<String, kD[]> m8288() {
            HashMap hashMap = new HashMap();
            C1927iF[] iFVarArr = this.f8263;
            for (C1927iF iFVar : iFVarArr) {
                hashMap.put(iFVar.m8280(), iFVar.m8282());
            }
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public Map<String, kH.Cif> m8290() {
            HashMap hashMap = new HashMap();
            C1927iF[] iFVarArr = this.f8263;
            for (C1927iF iFVar : iFVarArr) {
                hashMap.put(iFVar.m8280(), iFVar.m8284());
            }
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8272(jG jGVar, kO.iF iFVar) {
        try {
            m8267(jGVar);
            iFVar.mo8264(m8275());
        } catch (DashManifestConverterException e) {
            iFVar.mo8265("DashManifestConverter error" + e);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8267(jG jGVar) {
        JSONObject r3 = jGVar.mo7908();
        if (r3 == null) {
            throw new DashManifestConverterException("NfManifest has no JSON");
        }
        JSONArray optJSONArray = r3.optJSONArray("video_tracks");
        if (optJSONArray == null) {
            throw new DashManifestConverterException("NfManifest has no video_tracks");
        }
        JSONArray optJSONArray2 = r3.optJSONArray("audio_tracks");
        if (optJSONArray2 == null) {
            throw new DashManifestConverterException("NfManifest has no audio_tracks");
        }
        try {
            int length = optJSONArray.length();
            this.f8236 = new C0133[length];
            for (int i = 0; i < length; i++) {
                this.f8236[i] = new C0133(optJSONArray.getJSONObject(i));
            }
            int length2 = optJSONArray2.length();
            this.f8237 = new C0133[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                this.f8237[i2] = new C0133(optJSONArray2.getJSONObject(i2));
            }
        } catch (JSONException e) {
            throw new DashManifestConverterException(e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private kS m8275() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        C0133[] r0 = this.f8236;
        int length = r0.length;
        for (int i2 = 0; i2 < length; i2++) {
            i++;
            AdaptationSet r27 = r0[i2].m8289(i);
            if (r27 != null) {
                arrayList.add(r27);
            }
        }
        C0133[] r02 = this.f8237;
        int length2 = r02.length;
        for (int i3 = 0; i3 < length2; i3++) {
            i++;
            AdaptationSet r272 = r02[i3].m8289(i);
            if (r272 != null) {
                arrayList.add(r272);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Period(null, 0, arrayList));
        return new kS(0, this.f8234, -1, false, -1, -1, 0, null, null, arrayList2, m8270(), m8269(), this.f8232, this.f8235);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private kF m8270() {
        HashMap hashMap = new HashMap();
        for (C0133 r5 : this.f8236) {
            hashMap.putAll(r5.m8288());
        }
        for (C0133 r52 : this.f8237) {
            hashMap.putAll(r52.m8288());
        }
        return new kF(hashMap);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private kH m8269() {
        HashMap hashMap = new HashMap();
        for (C0133 r5 : this.f8236) {
            hashMap.putAll(r5.m8290());
        }
        for (C0133 r52 : this.f8237) {
            hashMap.putAll(r52.m8290());
        }
        return new kH(hashMap);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m8271(jG jGVar) {
        AudioSubtitleDefaultOrderInfo[] r2 = jGVar.m7928();
        if (r2 == null) {
            return null;
        }
        AudioSubtitleDefaultOrderInfo audioSubtitleDefaultOrderInfo = null;
        for (AudioSubtitleDefaultOrderInfo audioSubtitleDefaultOrderInfo2 : r2) {
            if (audioSubtitleDefaultOrderInfo == null || audioSubtitleDefaultOrderInfo.getPreferenceOrder() > audioSubtitleDefaultOrderInfo2.getPreferenceOrder()) {
                audioSubtitleDefaultOrderInfo = audioSubtitleDefaultOrderInfo2;
            }
        }
        if (audioSubtitleDefaultOrderInfo == null) {
            return null;
        }
        return audioSubtitleDefaultOrderInfo.getAudioTrackId();
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m8277(JSONObject jSONObject) {
        String string = jSONObject.getString("new_track_id");
        return !string.isEmpty() && string.startsWith("A:");
    }
}
