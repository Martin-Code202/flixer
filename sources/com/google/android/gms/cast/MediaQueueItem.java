package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MediaQueueItem extends zzbck {
    public static final Parcelable.Creator<MediaQueueItem> CREATOR = new zzah();
    private String zzehn;
    private JSONObject zzeho;
    private MediaInfo zzelj;
    private int zzelk;
    private boolean zzell;
    private double zzelm;
    private double zzeln;
    private double zzelo;
    private long[] zzelp;

    public static class Builder {
        private final MediaQueueItem zzelq;

        public Builder(MediaInfo mediaInfo) {
            this.zzelq = new MediaQueueItem(mediaInfo);
        }

        public MediaQueueItem build() {
            this.zzelq.zzabp();
            return this.zzelq;
        }
    }

    private MediaQueueItem(MediaInfo mediaInfo) {
        this(mediaInfo, 0, true, 0.0d, Double.POSITIVE_INFINITY, 0.0d, null, null);
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
    }

    MediaQueueItem(MediaInfo mediaInfo, int i, boolean z, double d, double d2, double d3, long[] jArr, String str) {
        this.zzelj = mediaInfo;
        this.zzelk = i;
        this.zzell = z;
        this.zzelm = d;
        this.zzeln = d2;
        this.zzelo = d3;
        this.zzelp = jArr;
        this.zzehn = str;
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
    }

    MediaQueueItem(JSONObject jSONObject) {
        this(null, 0, true, 0.0d, Double.POSITIVE_INFINITY, 0.0d, null, null);
        zzm(jSONObject);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        if ((this.zzeho == null) != (mediaQueueItem.zzeho == null)) {
            return false;
        }
        return (this.zzeho == null || mediaQueueItem.zzeho == null || zzn.zzc(this.zzeho, mediaQueueItem.zzeho)) && zzazl.zza(this.zzelj, mediaQueueItem.zzelj) && this.zzelk == mediaQueueItem.zzelk && this.zzell == mediaQueueItem.zzell && this.zzelm == mediaQueueItem.zzelm && this.zzeln == mediaQueueItem.zzeln && this.zzelo == mediaQueueItem.zzelo && Arrays.equals(this.zzelp, mediaQueueItem.zzelp);
    }

    public long[] getActiveTrackIds() {
        return this.zzelp;
    }

    public boolean getAutoplay() {
        return this.zzell;
    }

    public int getItemId() {
        return this.zzelk;
    }

    public MediaInfo getMedia() {
        return this.zzelj;
    }

    public double getPlaybackDuration() {
        return this.zzeln;
    }

    public double getPreloadTime() {
        return this.zzelo;
    }

    public double getStartTime() {
        return this.zzelm;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzelj, Integer.valueOf(this.zzelk), Boolean.valueOf(this.zzell), Double.valueOf(this.zzelm), Double.valueOf(this.zzeln), Double.valueOf(this.zzelo), Integer.valueOf(Arrays.hashCode(this.zzelp)), String.valueOf(this.zzeho)});
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzelj.toJson());
            if (this.zzelk != 0) {
                jSONObject.put("itemId", this.zzelk);
            }
            jSONObject.put("autoplay", this.zzell);
            jSONObject.put("startTime", this.zzelm);
            if (this.zzeln != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", this.zzeln);
            }
            jSONObject.put("preloadTime", this.zzelo);
            if (this.zzelp != null) {
                JSONArray jSONArray = new JSONArray();
                for (long j : this.zzelp) {
                    jSONArray.put(j);
                }
                jSONObject.put("activeTrackIds", jSONArray);
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
        zzbcn.zza(parcel, 2, (Parcelable) getMedia(), i, false);
        zzbcn.zzc(parcel, 3, getItemId());
        zzbcn.zza(parcel, 4, getAutoplay());
        zzbcn.zza(parcel, 5, getStartTime());
        zzbcn.zza(parcel, 6, getPlaybackDuration());
        zzbcn.zza(parcel, 7, getPreloadTime());
        zzbcn.zza(parcel, 8, getActiveTrackIds(), false);
        zzbcn.zza(parcel, 9, this.zzehn, false);
        zzbcn.zzai(parcel, zze);
    }

    /* access modifiers changed from: package-private */
    public final void zzabp() {
        if (this.zzelj == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (Double.isNaN(this.zzelm) || this.zzelm < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzeln)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzelo) || this.zzelo < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public final boolean zzm(JSONObject jSONObject) {
        boolean z;
        int i;
        boolean z2 = false;
        if (jSONObject.has("media")) {
            this.zzelj = new MediaInfo(jSONObject.getJSONObject("media"));
            z2 = true;
        }
        if (jSONObject.has("itemId") && this.zzelk != (i = jSONObject.getInt("itemId"))) {
            this.zzelk = i;
            z2 = true;
        }
        if (jSONObject.has("autoplay") && this.zzell != (z = jSONObject.getBoolean("autoplay"))) {
            this.zzell = z;
            z2 = true;
        }
        if (jSONObject.has("startTime")) {
            double d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzelm) > 1.0E-7d) {
                this.zzelm = d;
                z2 = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            double d2 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d2 - this.zzeln) > 1.0E-7d) {
                this.zzeln = d2;
                z2 = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d3 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d3 - this.zzelo) > 1.0E-7d) {
                this.zzelo = d3;
                z2 = true;
            }
        }
        boolean z3 = false;
        long[] jArr = null;
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.getLong(i2);
            }
            if (this.zzelp == null) {
                z3 = true;
            } else if (this.zzelp.length != length) {
                z3 = true;
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (this.zzelp[i3] != jArr[i3]) {
                        z3 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        if (z3) {
            this.zzelp = jArr;
            z2 = true;
        }
        if (!jSONObject.has("customData")) {
            return z2;
        }
        this.zzeho = jSONObject.getJSONObject("customData");
        return true;
    }
}
