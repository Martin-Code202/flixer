package org.linphone.core;
public class PresenceServiceImpl implements PresenceService {
    private long mNativePtr;

    private native int addNote(long j, long j2);

    private native int clearNotes(long j);

    private native int getBasicStatus(long j);

    private native String getContact(long j);

    private native String getId(long j);

    private native long getNbNotes(long j);

    private native Object getNthNote(long j, long j2);

    private native long newPresenceServiceImpl(String str, int i, String str2);

    private native int setBasicStatus(long j, int i);

    private native int setContact(long j, String str);

    private native int setId(long j, String str);

    private native void unref(long j);

    protected PresenceServiceImpl(long j) {
        this.mNativePtr = j;
    }

    protected PresenceServiceImpl(String str, PresenceBasicStatus presenceBasicStatus, String str2) {
        this.mNativePtr = newPresenceServiceImpl(str, presenceBasicStatus.toInt(), str2);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unref(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public String getId() {
        return getId(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public int setId(String str) {
        return setId(this.mNativePtr, str);
    }

    @Override // org.linphone.core.PresenceService
    public PresenceBasicStatus getBasicStatus() {
        return PresenceBasicStatus.fromInt(getBasicStatus(this.mNativePtr));
    }

    @Override // org.linphone.core.PresenceService
    public int setBasicStatus(PresenceBasicStatus presenceBasicStatus) {
        return setBasicStatus(this.mNativePtr, presenceBasicStatus.toInt());
    }

    @Override // org.linphone.core.PresenceService
    public String getContact() {
        return getContact(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public int setContact(String str) {
        return setContact(this.mNativePtr, str);
    }

    @Override // org.linphone.core.PresenceService
    public long getNbNotes() {
        return getNbNotes(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public PresenceNote getNthNote(long j) {
        return (PresenceNote) getNthNote(this.mNativePtr, j);
    }

    @Override // org.linphone.core.PresenceService
    public int addNote(PresenceNote presenceNote) {
        return addNote(this.mNativePtr, presenceNote.getNativePtr());
    }

    @Override // org.linphone.core.PresenceService
    public int clearNotes() {
        return clearNotes(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public long getNativePtr() {
        return this.mNativePtr;
    }
}
