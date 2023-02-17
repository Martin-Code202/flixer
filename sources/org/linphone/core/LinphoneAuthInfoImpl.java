package org.linphone.core;
class LinphoneAuthInfoImpl implements LinphoneAuthInfo {
    protected final long nativePtr;
    boolean ownPtr;

    private native void delete(long j);

    private native String getDomain(long j);

    private native String getHa1(long j);

    private native String getPassword(long j);

    private native String getRealm(long j);

    private native String getTlsCertificate(long j);

    private native String getTlsCertificatePath(long j);

    private native String getTlsKey(long j);

    private native String getTlsKeyPath(long j);

    private native String getUserId(long j);

    private native String getUsername(long j);

    private native long newLinphoneAuthInfo();

    private native void setDomain(long j, String str);

    private native void setHa1(long j, String str);

    private native void setPassword(long j, String str);

    private native void setRealm(long j, String str);

    private native void setTlsCertificate(long j, String str);

    private native void setTlsCertificatePath(long j, String str);

    private native void setTlsKey(long j, String str);

    private native void setTlsKeyPath(long j, String str);

    private native void setUserId(long j, String str);

    private native void setUsername(long j, String str);

    protected LinphoneAuthInfoImpl(String str, String str2, String str3, String str4) {
        this(str, null, str2, null, str3, str4);
    }

    protected LinphoneAuthInfoImpl(String str, String str2, String str3, String str4, String str5, String str6) {
        this.ownPtr = false;
        this.nativePtr = newLinphoneAuthInfo();
        setUsername(str);
        setUserId(str2);
        setPassword(str3);
        setHa1(str4);
        setDomain(str6);
        setRealm(str5);
        this.ownPtr = true;
    }

    protected LinphoneAuthInfoImpl(long j) {
        this.ownPtr = false;
        this.nativePtr = j;
        this.ownPtr = false;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.ownPtr) {
            delete(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getPassword() {
        return getPassword(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getRealm() {
        return getRealm(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getUsername() {
        return getUsername(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setPassword(String str) {
        setPassword(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setRealm(String str) {
        setRealm(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setUsername(String str) {
        setUsername(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getUserId() {
        return getUserId(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setUserId(String str) {
        setUserId(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getHa1() {
        return getHa1(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setHa1(String str) {
        setHa1(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setDomain(String str) {
        setDomain(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getDomain() {
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public LinphoneAuthInfo clone() {
        return LinphoneCoreFactory.instance().createAuthInfo(getUsername(), getUserId(), getPassword(), getHa1(), getRealm(), getDomain());
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getTlsCertificate() {
        return getTlsCertificate(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getTlsKey() {
        return getTlsKey(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getTlsCertificatePath() {
        return getTlsCertificatePath(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public String getTlsKeyPath() {
        return getTlsKeyPath(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setTlsCertificate(String str) {
        setTlsCertificate(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setTlsKey(String str) {
        setTlsKey(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setTlsCertificatePath(String str) {
        setTlsCertificatePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneAuthInfo
    public void setTlsKeyPath(String str) {
        setTlsKeyPath(this.nativePtr, str);
    }
}
