package com.crittercism.internal;

import com.android.org.conscrypt.OpenSSLSocketImpl;
import com.android.org.conscrypt.SSLParametersImpl;
import com.crittercism.internal.f;
import java.net.InetAddress;
public final class o extends OpenSSLSocketImpl {
    private r a;

    protected o(d dVar, c cVar, SSLParametersImpl sSLParametersImpl) {
        super(sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected o(d dVar, c cVar, String str, int i, SSLParametersImpl sSLParametersImpl) {
        super(str, i, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected o(d dVar, c cVar, InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected o(d dVar, c cVar, String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) {
        super(str, i, inetAddress, i2, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected o(d dVar, c cVar, InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }
}
