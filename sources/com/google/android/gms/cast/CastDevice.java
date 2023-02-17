package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CastDevice extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzn();
    private int zzbyy;
    private String zzeim;
    private String zzein;
    private Inet4Address zzeio;
    private String zzeip;
    private String zzeiq;
    private String zzeir;
    private int zzeis;
    private List<WebImage> zzeit;
    private int zzeiu;
    private String zzeiv;
    private String zzeiw;
    private int zzeix;

    CastDevice(String str, String str2, String str3, String str4, String str5, int i, List<WebImage> list, int i2, int i3, String str6, String str7, int i4) {
        this.zzeim = zzeu(str);
        this.zzein = zzeu(str2);
        if (!TextUtils.isEmpty(this.zzein)) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzein);
                if (byName instanceof Inet4Address) {
                    this.zzeio = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                String str8 = this.zzein;
                String message = e.getMessage();
                Log.i("CastDevice", new StringBuilder(String.valueOf(message).length() + String.valueOf(str8).length() + 48).append("Unable to convert host address (").append(str8).append(") to ipaddress: ").append(message).toString());
            }
        }
        this.zzeip = zzeu(str3);
        this.zzeiq = zzeu(str4);
        this.zzeir = zzeu(str5);
        this.zzeis = i;
        this.zzeit = list != null ? list : new ArrayList<>();
        this.zzeiu = i2;
        this.zzbyy = i3;
        this.zzeiv = zzeu(str6);
        this.zzeiw = str7;
        this.zzeix = i4;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzeu(String str) {
        return str == null ? "" : str;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return this.zzeim == null ? castDevice.zzeim == null : zzazl.zza(this.zzeim, castDevice.zzeim) && zzazl.zza(this.zzeio, castDevice.zzeio) && zzazl.zza(this.zzeiq, castDevice.zzeiq) && zzazl.zza(this.zzeip, castDevice.zzeip) && zzazl.zza(this.zzeir, castDevice.zzeir) && this.zzeis == castDevice.zzeis && zzazl.zza(this.zzeit, castDevice.zzeit) && this.zzeiu == castDevice.zzeiu && this.zzbyy == castDevice.zzbyy && zzazl.zza(this.zzeiv, castDevice.zzeiv) && zzazl.zza(Integer.valueOf(this.zzeix), Integer.valueOf(castDevice.zzeix));
    }

    public String getDeviceId() {
        return this.zzeim.startsWith("__cast_nearby__") ? this.zzeim.substring(16) : this.zzeim;
    }

    public String getDeviceVersion() {
        return this.zzeir;
    }

    public String getFriendlyName() {
        return this.zzeip;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzeit);
    }

    public Inet4Address getIpAddress() {
        return this.zzeio;
    }

    public String getModelName() {
        return this.zzeiq;
    }

    public int getServicePort() {
        return this.zzeis;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.zzeim == null) {
            return 0;
        }
        return this.zzeim.hashCode();
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("\"%s\" (%s)", this.zzeip, this.zzeim);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.zzeim, false);
        zzbcn.zza(parcel, 3, this.zzein, false);
        zzbcn.zza(parcel, 4, getFriendlyName(), false);
        zzbcn.zza(parcel, 5, getModelName(), false);
        zzbcn.zza(parcel, 6, getDeviceVersion(), false);
        zzbcn.zzc(parcel, 7, getServicePort());
        zzbcn.zzc(parcel, 8, getIcons(), false);
        zzbcn.zzc(parcel, 9, this.zzeiu);
        zzbcn.zzc(parcel, 10, this.zzbyy);
        zzbcn.zza(parcel, 11, this.zzeiv, false);
        zzbcn.zza(parcel, 12, this.zzeiw, false);
        zzbcn.zzc(parcel, 13, this.zzeix);
        zzbcn.zzai(parcel, zze);
    }
}
