package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import java.util.List;
public class Credential extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza();
    private final String mName;
    private final String zzbsw;
    private final String zzdzq;
    private final Uri zzdzz;
    private final List<IdToken> zzeaa;
    private final String zzeab;
    private final String zzeac;
    private final String zzead;
    private final String zzeae;
    private final String zzeaf;

    public static class Builder {
        private String mName;
        private final String zzbsw;
        private String zzdzq;
        private Uri zzdzz;
        private List<IdToken> zzeaa;
        private String zzeab;
        private String zzeac;
        private String zzead;
        private String zzeae;
        private String zzeaf;

        public Builder(String str) {
            this.zzbsw = str;
        }

        public Credential build() {
            return new Credential(this.zzbsw, this.mName, this.zzdzz, this.zzeaa, this.zzeab, this.zzdzq, this.zzeac, this.zzead, this.zzeae, this.zzeaf);
        }

        public Builder setPassword(String str) {
            this.zzeab = str;
            return this;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Credential(java.lang.String r6, java.lang.String r7, android.net.Uri r8, java.util.List<com.google.android.gms.auth.api.credentials.IdToken> r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r5 = this;
            r5.<init>()
            java.lang.String r0 = "credential identifier cannot be null"
            java.lang.Object r0 = com.google.android.gms.common.internal.zzbp.zzb(r6, r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = r0.trim()
            java.lang.String r0 = "credential identifier cannot be empty"
            com.google.android.gms.common.internal.zzbp.zzh(r2, r0)
            if (r10 == 0) goto L_0x0024
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x0024
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Password must not be empty if set"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            if (r11 == 0) goto L_0x0080
            r3 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x006d
            android.net.Uri r4 = android.net.Uri.parse(r3)
            boolean r0 = r4.isAbsolute()
            if (r0 == 0) goto L_0x0051
            boolean r0 = r4.isHierarchical()
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r4.getScheme()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0051
            java.lang.String r0 = r4.getAuthority()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0053
        L_0x0051:
            r0 = 0
            goto L_0x006e
        L_0x0053:
            java.lang.String r0 = "http"
            java.lang.String r1 = r4.getScheme()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x006b
            java.lang.String r0 = "https"
            java.lang.String r1 = r4.getScheme()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x006d
        L_0x006b:
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0080
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Account type must be a valid Http/Https URI"
            r0.<init>(r1)
            throw r0
        L_0x0080:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x0094
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x0094
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Password and AccountType are mutually exclusive"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            if (r7 == 0) goto L_0x00a1
            java.lang.String r0 = r7.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a1
            r7 = 0
        L_0x00a1:
            r5.mName = r7
            r5.zzdzz = r8
            if (r9 != 0) goto L_0x00ac
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00b0
        L_0x00ac:
            java.util.List r0 = java.util.Collections.unmodifiableList(r9)
        L_0x00b0:
            r5.zzeaa = r0
            r5.zzbsw = r2
            r5.zzeab = r10
            r5.zzdzq = r11
            r5.zzeac = r12
            r5.zzead = r13
            r5.zzeae = r14
            r5.zzeaf = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.Credential.<init>(java.lang.String, java.lang.String, android.net.Uri, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzbsw, credential.zzbsw) && TextUtils.equals(this.mName, credential.mName) && zzbf.equal(this.zzdzz, credential.zzdzz) && TextUtils.equals(this.zzeab, credential.zzeab) && TextUtils.equals(this.zzdzq, credential.zzdzq) && TextUtils.equals(this.zzeac, credential.zzeac);
    }

    public String getAccountType() {
        return this.zzdzq;
    }

    public String getFamilyName() {
        return this.zzeaf;
    }

    public String getGeneratedPassword() {
        return this.zzeac;
    }

    public String getGivenName() {
        return this.zzeae;
    }

    public String getId() {
        return this.zzbsw;
    }

    public List<IdToken> getIdTokens() {
        return this.zzeaa;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzeab;
    }

    public Uri getProfilePictureUri() {
        return this.zzdzz;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzbsw, this.mName, this.zzdzz, this.zzeab, this.zzdzq, this.zzeac});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, getId(), false);
        zzbcn.zza(parcel, 2, getName(), false);
        zzbcn.zza(parcel, 3, (Parcelable) getProfilePictureUri(), i, false);
        zzbcn.zzc(parcel, 4, getIdTokens(), false);
        zzbcn.zza(parcel, 5, getPassword(), false);
        zzbcn.zza(parcel, 6, getAccountType(), false);
        zzbcn.zza(parcel, 7, getGeneratedPassword(), false);
        zzbcn.zza(parcel, 8, this.zzead, false);
        zzbcn.zza(parcel, 9, getGivenName(), false);
        zzbcn.zza(parcel, 10, getFamilyName(), false);
        zzbcn.zzai(parcel, zze);
    }
}
