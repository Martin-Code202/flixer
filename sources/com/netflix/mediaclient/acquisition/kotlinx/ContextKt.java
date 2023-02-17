package com.netflix.mediaclient.acquisition.kotlinx;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import o.C1457Fr;
public final class ContextKt {
    public static final String getStringResource(Context context, String str) {
        C1457Fr.m5025(context, "$receiver");
        C1457Fr.m5025(str, "keyString");
        Integer stringId = getStringId(context, str);
        if (stringId == null) {
            return null;
        }
        try {
            return context.getString(stringId.intValue());
        } catch (Resources.NotFoundException e) {
            Log.e("AUI", "Couldn't find string resource with key " + str);
            return null;
        }
    }

    public static final Integer getStringId(Context context, String str) {
        C1457Fr.m5025(context, "$receiver");
        C1457Fr.m5025(str, "keyString");
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        return Integer.valueOf(identifier);
    }
}
