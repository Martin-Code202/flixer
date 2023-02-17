package org.linphone.core;
public class PresencePersonImpl implements PresencePerson {
    private long mNativePtr;

    private native int addActivitiesNote(long j, long j2);

    private native int addActivity(long j, long j2);

    private native int addNote(long j, long j2);

    private native int clearActivitesNotes(long j);

    private native int clearActivities(long j);

    private native int clearNotes(long j);

    private native String getId(long j);

    private native long getNbActivities(long j);

    private native long getNbActivitiesNotes(long j);

    private native long getNbNotes(long j);

    private native Object getNthActivitiesNote(long j, long j2);

    private native Object getNthActivity(long j, long j2);

    private native Object getNthNote(long j, long j2);

    private native long newPresencePersonImpl(String str);

    private native int setId(long j, String str);

    private native void unref(long j);

    protected PresencePersonImpl(long j) {
        this.mNativePtr = j;
    }

    protected PresencePersonImpl(String str) {
        this.mNativePtr = newPresencePersonImpl(str);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unref(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public String getId() {
        return getId(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public int setId(String str) {
        return setId(this.mNativePtr, str);
    }

    @Override // org.linphone.core.PresencePerson
    public long getNbActivities() {
        return getNbActivities(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public PresenceActivity getNthActivity(long j) {
        return (PresenceActivity) getNthActivity(this.mNativePtr, j);
    }

    @Override // org.linphone.core.PresencePerson
    public int addActivity(PresenceActivity presenceActivity) {
        return addActivity(this.mNativePtr, presenceActivity.getNativePtr());
    }

    @Override // org.linphone.core.PresencePerson
    public int clearActivities() {
        return clearActivities(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public long getNbNotes() {
        return getNbNotes(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public PresenceNote getNthNote(long j) {
        return (PresenceNote) getNthNote(this.mNativePtr, j);
    }

    @Override // org.linphone.core.PresencePerson
    public int addNote(PresenceNote presenceNote) {
        return addNote(this.mNativePtr, presenceNote.getNativePtr());
    }

    @Override // org.linphone.core.PresencePerson
    public int clearNotes() {
        return clearNotes(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public long getNbActivitiesNotes() {
        return getNbActivitiesNotes(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public PresenceNote getNthActivitiesNote(long j) {
        return (PresenceNote) getNthActivitiesNote(this.mNativePtr, j);
    }

    @Override // org.linphone.core.PresencePerson
    public int addActivitiesNote(PresenceNote presenceNote) {
        return addActivitiesNote(this.mNativePtr, presenceNote.getNativePtr());
    }

    @Override // org.linphone.core.PresencePerson
    public int clearActivitesNotes() {
        return clearActivitesNotes(this.mNativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public long getNativePtr() {
        return this.mNativePtr;
    }
}
