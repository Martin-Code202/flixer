package org.linphone.core;

import org.linphone.core.LinphoneXmlRpcRequest;
public class LinphoneXmlRpcRequestImpl implements LinphoneXmlRpcRequest {
    protected long nativePtr;

    private native void addIntArg(long j, int i);

    private native void addStringArg(long j, String str);

    private native String getContent(long j);

    private native int getIntResponse(long j);

    private native int getStatus(long j);

    private native String getStringResponse(long j);

    private native long newLinphoneXmlRpcRequest(String str, int i);

    private native void setListener(long j, LinphoneXmlRpcRequest.LinphoneXmlRpcRequestListener linphoneXmlRpcRequestListener);

    private native void unref(long j);

    protected LinphoneXmlRpcRequestImpl(long j) {
        this.nativePtr = j;
    }

    public LinphoneXmlRpcRequestImpl(String str, LinphoneXmlRpcRequest.ArgType argType) {
        this.nativePtr = newLinphoneXmlRpcRequest(str, argType.value());
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unref(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public void addIntArg(int i) {
        addIntArg(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public void addStringArg(String str) {
        addStringArg(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public String getContent() {
        return getContent(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public LinphoneXmlRpcRequest.Status getStatus() {
        return LinphoneXmlRpcRequest.Status.fromInt(getStatus(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public int getIntResponse() {
        return getIntResponse(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public String getStringResponse() {
        return getStringResponse(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneXmlRpcRequest
    public void setListener(LinphoneXmlRpcRequest.LinphoneXmlRpcRequestListener linphoneXmlRpcRequestListener) {
        setListener(this.nativePtr, linphoneXmlRpcRequestListener);
    }
}
