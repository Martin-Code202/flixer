package org.linphone.core;
public class LinphoneNatPolicyImpl implements LinphoneNatPolicy {
    protected final long mNativePtr;

    private native void clear(long j);

    private native void enableIce(long j, boolean z);

    private native void enableStun(long j, boolean z);

    private native void enableTurn(long j, boolean z);

    private native void enableUpnp(long j, boolean z);

    private native Object getCore(long j);

    private native String getStunServer(long j);

    private native String getStunServerUsername(long j);

    private native boolean iceEnabled(long j);

    private native void setStunServer(long j, String str);

    private native void setStunServerUsername(long j, String str);

    private native boolean stunEnabled(long j);

    private native boolean turnEnabled(long j);

    private native boolean upnpEnabled(long j);

    protected LinphoneNatPolicyImpl(long j) {
        this.mNativePtr = j;
    }

    private synchronized LinphoneCore getCore() {
        return (LinphoneCore) getCore(this.mNativePtr);
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void clear() {
        synchronized (getCore()) {
            clear(this.mNativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public boolean stunEnabled() {
        boolean stunEnabled;
        synchronized (getCore()) {
            stunEnabled = stunEnabled(this.mNativePtr);
        }
        return stunEnabled;
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void enableStun(boolean z) {
        synchronized (getCore()) {
            enableStun(this.mNativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public boolean turnEnabled() {
        boolean turnEnabled;
        synchronized (getCore()) {
            turnEnabled = turnEnabled(this.mNativePtr);
        }
        return turnEnabled;
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void enableTurn(boolean z) {
        synchronized (getCore()) {
            enableTurn(this.mNativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public boolean iceEnabled() {
        boolean iceEnabled;
        synchronized (getCore()) {
            iceEnabled = iceEnabled(this.mNativePtr);
        }
        return iceEnabled;
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void enableIce(boolean z) {
        synchronized (getCore()) {
            enableIce(this.mNativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public boolean upnpEnabled() {
        boolean upnpEnabled;
        synchronized (getCore()) {
            upnpEnabled = upnpEnabled(this.mNativePtr);
        }
        return upnpEnabled;
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void enableUpnp(boolean z) {
        synchronized (getCore()) {
            enableUpnp(this.mNativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public String getStunServer() {
        String stunServer;
        synchronized (getCore()) {
            stunServer = getStunServer(this.mNativePtr);
        }
        return stunServer;
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void setStunServer(String str) {
        synchronized (getCore()) {
            setStunServer(this.mNativePtr, str);
        }
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public String getStunServerUsername() {
        String stunServerUsername;
        synchronized (getCore()) {
            stunServerUsername = getStunServerUsername(this.mNativePtr);
        }
        return stunServerUsername;
    }

    @Override // org.linphone.core.LinphoneNatPolicy
    public void setStunServerUsername(String str) {
        synchronized (getCore()) {
            setStunServerUsername(this.mNativePtr, str);
        }
    }
}
