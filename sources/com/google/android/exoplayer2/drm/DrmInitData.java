package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.1
        @Override // android.os.Parcelable.Creator
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    };
    private int hashCode;
    public final int schemeDataCount;
    private final SchemeData[] schemeDatas;

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr, this);
        for (int i = 1; i < schemeDataArr.length; i++) {
            if (schemeDataArr[i - 1].uuid.equals(schemeDataArr[i].uuid)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr[i].uuid);
            }
        }
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }

    DrmInitData(Parcel parcel) {
        this.schemeDatas = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.schemeDataCount = this.schemeDatas.length;
    }

    public SchemeData get(int i) {
        return this.schemeDatas[i];
    }

    public DrmInitData copyWithSchemeType(String str) {
        boolean z = false;
        SchemeData[] schemeDataArr = this.schemeDatas;
        int length = schemeDataArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!Util.areEqual(schemeDataArr[i].type, str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return this;
        }
        SchemeData[] schemeDataArr2 = new SchemeData[this.schemeDatas.length];
        for (int i2 = 0; i2 < schemeDataArr2.length; i2++) {
            schemeDataArr2[i2] = this.schemeDatas[i2].copyWithSchemeType(str);
        }
        return new DrmInitData(schemeDataArr2);
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.schemeDatas, ((DrmInitData) obj).schemeDatas);
    }

    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        if (C.UUID_NIL.equals(schemeData.uuid)) {
            return C.UUID_NIL.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.schemeDatas, 0);
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.SchemeData.1
            @Override // android.os.Parcelable.Creator
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        };
        public final byte[] data;
        private int hashCode;
        public final String mimeType;
        public final boolean requiresSecureDecryption;
        public final String type;
        private final UUID uuid;

        public SchemeData(UUID uuid2, String str, String str2, byte[] bArr) {
            this(uuid2, str, str2, bArr, false);
        }

        public SchemeData(UUID uuid2, String str, String str2, byte[] bArr, boolean z) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid2);
            this.type = str;
            this.mimeType = (String) Assertions.checkNotNull(str2);
            this.data = (byte[]) Assertions.checkNotNull(bArr);
            this.requiresSecureDecryption = z;
        }

        SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.type = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.requiresSecureDecryption = parcel.readByte() != 0;
        }

        public SchemeData copyWithSchemeType(String str) {
            if (Util.areEqual(this.type, str)) {
                return this;
            }
            return new SchemeData(this.uuid, str, this.mimeType, this.data, this.requiresSecureDecryption);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return this.mimeType.equals(schemeData.mimeType) && Util.areEqual(this.uuid, schemeData.uuid) && Util.areEqual(this.type, schemeData.type) && Arrays.equals(this.data, schemeData.data);
        }

        @Override // java.lang.Object
        public int hashCode() {
            if (this.hashCode == 0) {
                this.hashCode = (((((this.uuid.hashCode() * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.hashCode;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.type);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte((byte) (this.requiresSecureDecryption ? 1 : 0));
        }
    }
}
