package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
public class AdBreakStatus extends zzbck {
    public static final Parcelable.Creator<AdBreakStatus> CREATOR = new zzc();
    private final long zzehs;
    private final long zzeht;
    private final String zzehu;
    private final String zzehv;
    private final long zzehw;

    AdBreakStatus(long j, long j2, String str, String str2, long j3) {
        this.zzehs = j;
        this.zzeht = j2;
        this.zzehu = str;
        this.zzehv = str2;
        this.zzehw = j3;
    }

    static AdBreakStatus zzj(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("currentBreakTime") || !jSONObject.has("currentBreakClipTime")) {
            return null;
        }
        try {
            long j = (long) (((double) jSONObject.getLong("currentBreakTime")) * 1000.0d);
            long j2 = (long) (((double) jSONObject.getLong("currentBreakClipTime")) * 1000.0d);
            String optString = jSONObject.optString("breakId", null);
            String optString2 = jSONObject.optString("breakClipId", null);
            long optLong = jSONObject.optLong("whenSkippable", -1);
            long j3 = optLong;
            if (optLong != -1) {
                j3 = (long) (((double) j3) * 1000.0d);
            }
            return new AdBreakStatus(j, j2, optString, optString2, j3);
        } catch (JSONException e) {
            Log.d("AdBreakInfo", String.format(Locale.ROOT, "Error while creating an AdBreakClipInfo from JSON: %s", e.getMessage()));
            return null;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakStatus)) {
            return false;
        }
        AdBreakStatus adBreakStatus = (AdBreakStatus) obj;
        return this.zzehs == adBreakStatus.zzehs && this.zzeht == adBreakStatus.zzeht && zzazl.zza(this.zzehu, adBreakStatus.zzehu) && zzazl.zza(this.zzehv, adBreakStatus.zzehv) && this.zzehw == adBreakStatus.zzehw;
    }

    public String getBreakClipId() {
        return this.zzehv;
    }

    public String getBreakId() {
        return this.zzehu;
    }

    public long getCurrentBreakClipTimeInMs() {
        return this.zzeht;
    }

    public long getCurrentBreakTimeInMs() {
        return this.zzehs;
    }

    public long getWhenSkippableInMs() {
        return this.zzehw;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzehs), Long.valueOf(this.zzeht), this.zzehu, this.zzehv, Long.valueOf(this.zzehw)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getCurrentBreakTimeInMs());
        zzbcn.zza(parcel, 3, getCurrentBreakClipTimeInMs());
        zzbcn.zza(parcel, 4, getBreakId(), false);
        zzbcn.zza(parcel, 5, getBreakClipId(), false);
        zzbcn.zza(parcel, 6, getWhenSkippableInMs());
        zzbcn.zzai(parcel, zze);
    }
}
