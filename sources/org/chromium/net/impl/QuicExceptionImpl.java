package org.chromium.net.impl;

import org.chromium.net.QuicException;
public class QuicExceptionImpl extends QuicException {
    private final NetworkExceptionImpl mNetworkException;
    private final int mQuicDetailedErrorCode;

    public QuicExceptionImpl(String str, int i, int i2) {
        super(str, null);
        this.mNetworkException = new NetworkExceptionImpl(str, 10, i);
        this.mQuicDetailedErrorCode = i2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(this.mNetworkException.getMessage());
        sb.append(", QuicDetailedErrorCode=").append(this.mQuicDetailedErrorCode);
        return sb.toString();
    }

    @Override // org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mNetworkException.getErrorCode();
    }

    @Override // org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mNetworkException.getCronetInternalErrorCode();
    }
}
