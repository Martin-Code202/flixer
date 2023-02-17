package com.google.android.gms.common.api;
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ApiException(com.google.android.gms.common.api.Status r5) {
        /*
            r4 = this;
            int r2 = r5.getStatusCode()
            java.lang.String r0 = r5.getStatusMessage()
            if (r0 == 0) goto L_0x000f
            java.lang.String r3 = r5.getStatusMessage()
            goto L_0x0011
        L_0x000f:
            java.lang.String r3 = ""
        L_0x0011:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r0 = r0.length()
            int r1 = r0 + 13
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = ": "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            r4.mStatus = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.ApiException.<init>(com.google.android.gms.common.api.Status):void");
    }
}
