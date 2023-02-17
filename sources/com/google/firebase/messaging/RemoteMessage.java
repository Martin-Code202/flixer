package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.Map;
public final class RemoteMessage extends zzbck {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzf();
    Bundle mBundle;
    private Map<String, String> zzdkr;

    RemoteMessage(Bundle bundle) {
        this.mBundle = bundle;
    }

    public final Map<String, String> getData() {
        if (this.zzdkr == null) {
            this.zzdkr = new ArrayMap();
            for (String str : this.mBundle.keySet()) {
                Object obj = this.mBundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals(NetflixActivity.EXTRA_FROM) && !str.equals("message_type") && !str.equals("collapse_key")) {
                        this.zzdkr.put(str, str2);
                    }
                }
            }
        }
        return this.zzdkr;
    }

    public final String getFrom() {
        return this.mBundle.getString(NetflixActivity.EXTRA_FROM);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.mBundle, false);
        zzbcn.zzai(parcel, zze);
    }
}
