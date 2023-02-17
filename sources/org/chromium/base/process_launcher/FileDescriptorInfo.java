package org.chromium.base.process_launcher;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import org.chromium.base.annotations.UsedByReflection;
@UsedByReflection
public final class FileDescriptorInfo implements Parcelable {
    public static final Parcelable.Creator<FileDescriptorInfo> CREATOR = new Parcelable.Creator<FileDescriptorInfo>() { // from class: org.chromium.base.process_launcher.FileDescriptorInfo.1
        @Override // android.os.Parcelable.Creator
        public FileDescriptorInfo createFromParcel(Parcel parcel) {
            return new FileDescriptorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FileDescriptorInfo[] newArray(int i) {
            return new FileDescriptorInfo[i];
        }
    };
    public final ParcelFileDescriptor fd;
    public final int id;
    public final long offset;
    public final long size;

    FileDescriptorInfo(Parcel parcel) {
        this.id = parcel.readInt();
        this.fd = (ParcelFileDescriptor) parcel.readParcelable(ParcelFileDescriptor.class.getClassLoader());
        this.offset = parcel.readLong();
        this.size = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeParcelable(this.fd, 1);
        parcel.writeLong(this.offset);
        parcel.writeLong(this.size);
    }
}
