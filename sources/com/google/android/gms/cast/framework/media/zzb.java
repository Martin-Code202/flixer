package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public interface zzb extends IInterface {

    public static abstract class zza extends zzec implements zzb {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.framework.media.IImagePicker");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (zza(i, parcel, parcel2, i2)) {
                return true;
            }
            switch (i) {
                case 1:
                    WebImage onPickImage = onPickImage((MediaMetadata) zzed.zza(parcel, MediaMetadata.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    zzed.zzb(parcel2, onPickImage);
                    return true;
                case 2:
                    IObjectWrapper zzacy = zzacy();
                    parcel2.writeNoException();
                    zzed.zza(parcel2, zzacy);
                    return true;
                case 3:
                    int zzacx = zzacx();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzacx);
                    return true;
                case 4:
                    WebImage zza = zza((MediaMetadata) zzed.zza(parcel, MediaMetadata.CREATOR), (ImageHints) zzed.zza(parcel, ImageHints.CREATOR));
                    parcel2.writeNoException();
                    zzed.zzb(parcel2, zza);
                    return true;
                default:
                    return false;
            }
        }
    }

    WebImage onPickImage(MediaMetadata mediaMetadata, int i);

    WebImage zza(MediaMetadata mediaMetadata, ImageHints imageHints);

    int zzacx();

    IObjectWrapper zzacy();
}
