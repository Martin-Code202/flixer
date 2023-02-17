package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneChatMessage;
class LinphoneChatRoomImpl implements LinphoneChatRoom {
    protected final long nativePtr;

    private native void compose(long j);

    private native Object createFileTransferMessage(long j, String str, String str2, String str3, int i);

    private native Object createLinphoneChatMessage(long j, String str);

    private native void deleteHistory(long j);

    private native void deleteMessage(long j, long j2);

    private native void destroy(long j);

    private native void finalize(long j);

    private native Object getCall(long j);

    private native long getChar(long j);

    private native Object getCore(long j);

    private native Object[] getHistory(long j, int i);

    private native Object[] getHistoryRange(long j, int i, int i2);

    private native int getHistorySize(long j);

    private native long getPeerAddress(long j);

    private native int getUnreadMessagesCount(long j);

    private native boolean isRemoteComposing(long j);

    private native boolean islimeAvailable(long j);

    private native void markAsRead(long j);

    private native void sendChatMessage(long j, Object obj, long j2);

    private native void sendMessage(long j, String str);

    private native void sendMessage2(long j, Object obj, long j2, LinphoneChatMessage.StateListener stateListener);

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.nativePtr != 0) {
            finalize(this.nativePtr);
        }
        super.finalize();
    }

    protected LinphoneChatRoomImpl(long j) {
        this.nativePtr = j;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneAddress getPeerAddress() {
        return new LinphoneAddressImpl(getPeerAddress(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void sendMessage(String str) {
        synchronized (getCore()) {
            sendMessage(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void sendMessage(LinphoneChatMessage linphoneChatMessage, LinphoneChatMessage.StateListener stateListener) {
        synchronized (getCore()) {
            sendMessage2(this.nativePtr, linphoneChatMessage, ((LinphoneChatMessageImpl) linphoneChatMessage).getNativePtr(), stateListener);
        }
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneChatMessage createLinphoneChatMessage(String str) {
        LinphoneChatMessage linphoneChatMessage;
        synchronized (getCore()) {
            linphoneChatMessage = (LinphoneChatMessage) createLinphoneChatMessage(this.nativePtr, str);
        }
        return linphoneChatMessage;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneChatMessage[] getHistory() {
        LinphoneChatMessage[] history;
        synchronized (getCore()) {
            history = getHistory(0);
        }
        return history;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneChatMessage[] getHistoryRange(int i, int i2) {
        LinphoneChatMessage[] historyPrivate;
        synchronized (getCore()) {
            historyPrivate = getHistoryPrivate(getHistoryRange(this.nativePtr, i, i2));
        }
        return historyPrivate;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneChatMessage[] getHistory(int i) {
        LinphoneChatMessage[] historyPrivate;
        synchronized (getCore()) {
            historyPrivate = getHistoryPrivate(getHistory(this.nativePtr, i));
        }
        return historyPrivate;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public int getUnreadMessagesCount() {
        int unreadMessagesCount;
        synchronized (getCore()) {
            unreadMessagesCount = getUnreadMessagesCount(this.nativePtr);
        }
        return unreadMessagesCount;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public int getHistorySize() {
        int historySize;
        synchronized (getCore()) {
            historySize = getHistorySize(this.nativePtr);
        }
        return historySize;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void deleteHistory() {
        synchronized (getCore()) {
            deleteHistory(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void compose() {
        synchronized (getCore()) {
            compose(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public boolean isRemoteComposing() {
        boolean isRemoteComposing;
        synchronized (getCore()) {
            isRemoteComposing = isRemoteComposing(this.nativePtr);
        }
        return isRemoteComposing;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void markAsRead() {
        synchronized (getCore()) {
            markAsRead(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void deleteMessage(LinphoneChatMessage linphoneChatMessage) {
        synchronized (getCore()) {
            if (linphoneChatMessage != null) {
                deleteMessage(this.nativePtr, ((LinphoneChatMessageImpl) linphoneChatMessage).getNativePtr());
            }
        }
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public synchronized LinphoneCore getCore() {
        return (LinphoneCore) getCore(this.nativePtr);
    }

    private LinphoneChatMessage[] getHistoryPrivate(Object[] objArr) {
        return (LinphoneChatMessage[]) objArr;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneChatMessage createFileTransferMessage(LinphoneContent linphoneContent) {
        LinphoneChatMessage linphoneChatMessage;
        synchronized (getCore()) {
            linphoneChatMessage = (LinphoneChatMessage) createFileTransferMessage(this.nativePtr, linphoneContent.getName(), linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getRealSize());
        }
        return linphoneChatMessage;
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public void sendChatMessage(LinphoneChatMessage linphoneChatMessage) {
        sendChatMessage(this.nativePtr, linphoneChatMessage, ((LinphoneChatMessageImpl) linphoneChatMessage).getNativePtr());
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public LinphoneCall getCall() {
        return (LinphoneCall) getCall(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public long getChar() {
        return getChar(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatRoom
    public boolean islimeAvailable() {
        return islimeAvailable(this.nativePtr);
    }
}
