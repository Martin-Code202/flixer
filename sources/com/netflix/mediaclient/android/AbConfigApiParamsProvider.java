package com.netflix.mediaclient.android;

import android.content.Context;
import com.netflix.mediaclient.R;
import o.AD;
import o.AbstractC1234;
import o.AbstractC1329Bb;
import o.C0690;
import o.C0717;
import o.uH;
public enum AbConfigApiParamsProvider implements AbstractC1234 {
    INSTANCE;
    

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f807 = 0;

    @Override // o.AbstractC1234
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo276(Context context, AbstractC1329Bb<String, String> bb) {
        if (!C0690.m14976()) {
            float r2 = C0690.m14975();
            bb.put("bavWidth", Integer.toString((int) (((float) m274(context)) * r2)));
            bb.put("savWidth", Integer.toString((int) (((float) m275(context)) * r2)));
        }
        if (C0717.m15045()) {
            bb.put("useLowb", "true");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m274(Context context) {
        if (f807 == 0) {
            int r2 = AD.m3319(context);
            int r3 = uH.m11416(1, AD.m3290(context));
            f807 = ((r2 - ((context.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding) * 2) * r3)) - (uH.m11415() * 2)) / r3;
        }
        return f807;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m275(Context context) {
        return AD.m3319(context);
    }
}
