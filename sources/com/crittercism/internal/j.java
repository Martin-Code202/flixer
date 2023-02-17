package com.crittercism.internal;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
public final class j extends SSLContextSpi {
    private static Method[] a = new Method[7];
    private static boolean b;
    private SSLContextSpi c;
    private d d;
    private c e;

    static {
        b = false;
        try {
            a[0] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", new Class[0]);
            a[1] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", String.class, Integer.TYPE);
            a[2] = SSLContextSpi.class.getDeclaredMethod("engineGetClientSessionContext", new Class[0]);
            a[3] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSessionContext", new Class[0]);
            a[4] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSocketFactory", new Class[0]);
            a[5] = SSLContextSpi.class.getDeclaredMethod("engineGetSocketFactory", new Class[0]);
            a[6] = SSLContextSpi.class.getDeclaredMethod("engineInit", KeyManager[].class, TrustManager[].class, SecureRandom.class);
            Method[] methodArr = a;
            for (Method method : methodArr) {
                if (method != null) {
                    method.setAccessible(true);
                }
            }
            j jVar = new j(new j(), null, null);
            jVar.engineCreateSSLEngine();
            jVar.engineCreateSSLEngine(null, 0);
            jVar.engineGetClientSessionContext();
            jVar.engineGetServerSessionContext();
            jVar.engineGetServerSocketFactory();
            jVar.engineGetSocketFactory();
            jVar.engineInit(null, null, null);
            b = true;
        } catch (Throwable th) {
            cf.a(th);
            b = false;
        }
    }

    private j(SSLContextSpi sSLContextSpi, d dVar, c cVar) {
        this.c = sSLContextSpi;
        this.d = dVar;
        this.e = cVar;
    }

    public static j a(SSLContextSpi sSLContextSpi, d dVar, c cVar) {
        if (!b) {
            return null;
        }
        return new j(sSLContextSpi, dVar, cVar);
    }

    private j() {
    }

    public static boolean a() {
        return b;
    }

    private <T> T a(int i, Object... objArr) {
        if (this.c == null) {
            return null;
        }
        try {
            return (T) a[i].invoke(this.c, objArr);
        } catch (IllegalArgumentException e2) {
            throw new bg(e2);
        } catch (IllegalAccessException e3) {
            throw new bg(e3);
        } catch (InvocationTargetException e4) {
            Throwable targetException = e4.getTargetException();
            if (targetException == null) {
                throw new bg(e4);
            } else if (targetException instanceof Exception) {
                throw ((Exception) targetException);
            } else if (targetException instanceof Error) {
                throw ((Error) targetException);
            } else {
                throw new bg(e4);
            }
        } catch (ClassCastException e5) {
            throw new bg(e5);
        }
    }

    private <T> T b(int i, Object... objArr) {
        try {
            return (T) a(i, objArr);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new bg(e3);
        }
    }

    private <T> T a(Object... objArr) {
        try {
            return (T) a(6, objArr);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (KeyManagementException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new bg(e4);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final SSLEngine engineCreateSSLEngine() {
        return (SSLEngine) b(0, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final SSLEngine engineCreateSSLEngine(String str, int i) {
        return (SSLEngine) b(1, str, Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final SSLSessionContext engineGetClientSessionContext() {
        return (SSLSessionContext) b(2, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final SSLSessionContext engineGetServerSessionContext() {
        return (SSLSessionContext) b(3, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final SSLServerSocketFactory engineGetServerSocketFactory() {
        return (SSLServerSocketFactory) b(4, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final SSLSocketFactory engineGetSocketFactory() {
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) b(5, new Object[0]);
        if (sSLSocketFactory == null) {
            return sSLSocketFactory;
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                return new m(sSLSocketFactory, this.d, this.e);
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return new l(sSLSocketFactory, this.d, this.e);
            }
            return sSLSocketFactory;
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            cf.b(th);
            return sSLSocketFactory;
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.net.ssl.SSLContextSpi
    public final void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        a(keyManagerArr, trustManagerArr, secureRandom);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        return this.c.equals(obj);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.c.toString();
    }
}
