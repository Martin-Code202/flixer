package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
public final class VideoInfo extends zzbck {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new zzbl();
    private int zzakp;
    private int zzakq;
    private int zzeod;

    VideoInfo(int i, int i2, int i3) {
        this.zzakp = i;
        this.zzakq = i2;
        this.zzeod = i3;
    }

    static VideoInfo zzn(JSONObject jSONObject) {
        int i;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("hdrType");
            char c = 65535;
            switch (string.hashCode()) {
                case 3218:
                    if (string.equals("dv")) {
                        c = 0;
                        break;
                    }
                    break;
                case 103158:
                    if (string.equals("hdr")) {
                        c = 2;
                        break;
                    }
                    break;
                case 113729:
                    if (string.equals("sdr")) {
                        c = 3;
                        break;
                    }
                    break;
                case 99136405:
                    if (string.equals("hdr10")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 3;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 4;
                    break;
                case 3:
                    i = 1;
                    break;
                default:
                    Log.d("VideoInfo", String.format(Locale.ROOT, "Unknown HDR type: %s", string));
                    i = 0;
                    break;
            }
            return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i);
        } catch (JSONException e) {
            Log.d("VideoInfo", String.format(Locale.ROOT, "Error while creating a VideoInfo instance from JSON: %s", e.getMessage()));
            return null;
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.zzakq == videoInfo.getHeight() && this.zzakp == videoInfo.getWidth() && this.zzeod == videoInfo.getHdrType();
    }

    public final int getHdrType() {
        return this.zzeod;
    }

    public final int getHeight() {
        return this.zzakq;
    }

    public final int getWidth() {
        return this.zzakp;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzakq), Integer.valueOf(this.zzakp), Integer.valueOf(this.zzeod)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 2, getWidth());
        zzbcn.zzc(parcel, 3, getHeight());
        zzbcn.zzc(parcel, 4, getHdrType());
        zzbcn.zzai(parcel, zze);
    }
}
