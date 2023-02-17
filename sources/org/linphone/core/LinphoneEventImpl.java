package org.linphone.core;
public class LinphoneEventImpl implements LinphoneEvent {
    private long mNativePtr;
    private Object mUserContext;

    private native int acceptSubscription(long j);

    private native void addCustomHeader(long j, String str, String str2);

    private native int denySubscription(long j, int i);

    private native Object getCore(long j);

    private native String getCustomHeader(long j, String str);

    private native long getErrorInfo(long j);

    private native String getEventName(long j);

    private native int getReason(long j);

    private native int getSubscriptionDir(long j);

    private native int getSubscriptionState(long j);

    private native int notify(long j, String str, String str2, byte[] bArr, String str3);

    private native void sendPublish(long j, String str, String str2, byte[] bArr, String str3);

    private native void sendSubscribe(long j, String str, String str2, byte[] bArr, String str3);

    private native int terminate(long j);

    private native void unref(long j);

    private native int updatePublish(long j, String str, String str2, byte[] bArr, String str3);

    private native int updateSubscribe(long j, String str, String str2, byte[] bArr, String str3);

    protected LinphoneEventImpl(long j) {
        this.mNativePtr = j;
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized String getEventName() {
        return getEventName(this.mNativePtr);
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized void acceptSubscription() {
        synchronized (getCore()) {
            acceptSubscription(this.mNativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized void denySubscription(Reason reason) {
        synchronized (getCore()) {
            denySubscription(this.mNativePtr, reason.mValue);
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public void notify(LinphoneContent linphoneContent) {
        synchronized (getCore()) {
            notify(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public void updateSubscribe(LinphoneContent linphoneContent) {
        synchronized (getCore()) {
            updateSubscribe(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public void updatePublish(LinphoneContent linphoneContent) {
        synchronized (getCore()) {
            updatePublish(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public void terminate() {
        synchronized (getCore()) {
            terminate(this.mNativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized Reason getReason() {
        return Reason.fromInt(getReason(this.mNativePtr));
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized void setUserContext(Object obj) {
        this.mUserContext = obj;
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized Object getUserContext() {
        return this.mUserContext;
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized SubscriptionDir getSubscriptionDir() {
        return SubscriptionDir.fromInt(getSubscriptionDir(this.mNativePtr));
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized SubscriptionState getSubscriptionState() {
        try {
        } catch (LinphoneCoreException e) {
            e.printStackTrace();
            return SubscriptionState.Error;
        }
        return SubscriptionState.fromInt(getSubscriptionState(this.mNativePtr));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unref(this.mNativePtr);
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized void addCustomHeader(String str, String str2) {
        addCustomHeader(this.mNativePtr, str, str2);
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized String getCustomHeader(String str) {
        return getCustomHeader(this.mNativePtr, str);
    }

    @Override // org.linphone.core.LinphoneEvent
    public void sendSubscribe(LinphoneContent linphoneContent) {
        synchronized (getCore()) {
            if (linphoneContent != null) {
                sendSubscribe(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
            } else {
                sendSubscribe(this.mNativePtr, null, null, null, null);
            }
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public void sendPublish(LinphoneContent linphoneContent) {
        synchronized (getCore()) {
            if (linphoneContent != null) {
                sendPublish(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
            } else {
                sendPublish(this.mNativePtr, null, null, null, null);
            }
        }
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized ErrorInfo getErrorInfo() {
        return new ErrorInfoImpl(getErrorInfo(this.mNativePtr));
    }

    @Override // org.linphone.core.LinphoneEvent
    public synchronized LinphoneCore getCore() {
        return (LinphoneCore) getCore(this.mNativePtr);
    }
}
