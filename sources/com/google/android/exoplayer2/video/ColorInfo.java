package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() { // from class: com.google.android.exoplayer2.video.ColorInfo.1
        @Override // android.os.Parcelable.Creator
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ColorInfo[] newArray(int i) {
            return new ColorInfo[0];
        }
    };
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.colorSpace = i;
        this.colorRange = i2;
        this.colorTransfer = i3;
        this.hdrStaticInfo = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.colorSpace = parcel.readInt();
        this.colorRange = parcel.readInt();
        this.colorTransfer = parcel.readInt();
        this.hdrStaticInfo = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ColorInfo(" + this.colorSpace + ", " + this.colorRange + ", " + this.colorTransfer + ", " + (this.hdrStaticInfo != null) + ")";
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((this.colorSpace + 527) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + Arrays.hashCode(this.hdrStaticInfo);
        }
        return this.hashCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.colorSpace);
        parcel.writeInt(this.colorRange);
        parcel.writeInt(this.colorTransfer);
        parcel.writeInt(this.hdrStaticInfo != null ? 1 : 0);
        if (this.hdrStaticInfo != null) {
            parcel.writeByteArray(this.hdrStaticInfo);
        }
    }
}
