package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class CredentialRequest extends zzbck {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zze();
    private int zzdxr;
    private final boolean zzeak;
    private final String[] zzeal;
    private final CredentialPickerConfig zzeam;
    private final CredentialPickerConfig zzean;
    private final boolean zzeao;
    private final String zzeap;
    private final String zzeaq;
    private final boolean zzear;

    public static final class Builder {
        private boolean zzeak;
        private String[] zzeal;
        private CredentialPickerConfig zzeam;
        private CredentialPickerConfig zzean;
        private boolean zzeao = false;
        private String zzeap = null;
        private String zzeaq;
        private boolean zzear = false;

        public final CredentialRequest build() {
            if (this.zzeal == null) {
                this.zzeal = new String[0];
            }
            if (this.zzeak || this.zzeal.length != 0) {
                return new CredentialRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public final Builder setPasswordLoginSupported(boolean z) {
            this.zzeak = z;
            return this;
        }

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.zzdxr = i;
        this.zzeak = z;
        this.zzeal = (String[]) zzbp.zzu(strArr);
        this.zzeam = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zzean = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i < 3) {
            this.zzeao = true;
            this.zzeap = null;
            this.zzeaq = null;
        } else {
            this.zzeao = z2;
            this.zzeap = str;
            this.zzeaq = str2;
        }
        this.zzear = z3;
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.zzeak, builder.zzeal, builder.zzeam, builder.zzean, builder.zzeao, builder.zzeap, builder.zzeaq, false);
    }

    public final String[] getAccountTypes() {
        return this.zzeal;
    }

    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzean;
    }

    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzeam;
    }

    public final String getIdTokenNonce() {
        return this.zzeaq;
    }

    public final String getServerClientId() {
        return this.zzeap;
    }

    public final boolean isIdTokenRequested() {
        return this.zzeao;
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzeak;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, isPasswordLoginSupported());
        zzbcn.zza(parcel, 2, getAccountTypes(), false);
        zzbcn.zza(parcel, 3, (Parcelable) getCredentialPickerConfig(), i, false);
        zzbcn.zza(parcel, 4, (Parcelable) getCredentialHintPickerConfig(), i, false);
        zzbcn.zza(parcel, 5, isIdTokenRequested());
        zzbcn.zza(parcel, 6, getServerClientId(), false);
        zzbcn.zza(parcel, 7, getIdTokenNonce(), false);
        zzbcn.zzc(parcel, 1000, this.zzdxr);
        zzbcn.zza(parcel, 8, this.zzear);
        zzbcn.zzai(parcel, zze);
    }
}
