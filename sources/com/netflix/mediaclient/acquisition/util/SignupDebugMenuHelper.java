package com.netflix.mediaclient.acquisition.util;

import android.content.Context;
import android.view.Menu;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import o.C1457Fr;
public final class SignupDebugMenuHelper {
    public static final SignupDebugMenuHelper INSTANCE = new SignupDebugMenuHelper();

    private SignupDebugMenuHelper() {
    }

    public final void addDebugPaneItem(Context context, Menu menu) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(menu, "debugMenu");
    }

    public final void addJumpWithMockMenu(SignupNativeActivity signupNativeActivity, Menu menu) {
        C1457Fr.m5025(signupNativeActivity, "activity");
        C1457Fr.m5025(menu, "debugMenu");
    }
}
