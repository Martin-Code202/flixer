package com.netflix.mediaclient.acquisition.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.TypeCastException;
import o.C1457Fr;
public final class ClipboardUtilities {
    public static final ClipboardUtilities INSTANCE = new ClipboardUtilities();

    private ClipboardUtilities() {
    }

    public final void copyText(Context context, String str) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(str, "text");
        Object systemService = context.getSystemService("clipboard");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("", str));
    }
}
