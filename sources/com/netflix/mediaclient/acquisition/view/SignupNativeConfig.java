package com.netflix.mediaclient.acquisition.view;
public final class SignupNativeConfig {
    public static final SignupNativeConfig INSTANCE = new SignupNativeConfig();
    private static boolean debounceEnabled = true;

    private SignupNativeConfig() {
    }

    public final boolean getDebounceEnabled() {
        return debounceEnabled;
    }

    public final void setDebounceEnabled(boolean z) {
        debounceEnabled = z;
    }
}
