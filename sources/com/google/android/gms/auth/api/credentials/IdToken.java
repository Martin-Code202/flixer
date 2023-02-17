package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class IdToken extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzh();
    private final String zzdzq;
    private final String zzeav;

    public IdToken(String str, String str2) {
        zzbp.zzb(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        zzbp.zzb(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.zzdzq = str;
        this.zzeav = str2;
    }

    public final String getAccountType() {
        return this.zzdzq;
    }

    public final String getIdToken() {
        return this.zzeav;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, getAccountType(), false);
        zzbcn.zza(parcel, 2, getIdToken(), false);
        zzbcn.zzai(parcel, zze);
    }
}
