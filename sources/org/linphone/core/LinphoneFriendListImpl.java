package org.linphone.core;

import java.io.Serializable;
import org.linphone.core.LinphoneFriendList;
class LinphoneFriendListImpl implements LinphoneFriendList, Serializable {
    protected final long nativePtr;

    private native void addFriend(long j, long j2);

    private native void addLocalFriend(long j, long j2);

    private native void enableSubscriptions(long j, boolean z);

    private native void exportFriendsToVCardFile(long j, String str);

    private native void finalize(long j);

    private native LinphoneFriend findFriendByUri(long j, String str);

    private native Object getCore(long j);

    private native LinphoneFriend[] getFriendList(long j);

    private native String getRLSUri(long j);

    private native int importFriendsFromVCardBuffer(long j, String str);

    private native int importFriendsFromVCardFile(long j, String str);

    private native long newLinphoneFriendList(long j);

    private native void setListener(long j, LinphoneFriendList.LinphoneFriendListListener linphoneFriendListListener);

    private native void setRLSAddress(long j, long j2);

    private native void setRLSUri(long j, String str);

    private native void setUri(long j, String str);

    private native void synchronizeFriendsFromServer(long j);

    private native void updateSubscriptions(long j);

    protected LinphoneFriendListImpl(LinphoneCoreImpl linphoneCoreImpl) {
        this.nativePtr = newLinphoneFriendList(linphoneCoreImpl.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void setRLSAddress(LinphoneAddress linphoneAddress) {
        synchronized (getSyncObject()) {
            setRLSAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void setRLSUri(String str) {
        synchronized (getSyncObject()) {
            setRLSUri(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public String getRLSUri() {
        String rLSUri;
        synchronized (getSyncObject()) {
            rLSUri = getRLSUri(this.nativePtr);
        }
        return rLSUri;
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void addFriend(LinphoneFriend linphoneFriend) {
        synchronized (getSyncObject()) {
            addFriend(this.nativePtr, linphoneFriend.getNativePtr());
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void addLocalFriend(LinphoneFriend linphoneFriend) {
        synchronized (getSyncObject()) {
            addLocalFriend(this.nativePtr, linphoneFriend.getNativePtr());
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public LinphoneFriend[] getFriendList() {
        LinphoneFriend[] friendList;
        synchronized (getSyncObject()) {
            friendList = getFriendList(this.nativePtr);
        }
        return friendList;
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void updateSubscriptions() {
        synchronized (getSyncObject()) {
            updateSubscriptions(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void enableSubscriptions(boolean z) {
        synchronized (getSyncObject()) {
            enableSubscriptions(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public LinphoneFriend findFriendByUri(String str) {
        LinphoneFriend findFriendByUri;
        synchronized (getSyncObject()) {
            findFriendByUri = findFriendByUri(this.nativePtr, str);
        }
        return findFriendByUri;
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void setUri(String str) {
        synchronized (getSyncObject()) {
            setUri(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void synchronizeFriendsFromServer() {
        synchronized (getSyncObject()) {
            synchronizeFriendsFromServer(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneFriendList
    public int importFriendsFromVCardFile(String str) {
        return importFriendsFromVCardFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriendList
    public int importFriendsFromVCardBuffer(String str) {
        return importFriendsFromVCardBuffer(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void exportFriendsToVCardFile(String str) {
        exportFriendsToVCardFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriendList
    public void setListener(LinphoneFriendList.LinphoneFriendListListener linphoneFriendListListener) {
        setListener(this.nativePtr, linphoneFriendListListener);
    }

    protected LinphoneFriendListImpl(long j) {
        this.nativePtr = j;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        if (this.nativePtr != 0) {
            finalize(this.nativePtr);
        }
        super.finalize();
    }

    @Override // org.linphone.core.LinphoneFriendList
    public long getNativePtr() {
        return this.nativePtr;
    }

    private Object getSyncObject() {
        return this;
    }
}
