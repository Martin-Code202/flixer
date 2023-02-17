package org.chromium.base.library_loader;

import org.chromium.base.library_loader.Linker;
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = (!ModernLinker.class.desiredAssertionStatus());
    private long mBaseLoadAddress = -1;
    private long mCurrentLoadAddress = -1;
    private boolean mInBrowserProcess = true;

    private static native boolean nativeCreateSharedRelro(String str, long j, String str2, Linker.LibInfo libInfo);

    private static native String nativeGetCpuAbi();

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    private ModernLinker() {
    }
}
