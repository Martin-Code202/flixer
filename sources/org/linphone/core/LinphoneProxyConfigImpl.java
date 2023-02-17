package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneCore;
class LinphoneProxyConfigImpl implements LinphoneProxyConfig {
    protected LinphoneCoreImpl mCore;
    protected final long nativePtr;
    Object userData;

    private native boolean avpfEnabled(long j);

    private native long createProxyConfig(long j);

    private native void done(long j);

    private native void edit(long j);

    private native void enableAvpf(long j, boolean z);

    private native void enablePublish(long j, boolean z);

    private native void enableQualityReporting(long j, boolean z);

    private native void enableRegister(long j, boolean z);

    private native void finalize(long j);

    private native long getAddress(long j);

    private native int getAvpfRRInterval(long j);

    private native String getContactParameters(long j);

    private native String getContactUriParameters(long j);

    private native String getCustomHeader(long j, String str);

    private native boolean getDialEscapePlus(long j);

    private native String getDialPrefix(long j);

    private native String getDomain(long j);

    private native int getError(long j);

    private native long getErrorInfo(long j);

    private native int getExpires(long j);

    private native String getIdentity(long j);

    private native Object getNatPolicy(long j);

    private native int getPrivacy(long j);

    private native String getProxy(long j);

    private native int getPublishExpires(long j);

    private native String getQualityReportingCollector(long j);

    private native int getQualityReportingInterval(long j);

    private native String getRealm(long j);

    private native String getRoute(long j);

    private native int getState(long j);

    private native boolean isPhoneNumber(long j, String str);

    private native boolean isRegisterEnabled(long j);

    private native boolean isRegistered(long j);

    private native int lookupCCCFromE164(long j, String str);

    private native int lookupCCCFromIso(long j, String str);

    private native long newLinphoneProxyConfig();

    private native String normalizePhoneNumber(long j, String str);

    private native long normalizeSipUri(long j, String str);

    private native void pauseRegister(long j);

    private native boolean publishEnabled(long j);

    private native boolean qualityReportingEnabled(long j);

    private native void refreshRegister(long j);

    private native void setAddress(long j, long j2);

    private native void setAvpfRRInterval(long j, int i);

    private native void setContactParameters(long j, String str);

    private native void setContactUriParameters(long j, String str);

    private native void setCustomHeader(long j, String str, String str2);

    private native void setDialEscapePlus(long j, boolean z);

    private native void setDialPrefix(long j, String str);

    private native void setExpires(long j, int i);

    private native void setIdentity(long j, String str);

    private native void setNatPolicy(long j, long j2);

    private native void setPrivacy(long j, int i);

    private native int setProxy(long j, String str);

    private native void setPublishExpires(long j, int i);

    private native void setQualityReportingCollector(long j, String str);

    private native void setQualityReportingInterval(long j, int i);

    private native void setRealm(long j, String str);

    private native int setRoute(long j, String str);

    protected LinphoneProxyConfigImpl(LinphoneCoreImpl linphoneCoreImpl, String str, String str2, String str3, boolean z) {
        this.mCore = linphoneCoreImpl;
        this.nativePtr = createProxyConfig(linphoneCoreImpl.nativePtr);
        setIdentity(str);
        setProxy(str2);
        setRoute(str3);
        enableRegister(z);
    }

    protected LinphoneProxyConfigImpl(LinphoneCoreImpl linphoneCoreImpl) {
        this.mCore = linphoneCoreImpl;
        this.nativePtr = createProxyConfig(linphoneCoreImpl.nativePtr);
    }

    protected LinphoneProxyConfigImpl(LinphoneCoreImpl linphoneCoreImpl, long j) {
        this.mCore = linphoneCoreImpl;
        this.nativePtr = j;
    }

    private void isValid() {
        if (this.nativePtr == 0) {
            throw new RuntimeException("proxy config removed");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.nativePtr != 0) {
            finalize(this.nativePtr);
        }
        super.finalize();
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public LinphoneProxyConfig enableRegister(boolean z) {
        isValid();
        enableRegister(this.nativePtr, z);
        return this;
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void done() {
        isValid();
        synchronized ((this.mCore != null ? this.mCore : this)) {
            done(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public LinphoneProxyConfig edit() {
        isValid();
        synchronized ((this.mCore != null ? this.mCore : this)) {
            edit(this.nativePtr);
        }
        return this;
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public LinphoneNatPolicy getNatPolicy() {
        isValid();
        return (LinphoneNatPolicy) getNatPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setNatPolicy(LinphoneNatPolicy linphoneNatPolicy) {
        isValid();
        setNatPolicy(this.nativePtr, ((LinphoneNatPolicyImpl) linphoneNatPolicy).mNativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setIdentity(String str) {
        isValid();
        setIdentity(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setAddress(LinphoneAddress linphoneAddress) {
        isValid();
        setAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setProxy(String str) {
        isValid();
        if (setProxy(this.nativePtr, str) != 0) {
            throw new LinphoneCoreException("Bad proxy address [" + str + "]");
        }
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String normalizePhoneNumber(String str) {
        isValid();
        return normalizePhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public LinphoneAddress normalizeSipUri(String str) {
        isValid();
        long normalizeSipUri = normalizeSipUri(this.nativePtr, str);
        if (normalizeSipUri == 0) {
            return null;
        }
        return new LinphoneAddressImpl(normalizeSipUri, LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setDialPrefix(String str) {
        isValid();
        setDialPrefix(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getDialPrefix() {
        isValid();
        return getDialPrefix(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getDomain() {
        isValid();
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setDialEscapePlus(boolean z) {
        isValid();
        setDialEscapePlus(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean getDialEscapePlus() {
        isValid();
        return getDialEscapePlus(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getIdentity() {
        isValid();
        return getIdentity(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public LinphoneAddress getAddress() {
        isValid();
        long address = getAddress(this.nativePtr);
        if (address == 0) {
            return null;
        }
        return new LinphoneAddressImpl(address, LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getProxy() {
        isValid();
        return getProxy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean isRegistered() {
        isValid();
        return isRegistered(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean registerEnabled() {
        isValid();
        return isRegisterEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getRoute() {
        isValid();
        return getRoute(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setRoute(String str) {
        isValid();
        if (setRoute(this.nativePtr, str) != 0) {
            throw new LinphoneCoreException("cannot set route [" + str + "]");
        }
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void enablePublish(boolean z) {
        isValid();
        enablePublish(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public LinphoneCore.RegistrationState getState() {
        isValid();
        return LinphoneCore.RegistrationState.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setExpires(int i) {
        isValid();
        setExpires(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int getExpires() {
        isValid();
        return getExpires(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean publishEnabled() {
        isValid();
        return publishEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setContactParameters(String str) {
        isValid();
        setContactParameters(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int lookupCCCFromIso(String str) {
        isValid();
        return lookupCCCFromIso(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int lookupCCCFromE164(String str) {
        isValid();
        return lookupCCCFromE164(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public Reason getError() {
        isValid();
        return Reason.fromInt(getError(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setPrivacy(int i) {
        isValid();
        setPrivacy(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int getPrivacy() {
        isValid();
        return getPrivacy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void enableAvpf(boolean z) {
        isValid();
        enableAvpf(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean avpfEnabled() {
        isValid();
        return avpfEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setAvpfRRInterval(int i) {
        isValid();
        setAvpfRRInterval(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int getAvpfRRInterval() {
        isValid();
        return getAvpfRRInterval(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getContactParameters() {
        isValid();
        return getContactParameters(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setContactUriParameters(String str) {
        isValid();
        setContactUriParameters(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getContactUriParameters() {
        isValid();
        return getContactUriParameters(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public ErrorInfo getErrorInfo() {
        return new ErrorInfoImpl(getErrorInfo(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void enableQualityReporting(boolean z) {
        isValid();
        enableQualityReporting(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean qualityReportingEnabled() {
        isValid();
        return avpfEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setQualityReportingInterval(int i) {
        isValid();
        setQualityReportingInterval(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int getQualityReportingInterval() {
        isValid();
        return getQualityReportingInterval(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setQualityReportingCollector(String str) {
        isValid();
        setQualityReportingCollector(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getQualityReportingCollector() {
        isValid();
        return getQualityReportingCollector(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setRealm(String str) {
        isValid();
        setRealm(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getRealm() {
        isValid();
        return getRealm(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setPublishExpires(int i) {
        isValid();
        setPublishExpires(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public int getPublishExpires() {
        isValid();
        return getPublishExpires(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public boolean isPhoneNumber(String str) {
        return isPhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void setCustomHeader(String str, String str2) {
        setCustomHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public String getCustomHeader(String str) {
        return getCustomHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void refreshRegister() {
        refreshRegister(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneProxyConfig
    public void pauseRegister() {
        pauseRegister(this.nativePtr);
    }
}
