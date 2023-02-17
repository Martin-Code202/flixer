package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class CredentialPickerConfig extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzc();
    private final boolean mShowCancelButton;
    private int zzdxr;
    private final boolean zzeag;
    @Deprecated
    private final boolean zzeah;
    private final int zzeai;

    public static class Builder {
        private boolean mShowCancelButton = true;
        private boolean zzeag = false;
        private int zzeaj = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.zzdxr = i;
        this.zzeag = z;
        this.mShowCancelButton = z2;
        if (i < 2) {
            this.zzeah = z3;
            this.zzeai = z3 ? 3 : 1;
            return;
        }
        this.zzeah = i2 == 3;
        this.zzeai = i2;
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.zzeag, builder.mShowCancelButton, false, builder.zzeaj);
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzeai == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzeag;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, shouldShowAddAccountButton());
        zzbcn.zza(parcel, 2, shouldShowCancelButton());
        zzbcn.zza(parcel, 3, isForNewAccount());
        zzbcn.zzc(parcel, 4, this.zzeai);
        zzbcn.zzc(parcel, 1000, this.zzdxr);
        zzbcn.zzai(parcel, zze);
    }
}
