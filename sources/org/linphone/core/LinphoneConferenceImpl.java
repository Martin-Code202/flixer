package org.linphone.core;
public class LinphoneConferenceImpl implements LinphoneConference {
    private final long nativePtr;

    private native LinphoneAddress[] getParticipants(long j);

    private native int removeParticipant(long j, LinphoneAddress linphoneAddress);

    private LinphoneConferenceImpl(long j) {
        this.nativePtr = j;
    }

    @Override // org.linphone.core.LinphoneConference
    public LinphoneAddress[] getParticipants() {
        return getParticipants(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneConference
    public int removeParticipant(LinphoneAddress linphoneAddress) {
        return removeParticipant(this.nativePtr, linphoneAddress);
    }
}
