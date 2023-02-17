package org.linphone.core;

import org.linphone.core.LinphonePlayer;
public class LinphonePlayerImpl implements LinphonePlayer {
    private long nativePtr = 0;

    private native void close(long j);

    private native void destroy(long j);

    private native int getCurrentPosition(long j);

    private native int getDuration(long j);

    private native int getState(long j);

    private native void init(long j);

    private native int open(long j, String str);

    private native int pause(long j);

    private native int seek(long j, int i);

    private native int start(long j);

    LinphonePlayerImpl(long j) {
        this.nativePtr = j;
        init(j);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized int open(String str) {
        return open(this.nativePtr, str);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized int start() {
        return start(this.nativePtr);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized int pause() {
        return pause(this.nativePtr);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized int seek(int i) {
        return seek(this.nativePtr, i);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized LinphonePlayer.State getState() {
        return LinphonePlayer.State.fromValue(getState(this.nativePtr));
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized int getDuration() {
        return getDuration(this.nativePtr);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized int getCurrentPosition() {
        return getCurrentPosition(this.nativePtr);
    }

    @Override // org.linphone.core.LinphonePlayer
    public synchronized void close() {
        close(this.nativePtr);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        destroy(this.nativePtr);
    }
}
