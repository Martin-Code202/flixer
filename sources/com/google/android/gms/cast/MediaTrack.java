package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
public final class MediaTrack extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaTrack> CREATOR = new zzaj();
    private String mName;
    private String zzdmm;
    private long zzdxd;
    private int zzecy;
    private String zzehn;
    private JSONObject zzeho;
    private String zzeks;
    private String zzeku;
    private int zzemi;

    MediaTrack(long j, int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.zzdxd = j;
        this.zzecy = i;
        this.zzeks = str;
        this.zzeku = str2;
        this.mName = str3;
        this.zzdmm = str4;
        this.zzemi = i2;
        this.zzehn = str5;
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

    MediaTrack(JSONObject jSONObject) {
        this(0, 0, null, null, null, null, -1, null);
        this.zzdxd = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzecy = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzecy = 2;
        } else if ("VIDEO".equals(string)) {
            this.zzecy = 3;
        } else {
            String valueOf = String.valueOf(string);
            throw new JSONException(valueOf.length() != 0 ? "invalid type: ".concat(valueOf) : new String("invalid type: "));
        }
        this.zzeks = jSONObject.optString("trackContentId", null);
        this.zzeku = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzdmm = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.zzemi = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.zzemi = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.zzemi = 3;
            } else if ("CHAPTERS".equals(string2)) {
                this.zzemi = 4;
            } else if ("METADATA".equals(string2)) {
                this.zzemi = 5;
            } else {
                String valueOf2 = String.valueOf(string2);
                throw new JSONException(valueOf2.length() != 0 ? "invalid subtype: ".concat(valueOf2) : new String("invalid subtype: "));
            }
        } else {
            this.zzemi = 0;
        }
        this.zzeho = jSONObject.optJSONObject("customData");
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        if ((this.zzeho == null) != (mediaTrack.zzeho == null)) {
            return false;
        }
        return (this.zzeho == null || mediaTrack.zzeho == null || zzn.zzc(this.zzeho, mediaTrack.zzeho)) && this.zzdxd == mediaTrack.zzdxd && this.zzecy == mediaTrack.zzecy && zzazl.zza(this.zzeks, mediaTrack.zzeks) && zzazl.zza(this.zzeku, mediaTrack.zzeku) && zzazl.zza(this.mName, mediaTrack.mName) && zzazl.zza(this.zzdmm, mediaTrack.zzdmm) && this.zzemi == mediaTrack.zzemi;
    }

    public final String getContentId() {
        return this.zzeks;
    }

    public final String getContentType() {
        return this.zzeku;
    }

    public final long getId() {
        return this.zzdxd;
    }

    public final String getLanguage() {
        return this.zzdmm;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getSubtype() {
        return this.zzemi;
    }

    public final int getType() {
        return this.zzecy;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzdxd), Integer.valueOf(this.zzecy), this.zzeks, this.zzeku, this.mName, this.zzdmm, Integer.valueOf(this.zzemi), String.valueOf(this.zzeho)});
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzdxd);
            switch (this.zzecy) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzeks != null) {
                jSONObject.put("trackContentId", this.zzeks);
            }
            if (this.zzeku != null) {
                jSONObject.put("trackContentType", this.zzeku);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzdmm)) {
                jSONObject.put("language", this.zzdmm);
            }
            switch (this.zzemi) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzeho != null) {
                jSONObject.put("customData", this.zzeho);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.zzehn = this.zzeho == null ? null : this.zzeho.toString();
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getId());
        zzbcn.zzc(parcel, 3, getType());
        zzbcn.zza(parcel, 4, getContentId(), false);
        zzbcn.zza(parcel, 5, getContentType(), false);
        zzbcn.zza(parcel, 6, getName(), false);
        zzbcn.zza(parcel, 7, getLanguage(), false);
        zzbcn.zzc(parcel, 8, getSubtype());
        zzbcn.zza(parcel, 9, this.zzehn, false);
        zzbcn.zzai(parcel, zze);
    }
}
