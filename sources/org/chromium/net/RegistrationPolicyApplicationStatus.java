package org.chromium.net;

import org.chromium.base.ApplicationStatus;
import org.chromium.net.NetworkChangeNotifierAutoDetect;
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    private boolean mDestroyed;

    /* access modifiers changed from: protected */
    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.init(networkChangeNotifierAutoDetect);
        ApplicationStatus.registerApplicationStateListener(this);
        onApplicationStateChange(getApplicationState());
    }

    /* access modifiers changed from: protected */
    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
        if (!this.mDestroyed) {
            ApplicationStatus.unregisterApplicationStateListener(this);
            this.mDestroyed = true;
        }
    }

    public void onApplicationStateChange(int i) {
        if (i == 1) {
            register();
        } else if (i == 2) {
            unregister();
        }
    }

    /* access modifiers changed from: package-private */
    public int getApplicationState() {
        return ApplicationStatus.getStateForApplication();
    }
}
