package org.linphone.core;
public class ErrorInfoImpl implements ErrorInfo {
    protected long mNativePtr;

    private native String getPhrase(long j);

    private native String getProtocol(long j);

    private native int getProtocolCode(long j);

    private native int getReason(long j);

    private native long getSubErrorInfo(long j);

    private native String getWarnings(long j);

    private native void ref(long j);

    private native void setPhrase(long j, String str);

    private native void setProtocol(long j, String str);

    private native void setProtocolCode(long j, int i);

    private native void setReason(long j, int i);

    private native void setSubErrorInfo(long j, long j2);

    private native void setWarnings(long j, String str);

    private native void unref(long j);

    public ErrorInfoImpl(long j, boolean z) {
        if (!z) {
            ref(j);
        }
        this.mNativePtr = j;
    }

    public ErrorInfoImpl(long j) {
        ref(j);
        this.mNativePtr = j;
    }

    @Override // org.linphone.core.ErrorInfo
    public Reason getReason() {
        return Reason.fromInt(getReason(this.mNativePtr));
    }

    @Override // org.linphone.core.ErrorInfo
    public String getProtocol() {
        return getProtocol(this.mNativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public int getProtocolCode() {
        return getProtocolCode(this.mNativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public String getPhrase() {
        return getPhrase(this.mNativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public String getWarnings() {
        return getWarnings(this.mNativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public ErrorInfo getSubErrorInfo() {
        long subErrorInfo = getSubErrorInfo(this.mNativePtr);
        if (subErrorInfo != 0) {
            return new ErrorInfoImpl(subErrorInfo, false);
        }
        return null;
    }

    @Override // org.linphone.core.ErrorInfo
    public void setReason(Reason reason) {
        setReason(this.mNativePtr, reason.mValue);
    }

    @Override // org.linphone.core.ErrorInfo
    public void setProtocol(String str) {
        setProtocol(this.mNativePtr, str);
    }

    @Override // org.linphone.core.ErrorInfo
    public void setProtocolCode(int i) {
        setProtocolCode(this.mNativePtr, i);
    }

    @Override // org.linphone.core.ErrorInfo
    public void setPhrase(String str) {
        setPhrase(this.mNativePtr, str);
    }

    @Override // org.linphone.core.ErrorInfo
    public void setWarnings(String str) {
        setWarnings(this.mNativePtr, str);
    }

    @Override // org.linphone.core.ErrorInfo
    public void setSubErrorInfo(ErrorInfo errorInfo) {
        setSubErrorInfo(this.mNativePtr, errorInfo != null ? ((ErrorInfoImpl) errorInfo).mNativePtr : 0);
    }

    @Override // org.linphone.core.ErrorInfo
    public String getDetails() {
        return getWarnings();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.mNativePtr != 0) {
            unref(this.mNativePtr);
            this.mNativePtr = 0;
        }
    }
}
