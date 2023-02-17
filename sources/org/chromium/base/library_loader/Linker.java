package org.chromium.base.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;
import java.util.Locale;
import org.chromium.base.Log;
import org.chromium.base.annotations.AccessedByNative;
public abstract class Linker {
    private static Object sSingletonLock = new Object();
    protected final Object mLock = new Object();
    protected int mMemoryDeviceConfig = 0;

    private static native long nativeGetRandomBaseLoadAddress();

    protected Linker() {
    }

    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new Parcelable.Creator<LibInfo>() { // from class: org.chromium.base.library_loader.Linker.LibInfo.1
            @Override // android.os.Parcelable.Creator
            public LibInfo createFromParcel(Parcel parcel) {
                return new LibInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LibInfo[] newArray(int i) {
                return new LibInfo[i];
            }
        };
        @AccessedByNative
        public long mLoadAddress;
        @AccessedByNative
        public long mLoadSize;
        @AccessedByNative
        public int mRelroFd;
        @AccessedByNative
        public long mRelroSize;
        @AccessedByNative
        public long mRelroStart;

        public LibInfo() {
            this.mLoadAddress = 0;
            this.mLoadSize = 0;
            this.mRelroStart = 0;
            this.mRelroSize = 0;
            this.mRelroFd = -1;
        }

        public LibInfo(Parcel parcel) {
            this.mLoadAddress = parcel.readLong();
            this.mLoadSize = parcel.readLong();
            this.mRelroStart = parcel.readLong();
            this.mRelroSize = parcel.readLong();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            this.mRelroFd = parcelFileDescriptor == null ? -1 : parcelFileDescriptor.detachFd();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mRelroFd >= 0) {
                parcel.writeLong(this.mLoadAddress);
                parcel.writeLong(this.mLoadSize);
                parcel.writeLong(this.mRelroStart);
                parcel.writeLong(this.mRelroSize);
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.mRelroFd);
                    fromFd.writeToParcel(parcel, 0);
                    fromFd.close();
                } catch (IOException e) {
                    Log.e("LibraryLoader", "Can't write LibInfo file descriptor to parcel", e);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", Long.valueOf(this.mLoadAddress), Long.valueOf(this.mLoadAddress + this.mLoadSize), Long.valueOf(this.mRelroStart), Long.valueOf(this.mRelroStart + this.mRelroSize), Integer.valueOf(this.mRelroFd));
        }
    }
}
