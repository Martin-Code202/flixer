package com.google.android.gms.cast;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
public final class TextTrackStyle extends zzbck {
    public static final Parcelable.Creator<TextTrackStyle> CREATOR = new zzbk();
    private int zzbre;
    private String zzehn;
    private JSONObject zzeho;
    private float zzent;
    private int zzenu;
    private int zzenv;
    private int zzenw;
    private int zzenx;
    private int zzeny;
    private int zzenz;
    private String zzeoa;
    private int zzeob;
    private int zzeoc;

    public TextTrackStyle() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
    }

    TextTrackStyle(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9, String str2) {
        this.zzent = f;
        this.zzenu = i;
        this.zzbre = i2;
        this.zzenv = i3;
        this.zzenw = i4;
        this.zzenx = i5;
        this.zzeny = i6;
        this.zzenz = i7;
        this.zzeoa = str;
        this.zzeob = i8;
        this.zzeoc = i9;
        this.zzehn = str2;
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

    private static String zzbc(int i) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i)));
    }

    private static int zzey(String str) {
        if (str == null || str.length() != 9 || str.charAt(0) != '#') {
            return 0;
        }
        try {
            return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        if ((this.zzeho == null) != (textTrackStyle.zzeho == null)) {
            return false;
        }
        return (this.zzeho == null || textTrackStyle.zzeho == null || zzn.zzc(this.zzeho, textTrackStyle.zzeho)) && this.zzent == textTrackStyle.zzent && this.zzenu == textTrackStyle.zzenu && this.zzbre == textTrackStyle.zzbre && this.zzenv == textTrackStyle.zzenv && this.zzenw == textTrackStyle.zzenw && this.zzenx == textTrackStyle.zzenx && this.zzenz == textTrackStyle.zzenz && zzazl.zza(this.zzeoa, textTrackStyle.zzeoa) && this.zzeob == textTrackStyle.zzeob && this.zzeoc == textTrackStyle.zzeoc;
    }

    public final int getBackgroundColor() {
        return this.zzbre;
    }

    public final int getEdgeColor() {
        return this.zzenw;
    }

    public final int getEdgeType() {
        return this.zzenv;
    }

    public final String getFontFamily() {
        return this.zzeoa;
    }

    public final int getFontGenericFamily() {
        return this.zzeob;
    }

    public final float getFontScale() {
        return this.zzent;
    }

    public final int getFontStyle() {
        return this.zzeoc;
    }

    public final int getForegroundColor() {
        return this.zzenu;
    }

    public final int getWindowColor() {
        return this.zzeny;
    }

    public final int getWindowCornerRadius() {
        return this.zzenz;
    }

    public final int getWindowType() {
        return this.zzenx;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.zzent), Integer.valueOf(this.zzenu), Integer.valueOf(this.zzbre), Integer.valueOf(this.zzenv), Integer.valueOf(this.zzenw), Integer.valueOf(this.zzenx), Integer.valueOf(this.zzeny), Integer.valueOf(this.zzenz), this.zzeoa, Integer.valueOf(this.zzeob), Integer.valueOf(this.zzeoc), String.valueOf(this.zzeho)});
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzent);
            if (this.zzenu != 0) {
                jSONObject.put("foregroundColor", zzbc(this.zzenu));
            }
            if (this.zzbre != 0) {
                jSONObject.put("backgroundColor", zzbc(this.zzbre));
            }
            switch (this.zzenv) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzenw != 0) {
                jSONObject.put("edgeColor", zzbc(this.zzenw));
            }
            switch (this.zzenx) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzeny != 0) {
                jSONObject.put("windowColor", zzbc(this.zzeny));
            }
            if (this.zzenx == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzenz);
            }
            if (this.zzeoa != null) {
                jSONObject.put("fontFamily", this.zzeoa);
            }
            switch (this.zzeob) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzeoc) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
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
        zzbcn.zza(parcel, 2, getFontScale());
        zzbcn.zzc(parcel, 3, getForegroundColor());
        zzbcn.zzc(parcel, 4, getBackgroundColor());
        zzbcn.zzc(parcel, 5, getEdgeType());
        zzbcn.zzc(parcel, 6, getEdgeColor());
        zzbcn.zzc(parcel, 7, getWindowType());
        zzbcn.zzc(parcel, 8, getWindowColor());
        zzbcn.zzc(parcel, 9, getWindowCornerRadius());
        zzbcn.zza(parcel, 10, getFontFamily(), false);
        zzbcn.zzc(parcel, 11, getFontGenericFamily());
        zzbcn.zzc(parcel, 12, getFontStyle());
        zzbcn.zza(parcel, 13, this.zzehn, false);
        zzbcn.zzai(parcel, zze);
    }

    public final void zzl(JSONObject jSONObject) {
        this.zzent = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzenu = zzey(jSONObject.optString("foregroundColor"));
        this.zzbre = zzey(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzenv = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzenv = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzenv = 2;
            } else if ("RAISED".equals(string)) {
                this.zzenv = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzenv = 4;
            }
        }
        this.zzenw = zzey(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzenx = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzenx = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzenx = 2;
            }
        }
        this.zzeny = zzey(jSONObject.optString("windowColor"));
        if (this.zzenx == 2) {
            this.zzenz = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzeoa = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzeob = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzeob = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzeob = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzeob = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzeob = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.zzeob = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.zzeob = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzeoc = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzeoc = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzeoc = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzeoc = 3;
            }
        }
        this.zzeho = jSONObject.optJSONObject("customData");
    }
}
