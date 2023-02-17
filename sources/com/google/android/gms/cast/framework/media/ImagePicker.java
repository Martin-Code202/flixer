package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.zzb;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
public class ImagePicker {
    private final zzb zzesi = new zza();

    class zza extends zzb.zza {
        private zza() {
        }

        @Override // com.google.android.gms.cast.framework.media.zzb
        public final WebImage onPickImage(MediaMetadata mediaMetadata, int i) {
            return ImagePicker.this.onPickImage(mediaMetadata, i);
        }

        @Override // com.google.android.gms.cast.framework.media.zzb
        public final WebImage zza(MediaMetadata mediaMetadata, ImageHints imageHints) {
            return ImagePicker.this.onPickImage(mediaMetadata, imageHints);
        }

        @Override // com.google.android.gms.cast.framework.media.zzb
        public final int zzacx() {
            return 11400208;
        }

        @Override // com.google.android.gms.cast.framework.media.zzb
        public final IObjectWrapper zzacy() {
            return zzn.zzw(ImagePicker.this);
        }
    }

    @Deprecated
    public WebImage onPickImage(MediaMetadata mediaMetadata, int i) {
        if (mediaMetadata == null || !mediaMetadata.hasImages()) {
            return null;
        }
        return mediaMetadata.getImages().get(0);
    }

    public WebImage onPickImage(MediaMetadata mediaMetadata, ImageHints imageHints) {
        return onPickImage(mediaMetadata, imageHints.getType());
    }

    public final zzb zzacz() {
        return this.zzesi;
    }
}
