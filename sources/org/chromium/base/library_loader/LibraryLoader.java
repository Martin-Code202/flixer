package org.chromium.base.library_loader;

import org.chromium.base.annotations.CalledByNative;
public class LibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = (!LibraryLoader.class.desiredAssertionStatus());
    private static volatile LibraryLoader sInstance;
    private static final Object sLock = new Object();
    private final int mLibraryProcessType;

    private static native boolean nativeForkAndPrefetchNativeLibrary();

    private native String nativeGetVersionNumber();

    private native void nativeInitCommandLine(String[] strArr);

    private native boolean nativeLibraryLoaded();

    private static native int nativePercentageOfResidentNativeLibraryCode();

    private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(boolean z, boolean z2, int i, long j);

    private native void nativeRecordLibraryPreloaderBrowserHistogram(int i);

    private native void nativeRegisterChromiumAndroidLinkerRendererHistogram(boolean z, boolean z2, long j);

    private native void nativeRegisterLibraryPreloaderRendererHistogram(int i);

    @CalledByNative
    public static int getLibraryProcessType() {
        if (sInstance == null) {
            return 0;
        }
        return sInstance.mLibraryProcessType;
    }
}
