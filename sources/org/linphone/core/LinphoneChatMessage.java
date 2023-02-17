package org.linphone.core;

import java.util.Vector;
public interface LinphoneChatMessage {

    public interface LinphoneChatMessageListener {
        void onLinphoneChatMessageFileTransferProgressChanged(LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, int i, int i2);

        void onLinphoneChatMessageFileTransferReceived(LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, LinphoneBuffer linphoneBuffer);

        void onLinphoneChatMessageFileTransferSent(LinphoneChatMessage linphoneChatMessage, LinphoneContent linphoneContent, int i, int i2, LinphoneBuffer linphoneBuffer);

        void onLinphoneChatMessageStateChanged(LinphoneChatMessage linphoneChatMessage, State state);
    }

    @Deprecated
    public interface StateListener {
        void onLinphoneChatMessageStateChanged(LinphoneChatMessage linphoneChatMessage, State state);
    }

    void addCustomHeader(String str, String str2);

    void cancelFileTransfer();

    void destroy();

    int downloadFile();

    String getAppData();

    String getCustomHeader(String str);

    ErrorInfo getErrorInfo();

    String getExternalBodyUrl();

    LinphoneContent getFileTransferInformation();

    LinphoneAddress getFrom();

    LinphoneAddress getPeerAddress();

    Reason getReason();

    State getStatus();

    int getStorageId();

    String getText();

    long getTime();

    LinphoneAddress getTo();

    boolean isOutgoing();

    boolean isRead();

    boolean isSecured();

    void putChar(long j);

    void reSend();

    void setAppData(String str);

    void setExternalBodyUrl(String str);

    void setFileTransferFilepath(String str);

    void setListener(LinphoneChatMessageListener linphoneChatMessageListener);

    void store();

    public static class State {
        public static final State Delivered = new State(2, "Delivered");
        public static final State DeliveredToUser = new State(6, "DeliveredToUser");
        public static final State Displayed = new State(7, "Displayed");
        public static final State FileTransferDone = new State(5, "FileTransferDone");
        public static final State FileTransferError = new State(4, "FileTransferError");
        public static final State Idle = new State(0, "Idle");
        public static final State InProgress = new State(1, "InProgress");
        public static final State NotDelivered = new State(3, "NotDelivered");
        private static Vector<State> values = new Vector<>();
        private final String mStringValue;
        private final int mValue;

        public final int value() {
            return this.mValue;
        }

        private State(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static State fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                State elementAt = values.elementAt(i2);
                if (elementAt.mValue == i) {
                    return elementAt;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
