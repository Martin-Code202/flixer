package org.linphone.core;

import android.content.Context;
import android.media.AudioManager;
import java.io.File;
import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCore;
import org.linphone.mediastream.Factory;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.video.AndroidVideoWindowImpl;
import org.linphone.mediastream.video.capture.hwconf.Hacks;
class LinphoneCoreImpl implements LinphoneCore {
    static int FIND_PAYLOAD_IGNORE_CHANNELS = -1;
    static int FIND_PAYLOAD_IGNORE_RATE = -1;
    private AudioManager mAudioManager = null;
    private Context mContext = null;
    private final LinphoneCoreListener mListener;
    private boolean mSpeakerEnabled = false;
    protected long nativePtr = 0;
    private boolean openh264DownloadEnabled = false;

    private native void acceptCall(long j, long j2);

    private native void acceptCallUpdate(long j, long j2, long j3);

    private native void acceptCallWithParams(long j, long j2, long j3);

    private native boolean acceptEarlyMedia(long j, long j2);

    private native boolean acceptEarlyMediaWithParams(long j, long j2, long j3);

    private native void addAllToConference(long j);

    private native void addAuthInfo(long j, long j2);

    private native void addFriend(long j, long j2);

    private native void addFriendList(long j, long j2);

    private native void addListener(long j, LinphoneCoreListener linphoneCoreListener);

    private native int addProxyConfig(LinphoneProxyConfig linphoneProxyConfig, long j, long j2);

    private native void addToConference(long j, long j2);

    private native boolean audioMulticastEnabled(long j);

    private native boolean chatEnabled(long j);

    private native void clearAuthInfos(long j);

    private native void clearCallLogs(long j);

    private native void clearProxyConfigs(long j);

    private native long createCallParams(long j, long j2);

    private native LinphoneConference createConference(long j, LinphoneConferenceParams linphoneConferenceParams);

    private native Object createFriend(long j);

    private native Object createFriendWithAddress(long j, String str);

    private native long createInfoMessage(long j);

    private native long createLocalPlayer(long j, AndroidVideoWindowImpl androidVideoWindowImpl);

    private native Object createNatPolicy(long j);

    private native Object createPublish(long j, long j2, String str, int i);

    private native Object createSubscribe(long j, long j2, String str, int i);

    private native void declineCall(long j, long j2, int i);

    private native void deferCallUpdate(long j, long j2);

    private native void delete(long j);

    private native void disableChat(long j, int i);

    private native boolean dnsSrvEnabled(long j);

    private native void enableAdaptiveRateControl(long j, boolean z);

    private native void enableAudioMulticast(long j, boolean z);

    private native void enableChat(long j);

    private native void enableDnsSrv(long j, boolean z);

    private native void enableEchoCancellation(long j, boolean z);

    private native void enableEchoLimiter(long j, boolean z);

    private native void enableIpv6(long j, boolean z);

    private native void enableKeepAlive(long j, boolean z);

    private native int enablePayloadType(long j, long j2, boolean z);

    private native void enableSdp200Ack(long j, boolean z);

    private native void enableVideo(long j, boolean z, boolean z2);

    private native void enableVideoMulticast(long j, boolean z);

    private native boolean enterConference(long j);

    private native long findAuthInfos(long j, String str, String str2, String str3);

    private native Object findCallFromUri(long j, String str);

    private native long findPayloadType(long j, String str, int i, int i2);

    private native void forceSpeakerState(long j, boolean z);

    private native String getAdaptiveRateAlgorithm(long j);

    private native int getAudioDscp(long j);

    private native String getAudioMulticastAddr(long j);

    private native int getAudioMulticastTtl(long j);

    private native long[] getAuthInfosList(long j);

    private native Object getCall(long j, int i);

    private native long getCallLog(long j, int i);

    private native long[] getCallLogs(long j);

    private native int getCallsNb(long j);

    private native Object getChatRoom(long j, long j2);

    private native Object[] getChatRooms(long j);

    private native LinphoneConference getConference(long j);

    private native int getConferenceSize(long j);

    private native long getConfig(long j);

    private native Object getCurrentCall(long j);

    private native LinphoneProxyConfig getDefaultProxyConfig(long j);

    private native int getDownloadBandwidth(long j);

    private native String getFileTransferServer(long j);

    private native int getFirewallPolicy(long j);

    private native LinphoneFriend getFriendByAddress(long j, String str);

    private native LinphoneFriend[] getFriendList(long j);

    private native LinphoneFriendList[] getFriendLists(long j);

    private native int getGlobalState(long j);

    private native String getHttpProxyHost(long j);

    private native int getHttpProxyPort(long j);

    private native int getInCallTimeout(long j);

    private native int getIncomingTimeout(long j);

    private native long getLastOutgoingCallLog(long j);

    private native int getLimeEncryption(long j);

    private native Object getMSFactory(long j);

    private native int getMaxCalls(long j);

    private native int getMediaEncryption(long j);

    private native int getMissedCallsCount(long j);

    private native int getMtu(long j);

    private native Object getNatPolicy(long j);

    private native int getNortpTimeout(long j);

    private native int getNumberOfCallLogs(long j);

    private native Object getOrCreateChatRoom(long j, String str);

    private native int getPayloadTypeBitrate(long j, long j2);

    private native int getPayloadTypeNumber(long j, long j2);

    private native float getPlaybackGain(long j);

    private native float getPreferredFramerate(long j);

    private native int[] getPreferredVideoSize(long j);

    private native int getPresenceInfo(long j);

    private native Object getPresenceModel(long j);

    private native String getPrimaryContact(long j);

    private native String getPrimaryContactDisplayName(long j);

    private native String getPrimaryContactUsername(long j);

    private native String getProvisioningUri(long j);

    private native LinphoneProxyConfig[] getProxyConfigList(long j);

    private native long getRemoteAddress(long j);

    private native String getRemoteRingbackTone(long j);

    private native String getRing(long j);

    private native int getSignalingTransportPort(long j, int i);

    private native int getSipDscp(long j);

    private native int getSipTransportTimeout(long j);

    private native String getStunServer(long j);

    private native String getTlsCertificate(long j);

    private native String getTlsCertificatePath(long j);

    private native String getTlsKey(long j);

    private native String getTlsKeyPath(long j);

    private native int getUploadBandwidth(long j);

    private native String getUpnpExternalIpaddress(long j);

    private native int getUpnpState(long j);

    private native boolean getUseRfc2833ForDtmfs(long j);

    private native boolean getUseSipInfoForDtmfs(long j);

    private native String getVersion(long j);

    private native boolean getVideoAutoAcceptPolicy(long j);

    private native boolean getVideoAutoInitiatePolicy(long j);

    private native int getVideoDevice(long j);

    private native int getVideoDscp(long j);

    private native String getVideoMulticastAddr(long j);

    private native int getVideoMulticastTtl(long j);

    private native String getVideoPreset(long j);

    private native boolean hasBuiltInEchoCanceler(long j);

    private native boolean hasCrappyOpenGL(long j);

    private native long interpretUrl(long j, String str);

    private native Object invite(long j, String str);

    private native Object inviteAddress(long j, long j2);

    private native Object inviteAddressWithParams(long j, long j2, long j3);

    private native boolean isAdaptiveRateControlEnabled(long j);

    private native boolean isEchoCancellationEnabled(long j);

    private native boolean isEchoLimiterEnabled(long j);

    private native boolean isInCall(long j);

    private native boolean isInComingInvitePending(long j);

    private native boolean isInConference(long j);

    private native boolean isIpv6Enabled(long j);

    private native boolean isKeepAliveEnabled(long j);

    private native boolean isLimeEncryptionAvailable(long j);

    private native boolean isMediaEncryptionMandatory(long j);

    private native boolean isMicMuted(long j);

    private native boolean isNetworkStateReachable(long j);

    private native boolean isPayloadTypeEnabled(long j, long j2);

    private native boolean isSdp200AckEnabled(long j);

    private native boolean isVCardSupported(long j);

    private native boolean isVideoEnabled(long j);

    private native boolean isVideoSupported(long j);

    private native void iterate(long j);

    private native void leaveConference(long j);

    private native long[] listAudioPayloadTypes(long j);

    private native String[] listSupportedVideoResolutions(long j);

    private native long[] listVideoPayloadTypes(long j);

    private native boolean mediaEncryptionSupported(long j, int i);

    private native void migrateCallLogs(long j);

    private native int migrateToMultiTransport(long j);

    private native void muteMic(long j, boolean z);

    private native boolean needsEchoCalibration(long j);

    private native long newLinphoneCore(LinphoneCoreListener linphoneCoreListener, String str, String str2, Object obj, Object obj2);

    private native int pauseAllCalls(long j);

    private native int pauseCall(long j, long j2);

    private native boolean payloadTypeIsVbr(long j, long j2);

    private native void playDtmf(long j, char c, int i);

    private native Object publish(long j, long j2, String str, int i, String str2, String str3, byte[] bArr, String str4);

    private native void refreshRegisters(long j);

    private native void reloadMsPlugins(long j, String str);

    private native void reloadSoundDevices(long j);

    private native void removeAuthInfo(long j, long j2);

    private native void removeCallLog(long j, long j2);

    private native void removeFriend(long j, long j2);

    private native void removeFriendList(long j, long j2);

    private native void removeFromConference(long j, long j2);

    private native void removeListener(long j, LinphoneCoreListener linphoneCoreListener);

    private native void removeProxyConfig(long j, long j2);

    private native void resetMissedCallsCount(long j);

    private native int resumeCall(long j, long j2);

    private native void sendDtmf(long j, char c);

    private native int sendDtmfs(long j, String str);

    private native void setAdaptiveRateAlgorithm(long j, String str);

    private native void setAndroidMulticastLock(long j, Object obj);

    private static native void setAndroidPowerManager(Object obj);

    private native void setAndroidWifiLock(long j, Object obj);

    private native void setAudioCodecs(long j, long[] jArr);

    private native void setAudioDscp(long j, int i);

    private native void setAudioJittcomp(long j, int i);

    private native int setAudioMulticastAddr(long j, String str);

    private native int setAudioMulticastTtl(long j, int i);

    private native void setAudioPort(long j, int i);

    private native void setAudioPortRange(long j, int i, int i2);

    private native void setCallErrorTone(long j, int i, String str);

    private native void setCallLogsDatabasePath(long j, String str);

    private native void setChatDatabasePath(long j, String str);

    private native void setCpuCountNative(long j, int i);

    private native void setDefaultProxyConfig(long j, long j2);

    private native void setDefaultSoundDevices(long j);

    private native void setDeviceRotation(long j, int i);

    private native void setDnsServers(long j, String[] strArr);

    private native void setDownloadBandwidth(long j, int i);

    private native void setDownloadPtime(long j, int i);

    private native void setFileTransferServer(long j, String str);

    private native void setFirewallPolicy(long j, int i);

    private native void setFriendsDatabasePath(long j, String str);

    private native void setHttpProxyHost(long j, String str);

    private native void setHttpProxyPort(long j, int i);

    private native void setInCallTimeout(long j, int i);

    private native void setIncomingTimeout(long j, int i);

    private native void setLimeEncryption(long j, int i);

    private native void setMaxCalls(long j, int i);

    private native void setMediaEncryption(long j, int i);

    private native void setMediaEncryptionMandatory(long j, boolean z);

    private native void setMediaNetworkReachable(long j, boolean z);

    private native void setMicrophoneGain(long j, float f);

    private native void setMtu(long j, int i);

    private native void setNatPolicy(long j, long j2);

    private native void setNetworkStateReachable(long j, boolean z);

    private native void setNortpTimeout(long j, int i);

    private native void setPayloadTypeBitrate(long j, long j2, int i);

    private native void setPayloadTypeNumber(long j, long j2, int i);

    private native void setPlayFile(long j, String str);

    private native void setPlaybackGain(long j, float f);

    private native void setPreferredFramerate(long j, float f);

    private native void setPreferredVideoSize(long j, int i, int i2);

    private native void setPreferredVideoSizeByName(long j, String str);

    private native void setPresenceInfo(long j, int i, String str, int i2);

    private native void setPresenceModel(long j, long j2);

    private native void setPreviewWindowId(long j, Object obj);

    private native void setPrimaryContact(long j, String str, String str2);

    private native void setPrimaryContact2(long j, String str);

    private native void setProvisioningUri(long j, String str);

    private native void setRemoteRingbackTone(long j, String str);

    private native void setRing(long j, String str);

    private native void setRingback(long j, String str);

    private native void setRootCA(long j, String str);

    private native void setRootCAData(long j, String str);

    private native void setSignalingTransportPorts(long j, int i, int i2, int i3);

    private native void setSipDscp(long j, int i);

    private native void setSipNetworkReachable(long j, boolean z);

    private native void setSipTransportTimeout(long j, int i);

    private native void setStaticPicture(long j, String str);

    private native void setStunServer(long j, String str);

    private native void setTlsCertificate(long j, String str);

    private native void setTlsCertificatePath(long j, String str);

    private native void setTlsKey(long j, String str);

    private native void setTlsKeyPath(long j, String str);

    private native void setTone(long j, int i, String str);

    private native void setUploadBandwidth(long j, int i);

    private native void setUploadPtime(long j, int i);

    private native void setUseRfc2833ForDtmfs(long j, boolean z);

    private native void setUseSipInfoForDtmfs(long j, boolean z);

    private native void setUserAgent(long j, String str, String str2);

    private native void setUserCertificatesPath(long j, String str);

    private native void setVerifyServerCN(long j, boolean z);

    private native void setVerifyServerCertificates(long j, boolean z);

    private native void setVideoCodecs(long j, long[] jArr);

    private native int setVideoDevice(long j, int i);

    private native void setVideoDscp(long j, int i);

    private native void setVideoJittcomp(long j, int i);

    private native int setVideoMulticastAddr(long j, String str);

    private native int setVideoMulticastTtl(long j, int i);

    private native void setVideoPolicy(long j, boolean z, boolean z2);

    private native void setVideoPort(long j, int i);

    private native void setVideoPortRange(long j, int i, int i2);

    private native void setVideoPreset(long j, String str);

    private native void setVideoWindowId(long j, Object obj);

    private native void setZrtpSecretsCache(long j, String str);

    private native boolean soundResourcesLocked(long j);

    private native int startConferenceRecording(long j, String str);

    private native int startEchoCalibration(long j, Object obj);

    private native int startEchoTester(long j, int i);

    private native LinphoneCall startReferedCall(long j, long j2, long j3);

    private native int stopConferenceRecording(long j);

    private native void stopDtmf(long j);

    private native int stopEchoTester(long j);

    private native void stopRinging(long j);

    private native Object subscribe(long j, long j2, String str, int i, String str2, String str3, byte[] bArr, String str4);

    private native void terminateAllCalls(long j);

    private native void terminateCall(long j, long j2);

    private native void terminateConference(long j);

    private native int transferCall(long j, long j2, String str);

    private native int transferCallToAnother(long j, long j2, long j3);

    private native void tunnelAddServer(long j, long j2);

    private native void tunnelAddServerAndMirror(long j, String str, int i, int i2, int i3);

    private native void tunnelAutoDetect(long j);

    private native void tunnelCleanServers(long j);

    private native boolean tunnelDualModeEnabled(long j);

    private native void tunnelEnable(long j, boolean z);

    private native void tunnelEnableDualMode(long j, boolean z);

    private native void tunnelEnableSip(long j, boolean z);

    private native int tunnelGetMode(long j);

    private final native TunnelConfig[] tunnelGetServers(long j);

    private native void tunnelSetHttpProxy(long j, String str, int i, String str2, String str3);

    private native void tunnelSetMode(long j, int i);

    private native boolean tunnelSipEnabled(long j);

    private native int updateCall(long j, long j2, long j3);

    private native void uploadLogCollection(long j);

    private native boolean upnpAvailable(long j);

    private native boolean videoMulticastEnabled(long j);

    @Override // org.linphone.core.LinphoneCore
    public native boolean isTunnelAvailable();

    @Override // org.linphone.core.LinphoneCore
    public native void resetLogCollection();

    LinphoneCoreImpl(LinphoneCoreListener linphoneCoreListener, File file, File file2, Object obj, Object obj2) {
        this.mListener = linphoneCoreListener;
        this.nativePtr = newLinphoneCore(linphoneCoreListener, file == null ? null : file.getCanonicalPath(), file2 == null ? null : file2.getCanonicalPath(), obj, obj2);
        setContext(obj2);
    }

    LinphoneCoreImpl(LinphoneCoreListener linphoneCoreListener, Object obj) {
        this.mListener = linphoneCoreListener;
        this.nativePtr = newLinphoneCore(linphoneCoreListener, null, null, null, obj);
        setContext(obj);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.nativePtr != 0) {
            destroy();
        }
    }

    private boolean contextInitialized() {
        if (this.mContext != null) {
            return true;
        }
        Log.e("Context of LinphoneCore has not been initialized, call setContext() after creating LinphoneCore.");
        return false;
    }

    @Override // org.linphone.core.LinphoneCore
    public void setContext(Object obj) {
        this.mContext = (Context) obj;
        reloadMsPlugins(this.mContext.getApplicationInfo().nativeLibraryDir);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addAuthInfo(LinphoneAuthInfo linphoneAuthInfo) {
        isValid();
        addAuthInfo(this.nativePtr, ((LinphoneAuthInfoImpl) linphoneAuthInfo).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeAuthInfo(LinphoneAuthInfo linphoneAuthInfo) {
        isValid();
        removeAuthInfo(this.nativePtr, ((LinphoneAuthInfoImpl) linphoneAuthInfo).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneProxyConfig getDefaultProxyConfig() {
        isValid();
        return getDefaultProxyConfig(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall invite(String str) {
        isValid();
        return (LinphoneCall) invite(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void iterate() {
        try {
            isValid();
            iterate(this.nativePtr);
        } catch (RuntimeException e) {
            Log.e("Caught runtime exception:", e);
        }
        return;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setDefaultProxyConfig(LinphoneProxyConfig linphoneProxyConfig) {
        isValid();
        setDefaultProxyConfig(this.nativePtr, linphoneProxyConfig != null ? ((LinphoneProxyConfigImpl) linphoneProxyConfig).nativePtr : 0);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addProxyConfig(LinphoneProxyConfig linphoneProxyConfig) {
        isValid();
        if (addProxyConfig(linphoneProxyConfig, this.nativePtr, ((LinphoneProxyConfigImpl) linphoneProxyConfig).nativePtr) != 0) {
            throw new LinphoneCoreException("bad proxy config");
        }
        ((LinphoneProxyConfigImpl) linphoneProxyConfig).mCore = this;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeProxyConfig(LinphoneProxyConfig linphoneProxyConfig) {
        isValid();
        if (linphoneProxyConfig != null) {
            removeProxyConfig(this.nativePtr, ((LinphoneProxyConfigImpl) linphoneProxyConfig).nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void clearAuthInfos() {
        isValid();
        clearAuthInfos(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void clearProxyConfigs() {
        isValid();
        clearProxyConfigs(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void terminateCall(LinphoneCall linphoneCall) {
        isValid();
        if (linphoneCall != null) {
            terminateCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneAddress getRemoteAddress() {
        isValid();
        long remoteAddress = getRemoteAddress(this.nativePtr);
        if (remoteAddress == 0) {
            return null;
        }
        return new LinphoneAddressImpl(remoteAddress, LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isIncall() {
        isValid();
        return isInCall(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isInComingInvitePending() {
        isValid();
        return isInComingInvitePending(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void acceptCall(LinphoneCall linphoneCall) {
        isValid();
        acceptCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCallLog[] getCallLogs() {
        long[] callLogs = getCallLogs(this.nativePtr);
        if (callLogs == null) {
            return null;
        }
        isValid();
        LinphoneCallLog[] linphoneCallLogArr = new LinphoneCallLog[callLogs.length];
        for (int i = 0; i < linphoneCallLogArr.length; i++) {
            linphoneCallLogArr[i] = new LinphoneCallLogImpl(callLogs[i]);
        }
        return linphoneCallLogArr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCallLog getLastOutgoingCallLog() {
        isValid();
        return new LinphoneCallLogImpl(getLastOutgoingCallLog(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void destroy() {
        delete(this.nativePtr);
        setAndroidPowerManager(null);
        this.nativePtr = 0;
    }

    private void isValid() {
        if (this.nativePtr == 0) {
            throw new RuntimeException("object already destroyed");
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setNetworkReachable(boolean z) {
        setNetworkStateReachable(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPlaybackGain(float f) {
        setPlaybackGain(this.nativePtr, f);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized float getPlaybackGain() {
        return getPlaybackGain(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void muteMic(boolean z) {
        muteMic(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneAddress interpretUrl(String str) {
        long interpretUrl;
        interpretUrl = interpretUrl(this.nativePtr, str);
        if (interpretUrl != 0) {
        } else {
            throw new LinphoneCoreException("Cannot interpret [" + str + "]");
        }
        return new LinphoneAddressImpl(interpretUrl, LinphoneAddressImpl.WrapMode.FromNew);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall invite(LinphoneAddress linphoneAddress) {
        LinphoneCall linphoneCall;
        linphoneCall = (LinphoneCall) inviteAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
        if (linphoneCall == null) {
            throw new LinphoneCoreException("Unable to invite address " + linphoneAddress.asString());
        }
        return linphoneCall;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void sendDtmfs(String str) {
        sendDtmfs(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void sendDtmf(char c) {
        sendDtmf(this.nativePtr, c);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void clearCallLogs() {
        clearCallLogs(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isMicMuted() {
        return isMicMuted(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized PayloadType findPayloadType(String str, int i, int i2) {
        isValid();
        long findPayloadType = findPayloadType(this.nativePtr, str, i, i2);
        if (findPayloadType == 0) {
            return null;
        }
        return new PayloadTypeImpl(findPayloadType);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enablePayloadType(PayloadType payloadType, boolean z) {
        isValid();
        if (enablePayloadType(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr, z) != 0) {
            throw new LinphoneCoreException("cannot enable payload type [" + payloadType + "]");
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isPayloadTypeEnabled(PayloadType payloadType) {
        isValid();
        return isPayloadTypeEnabled(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean payloadTypeIsVbr(PayloadType payloadType) {
        isValid();
        return payloadTypeIsVbr(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableEchoCancellation(boolean z) {
        isValid();
        enableEchoCancellation(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isEchoCancellationEnabled() {
        isValid();
        return isEchoCancellationEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall getCurrentCall() {
        isValid();
        return (LinphoneCall) getCurrentCall(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public int getPlayLevel() {
        return 0;
    }

    @Override // org.linphone.core.LinphoneCore
    public void setPlayLevel(int i) {
    }

    private void applyAudioHacks() {
        if (Hacks.needGalaxySAudioHack()) {
            setMicrophoneGain(-9.0f);
        }
    }

    private void setAudioModeIncallForGalaxyS() {
        if (contextInitialized()) {
            this.mAudioManager.setMode(2);
        }
    }

    public void routeAudioToSpeakerHelper(boolean z) {
        if (contextInitialized()) {
            if (Hacks.needGalaxySAudioHack()) {
                setAudioModeIncallForGalaxyS();
            }
            this.mAudioManager.setSpeakerphoneOn(z);
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public void enableSpeaker(boolean z) {
        LinphoneCall currentCall = getCurrentCall();
        this.mSpeakerEnabled = z;
        applyAudioHacks();
        if (currentCall == null || currentCall.getState() != LinphoneCall.State.StreamsRunning || !Hacks.needGalaxySAudioHack()) {
            routeAudioToSpeakerHelper(z);
            return;
        }
        Log.d("Hack to have speaker=", Boolean.valueOf(z), " while on call");
        forceSpeakerState(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean isSpeakerEnabled() {
        return this.mSpeakerEnabled;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void playDtmf(char c, int i) {
        playDtmf(this.nativePtr, c, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void stopDtmf() {
        stopDtmf(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addFriend(LinphoneFriend linphoneFriend) {
        addFriend(this.nativePtr, ((LinphoneFriendImpl) linphoneFriend).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneFriendList createLinphoneFriendList() {
        return new LinphoneFriendListImpl(this);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addFriendList(LinphoneFriendList linphoneFriendList) {
        addFriendList(this.nativePtr, ((LinphoneFriendListImpl) linphoneFriendList).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeFriendList(LinphoneFriendList linphoneFriendList) {
        removeFriendList(this.nativePtr, ((LinphoneFriendListImpl) linphoneFriendList).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneFriend[] getFriendList() {
        return getFriendList(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneFriendList[] getFriendLists() {
        return getFriendLists(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPresenceInfo(int i, String str, OnlineStatus onlineStatus) {
        setPresenceInfo(this.nativePtr, i, str, onlineStatus.mValue);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized OnlineStatus getPresenceInfo() {
        return OnlineStatus.fromInt(getPresenceInfo(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPresenceModel(PresenceModel presenceModel) {
        setPresenceModel(this.nativePtr, ((PresenceModelImpl) presenceModel).getNativePtr());
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized PresenceModel getPresenceModel() {
        return (PresenceModel) getPresenceModel(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneChatRoom getOrCreateChatRoom(String str) {
        return (LinphoneChatRoom) getOrCreateChatRoom(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneChatRoom getChatRoom(LinphoneAddress linphoneAddress) {
        return (LinphoneChatRoom) getChatRoom(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPreviewWindow(Object obj) {
        setPreviewWindowId(this.nativePtr, obj);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoWindow(Object obj) {
        setVideoWindowId(this.nativePtr, obj);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setDeviceRotation(int i) {
        setDeviceRotation(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableVideo(boolean z, boolean z2) {
        enableVideo(this.nativePtr, z, z2);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isVideoEnabled() {
        return isVideoEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isVideoSupported() {
        return isVideoSupported(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isVCardSupported() {
        return isVCardSupported(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.FirewallPolicy getFirewallPolicy() {
        return LinphoneCore.FirewallPolicy.fromInt(getFirewallPolicy(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setFirewallPolicy(LinphoneCore.FirewallPolicy firewallPolicy) {
        setFirewallPolicy(this.nativePtr, firewallPolicy.value());
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneNatPolicy createNatPolicy() {
        return (LinphoneNatPolicy) createNatPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setNatPolicy(LinphoneNatPolicy linphoneNatPolicy) {
        setNatPolicy(this.nativePtr, ((LinphoneNatPolicyImpl) linphoneNatPolicy).mNativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneNatPolicy getNatPolicy() {
        return (LinphoneNatPolicy) getNatPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getStunServer() {
        return getStunServer(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setStunServer(String str) {
        setStunServer(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall inviteAddressWithParams(LinphoneAddress linphoneAddress, LinphoneCallParams linphoneCallParams) {
        LinphoneCall linphoneCall;
        linphoneCall = (LinphoneCall) inviteAddressWithParams(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr);
        if (linphoneCall == null) {
            throw new LinphoneCoreException("Unable to invite with params " + linphoneAddress.asString());
        }
        return linphoneCall;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int updateCall(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        return updateCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr, linphoneCallParams != null ? ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr : 0);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getUploadBandwidth() {
        return getUploadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setUploadBandwidth(int i) {
        setUploadBandwidth(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getDownloadBandwidth() {
        return getDownloadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setDownloadBandwidth(int i) {
        setDownloadBandwidth(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPreferredVideoSize(VideoSize videoSize) {
        setPreferredVideoSize(this.nativePtr, videoSize.width, videoSize.height);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPreferredVideoSizeByName(String str) {
        setPreferredVideoSizeByName(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized VideoSize getPreferredVideoSize() {
        VideoSize videoSize;
        int[] preferredVideoSize = getPreferredVideoSize(this.nativePtr);
        videoSize = new VideoSize();
        videoSize.width = preferredVideoSize[0];
        videoSize.height = preferredVideoSize[1];
        return videoSize;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setRing(String str) {
        setRing(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getRing() {
        return getRing(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setRootCA(String str) {
        setRootCA(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setRootCAData(String str) {
        setRootCAData(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setRingback(String str) {
        setRingback(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneProxyConfig[] getProxyConfigList() {
        return getProxyConfigList(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized PayloadType[] getVideoCodecs() {
        long[] listVideoPayloadTypes = listVideoPayloadTypes(this.nativePtr);
        if (listVideoPayloadTypes == null) {
            return null;
        }
        PayloadType[] payloadTypeArr = new PayloadType[listVideoPayloadTypes.length];
        for (int i = 0; i < payloadTypeArr.length; i++) {
            payloadTypeArr[i] = new PayloadTypeImpl(listVideoPayloadTypes[i]);
        }
        return payloadTypeArr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoCodecs(PayloadType[] payloadTypeArr) {
        long[] jArr = new long[payloadTypeArr.length];
        for (int i = 0; i < payloadTypeArr.length; i++) {
            jArr[i] = ((PayloadTypeImpl) payloadTypeArr[i]).nativePtr;
        }
        setVideoCodecs(this.nativePtr, jArr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized PayloadType[] getAudioCodecs() {
        long[] listAudioPayloadTypes = listAudioPayloadTypes(this.nativePtr);
        if (listAudioPayloadTypes == null) {
            return null;
        }
        PayloadType[] payloadTypeArr = new PayloadType[listAudioPayloadTypes.length];
        for (int i = 0; i < payloadTypeArr.length; i++) {
            payloadTypeArr[i] = new PayloadTypeImpl(listAudioPayloadTypes[i]);
        }
        return payloadTypeArr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setAudioCodecs(PayloadType[] payloadTypeArr) {
        long[] jArr = new long[payloadTypeArr.length];
        for (int i = 0; i < payloadTypeArr.length; i++) {
            jArr[i] = ((PayloadTypeImpl) payloadTypeArr[i]).nativePtr;
        }
        setAudioCodecs(this.nativePtr, jArr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isNetworkReachable() {
        return isNetworkStateReachable(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableKeepAlive(boolean z) {
        enableKeepAlive(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isKeepAliveEnabled() {
        return isKeepAliveEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void startEchoCalibration(LinphoneCoreListener linphoneCoreListener) {
        startEchoCalibration(this.nativePtr, linphoneCoreListener);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int startEchoTester(int i) {
        return startEchoTester(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int stopEchoTester() {
        return stopEchoTester(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.Transports getSignalingTransportPorts() {
        LinphoneCore.Transports transports;
        transports = new LinphoneCore.Transports();
        transports.udp = getSignalingTransportPort(this.nativePtr, 0);
        transports.tcp = getSignalingTransportPort(this.nativePtr, 1);
        transports.tls = getSignalingTransportPort(this.nativePtr, 3);
        return transports;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setSignalingTransportPorts(LinphoneCore.Transports transports) {
        setSignalingTransportPorts(this.nativePtr, transports.udp, transports.tcp, transports.tls);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableIpv6(boolean z) {
        enableIpv6(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isIpv6Enabled() {
        return isIpv6Enabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void adjustSoftwareVolume(int i) {
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean pauseCall(LinphoneCall linphoneCall) {
        return 0 == pauseCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean resumeCall(LinphoneCall linphoneCall) {
        return 0 == resumeCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean pauseAllCalls() {
        return 0 == pauseAllCalls(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setDownloadPtime(int i) {
        setDownloadPtime(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setUploadPtime(int i) {
        setUploadPtime(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setZrtpSecretsCache(String str) {
        setZrtpSecretsCache(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableEchoLimiter(boolean z) {
        enableEchoLimiter(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoDevice(int i) {
        Log.i("Setting camera id :", Integer.valueOf(i));
        if (setVideoDevice(this.nativePtr, i) != 0) {
            Log.e("Failed to set video device to id:", Integer.valueOf(i));
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getVideoDevice() {
        return getVideoDevice(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void leaveConference() {
        leaveConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean enterConference() {
        return enterConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isInConference() {
        return isInConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void terminateConference() {
        terminateConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getConferenceSize() {
        return getConferenceSize(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneConference createConference(LinphoneConferenceParams linphoneConferenceParams) {
        return createConference(this.nativePtr, linphoneConferenceParams);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneConference getConference() {
        return getConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getCallsNb() {
        return getCallsNb(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void terminateAllCalls() {
        terminateAllCalls(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall[] getCalls() {
        LinphoneCall[] linphoneCallArr;
        int callsNb = getCallsNb(this.nativePtr);
        linphoneCallArr = new LinphoneCall[callsNb];
        for (int i = 0; i < callsNb; i++) {
            linphoneCallArr[i] = (LinphoneCall) getCall(this.nativePtr, i);
        }
        return linphoneCallArr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addAllToConference() {
        addAllToConference(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addToConference(LinphoneCall linphoneCall) {
        addToConference(this.nativePtr, getCallPtr(linphoneCall));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeFromConference(LinphoneCall linphoneCall) {
        removeFromConference(this.nativePtr, getCallPtr(linphoneCall));
    }

    private long getCallPtr(LinphoneCall linphoneCall) {
        return ((LinphoneCallImpl) linphoneCall).nativePtr;
    }

    private long getCallParamsPtr(LinphoneCallParams linphoneCallParams) {
        return ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void transferCall(LinphoneCall linphoneCall, String str) {
        transferCall(this.nativePtr, getCallPtr(linphoneCall), str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void transferCallToAnother(LinphoneCall linphoneCall, LinphoneCall linphoneCall2) {
        transferCallToAnother(this.nativePtr, getCallPtr(linphoneCall), getCallPtr(linphoneCall2));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall findCallFromUri(String str) {
        return (LinphoneCall) findCallFromUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.MediaEncryption getMediaEncryption() {
        return LinphoneCore.MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isMediaEncryptionMandatory() {
        return isMediaEncryptionMandatory(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setMediaEncryption(LinphoneCore.MediaEncryption mediaEncryption) {
        setMediaEncryption(this.nativePtr, mediaEncryption.mValue);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setMediaEncryptionMandatory(boolean z) {
        setMediaEncryptionMandatory(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getMaxCalls() {
        return getMaxCalls(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean isMyself(String str) {
        LinphoneProxyConfig defaultProxyConfig = getDefaultProxyConfig();
        if (defaultProxyConfig == null) {
            return false;
        }
        return str.equals(defaultProxyConfig.getIdentity());
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean soundResourcesLocked() {
        return soundResourcesLocked(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setMaxCalls(int i) {
        setMaxCalls(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isEchoLimiterEnabled() {
        return isEchoLimiterEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean mediaEncryptionSupported(LinphoneCore.MediaEncryption mediaEncryption) {
        return mediaEncryptionSupported(this.nativePtr, mediaEncryption.mValue);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPlayFile(String str) {
        setPlayFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelAddServerAndMirror(String str, int i, int i2, int i3) {
        tunnelAddServerAndMirror(this.nativePtr, str, i, i2, i3);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelAddServer(TunnelConfig tunnelConfig) {
        tunnelAddServer(this.nativePtr, ((TunnelConfigImpl) tunnelConfig).mNativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public final synchronized TunnelConfig[] tunnelGetServers() {
        return tunnelGetServers(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelAutoDetect() {
        tunnelAutoDetect(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelCleanServers() {
        tunnelCleanServers(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelEnable(boolean z) {
        tunnelEnable(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelSetMode(LinphoneCore.TunnelMode tunnelMode) {
        tunnelSetMode(this.nativePtr, LinphoneCore.TunnelMode.enumToInt(tunnelMode));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.TunnelMode tunnelGetMode() {
        return LinphoneCore.TunnelMode.intToEnum(tunnelGetMode(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public void tunnelEnableSip(boolean z) {
        tunnelEnableSip(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean tunnelSipEnabled() {
        return tunnelSipEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void tunnelEnableDualMode(boolean z) {
        tunnelEnableDualMode(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean tunnelDualModeEnabled() {
        return tunnelDualModeEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void acceptCallWithParams(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        acceptCallWithParams(this.nativePtr, getCallPtr(linphoneCall), getCallParamsPtr(linphoneCallParams));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void acceptCallUpdate(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        acceptCallUpdate(this.nativePtr, getCallPtr(linphoneCall), getCallParamsPtr(linphoneCallParams));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void deferCallUpdate(LinphoneCall linphoneCall) {
        deferCallUpdate(this.nativePtr, getCallPtr(linphoneCall));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoPolicy(boolean z, boolean z2) {
        setVideoPolicy(this.nativePtr, z, z2);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean getVideoAutoInitiatePolicy() {
        return getVideoAutoInitiatePolicy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean getVideoAutoAcceptPolicy() {
        return getVideoAutoAcceptPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setStaticPicture(String str) {
        setStaticPicture(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setUserAgent(String str, String str2) {
        setUserAgent(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setCpuCount(int i) {
        setCpuCountNative(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getMissedCallsCount() {
        return getMissedCallsCount(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeCallLog(LinphoneCallLog linphoneCallLog) {
        removeCallLog(this.nativePtr, ((LinphoneCallLogImpl) linphoneCallLog).getNativePtr());
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void resetMissedCallsCount() {
        resetMissedCallsCount(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void tunnelSetHttpProxy(String str, int i, String str2, String str3) {
        tunnelSetHttpProxy(this.nativePtr, str, i, str2, str3);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void refreshRegisters() {
        refreshRegisters(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getVersion() {
        return getVersion(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized PayloadType findPayloadType(String str, int i) {
        return findPayloadType(str, i, FIND_PAYLOAD_IGNORE_CHANNELS);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeFriend(LinphoneFriend linphoneFriend) {
        removeFriend(this.nativePtr, linphoneFriend.getNativePtr());
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneFriend findFriendByAddress(String str) {
        return getFriendByAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setAudioPort(int i) {
        setAudioPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoPort(int i) {
        setVideoPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setAudioPortRange(int i, int i2) {
        setAudioPortRange(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoPortRange(int i, int i2) {
        setVideoPortRange(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setIncomingTimeout(int i) {
        setIncomingTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getIncomingTimeout() {
        return getIncomingTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setInCallTimeout(int i) {
        setInCallTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getInCallTimeout() {
        return getInCallTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setMicrophoneGain(float f) {
        setMicrophoneGain(this.nativePtr, f);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPrimaryContact(String str) {
        setPrimaryContact2(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getPrimaryContact() {
        return getPrimaryContact(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPrimaryContact(String str, String str2) {
        setPrimaryContact(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getPrimaryContactUsername() {
        return getPrimaryContactUsername(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getPrimaryContactDisplayName() {
        return getPrimaryContactDisplayName(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setUseSipInfoForDtmfs(boolean z) {
        setUseSipInfoForDtmfs(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean getUseSipInfoForDtmfs() {
        return getUseSipInfoForDtmfs(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setUseRfc2833ForDtmfs(boolean z) {
        setUseRfc2833ForDtmfs(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean getUseRfc2833ForDtmfs() {
        return getUseRfc2833ForDtmfs(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LpConfig getConfig() {
        return new LpConfigImpl(getConfig(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean needsEchoCalibration() {
        return needsEchoCalibration(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean hasBuiltInEchoCanceler() {
        return hasBuiltInEchoCanceler(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean hasCrappyOpenGL() {
        return hasCrappyOpenGL(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void declineCall(LinphoneCall linphoneCall, Reason reason) {
        declineCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr, reason.mValue);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean upnpAvailable() {
        return upnpAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.UpnpState getUpnpState() {
        return LinphoneCore.UpnpState.fromInt(getUpnpState(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getUpnpExternalIpaddress() {
        return getUpnpExternalIpaddress(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void startConferenceRecording(String str) {
        startConferenceRecording(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void stopConferenceRecording() {
        stopConferenceRecording(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized PayloadType findPayloadType(String str) {
        return findPayloadType(str, FIND_PAYLOAD_IGNORE_RATE);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setSipDscp(int i) {
        setSipDscp(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getSipDscp() {
        return getSipDscp(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setAudioDscp(int i) {
        setAudioDscp(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getAudioDscp() {
        return getAudioDscp(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoDscp(int i) {
        setVideoDscp(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getVideoDscp() {
        return getVideoDscp(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneInfoMessage createInfoMessage() {
        return new LinphoneInfoMessageImpl(createInfoMessage(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneEvent subscribe(LinphoneAddress linphoneAddress, String str, int i, LinphoneContent linphoneContent) {
        return (LinphoneEvent) subscribe(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, str, i, linphoneContent != null ? linphoneContent.getType() : null, linphoneContent != null ? linphoneContent.getSubtype() : null, linphoneContent != null ? linphoneContent.getData() : null, linphoneContent != null ? linphoneContent.getEncoding() : null);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneEvent publish(LinphoneAddress linphoneAddress, String str, int i, LinphoneContent linphoneContent) {
        return (LinphoneEvent) publish(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, str, i, linphoneContent != null ? linphoneContent.getType() : null, linphoneContent != null ? linphoneContent.getSubtype() : null, linphoneContent != null ? linphoneContent.getData() : null, linphoneContent != null ? linphoneContent.getEncoding() : null);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneEvent createSubscribe(LinphoneAddress linphoneAddress, String str, int i) {
        return (LinphoneEvent) createSubscribe(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, str, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneEvent createPublish(LinphoneAddress linphoneAddress, String str, int i) {
        return (LinphoneEvent) createPublish(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, str, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setChatDatabasePath(String str) {
        setChatDatabasePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setCallLogsDatabasePath(String str) {
        setCallLogsDatabasePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setFriendsDatabasePath(String str) {
        setFriendsDatabasePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneChatRoom[] getChatRooms() {
        Object[] chatRooms = getChatRooms(this.nativePtr);
        if (chatRooms == null) {
            return null;
        }
        LinphoneChatRoom[] linphoneChatRoomArr = new LinphoneChatRoom[chatRooms.length];
        for (int i = 0; i < linphoneChatRoomArr.length; i++) {
            linphoneChatRoomArr[i] = (LinphoneChatRoom) chatRooms[i];
        }
        return linphoneChatRoomArr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneAuthInfo[] getAuthInfosList() {
        long[] authInfosList = getAuthInfosList(this.nativePtr);
        if (authInfosList == null) {
            return null;
        }
        LinphoneAuthInfo[] linphoneAuthInfoArr = new LinphoneAuthInfo[authInfosList.length];
        for (int i = 0; i < linphoneAuthInfoArr.length; i++) {
            linphoneAuthInfoArr[i] = new LinphoneAuthInfoImpl(authInfosList[i]);
        }
        return linphoneAuthInfoArr;
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneAuthInfo findAuthInfo(String str, String str2, String str3) {
        long findAuthInfos = findAuthInfos(this.nativePtr, str, str2, str3);
        if (findAuthInfos == 0) {
            return null;
        }
        return new LinphoneAuthInfoImpl(findAuthInfos);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCall startReferedCall(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        return startReferedCall(this.nativePtr, getCallPtr(linphoneCall), ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String[] getSupportedVideoSizes() {
        return listSupportedVideoResolutions(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int migrateToMultiTransport() {
        return migrateToMultiTransport(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void migrateCallLogs() {
        migrateCallLogs(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean acceptEarlyMedia(LinphoneCall linphoneCall) {
        return acceptEarlyMedia(this.nativePtr, getCallPtr(linphoneCall));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean acceptEarlyMediaWithParams(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        return acceptEarlyMediaWithParams(this.nativePtr, getCallPtr(linphoneCall), linphoneCallParams != null ? ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr : 0);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneProxyConfig createProxyConfig() {
        return new LinphoneProxyConfigImpl(this);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneProxyConfig createProxyConfig(String str, String str2, String str3, boolean z) {
        isValid();
        try {
        } catch (LinphoneCoreException e) {
            return null;
        }
        return new LinphoneProxyConfigImpl(this, str, str2, str3, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setCallErrorTone(Reason reason, String str) {
        setCallErrorTone(this.nativePtr, reason.mValue, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setMtu(int i) {
        setMtu(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getMtu() {
        return getMtu(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableSdp200Ack(boolean z) {
        enableSdp200Ack(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isSdp200AckEnabled() {
        return isSdp200AckEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setTone(ToneID toneID, String str) {
        setTone(this.nativePtr, toneID.mValue, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void disableChat(Reason reason) {
        disableChat(this.nativePtr, reason.mValue);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableChat() {
        enableChat(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean chatEnabled() {
        return chatEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void stopRinging() {
        stopRinging(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPayloadTypeBitrate(PayloadType payloadType, int i) {
        setPayloadTypeBitrate(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getPayloadTypeBitrate(PayloadType payloadType) {
        return getPayloadTypeBitrate(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setPayloadTypeNumber(PayloadType payloadType, int i) {
        setPayloadTypeNumber(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized int getPayloadTypeNumber(PayloadType payloadType) {
        return getPayloadTypeNumber(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void enableAdaptiveRateControl(boolean z) {
        enableAdaptiveRateControl(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isAdaptiveRateControlEnabled() {
        return isAdaptiveRateControlEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.AdaptiveRateAlgorithm getAdaptiveRateAlgorithm() {
        return LinphoneCore.AdaptiveRateAlgorithm.fromString(getAdaptiveRateAlgorithm(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setAdaptiveRateAlgorithm(LinphoneCore.AdaptiveRateAlgorithm adaptiveRateAlgorithm) {
        setAdaptiveRateAlgorithm(this.nativePtr, adaptiveRateAlgorithm.toString());
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setAudioJittcomp(int i) {
        setAudioJittcomp(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setVideoJittcomp(int i) {
        setVideoJittcomp(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setFileTransferServer(String str) {
        setFileTransferServer(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized String getFileTransferServer() {
        return getFileTransferServer(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphonePlayer createLocalPlayer(AndroidVideoWindowImpl androidVideoWindowImpl) {
        long createLocalPlayer = createLocalPlayer(this.nativePtr, androidVideoWindowImpl);
        if (createLocalPlayer == 0) {
            return null;
        }
        return new LinphonePlayerImpl(createLocalPlayer);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void addListener(LinphoneCoreListener linphoneCoreListener) {
        addListener(this.nativePtr, linphoneCoreListener);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void removeListener(LinphoneCoreListener linphoneCoreListener) {
        removeListener(this.nativePtr, linphoneCoreListener);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setRemoteRingbackTone(String str) {
        setRemoteRingbackTone(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getRemoteRingbackTone() {
        return getRemoteRingbackTone(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void uploadLogCollection() {
        uploadLogCollection(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setPreferredFramerate(float f) {
        setPreferredFramerate(this.nativePtr, f);
    }

    @Override // org.linphone.core.LinphoneCore
    public float getPreferredFramerate() {
        return getPreferredFramerate(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setAudioMulticastAddr(String str) {
        if (setAudioMulticastAddr(this.nativePtr, str) != 0) {
            throw new LinphoneCoreException("bad ip address [" + str + "]");
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public void setVideoMulticastAddr(String str) {
        if (setVideoMulticastAddr(this.nativePtr, str) != 0) {
            throw new LinphoneCoreException("bad ip address [" + str + "]");
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public String getAudioMulticastAddr() {
        return getAudioMulticastAddr(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getVideoMulticastAddr() {
        return getVideoMulticastAddr(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setAudioMulticastTtl(int i) {
        if (setAudioMulticastTtl(this.nativePtr, i) != 0) {
            throw new LinphoneCoreException("bad ttl value [" + i + "]");
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public void setVideoMulticastTtl(int i) {
        if (setVideoMulticastTtl(this.nativePtr, i) != 0) {
            throw new LinphoneCoreException("bad ttl value [" + i + "]");
        }
    }

    @Override // org.linphone.core.LinphoneCore
    public int getAudioMulticastTtl() {
        return getAudioMulticastTtl(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public int getVideoMulticastTtl() {
        return getVideoMulticastTtl(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void enableAudioMulticast(boolean z) {
        enableAudioMulticast(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean audioMulticastEnabled() {
        return audioMulticastEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void enableVideoMulticast(boolean z) {
        enableVideoMulticast(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean videoMulticastEnabled() {
        return videoMulticastEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void enableDnsSrv(boolean z) {
        enableDnsSrv(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean dnsSrvEnabled() {
        return dnsSrvEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setVideoPreset(String str) {
        setVideoPreset(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getVideoPreset() {
        return getVideoPreset(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public LinphoneCallParams createCallParams(LinphoneCall linphoneCall) {
        long j = 0;
        if (linphoneCall != null) {
            j = ((LinphoneCallImpl) linphoneCall).nativePtr;
        }
        return new LinphoneCallParamsImpl(createCallParams(this.nativePtr, j));
    }

    @Override // org.linphone.core.LinphoneCore
    public void setProvisioningUri(String str) {
        setProvisioningUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getProvisioningUri() {
        return getProvisioningUri(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public LinphoneCore.GlobalState getGlobalState() {
        return LinphoneCore.GlobalState.fromInt(getGlobalState(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public void setHttpProxyHost(String str) {
        setHttpProxyHost(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setHttpProxyPort(int i) {
        setHttpProxyPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getHttpProxyHost() {
        return getHttpProxyHost(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public int getHttpProxyPort() {
        return getHttpProxyPort(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setSipTransportTimeout(int i) {
        setSipTransportTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public int getSipTransportTimeout() {
        return getSipTransportTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setNortpTimeout(int i) {
        setNortpTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphoneCore
    public int getNortpTimeout() {
        return getNortpTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setSipNetworkReachable(boolean z) {
        setSipNetworkReachable(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setMediaNetworkReachable(boolean z) {
        setMediaNetworkReachable(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public Factory getMSFactory() {
        return (Factory) getMSFactory(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setDnsServers(String[] strArr) {
        setDnsServers(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setUserCertificatesPath(String str) {
        setUserCertificatesPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void reloadMsPlugins(String str) {
        reloadMsPlugins(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void reloadSoundDevices() {
        reloadSoundDevices(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setDefaultSoundDevices() {
        setDefaultSoundDevices(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized boolean isLimeEncryptionAvailable() {
        return isLimeEncryptionAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized void setLimeEncryption(LinphoneCore.LinphoneLimeState linphoneLimeState) {
        setLimeEncryption(this.nativePtr, linphoneLimeState.mValue);
    }

    @Override // org.linphone.core.LinphoneCore
    public synchronized LinphoneCore.LinphoneLimeState getLimeEncryption() {
        return LinphoneCore.LinphoneLimeState.fromInt(getLimeEncryption(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneCore
    public String getTlsCertificate() {
        return getTlsCertificate(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getTlsKey() {
        return getTlsKey(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getTlsCertificatePath() {
        return getTlsCertificatePath(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public String getTlsKeyPath() {
        return getTlsKeyPath(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setTlsCertificate(String str) {
        setTlsCertificate(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setTlsKey(String str) {
        setTlsKey(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setTlsCertificatePath(String str) {
        setTlsCertificatePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setTlsKeyPath(String str) {
        setTlsKeyPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setVerifyServerCertificates(boolean z) {
        setVerifyServerCertificates(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public void setVerifyServerCN(boolean z) {
        setVerifyServerCN(this.nativePtr, z);
    }

    @Override // org.linphone.core.LinphoneCore
    public void enableDownloadOpenH264(boolean z) {
        this.openh264DownloadEnabled = z;
    }

    @Override // org.linphone.core.LinphoneCore
    public boolean downloadOpenH264Enabled() {
        return this.openh264DownloadEnabled;
    }

    @Override // org.linphone.core.LinphoneCore
    public LinphoneFriend createFriend() {
        return (LinphoneFriend) createFriend(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneCore
    public LinphoneFriend createFriendWithAddress(String str) {
        return (LinphoneFriend) createFriendWithAddress(this.nativePtr, str);
    }
}
