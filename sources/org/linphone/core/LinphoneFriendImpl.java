package org.linphone.core;

import java.io.Serializable;
import org.linphone.core.LinphoneAddressImpl;
import org.linphone.core.LinphoneFriend;
public class LinphoneFriendImpl implements LinphoneFriend, Serializable {
    protected final long nativePtr;
    private Object userdData;

    private native void addAddress(long j, long j2);

    private native void addPhoneNumber(long j, String str);

    private native void done(long j);

    private native void edit(long j);

    private native void enableSubscribes(long j, boolean z);

    private native void finalize(long j);

    private native long getAddress(long j);

    private native long[] getAddresses(long j);

    private native Object getCore(long j);

    private native String getFamilyName(long j);

    private native String getGivenName(long j);

    private native int getIncSubscribePolicy(long j);

    private native String getName(long j);

    private native String getOrganization(long j);

    private native Object[] getPhoneNumbers(long j);

    private native Object getPresenceModel(long j);

    private native Object getPresenceModelForUri(long j, String str);

    private native String getRefKey(long j);

    private native int getStatus(long j);

    private native String getVcardToString(long j);

    private native boolean isAlreadyPresentInFriendList(long j);

    private native boolean isPresenceReceived(long j);

    private native boolean isSubscribesEnabled(long j);

    private native long newLinphoneFriend(String str);

    private native void removeAddress(long j, long j2);

    private native void removePhoneNumber(long j, String str);

    private native void setAddress(long j, long j2);

    private native void setFamilyName(long j, String str);

    private native void setGivenName(long j, String str);

    private native void setIncSubscribePolicy(long j, int i);

    private native void setName(long j, String str);

    private native void setOrganization(long j, String str);

    private native void setPresenceModel(long j, long j2);

    private native void setRefKey(long j, String str);

    public Object getUserData() {
        return this.userdData;
    }

    public void setUserData(Object obj) {
        this.userdData = obj;
    }

    protected LinphoneFriendImpl() {
        this.nativePtr = newLinphoneFriend(null);
    }

    protected LinphoneFriendImpl(String str) {
        this.nativePtr = newLinphoneFriend(str);
    }

    protected LinphoneFriendImpl(long j) {
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

    @Override // org.linphone.core.LinphoneFriend
    public void setAddress(LinphoneAddress linphoneAddress) {
        setAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public LinphoneAddress getAddress() {
        long address = getAddress(this.nativePtr);
        if (address != 0) {
            return new LinphoneAddressImpl(address, LinphoneAddressImpl.WrapMode.FromConst);
        }
        return null;
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setIncSubscribePolicy(LinphoneFriend.SubscribePolicy subscribePolicy) {
        synchronized (getSyncObject()) {
            setIncSubscribePolicy(this.nativePtr, subscribePolicy.mValue);
        }
    }

    @Override // org.linphone.core.LinphoneFriend
    public LinphoneFriend.SubscribePolicy getIncSubscribePolicy() {
        return LinphoneFriend.SubscribePolicy.fromInt(getIncSubscribePolicy(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneFriend
    public void enableSubscribes(boolean z) {
        synchronized (getSyncObject()) {
            enableSubscribes(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.LinphoneFriend
    public boolean isSubscribesEnabled() {
        return isSubscribesEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public boolean isPresenceReceived() {
        return isPresenceReceived(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public OnlineStatus getStatus() {
        return OnlineStatus.fromInt(getStatus(this.nativePtr));
    }

    @Override // org.linphone.core.LinphoneFriend
    public PresenceModel getPresenceModel() {
        return (PresenceModel) getPresenceModel(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public PresenceModel getPresenceModelForUri(String str) {
        return (PresenceModel) getPresenceModelForUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setPresenceModel(PresenceModel presenceModel) {
        setPresenceModel(this.nativePtr, ((PresenceModelImpl) presenceModel).getNativePtr());
    }

    @Override // org.linphone.core.LinphoneFriend
    public void edit() {
        synchronized (getSyncObject()) {
            edit(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneFriend
    public void done() {
        synchronized (getSyncObject()) {
            done(this.nativePtr);
        }
    }

    @Override // org.linphone.core.LinphoneFriend
    public long getNativePtr() {
        return this.nativePtr;
    }

    private Object getSyncObject() {
        Object core = getCore(this.nativePtr);
        if (core != null) {
            return core;
        }
        return this;
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setRefKey(String str) {
        synchronized (getSyncObject()) {
            setRefKey(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.LinphoneFriend
    public String getRefKey() {
        return getRefKey(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public synchronized String getVcardToString() {
        return getVcardToString(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setName(String str) {
        setName(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public String getName() {
        return getName(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setFamilyName(String str) {
        setFamilyName(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public String getFamilyName() {
        return getFamilyName(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setGivenName(String str) {
        setGivenName(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public String getGivenName() {
        return getGivenName(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void setOrganization(String str) {
        setOrganization(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public String getOrganization() {
        return getOrganization(this.nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public LinphoneAddress[] getAddresses() {
        long[] addresses = getAddresses(this.nativePtr);
        if (addresses == null) {
            return null;
        }
        LinphoneAddress[] linphoneAddressArr = new LinphoneAddress[addresses.length];
        for (int i = 0; i < linphoneAddressArr.length; i++) {
            linphoneAddressArr[i] = new LinphoneAddressImpl(addresses[i], LinphoneAddressImpl.WrapMode.FromConst);
        }
        return linphoneAddressArr;
    }

    @Override // org.linphone.core.LinphoneFriend
    public void addAddress(LinphoneAddress linphoneAddress) {
        addAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void removeAddress(LinphoneAddress linphoneAddress) {
        removeAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
    }

    @Override // org.linphone.core.LinphoneFriend
    public String[] getPhoneNumbers() {
        Object[] phoneNumbers = getPhoneNumbers(this.nativePtr);
        if (phoneNumbers == null) {
            return null;
        }
        String[] strArr = new String[phoneNumbers.length];
        for (int i = 0; i < phoneNumbers.length; i++) {
            strArr[i] = phoneNumbers[i].toString();
        }
        return strArr;
    }

    @Override // org.linphone.core.LinphoneFriend
    public void addPhoneNumber(String str) {
        addPhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public void removePhoneNumber(String str) {
        removePhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphoneFriend
    public boolean isAlreadyPresentInFriendList() {
        return isAlreadyPresentInFriendList(this.nativePtr);
    }
}
