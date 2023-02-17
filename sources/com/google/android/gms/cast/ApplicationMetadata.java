package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class ApplicationMetadata extends zzbck {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zzd();
    private String mName;
    private List<WebImage> zzbro;
    private String zzehx;
    private List<String> zzehy;
    private String zzehz;
    private Uri zzeia;

    private ApplicationMetadata() {
        this.zzbro = new ArrayList();
        this.zzehy = new ArrayList();
    }

    ApplicationMetadata(String str, String str2, List<WebImage> list, List<String> list2, String str3, Uri uri) {
        this.zzehx = str;
        this.mName = str2;
        this.zzbro = list;
        this.zzehy = list2;
        this.zzehz = str3;
        this.zzeia = uri;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzazl.zza(this.zzehx, applicationMetadata.zzehx) && zzazl.zza(this.zzbro, applicationMetadata.zzbro) && zzazl.zza(this.mName, applicationMetadata.mName) && zzazl.zza(this.zzehy, applicationMetadata.zzehy) && zzazl.zza(this.zzehz, applicationMetadata.zzehz) && zzazl.zza(this.zzeia, applicationMetadata.zzeia);
    }

    public String getApplicationId() {
        return this.zzehx;
    }

    public List<WebImage> getImages() {
        return this.zzbro;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzehz;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzehy);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzehx, this.mName, this.zzbro, this.zzehy, this.zzehz, this.zzeia});
    }

    @Override // java.lang.Object
    public String toString() {
        return "applicationId: " + this.zzehx + ", name: " + this.mName + ", images.count: " + (this.zzbro == null ? 0 : this.zzbro.size()) + ", namespaces.count: " + (this.zzehy == null ? 0 : this.zzehy.size()) + ", senderAppIdentifier: " + this.zzehz + ", senderAppLaunchUrl: " + this.zzeia;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getApplicationId(), false);
        zzbcn.zza(parcel, 3, getName(), false);
        zzbcn.zzc(parcel, 4, getImages(), false);
        zzbcn.zzb(parcel, 5, getSupportedNamespaces(), false);
        zzbcn.zza(parcel, 6, getSenderAppIdentifier(), false);
        zzbcn.zza(parcel, 7, (Parcelable) this.zzeia, i, false);
        zzbcn.zzai(parcel, zze);
    }
}
