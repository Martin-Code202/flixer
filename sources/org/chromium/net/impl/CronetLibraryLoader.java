package org.chromium.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.net.NetworkChangeNotifier;
public class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = (!CronetLibraryLoader.class.desiredAssertionStatus());
    private static final String LIBRARY_NAME = ("cronet." + ImplVersion.getCronetVersion());
    private static final String TAG = CronetLibraryLoader.class.getSimpleName();
    private static final HandlerThread sInitThread = new HandlerThread("CronetInit");
    private static volatile boolean sInitThreadInitDone = false;
    private static volatile boolean sLibraryLoaded = false;
    private static final Object sLoadLock = new Object();
    private static final ConditionVariable sWaitForLibLoad = new ConditionVariable();

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    public static void ensureInitialized(Context context, CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        synchronized (sLoadLock) {
            if (!sInitThreadInitDone) {
                ContextUtils.initApplicationContext(context);
                if (!sInitThread.isAlive()) {
                    sInitThread.start();
                }
                postToInitThread(new Runnable() { // from class: org.chromium.net.impl.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.ensureInitializedOnInitThread();
                    }
                });
            }
            if (!sLibraryLoaded) {
                if (cronetEngineBuilderImpl.libraryLoader() != null) {
                    cronetEngineBuilderImpl.libraryLoader().loadLibrary(LIBRARY_NAME);
                } else {
                    System.loadLibrary(LIBRARY_NAME);
                }
                String cronetVersion = ImplVersion.getCronetVersion();
                if (!cronetVersion.equals(nativeGetCronetVersion())) {
                    throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", cronetVersion, nativeGetCronetVersion()));
                }
                Log.i(TAG, "Cronet version: %s, arch: %s", cronetVersion, System.getProperty("os.arch"));
                sLibraryLoaded = true;
                sWaitForLibLoad.open();
            }
        }
    }

    private static boolean onInitThread() {
        return sInitThread.getLooper() == Looper.myLooper();
    }

    static void ensureInitializedOnInitThread() {
        if (!$assertionsDisabled && !onInitThread()) {
            throw new AssertionError();
        } else if (!sInitThreadInitDone) {
            NetworkChangeNotifier.init();
            NetworkChangeNotifier.registerToReceiveNotificationsAlways();
            sWaitForLibLoad.block();
            if ($assertionsDisabled || sLibraryLoaded) {
                nativeCronetInitOnInitThread();
                sInitThreadInitDone = true;
                return;
            }
            throw new AssertionError();
        }
    }

    public static void postToInitThread(Runnable runnable) {
        if (onInitThread()) {
            runnable.run();
        } else {
            new Handler(sInitThread.getLooper()).post(runnable);
        }
    }
}
