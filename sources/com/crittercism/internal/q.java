package com.crittercism.internal;

import com.android.org.conscrypt.OpenSSLSocketImplWrapper;
import com.android.org.conscrypt.SSLParametersImpl;
import com.crittercism.internal.f;
import java.net.Socket;
public final class q extends OpenSSLSocketImplWrapper {
    private r a;

    protected q(d dVar, c cVar, Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) {
        super(socket, str, i, z, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }
}
