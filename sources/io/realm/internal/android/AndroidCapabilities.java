package io.realm.internal.android;

import android.os.Looper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.realm.internal.Capabilities;
public class AndroidCapabilities implements Capabilities {
    @SuppressFBWarnings({"MS_SHOULD_BE_FINAL"})
    public static boolean EMULATE_MAIN_THREAD = false;
    private final boolean isIntentServiceThread = isIntentServiceThread();
    private final Looper looper = Looper.myLooper();

    @Override // io.realm.internal.Capabilities
    public boolean canDeliverNotification() {
        return hasLooper() && !this.isIntentServiceThread;
    }

    @Override // io.realm.internal.Capabilities
    public void checkCanDeliverNotification(String str) {
        if (!hasLooper()) {
            throw new IllegalStateException(str == null ? "" : str + " Realm cannot be automatically updated on a thread without a looper.");
        } else if (this.isIntentServiceThread) {
            throw new IllegalStateException(str == null ? "" : str + " Realm cannot be automatically updated on an IntentService thread.");
        }
    }

    private boolean hasLooper() {
        return this.looper != null;
    }

    private static boolean isIntentServiceThread() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("IntentService[");
    }
}
