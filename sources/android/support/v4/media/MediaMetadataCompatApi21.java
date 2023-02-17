package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;
class MediaMetadataCompatApi21 {
    MediaMetadataCompatApi21() {
    }

    public static void writeToParcel(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }

    public static Object createFromParcel(Parcel parcel) {
        return MediaMetadata.CREATOR.createFromParcel(parcel);
    }
}
