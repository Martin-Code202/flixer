package org.chromium.net.impl;

import java.util.concurrent.Executor;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UploadDataProvider;
public abstract class UrlRequestBase extends ExperimentalUrlRequest {
    static final /* synthetic */ boolean $assertionsDisabled = (!UrlRequestBase.class.desiredAssertionStatus());

    /* access modifiers changed from: protected */
    public abstract void addHeader(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void setHttpMethod(String str);

    /* access modifiers changed from: protected */
    public abstract void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);

    public static int convertLoadState(int i) {
        if ($assertionsDisabled || (i >= 0 && i <= 16)) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                case 6:
                default:
                    throw new IllegalArgumentException("No request status found.");
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                    return 4;
                case 7:
                    return 5;
                case 8:
                    return 6;
                case 9:
                    return 7;
                case 10:
                    return 8;
                case 11:
                    return 9;
                case 12:
                    return 10;
                case 13:
                    return 11;
                case 14:
                    return 12;
                case 15:
                    return 13;
                case 16:
                    return 14;
            }
        } else {
            throw new AssertionError();
        }
    }
}
