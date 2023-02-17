package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CastOptions extends zzbck {
    public static final Parcelable.Creator<CastOptions> CREATOR = new zzb();
    private final LaunchOptions zzekr;
    private final String zzeoo;
    private final List<String> zzeop;
    private final boolean zzeoq;
    private final boolean zzeor;
    private final CastMediaOptions zzeos;
    private final boolean zzeot;
    private final double zzeou;

    public static final class Builder {
        private LaunchOptions zzekr = new LaunchOptions();
        private String zzeoo;
        private List<String> zzeop = new ArrayList();
        private boolean zzeoq;
        private boolean zzeor = true;
        private CastMediaOptions zzeos = new CastMediaOptions.Builder().build();
        private boolean zzeot = true;
        private double zzeou = 0.05000000074505806d;

        public final CastOptions build() {
            return new CastOptions(this.zzeoo, this.zzeop, this.zzeoq, this.zzekr, this.zzeor, this.zzeos, this.zzeot, this.zzeou);
        }

        public final Builder setReceiverApplicationId(String str) {
            this.zzeoo = str;
            return this;
        }
    }

    CastOptions(String str, List<String> list, boolean z, LaunchOptions launchOptions, boolean z2, CastMediaOptions castMediaOptions, boolean z3, double d) {
        this.zzeoo = TextUtils.isEmpty(str) ? "" : str;
        int size = list == null ? 0 : list.size();
        this.zzeop = new ArrayList(size);
        if (size > 0) {
            this.zzeop.addAll(list);
        }
        this.zzeoq = z;
        this.zzekr = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.zzeor = z2;
        this.zzeos = castMediaOptions;
        this.zzeot = z3;
        this.zzeou = d;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.zzeos;
    }

    public boolean getEnableReconnectionService() {
        return this.zzeot;
    }

    public LaunchOptions getLaunchOptions() {
        return this.zzekr;
    }

    public String getReceiverApplicationId() {
        return this.zzeoo;
    }

    public boolean getResumeSavedSession() {
        return this.zzeor;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzeoq;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzeop);
    }

    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzeou;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getReceiverApplicationId(), false);
        zzbcn.zzb(parcel, 3, getSupportedNamespaces(), false);
        zzbcn.zza(parcel, 4, getStopReceiverApplicationWhenEndingSession());
        zzbcn.zza(parcel, 5, (Parcelable) getLaunchOptions(), i, false);
        zzbcn.zza(parcel, 6, getResumeSavedSession());
        zzbcn.zza(parcel, 7, (Parcelable) getCastMediaOptions(), i, false);
        zzbcn.zza(parcel, 8, getEnableReconnectionService());
        zzbcn.zza(parcel, 9, getVolumeDeltaBeforeIceCreamSandwich());
        zzbcn.zzai(parcel, zze);
    }
}
