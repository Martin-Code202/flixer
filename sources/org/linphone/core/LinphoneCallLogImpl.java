package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneCallLog;
class LinphoneCallLogImpl implements LinphoneCallLog {
    protected final long nativePtr;

    private native int getCallDuration(long j);

    private native String getCallId(long j);

    private native long getFrom(long j);

    private native String getStartDate(long j);

    private native int getStatus(long j);

    private native long getTimestamp(long j);

    private native long getTo(long j);

    private native boolean isIncoming(long j);

    private native boolean wasConference(long j);

    LinphoneCallLogImpl(long j) {
        this.nativePtr = j;
    }

    @Override // org.linphone.core.LinphoneCallLog
    public CallDirection getDirection() {
        return isIncoming(this.nativePtr) ? CallDirection.Incoming : CallDirection.Outgoing;
    }

    @Override // org.linphone.core.LinphoneCallLog
    public LinphoneAddress getFrom() {
        return new LinphoneAddressImpl(getFrom(this.nativePtr), LinphoneAddressImpl.WrapMode.FromExisting);
    }

    @Override // org.linphone.core.LinphoneCallLog
    public LinphoneAddress getTo() {
        return new LinphoneAddressImpl(getTo(this.nativePtr), LinphoneAddressImpl.WrapMode.FromExisting);
    }

    @Override // org.linphone.core.LinphoneCallLog
    public LinphoneCallLog.CallStatus getStatus() {
        return LinphoneCallLog.CallStatus.fromInt(getStatus(this.nativePtr));
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // org.linphone.core.LinphoneCallLog
    public String getStartDate() {
        return getStartDate(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallLog
    public int getCallDuration() {
        return getCallDuration(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallLog
    public String getCallId() {
        return getCallId(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallLog
    public long getTimestamp() {
        return getTimestamp(this.nativePtr) * 1000;
    }

    @Override // org.linphone.core.LinphoneCallLog
    public boolean wasConference() {
        return wasConference(this.nativePtr);
    }
}
