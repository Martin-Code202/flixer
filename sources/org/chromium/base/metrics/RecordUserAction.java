package org.chromium.base.metrics;

import org.chromium.base.annotations.CalledByNative;
public class RecordUserAction {
    static final /* synthetic */ boolean $assertionsDisabled = (!RecordUserAction.class.desiredAssertionStatus());

    public interface UserActionCallback {
        @CalledByNative
        void onActionRecorded(String str);
    }

    private static native long nativeAddActionCallbackForTesting(UserActionCallback userActionCallback);

    private static native void nativeRecordUserAction(String str);

    private static native void nativeRemoveActionCallbackForTesting(long j);
}
