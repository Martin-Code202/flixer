package org.linphone.core;

import java.io.UnsupportedEncodingException;
import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneChatMessage;
public class LinphoneChatMessageImpl implements LinphoneChatMessage {
    protected long nativePtr;

    private native void addCustomHeader(long j, String str, String str2);

    private native void cancelFileTransfer(long j);

    private native int downloadFile(long j);

    private native String getAppData(long j);

    private native String getCustomHeader(long j, String str);

    private native long getErrorInfo(long j);

    private native String getExternalBodyUrl(long j);

    private native Object getFileTransferInformation(long j);

    private native long getFrom(long j);

    private native long getPeerAddress(long j);

    private native int getReason(long j);

    private native int getStatus(long j);

    private native int getStorageId(long j);

    private native byte[] getText(long j);

    private native long getTime(long j);

    private native long getTo(long j);

    private native boolean isOutgoing(long j);

    private native boolean isRead(long j);

    private native boolean isSecured(long j);

    private native void putChar(long j, long j2);

    private native void reSend(long j);

    private native void setAppData(long j, String str);

    private native void setExternalBodyUrl(long j, String str);

    private native void setFileTransferFilepath(long j, String str);

    private native void setListener(long j, LinphoneChatMessage.LinphoneChatMessageListener linphoneChatMessageListener);

    private native void store(long j);

    private native void unref(long j);

    protected LinphoneChatMessageImpl(long j) {
        this.nativePtr = j;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public String getText() {
        try {
            byte[] text = getText(this.nativePtr);
            if (text != null) {
                return new String(text, "UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public LinphoneAddress getPeerAddress() {
        return new LinphoneAddressImpl(getPeerAddress(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public String getExternalBodyUrl() {
        return getExternalBodyUrl(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void setExternalBodyUrl(String str) {
        setExternalBodyUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public LinphoneAddress getFrom() {
        return new LinphoneAddressImpl(getFrom(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public LinphoneAddress getTo() {
        return new LinphoneAddressImpl(getTo(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void addCustomHeader(String str, String str2) {
        addCustomHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public String getCustomHeader(String str) {
        return getCustomHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public long getTime() {
        return getTime(this.nativePtr) * 1000;
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public LinphoneChatMessage.State getStatus() {
        return LinphoneChatMessage.State.fromInt(getStatus(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public boolean isRead() {
        return isRead(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public boolean isOutgoing() {
        return isOutgoing(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void store() {
        store(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public int getStorageId() {
        return getStorageId(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public Reason getReason() {
        return Reason.fromInt(getReason(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public ErrorInfo getErrorInfo() {
        return new ErrorInfoImpl(getErrorInfo(this.nativePtr));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        destroy();
        super.finalize();
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public LinphoneContent getFileTransferInformation() {
        return (LinphoneContent) getFileTransferInformation(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void setAppData(String str) {
        setAppData(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public String getAppData() {
        return getAppData(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void cancelFileTransfer() {
        cancelFileTransfer(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void setFileTransferFilepath(String str) {
        setFileTransferFilepath(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public int downloadFile() {
        return downloadFile(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void setListener(LinphoneChatMessage.LinphoneChatMessageListener linphoneChatMessageListener) {
        setListener(this.nativePtr, linphoneChatMessageListener);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void putChar(long j) {
        putChar(this.nativePtr, j);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void destroy() {
        if (this.nativePtr != 0) {
            unref(this.nativePtr);
            this.nativePtr = 0;
        }
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public boolean isSecured() {
        return isSecured(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneChatMessage
    public void reSend() {
        reSend(this.nativePtr);
    }
}
