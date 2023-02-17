package org.chromium.base.library_loader;

import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.library_loader.Linker;
class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = (!LegacyLinker.class.desiredAssertionStatus());
    private long mBaseLoadAddress = -1;
    private long mCurrentLoadAddress = -1;
    private boolean mInBrowserProcess = true;

    private static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibraryInZipFile(String str, String str2, long j, Linker.LibInfo libInfo);

    /* access modifiers changed from: private */
    public static native void nativeRunCallbackOnUiThread(long j);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    private LegacyLinker() {
    }

    @CalledByNative
    public static void postCallbackOnMainThread(final long j) {
        ThreadUtils.postOnUiThread(new Runnable() { // from class: org.chromium.base.library_loader.LegacyLinker.1
            @Override // java.lang.Runnable
            public void run() {
                LegacyLinker.nativeRunCallbackOnUiThread(j);
            }
        });
    }
}
