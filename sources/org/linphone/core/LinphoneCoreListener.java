package org.linphone.core;

import java.nio.ByteBuffer;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCore;
public interface LinphoneCoreListener {
    @Deprecated
    void authInfoRequested(LinphoneCore linphoneCore, String str, String str2, String str3);

    void authenticationRequested(LinphoneCore linphoneCore, LinphoneAuthInfo linphoneAuthInfo, LinphoneCore.AuthMethod authMethod);

    void callEncryptionChanged(LinphoneCore linphoneCore, LinphoneCall linphoneCall, boolean z, String str);

    void callState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state, String str);

    void callStatsUpdated(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCallStats linphoneCallStats);

    void configuringStatus(LinphoneCore linphoneCore, LinphoneCore.RemoteProvisioningState remoteProvisioningState, String str);

    @Deprecated
    void displayMessage(LinphoneCore linphoneCore, String str);

    @Deprecated
    void displayStatus(LinphoneCore linphoneCore, String str);

    @Deprecated
    void displayWarning(LinphoneCore linphoneCore, String str);

    void dtmfReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, int i);

    void ecCalibrationStatus(LinphoneCore linphoneCore, LinphoneCore.EcCalibratorStatus ecCalibratorStatus, int i, Object obj);

    void fileTransferProgressIndication(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, int i);

    void fileTransferRecv(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, byte[] bArr, int i);

    int fileTransferSend(LinphoneCore linphoneCore, LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, ByteBuffer byteBuffer, int i);

    void friendListCreated(LinphoneCore linphoneCore, LinphoneFriendList linphoneFriendList);

    void friendListRemoved(LinphoneCore linphoneCore, LinphoneFriendList linphoneFriendList);

    void globalState(LinphoneCore linphoneCore, LinphoneCore.GlobalState globalState, String str);

    void infoReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneInfoMessage linphoneInfoMessage);

    void isComposingReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom);

    void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage);

    void messageReceivedUnableToDecrypted(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage);

    void networkReachableChanged(LinphoneCore linphoneCore, boolean z);

    void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str);

    void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend);

    void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr);

    void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent);

    void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState);

    void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, LinphoneCore.RegistrationState registrationState, String str);

    @Deprecated
    void show(LinphoneCore linphoneCore);

    void subscriptionStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, SubscriptionState subscriptionState);

    void transferState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state);

    void uploadProgressIndication(LinphoneCore linphoneCore, int i, int i2);

    void uploadStateChanged(LinphoneCore linphoneCore, LinphoneCore.LogCollectionUploadState logCollectionUploadState, String str);
}
