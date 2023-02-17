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
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneFriendList;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;
public class TutorialChatRoom implements LinphoneCoreListener, LinphoneChatMessage.StateListener {
    private TutorialNotifier TutorialNotifier;
    private boolean running;

    public TutorialChatRoom(TutorialNotifier tutorialNotifier) {
        this.TutorialNotifier = tutorialNotifier;
    }

    public TutorialChatRoom() {
        this.TutorialNotifier = new TutorialNotifier();
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void show(LinphoneCore linphoneCore) {
    }

    public void byeReceived(LinphoneCore linphoneCore, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authInfoRequested(LinphoneCore linphoneCore, String str, String str2, String str3) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void authenticationRequested(LinphoneCore linphoneCore, LinphoneAuthInfo linphoneAuthInfo, LinphoneCore.AuthMethod authMethod) {
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
    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, LinphoneCore.RegistrationState registrationState, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
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
        if (strArr.length != 1) {
            throw new IllegalArgumentException("Bad number of arguments");
        }
        try {
            new TutorialChatRoom().launchTutorial(strArr[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchTutorial(String str) {
        LinphoneCore createLinphoneCore = LinphoneCoreFactory.instance().createLinphoneCore(this, null);
        try {
            LinphoneChatRoom orCreateChatRoom = createLinphoneCore.getOrCreateChatRoom(str);
            orCreateChatRoom.sendMessage(orCreateChatRoom.createLinphoneChatMessage("Hello world"), this);
            this.running = true;
            while (this.running) {
                createLinphoneCore.iterate();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    write("Interrupted!\nAborting");
                    return;
                }
            }
            write("Shutting down...");
            createLinphoneCore.destroy();
            write("Exited");
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
        write("Message [" + linphoneChatMessage.getText() + "] received from [" + linphoneChatMessage.getFrom().asString() + "]");
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void messageReceivedUnableToDecrypted(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    @Override // org.linphone.core.LinphoneChatMessage.StateListener
    public void onLinphoneChatMessageStateChanged(LinphoneChatMessage linphoneChatMessage, LinphoneChatMessage.State state) {
        write("Sent message [" + linphoneChatMessage.getText() + "] new state is " + state.toString());
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
        if (linphoneChatRoom.isRemoteComposing()) {
            write("Remote is writing a message");
        } else {
            write("Remote has stop writing");
        }
    }

    @Override // org.linphone.core.LinphoneCoreListener
    public void configuringStatus(LinphoneCore linphoneCore, LinphoneCore.RemoteProvisioningState remoteProvisioningState, String str) {
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
