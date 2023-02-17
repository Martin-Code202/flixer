package org.linphone.core.tutorials;

import java.nio.ByteBuffer;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneAuthInfo;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCallStats;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneContent;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneFriendList;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.OnlineStatus;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;
public class TutorialBuddyStatus implements LinphoneCoreListener {
    private TutorialNotifier TutorialNotifier;
    private boolean running;

    public TutorialBuddyStatus(TutorialNotifier tutorialNotifier) {
        this.TutorialNotifier = tutorialNotifier;
    }

    public TutorialBuddyStatus() {
        this.TutorialNotifier = new TutorialNotifier();
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
        write("[" + linphoneFriend.getAddress().getUserName() + "] wants to see your status, accepting");
        linphoneFriend.edit();
        linphoneFriend.setIncSubscribePolicy(LinphoneFriend.SubscribePolicy.SPAccept);
        linphoneFriend.done();
        try {
            linphoneCore.addFriend(linphoneFriend);
        } catch (LinphoneCoreException e) {
            write("Error while adding friend [" + linphoneFriend.getAddress().getUserName() + "] to linphone in the callback");
        }
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
        write("New state [" + linphoneFriend.getStatus() + "] for user id [" + linphoneFriend.getAddress().getUserName() + "]");
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, LinphoneCore.RegistrationState registrationState, String str) {
        write(linphoneProxyConfig.getIdentity() + " : " + str + "\n");
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void show(LinphoneCore linphoneCore) {
    }

    public void byeReceived(LinphoneCore linphoneCore, String str) {
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
    public void globalState(LinphoneCore linphoneCore, LinphoneCore.GlobalState globalState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCall.State state, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callStatsUpdated(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCallStats linphoneCallStats) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void ecCalibrationStatus(LinphoneCore linphoneCore, LinphoneCore.EcCalibratorStatus ecCalibratorStatus, int i, Object obj) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void callEncryptionChanged(LinphoneCore linphoneCore, LinphoneCall linphoneCall, boolean z, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void dtmfReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, int i) {
    }

    public static void main(String[] strArr) {
        if (strArr.length < 1 || strArr.length > 3) {
            throw new IllegalArgumentException("Bad number of arguments [" + strArr.length + "] should be 1, 2 or 3");
        }
        try {
            new TutorialBuddyStatus().launchTutorial(strArr[1], strArr.length > 1 ? strArr[1] : null, strArr.length > 2 ? strArr[2] : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchTutorial(String str, String str2, String str3) {
        LinphoneCoreFactory instance = LinphoneCoreFactory.instance();
        LinphoneCore createLinphoneCore = instance.createLinphoneCore(this, null);
        try {
            LinphoneFriend createFriendWithAddress = createLinphoneCore.createFriendWithAddress(str);
            if (createFriendWithAddress == null) {
                write("Could not create friend; weird SIP address?");
                return;
            }
            if (str2 != null) {
                LinphoneAddress createLinphoneAddress = instance.createLinphoneAddress(str2);
                String userName = createLinphoneAddress.getUserName();
                String domain = createLinphoneAddress.getDomain();
                if (str3 != null) {
                    createLinphoneCore.addAuthInfo(instance.createAuthInfo(userName, str3, null, domain));
                }
                LinphoneProxyConfig createProxyConfig = createLinphoneCore.createProxyConfig(str2, domain, null, true);
                createProxyConfig.enablePublish(true);
                createLinphoneCore.addProxyConfig(createProxyConfig);
                createLinphoneCore.setDefaultProxyConfig(createProxyConfig);
                while (!createProxyConfig.isRegistered()) {
                    createLinphoneCore.iterate();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        write("Interrupted!\nAborting");
                        write("Shutting down...");
                        createLinphoneCore.destroy();
                        write("Exited");
                        return;
                    }
                }
            }
            createFriendWithAddress.enableSubscribes(true);
            createFriendWithAddress.setIncSubscribePolicy(LinphoneFriend.SubscribePolicy.SPAccept);
            try {
                createLinphoneCore.addFriend(createFriendWithAddress);
                createLinphoneCore.setPresenceInfo(0, null, OnlineStatus.Online);
                this.running = true;
                while (this.running) {
                    createLinphoneCore.iterate();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e2) {
                        write("Interrupted!\nAborting");
                        write("Shutting down...");
                        createLinphoneCore.destroy();
                        write("Exited");
                        return;
                    }
                }
                createLinphoneCore.setPresenceInfo(0, null, OnlineStatus.Offline);
                createLinphoneCore.iterate();
                createFriendWithAddress.edit();
                createFriendWithAddress.enableSubscribes(false);
                createFriendWithAddress.done();
                createLinphoneCore.iterate();
                write("Shutting down...");
                createLinphoneCore.destroy();
                write("Exited");
            } catch (LinphoneCoreException e3) {
                write("Error while adding friend " + createFriendWithAddress.getAddress().getUserName() + " to linphone");
                write("Shutting down...");
                createLinphoneCore.destroy();
                write("Exited");
            }
        } finally {
            write("Shutting down...");
            createLinphoneCore.destroy();
            write("Exited");
        }
    }

    public void stopMainLoop() {
        this.running = false;
    }

    private void write(String str) {
        this.TutorialNotifier.notify(str);
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceivedUnableToDecrypted(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
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
    public void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void isComposingReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void configuringStatus(LinphoneCore linphoneCore, LinphoneCore.RemoteProvisioningState remoteProvisioningState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authInfoRequested(LinphoneCore linphoneCore, String str, String str2, String str3) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authenticationRequested(LinphoneCore linphoneCore, LinphoneAuthInfo linphoneAuthInfo, LinphoneCore.AuthMethod authMethod) {
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
