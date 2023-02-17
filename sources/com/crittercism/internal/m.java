package com.crittercism.internal;

import com.android.org.conscrypt.SSLParametersImpl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
public final class m extends k {
    private static boolean a = false;
    private static SSLSocketFactory b;
    private SSLParametersImpl c;
    private d d;
    private SSLSocketFactory delegate;
    private c e;

    public static boolean a(d dVar, c cVar) {
        if (a) {
            return a;
        }
        SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        try {
            m mVar = new m(defaultSSLSocketFactory, dVar, cVar);
            try {
                mVar.createSocket(mVar.createSocket(), "localhost", 6895, true);
            } catch (SocketException unused) {
            }
            HttpsURLConnection.setDefaultSSLSocketFactory(mVar);
            b = defaultSSLSocketFactory;
            a = true;
            return true;
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            cf.a("Unable to instrument https connections.", th);
            return false;
        }
    }

    public m(SSLSocketFactory sSLSocketFactory, d dVar, c cVar) {
        this.delegate = sSLSocketFactory;
        this.d = dVar;
        this.e = cVar;
        this.c = a(sSLSocketFactory);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.net.Socket, com.crittercism.internal.q] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket createSocket(java.net.Socket r10, java.lang.String r11, int r12, boolean r13) {
        /*
            r9 = this;
            com.android.org.conscrypt.SSLParametersImpl r0 = r9.c
            com.android.org.conscrypt.SSLParametersImpl r8 = a(r0)
            com.crittercism.internal.q r0 = new com.crittercism.internal.q
            com.crittercism.internal.d r1 = r9.d
            com.crittercism.internal.c r2 = r9.e
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.m.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.Socket, com.crittercism.internal.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // javax.net.SocketFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket createSocket(java.lang.String r7, int r8) {
        /*
            r6 = this;
            com.crittercism.internal.o r0 = new com.crittercism.internal.o
            com.crittercism.internal.d r1 = r6.d
            com.crittercism.internal.c r2 = r6.e
            com.android.org.conscrypt.SSLParametersImpl r3 = r6.c
            com.android.org.conscrypt.SSLParametersImpl r5 = a(r3)
            r3 = r7
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.m.createSocket(java.lang.String, int):java.net.Socket");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.Socket, com.crittercism.internal.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // javax.net.SocketFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket createSocket(java.lang.String r9, int r10, java.net.InetAddress r11, int r12) {
        /*
            r8 = this;
            com.crittercism.internal.o r0 = new com.crittercism.internal.o
            com.crittercism.internal.d r1 = r8.d
            com.crittercism.internal.c r2 = r8.e
            com.android.org.conscrypt.SSLParametersImpl r3 = r8.c
            com.android.org.conscrypt.SSLParametersImpl r7 = a(r3)
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.m.createSocket(java.lang.String, int, java.net.InetAddress, int):java.net.Socket");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.Socket, com.crittercism.internal.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // javax.net.SocketFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket createSocket(java.net.InetAddress r7, int r8) {
        /*
            r6 = this;
            com.crittercism.internal.o r0 = new com.crittercism.internal.o
            com.crittercism.internal.d r1 = r6.d
            com.crittercism.internal.c r2 = r6.e
            com.android.org.conscrypt.SSLParametersImpl r3 = r6.c
            com.android.org.conscrypt.SSLParametersImpl r5 = a(r3)
            r3 = r7
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.m.createSocket(java.net.InetAddress, int):java.net.Socket");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.Socket, com.crittercism.internal.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // javax.net.SocketFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket createSocket(java.net.InetAddress r9, int r10, java.net.InetAddress r11, int r12) {
        /*
            r8 = this;
            com.crittercism.internal.o r0 = new com.crittercism.internal.o
            com.crittercism.internal.d r1 = r8.d
            com.crittercism.internal.c r2 = r8.e
            com.android.org.conscrypt.SSLParametersImpl r3 = r8.c
            com.android.org.conscrypt.SSLParametersImpl r7 = a(r3)
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.m.createSocket(java.net.InetAddress, int, java.net.InetAddress, int):java.net.Socket");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.Socket, com.crittercism.internal.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // javax.net.SocketFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket createSocket() {
        /*
            r4 = this;
            com.crittercism.internal.o r0 = new com.crittercism.internal.o
            com.crittercism.internal.d r1 = r4.d
            com.crittercism.internal.c r2 = r4.e
            com.android.org.conscrypt.SSLParametersImpl r3 = r4.c
            com.android.org.conscrypt.SSLParametersImpl r3 = a(r3)
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crittercism.internal.m.createSocket():java.net.Socket");
    }

    private static SSLParametersImpl a(SSLSocketFactory sSLSocketFactory) {
        SSLParametersImpl sSLParametersImpl = null;
        try {
            sSLParametersImpl = (SSLParametersImpl) e.a(e.a(sSLSocketFactory.getClass(), SSLParametersImpl.class, false), sSLSocketFactory);
        } catch (bh e2) {
            cf.b(e2);
        }
        return a(sSLParametersImpl);
    }

    private static SSLParametersImpl a(SSLParametersImpl sSLParametersImpl) {
        try {
            return b(sSLParametersImpl);
        } catch (bh unused) {
            return null;
        }
    }

    private static SSLParametersImpl b(SSLParametersImpl sSLParametersImpl) {
        try {
            Method declaredMethod = SSLParametersImpl.class.getDeclaredMethod("clone", new Class[0]);
            declaredMethod.setAccessible(true);
            return (SSLParametersImpl) declaredMethod.invoke(sSLParametersImpl, new Object[0]);
        } catch (NoSuchMethodException e2) {
            throw new bh(e2);
        } catch (IllegalArgumentException e3) {
            throw new bh(e3);
        } catch (IllegalAccessException e4) {
            throw new bh(e4);
        } catch (InvocationTargetException e5) {
            throw new bh(e5);
        }
    }

    @Override // com.crittercism.internal.k
    public final SSLSocketFactory a() {
        return this.delegate;
    }
}
