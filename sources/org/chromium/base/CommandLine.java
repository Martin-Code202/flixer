package org.chromium.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled = (!CommandLine.class.desiredAssertionStatus());
    private static final AtomicReference<CommandLine> sCommandLine = new AtomicReference<>();
    private static final List<Object> sResetListeners = new ArrayList();

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeReset();

    public abstract String getSwitchValue(String str);

    public abstract boolean hasSwitch(String str);

    public static boolean isInitialized() {
        return sCommandLine.get() != null;
    }

    public static CommandLine getInstance() {
        CommandLine commandLine = sCommandLine.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    private CommandLine() {
    }
}
