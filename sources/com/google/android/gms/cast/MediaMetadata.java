package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzbae;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.model.leafs.PostPlayItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class MediaMetadata extends zzbck {
    public static final Parcelable.Creator<MediaMetadata> CREATOR = new zzaf();
    private static final String[] zzelc = {null, "String", "int", "double", "ISO-8601 date String"};
    private static final zza zzeld = new zza().zzb("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).zzb("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).zzb("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).zzb("com.google.android.gms.cast.metadata.TITLE", "title", 1).zzb("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).zzb("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).zzb("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).zzb("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).zzb("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).zzb("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).zzb("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).zzb("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).zzb("com.google.android.gms.cast.metadata.EPISODE_NUMBER", PostPlayItem.POST_PLAY_ITEM_EPISODE, 2).zzb("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).zzb("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).zzb("com.google.android.gms.cast.metadata.WIDTH", "width", 2).zzb("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).zzb("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).zzb("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).zzb("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
    private final List<WebImage> zzbro;
    private Bundle zzele;
    private int zzelf;

    /* access modifiers changed from: package-private */
    public static class zza {
        private final Map<String, String> zzelg = new HashMap();
        private final Map<String, String> zzelh = new HashMap();
        private final Map<String, Integer> zzeli = new HashMap();

        public final zza zzb(String str, String str2, int i) {
            this.zzelg.put(str, str2);
            this.zzelh.put(str2, str);
            this.zzeli.put(str, Integer.valueOf(i));
            return this;
        }

        public final String zzev(String str) {
            return this.zzelg.get(str);
        }

        public final String zzew(String str) {
            return this.zzelh.get(str);
        }

        public final int zzex(String str) {
            Integer num = this.zzeli.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int i) {
        this(new ArrayList(), new Bundle(), i);
    }

    MediaMetadata(List<WebImage> list, Bundle bundle, int i) {
        this.zzbro = list;
        this.zzele = bundle;
        this.zzelf = i;
    }

    private final void zza(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.zzele.containsKey(str)) {
                    switch (zzeld.zzex(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(zzeld.zzev(str), this.zzele.getString(str));
                            continue;
                        case 2:
                            jSONObject.put(zzeld.zzev(str), this.zzele.getInt(str));
                            continue;
                        case 3:
                            jSONObject.put(zzeld.zzev(str), this.zzele.getDouble(str));
                            continue;
                        default:
                            continue;
                    }
                }
            }
            for (String str2 : this.zzele.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzele.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    private final void zzb(JSONObject jSONObject, String... strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"metadataType".equals(next)) {
                    String zzew = zzeld.zzew(next);
                    if (zzew == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            this.zzele.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzele.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzele.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzew)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                switch (zzeld.zzex(zzew)) {
                                    case 1:
                                        if (obj2 instanceof String) {
                                            this.zzele.putString(zzew, (String) obj2);
                                            break;
                                        } else {
                                            continue;
                                        }
                                    case 2:
                                        if (obj2 instanceof Integer) {
                                            this.zzele.putInt(zzew, ((Integer) obj2).intValue());
                                            break;
                                        } else {
                                            continue;
                                        }
                                    case 3:
                                        if (obj2 instanceof Double) {
                                            this.zzele.putDouble(zzew, ((Double) obj2).doubleValue());
                                            break;
                                        } else {
                                            continue;
                                        }
                                    case 4:
                                        if ((obj2 instanceof String) && zzbae.zzfn((String) obj2) != null) {
                                            this.zzele.putString(zzew, (String) obj2);
                                            break;
                                        }
                                }
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        } catch (JSONException unused2) {
        }
    }

    private final boolean zzb(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzb((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static void zzf(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzex = zzeld.zzex(str);
        if (zzex != i && zzex != 0) {
            String str2 = zzelc[i];
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 21).append("Value for ").append(str).append(" must be a ").append(str2).toString());
        }
    }

    public void clear() {
        this.zzele.clear();
        this.zzbro.clear();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return zzb(this.zzele, mediaMetadata.zzele) && this.zzbro.equals(mediaMetadata.zzbro);
    }

    public List<WebImage> getImages() {
        return this.zzbro;
    }

    public int getMediaType() {
        return this.zzelf;
    }

    public String getString(String str) {
        zzf(str, 1);
        return this.zzele.getString(str);
    }

    public boolean hasImages() {
        return this.zzbro != null && !this.zzbro.isEmpty();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 17;
        for (String str : this.zzele.keySet()) {
            i = (i * 31) + this.zzele.get(str).hashCode();
        }
        return (i * 31) + this.zzbro.hashCode();
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzelf);
        } catch (JSONException unused) {
        }
        zzbae.zza(jSONObject, this.zzbro);
        switch (this.zzelf) {
            case 0:
                zza(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                break;
            case 1:
                zza(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                break;
            case 2:
                zza(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
                break;
            case 3:
                zza(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                break;
            case 4:
                zza(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
                break;
            default:
                zza(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 2, getImages(), false);
        zzbcn.zza(parcel, 3, this.zzele, false);
        zzbcn.zzc(parcel, 4, getMediaType());
        zzbcn.zzai(parcel, zze);
    }

    public final void zzl(JSONObject jSONObject) {
        clear();
        this.zzelf = 0;
        try {
            this.zzelf = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        zzbae.zza(this.zzbro, jSONObject);
        switch (this.zzelf) {
            case 0:
                zzb(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 1:
                zzb(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 2:
                zzb(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
                return;
            case 3:
                zzb(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 4:
                zzb(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
                return;
            default:
                zzb(jSONObject, new String[0]);
                return;
        }
    }
}
