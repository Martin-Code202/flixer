package org.linphone.core;
public class PresenceActivityImpl implements PresenceActivity {
    private long mNativePtr;

    private native String getDescription(long j);

    private native int getType(long j);

    private native long newPresenceActivityImpl(int i, String str);

    private native int setDescription(long j, String str);

    private native int setType(long j, int i);

    private native String toString(long j);

    private native void unref(long j);

    protected PresenceActivityImpl(long j) {
        this.mNativePtr = j;
    }

    protected PresenceActivityImpl(PresenceActivityType presenceActivityType, String str) {
        this.mNativePtr = newPresenceActivityImpl(presenceActivityType.toInt(), str);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unref(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceActivity
    public String toString() {
        return toString(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceActivity
    public PresenceActivityType getType() {
        return PresenceActivityType.fromInt(getType(this.mNativePtr));
    }

    @Override // org.linphone.core.PresenceActivity
    public int setType(PresenceActivityType presenceActivityType) {
        return setType(this.mNativePtr, presenceActivityType.toInt());
    }

    @Override // org.linphone.core.PresenceActivity
    public String getDescription() {
        return getDescription(this.mNativePtr);
    }

    @Override // org.linphone.core.PresenceActivity
    public int setDescription(String str) {
        return setDescription(this.mNativePtr, str);
    }

    @Override // org.linphone.core.PresenceActivity
    public long getNativePtr() {
        return this.mNativePtr;
    }
}
