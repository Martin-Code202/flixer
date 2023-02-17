package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzazx;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public class CastMediaOptions extends zzbck {
    public static final Parcelable.Creator<CastMediaOptions> CREATOR = new zza();
    private static final zzazx zzejc = new zzazx("CastMediaOptions");
    private final String zzesb;
    private final String zzesc;
    private final zzb zzesd;
    private final NotificationOptions zzese;

    public static final class Builder {
        private String zzesb = MediaIntentReceiver.class.getName();
        private String zzesc;
        private NotificationOptions zzese = new NotificationOptions.Builder().build();
        private ImagePicker zzesf;

        public final CastMediaOptions build() {
            return new CastMediaOptions(this.zzesb, this.zzesc, this.zzesf == null ? null : this.zzesf.zzacz().asBinder(), this.zzese);
        }
    }

    CastMediaOptions(String str, String str2, IBinder iBinder, NotificationOptions notificationOptions) {
        zzb zzb;
        this.zzesb = str;
        this.zzesc = str2;
        if (iBinder == null) {
            zzb = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            zzb = queryLocalInterface instanceof zzb ? (zzb) queryLocalInterface : new zzc(iBinder);
        }
        this.zzesd = zzb;
        this.zzese = notificationOptions;
    }

    public String getExpandedControllerActivityClassName() {
        return this.zzesc;
    }

    public ImagePicker getImagePicker() {
        if (this.zzesd == null) {
            return null;
        }
        try {
            return (ImagePicker) zzn.zzx(this.zzesd.zzacy());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getWrappedClientObject", zzb.class.getSimpleName());
            return null;
        }
    }

    public String getMediaIntentReceiverClassName() {
        return this.zzesb;
    }

    public NotificationOptions getNotificationOptions() {
        return this.zzese;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getMediaIntentReceiverClassName(), false);
        zzbcn.zza(parcel, 3, getExpandedControllerActivityClassName(), false);
        zzbcn.zza(parcel, 4, this.zzesd == null ? null : this.zzesd.asBinder(), false);
        zzbcn.zza(parcel, 5, (Parcelable) getNotificationOptions(), i, false);
        zzbcn.zzai(parcel, zze);
    }
}
