package org.chromium.base.process_launcher;
public class ChildProcessServiceImpl {
    static final /* synthetic */ boolean $assertionsDisabled = (!ChildProcessServiceImpl.class.desiredAssertionStatus());

    private static native void nativeExitChildProcess();

    private static native void nativeRegisterFileDescriptors(String[] strArr, int[] iArr, int[] iArr2, long[] jArr, long[] jArr2);
}
