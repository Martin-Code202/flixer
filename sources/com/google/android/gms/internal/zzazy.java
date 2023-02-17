package com.google.android.gms.internal;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzazy extends zzayv {
    public static final String NAMESPACE = zzazl.zzfh("com.google.cast.media");
    private final List<zzbad> zzeyz = new ArrayList();
    private long zzfcj;
    private MediaStatus zzfck;
    private zzazz zzfcl;
    private final zzbad zzfcm = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcn = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfco = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcp = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcq = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcr = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcs = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfct = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcu = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcv = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcw = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcx = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcy = new zzbad(this.zzasb, 86400000);
    private final zzbad zzfcz = new zzbad(this.zzasb, 86400000);

    public zzazy(String str, zzd zzd) {
        super(NAMESPACE, zzd, "MediaControlChannel", null, 1000);
        this.zzeyz.add(this.zzfcm);
        this.zzeyz.add(this.zzfcn);
        this.zzeyz.add(this.zzfco);
        this.zzeyz.add(this.zzfcp);
        this.zzeyz.add(this.zzfcq);
        this.zzeyz.add(this.zzfcr);
        this.zzeyz.add(this.zzfcs);
        this.zzeyz.add(this.zzfct);
        this.zzeyz.add(this.zzfcu);
        this.zzeyz.add(this.zzfcv);
        this.zzeyz.add(this.zzfcw);
        this.zzeyz.add(this.zzfcx);
        this.zzeyz.add(this.zzfcy);
        this.zzeyz.add(this.zzfcz);
        zzaer();
    }

    private final void onMetadataUpdated() {
        if (this.zzfcl != null) {
            this.zzfcl.onMetadataUpdated();
        }
    }

    private final void onPreloadStatusUpdated() {
        if (this.zzfcl != null) {
            this.zzfcl.onPreloadStatusUpdated();
        }
    }

    private final void onQueueStatusUpdated() {
        if (this.zzfcl != null) {
            this.zzfcl.onQueueStatusUpdated();
        }
    }

    private final void onStatusUpdated() {
        if (this.zzfcl != null) {
            this.zzfcl.onStatusUpdated();
        }
    }

    private final void zza(long j, JSONObject jSONObject) {
        int i;
        boolean test = this.zzfcm.test(j);
        boolean z = this.zzfcq.zzaet() && !this.zzfcq.test(j);
        boolean z2 = (this.zzfcr.zzaet() && !this.zzfcr.test(j)) || (this.zzfcs.zzaet() && !this.zzfcs.test(j));
        int i2 = 0;
        if (z) {
            i2 = 2;
        }
        if (z2) {
            i2 |= 1;
        }
        if (test || this.zzfck == null) {
            this.zzfck = new MediaStatus(jSONObject);
            this.zzfcj = this.zzasb.elapsedRealtime();
            i = 127;
        } else {
            i = this.zzfck.zza(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.zzfcj = this.zzasb.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0) {
            this.zzfcj = this.zzasb.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0) {
            onMetadataUpdated();
        }
        if ((i & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((i & 16) != 0) {
            onPreloadStatusUpdated();
        }
        if ((i & 32) != 0) {
            this.zzfcj = this.zzasb.elapsedRealtime();
            if (this.zzfcl != null) {
                this.zzfcl.onAdBreakStatusUpdated();
            }
        }
        if ((i & 64) != 0) {
            this.zzfcj = this.zzasb.elapsedRealtime();
            onStatusUpdated();
        }
        for (zzbad zzbad : this.zzeyz) {
            zzbad.zzc(j, 0, null);
        }
    }

    private final long zzabq() {
        if (this.zzfck != null) {
            return this.zzfck.zzabq();
        }
        throw new zzbaa();
    }

    private final void zzaer() {
        this.zzfcj = 0;
        this.zzfck = null;
        for (zzbad zzbad : this.zzeyz) {
            zzbad.clear();
        }
    }

    public final long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzfcj == 0) {
            return 0;
        }
        double playbackRate = this.zzfck.getPlaybackRate();
        long streamPosition = this.zzfck.getStreamPosition();
        int playerState = this.zzfck.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long elapsedRealtime = this.zzasb.elapsedRealtime() - this.zzfcj;
        long j = elapsedRealtime;
        if (elapsedRealtime < 0) {
            j = 0;
        }
        if (j == 0) {
            return streamPosition;
        }
        long j2 = streamPosition + ((long) (((double) j) * playbackRate));
        if (streamDuration > 0 && j2 > streamDuration) {
            return streamDuration;
        }
        if (j2 < 0) {
            return 0;
        }
        return j2;
    }

    public final MediaInfo getMediaInfo() {
        if (this.zzfck == null) {
            return null;
        }
        return this.zzfck.getMediaInfo();
    }

    public final MediaStatus getMediaStatus() {
        return this.zzfck;
    }

    public final long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0;
    }

    public final long zza(zzbac zzbac) {
        JSONObject jSONObject = new JSONObject();
        long zzaef = zzaef();
        this.zzfct.zza(zzaef, zzbac);
        zzbb(true);
        try {
            jSONObject.put("requestId", zzaef);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzfck != null) {
                jSONObject.put("mediaSessionId", this.zzfck.zzabq());
            }
        } catch (JSONException unused) {
        }
        zza(jSONObject.toString(), zzaef, null);
        return zzaef;
    }

    public final long zza(zzbac zzbac, int i, long j, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) {
        if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzaef = zzaef();
            this.zzfcx.zza(zzaef, zzbac);
            zzbb(true);
            try {
                jSONObject2.put("requestId", zzaef);
                jSONObject2.put("type", "QUEUE_UPDATE");
                jSONObject2.put("mediaSessionId", zzabq());
                if (i != 0) {
                    jSONObject2.put("currentItemId", i);
                }
                if (i2 != 0) {
                    jSONObject2.put("jump", i2);
                }
                if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                        jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                    }
                    jSONObject2.put("items", jSONArray);
                }
                if (num != null) {
                    switch (num.intValue()) {
                        case 0:
                            jSONObject2.put("repeatMode", "REPEAT_OFF");
                            break;
                        case 1:
                            jSONObject2.put("repeatMode", "REPEAT_ALL");
                            break;
                        case 2:
                            jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                            break;
                        case 3:
                            jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                            break;
                    }
                }
                if (j != -1) {
                    jSONObject2.put("currentTime", ((double) j) / 1000.0d);
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException unused) {
            }
            zza(jSONObject2.toString(), zzaef, null);
            return zzaef;
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("playPosition cannot be negative: ").append(j).toString());
    }

    public final long zza(zzbac zzbac, long j, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzaef = zzaef();
        this.zzfcq.zza(zzaef, zzbac);
        zzbb(true);
        try {
            jSONObject2.put("requestId", zzaef);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", zzabq());
            jSONObject2.put("currentTime", ((double) j) / 1000.0d);
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zza(jSONObject2.toString(), zzaef, null);
        return zzaef;
    }

    public final long zza(zzbac zzbac, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzaef = zzaef();
        this.zzfcn.zza(zzaef, zzbac);
        zzbb(true);
        try {
            jSONObject2.put("requestId", zzaef);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzabq());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zza(jSONObject2.toString(), zzaef, null);
        return zzaef;
    }

    public final void zza(zzazz zzazz) {
        this.zzfcl = zzazz;
    }

    @Override // com.google.android.gms.internal.zzayv, com.google.android.gms.internal.zzazd
    public final void zzaee() {
        super.zzaee();
        zzaer();
    }

    public final long zzc(zzbac zzbac, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzaef = zzaef();
        this.zzfco.zza(zzaef, zzbac);
        zzbb(true);
        try {
            jSONObject2.put("requestId", zzaef);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzabq());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zza(jSONObject2.toString(), zzaef, null);
        return zzaef;
    }

    @Override // com.google.android.gms.internal.zzazd
    public final void zzc(long j, int i) {
        for (zzbad zzbad : this.zzeyz) {
            zzbad.zzc(j, i, null);
        }
    }

    @Override // com.google.android.gms.internal.zzazd
    public final void zzff(String str) {
        this.zzejc.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            char c = 65535;
            switch (string.hashCode()) {
                case -1830647528:
                    if (string.equals("LOAD_CANCELLED")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1125000185:
                    if (string.equals("INVALID_REQUEST")) {
                        c = 4;
                        break;
                    }
                    break;
                case -262628938:
                    if (string.equals("LOAD_FAILED")) {
                        c = 2;
                        break;
                    }
                    break;
                case 431600379:
                    if (string.equals("INVALID_PLAYER_STATE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 823510221:
                    if (string.equals("MEDIA_STATUS")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    JSONArray jSONArray = jSONObject.getJSONArray("status");
                    if (jSONArray.length() > 0) {
                        zza(optLong, jSONArray.getJSONObject(0));
                        return;
                    }
                    this.zzfck = null;
                    onStatusUpdated();
                    onMetadataUpdated();
                    onQueueStatusUpdated();
                    onPreloadStatusUpdated();
                    this.zzfct.zzc(optLong, 0, null);
                    return;
                case 1:
                    this.zzejc.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                    JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                    for (zzbad zzbad : this.zzeyz) {
                        zzbad.zzc(optLong, 2100, optJSONObject);
                    }
                    return;
                case 2:
                    this.zzfcm.zzc(optLong, 2100, jSONObject.optJSONObject("customData"));
                    return;
                case 3:
                    this.zzfcm.zzc(optLong, 2101, jSONObject.optJSONObject("customData"));
                    return;
                case 4:
                    this.zzejc.zzf("received unexpected error: Invalid Request.", new Object[0]);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                    for (zzbad zzbad2 : this.zzeyz) {
                        zzbad2.zzc(optLong, 2100, optJSONObject2);
                    }
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
            this.zzejc.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzayv
    public final boolean zzz(long j) {
        for (zzbad zzbad : this.zzeyz) {
            zzbad.zzd(j, 2102);
        }
        boolean z = false;
        synchronized (zzbad.zzaje) {
            Iterator<zzbad> it = this.zzeyz.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().zzaet()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return z;
    }
}
