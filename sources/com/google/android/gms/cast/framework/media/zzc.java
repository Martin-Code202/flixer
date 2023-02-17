package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzc extends zzeb implements zzb {
    zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker");
    }

    @Override // com.google.android.gms.cast.framework.media.zzb
    public final WebImage onPickImage(MediaMetadata mediaMetadata, int i) {
        Parcel zzax = zzax();
        zzed.zza(zzax, mediaMetadata);
        zzax.writeInt(i);
        Parcel zza = zza(1, zzax);
        WebImage webImage = (WebImage) zzed.zza(zza, WebImage.CREATOR);
        zza.recycle();
        return webImage;
    }

    @Override // com.google.android.gms.cast.framework.media.zzb
    public final WebImage zza(MediaMetadata mediaMetadata, ImageHints imageHints) {
        Parcel zzax = zzax();
        zzed.zza(zzax, mediaMetadata);
        zzed.zza(zzax, imageHints);
        Parcel zza = zza(4, zzax);
        WebImage webImage = (WebImage) zzed.zza(zza, WebImage.CREATOR);
        zza.recycle();
        return webImage;
    }

    @Override // com.google.android.gms.cast.framework.media.zzb
    public final int zzacx() {
        Parcel zza = zza(3, zzax());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.cast.framework.media.zzb
    public final IObjectWrapper zzacy() {
        Parcel zza = zza(2, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}
