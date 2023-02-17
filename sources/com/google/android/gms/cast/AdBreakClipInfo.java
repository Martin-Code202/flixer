package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
public class AdBreakClipInfo extends zzbck {
    public static final Parcelable.Creator<AdBreakClipInfo> CREATOR = new zza();
    private final String zzbcn;
    private final String zzbsw;
    private final String zzehj;
    private final long zzehk;
    private final String zzehl;
    private final String zzehm;
    private String zzehn;
    private JSONObject zzeho;

    AdBreakClipInfo(String str, String str2, long j, String str3, String str4, String str5, String str6) {
        this.zzbsw = str;
        this.zzehj = str2;
        this.zzehk = j;
        this.zzbcn = str3;
        this.zzehl = str4;
        this.zzehm = str5;
        this.zzehn = str6;
        if (!TextUtils.isEmpty(this.zzehn)) {
            try {
                this.zzeho = new JSONObject(str6);
            } catch (JSONException e) {
                Log.w("AdBreakClipInfo", String.format(Locale.ROOT, "Error creating AdBreakClipInfo: %s", e.getMessage()));
                this.zzehn = null;
                this.zzeho = new JSONObject();
            }
        } else {
            this.zzeho = new JSONObject();
        }
    }

    static AdBreakClipInfo zzh(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("id")) {
            return null;
        }
        try {
            String string = jSONObject.getString("id");
            long optLong = (long) (((double) jSONObject.optLong(SessionEndedEvent.DURATION)) * 1000.0d);
            String optString = jSONObject.optString("clickThroughUrl", null);
            String optString2 = jSONObject.optString("contentUrl", null);
            String optString3 = jSONObject.optString(HttpResponse.MIME_TYPE, null);
            String optString4 = jSONObject.optString("title", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("customData");
            return new AdBreakClipInfo(string, optString4, optLong, optString2, optString3, optString, optJSONObject == null ? null : optJSONObject.toString());
        } catch (JSONException e) {
            Log.d("AdBreakClipInfo", String.format(Locale.ROOT, "Error while creating an AdBreakClipInfo from JSON: %s", e.getMessage()));
            return null;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakClipInfo)) {
            return false;
        }
        AdBreakClipInfo adBreakClipInfo = (AdBreakClipInfo) obj;
        return zzazl.zza(this.zzbsw, adBreakClipInfo.zzbsw) && zzazl.zza(this.zzehj, adBreakClipInfo.zzehj) && this.zzehk == adBreakClipInfo.zzehk && zzazl.zza(this.zzbcn, adBreakClipInfo.zzbcn) && zzazl.zza(this.zzehl, adBreakClipInfo.zzehl) && zzazl.zza(this.zzehm, adBreakClipInfo.zzehm) && zzazl.zza(this.zzehn, adBreakClipInfo.zzehn);
    }

    public String getClickThroughUrl() {
        return this.zzehm;
    }

    public String getContentUrl() {
        return this.zzbcn;
    }

    public long getDurationInMs() {
        return this.zzehk;
    }

    public String getId() {
        return this.zzbsw;
    }

    public String getMimeType() {
        return this.zzehl;
    }

    public String getTitle() {
        return this.zzehj;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzbsw, this.zzehj, Long.valueOf(this.zzehk), this.zzbcn, this.zzehl, this.zzehm, this.zzehn});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getId(), false);
        zzbcn.zza(parcel, 3, getTitle(), false);
        zzbcn.zza(parcel, 4, getDurationInMs());
        zzbcn.zza(parcel, 5, getContentUrl(), false);
        zzbcn.zza(parcel, 6, getMimeType(), false);
        zzbcn.zza(parcel, 7, getClickThroughUrl(), false);
        zzbcn.zza(parcel, 8, this.zzehn, false);
        zzbcn.zzai(parcel, zze);
    }
}
