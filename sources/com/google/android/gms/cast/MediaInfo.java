package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MediaInfo extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzae();
    private String zzehn;
    private JSONObject zzeho;
    private final String zzeks;
    private int zzekt;
    private String zzeku;
    private MediaMetadata zzekv;
    private long zzekw;
    private List<MediaTrack> zzekx;
    private TextTrackStyle zzeky;
    private List<AdBreakInfo> zzekz;
    private List<AdBreakClipInfo> zzela;

    MediaInfo(String str, int i, String str2, MediaMetadata mediaMetadata, long j, List<MediaTrack> list, TextTrackStyle textTrackStyle, String str3, List<AdBreakInfo> list2, List<AdBreakClipInfo> list3) {
        this.zzeks = str;
        this.zzekt = i;
        this.zzeku = str2;
        this.zzekv = mediaMetadata;
        this.zzekw = j;
        this.zzekx = list;
        this.zzeky = textTrackStyle;
        this.zzehn = str3;
        if (this.zzehn != null) {
            try {
                this.zzeho = new JSONObject(this.zzehn);
            } catch (JSONException unused) {
                this.zzeho = null;
                this.zzehn = null;
            }
        } else {
            this.zzeho = null;
        }
        this.zzekz = list2;
        this.zzela = list3;
    }

    MediaInfo(JSONObject jSONObject) {
        this(jSONObject.getString("contentId"), -1, null, null, -1, null, null, null, null, null);
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzekt = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzekt = 1;
        } else if ("LIVE".equals(string)) {
            this.zzekt = 2;
        } else {
            this.zzekt = -1;
        }
        this.zzeku = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.zzekv = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzekv.zzl(jSONObject2);
        }
        this.zzekw = -1;
        if (jSONObject.has(SessionEndedEvent.DURATION) && !jSONObject.isNull(SessionEndedEvent.DURATION)) {
            double optDouble = jSONObject.optDouble(SessionEndedEvent.DURATION, 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                this.zzekw = (long) (1000.0d * optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.zzekx = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.zzekx.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.zzekx = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzl(jSONObject3);
            this.zzeky = textTrackStyle;
        } else {
            this.zzeky = null;
        }
        zzk(jSONObject);
        this.zzeho = jSONObject.optJSONObject("customData");
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if ((this.zzeho == null) != (mediaInfo.zzeho == null)) {
            return false;
        }
        return (this.zzeho == null || mediaInfo.zzeho == null || zzn.zzc(this.zzeho, mediaInfo.zzeho)) && zzazl.zza(this.zzeks, mediaInfo.zzeks) && this.zzekt == mediaInfo.zzekt && zzazl.zza(this.zzeku, mediaInfo.zzeku) && zzazl.zza(this.zzekv, mediaInfo.zzekv) && this.zzekw == mediaInfo.zzekw && zzazl.zza(this.zzekx, mediaInfo.zzekx) && zzazl.zza(this.zzeky, mediaInfo.zzeky) && zzazl.zza(this.zzekz, mediaInfo.zzekz) && zzazl.zza(this.zzela, mediaInfo.zzela);
    }

    public List<AdBreakClipInfo> getAdBreakClips() {
        if (this.zzela == null) {
            return null;
        }
        return Collections.unmodifiableList(this.zzela);
    }

    public List<AdBreakInfo> getAdBreaks() {
        if (this.zzekz == null) {
            return null;
        }
        return Collections.unmodifiableList(this.zzekz);
    }

    public String getContentId() {
        return this.zzeks;
    }

    public String getContentType() {
        return this.zzeku;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzekx;
    }

    public MediaMetadata getMetadata() {
        return this.zzekv;
    }

    public long getStreamDuration() {
        return this.zzekw;
    }

    public int getStreamType() {
        return this.zzekt;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzeky;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzeks, Integer.valueOf(this.zzekt), this.zzeku, this.zzekv, Long.valueOf(this.zzekw), String.valueOf(this.zzeho), this.zzekx, this.zzeky, this.zzekz, this.zzela});
    }

    public final JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzeks);
            switch (this.zzekt) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.zzeku != null) {
                jSONObject.put("contentType", this.zzeku);
            }
            if (this.zzekv != null) {
                jSONObject.put("metadata", this.zzekv.toJson());
            }
            if (this.zzekw <= -1) {
                jSONObject.put(SessionEndedEvent.DURATION, JSONObject.NULL);
            } else {
                jSONObject.put(SessionEndedEvent.DURATION, ((double) this.zzekw) / 1000.0d);
            }
            if (this.zzekx != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack mediaTrack : this.zzekx) {
                    jSONArray.put(mediaTrack.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzeky != null) {
                jSONObject.put("textTrackStyle", this.zzeky.toJson());
            }
            if (this.zzeho != null) {
                jSONObject.put("customData", this.zzeho);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.zzehn = this.zzeho == null ? null : this.zzeho.toString();
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getContentId(), false);
        zzbcn.zzc(parcel, 3, getStreamType());
        zzbcn.zza(parcel, 4, getContentType(), false);
        zzbcn.zza(parcel, 5, (Parcelable) getMetadata(), i, false);
        zzbcn.zza(parcel, 6, getStreamDuration());
        zzbcn.zzc(parcel, 7, getMediaTracks(), false);
        zzbcn.zza(parcel, 8, (Parcelable) getTextTrackStyle(), i, false);
        zzbcn.zza(parcel, 9, this.zzehn, false);
        zzbcn.zzc(parcel, 10, getAdBreaks(), false);
        zzbcn.zzc(parcel, 11, getAdBreakClips(), false);
        zzbcn.zzai(parcel, zze);
    }

    /* access modifiers changed from: package-private */
    public final void zzk(JSONObject jSONObject) {
        if (jSONObject.has("breaks")) {
            JSONArray jSONArray = jSONObject.getJSONArray("breaks");
            this.zzekz = new ArrayList(jSONArray.length());
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    break;
                }
                AdBreakInfo zzi = AdBreakInfo.zzi(jSONArray.getJSONObject(i));
                if (zzi == null) {
                    this.zzekz.clear();
                    break;
                } else {
                    this.zzekz.add(zzi);
                    i++;
                }
            }
        }
        if (jSONObject.has("breakClips")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("breakClips");
            this.zzela = new ArrayList(jSONArray2.length());
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                AdBreakClipInfo zzh = AdBreakClipInfo.zzh(jSONArray2.getJSONObject(i2));
                if (zzh != null) {
                    this.zzela.add(zzh);
                } else {
                    this.zzela.clear();
                    return;
                }
            }
        }
    }

    public final void zzx(List<AdBreakInfo> list) {
        this.zzekz = list;
    }
}
