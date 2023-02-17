package org.linphone.core;

import org.linphone.core.LinphoneCallStats;
class LinphoneCallStatsImpl implements LinphoneCallStats {
    private long bytesReceived;
    private long bytesSent;
    private long cumulativePacketsLost;
    private float downloadBandwidth;
    private float estimatedDownloadBandwidth;
    private int iceState;
    private float jitterBufferSize;
    private long latePacketsCumulativeNumber;
    private float localLateRate;
    private float localLossRate;
    private int mediaType;
    private long nativePtr;
    private long packetsReceived;
    private long packetsSent;
    private float receiverInterarrivalJitter;
    private float receiverLossRate;
    private float roundTripDelay;
    private float senderInterarrivalJitter;
    private float senderLossRate;
    private float uploadBandwidth;

    private native long getCumulativePacketsLost(long j);

    private native float getDownloadBandwidth(long j);

    private native float getEstimatedDownloadBandwidth(long j);

    private native int getIceState(long j);

    private native int getIpFamilyOfRemote(long j);

    private native float getJitterBufferSize(long j);

    private native long getLatePacketsCumulativeNumber(long j);

    private native float getLocalLateRate(long j);

    private native float getLocalLossRate(long j);

    private native int getMediaType(long j);

    private native long getNumberBytesReceived(long j);

    private native long getNumberBytesSent(long j);

    private native long getNumberPacketsReceived(long j);

    private native long getNumberPacketsSent(long j);

    private native float getReceiverInterarrivalJitter(long j);

    private native float getReceiverLossRate(long j);

    private native float getRoundTripDelay(long j);

    private native float getSenderInterarrivalJitter(long j);

    private native float getSenderLossRate(long j);

    private native float getUploadBandwidth(long j);

    private native void updateStats(long j, int i);

    protected LinphoneCallStatsImpl(long j) {
        this.nativePtr = j;
        this.mediaType = getMediaType(j);
        this.iceState = getIceState(j);
        this.downloadBandwidth = getDownloadBandwidth(j);
        this.uploadBandwidth = getUploadBandwidth(j);
        this.estimatedDownloadBandwidth = getEstimatedDownloadBandwidth(j);
        this.packetsSent = getNumberPacketsSent(j);
        this.packetsReceived = getNumberPacketsReceived(j);
        this.bytesSent = getNumberBytesSent(j);
        this.bytesReceived = getNumberBytesReceived(j);
        this.senderLossRate = getSenderLossRate(j);
        this.receiverLossRate = getReceiverLossRate(j);
        this.cumulativePacketsLost = getCumulativePacketsLost(j);
        this.senderInterarrivalJitter = getSenderInterarrivalJitter(j);
        this.receiverInterarrivalJitter = getReceiverInterarrivalJitter(j);
        this.roundTripDelay = getRoundTripDelay(j);
        this.latePacketsCumulativeNumber = getLatePacketsCumulativeNumber(j);
        this.jitterBufferSize = getJitterBufferSize(j);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public LinphoneCallStats.MediaType getMediaType() {
        return LinphoneCallStats.MediaType.fromInt(this.mediaType);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public LinphoneCallStats.IceState getIceState() {
        return LinphoneCallStats.IceState.fromInt(this.iceState);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getDownloadBandwidth() {
        return this.downloadBandwidth;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getUploadBandwidth() {
        return this.uploadBandwidth;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getEstimatedDownloadBandwidth() {
        return this.estimatedDownloadBandwidth;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getSenderLossRate() {
        return this.senderLossRate;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getReceiverLossRate() {
        return this.receiverLossRate;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getSenderInterarrivalJitter() {
        return this.senderInterarrivalJitter;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getReceiverInterarrivalJitter() {
        return this.receiverInterarrivalJitter;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getRoundTripDelay() {
        return this.roundTripDelay;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public long getLatePacketsCumulativeNumber() {
        return this.latePacketsCumulativeNumber;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getJitterBufferSize() {
        return this.jitterBufferSize;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getLocalLossRate() {
        return this.localLossRate;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public float getLocalLateRate() {
        return this.localLateRate;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public long getCumulativePacketsLost() {
        return this.cumulativePacketsLost;
    }

    @Override // org.linphone.core.LinphoneCallStats
    public int getIpFamilyOfRemote() {
        return getIpFamilyOfRemote(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public long getNumberPacketsSent() {
        return getNumberPacketsSent(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public long getNumberPacketsReceived() {
        return getNumberPacketsReceived(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public long getNumberBytesSent() {
        return getNumberBytesSent(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCallStats
    public long getNumberBytesReceived() {
        return getNumberBytesReceived(this.nativePtr);
    }
}
