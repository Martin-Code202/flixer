package org.linphone.core;
public class LinphoneXmlRpcSessionImpl implements LinphoneXmlRpcSession {
    protected long nativePtr;

    private native long newLinphoneXmlRpcSession(long j, String str);

    private native void sendRequest(long j, long j2);

    private native void unref(long j);

    public LinphoneXmlRpcSessionImpl(LinphoneCore linphoneCore, String str) {
        this.nativePtr = newLinphoneXmlRpcSession(((LinphoneCoreImpl) linphoneCore).nativePtr, str);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unref(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneXmlRpcSession
    public void sendRequest(LinphoneXmlRpcRequest linphoneXmlRpcRequest) {
        sendRequest(this.nativePtr, ((LinphoneXmlRpcRequestImpl) linphoneXmlRpcRequest).getNativePtr());
    }
}
