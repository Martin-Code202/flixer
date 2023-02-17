package org.linphone.core;

import java.nio.ByteBuffer;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCore;
public class LinphoneCoreListenerBase implements LinphoneCoreListener {
    @Override // org.linphone.core.LinphoneCoreListener
    public void authInfoRequested(LinphoneCore linphoneCore, String str, String str2, String str3) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authenticationRequested(LinphoneCore linphoneCore, LinphoneAuthInfo linphoneAuthInfo, LinphoneCore.AuthMethod authMethod) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callStatsUpdated(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCallStats linphoneCallStats) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void dtmfReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, int i) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void transferState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void infoReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneInfoMessage linphoneInfoMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void subscriptionStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, SubscriptionState subscriptionState) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void show(LinphoneCore linphoneCore) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void displayStatus(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void displayMessage(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void displayWarning(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void fileTransferProgressIndication(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, int i) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void fileTransferRecv(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, byte[] bArr, int i) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public int fileTransferSend(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, ByteBuffer byteBuffer, int i) {
        return 0;
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void globalState(LinphoneCore linphoneCore, LinphoneCore.GlobalState globalState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, LinphoneCore.RegistrationState registrationState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void configuringStatus(LinphoneCore linphoneCore, LinphoneCore.RemoteProvisioningState remoteProvisioningState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceivedUnableToDecrypted(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callEncryptionChanged(LinphoneCore linphoneCore, LinphoneCall linphoneCall, boolean z, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void isComposingReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void ecCalibrationStatus(LinphoneCore linphoneCore, LinphoneCore.EcCalibratorStatus ecCalibratorStatus, int i, Object obj) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void uploadProgressIndication(LinphoneCore linphoneCore, int i, int i2) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void uploadStateChanged(LinphoneCore linphoneCore, LinphoneCore.LogCollectionUploadState logCollectionUploadState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void friendListCreated(LinphoneCore linphoneCore, LinphoneFriendList linphoneFriendList) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void friendListRemoved(LinphoneCore linphoneCore, LinphoneFriendList linphoneFriendList) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void networkReachableChanged(LinphoneCore linphoneCore, boolean z) {
    }
}
