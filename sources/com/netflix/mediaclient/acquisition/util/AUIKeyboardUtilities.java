package com.netflix.mediaclient.acquisition.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.TypeCastException;
import o.C1457Fr;
public final class AUIKeyboardUtilities {
    public static final AUIKeyboardUtilities INSTANCE = new AUIKeyboardUtilities();

    private AUIKeyboardUtilities() {
    }

    public final void dismissKeyboard(Activity activity) {
        C1457Fr.m5025(activity, "activity");
        Object systemService = activity.getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = activity.getCurrentFocus();
        inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
    }
}
