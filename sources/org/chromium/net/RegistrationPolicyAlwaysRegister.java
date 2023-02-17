package org.chromium.net;

import org.chromium.net.NetworkChangeNotifierAutoDetect;
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    /* access modifiers changed from: protected */
    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.init(networkChangeNotifierAutoDetect);
        register();
    }

    /* access modifiers changed from: protected */
    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
    }
}
