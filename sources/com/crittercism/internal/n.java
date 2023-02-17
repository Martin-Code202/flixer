package com.crittercism.internal;

import com.crittercism.internal.f;
import java.net.InetAddress;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;
public final class n extends OpenSSLSocketImpl {
    private r a;

    protected n(d dVar, c cVar, SSLParametersImpl sSLParametersImpl) {
        super(sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected n(d dVar, c cVar, String str, int i, SSLParametersImpl sSLParametersImpl) {
        super(str, i, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected n(d dVar, c cVar, InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected n(d dVar, c cVar, String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) {
        super(str, i, inetAddress, i2, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }

    protected n(d dVar, c cVar, InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
        this.a = new r(f.a.HTTPS, dVar, cVar);
    }
}
