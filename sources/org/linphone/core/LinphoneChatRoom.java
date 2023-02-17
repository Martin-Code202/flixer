package org.linphone.core;

import org.linphone.core.LinphoneChatMessage;
public interface LinphoneChatRoom {
    void compose();

    LinphoneChatMessage createFileTransferMessage(LinphoneContent linphoneContent);

    LinphoneChatMessage createLinphoneChatMessage(String str);

    void deleteHistory();

    void deleteMessage(LinphoneChatMessage linphoneChatMessage);

    LinphoneCall getCall();

    long getChar();

    LinphoneCore getCore();

    LinphoneChatMessage[] getHistory();

    LinphoneChatMessage[] getHistory(int i);

    LinphoneChatMessage[] getHistoryRange(int i, int i2);

    int getHistorySize();

    LinphoneAddress getPeerAddress();

    int getUnreadMessagesCount();

    boolean isRemoteComposing();

    boolean islimeAvailable();

    void markAsRead();

    void sendChatMessage(LinphoneChatMessage linphoneChatMessage);

    void sendMessage(String str);

    @Deprecated
    void sendMessage(LinphoneChatMessage linphoneChatMessage, LinphoneChatMessage.StateListener stateListener);
}
