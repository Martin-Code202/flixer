package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneCall;
class LinphoneCallImpl implements LinphoneCall {
    LinphoneCore mCore;
    protected final long nativePtr;
    boolean ownPtr = false;
    Object userData;

    private native boolean askedToAutoAnswer(long j);

    private native boolean cameraEnabled(long j);

    private native void declineWithErrorInfo(long j, long j2);

    private native void enableCamera(long j, boolean z);

    private native void enableEchoCancellation(long j, boolean z);

    private native void enableEchoLimiter(long j, boolean z);

    private native void finalize(long j);

    private native String getAuthenticationToken(long j);

    private native float getAverageQuality(long j);

    private native long getCallLog(long j);

    private native Object getChatRoom(long j);

    private native LinphoneCore getCore(long j);

    private native long getCurrentParams(long j);

    private native float getCurrentQuality(long j);

    private native long getDiversionAddress(long j);

    private native int getDuration(long j);

    private native long getErrorInfo(long j);

    private native float getPlayVolume(long j);

    private native long getPlayer(long j);

    private native long getRemoteAddress(long j);

    private native String getRemoteContact(long j);

    private native long getRemoteParams(long j);

    private native String getRemoteUserAgent(long j);

    private native Object getReplacedCall(long j);

    private native int getState(long j);

    private native Object getStats(long j, int i);

    private native int getTransferState(long j);

    private native Object getTransferTargetCall(long j);

    private native Object getTransfererCall(long j);

    private native boolean isAuthenticationTokenVerified(long j);

    private native boolean isEchoCancellationEnabled(long j);

    private native boolean isEchoLimiterEnabled(long j);

    private native boolean isIncoming(long j);

    private native boolean mediaInProgress(long j);

    private native int sendInfoMessage(long j, long j2);

    private native void setAuthenticationTokenVerified(long j, boolean z);

    private native void setListener(long j, LinphoneCall.LinphoneCallListener linphoneCallListener);

    private native void setVideoWindowId(long j, Object obj);

    private native void startRecording(long j);

    private native void stopRecording(long j);

    private native void takeSnapshot(long j, String str);

    private native void terminateWithErrorInfo(long j, long j2);

    private native void zoomVideo(long j, float f, float f2, float f3);

    public native LinphoneConference getConference(long j);

    private LinphoneCallImpl(long j) {
        this.nativePtr = j;
        this.mCore = getCore(this.nativePtr);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        finalize(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCallLog getCallLog() {
        long callLog = getCallLog(this.nativePtr);
        if (callLog != 0) {
            return new LinphoneCallLogImpl(callLog);
        }
        return null;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCallStats getAudioStats() {
        LinphoneCallStats linphoneCallStats;
        synchronized (this.mCore) {
            linphoneCallStats = (LinphoneCallStats) getStats(this.nativePtr, 0);
        }
        return linphoneCallStats;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCallStats getVideoStats() {
        LinphoneCallStats linphoneCallStats;
        synchronized (this.mCore) {
            linphoneCallStats = (LinphoneCallStats) getStats(this.nativePtr, 1);
        }
        return linphoneCallStats;
    }

    @Override // org.linphone.core.LinphoneCall
    public CallDirection getDirection() {
        return isIncoming(this.nativePtr) ? CallDirection.Incoming : CallDirection.Outgoing;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneAddress getRemoteAddress() {
        long remoteAddress = getRemoteAddress(this.nativePtr);
        if (remoteAddress != 0) {
            return new LinphoneAddressImpl(remoteAddress, LinphoneAddressImpl.WrapMode.FromConst);
        }
        return null;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCall.State getState() {
        return LinphoneCall.State.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCallParams getCurrentParams() {
        LinphoneCallParamsImpl linphoneCallParamsImpl;
        synchronized (this.mCore) {
            linphoneCallParamsImpl = new LinphoneCallParamsImpl(getCurrentParams(this.nativePtr));
        }
        return linphoneCallParamsImpl;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCallParams getCurrentParamsCopy() {
        return getCurrentParams();
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCallParams getRemoteParams() {
        synchronized (this.mCore) {
            long remoteParams = getRemoteParams(this.nativePtr);
            if (remoteParams == 0) {
                return null;
            }
            return new LinphoneCallParamsImpl(remoteParams);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public void enableCamera(boolean z) {
        synchronized (this.mCore) {
            enableCamera(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean cameraEnabled() {
        return cameraEnabled(this.nativePtr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof LinphoneCallImpl) && this.nativePtr == ((LinphoneCallImpl) obj).nativePtr;
    }

    public int hashCode() {
        return ((int) (this.nativePtr ^ (this.nativePtr >>> 32))) + 527;
    }

    @Override // org.linphone.core.LinphoneCall
    public void enableEchoCancellation(boolean z) {
        enableEchoCancellation(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean isEchoCancellationEnabled() {
        return isEchoCancellationEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public void enableEchoLimiter(boolean z) {
        enableEchoLimiter(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean isEchoLimiterEnabled() {
        return isEchoLimiterEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCall getReplacedCall() {
        return (LinphoneCall) getReplacedCall(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public int getDuration() {
        return getDuration(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public float getAverageQuality() {
        return getAverageQuality(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public float getCurrentQuality() {
        return getCurrentQuality(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public String getAuthenticationToken() {
        return getAuthenticationToken(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean isAuthenticationTokenVerified() {
        return isAuthenticationTokenVerified(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public void setAuthenticationTokenVerified(boolean z) {
        setAuthenticationTokenVerified(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean isInConference() {
        return getConference() != null;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneConference getConference() {
        return getConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean mediaInProgress() {
        return mediaInProgress(this.nativePtr);
    }

    public String toString() {
        return "Call " + this.nativePtr;
    }

    @Override // org.linphone.core.LinphoneCall
    public float getPlayVolume() {
        return getPlayVolume(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public String getRemoteUserAgent() {
        return getRemoteUserAgent(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public String getRemoteContact() {
        return getRemoteContact(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public void takeSnapshot(String str) {
        synchronized (this.mCore) {
            takeSnapshot(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public void zoomVideo(float f, float f2, float f3) {
        zoomVideo(this.nativePtr, f, f2, f3);
    }

    @Override // org.linphone.core.LinphoneCall
    public void startRecording() {
        synchronized (this.mCore) {
            startRecording(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public void stopRecording() {
        synchronized (this.mCore) {
            stopRecording(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCall.State getTransferState() {
        return LinphoneCall.State.fromInt(getTransferState(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCall
    public void sendInfoMessage(LinphoneInfoMessage linphoneInfoMessage) {
        synchronized (this.mCore) {
            sendInfoMessage(this.nativePtr, ((LinphoneInfoMessageImpl) linphoneInfoMessage).nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCall getTransfererCall() {
        return (LinphoneCall) getTransfererCall(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneCall getTransferTargetCall() {
        return (LinphoneCall) getTransferTargetCall(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public Reason getReason() {
        return null;
    }

    @Override // org.linphone.core.LinphoneCall
    public ErrorInfo getErrorInfo() {
        ErrorInfoImpl errorInfoImpl;
        synchronized (this.mCore) {
            errorInfoImpl = new ErrorInfoImpl(getErrorInfo(this.nativePtr));
        }
        return errorInfoImpl;
    }

    @Override // org.linphone.core.LinphoneCall
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.LinphoneCall
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphonePlayer getPlayer() {
        LinphonePlayerImpl linphonePlayerImpl;
        synchronized (this.mCore) {
            linphonePlayerImpl = new LinphonePlayerImpl(getPlayer(this.nativePtr));
        }
        return linphonePlayerImpl;
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneChatRoom getChatRoom() {
        LinphoneChatRoom linphoneChatRoom;
        synchronized (this.mCore) {
            linphoneChatRoom = (LinphoneChatRoom) getChatRoom(this.nativePtr);
        }
        return linphoneChatRoom;
    }

    @Override // org.linphone.core.LinphoneCall
    public void setListener(LinphoneCall.LinphoneCallListener linphoneCallListener) {
        synchronized (this.mCore) {
            setListener(this.nativePtr, linphoneCallListener);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public synchronized void setVideoWindow(Object obj) {
        setVideoWindowId(this.nativePtr, obj);
    }

    @Override // org.linphone.core.LinphoneCall
    public LinphoneAddress getDiversionAddress() {
        long diversionAddress = getDiversionAddress(this.nativePtr);
        if (diversionAddress != 0) {
            return new LinphoneAddressImpl(diversionAddress, LinphoneAddressImpl.WrapMode.FromConst);
        }
        return null;
    }

    @Override // org.linphone.core.LinphoneCall
    public boolean askedToAutoAnswer() {
        return askedToAutoAnswer(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCall
    public void declineWithErrorInfo(ErrorInfo errorInfo) {
        synchronized (this.mCore) {
            declineWithErrorInfo(this.nativePtr, ((ErrorInfoImpl) errorInfo).mNativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneCall
    public void terminateWithErrorInfo(ErrorInfo errorInfo) {
        synchronized (this.mCore) {
            terminateWithErrorInfo(this.nativePtr, ((ErrorInfoImpl) errorInfo).mNativePtr);
        }
    }
}
