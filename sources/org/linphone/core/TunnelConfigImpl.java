package org.linphone.core;
public class TunnelConfigImpl implements TunnelConfig {
    long mNativePtr;

    private native void destroy(long j);

    private native void enableSip(long j, boolean z);

    private native int getDelay(long j);

    private native String getHost(long j);

    private native String getHost2(long j);

    private native int getPort(long j);

    private native int getPort2(long j);

    private native int getRemoteUdpMirrorPort(long j);

    private native void setDelay(long j, int i);

    private native void setHost(long j, String str);

    private native void setHost2(long j, String str);

    private native void setPort(long j, int i);

    private native void setPort2(long j, int i);

    private native void setRemoteUdpMirrorPort(long j, int i);

    protected TunnelConfigImpl(long j) {
        this.mNativePtr = j;
    }

    @Override // org.linphone.core.TunnelConfig
    public String getHost() {
        return getHost(this.mNativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public void setHost(String str) {
        setHost(this.mNativePtr, str);
    }

    @Override // org.linphone.core.TunnelConfig
    public int getPort() {
        return getPort(this.mNativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public void setPort(int i) {
        setPort(this.mNativePtr, i);
    }

    @Override // org.linphone.core.TunnelConfig
    public String getHost2() {
        return getHost2(this.mNativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public void setHost2(String str) {
        setHost2(this.mNativePtr, str);
    }

    @Override // org.linphone.core.TunnelConfig
    public int getPort2() {
        return getPort2(this.mNativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public void setPort2(int i) {
        setPort2(this.mNativePtr, i);
    }

    @Override // org.linphone.core.TunnelConfig
    public int getRemoteUdpMirrorPort() {
        return getRemoteUdpMirrorPort(this.mNativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public void setRemoteUdpMirrorPort(int i) {
        setRemoteUdpMirrorPort(this.mNativePtr, i);
    }

    @Override // org.linphone.core.TunnelConfig
    public int getDelay() {
        return getDelay(this.mNativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public void setDelay(int i) {
        setDelay(this.mNativePtr, i);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.mNativePtr != 0) {
            destroy(this.mNativePtr);
        }
    }
}
