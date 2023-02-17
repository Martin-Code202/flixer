package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MediaStatus extends zzbck {
    public static final Parcelable.Creator<MediaStatus> CREATOR = new zzai();
    private String zzehn;
    private JSONObject zzeho;
    private MediaInfo zzelb;
    private long[] zzelp;
    private long zzelr;
    private int zzels;
    private double zzelt;
    private int zzelu;
    private int zzelv;
    private long zzelw;
    private long zzelx;
    private double zzely;
    private boolean zzelz;
    private int zzema;
    private int zzemb;
    private int zzemc;
    private ArrayList<MediaQueueItem> zzemd;
    private boolean zzeme;
    private AdBreakStatus zzemf;
    private VideoInfo zzemg;
    private final SparseArray<Integer> zzemh;

    MediaStatus(MediaInfo mediaInfo, long j, int i, double d, int i2, int i3, long j2, long j3, double d2, boolean z, long[] jArr, int i4, int i5, String str, int i6, List<MediaQueueItem> list, boolean z2, AdBreakStatus adBreakStatus, VideoInfo videoInfo) {
        this.zzemd = new ArrayList<>();
        this.zzemh = new SparseArray<>();
        this.zzelb = mediaInfo;
        this.zzelr = j;
        this.zzels = i;
        this.zzelt = d;
        this.zzelu = i2;
        this.zzelv = i3;
        this.zzelw = j2;
        this.zzelx = j3;
        this.zzely = d2;
        this.zzelz = z;
        this.zzelp = jArr;
        this.zzema = i4;
        this.zzemb = i5;
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
        this.zzemc = i6;
        if (list != null && !list.isEmpty()) {
            zza((MediaQueueItem[]) list.toArray(new MediaQueueItem[list.size()]));
        }
        this.zzeme = z2;
        this.zzemf = adBreakStatus;
        this.zzemg = videoInfo;
    }

    public MediaStatus(JSONObject jSONObject) {
        this(null, 0, 0, 0.0d, 0, 0, 0, 0, 0.0d, false, null, 0, 0, null, 0, null, false, null, null);
        zza(jSONObject, 0);
    }

    private final void zza(MediaQueueItem[] mediaQueueItemArr) {
        this.zzemd.clear();
        this.zzemh.clear();
        for (int i = 0; i < mediaQueueItemArr.length; i++) {
            MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
            this.zzemd.add(mediaQueueItem);
            this.zzemh.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        if ((this.zzeho == null) != (mediaStatus.zzeho == null) || this.zzelr != mediaStatus.zzelr || this.zzels != mediaStatus.zzels || this.zzelt != mediaStatus.zzelt || this.zzelu != mediaStatus.zzelu || this.zzelv != mediaStatus.zzelv || this.zzelw != mediaStatus.zzelw || this.zzely != mediaStatus.zzely || this.zzelz != mediaStatus.zzelz || this.zzema != mediaStatus.zzema || this.zzemb != mediaStatus.zzemb || this.zzemc != mediaStatus.zzemc || !Arrays.equals(this.zzelp, mediaStatus.zzelp) || !zzazl.zza(Long.valueOf(this.zzelx), Long.valueOf(mediaStatus.zzelx)) || !zzazl.zza(this.zzemd, mediaStatus.zzemd) || !zzazl.zza(this.zzelb, mediaStatus.zzelb)) {
            return false;
        }
        return (this.zzeho == null || mediaStatus.zzeho == null || zzn.zzc(this.zzeho, mediaStatus.zzeho)) && this.zzeme == mediaStatus.isPlayingAd();
    }

    public long[] getActiveTrackIds() {
        return this.zzelp;
    }

    public AdBreakStatus getAdBreakStatus() {
        return this.zzemf;
    }

    public int getCurrentItemId() {
        return this.zzels;
    }

    public int getIdleReason() {
        return this.zzelv;
    }

    public Integer getIndexById(int i) {
        return this.zzemh.get(i);
    }

    public MediaQueueItem getItemById(int i) {
        Integer num = this.zzemh.get(i);
        if (num == null) {
            return null;
        }
        return this.zzemd.get(num.intValue());
    }

    public int getLoadingItemId() {
        return this.zzema;
    }

    public MediaInfo getMediaInfo() {
        return this.zzelb;
    }

    public double getPlaybackRate() {
        return this.zzelt;
    }

    public int getPlayerState() {
        return this.zzelu;
    }

    public int getPreloadedItemId() {
        return this.zzemb;
    }

    public MediaQueueItem getQueueItemById(int i) {
        return getItemById(i);
    }

    public int getQueueItemCount() {
        return this.zzemd.size();
    }

    public int getQueueRepeatMode() {
        return this.zzemc;
    }

    public long getStreamPosition() {
        return this.zzelw;
    }

    public double getStreamVolume() {
        return this.zzely;
    }

    public VideoInfo getVideoInfo() {
        return this.zzemg;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzelb, Long.valueOf(this.zzelr), Integer.valueOf(this.zzels), Double.valueOf(this.zzelt), Integer.valueOf(this.zzelu), Integer.valueOf(this.zzelv), Long.valueOf(this.zzelw), Long.valueOf(this.zzelx), Double.valueOf(this.zzely), Boolean.valueOf(this.zzelz), Integer.valueOf(Arrays.hashCode(this.zzelp)), Integer.valueOf(this.zzema), Integer.valueOf(this.zzemb), String.valueOf(this.zzeho), Integer.valueOf(this.zzemc), this.zzemd, Boolean.valueOf(this.zzeme)});
    }

    public boolean isMute() {
        return this.zzelz;
    }

    public boolean isPlayingAd() {
        return this.zzeme;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.zzehn = this.zzeho == null ? null : this.zzeho.toString();
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, (Parcelable) getMediaInfo(), i, false);
        zzbcn.zza(parcel, 3, this.zzelr);
        zzbcn.zzc(parcel, 4, getCurrentItemId());
        zzbcn.zza(parcel, 5, getPlaybackRate());
        zzbcn.zzc(parcel, 6, getPlayerState());
        zzbcn.zzc(parcel, 7, getIdleReason());
        zzbcn.zza(parcel, 8, getStreamPosition());
        zzbcn.zza(parcel, 9, this.zzelx);
        zzbcn.zza(parcel, 10, getStreamVolume());
        zzbcn.zza(parcel, 11, isMute());
        zzbcn.zza(parcel, 12, getActiveTrackIds(), false);
        zzbcn.zzc(parcel, 13, getLoadingItemId());
        zzbcn.zzc(parcel, 14, getPreloadedItemId());
        zzbcn.zza(parcel, 15, this.zzehn, false);
        zzbcn.zzc(parcel, 16, this.zzemc);
        zzbcn.zzc(parcel, 17, this.zzemd, false);
        zzbcn.zza(parcel, 18, isPlayingAd());
        zzbcn.zza(parcel, 19, (Parcelable) getAdBreakStatus(), i, false);
        zzbcn.zza(parcel, 20, (Parcelable) getVideoInfo(), i, false);
        zzbcn.zzai(parcel, zze);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final int zza(JSONObject jSONObject, int i) {
        boolean z;
        int i2;
        int i3 = 0;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzelr) {
            this.zzelr = j;
            i3 = 1;
        }
        if (jSONObject.has("playerState")) {
            int i4 = 0;
            String string = jSONObject.getString("playerState");
            if (string.equals("IDLE")) {
                i4 = 1;
            } else if (string.equals("PLAYING")) {
                i4 = 2;
            } else if (string.equals("PAUSED")) {
                i4 = 3;
            } else if (string.equals("BUFFERING")) {
                i4 = 4;
            }
            if (i4 != this.zzelu) {
                this.zzelu = i4;
                i3 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                int i5 = 0;
                String string2 = jSONObject.getString("idleReason");
                if (string2.equals("CANCELLED")) {
                    i5 = 2;
                } else if (string2.equals("INTERRUPTED")) {
                    i5 = 3;
                } else if (string2.equals("FINISHED")) {
                    i5 = 1;
                } else if (string2.equals(UmaAlert.TYPE_ERROR)) {
                    i5 = 4;
                }
                if (i5 != this.zzelv) {
                    this.zzelv = i5;
                    i3 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.zzelt != d) {
                this.zzelt = d;
                i3 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long j2 = (long) (jSONObject.getDouble("currentTime") * 1000.0d);
            if (j2 != this.zzelw) {
                this.zzelw = j2;
                i3 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j3 = jSONObject.getLong("supportedMediaCommands");
            if (j3 != this.zzelx) {
                this.zzelx = j3;
                i3 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.zzely) {
                this.zzely = d2;
                i3 |= 2;
            }
            boolean z2 = jSONObject2.getBoolean("muted");
            if (z2 != this.zzelz) {
                this.zzelz = z2;
                i3 |= 2;
            }
        }
        boolean z3 = false;
        long[] jArr = null;
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                jArr[i6] = jSONArray.getLong(i6);
            }
            if (this.zzelp == null) {
                z3 = true;
            } else if (this.zzelp.length != length) {
                z3 = true;
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        break;
                    } else if (this.zzelp[i7] != jArr[i7]) {
                        z3 = true;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            if (z3) {
                this.zzelp = jArr;
            }
        } else if (this.zzelp != null) {
            z3 = true;
        }
        if (z3) {
            this.zzelp = jArr;
            i3 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzeho = jSONObject.getJSONObject("customData");
            this.zzehn = null;
            i3 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            MediaInfo mediaInfo = new MediaInfo(jSONObject3);
            if (this.zzelb == null || (this.zzelb != null && !this.zzelb.equals(mediaInfo))) {
                this.zzelb = mediaInfo;
                i3 |= 2;
            }
            if (jSONObject3.has("metadata")) {
                i3 |= 4;
            }
        }
        if (jSONObject.has("currentItemId") && this.zzels != (i2 = jSONObject.getInt("currentItemId"))) {
            this.zzels = i2;
            i3 |= 2;
        }
        int optInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzemb != optInt) {
            this.zzemb = optInt;
            i3 |= 16;
        }
        int optInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzema != optInt2) {
            this.zzema = optInt2;
            i3 |= 2;
        }
        int streamType = this.zzelb == null ? -1 : this.zzelb.getStreamType();
        int i8 = this.zzelu;
        int i9 = this.zzelv;
        int i10 = this.zzema;
        if (i8 == 1) {
            switch (i9) {
                case 1:
                case 3:
                    if (i10 != 0) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 2:
                    if (streamType == 2) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        } else {
            z = false;
        }
        if (!z) {
            boolean z4 = false;
            if (jSONObject.has("repeatMode")) {
                int i11 = this.zzemc;
                String string3 = jSONObject.getString("repeatMode");
                char c = 65535;
                switch (string3.hashCode()) {
                    case -1118317585:
                        if (string3.equals("REPEAT_ALL_AND_SHUFFLE")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -962896020:
                        if (string3.equals("REPEAT_SINGLE")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1645938909:
                        if (string3.equals("REPEAT_ALL")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1645952171:
                        if (string3.equals("REPEAT_OFF")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        i11 = 0;
                        break;
                    case 1:
                        i11 = 1;
                        break;
                    case 2:
                        i11 = 2;
                        break;
                    case 3:
                        i11 = 3;
                        break;
                }
                if (this.zzemc != i11) {
                    this.zzemc = i11;
                    z4 = true;
                }
            }
            if (jSONObject.has("items")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                int length2 = jSONArray2.length();
                SparseArray sparseArray = new SparseArray();
                for (int i12 = 0; i12 < length2; i12++) {
                    sparseArray.put(i12, Integer.valueOf(jSONArray2.getJSONObject(i12).getInt("itemId")));
                }
                MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[length2];
                for (int i13 = 0; i13 < length2; i13++) {
                    Integer num = (Integer) sparseArray.get(i13);
                    JSONObject jSONObject4 = jSONArray2.getJSONObject(i13);
                    MediaQueueItem itemById = getItemById(num.intValue());
                    if (itemById != null) {
                        z4 |= itemById.zzm(jSONObject4);
                        mediaQueueItemArr[i13] = itemById;
                        if (i13 != getIndexById(num.intValue()).intValue()) {
                            z4 = true;
                        }
                    } else {
                        z4 = true;
                        if (num.intValue() == this.zzels) {
                            mediaQueueItemArr[i13] = new MediaQueueItem.Builder(this.zzelb).build();
                            mediaQueueItemArr[i13].zzm(jSONObject4);
                        } else {
                            mediaQueueItemArr[i13] = new MediaQueueItem(jSONObject4);
                        }
                    }
                }
                if (this.zzemd.size() != length2) {
                    z4 = true;
                }
                zza(mediaQueueItemArr);
            }
            if (z4) {
                i3 |= 8;
            }
        } else {
            this.zzels = 0;
            this.zzema = 0;
            this.zzemb = 0;
            if (!this.zzemd.isEmpty()) {
                this.zzemc = 0;
                this.zzemd.clear();
                this.zzemh.clear();
                i3 |= 8;
            }
        }
        AdBreakStatus zzj = AdBreakStatus.zzj(jSONObject.optJSONObject("breakStatus"));
        if ((this.zzemf == null && zzj != null) || (this.zzemf != null && !this.zzemf.equals(zzj))) {
            this.zzeme = zzj != null;
            this.zzemf = zzj;
            i3 |= 32;
        }
        VideoInfo zzn = VideoInfo.zzn(jSONObject.optJSONObject("videoInfo"));
        if ((this.zzemg == null && zzn != null) || (this.zzemg != null && !this.zzemg.equals(zzn))) {
            this.zzemg = zzn;
            i3 |= 64;
        }
        if (!jSONObject.has("breakInfo") || this.zzelb == null) {
            return i3;
        }
        this.zzelb.zzk(jSONObject.getJSONObject("breakInfo"));
        return i3 | 2;
    }

    public final long zzabq() {
        return this.zzelr;
    }

    public final void zzaw(boolean z) {
        this.zzeme = z;
    }
}
