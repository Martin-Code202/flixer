package org.linphone.mediastream;
public class Factory {
    private long mNativePtr;

    private native void enableFilterFromName(long j, String str, boolean z);

    private native boolean filterFromNameEnabled(long j, String str);

    private native String getDecoderText(long j, String str);

    private native String getEncoderText(long j, String str);

    private native void setDeviceInfo(long j, String str, String str2, String str3, int i, int i2, int i3);

    private Factory(long j) {
        this.mNativePtr = j;
    }

    public void enableFilterFromName(String str, boolean z) {
        enableFilterFromName(this.mNativePtr, str, z);
    }

    public boolean filterFromNameEnabled(String str) {
        return filterFromNameEnabled(this.mNativePtr, str);
    }

    public void setDeviceInfo(String str, String str2, String str3, int i, int i2, int i3) {
        setDeviceInfo(this.mNativePtr, str, str2, str3, i, i2, i3);
    }

    public String getEncoderText(String str) {
        return getEncoderText(this.mNativePtr, str);
    }

    public String getDecoderText(String str) {
        return getDecoderText(this.mNativePtr, str);
    }
}
