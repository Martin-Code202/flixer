package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
public final class WebImage extends zzbck {
    public static final Parcelable.Creator<WebImage> CREATOR = new zze();
    private final int zzakp;
    private final int zzakq;
    private int zzdxr;
    private final Uri zzeux;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.zzdxr = i;
        this.zzeux = uri;
        this.zzakp = i2;
        this.zzakq = i3;
    }

    public WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) {
        this(zzp(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzp(JSONObject jSONObject) {
        if (!jSONObject.has("url")) {
            return null;
        }
        try {
            return Uri.parse(jSONObject.getString("url"));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzbf.equal(this.zzeux, webImage.zzeux) && this.zzakp == webImage.zzakp && this.zzakq == webImage.zzakq;
    }

    public final int getHeight() {
        return this.zzakq;
    }

    public final Uri getUrl() {
        return this.zzeux;
    }

    public final int getWidth() {
        return this.zzakp;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzeux, Integer.valueOf(this.zzakp), Integer.valueOf(this.zzakq)});
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.zzeux.toString());
            jSONObject.put("width", this.zzakp);
            jSONObject.put("height", this.zzakq);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // java.lang.Object
    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.zzakp), Integer.valueOf(this.zzakq), this.zzeux.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, (Parcelable) getUrl(), i, false);
        zzbcn.zzc(parcel, 3, getWidth());
        zzbcn.zzc(parcel, 4, getHeight());
        zzbcn.zzai(parcel, zze);
    }
}
