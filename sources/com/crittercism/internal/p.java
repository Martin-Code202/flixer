package com.crittercism.internal;

import com.crittercism.internal.f;
import java.net.Socket;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImplWrapper;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;
public final class p extends OpenSSLSocketImplWrapper {
    private r a;

    protected p(d dVar, c cVar, Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) {
        super(socket, str, i, z, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }
}
