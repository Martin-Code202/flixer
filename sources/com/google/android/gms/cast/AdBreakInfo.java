package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AdBreakInfo extends zzbck {
    public static final Parcelable.Creator<AdBreakInfo> CREATOR = new zzb();
    private final String zzbsw;
    private final long zzehk;
    private final long zzehp;
    private final boolean zzehq;
    private String[] zzehr;

    public AdBreakInfo(long j, String str, long j2, boolean z, String[] strArr) {
        this.zzehp = j;
        this.zzbsw = str;
        this.zzehk = j2;
        this.zzehq = z;
        this.zzehr = strArr;
    }

    static AdBreakInfo zzi(JSONObject jSONObject) {
        if (!(jSONObject != null && jSONObject.has("id") && jSONObject.has("position"))) {
            return null;
        }
        try {
            String string = jSONObject.getString("id");
            long j = (long) (((double) jSONObject.getLong("position")) * 1000.0d);
            boolean optBoolean = jSONObject.optBoolean("isWatched");
            long optLong = (long) (((double) jSONObject.optLong(SessionEndedEvent.DURATION)) * 1000.0d);
            JSONArray optJSONArray = jSONObject.optJSONArray("breakClipIds");
            String[] strArr = null;
            if (optJSONArray != null) {
                strArr = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    strArr[i] = optJSONArray.getString(i);
                }
            }
            return new AdBreakInfo(j, string, optLong, optBoolean, strArr);
        } catch (JSONException e) {
            Log.d("AdBreakInfo", String.format(Locale.ROOT, "Error while creating an AdBreakInfo from JSON: %s", e.getMessage()));
            return null;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakInfo)) {
            return false;
        }
        AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
        return zzazl.zza(this.zzbsw, adBreakInfo.zzbsw) && this.zzehp == adBreakInfo.zzehp && this.zzehk == adBreakInfo.zzehk && this.zzehq == adBreakInfo.zzehq && Arrays.equals(this.zzehr, adBreakInfo.zzehr);
    }

    public String[] getBreakClipIds() {
        return this.zzehr;
    }

    public long getDurationInMs() {
        return this.zzehk;
    }

    public String getId() {
        return this.zzbsw;
    }

    public long getPlaybackPositionInMs() {
        return this.zzehp;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.zzbsw.hashCode();
    }

    public boolean isWatched() {
        return this.zzehq;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getPlaybackPositionInMs());
        zzbcn.zza(parcel, 3, getId(), false);
        zzbcn.zza(parcel, 4, getDurationInMs());
        zzbcn.zza(parcel, 5, isWatched());
        zzbcn.zza(parcel, 6, getBreakClipIds(), false);
        zzbcn.zzai(parcel, zze);
    }
}
