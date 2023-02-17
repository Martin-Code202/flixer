package org.chromium.net.impl;

import org.chromium.net.NetworkException;
public class NetworkExceptionImpl extends NetworkException {
    private final int mCronetInternalErrorCode;
    private final int mErrorCode;

    public NetworkExceptionImpl(String str, int i, int i2) {
        super(str, null);
        this.mErrorCode = i;
        this.mCronetInternalErrorCode = i2;
    }

    @Override // org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    public boolean immediatelyRetryable() {
        switch (this.mErrorCode) {
            case 1:
            case 2:
            case 7:
            case 9:
            case 10:
            case 11:
            default:
                return false;
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        sb.append(", ErrorCode=").append(this.mErrorCode);
        if (this.mCronetInternalErrorCode != 0) {
            sb.append(", InternalErrorCode=").append(this.mCronetInternalErrorCode);
        }
        sb.append(", Retryable=").append(immediatelyRetryable());
        return sb.toString();
    }
}
