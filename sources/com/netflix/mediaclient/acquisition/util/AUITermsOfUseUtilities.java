package com.netflix.mediaclient.acquisition.util;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import kotlin.TypeCastException;
import o.C1457Fr;
public final class AUITermsOfUseUtilities {
    public static final AUITermsOfUseUtilities INSTANCE = new AUITermsOfUseUtilities();

    private AUITermsOfUseUtilities() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final String getTouMessage(Context context, String str) {
        String str2;
        int i;
        if (context == null) {
            return "";
        }
        if (str == null) {
            str2 = null;
        } else if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else {
            str2 = str.toLowerCase();
            C1457Fr.m5016((Object) str2, "(this as java.lang.String).toLowerCase()");
        }
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 3248:
                    if (str2.equals(SignupConstants.Field.REGION_EU)) {
                        i = R.string.res_2131887688_tou_eu_inapp;
                        break;
                    }
                    break;
                case 3276:
                    if (str2.equals(SignupConstants.Field.REGION_FR)) {
                        i = R.string.res_2131887689_tou_fr_inapp;
                        break;
                    }
                    break;
                case 3742:
                    if (str2.equals(SignupConstants.Field.REGION_US)) {
                        i = R.string.res_2131887691_tou_us_inapp;
                        break;
                    }
                    break;
            }
            String string = context.getString(i);
            C1457Fr.m5016((Object) string, "context.getString(resId)");
            return string;
        }
        i = R.string.res_2131887690_tou_rest_checkbox_inapp;
        String string = context.getString(i);
        C1457Fr.m5016((Object) string, "context.getString(resId)");
        return string;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isTouCheckboxVisible(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0017
            r3 = r5
            if (r3 != 0) goto L_0x000d
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L_0x000d:
            java.lang.String r2 = r3.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            o.C1457Fr.m5016(r2, r0)
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            if (r2 != 0) goto L_0x001b
            goto L_0x003f
        L_0x001b:
            int r0 = r2.hashCode()
            switch(r0) {
                case 3248: goto L_0x0023;
                case 3276: goto L_0x002c;
                case 3742: goto L_0x0035;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x003f
        L_0x0023:
            java.lang.String r0 = "eu"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x003f
            goto L_0x003d
        L_0x002c:
            java.lang.String r0 = "fr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x003f
            goto L_0x003d
        L_0x0035:
            java.lang.String r0 = "us"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x003f
        L_0x003d:
            r0 = 0
            goto L_0x0040
        L_0x003f:
            r0 = 1
        L_0x0040:
            return r0
            switch-data {3248->0x0023, 3276->0x002c, 3742->0x0035, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netflix.mediaclient.acquisition.util.AUITermsOfUseUtilities.isTouCheckboxVisible(java.lang.String):boolean");
    }
}
